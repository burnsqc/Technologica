package com.technologica.registration.deferred;

import com.technologica.Technologica;
import com.technologica.registration.deferred.util.MasterDeferredRegistrar;
import com.technologica.world.entity.animal.Alligator;
import com.technologica.world.entity.animal.Beaver;
import com.technologica.world.entity.animal.Buffalo;
import com.technologica.world.entity.animal.Cobra;
import com.technologica.world.entity.animal.Cottonmouth;
import com.technologica.world.entity.animal.Coyote;
import com.technologica.world.entity.animal.Crab;
import com.technologica.world.entity.animal.Deer;
import com.technologica.world.entity.animal.Duck;
import com.technologica.world.entity.animal.Elephant;
import com.technologica.world.entity.animal.FigureEightPufferfish;
import com.technologica.world.entity.animal.Flamingo;
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
import com.technologica.world.entity.monster.AtomicCreeper;
import com.technologica.world.entity.monster.Beeper;
import com.technologica.world.entity.monster.DustDevil;
import com.technologica.world.entity.monster.Mummy;
import com.technologica.world.entity.monster.Peeper;
import com.technologica.world.entity.monster.Sleeper;
import com.technologica.world.entity.monster.Sweeper;
import com.technologica.world.entity.monster.Weeper;
import com.technologica.world.entity.projectile.Coconut;
import com.technologica.world.entity.projectile.Dodgeball;
import com.technologica.world.entity.projectile.Harpoon;
import com.technologica.world.entity.projectile.Meteor;
import com.technologica.world.entity.vehicle.Rocket;
import com.technologica.world.entity.vehicle.TechnologicaBoat;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.RegistryObject;

/**
 * <p>
 * This class contains Registry Objects for Entity Types.
 * The {@link #init} method is called by {@link Technologica#initDeferredRegisters} and returns a head-count to later be checked during registration and other setup activities.
 * </p>
 * 
 * @tl.status GREEN
 */
public final class TechnologicaEntityTypes extends MasterDeferredRegistrar {

	public static int init() {
		return ENTITY_TYPES.getEntries().size();
	}

	public static final RegistryObject<EntityType<Alligator>> ALLIGATOR = ENTITY_TYPES.register("alligator", () -> EntityType.Builder.<Alligator>of(Alligator::new, MobCategory.CREATURE).sized(1.5F, 0.5F).clientTrackingRange(10).build("alligator"));
	public static final RegistryObject<EntityType<Beaver>> BEAVER = ENTITY_TYPES.register("beaver", () -> EntityType.Builder.<Beaver>of(Beaver::new, MobCategory.CREATURE).sized(0.6F, 0.5F).clientTrackingRange(10).build("beaver"));
	public static final RegistryObject<EntityType<Buffalo>> BUFFALO = ENTITY_TYPES.register("buffalo", () -> EntityType.Builder.<Buffalo>of(Buffalo::new, MobCategory.CREATURE).sized(1.5F, 1.7F).clientTrackingRange(10).build("buffalo"));
	public static final RegistryObject<EntityType<Cobra>> COBRA = ENTITY_TYPES.register("cobra", () -> EntityType.Builder.<Cobra>of(Cobra::new, MobCategory.CREATURE).sized(1.4F, 0.1F).clientTrackingRange(10).build("cobra"));
	public static final RegistryObject<EntityType<Cottonmouth>> COTTONMOUTH = ENTITY_TYPES.register("cottonmouth", () -> EntityType.Builder.<Cottonmouth>of(Cottonmouth::new, MobCategory.CREATURE).sized(1.4F, 0.1F).clientTrackingRange(10).build("cottonmouth"));
	public static final RegistryObject<EntityType<Coyote>> COYOTE = ENTITY_TYPES.register("coyote", () -> EntityType.Builder.<Coyote>of(Coyote::new, MobCategory.CREATURE).sized(0.6F, 0.85F).clientTrackingRange(10).build("coyote"));
	public static final RegistryObject<EntityType<Crab>> CRAB = ENTITY_TYPES.register("crab", () -> EntityType.Builder.<Crab>of(Crab::new, MobCategory.CREATURE).sized(0.5F, 0.3F).clientTrackingRange(10).build("crab"));
	public static final RegistryObject<EntityType<Deer>> DEER = ENTITY_TYPES.register("deer", () -> EntityType.Builder.<Deer>of(Deer::new, MobCategory.CREATURE).sized(1.0F, 1.5F).clientTrackingRange(10).build("deer"));
	public static final RegistryObject<EntityType<Duck>> DUCK = ENTITY_TYPES.register("duck", () -> EntityType.Builder.<Duck>of(Duck::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("duck"));
	public static final RegistryObject<EntityType<Elephant>> ELEPHANT = ENTITY_TYPES.register("elephant", () -> EntityType.Builder.<Elephant>of(Elephant::new, MobCategory.CREATURE).sized(3.0F, 3.0F).clientTrackingRange(10).build("elephant"));
	public static final RegistryObject<EntityType<Flamingo>> FLAMINGO = ENTITY_TYPES.register("flamingo", () -> EntityType.Builder.<Flamingo>of(Flamingo::new, MobCategory.CREATURE).sized(0.6F, 1.7F).clientTrackingRange(10).build("flamingo"));
	public static final RegistryObject<EntityType<FigureEightPufferfish>> FIGURE_EIGHT_PUFFERFISH = ENTITY_TYPES.register("figure_eight_pufferfish", () -> EntityType.Builder.<FigureEightPufferfish>of(FigureEightPufferfish::new, MobCategory.WATER_AMBIENT).sized(0.7F, 0.7F).clientTrackingRange(4).build("figure_eight_pufferfish"));
	public static final RegistryObject<EntityType<Giraffe>> GIRAFFE = ENTITY_TYPES.register("giraffe", () -> EntityType.Builder.<Giraffe>of(Giraffe::new, MobCategory.CREATURE).sized(1.4F, 5.0F).clientTrackingRange(20).build("giraffe"));
	public static final RegistryObject<EntityType<Gorilla>> GORILLA = ENTITY_TYPES.register("gorilla", () -> EntityType.Builder.<Gorilla>of(Gorilla::new, MobCategory.CREATURE).sized(1.0F, 1.4F).clientTrackingRange(10).build("gorilla"));
	public static final RegistryObject<EntityType<GrizzlyBear>> GRIZZLY_BEAR = ENTITY_TYPES.register("grizzly_bear", () -> EntityType.Builder.<GrizzlyBear>of(GrizzlyBear::new, MobCategory.CREATURE).sized(1.4F, 1.4F).clientTrackingRange(10).build("grizzly_bear"));
	public static final RegistryObject<EntityType<Jaguar>> JAGUAR = ENTITY_TYPES.register("jaguar", () -> EntityType.Builder.<Jaguar>of(Jaguar::new, MobCategory.CREATURE).sized(1.0F, 1.2F).clientTrackingRange(10).build("jaguar"));
	public static final RegistryObject<EntityType<KingCrab>> KING_CRAB = ENTITY_TYPES.register("king_crab", () -> EntityType.Builder.<KingCrab>of(KingCrab::new, MobCategory.CREATURE).sized(2.0F, 1.3F).clientTrackingRange(10).build("king_crab"));
	public static final RegistryObject<EntityType<LeopardSeal>> LEOPARD_SEAL = ENTITY_TYPES.register("leopard_seal", () -> EntityType.Builder.<LeopardSeal>of(LeopardSeal::new, MobCategory.CREATURE).sized(1.5F, 0.7F).clientTrackingRange(10).build("leopard_seal"));
	public static final RegistryObject<EntityType<Lion>> LION = ENTITY_TYPES.register("lion", () -> EntityType.Builder.<Lion>of(Lion::new, MobCategory.CREATURE).sized(1.2F, 1.3F).clientTrackingRange(10).build("lion"));
	public static final RegistryObject<EntityType<Lizard>> LIZARD = ENTITY_TYPES.register("lizard", () -> EntityType.Builder.<Lizard>of(Lizard::new, MobCategory.CREATURE).sized(0.5F, 0.3F).clientTrackingRange(10).build("lizard"));
	public static final RegistryObject<EntityType<Moose>> MOOSE = ENTITY_TYPES.register("moose", () -> EntityType.Builder.<Moose>of(Moose::new, MobCategory.CREATURE).sized(1.8F, 2.3F).clientTrackingRange(10).build("moose"));
	public static final RegistryObject<EntityType<Narwhal>> NARWHAL = ENTITY_TYPES.register("narwhal", () -> EntityType.Builder.<Narwhal>of(Narwhal::new, MobCategory.CREATURE).sized(1.5F, 0.5F).clientTrackingRange(10).build("narwhal"));
	public static final RegistryObject<EntityType<Octopus>> OCTOPUS = ENTITY_TYPES.register("octopus", () -> EntityType.Builder.<Octopus>of(Octopus::new, MobCategory.CREATURE).sized(1.0F, 0.9F).clientTrackingRange(10).build("octopus"));
	public static final RegistryObject<EntityType<Ostrich>> OSTRICH = ENTITY_TYPES.register("ostrich", () -> EntityType.Builder.<Ostrich>of(Ostrich::new, MobCategory.CREATURE).sized(1.0F, 2.3F).clientTrackingRange(10).build("ostrich"));
	public static final RegistryObject<EntityType<Owl>> OWL = ENTITY_TYPES.register("owl", () -> EntityType.Builder.<Owl>of(Owl::new, MobCategory.CREATURE).sized(0.4F, 0.7F).clientTrackingRange(10).build("owl"));
	public static final RegistryObject<EntityType<Penguin>> PENGUIN = ENTITY_TYPES.register("penguin", () -> EntityType.Builder.<Penguin>of(Penguin::new, MobCategory.CREATURE).sized(0.5F, 1.3F).clientTrackingRange(10).build("penguin"));
	public static final RegistryObject<EntityType<Piranha>> PIRANHA = ENTITY_TYPES.register("piranha", () -> EntityType.Builder.<Piranha>of(Piranha::new, MobCategory.WATER_AMBIENT).sized(0.5F, 0.4F).clientTrackingRange(4).build("piranha"));
	public static final RegistryObject<EntityType<PoisonDartFrog>> POISON_DART_FROG = ENTITY_TYPES.register("poison_dart_frog", () -> EntityType.Builder.<PoisonDartFrog>of(PoisonDartFrog::new, MobCategory.CREATURE).sized(0.4F, 0.4F).clientTrackingRange(10).build("poison_dart_frog"));
	public static final RegistryObject<EntityType<Raccoon>> RACCOON = ENTITY_TYPES.register("raccoon", () -> EntityType.Builder.<Raccoon>of(Raccoon::new, MobCategory.CREATURE).sized(0.7F, 0.6F).clientTrackingRange(10).build("raccoon"));
	public static final RegistryObject<EntityType<Scorpion>> SCORPION = ENTITY_TYPES.register("scorpion", () -> EntityType.Builder.<Scorpion>of(Scorpion::new, MobCategory.CREATURE).sized(1.4F, 0.9F).clientTrackingRange(10).build("scorpion"));
	public static final RegistryObject<EntityType<Shark>> SHARK = ENTITY_TYPES.register("shark", () -> EntityType.Builder.<Shark>of(Shark::new, MobCategory.CREATURE).sized(2.0F, 0.8F).clientTrackingRange(10).build("shark"));
	public static final RegistryObject<EntityType<Sloth>> SLOTH = ENTITY_TYPES.register("sloth", () -> EntityType.Builder.<Sloth>of(Sloth::new, MobCategory.CREATURE).sized(0.8F, 0.7F).clientTrackingRange(10).build("sloth"));
	public static final RegistryObject<EntityType<Stingray>> STINGRAY = ENTITY_TYPES.register("stingray", () -> EntityType.Builder.<Stingray>of(Stingray::new, MobCategory.CREATURE).sized(1.0F, 0.2F).clientTrackingRange(10).build("stingray"));
	public static final RegistryObject<EntityType<Turkey>> TURKEY = ENTITY_TYPES.register("turkey", () -> EntityType.Builder.<Turkey>of(Turkey::new, MobCategory.CREATURE).sized(0.6F, 0.9F).clientTrackingRange(10).build("turkey"));
	public static final RegistryObject<EntityType<Vulture>> VULTURE = ENTITY_TYPES.register("vulture", () -> EntityType.Builder.<Vulture>of(Vulture::new, MobCategory.CREATURE).sized(1.2F, 0.5F).clientTrackingRange(10).build("vulture"));
	public static final RegistryObject<EntityType<Walrus>> WALRUS = ENTITY_TYPES.register("walrus", () -> EntityType.Builder.<Walrus>of(Walrus::new, MobCategory.CREATURE).sized(1.7F, 1.4F).clientTrackingRange(10).build("walrus"));
	public static final RegistryObject<EntityType<Zebra>> ZEBRA = ENTITY_TYPES.register("zebra", () -> EntityType.Builder.<Zebra>of(Zebra::new, MobCategory.CREATURE).sized(1.3964844F, 1.6F).clientTrackingRange(10).build("zebra"));
	public static final RegistryObject<EntityType<AtomicCreeper>> ATOMIC_CREEPER = ENTITY_TYPES.register("atomic_creeper", () -> EntityType.Builder.<AtomicCreeper>of(AtomicCreeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(16).build("atomic_creeper"));
	public static final RegistryObject<EntityType<Mummy>> MUMMY = ENTITY_TYPES.register("mummy", () -> EntityType.Builder.<Mummy>of(Mummy::new, MobCategory.MONSTER).sized(0.6F, 1.95F).clientTrackingRange(8).build("mummy"));
	public static final RegistryObject<EntityType<Peeper>> PEEPER = ENTITY_TYPES.register("peeper", () -> EntityType.Builder.<Peeper>of(Peeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(16).build("peeper"));
	public static final RegistryObject<EntityType<Beeper>> BEEPER = ENTITY_TYPES.register("beeper", () -> EntityType.Builder.<Beeper>of(Beeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(16).build("beeper"));
	public static final RegistryObject<EntityType<Sleeper>> SLEEPER = ENTITY_TYPES.register("sleeper", () -> EntityType.Builder.<Sleeper>of(Sleeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(16).build("sleeper"));
	public static final RegistryObject<EntityType<Weeper>> WEEPER = ENTITY_TYPES.register("weeper", () -> EntityType.Builder.<Weeper>of(Weeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(16).build("weeper"));
	public static final RegistryObject<EntityType<Sweeper>> SWEEPER = ENTITY_TYPES.register("sweeper", () -> EntityType.Builder.<Sweeper>of(Sweeper::new, MobCategory.MONSTER).sized(0.6F, 1.7F).clientTrackingRange(8).build("sweeper"));
	public static final RegistryObject<EntityType<DustDevil>> DUST_DEVIL = ENTITY_TYPES.register("dust_devil", () -> EntityType.Builder.<DustDevil>of(DustDevil::new, MobCategory.MONSTER).sized(1.0F, 3.0F).clientTrackingRange(8).build("dust_devil"));

	public static final RegistryObject<EntityType<TechnologicaBoat>> TECHNOLOGICA_BOAT = ENTITY_TYPES.register("technologica_boat", () -> EntityType.Builder.<TechnologicaBoat>of(TechnologicaBoat::new, MobCategory.MISC).sized(1.375F, 0.5625F).build("technologica_boat")); // .setCustomClientFactory((spawnEntity, world) -> new TechnologicaBoat(world, 0, 0, 0)).clientTrackingRange(10)
	public static final RegistryObject<EntityType<Rocket>> ROCKET = ENTITY_TYPES.register("rocket", () -> EntityType.Builder.<Rocket>of(Rocket::new, MobCategory.MISC).sized(1.375F, 0.5625F).setCustomClientFactory((spawnEntity, world) -> new Rocket(world, 0, 0, 0)).clientTrackingRange(10).build("rocket"));
	public static final RegistryObject<EntityType<Coconut>> COCONUT = ENTITY_TYPES.register("coconut", () -> EntityType.Builder.<Coconut>of(Coconut::new, MobCategory.MISC).sized(0.25F, 0.25F).setCustomClientFactory((spawnEntity, world) -> new Coconut(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(10).build("coconut"));
	public static final RegistryObject<EntityType<Dodgeball>> DODGEBALL = ENTITY_TYPES.register("dodgeball", () -> EntityType.Builder.<Dodgeball>of(Dodgeball::new, MobCategory.MISC).sized(0.25F, 0.25F).setCustomClientFactory((spawnEntity, world) -> new Dodgeball(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(10).build("dodgeball"));
	public static final RegistryObject<EntityType<Harpoon>> HARPOON = ENTITY_TYPES.register("harpoon", () -> EntityType.Builder.<Harpoon>of(Harpoon::new, MobCategory.MISC).sized(0.5F, 0.5F).setCustomClientFactory((spawnEntity, world) -> new Harpoon(world, 0, 0, 0)).clientTrackingRange(4).updateInterval(20).build("harpoon"));
	public static final RegistryObject<EntityType<InvisibleSeat>> INVISIBLE_SEAT = ENTITY_TYPES.register("invisible_seat", () -> EntityType.Builder.<InvisibleSeat>of(InvisibleSeat::new, MobCategory.MISC).sized(0.1F, 0.1F).setCustomClientFactory((spawnEntity, world) -> new InvisibleSeat(world, 0, 0, 0)).clientTrackingRange(10).build("invisible_seat_entity"));
	public static final RegistryObject<EntityType<NavalMine>> NAVAL_MINE = ENTITY_TYPES.register("naval_mine", () -> EntityType.Builder.<NavalMine>of(NavalMine::new, MobCategory.MISC).sized(2.0F, 2.0F).setCustomClientFactory((spawnEntity, world) -> new NavalMine(world, 0, 0, 0)).clientTrackingRange(10).build("naval_mine_entity"));
	public static final RegistryObject<EntityType<Meteor>> METEOR = ENTITY_TYPES.register("meteor", () -> EntityType.Builder.<Meteor>of(Meteor::new, MobCategory.MISC).sized(1.0F, 1.0F).clientTrackingRange(4).updateInterval(10).build("meteor"));
}