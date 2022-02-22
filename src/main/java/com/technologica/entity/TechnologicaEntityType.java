package com.technologica.entity;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import com.technologica.entity.item.InvisibleSeatEntity;
import com.technologica.entity.item.NavalMineEntity;
import com.technologica.entity.item.VanillaBoatEntity;
import com.technologica.entity.monster.PeeperEntity;
import com.technologica.entity.monster.SweeperEntity;
import com.technologica.entity.passive.AlligatorEntity;
import com.technologica.entity.passive.BeaverEntity;
import com.technologica.entity.passive.BuffaloEntity;
import com.technologica.entity.passive.CamelEntity;
import com.technologica.entity.passive.CobraEntity;
import com.technologica.entity.passive.CottonmouthEntity;
import com.technologica.entity.passive.CoyoteEntity;
import com.technologica.entity.passive.CrabEntity;
import com.technologica.entity.passive.DeerEntity;
import com.technologica.entity.passive.DuckEntity;
import com.technologica.entity.passive.ElephantEntity;
import com.technologica.entity.passive.FlamingoEntity;
import com.technologica.entity.passive.FrogEntity;
import com.technologica.entity.passive.GiraffeEntity;
import com.technologica.entity.passive.GorillaEntity;
import com.technologica.entity.passive.GrizzlyBearEntity;
import com.technologica.entity.passive.JaguarEntity;
import com.technologica.entity.passive.KingCrabEntity;
import com.technologica.entity.passive.LeopardSealEntity;
import com.technologica.entity.passive.LionEntity;
import com.technologica.entity.passive.LizardEntity;
import com.technologica.entity.passive.MooseEntity;
import com.technologica.entity.passive.NarwhalEntity;
import com.technologica.entity.passive.OctopusEntity;
import com.technologica.entity.passive.OstrichEntity;
import com.technologica.entity.passive.OwlEntity;
import com.technologica.entity.passive.PenguinEntity;
import com.technologica.entity.passive.PoisonDartFrogEntity;
import com.technologica.entity.passive.RaccoonEntity;
import com.technologica.entity.passive.ScorpionEntity;
import com.technologica.entity.passive.SharkEntity;
import com.technologica.entity.passive.SlothEntity;
import com.technologica.entity.passive.StingrayEntity;
import com.technologica.entity.passive.TurkeyEntity;
import com.technologica.entity.passive.VultureEntity;
import com.technologica.entity.passive.WalrusEntity;
import com.technologica.entity.passive.ZebraEntity;
import com.technologica.entity.passive.fish.PiranhaEntity;
import com.technologica.entity.projectile.CoconutEntity;
import com.technologica.entity.projectile.DodgeballEntity;
import com.technologica.entity.projectile.HarpoonEntity;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

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
	
	public static final RegistryObject<EntityType<AlligatorEntity>> ALLIGATOR = ENTITIES.register("alligator", () -> EntityType.Builder.<AlligatorEntity>of(AlligatorEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("alligator"));
	public static final RegistryObject<EntityType<BeaverEntity>> BEAVER = ENTITIES.register("beaver", () -> EntityType.Builder.<BeaverEntity>of(BeaverEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("beaver"));
	public static final RegistryObject<EntityType<BuffaloEntity>> BUFFALO = ENTITIES.register("buffalo", () -> EntityType.Builder.<BuffaloEntity>of(BuffaloEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("buffalo"));
	public static final RegistryObject<EntityType<CamelEntity>> CAMEL = ENTITIES.register("camel", () -> EntityType.Builder.<CamelEntity>of(CamelEntity::new, EntityClassification.CREATURE).sized(1.3964844F, 2.0F).clientTrackingRange(10).build("camel"));
	public static final RegistryObject<EntityType<CobraEntity>> COBRA = ENTITIES.register("cobra", () -> EntityType.Builder.<CobraEntity>of(CobraEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("cobra"));
	public static final RegistryObject<EntityType<CottonmouthEntity>> COTTONMOUTH = ENTITIES.register("cottonmouth", () -> EntityType.Builder.<CottonmouthEntity>of(CottonmouthEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("cottonmouth"));
	public static final RegistryObject<EntityType<CoyoteEntity>> COYOTE = ENTITIES.register("coyote", () -> EntityType.Builder.<CoyoteEntity>of(CoyoteEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("coyote"));
	public static final RegistryObject<EntityType<CrabEntity>> CRAB = ENTITIES.register("crab", () -> EntityType.Builder.<CrabEntity>of(CrabEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("crab"));
	public static final RegistryObject<EntityType<DeerEntity>> DEER = ENTITIES.register("deer", () -> EntityType.Builder.<DeerEntity>of(DeerEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("deer"));
	public static final RegistryObject<EntityType<DuckEntity>> DUCK = ENTITIES.register("duck", () -> EntityType.Builder.<DuckEntity>of(DuckEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("duck"));
	public static final RegistryObject<EntityType<ElephantEntity>> ELEPHANT = ENTITIES.register("elephant", () -> EntityType.Builder.<ElephantEntity>of(ElephantEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("elephant"));
	public static final RegistryObject<EntityType<FlamingoEntity>> FLAMINGO = ENTITIES.register("flamingo", () -> EntityType.Builder.<FlamingoEntity>of(FlamingoEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("flamingo"));
	public static final RegistryObject<EntityType<FrogEntity>> FROG = ENTITIES.register("frog", () -> EntityType.Builder.<FrogEntity>of(FrogEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("frog"));
	public static final RegistryObject<EntityType<GiraffeEntity>> GIRAFFE = ENTITIES.register("giraffe", () -> EntityType.Builder.<GiraffeEntity>of(GiraffeEntity::new, EntityClassification.CREATURE).sized(1.4F, 3.0F).clientTrackingRange(20).build("giraffe"));
	public static final RegistryObject<EntityType<GorillaEntity>> GORILLA = ENTITIES.register("gorilla", () -> EntityType.Builder.<GorillaEntity>of(GorillaEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("gorilla"));
	public static final RegistryObject<EntityType<GrizzlyBearEntity>> GRIZZLY_BEAR = ENTITIES.register("grizzly_bear", () -> EntityType.Builder.<GrizzlyBearEntity>of(GrizzlyBearEntity::new, EntityClassification.CREATURE).sized(1.4F, 1.4F).clientTrackingRange(10).build("grizzly_bear"));
	public static final RegistryObject<EntityType<JaguarEntity>> JAGUAR = ENTITIES.register("jaguar", () -> EntityType.Builder.<JaguarEntity>of(JaguarEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("jaguar"));
	public static final RegistryObject<EntityType<KingCrabEntity>> KING_CRAB = ENTITIES.register("king_crab", () -> EntityType.Builder.<KingCrabEntity>of(KingCrabEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("king_crab"));
	public static final RegistryObject<EntityType<LeopardSealEntity>> LEOPARD_SEAL = ENTITIES.register("leopard_seal", () -> EntityType.Builder.<LeopardSealEntity>of(LeopardSealEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("leopard_seal"));
	public static final RegistryObject<EntityType<LionEntity>> LION = ENTITIES.register("lion", () -> EntityType.Builder.<LionEntity>of(LionEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("lion"));
	public static final RegistryObject<EntityType<LizardEntity>> LIZARD = ENTITIES.register("lizard", () -> EntityType.Builder.<LizardEntity>of(LizardEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("lizard"));
	public static final RegistryObject<EntityType<MooseEntity>> MOOSE = ENTITIES.register("moose", () -> EntityType.Builder.<MooseEntity>of(MooseEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("moose"));
	public static final RegistryObject<EntityType<NarwhalEntity>> NARWHAL = ENTITIES.register("narwhal", () -> EntityType.Builder.<NarwhalEntity>of(NarwhalEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("narwhal"));
	public static final RegistryObject<EntityType<OctopusEntity>> OCTOPUS = ENTITIES.register("octopus", () -> EntityType.Builder.<OctopusEntity>of(OctopusEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("octopus"));
	public static final RegistryObject<EntityType<OstrichEntity>> OSTRICH = ENTITIES.register("ostrich", () -> EntityType.Builder.<OstrichEntity>of(OstrichEntity::new, EntityClassification.CREATURE).sized(1.0F, 1.8F).clientTrackingRange(10).build("ostrich"));
	public static final RegistryObject<EntityType<OwlEntity>> OWL = ENTITIES.register("owl", () -> EntityType.Builder.<OwlEntity>of(OwlEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("owl"));
	public static final RegistryObject<EntityType<PenguinEntity>> PENGUIN = ENTITIES.register("penguin", () -> EntityType.Builder.<PenguinEntity>of(PenguinEntity::new, EntityClassification.CREATURE).sized(1.0F, 1.625F).clientTrackingRange(10).build("penguin"));
	public static final RegistryObject<EntityType<PiranhaEntity>> PIRANHA = ENTITIES.register("piranha", () -> EntityType.Builder.<PiranhaEntity>of(PiranhaEntity::new, EntityClassification.WATER_AMBIENT).sized(0.5F, 0.4F).clientTrackingRange(10).build("piranha"));
	public static final RegistryObject<EntityType<PoisonDartFrogEntity>> POISON_DART_FROG = ENTITIES.register("poison_dart_frog", () -> EntityType.Builder.<PoisonDartFrogEntity>of(PoisonDartFrogEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("poison_dart_frog"));
	public static final RegistryObject<EntityType<RaccoonEntity>> RACCOON = ENTITIES.register("raccoon", () -> EntityType.Builder.<RaccoonEntity>of(RaccoonEntity::new, EntityClassification.CREATURE).sized(0.8F, 0.8F).clientTrackingRange(10).build("raccoon"));
    public static final RegistryObject<EntityType<ScorpionEntity>> SCORPION = ENTITIES.register("scorpion", () -> EntityType.Builder.<ScorpionEntity>of(ScorpionEntity::new, EntityClassification.CREATURE).sized(0.9F, 1.0F).clientTrackingRange(10).build("scorpion"));
    public static final RegistryObject<EntityType<SharkEntity>> SHARK = ENTITIES.register("shark", () -> EntityType.Builder.<SharkEntity>of(SharkEntity::new, EntityClassification.CREATURE).sized(0.9F, 0.6F).clientTrackingRange(10).build("shark"));
    public static final RegistryObject<EntityType<SlothEntity>> SLOTH = ENTITIES.register("sloth", () -> EntityType.Builder.<SlothEntity>of(SlothEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("sloth"));
    public static final RegistryObject<EntityType<StingrayEntity>> STINGRAY = ENTITIES.register("stingray", () -> EntityType.Builder.<StingrayEntity>of(StingrayEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("stingray"));
    public static final RegistryObject<EntityType<TurkeyEntity>> TURKEY = ENTITIES.register("turkey", () -> EntityType.Builder.<TurkeyEntity>of(TurkeyEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("turkey"));
    public static final RegistryObject<EntityType<VultureEntity>> VULTURE = ENTITIES.register("vulture", () -> EntityType.Builder.<VultureEntity>of(VultureEntity::new, EntityClassification.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("vulture"));
    public static final RegistryObject<EntityType<WalrusEntity>> WALRUS = ENTITIES.register("walrus", () -> EntityType.Builder.<WalrusEntity>of(WalrusEntity::new, EntityClassification.CREATURE).sized(1.4F, 1.4F).clientTrackingRange(10).build("walrus"));
    public static final RegistryObject<EntityType<ZebraEntity>> ZEBRA = ENTITIES.register("zebra", () -> EntityType.Builder.<ZebraEntity>of(ZebraEntity::new, EntityClassification.CREATURE).sized(1.3964844F, 1.6F).clientTrackingRange(10).build("zebra"));
	
    /*
	 * MONSTERS
	 */
    
    public static final RegistryObject<EntityType<PeeperEntity>> PEEPER = ENTITIES.register("peeper", () -> EntityType.Builder.<PeeperEntity>of(PeeperEntity::new, EntityClassification.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(16).build("peeper"));
    public static final RegistryObject<EntityType<SweeperEntity>> SWEEPER = ENTITIES.register("sweeper", () -> EntityType.Builder.<SweeperEntity>of(SweeperEntity::new, EntityClassification.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(8).build("sweeper"));
    
    /*
	 * VEHICLES
	 */
    
    public static final RegistryObject<EntityType<VanillaBoatEntity>> MOD_BOAT = ENTITIES.register("mod_boat", () -> EntityType.Builder.<VanillaBoatEntity>of(VanillaBoatEntity::new, EntityClassification.MISC).sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new VanillaBoatEntity(world, 0, 0, 0)).clientTrackingRange(10).build("mod_boat"));
    
    /*
     * PROJECTILES
     */
    
    public static final RegistryObject<EntityType<CoconutEntity>> COCONUT = ENTITIES.register("coconut", () -> EntityType.Builder.<CoconutEntity>of(CoconutEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).setCustomClientFactory((spawnEntity, world) -> new CoconutEntity(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(10).build("coconut"));
    public static final RegistryObject<EntityType<DodgeballEntity>> DODGEBALL = ENTITIES.register("dodgeball", () -> EntityType.Builder.<DodgeballEntity>of(DodgeballEntity::new, EntityClassification.MISC).sized(0.25F, 0.25F).setCustomClientFactory((spawnEntity, world) -> new DodgeballEntity(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(10).build("dodgeball"));
    public static final RegistryObject<EntityType<HarpoonEntity>> HARPOON = ENTITIES.register("harpoon", () -> EntityType.Builder.<HarpoonEntity>of(HarpoonEntity::new, EntityClassification.MISC).sized(0.5F, 0.5F).setCustomClientFactory((spawnEntity, world) -> new HarpoonEntity(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(20).build("harpoon"));
    
    /*
	 * OTHER
	 */
    
    public static final RegistryObject<EntityType<InvisibleSeatEntity>> INVISIBLE_SEAT = ENTITIES.register("invisible_seat", () -> EntityType.Builder.<InvisibleSeatEntity>of(InvisibleSeatEntity::new, EntityClassification.MISC).sized(0.1F, 0.1F).setCustomClientFactory((spawnEntity, world) -> new InvisibleSeatEntity(world, 0, 0, 0)).clientTrackingRange(10).build("invisible_seat_entity"));
    public static final RegistryObject<EntityType<NavalMineEntity>> NAVAL_MINE = ENTITIES.register("naval_mine", () -> EntityType.Builder.<NavalMineEntity>of(NavalMineEntity::new, EntityClassification.MISC).sized(2.0F, 2.0F).setCustomClientFactory((spawnEntity, world) -> new NavalMineEntity(world, 0, 0, 0)).clientTrackingRange(10).build("naval_mine_entity"));
}