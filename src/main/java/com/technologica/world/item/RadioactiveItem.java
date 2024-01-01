package com.technologica.world.item;

import java.util.function.Consumer;

import com.technologica.client.renderer.blockentity.RadiationRenderer;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class RadioactiveItem extends Item {
	private ResourceLocation BASE_MODEL_LOCATION;

	public RadioactiveItem(Item.Properties p_43136_, String name) {
		super(p_43136_);
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
				return new RadiationRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), BASE_MODEL_LOCATION);
			}
		});
	}
}