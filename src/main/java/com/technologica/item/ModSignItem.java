package com.technologica.item;

import javax.annotation.Nullable;

import com.technologica.network.play.server.ModSOpenSignMenuPacket;
import com.technologica.network.play.server.Packets;
import com.technologica.tileentity.ModSignTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class ModSignItem extends SignItem {
		
	public ModSignItem(Properties propertiesIn, Block floorBlockIn, Block wallBlockIn) {
		super(propertiesIn, floorBlockIn, wallBlockIn);
	}

	@Override
	protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity playerIn, ItemStack stack, BlockState state) {
		boolean flag = setTileEntityNBT(worldIn, playerIn, pos, stack);
		
		
		if (!worldIn.isRemote && !flag && playerIn != null) {
			ModSignTileEntity signTile = (ModSignTileEntity) worldIn.getTileEntity(pos);
			
			ServerPlayerEntity player = (ServerPlayerEntity) playerIn;
			signTile.setPlayer(player);
			
			Packets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new ModSOpenSignMenuPacket(pos));
		}
		
		return flag;
	}
}