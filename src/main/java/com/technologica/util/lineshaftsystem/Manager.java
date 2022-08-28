package com.technologica.util.lineshaftsystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.mojang.datafixers.util.Pair;
import com.technologica.world.level.block.LineShaftBlock;
import com.technologica.world.level.block.entity.LineShaftHangerTileEntity;
import com.technologica.world.level.block.entity.LineShaftTileEntity;

import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

/**
 * Manager class for the Line Shaft System.
 */
public class Manager {
	private boolean jammed = false;
	public int shaftIndex = 0;
	public float load;
	public List<BlockEntity> allShaftBlockEntities = new ArrayList<>();
	public List<LineShaft> allShafts = new ArrayList<>();
	private LinkedList<Pair<Integer, Float>> adj[];
	private float RPM;

	public Manager() {
		adj = new LinkedList[1];
		adj[0] = new LinkedList();
	}

	public void onChanged(BlockEntity be, float rpmIn) {
		this.RPM = rpmIn;
		this.reGroup(be);
		this.setAll();
	}

	/**
	 * This method scans outward from a single block entity and attempts to group any and all Line Shaft and Line Shaft Hanger Block Entities into a complete Line Shaft System.
	 * 
	 * @param blockEntityIn
	 */
	private void reGroup(BlockEntity blockEntityIn) {
		// Start with a single LineShaftBlockEntity. Incrementally search in both coaxial directions for aligned LineShaftBlocks and build a new LineShaft object.
		Level level = blockEntityIn.getLevel();

		List<BlockEntity> tempAllShaftBlocks = new ArrayList<>();
		tempAllShaftBlocks.add(blockEntityIn);
		allShaftBlockEntities.add(blockEntityIn);

		Axis axis = blockEntityIn.getBlockState().getValue(BlockStateProperties.AXIS);
		Direction direction1 = null;
		Direction direction2 = null;

		switch (axis) {
		case X:
			direction1 = Direction.EAST;
			direction2 = Direction.WEST;
			break;
		case Y:
			direction1 = Direction.UP;
			direction2 = Direction.DOWN;
			break;
		case Z:
			direction1 = Direction.NORTH;
			direction2 = Direction.SOUTH;
			break;
		}

		int offset = 1;
		BlockEntity scannedBlockEntity = level.getBlockEntity(blockEntityIn.getBlockPos().relative(direction1, offset));

		while ((scannedBlockEntity instanceof LineShaftTileEntity || scannedBlockEntity instanceof LineShaftHangerTileEntity) && scannedBlockEntity.getBlockState().getValue(BlockStateProperties.AXIS) == blockEntityIn.getBlockState().getValue(BlockStateProperties.AXIS)) {
			tempAllShaftBlocks.add(scannedBlockEntity);
			allShaftBlockEntities.add(scannedBlockEntity);
			offset++;
			scannedBlockEntity = level.getBlockEntity(blockEntityIn.getBlockPos().relative(direction1, offset));
		}

		offset = 1;
		scannedBlockEntity = level.getBlockEntity(blockEntityIn.getBlockPos().relative(direction2, offset));

		while ((scannedBlockEntity instanceof LineShaftTileEntity || scannedBlockEntity instanceof LineShaftHangerTileEntity) && scannedBlockEntity.getBlockState().getValue(BlockStateProperties.AXIS) == blockEntityIn.getBlockState().getValue(BlockStateProperties.AXIS)) {
			tempAllShaftBlocks.add(scannedBlockEntity);
			allShaftBlockEntities.add(scannedBlockEntity);
			offset++;
			scannedBlockEntity = level.getBlockEntity(blockEntityIn.getBlockPos().relative(direction2, offset));
		}

		LineShaft lineShaft = new LineShaft(tempAllShaftBlocks, shaftIndex);
		shaftIndex++;
		allShafts.add(lineShaft);

		// Now check the above LineShaft object for pulley connections and loop back to top. Be sure to check if they are already a part of the allShafts list.
		for (BlockEntity shaftBlock : lineShaft.shaftList) {
			if (shaftBlock instanceof LineShaftTileEntity) {
				if (((LineShaftTileEntity) shaftBlock).getBeltPos() != null) {
					if (!allShaftBlockEntities.contains(level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()))) {
						addEdge(lineShaft.getIndex(), shaftIndex, shaftBlock.getBlockState().getValue(LineShaftBlock.RADIUS).getRadius() / level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()).getBlockState().getValue(LineShaftBlock.RADIUS).getRadius());
						reGroup(level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()));
					} else {
						for (LineShaft shaft2 : allShafts) {
							if (shaft2.shaftList.contains(level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos())) && blockEntityIn instanceof LineShaftTileEntity) {
								if (level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()) != level.getBlockEntity(((LineShaftTileEntity) blockEntityIn).getBeltPos())) {
									addEdge(lineShaft.getIndex(), shaft2.getIndex(), shaftBlock.getBlockState().getValue(LineShaftBlock.RADIUS).getRadius() / level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()).getBlockState().getValue(LineShaftBlock.RADIUS).getRadius());
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	public void setAll() {
		int numberofShafts = allShafts.size();
		Boolean visited[] = new Boolean[numberofShafts];
		float ratio = 1.0F;
		int count = 0;

		for (int i = 0; i < numberofShafts; i++) {
			visited[i] = false;
		}

		allShafts.get(0).setRPM(RPM);
		visited[0] = true;

		while (adj.length > 0) {
			while (!adj[0].isEmpty()) {
				int shaftIndex = adj[0].get(0).getFirst();
				ratio = adj[0].get(0).getSecond();
				if (!visited[shaftIndex]) {
					allShafts.get(shaftIndex).setRPM(allShafts.get(count).getRPM() * ratio);
					visited[shaftIndex] = true;
				} else {
					if (allShafts.get(shaftIndex).getRPM() != allShafts.get(count).getRPM() * ratio) {
						jammed = true;
					}
				}

				adj[0].remove(0);
			}

			LinkedList<Pair<Integer, Float>> temp[] = adj.clone();
			adj = new LinkedList[adj.length - 1];

			for (int i = 0; i < adj.length; i++) {
				adj[i] = new LinkedList();
			}

			for (int i = 1; i < temp.length; i++) {
				if (temp[i] != null) {
					adj[i - 1] = temp[i];
				}
			}
			count++;
		}

		for (LineShaft shaft : allShafts) {
			if (jammed) {
				shaft.setRPM(0.0F);
			}
			for (BlockEntity shaftBlock : shaft.shaftList) {
				if (shaftBlock instanceof LineShaftTileEntity) {
					((LineShaftTileEntity) shaftBlock).setRPM(shaft.getRPM());
					((LineShaftTileEntity) shaftBlock).setTorque(shaft.getTorque());
				} else if (shaftBlock instanceof LineShaftHangerTileEntity) {
					((LineShaftHangerTileEntity) shaftBlock).setRPM(shaft.getRPM());
					((LineShaftHangerTileEntity) shaftBlock).setTorque(shaft.getTorque());
				}
			}
		}
	}

	public void addEdge(int v, int w, float ratioIn) {
		int max = Math.max(v, w) + 1;
		if (max > adj.length) {
			LinkedList<Pair<Integer, Float>> temp[] = adj.clone();
			adj = new LinkedList[max];

			for (int i = 0; i < max; i++) {
				adj[i] = new LinkedList();
			}

			for (int i = 0; i < temp.length; i++) {
				if (temp[i] != null) {
					adj[i] = temp[i];
				}
			}
		}

		adj[v].add(new Pair<>(w, ratioIn));
		adj[w].add(new Pair<>(v, 1 / ratioIn));
	}
}