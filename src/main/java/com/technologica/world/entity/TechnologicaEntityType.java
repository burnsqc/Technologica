package com.technologica.world.entity;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import com.technologica.world.entity.animal.AlligatorEntity;
import com.technologica.world.entity.animal.BeaverEntity;
import com.technologica.world.entity.animal.BuffaloEntity;
import com.technologica.world.entity.animal.CamelEntity;
import com.technologica.world.entity.animal.CobraEntity;
import com.technologica.world.entity.animal.CottonmouthEntity;
import com.technologica.world.entity.animal.CoyoteEntity;
import com.technologica.world.entity.animal.CrabEntity;
import com.technologica.world.entity.animal.DeerEntity;
import com.technologica.world.entity.animal.DuckEntity;
import com.technologica.world.entity.animal.ElephantEntity;
import com.technologica.world.entity.animal.FlamingoEntity;
import com.technologica.world.entity.animal.FrogEntity;
import com.technologica.world.entity.animal.GiraffeEntity;
import com.technologica.world.entity.animal.GorillaEntity;
import com.technologica.world.entity.animal.GrizzlyBearEntity;
import com.technologica.world.entity.animal.JaguarEntity;
import com.technologica.world.entity.animal.KingCrabEntity;
import com.technologica.world.entity.animal.LeopardSealEntity;
import com.technologica.world.entity.animal.LionEntity;
import com.technologica.world.entity.animal.LizardEntity;
import com.technologica.world.entity.animal.MooseEntity;
import com.technologica.world.entity.animal.NarwhalEntity;
import com.technologica.world.entity.animal.OctopusEntity;
import com.technologica.world.entity.animal.OstrichEntity;
import com.technologica.world.entity.animal.OwlEntity;
import com.technologica.world.entity.animal.PenguinEntity;
import com.technologica.world.entity.animal.PiranhaEntity;
import com.technologica.world.entity.animal.PoisonDartFrogEntity;
import com.technologica.world.entity.animal.RaccoonEntity;
import com.technologica.world.entity.animal.ScorpionEntity;
import com.technologica.world.entity.animal.SharkEntity;
import com.technologica.world.entity.animal.SlothEntity;
import com.technologica.world.entity.animal.StingrayEntity;
import com.technologica.world.entity.animal.TurkeyEntity;
import com.technologica.world.entity.animal.VultureEntity;
import com.technologica.world.entity.animal.WalrusEntity;
import com.technologica.world.entity.animal.ZebraEntity;
import com.technologica.world.entity.decoration.InvisibleSeatEntity;
import com.technologica.world.entity.item.NavalMineEntity;
import com.technologica.world.entity.monster.PeeperEntity;
import com.technologica.world.entity.monster.SweeperEntity;
import com.technologica.world.entity.projectile.CoconutEntity;
import com.technologica.world.entity.projectile.DodgeballEntity;
import com.technologica.world.entity.projectile.HarpoonEntity;
import com.technologica.world.entity.vehicle.VanillaBoatEntity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaEntityType {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING ENTITIES");
		ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info(ENTITIES.getEntries().size() + " ENTITIES INITIALIZED");
    }
	
	/*
	 * ANIMALS
	 */
	
	public static final RegistryObject<EntityType<AlligatorEntity>> ALLIGATOR = ENTITIES.register("alligator", () -> EntityType.Builder.<AlligatorEntity>of(AlligatorEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("alligator"));
	public static final RegistryObject<EntityType<BeaverEntity>> BEAVER = ENTITIES.register("beaver", () -> EntityType.Builder.<BeaverEntity>of(BeaverEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("beaver"));
	public static final RegistryObject<EntityType<BuffaloEntity>> BUFFALO = ENTITIES.register("buffalo", () -> EntityType.Builder.<BuffaloEntity>of(BuffaloEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("buffalo"));
	public static final RegistryObject<EntityType<CamelEntity>> CAMEL = ENTITIES.register("camel", () -> EntityType.Builder.<CamelEntity>of(CamelEntity::new, MobCategory.CREATURE).sized(1.3964844F, 2.0F).clientTrackingRange(10).build("camel"));
	public static final RegistryObject<EntityType<CobraEntity>> COBRA = ENTITIES.register("cobra", () -> EntityType.Builder.<CobraEntity>of(CobraEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("cobra"));
	public static final RegistryObject<EntityType<CottonmouthEntity>> COTTONMOUTH = ENTITIES.register("cottonmouth", () -> EntityType.Builder.<CottonmouthEntity>of(CottonmouthEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("cottonmouth"));
	public static final RegistryObject<EntityType<CoyoteEntity>> COYOTE = ENTITIES.register("coyote", () -> EntityType.Builder.<CoyoteEntity>of(CoyoteEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("coyote"));
	public static final RegistryObject<EntityType<CrabEntity>> CRAB = ENTITIES.register("crab", () -> EntityType.Builder.<CrabEntity>of(CrabEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("crab"));
	public static final RegistryObject<EntityType<DeerEntity>> DEER = ENTITIES.register("deer", () -> EntityType.Builder.<DeerEntity>of(DeerEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("deer"));
	public static final RegistryObject<EntityType<DuckEntity>> DUCK = ENTITIES.register("duck", () -> EntityType.Builder.<DuckEntity>of(DuckEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("duck"));
	public static final RegistryObject<EntityType<ElephantEntity>> ELEPHANT = ENTITIES.register("elephant", () -> EntityType.Builder.<ElephantEntity>of(ElephantEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("elephant"));
	public static final RegistryObject<EntityType<FlamingoEntity>> FLAMINGO = ENTITIES.register("flamingo", () -> EntityType.Builder.<FlamingoEntity>of(FlamingoEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("flamingo"));
	public static final RegistryObject<EntityType<FrogEntity>> FROG = ENTITIES.register("frog", () -> EntityType.Builder.<FrogEntity>of(FrogEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("frog"));
	public static final RegistryObject<EntityType<GiraffeEntity>> GIRAFFE = ENTITIES.register("giraffe", () -> EntityType.Builder.<GiraffeEntity>of(GiraffeEntity::new, MobCategory.CREATURE).sized(1.4F, 3.0F).clientTrackingRange(20).build("giraffe"));
	public static final RegistryObject<EntityType<GorillaEntity>> GORILLA = ENTITIES.register("gorilla", () -> EntityType.Builder.<GorillaEntity>of(GorillaEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("gorilla"));
	public static final RegistryObject<EntityType<GrizzlyBearEntity>> GRIZZLY_BEAR = ENTITIES.register("grizzly_bear", () -> EntityType.Builder.<GrizzlyBearEntity>of(GrizzlyBearEntity::new, MobCategory.CREATURE).sized(1.4F, 1.4F).clientTrackingRange(10).build("grizzly_bear"));
	public static final RegistryObject<EntityType<JaguarEntity>> JAGUAR = ENTITIES.register("jaguar", () -> EntityType.Builder.<JaguarEntity>of(JaguarEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("jaguar"));
	public static final RegistryObject<EntityType<KingCrabEntity>> KING_CRAB = ENTITIES.register("king_crab", () -> EntityType.Builder.<KingCrabEntity>of(KingCrabEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("king_crab"));
	public static final RegistryObject<EntityType<LeopardSealEntity>> LEOPARD_SEAL = ENTITIES.register("leopard_seal", () -> EntityType.Builder.<LeopardSealEntity>of(LeopardSealEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("leopard_seal"));
	public static final RegistryObject<EntityType<LionEntity>> LION = ENTITIES.register("lion", () -> EntityType.Builder.<LionEntity>of(LionEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("lion"));
	public static final RegistryObject<EntityType<LizardEntity>> LIZARD = ENTITIES.register("lizard", () -> EntityType.Builder.<LizardEntity>of(LizardEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("lizard"));
	public static final RegistryObject<EntityType<MooseEntity>> MOOSE = ENTITIES.register("moose", () -> EntityType.Builder.<MooseEntity>of(MooseEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("moose"));
	public static final RegistryObject<EntityType<NarwhalEntity>> NARWHAL = ENTITIES.register("narwhal", () -> EntityType.Builder.<NarwhalEntity>of(NarwhalEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("narwhal"));
	public static final RegistryObject<EntityType<OctopusEntity>> OCTOPUS = ENTITIES.register("octopus", () -> EntityType.Builder.<OctopusEntity>of(OctopusEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("octopus"));
	public static final RegistryObject<EntityType<OstrichEntity>> OSTRICH = ENTITIES.register("ostrich", () -> EntityType.Builder.<OstrichEntity>of(OstrichEntity::new, MobCategory.CREATURE).sized(1.0F, 1.8F).clientTrackingRange(10).build("ostrich"));
	public static final RegistryObject<EntityType<OwlEntity>> OWL = ENTITIES.register("owl", () -> EntityType.Builder.<OwlEntity>of(OwlEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("owl"));
	public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = ENTITIES.register("penguin", () -> EntityType.Builder.<PenguinEntity>of(PenguinEntity::new, MobCategory.CREATURE).sized(1.0F, 1.625F).clientTrackingRange(10).build("penguin"));
	public static final RegistryObject<EntityType<PiranhaEntity>> PIRANHA = ENTITIES.register("piranha", () -> EntityType.Builder.<PiranhaEntity>of(PiranhaEntity::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.4F).clientTrackingRange(10).build("piranha"));
	public static final RegistryObject<EntityType<PoisonDartFrogEntity>> POISON_DART_FROG = ENTITIES.register("poison_dart_frog", () -> EntityType.Builder.<PoisonDartFrogEntity>of(PoisonDartFrogEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("poison_dart_frog"));
	public static final RegistryObject<EntityType<RaccoonEntity>> RACCOON = ENTITIES.register("raccoon", () -> EntityType.Builder.<RaccoonEntity>of(RaccoonEntity::new, MobCategory.CREATURE).sized(0.8F, 0.8F).clientTrackingRange(10).build("raccoon"));
    public static final RegistryObject<EntityType<ScorpionEntity>> SCORPION = ENTITIES.register("scorpion", () -> EntityType.Builder.<ScorpionEntity>of(ScorpionEntity::new, MobCategory.CREATURE).sized(0.9F, 1.0F).clientTrackingRange(10).build("scorpion"));
    public static final RegistryObject<EntityType<SharkEntity>> SHARK = ENTITIES.register("shark", () -> EntityType.Builder.<SharkEntity>of(SharkEntity::new, MobCategory.CREATURE).sized(0.9F, 0.6F).clientTrackingRange(10).build("shark"));
    public static final RegistryObject<EntityType<SlothEntity>> SLOTH = ENTITIES.register("sloth", () -> EntityType.Builder.<SlothEntity>of(SlothEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("sloth"));
    public static final RegistryObject<EntityType<StingrayEntity>> STINGRAY = ENTITIES.register("stingray", () -> EntityType.Builder.<StingrayEntity>of(StingrayEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("stingray"));
    public static final RegistryObject<EntityType<TurkeyEntity>> TURKEY = ENTITIES.register("turkey", () -> EntityType.Builder.<TurkeyEntity>of(TurkeyEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("turkey"));
    public static final RegistryObject<EntityType<VultureEntity>> VULTURE = ENTITIES.register("vulture", () -> EntityType.Builder.<VultureEntity>of(VultureEntity::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("vulture"));
    public static final RegistryObject<EntityType<WalrusEntity>> WALRUS = ENTITIES.register("walrus", () -> EntityType.Builder.<WalrusEntity>of(WalrusEntity::new, MobCategory.CREATURE).sized(1.4F, 1.4F).clientTrackingRange(10).build("walrus"));
    public static final RegistryObject<EntityType<ZebraEntity>> ZEBRA = ENTITIES.register("zebra", () -> EntityType.Builder.<ZebraEntity>of(ZebraEntity::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).clientTrackingRange(10).build("zebra"));
	
    /*
	 * MONSTERS
	 */
    
    public static final RegistryObject<EntityType<PeeperEntity>> PEEPER = ENTITIES.register("peeper", () -> EntityType.Builder.<PeeperEntity>of(PeeperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(16).build("peeper"));
    public static final RegistryObject<EntityType<SweeperEntity>> SWEEPER = ENTITIES.register("sweeper", () -> EntityType.Builder.<SweeperEntity>of(SweeperEntity::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(8).build("sweeper"));
    
    /*
	 * VEHICLES
	 */
    
    public static final RegistryObject<EntityType<VanillaBoatEntity>> MOD_BOAT = ENTITIES.register("mod_boat", () -> EntityType.Builder.<VanillaBoatEntity>of(VanillaBoatEntity::new, MobCategory.MISC).sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new VanillaBoatEntity(world, 0, 0, 0)).clientTrackingRange(10).build("mod_boat"));
    
    /*
     * PROJECTILES
     */
    
    public static final RegistryObject<EntityType<CoconutEntity>> COCONUT = ENTITIES.register("coconut", () -> EntityType.Builder.<CoconutEntity>of(CoconutEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setCustomClientFactory((spawnEntity, world) -> new CoconutEntity(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(10).build("coconut"));
    public static final RegistryObject<EntityType<DodgeballEntity>> DODGEBALL = ENTITIES.register("dodgeball", () -> EntityType.Builder.<DodgeballEntity>of(DodgeballEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).setCustomClientFactory((spawnEntity, world) -> new DodgeballEntity(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(10).build("dodgeball"));
    public static final RegistryObject<EntityType<HarpoonEntity>> HARPOON = ENTITIES.register("harpoon", () -> EntityType.Builder.<HarpoonEntity>of(HarpoonEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).setCustomClientFactory((spawnEntity, world) -> new HarpoonEntity(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(20).build("harpoon"));
    
    /*
	 * OTHER
	 */
    
    public static final RegistryObject<EntityType<InvisibleSeatEntity>> INVISIBLE_SEAT = ENTITIES.register("invisible_seat", () -> EntityType.Builder.<InvisibleSeatEntity>of(InvisibleSeatEntity::new, MobCategory.MISC).sized(0.1F, 0.1F).setCustomClientFactory((spawnEntity, world) -> new InvisibleSeatEntity(world, 0, 0, 0)).clientTrackingRange(10).build("invisible_seat_entity"));
    public static final RegistryObject<EntityType<NavalMineEntity>> NAVAL_MINE = ENTITIES.register("naval_mine", () -> EntityType.Builder.<NavalMineEntity>of(NavalMineEntity::new, MobCategory.MISC).sized(2.0F, 2.0F).setCustomClientFactory((spawnEntity, world) -> new NavalMineEntity(world, 0, 0, 0)).clientTrackingRange(10).build("naval_mine_entity"));
}