package com.technologica.world.item;

import java.util.function.Consumer;

import com.technologica.client.renderer.blockentity.CustomGlintRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class RadioactiveItem extends Item {
	public RadioactiveItem(Item.Properties p_43136_) {
		super(p_43136_);
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
				return new CustomGlintRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
			}
		});
	}
}