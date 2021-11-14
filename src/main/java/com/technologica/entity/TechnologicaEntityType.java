package com.technologica.entity;

import static com.technologica.Technologica.MODID;

import com.technologica.entity.item.InvisibleSeatEntity;
import com.technologica.entity.item.VanillaBoatEntity;
import com.technologica.entity.monster.PeeperEntity;
import com.technologica.entity.monster.ScorpionEntity;
import com.technologica.entity.monster.SharkEntity;
import com.technologica.entity.monster.SweeperEntity;
import com.technologica.entity.passive.CoyoteEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.GiraffeEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.entity.passive.OstrichEntity;
import com.technologica.entity.passive.ZebraEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TechnologicaEntityType {
	private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
	
	public static final RegistryObject<EntityType<VanillaBoatEntity>> MOD_BOAT = ENTITIES.register("mod_boat", () -> EntityType.Builder.<VanillaBoatEntity>create(VanillaBoatEntity::new, EntityClassification.MISC).size(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new VanillaBoatEntity(world, 0, 0, 0)).trackingRange(10).build("mod_boat"));
	
	public static final RegistryObject<EntityType<CoyoteEntity>> COYOTE = ENTITIES.register("coyote", () -> EntityType.Builder.<CoyoteEntity>create(CoyoteEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).trackingRange(10).build("coyote"));
	public static final RegistryObject<EntityType<DuckEntity>> DUCK = ENTITIES.register("duck", () -> EntityType.Builder.<DuckEntity>create(DuckEntity::new, EntityClassification.CREATURE).size(0.4F, 0.7F).trackingRange(10).build("duck"));
	public static final RegistryObject<EntityType<GiraffeEntity>> GIRAFFE = ENTITIES.register("giraffe", () -> EntityType.Builder.<GiraffeEntity>create(GiraffeEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).trackingRange(10).build("giraffe"));
	public static final RegistryObject<EntityType<GrizzlyBearEntity>> GRIZZLY_BEAR = ENTITIES.register("grizzly_bear", () -> EntityType.Builder.<GrizzlyBearEntity>create(GrizzlyBearEntity::new, EntityClassification.CREATURE).size(1.4F, 1.4F).trackingRange(10).build("grizzly_bear"));
    public static final RegistryObject<EntityType<OstrichEntity>> OSTRICH = ENTITIES.register("ostrich", () -> EntityType.Builder.<OstrichEntity>create(OstrichEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).trackingRange(10).build("ostrich"));
    public static final RegistryObject<EntityType<ScorpionEntity>> SCORPION = ENTITIES.register("scorpion", () -> EntityType.Builder.<ScorpionEntity>create(ScorpionEntity::new, EntityClassification.CREATURE).size(0.9F, 1.0F).trackingRange(10).build("scorpion"));
    public static final RegistryObject<EntityType<SharkEntity>> SHARK = ENTITIES.register("shark", () -> EntityType.Builder.<SharkEntity>create(SharkEntity::new, EntityClassification.CREATURE).size(0.9F, 0.6F).trackingRange(10).build("shark"));
    public static final RegistryObject<EntityType<ZebraEntity>> ZEBRA = ENTITIES.register("zebra", () -> EntityType.Builder.<ZebraEntity>create(ZebraEntity::new, EntityClassification.CREATURE).size(1.3964844F, 1.6F).trackingRange(10).build("zebra"));
	
    public static final RegistryObject<EntityType<PeeperEntity>> PEEPER = ENTITIES.register("peeper", () -> EntityType.Builder.<PeeperEntity>create(PeeperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.7F).trackingRange(16).build("peeper"));
    public static final RegistryObject<EntityType<SweeperEntity>> SWEEPER = ENTITIES.register("sweeper", () -> EntityType.Builder.<SweeperEntity>create(SweeperEntity::new, EntityClassification.MONSTER).size(0.6F, 1.7F).trackingRange(8).build("sweeper"));
    
    public static final RegistryObject<EntityType<InvisibleSeatEntity>> INVISIBLE_SEAT = ENTITIES.register("invisible_seat", () -> EntityType.Builder.<InvisibleSeatEntity>create(InvisibleSeatEntity::new, EntityClassification.MISC).size(0.1F, 0.1F).setCustomClientFactory((spawnEntity, world) -> new InvisibleSeatEntity(world, 0, 0, 0)).trackingRange(10).build("invisible_seat_entity"));
    
	public static void register() 
    {
        ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());  
    }
}