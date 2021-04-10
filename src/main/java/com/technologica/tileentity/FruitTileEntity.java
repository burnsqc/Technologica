package com.technologica.tileentity;

import net.minecraft.block.*;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.TNTBlock;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

import com.technologica.setup.Registration;

import java.util.Arrays;
import java.util.Random;

public class FruitTileEntity extends TileEntity implements ITickableTileEntity {

	public FruitTileEntity() {
		super(Registration.BANANA_CROP.get());
	}

	private final int INVALID_VALUE = -1;
	private int ticksLeftTillDisappear = INVALID_VALUE;

	public void setTicksLeftTillDisappear(int ticks) {
		ticksLeftTillDisappear = ticks;
	}

	@Override
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		CompoundNBT nbtTagCompound = new CompoundNBT();
		write(nbtTagCompound);
		int tileEntityType = 42;
		return new SUpdateTileEntityPacket(this.pos, tileEntityType, nbtTagCompound);
	}

	@Override
	public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
		BlockState blockState = world.getBlockState(pos);
		read(blockState, pkt.getNbtCompound());
	}

	@Override
	public CompoundNBT getUpdateTag() {
		CompoundNBT nbtTagCompound = new CompoundNBT();
		write(nbtTagCompound);
		return nbtTagCompound;
	}

	@Override
	public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound) {
		this.read(blockState, parentNBTTagCompound);
	}

	@Override
	public CompoundNBT write(CompoundNBT parentNBTTagCompound) {
		super.write(parentNBTTagCompound);

		parentNBTTagCompound.putInt("ticksLeft", ticksLeftTillDisappear);

		parentNBTTagCompound.putString("testString", testString);

		CompoundNBT blockPosNBT = new CompoundNBT();
		blockPosNBT.putInt("x", testBlockPos.getX());
		blockPosNBT.putInt("y", testBlockPos.getY());
		blockPosNBT.putInt("z", testBlockPos.getZ());
		parentNBTTagCompound.put("testBlockPos", blockPosNBT);

		CompoundNBT itemStackNBT = new CompoundNBT();
		testItemStack.write(itemStackNBT);
		parentNBTTagCompound.put("testItemStack", itemStackNBT);

		parentNBTTagCompound.putIntArray("testIntArray", testIntArray);

		ListNBT doubleArrayNBT = new ListNBT();
		for (double value : testDoubleArray) {
			doubleArrayNBT.add(DoubleNBT.valueOf(value));
		}
		parentNBTTagCompound.put("testDoubleArray", doubleArrayNBT);

		ListNBT doubleArrayWithNullsNBT = new ListNBT();
		for (int i = 0; i < testDoubleArrayWithNulls.length; ++i) {
			Double value = testDoubleArrayWithNulls[i];
			if (value != null) {
				CompoundNBT dataForThisSlot = new CompoundNBT();
				dataForThisSlot.putInt("i", i + 1);
				dataForThisSlot.putDouble("v", value);
				doubleArrayWithNullsNBT.add(dataForThisSlot);
			}
		}
		parentNBTTagCompound.put("testDoubleArrayWithNulls", doubleArrayWithNullsNBT);
		return parentNBTTagCompound;
	}

	@Override
	public void read(BlockState blockState, CompoundNBT parentNBTTagCompound) {
		super.read(blockState, parentNBTTagCompound);

//		final int NBT_INT_ID = NBTtypesMBE.INT_NBT_ID;
		int readTicks = INVALID_VALUE;
//		if (parentNBTTagCompound.contains("ticksLeft", NBT_INT_ID)) {
			readTicks = parentNBTTagCompound.getInt("ticksLeft");
			if (readTicks < 0)
				readTicks = INVALID_VALUE;
//		}
		ticksLeftTillDisappear = readTicks;

		String readTestString = null;
//		final int NBT_STRING_ID = NBTtypesMBE.STRING_NBT_ID;
//		if (parentNBTTagCompound.contains("testString", NBT_STRING_ID)) {
			readTestString = parentNBTTagCompound.getString("testString");
//		}
		if (!testString.equals(readTestString)) {
			System.err.println("testString mismatch:" + readTestString);
		}

		CompoundNBT blockPosNBT = parentNBTTagCompound.getCompound("testBlockPos");
		BlockPos readBlockPos = null;
//		if (blockPosNBT.contains("x", NBT_INT_ID) && blockPosNBT.contains("y", NBT_INT_ID)
//				&& blockPosNBT.contains("z", NBT_INT_ID)) {
			readBlockPos = new BlockPos(blockPosNBT.getInt("x"), blockPosNBT.getInt("y"), blockPosNBT.getInt("z"));
//		}
		if (readBlockPos == null || !testBlockPos.equals(readBlockPos)) {
			System.err.println("testBlockPos mismatch:" + readBlockPos);
		}

		CompoundNBT itemStackNBT = parentNBTTagCompound.getCompound("testItemStack");
		ItemStack readItemStack = ItemStack.read(itemStackNBT);
		if (!ItemStack.areItemStacksEqual(testItemStack, readItemStack)) {
			System.err.println("testItemStack mismatch:" + readItemStack);
		}

		int[] readIntArray = parentNBTTagCompound.getIntArray("testIntArray");
		if (!Arrays.equals(testIntArray, readIntArray)) {
			System.err.println("testIntArray mismatch:" + readIntArray);
		}

//		final int NBT_DOUBLE_ID = NBTtypesMBE.DOUBLE_NBT_ID;
//		ListNBT doubleArrayNBT = parentNBTTagCompound.getList("testDoubleArray", NBT_DOUBLE_ID);
//		int numberOfEntries = Math.min(doubleArrayNBT.size(), testDoubleArray.length);
//		double[] readDoubleArray = new double[numberOfEntries];
//		for (int i = 0; i < numberOfEntries; ++i) {
//			readDoubleArray[i] = doubleArrayNBT.getDouble(i);
//		}
//		if (doubleArrayNBT.size() != numberOfEntries || !Arrays.equals(readDoubleArray, testDoubleArray)) {
//			System.err.println("testDoubleArray mismatch:" + readDoubleArray);
//		}

//		final int NBT_COMPOUND_ID = NBTtypesMBE.COMPOUND_NBT_ID;
//		ListNBT doubleNullArrayNBT = parentNBTTagCompound.getList("testDoubleArrayWithNulls", NBT_COMPOUND_ID);
//		numberOfEntries = Math.min(doubleArrayNBT.size(), testDoubleArrayWithNulls.length);
//		Double[] readDoubleNullArray = new Double[numberOfEntries];
//		for (int i = 0; i < doubleNullArrayNBT.size(); ++i) {
//			CompoundNBT nbtEntry = doubleNullArrayNBT.getCompound(i);
//			int idx = nbtEntry.getInt("i") - 1;
//			if (nbtEntry.contains("v", NBT_DOUBLE_ID) && idx >= 0 && idx < numberOfEntries) {
//				readDoubleNullArray[idx] = nbtEntry.getDouble("v");
//			}
//		}
//		if (!Arrays.equals(testDoubleArrayWithNulls, readDoubleNullArray)) {
//			System.err.println("testDoubleArrayWithNulls mismatch:" + readDoubleNullArray);
		}
//	}

	@Override
	public void tick() {
		if (!this.hasWorld())
			return;
		World world = this.getWorld();
		if (world.isRemote)
			return;
		ServerWorld serverWorld = (ServerWorld) world;
		if (ticksLeftTillDisappear == INVALID_VALUE)
			return;
		--ticksLeftTillDisappear;
		if (ticksLeftTillDisappear > 0)
			return;
		Block[] blockChoices = { Blocks.DIAMOND_BLOCK, Blocks.OBSIDIAN, Blocks.AIR, Blocks.TNT, Blocks.CORNFLOWER,
				Blocks.OAK_SAPLING, Blocks.WATER };
		Random random = new Random();
		Block chosenBlock = blockChoices[random.nextInt(blockChoices.length)];
		world.setBlockState(this.pos, chosenBlock.getDefaultState());
		if (chosenBlock == Blocks.TNT) {
			Blocks.TNT.catchFire(Blocks.TNT.getDefaultState().with(TNTBlock.UNSTABLE, true), world, pos, null, null);
			world.removeBlock(pos, false);
		} else if (chosenBlock == Blocks.OAK_SAPLING) {
			SaplingBlock blockSapling = (SaplingBlock) Blocks.OAK_SAPLING;
			blockSapling.placeTree(serverWorld, this.pos, blockSapling.getDefaultState(), random);
		}
	}

	private final int[] testIntArray = { 5, 4, 3, 2, 1 };
	private final double[] testDoubleArray = { 1, 2, 3, 4, 5, 6 };
	private final Double[] testDoubleArrayWithNulls = { 61.1, 62.2, null, 64.4, 65.5 };
	private final ItemStack testItemStack = new ItemStack(Items.COOKED_CHICKEN, 23);
	private final String testString = "supermouse";
	private final BlockPos testBlockPos = new BlockPos(10, 11, 12);
}