package com.technologica.world.level.block;

import java.util.Random;

import com.technologica.world.item.TechnologicaItems;
import com.technologica.world.level.block.entity.SawmillTileEntity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Special one-off class for the sawmill.
 * Created to handle player interaction and associated tile entity.
 */
public class SawmillBlock extends FourDirectionBlock implements EntityBlock {

	protected SawmillBlock() {
		super(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.ANVIL).noOcclusion());
	}
	
	/*
	 * Technologica Methods
	 */
	
	public SawmillTileEntity getTileEntity(Level worldIn, BlockPos posIn) {
		return (SawmillTileEntity) worldIn.getBlockEntity(posIn);
	}
	
	/*
	 * Minecraft Methods
	 */
	
	@Override
	public InteractionResult use(BlockState stateIn, Level worldIn, BlockPos posIn, Player playerIn, InteractionHand handIn, BlockHitResult hitIn) {
		SawmillTileEntity tile = getTileEntity(worldIn, posIn);
		ItemStack itemstack = playerIn.getItemInHand(handIn);
		Item item = playerIn.getItemInHand(handIn).getItem();
		
		if (tile.getLog().isEmpty()) {
			if (item == TechnologicaItems.SAWBLADE.get()) {
				tile.setBlade(true);
				worldIn.playSound((Player)null, posIn, SoundEvents.ANVIL_PLACE, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
				itemstack.shrink(1);
			} else if (ForgeRegistries.ITEMS.tags().getTag(ItemTags.LOGS).contains(itemstack.getItem())) {
				tile.setLog(new ItemStack(itemstack.getItem(), 1));
				worldIn.playSound((Player)null, posIn, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 0.25F, 1.0F + worldIn.random.nextFloat() * 0.4F);
				itemstack.shrink(1);
				playerIn.getInventory().setItem(playerIn.getInventory().selected, itemstack);
				playerIn.containerMenu.broadcastChanges();
			}
		}
		return InteractionResult.sidedSuccess(worldIn.isClientSide);
	}
	
	@Override
	public void animateTick(BlockState stateIn, Level worldIn, BlockPos posIn, Random randomIn) {
		if (worldIn.isClientSide && getTileEntity(worldIn, posIn).isSawing()) {
			double d0 = (double) posIn.getX() + randomIn.nextDouble();
	        double d1 = (double) posIn.getY() + 2.0D;
	        double d2 = (double) posIn.getZ() + randomIn.nextDouble();
	        worldIn.addParticle(ParticleTypes.POOF, d0, d1, d2, 0.0D, 0.0D, 0.0D);
	        worldIn.addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, stateIn), d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}
	
	/*
	 * Forge Methods
	 */

	@Override
	public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
		return new SawmillTileEntity(p_153215_, p_153216_);
	}
}