package com.technologica.util.lineshaftsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.MarkerManager;

import com.technologica.world.level.block.LineShaftBlock;
import com.technologica.world.level.block.entity.LineShaftBlockEntity;
import com.technologica.world.level.block.entity.LineShaftHangerBlockEntity;

import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

/**
 * Manager class for the Line Shaft System
 */
public class LineShaftSystemManager {
	private Level level;
	private int lineShaftIndex = 0;
	private float load;
	private Map<BlockEntity, Integer> knownShaftBlockEntities = new HashMap<>();
	private List<LineShaft> lineShafts = new ArrayList<>();
	private List<LineShaftConnection> connections = new ArrayList<LineShaftConnection>();
	private float rpm;
	private int recursions = 0;

	public void onChanged(BlockEntity blockEntity, float rpm) {
		trace("New line shaft system manager prompted by " + blockEntity.getClass().getSimpleName() + " at " + blockEntity.getBlockPos().toString() + "...");
		level = blockEntity.getLevel();
		this.rpm = rpm;
		trace("├─Mapping line shaft system...");
		mapLineShaftSystem(blockEntity);
		trace("│ └─Mapping complete with " + lineShafts.size() + " line shafts and " + connections.size() / 2 + " connections");
		boolean jammed = validateLineShaftSystem();
		spinLineShaftSystem(jammed);
	}

	private void mapLineShaftSystem(BlockEntity blockEntity) {
		LineShaft lineShaft = groupLineShaft(blockEntity);
		scanForConnections(lineShaft);
	}

	private LineShaft groupLineShaft(BlockEntity blockEntity) {
		trace("│ ├─Grouping line shaft " + lineShaftIndex + "...");

		Set<BlockEntity> lineShaftBlocks = new HashSet<>();
		lineShaftBlocks.add(blockEntity);
		knownShaftBlockEntities.put(blockEntity, lineShaftIndex);
		trace("│ │ ├─Added " + blockEntity.getClass().getSimpleName() + " at " + blockEntity.getBlockPos().toString());
		Axis axis = blockEntity.getBlockState().getValue(BlockStateProperties.AXIS);
		lineShaftBlocks.addAll(scanForConnectedShafts(blockEntity, Direction.get(Direction.AxisDirection.POSITIVE, axis)));
		lineShaftBlocks.addAll(scanForConnectedShafts(blockEntity, Direction.get(Direction.AxisDirection.NEGATIVE, axis)));
		LineShaft lineShaft = new LineShaft(lineShaftBlocks, lineShaftIndex);
		lineShafts.add(lineShaft);
		lineShaftIndex++;

		trace("│ │ └─Grouping complete");
		return lineShaft;
	}

	private Set<BlockEntity> scanForConnectedShafts(BlockEntity blockEntity, Direction direction) {
		trace("│ │ ├─Scanning " + direction.toString() + "...");

		Set<BlockEntity> lineShaftBlocks = new HashSet<>();
		int offset = 1;
		BlockEntity scannedBlockEntity = level.getBlockEntity(blockEntity.getBlockPos().relative(direction, offset));
		while ((scannedBlockEntity instanceof LineShaftBlockEntity || scannedBlockEntity instanceof LineShaftHangerBlockEntity) && axisMatches(blockEntity, scannedBlockEntity)) {
			lineShaftBlocks.add(scannedBlockEntity);
			knownShaftBlockEntities.put(scannedBlockEntity, lineShaftIndex);
			trace("│ │ │ ├─Added " + scannedBlockEntity.getClass().getSimpleName() + " at " + scannedBlockEntity.getBlockPos().toString());
			offset++;
			scannedBlockEntity = level.getBlockEntity(blockEntity.getBlockPos().relative(direction, offset));
		}

		trace("│ │ │ └─Scan complete");
		return lineShaftBlocks;
	}

	private void scanForConnections(LineShaft fromLineShaft) {
		trace("│ ├─Scanning line shaft " + fromLineShaft.getIndex() + " for connections...");

		for (BlockEntity shaftBlock : fromLineShaft.getShaftBlockEntities()) {
			if (shaftBlock instanceof LineShaftBlockEntity) {
				LineShaftBlockEntity lineShaftBlockEntity = (LineShaftBlockEntity) shaftBlock;
				if (lineShaftBlockEntity.getBeltPos() != null) {
					if (knownShaftBlockEntities.containsKey(level.getBlockEntity(lineShaftBlockEntity.getBeltPos()))) {
						trace("│ │ ├─Detected connection to known line shaft " + knownShaftBlockEntities.get(level.getBlockEntity(lineShaftBlockEntity.getBeltPos())));
						connections.add(new LineShaftConnection(fromLineShaft.getIndex(), knownShaftBlockEntities.get(level.getBlockEntity(lineShaftBlockEntity.getBeltPos())), shaftBlock.getBlockState().getValue(LineShaftBlock.RADIUS).getRadius() / level.getBlockEntity(lineShaftBlockEntity.getBeltPos()).getBlockState().getValue(LineShaftBlock.RADIUS).getRadius()));
					} else {
						trace("│ │ ├─Detected connection to unknown line shaft");
						connections.add(new LineShaftConnection(fromLineShaft.getIndex(), lineShaftIndex, shaftBlock.getBlockState().getValue(LineShaftBlock.RADIUS).getRadius() / level.getBlockEntity(lineShaftBlockEntity.getBeltPos()).getBlockState().getValue(LineShaftBlock.RADIUS).getRadius()));
						recursions++;
						mapLineShaftSystem(level.getBlockEntity(lineShaftBlockEntity.getBeltPos()));
					}
				}
			}
		}

		trace("│ │ └─Scan complete");
		recursions--;
	}

	private boolean validateLineShaftSystem() {
		trace("├─Validating line shaft system...");

		boolean jammed = false;
		int fromShaft = 0;
		int toShaft = 0;
		float ratio = 1.0F;

		trace("│ ├─Targetting " + rpm + " RPM for unvisited line shaft " + toShaft);
		lineShafts.get(fromShaft).setRPM(rpm, false);
		lineShafts.get(fromShaft).setVisited(true);

		while (connections.size() > 0) {
			fromShaft = connections.get(0).getFrom();
			toShaft = connections.get(0).getTo();
			ratio = connections.get(0).getRatio();

			if (lineShafts.get(toShaft).getVisited()) {
				trace("│ ├─Targetting " + lineShafts.get(fromShaft).getRPM() * ratio + " RPM for visited line shaft " + toShaft);
				if (lineShafts.get(toShaft).getRPM() != lineShafts.get(fromShaft).getRPM() * ratio) {
					trace("│ │ └─RPM mismatch, system jammed");
					jammed = true;
					break;
				} else {
					// lineShafts.get(toShaft).setRPM(rpm + ratio, false);
					trace("│ │ └─RPM matched");
				}
			} else {
				trace("│ ├─Targetting " + lineShafts.get(fromShaft).getRPM() * ratio + " RPM for unvisited line shaft " + toShaft);
				lineShafts.get(toShaft).setRPM(lineShafts.get(fromShaft).getRPM() * ratio, false);
				lineShafts.get(toShaft).setVisited(true);
			}
			connections.remove(0);
		}

		trace("│ └─Validation complete");
		return jammed;
	}

	private void spinLineShaftSystem(boolean jammed) {
		trace("└─Spinning line shaft system...");
		for (LineShaft shaft : lineShafts) {

			if (jammed) {
				shaft.setRPM(0.0F, true);
				trace("  ├─Spinning line shaft " + shaft.getIndex() + " at " + shaft.getRPM() + " RPM");
			} else {
				shaft.setRPM(shaft.getRPM(), true);
				trace("  ├─Spinning line shaft " + shaft.getIndex() + " at " + shaft.getRPM() + " RPM");
			}
		}
		trace("  └─Spin complete");
	}

	private boolean axisMatches(BlockEntity currentBlockEntity, BlockEntity scannedBlockEntity) {
		return currentBlockEntity.getBlockState().getValue(BlockStateProperties.AXIS) == scannedBlockEntity.getBlockState().getValue(BlockStateProperties.AXIS);
	}

	private void trace(String message) {
		recursions = recursions < 0 ? 0 : recursions;
		LogManager.getLogger("TECHNOLOGICA").trace(MarkerManager.getMarker("MANAGER"), "│ ".repeat(recursions) + message);
	}
}
