package com.technologica.world.item;

import java.util.function.Consumer;

import com.technologica.client.model.armor.NightVisionGogglesModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.Model;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class NightVisionGogglesItem extends ArmorItem {

	public NightVisionGogglesItem(ArmorMaterial armorMaterial, Type helmet, Properties properties) {
		super(armorMaterial, helmet, properties);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public Model getGenericArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> original) {
				if (armorSlot == EquipmentSlot.HEAD) {
					NightVisionGogglesModel<LivingEntity> nightVisionGogglesModel = new NightVisionGogglesModel<LivingEntity>(Minecraft.getInstance().getEntityModels().bakeLayer(TechnologicaModelLayers.NIGHT_VISION_GOGGLES));
					ForgeHooksClient.copyModelProperties(original, nightVisionGogglesModel);
					return nightVisionGogglesModel;
				}
				return null;
			}
		});
	}
}
