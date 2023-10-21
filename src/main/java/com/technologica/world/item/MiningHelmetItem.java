package com.technologica.world.item;

import java.util.function.Consumer;

import com.technologica.client.model.armor.MiningHelmetModel;
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

public class MiningHelmetItem extends ArmorItem {

	public MiningHelmetItem(ArmorMaterial p_40386_, Type helmet, Properties p_40388_) {
		super(p_40386_, helmet, p_40388_);
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public Model getGenericArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> original) {
				if (armorSlot == EquipmentSlot.HEAD) {
					MiningHelmetModel<LivingEntity> miningHelmetModel = new MiningHelmetModel<LivingEntity>(Minecraft.getInstance().getEntityModels().bakeLayer(TechnologicaModelLayers.MINING_HELMET));
					ForgeHooksClient.copyModelProperties(original, miningHelmetModel);
					return miningHelmetModel;
				}
				return null;
			}
		});
	}
}
