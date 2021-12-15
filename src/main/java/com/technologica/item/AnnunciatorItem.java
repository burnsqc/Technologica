package com.technologica.item;

import javax.annotation.Nullable;

import com.technologica.network.play.server.Packets;
import com.technologica.network.play.server.SOpenAnnunciatorMenuPacket;
import com.technologica.tileentity.AnnunciatorTileEntity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.PacketDistributor;

public class AnnunciatorItem extends BlockItem {
		
	public AnnunciatorItem(Block floorBlockIn) {
		super(floorBlockIn, new Item.Properties().group(TechnologicaItemGroup.CONSTRUCTION));
	}

	@Override
	protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity playerIn, ItemStack stack, BlockState state) {
		boolean flag = setTileEntityNBT(worldIn, playerIn, pos, stack);
		
		
		if (!worldIn.isRemote && !flag && playerIn != null) {
			AnnunciatorTileEntity signTile = (AnnunciatorTileEntity) worldIn.getTileEntity(pos);
			
			ServerPlayerEntity player = (ServerPlayerEntity) playerIn;
			signTile.setPlayer(player);
			
			Packets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new SOpenAnnunciatorMenuPacket(pos));
		}
		
		return flag;
	}
}