package com.technologica.world.item;

import java.util.function.Consumer;

import com.technologica.client.model.armor.DivingHelmetModel;
import com.technologica.client.model.geom.TechnologicaModelLayers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class DivingHelmetItem extends ArmorItem {

	public DivingHelmetItem(ArmorMaterial armorMaterial, Type type, Properties properties) {
		super(armorMaterial, type, properties);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public HumanoidModel<?> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<?> original) {
				return new DivingHelmetModel<LivingEntity>(Minecraft.getInstance().getEntityModels().bakeLayer(TechnologicaModelLayers.DIVING_HELMET));
			}
		});
	}
}
