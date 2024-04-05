package com.technologica.world.item;

import java.util.function.Consumer;

import com.technologica.client.renderer.blockentity.ExcitationRenderer;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class Excitation extends Item {
	private ResourceLocation BASE_MODEL_LOCATION;

	public Excitation(Properties properties, String name) {
		super(properties);
		BASE_MODEL_LOCATION = new TechnologicaLocation("item/" + name + "_base");
	}

	@Override
	public boolean isFoil(ItemStack p_43138_) {
		return true;
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return new ExcitationRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), BASE_MODEL_LOCATION);
			}
		});
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level worldIn, Player playerIn, InteractionHand handIn) {
		Minecraft mc = Minecraft.getInstance();
		HitResult hr = mc.hitResult;
		LightningBolt lightningboltentity = EntityType.LIGHTNING_BOLT.create(worldIn);
		lightningboltentity.moveTo(hr.getLocation());
		worldIn.addFreshEntity(lightningboltentity);
		return InteractionResultHolder.consume(playerIn.getItemInHand(handIn));
	}
}
