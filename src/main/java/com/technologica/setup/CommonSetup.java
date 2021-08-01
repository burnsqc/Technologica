package com.technologica.setup;

import com.technologica.block.ModBlocks;
import com.technologica.capabilities.ModCapabilities;
import com.technologica.entity.ModEntities;
import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.minecraft.entity.passive.horse.AbstractHorseEntity.func_234237_fg_;

public class CommonSetup {

   public static void init(final FMLCommonSetupEvent event) {
      ModCapabilities.register();
      GlobalEntityTypeAttributes.put(ModEntities.DUCK.get(), DuckEntity.registerAttributes().create());
      GlobalEntityTypeAttributes.put(ModEntities.GRIZZLY_BEAR.get(), GrizzlyBearEntity.registerAttributes().create());
      GlobalEntityTypeAttributes.put(ModEntities.OSTRICH.get(), func_234237_fg_().create());
      GlobalEntityTypeAttributes.put(ModEntities.SHARK.get(), SharkEntity.registerAttributes().create());
      GlobalEntityTypeAttributes.put(ModEntities.ZEBRA.get(), func_234237_fg_().create());

      event.enqueueWork(() -> {
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BANANA_SAPLING.getId(), ModBlocks.POTTED_BANANA_SAPLING::get);
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CHERRY_SAPLING.getId(), ModBlocks.POTTED_CHERRY_SAPLING::get);
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.COCONUT_SAPLING.getId(), ModBlocks.POTTED_COCONUT_SAPLING::get);
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.KIWI_SAPLING.getId(), ModBlocks.POTTED_KIWI_SAPLING::get);
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LEMON_SAPLING.getId(), ModBlocks.POTTED_LEMON_SAPLING::get);
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LIME_SAPLING.getId(), ModBlocks.POTTED_LIME_SAPLING::get);
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ORANGE_SAPLING.getId(), ModBlocks.POTTED_ORANGE_SAPLING::get);
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PEACH_SAPLING.getId(), ModBlocks.POTTED_PEACH_SAPLING::get);
         ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.PEAR_SAPLING.getId(), ModBlocks.POTTED_PEAR_SAPLING::get);
      });
   }

}
