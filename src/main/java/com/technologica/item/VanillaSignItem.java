package com.technologica.item;

import javax.annotation.Nullable;

import com.technologica.network.play.server.SOpenModSignMenuPacket;
import com.technologica.network.play.server.Packets;
import com.technologica.tileentity.VanillaSignTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SignItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class VanillaSignItem extends SignItem {
		
	public VanillaSignItem(Block floorBlockIn, Block wallBlockIn) {
		super(new Item.Properties().tab(TechnologicaItemGroup.CONSTRUCTION), floorBlockIn, wallBlockIn);
	}

	@Override
	protected boolean updateCustomBlockEntityTag(BlockPos pos, World worldIn, @Nullable PlayerEntity playerIn, ItemStack stack, BlockState state) {
		boolean flag = updateCustomBlockEntityTag(worldIn, playerIn, pos, stack);
		
		
		if (!worldIn.isClientSide && !flag && playerIn != null) {
			VanillaSignTileEntity signTile = (VanillaSignTileEntity) worldIn.getBlockEntity(pos);
			
			ServerPlayerEntity player = (ServerPlayerEntity) playerIn;
			signTile.setAllowedPlayerEditor(player);
			
			Packets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SOpenModSignMenuPacket(pos));
		}
		
		return flag;
	}
}