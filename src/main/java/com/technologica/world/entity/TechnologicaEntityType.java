package com.technologica.world.entity;

import static com.technologica.Technologica.LOGGER;
import static com.technologica.Technologica.MODID;

import com.technologica.world.entity.animal.Alligator;
import com.technologica.world.entity.animal.Beaver;
import com.technologica.world.entity.animal.Buffalo;
import com.technologica.world.entity.animal.Camel;
import com.technologica.world.entity.animal.Cobra;
import com.technologica.world.entity.animal.Cottonmouth;
import com.technologica.world.entity.animal.Coyote;
import com.technologica.world.entity.animal.Crab;
import com.technologica.world.entity.animal.Deer;
import com.technologica.world.entity.animal.Duck;
import com.technologica.world.entity.animal.Elephant;
import com.technologica.world.entity.animal.Flamingo;
import com.technologica.world.entity.animal.Frog;
import com.technologica.world.entity.animal.Giraffe;
import com.technologica.world.entity.animal.Gorilla;
import com.technologica.world.entity.animal.GrizzlyBear;
import com.technologica.world.entity.animal.Jaguar;
import com.technologica.world.entity.animal.KingCrab;
import com.technologica.world.entity.animal.LeopardSeal;
import com.technologica.world.entity.animal.Lion;
import com.technologica.world.entity.animal.Lizard;
import com.technologica.world.entity.animal.Moose;
import com.technologica.world.entity.animal.Narwhal;
import com.technologica.world.entity.animal.Octopus;
import com.technologica.world.entity.animal.Ostrich;
import com.technologica.world.entity.animal.Owl;
import com.technologica.world.entity.animal.Penguin;
import com.technologica.world.entity.animal.Piranha;
import com.technologica.world.entity.animal.PoisonDartFrog;
import com.technologica.world.entity.animal.Raccoon;
import com.technologica.world.entity.animal.Scorpion;
import com.technologica.world.entity.animal.Shark;
import com.technologica.world.entity.animal.Sloth;
import com.technologica.world.entity.animal.Stingray;
import com.technologica.world.entity.animal.Turkey;
import com.technologica.world.entity.animal.Vulture;
import com.technologica.world.entity.animal.Walrus;
import com.technologica.world.entity.animal.Zebra;
import com.technologica.world.entity.decoration.InvisibleSeat;
import com.technologica.world.entity.item.NavalMine;
import com.technologica.world.entity.monster.Peeper;
import com.technologica.world.entity.monster.Sweeper;
import com.technologica.world.entity.projectile.Coconut;
import com.technologica.world.entity.projectile.Dodgeball;
import com.technologica.world.entity.projectile.Harpoon;
import com.technologica.world.entity.vehicle.VanillaBoat;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TechnologicaEntityType {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
	
	public static void init() {
		LOGGER.info("INITIALIZING ENTITIES");
		ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		LOGGER.info(ENTITIES.getEntries().size() + " ENTITIES INITIALIZED");
    }
	
	/*
	 * ANIMALS
	 */
	
	public static final RegistryObject<EntityType<Alligator>> ALLIGATOR = ENTITIES.register("alligator", () -> EntityType.Builder.<Alligator>of(Alligator::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("alligator"));
	public static final RegistryObject<EntityType<Beaver>> BEAVER = ENTITIES.register("beaver", () -> EntityType.Builder.<Beaver>of(Beaver::new, MobCategory.CREATURE).sized(0.6F, 0.5F).clientTrackingRange(10).build("beaver"));
	public static final RegistryObject<EntityType<Buffalo>> BUFFALO = ENTITIES.register("buffalo", () -> EntityType.Builder.<Buffalo>of(Buffalo::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("buffalo"));
	public static final RegistryObject<EntityType<Camel>> CAMEL = ENTITIES.register("camel", () -> EntityType.Builder.<Camel>of(Camel::new, MobCategory.CREATURE).sized(1.3964844F, 2.0F).clientTrackingRange(10).build("camel"));
	public static final RegistryObject<EntityType<Cobra>> COBRA = ENTITIES.register("cobra", () -> EntityType.Builder.<Cobra>of(Cobra::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("cobra"));
	public static final RegistryObject<EntityType<Cottonmouth>> COTTONMOUTH = ENTITIES.register("cottonmouth", () -> EntityType.Builder.<Cottonmouth>of(Cottonmouth::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("cottonmouth"));
	public static final RegistryObject<EntityType<Coyote>> COYOTE = ENTITIES.register("coyote", () -> EntityType.Builder.<Coyote>of(Coyote::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("coyote"));
	public static final RegistryObject<EntityType<Crab>> CRAB = ENTITIES.register("crab", () -> EntityType.Builder.<Crab>of(Crab::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("crab"));
	public static final RegistryObject<EntityType<Deer>> DEER = ENTITIES.register("deer", () -> EntityType.Builder.<Deer>of(Deer::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("deer"));
	public static final RegistryObject<EntityType<Duck>> DUCK = ENTITIES.register("duck", () -> EntityType.Builder.<Duck>of(Duck::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("duck"));
	public static final RegistryObject<EntityType<Elephant>> ELEPHANT = ENTITIES.register("elephant", () -> EntityType.Builder.<Elephant>of(Elephant::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("elephant"));
	public static final RegistryObject<EntityType<Flamingo>> FLAMINGO = ENTITIES.register("flamingo", () -> EntityType.Builder.<Flamingo>of(Flamingo::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("flamingo"));
	public static final RegistryObject<EntityType<Frog>> FROG = ENTITIES.register("frog", () -> EntityType.Builder.<Frog>of(Frog::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("frog"));
	public static final RegistryObject<EntityType<Giraffe>> GIRAFFE = ENTITIES.register("giraffe", () -> EntityType.Builder.<Giraffe>of(Giraffe::new, MobCategory.CREATURE).sized(1.4F, 3.0F).clientTrackingRange(20).build("giraffe"));
	public static final RegistryObject<EntityType<Gorilla>> GORILLA = ENTITIES.register("gorilla", () -> EntityType.Builder.<Gorilla>of(Gorilla::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("gorilla"));
	public static final RegistryObject<EntityType<GrizzlyBear>> GRIZZLY_BEAR = ENTITIES.register("grizzly_bear", () -> EntityType.Builder.<GrizzlyBear>of(GrizzlyBear::new, MobCategory.CREATURE).sized(1.4F, 1.4F).clientTrackingRange(10).build("grizzly_bear"));
	public static final RegistryObject<EntityType<Jaguar>> JAGUAR = ENTITIES.register("jaguar", () -> EntityType.Builder.<Jaguar>of(Jaguar::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("jaguar"));
	public static final RegistryObject<EntityType<KingCrab>> KING_CRAB = ENTITIES.register("king_crab", () -> EntityType.Builder.<KingCrab>of(KingCrab::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("king_crab"));
	public static final RegistryObject<EntityType<LeopardSeal>> LEOPARD_SEAL = ENTITIES.register("leopard_seal", () -> EntityType.Builder.<LeopardSeal>of(LeopardSeal::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("leopard_seal"));
	public static final RegistryObject<EntityType<Lion>> LION = ENTITIES.register("lion", () -> EntityType.Builder.<Lion>of(Lion::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("lion"));
	public static final RegistryObject<EntityType<Lizard>> LIZARD = ENTITIES.register("lizard", () -> EntityType.Builder.<Lizard>of(Lizard::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("lizard"));
	public static final RegistryObject<EntityType<Moose>> MOOSE = ENTITIES.register("moose", () -> EntityType.Builder.<Moose>of(Moose::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("moose"));
	public static final RegistryObject<EntityType<Narwhal>> NARWHAL = ENTITIES.register("narwhal", () -> EntityType.Builder.<Narwhal>of(Narwhal::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("narwhal"));
	public static final RegistryObject<EntityType<Octopus>> OCTOPUS = ENTITIES.register("octopus", () -> EntityType.Builder.<Octopus>of(Octopus::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("octopus"));
	public static final RegistryObject<EntityType<Ostrich>> OSTRICH = ENTITIES.register("ostrich", () -> EntityType.Builder.<Ostrich>of(Ostrich::new, MobCategory.CREATURE).sized(1.0F, 1.8F).clientTrackingRange(10).build("ostrich"));
	public static final RegistryObject<EntityType<Owl>> OWL = ENTITIES.register("owl", () -> EntityType.Builder.<Owl>of(Owl::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("owl"));
	public static final RegistryObject<EntityType<Penguin>> PENGUIN = ENTITIES.register("penguin", () -> EntityType.Builder.<Penguin>of(Penguin::new, MobCategory.CREATURE).sized(1.0F, 1.625F).clientTrackingRange(10).build("penguin"));
	public static final RegistryObject<EntityType<Piranha>> PIRANHA = ENTITIES.register("piranha", () -> EntityType.Builder.<Piranha>of(Piranha::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.4F).clientTrackingRange(10).build("piranha"));
	public static final RegistryObject<EntityType<PoisonDartFrog>> POISON_DART_FROG = ENTITIES.register("poison_dart_frog", () -> EntityType.Builder.<PoisonDartFrog>of(PoisonDartFrog::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("poison_dart_frog"));
	public static final RegistryObject<EntityType<Raccoon>> RACCOON = ENTITIES.register("raccoon", () -> EntityType.Builder.<Raccoon>of(Raccoon::new, MobCategory.CREATURE).sized(0.8F, 0.8F).clientTrackingRange(10).build("raccoon"));
    public static final RegistryObject<EntityType<Scorpion>> SCORPION = ENTITIES.register("scorpion", () -> EntityType.Builder.<Scorpion>of(Scorpion::new, MobCategory.CREATURE).sized(0.9F, 1.0F).clientTrackingRange(10).build("scorpion"));
    public static final RegistryObject<EntityType<Shark>> SHARK = ENTITIES.register("shark", () -> EntityType.Builder.<Shark>of(Shark::new, MobCategory.CREATURE).sized(0.9F, 0.6F).clientTrackingRange(10).build("shark"));
    public static final RegistryObject<EntityType<Sloth>> SLOTH = ENTITIES.register("sloth", () -> EntityType.Builder.<Sloth>of(Sloth::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("sloth"));
    public static final RegistryObject<EntityType<Stingray>> STINGRAY = ENTITIES.register("stingray", () -> EntityType.Builder.<Stingray>of(Stingray::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("stingray"));
    public static final RegistryObject<EntityType<Turkey>> TURKEY = ENTITIES.register("turkey", () -> EntityType.Builder.<Turkey>of(Turkey::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("turkey"));
    public static final RegistryObject<EntityType<Vulture>> VULTURE = ENTITIES.register("vulture", () -> EntityType.Builder.<Vulture>of(Vulture::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("vulture"));
    public static final RegistryObject<EntityType<Walrus>> WALRUS = ENTITIES.register("walrus", () -> EntityType.Builder.<Walrus>of(Walrus::new, MobCategory.CREATURE).sized(1.4F, 1.4F).clientTrackingRange(10).build("walrus"));
    public static final RegistryObject<EntityType<Zebra>> ZEBRA = ENTITIES.register("zebra", () -> EntityType.Builder.<Zebra>of(Zebra::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).clientTrackingRange(10).build("zebra"));
	
    /*
	 * MONSTERS
	 */
    
    public static final RegistryObject<EntityType<Peeper>> PEEPER = ENTITIES.register("peeper", () -> EntityType.Builder.<Peeper>of(Peeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(16).build("peeper"));
    public static final RegistryObject<EntityType<Sweeper>> SWEEPER = ENTITIES.register("sweeper", () -> EntityType.Builder.<Sweeper>of(Sweeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(8).build("sweeper"));
    
    /*
	 * VEHICLES
	 */
    
    public static final RegistryObject<EntityType<VanillaBoat>> MOD_BOAT = ENTITIES.register("mod_boat", () -> EntityType.Builder.<VanillaBoat>of(VanillaBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new VanillaBoat(world, 0, 0, 0)).clientTrackingRange(10).build("mod_boat"));
    
    /*
     * PROJECTILES
     */
    
    public static final RegistryObject<EntityType<Coconut>> COCONUT = ENTITIES.register("coconut", () -> EntityType.Builder.<Coconut>of(Coconut::new, MobCategory.MISC).sized(0.25F, 0.25F).setCustomClientFactory((spawnEntity, world) -> new Coconut(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(10).build("coconut"));
    public static final RegistryObject<EntityType<Dodgeball>> DODGEBALL = ENTITIES.register("dodgeball", () -> EntityType.Builder.<Dodgeball>of(Dodgeball::new, MobCategory.MISC).sized(0.25F, 0.25F).setCustomClientFactory((spawnEntity, world) -> new Dodgeball(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(10).build("dodgeball"));
    public static final RegistryObject<EntityType<Harpoon>> HARPOON = ENTITIES.register("harpoon", () -> EntityType.Builder.<Harpoon>of(Harpoon::new, MobCategory.MISC).sized(0.5F, 0.5F).setCustomClientFactory((spawnEntity, world) -> new Harpoon(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(20).build("harpoon"));
    
    /*
	 * OTHER
	 */
    
    public static final RegistryObject<EntityType<InvisibleSeat>> INVISIBLE_SEAT = ENTITIES.register("invisible_seat", () -> EntityType.Builder.<InvisibleSeat>of(InvisibleSeat::new, MobCategory.MISC).sized(0.1F, 0.1F).setCustomClientFactory((spawnEntity, world) -> new InvisibleSeat(world, 0, 0, 0)).clientTrackingRange(10).build("invisible_seat_entity"));
    public static final RegistryObject<EntityType<NavalMine>> NAVAL_MINE = ENTITIES.register("naval_mine", () -> EntityType.Builder.<NavalMine>of(NavalMine::new, MobCategory.MISC).sized(2.0F, 2.0F).setCustomClientFactory((spawnEntity, world) -> new NavalMine(world, 0, 0, 0)).clientTrackingRange(10).build("naval_mine_entity"));
}