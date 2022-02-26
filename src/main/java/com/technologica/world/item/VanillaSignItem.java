package com.technologica.world.item;

import javax.annotation.Nullable;

import com.technologica.network.play.server.Packets;
import com.technologica.network.protocol.game.ClientboundOpenTechnologicaSignEditorPacket;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.network.PacketDistributor;

public class VanillaSignItem extends SignItem {
	public VanillaSignItem(Block floorBlockIn, Block wallBlockIn) {
		super(new Item.Properties().tab(TechnologicaItemGroup.CONSTRUCTION), floorBlockIn, wallBlockIn);
	}

	@Override
	protected boolean updateCustomBlockEntityTag(BlockPos pos, Level worldIn, @Nullable Player playerIn, ItemStack stack, BlockState state) {
		boolean flag = updateCustomBlockEntityTag(worldIn, playerIn, pos, stack);
		
		if (!worldIn.isClientSide && !flag && playerIn != null) {
			ServerPlayer player = (ServerPlayer) playerIn;
			Packets.INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), new ClientboundOpenTechnologicaSignEditorPacket(pos));
		}
		
		return flag;
	}
}