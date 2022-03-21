package com.technologica.data.worldgen;

import com.google.common.collect.ImmutableList;
import com.technologica.world.level.block.TechnologicaBlocks;

import net.minecraft.data.BuiltinRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.ProcessorRule;
import net.minecraft.world.level.levelgen.structure.templatesystem.RandomBlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

public class TechnologicaProcessorLists {
   public static final StructureProcessorList FARM_PLAINS_MODIFIED = register("farm_plains_modified", ImmutableList.of(new RuleProcessor(ImmutableList.of(new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.3F), AlwaysTrueTest.INSTANCE, TechnologicaBlocks.CHILI_PEPPER_CROP.get().defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.2F), AlwaysTrueTest.INSTANCE, Blocks.POTATOES.defaultBlockState()), new ProcessorRule(new RandomBlockMatchTest(Blocks.WHEAT, 0.1F), AlwaysTrueTest.INSTANCE, Blocks.BEETROOTS.defaultBlockState())))));
   
   private static StructureProcessorList register(String p_127226_, ImmutableList<StructureProcessor> p_127227_) {
      ResourceLocation resourcelocation = new ResourceLocation(p_127226_);
      StructureProcessorList structureprocessorlist = new StructureProcessorList(p_127227_);
      return BuiltinRegistries.register(BuiltinRegistries.PROCESSOR_LIST, resourcelocation, structureprocessorlist);
   }
}