package com.technologica.entity;

import static com.technologica.Technologica.MODID;

import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.entity.passive.OstrichEntity;
import com.technologica.entity.passive.ZebraEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntities {
	private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
	
	public static final RegistryObject<EntityType<DuckEntity>> DUCK = ENTITIES.register("duck", () -> EntityType.Builder.<DuckEntity>create(DuckEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).trackingRange(10).build("duck"));
    public static final RegistryObject<EntityType<GrizzlyBearEntity>> GRIZZLY_BEAR = ENTITIES.register("grizzly_bear", () -> EntityType.Builder.<GrizzlyBearEntity>create(GrizzlyBearEntity::new, EntityClassification.CREATURE).size(1.4F, 1.4F).trackingRange(10).build("grizzly_bear"));
    public static final RegistryObject<EntityType<OstrichEntity>> OSTRICH = ENTITIES.register("ostrich", () -> EntityType.Builder.<OstrichEntity>create(OstrichEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).trackingRange(10).build("ostrich"));
    public static final RegistryObject<EntityType<SharkEntity>> SHARK = ENTITIES.register("shark", () -> EntityType.Builder.<SharkEntity>create(SharkEntity::new, EntityClassification.CREATURE).size(0.9F, 0.6F).trackingRange(10).build("shark"));
    public static final RegistryObject<EntityType<ZebraEntity>> ZEBRA = ENTITIES.register("zebra", () -> EntityType.Builder.<ZebraEntity>create(ZebraEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).trackingRange(10).build("zebra"));
	
	public static void register() 
    {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());  
    }
}