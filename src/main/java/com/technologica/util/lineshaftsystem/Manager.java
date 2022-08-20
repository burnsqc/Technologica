package com.technologica.util.lineshaftsystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

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
	public int shaftIndex = 0;
	public float load;
	public List<BlockEntity> allShaftBlocks;
	public List<LineShaft> allShafts;
	private LinkedList<Integer> adj[];

	public Manager() {
		adj = new LinkedList[1];
		adj[0] = new LinkedList();
		// Check for safe assumptions before spinning up new manager vs merging into existing one
	}

	public void onChanged(BlockEntity be) {
		this.reGroup(be);
		if (this.isValid()) {
			this.setAll();
		} else {
			// idk
		}
	}

	/**
	 * This method scans outward from a single block entity and attempts to group any and all Line Shaft and Line Shaft Hanger Block Entities into a complete Line Shaft System.
	 * 
	 * @param be
	 */
	private void reGroup(BlockEntity be) {
		// Start with a single LineShaftBlockEntity. Incrementally search in both coaxial directions for aligned LineShaftBlocks and build a new LineShaft object.
		Level level = be.getLevel();

		List<BlockEntity> tempAllShaftBlocks = new ArrayList<>();
		tempAllShaftBlocks.add(be);
		if (allShaftBlocks == null) {
			allShaftBlocks = new ArrayList<>();
		}
		allShaftBlocks.add(be);

		Axis axis = be.getBlockState().getValue(BlockStateProperties.AXIS);
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
		BlockEntity shaftCheck = level.getBlockEntity(be.getBlockPos().relative(direction1, offset));

		while ((shaftCheck instanceof LineShaftTileEntity || shaftCheck instanceof LineShaftHangerTileEntity) && shaftCheck.getBlockState().getValue(BlockStateProperties.AXIS) == be.getBlockState().getValue(BlockStateProperties.AXIS)) {
			tempAllShaftBlocks.add(shaftCheck);
			allShaftBlocks.add(shaftCheck);
			offset++;
			shaftCheck = level.getBlockEntity(be.getBlockPos().relative(direction1, offset));
		}

		offset = 1;
		shaftCheck = level.getBlockEntity(be.getBlockPos().relative(direction2, offset));

		while ((shaftCheck instanceof LineShaftTileEntity || shaftCheck instanceof LineShaftHangerTileEntity) && shaftCheck.getBlockState().getValue(BlockStateProperties.AXIS) == be.getBlockState().getValue(BlockStateProperties.AXIS)) {
			tempAllShaftBlocks.add(shaftCheck);
			allShaftBlocks.add(shaftCheck);
			offset++;
			shaftCheck = level.getBlockEntity(be.getBlockPos().relative(direction2, offset));
		}

		LineShaft shaft = new LineShaft(tempAllShaftBlocks, shaftIndex);
		shaftIndex++;

		if (allShafts == null) {
			allShafts = new ArrayList<>();
		}

		allShafts.add(shaft);

		// Now check the above LineShaft object for pulley connections and loop back to top. Be sure to check if they are already a part of the allShafts list.
		for (BlockEntity shaftBlock : shaft.shaftList) {
			if (shaftBlock instanceof LineShaftTileEntity) {
				if (((LineShaftTileEntity) shaftBlock).getBeltPos() != null) {
					if (!allShaftBlocks.contains(level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()))) {
						addEdge(shaft.getIndex(), shaftIndex);
						reGroup(level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()));
					} else {
						for (LineShaft shaft2 : allShafts) {
							if (shaft2.shaftList.contains(level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()))) {
								if (level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()) != level.getBlockEntity(((LineShaftTileEntity) be).getBeltPos())) {
									addEdge(shaft.getIndex(), shaft2.getIndex());
									break;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Treat the system as an undirected graph, since any torque/rpm change can happen anywhere in the system and any pulley connections should have equal possibility to drive or be driven.
	 * 
	 * @return
	 */
	public boolean isValid() {
		// Directed graphs
		// Simple cycles

		// for (LineShaft shaft : allShafts) {
		// for (BlockEntity shaftBlock : shaft.shaftList) {
		// if (shaftBlock instanceof LineShaftTileEntity) {
		// if (((LineShaftTileEntity) shaftBlock).getBeltPos() != null) {
		// if (allShaftBlocks.contains(level.getBlockEntity(((LineShaftTileEntity) shaftBlock).getBeltPos()))) {
		// // cycle
		// }
		// }
		// }
		// }
		// }

		boolean loopRatio1 = true;

		if (!isCyclic()) {
			return true;
		} else {
			if (loopRatio1) {
				return true;
			} else {
				return false;
			}
		}
	}

	public void setAll() {

	}

	/**
	 * In light of the fact that reGroup essentially builds a new system from scratch, do we actually need this?
	 * 
	 * @param manLeft
	 * @param manRight
	 */
	public void merge(Manager manLeft, Manager manRight) {
		Manager managerNew = new Manager();
		managerNew.allShaftBlocks.addAll(manLeft.allShaftBlocks);
		managerNew.allShaftBlocks.addAll(manRight.allShaftBlocks);
		// managerNew.onChanged();
	}

	/**
	 * If we do away with merge in favor of reGroup, something similar might apply here. Severing a pulley connection should trigger a regroup on each of the two previously connected pulleys.
	 * 
	 * @param manIn
	 */
	public void split(Manager manIn) {
		// Directed graphs again
		// Detect two independent systems and pare the allShaftBlocks
	}

	public void addEdge(int v, int w) {
		int max = Math.max(v, w) + 1;
		if (max > adj.length) {
			LinkedList<Integer> temp[] = adj.clone();
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

		adj[v].add(w);
		adj[w].add(v);
	}

	public Boolean isCyclic() {
		int V = allShafts.size();
		Boolean visited[] = new Boolean[V];

		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		for (int u = 0; u < V; u++) {
			if (!visited[u]) {
				if (isCyclicUtil(u, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	public Boolean isCyclicUtil(int v, Boolean visited[], int parent) {
		visited[v] = true;
		Integer i;
		Iterator<Integer> it = adj[v].iterator();

		while (it.hasNext()) {
			i = it.next();

			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v)) {
					return true;
				}
			} else if (i != parent) {
				return true;
			}
		}
		return false;
	}
}