package com.technologica.world.entity.vehicle;

import java.util.function.IntFunction;

import com.technologica.registration.deferred.TechnologicaBlocks;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.registration.deferred.TechnologicaItems;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class TechnologicaBoat extends Boat {
	private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(Boat.class, EntityDataSerializers.INT);

	public TechnologicaBoat(EntityType<? extends Boat> boat, Level level) {
		super(boat, level);
	}

	public TechnologicaBoat(Level level, double posX, double posY, double posZ) {
		this(TechnologicaEntityTypes.TECHNOLOGICA_BOAT.get(), level);
		this.setPos(posX, posY, posZ);
		this.xo = posX;
		this.yo = posY;
		this.zo = posZ;
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_ID_TYPE, TechnologicaBoat.Type.APRICOT.ordinal());
	}

	public void setVariant(TechnologicaBoat.Type type) {
		this.entityData.set(DATA_ID_TYPE, type.ordinal());
	}

	public TechnologicaBoat.Type getTechnologicaVariant() {
		return TechnologicaBoat.Type.byId(this.entityData.get(DATA_ID_TYPE));
	}

	@Override
	protected void addAdditionalSaveData(CompoundTag compoundTag) {
		compoundTag.putString("Type", this.getTechnologicaVariant().getSerializedName());
	}

	@Override
	protected void readAdditionalSaveData(CompoundTag compoundTag) {
		if (compoundTag.contains("Type", 8)) {
			this.setVariant(TechnologicaBoat.Type.byName(compoundTag.getString("Type")));
		}

	}

	@Override
	public Item getDropItem() {
		switch (this.getTechnologicaVariant()) {
		case ALCHEMICAL:
			return TechnologicaItems.ALCHEMICAL_BOAT.get();
		case APRICOT:
			return TechnologicaItems.APRICOT_BOAT.get();
		case ASPEN:
			return TechnologicaItems.ASPEN_BOAT.get();
		case AVOCADO:
			return TechnologicaItems.AVOCADO_BOAT.get();
		case BANANA:
			return TechnologicaItems.BANANA_BOAT.get();
		case BENEVOLENT:
			return TechnologicaItems.BENEVOLENT_BOAT.get();
		case CHERRY:
			return TechnologicaItems.CHERRY_BOAT.get();
		case CHESTNUT:
			return TechnologicaItems.CHESTNUT_BOAT.get();
		case CINNAMON:
			return TechnologicaItems.CINNAMON_BOAT.get();
		case COCONUT:
			return TechnologicaItems.COCONUT_BOAT.get();
		case CONDUCTIVE:
			return TechnologicaItems.CONDUCTIVE_BOAT.get();
		case EBONY:
			return TechnologicaItems.EBONY_BOAT.get();
		case FROSTBITTEN:
			return TechnologicaItems.FROSTBITTEN_BOAT.get();
		case FRUITFUL:
			return TechnologicaItems.FRUITFUL_BOAT.get();
		case INFERNAL:
			return TechnologicaItems.INFERNAL_BOAT.get();
		case KIWI:
			return TechnologicaItems.KIWI_BOAT.get();
		case LEMON:
			return TechnologicaItems.LEMON_BOAT.get();
		case LIME:
			return TechnologicaItems.LIME_BOAT.get();
		case MAHOGANY:
			return TechnologicaItems.MAHOGANY_BOAT.get();
		case MALEVOLENT:
			return TechnologicaItems.MALEVOLENT_BOAT.get();
		case MAPLE:
			return TechnologicaItems.MAPLE_BOAT.get();
		case OLIVE:
			return TechnologicaItems.OLIVE_BOAT.get();
		case ORANGE:
			return TechnologicaItems.ORANGE_BOAT.get();
		case PEACH:
			return TechnologicaItems.PEACH_BOAT.get();
		case PEAR:
			return TechnologicaItems.PEAR_BOAT.get();
		case PLUM:
			return TechnologicaItems.PLUM_BOAT.get();
		case REDWOOD:
			return TechnologicaItems.REDWOOD_BOAT.get();
		case ROSEWOOD:
			return TechnologicaItems.ROSEWOOD_BOAT.get();
		case RUBBER:
			return TechnologicaItems.RUBBER_BOAT.get();
		case TEAK:
			return TechnologicaItems.TEAK_BOAT.get();
		case WALNUT:
			return TechnologicaItems.WALNUT_BOAT.get();
		case ZEBRAWOOD:
			return TechnologicaItems.ZEBRAWOOD_BOAT.get();
		default:
			return TechnologicaItems.APRICOT_BOAT.get();
		}
	}

	public static enum Type implements StringRepresentable {
		APRICOT(TechnologicaBlocks.APRICOT_PLANKS.get(), "apricot"),
		ASPEN(TechnologicaBlocks.ASPEN_PLANKS.get(), "aspen"),
		AVOCADO(TechnologicaBlocks.AVOCADO_PLANKS.get(), "avocado"),
		BANANA(TechnologicaBlocks.BANANA_PLANKS.get(), "banana"),
		CHERRY(TechnologicaBlocks.CHERRY_PLANKS.get(), "cherry"),
		CHESTNUT(TechnologicaBlocks.CHESTNUT_PLANKS.get(), "chestnut"),
		CINNAMON(TechnologicaBlocks.CINNAMON_PLANKS.get(), "cinnamon"),
		COCONUT(TechnologicaBlocks.COCONUT_PLANKS.get(), "coconut"),
		EBONY(TechnologicaBlocks.EBONY_PLANKS.get(), "ebony"),
		KIWI(TechnologicaBlocks.KIWI_PLANKS.get(), "kiwi"),
		LEMON(TechnologicaBlocks.LEMON_PLANKS.get(), "lemon"),
		LIME(TechnologicaBlocks.LIME_PLANKS.get(), "lime"),
		MAHOGANY(TechnologicaBlocks.MAHOGANY_PLANKS.get(), "mahogany"),
		MAPLE(TechnologicaBlocks.MAPLE_PLANKS.get(), "maple"),
		OLIVE(TechnologicaBlocks.OLIVE_PLANKS.get(), "olive"),
		ORANGE(TechnologicaBlocks.ORANGE_PLANKS.get(), "orange"),
		PEACH(TechnologicaBlocks.PEACH_PLANKS.get(), "peach"),
		PEAR(TechnologicaBlocks.PEAR_PLANKS.get(), "pear"),
		PLUM(TechnologicaBlocks.PLUM_PLANKS.get(), "plum"),
		REDWOOD(TechnologicaBlocks.REDWOOD_PLANKS.get(), "redwood"),
		ROSEWOOD(TechnologicaBlocks.ROSEWOOD_PLANKS.get(), "rosewood"),
		RUBBER(TechnologicaBlocks.RUBBER_PLANKS.get(), "rubber"),
		TEAK(TechnologicaBlocks.TEAK_PLANKS.get(), "teak"),
		WALNUT(TechnologicaBlocks.WALNUT_PLANKS.get(), "walnut"),
		ZEBRAWOOD(TechnologicaBlocks.ZEBRAWOOD_PLANKS.get(), "zebrawood"),
		ALCHEMICAL(TechnologicaBlocks.ALCHEMICAL_PLANKS.get(), "alchemical"),
		BENEVOLENT(TechnologicaBlocks.BENEVOLENT_PLANKS.get(), "benevolent"),
		CONDUCTIVE(TechnologicaBlocks.CONDUCTIVE_PLANKS.get(), "conductive"),
		FROSTBITTEN(TechnologicaBlocks.FROSTBITTEN_PLANKS.get(), "frostbitten"),
		FRUITFUL(TechnologicaBlocks.FRUITFUL_PLANKS.get(), "fruitful"),
		INFERNAL(TechnologicaBlocks.INFERNAL_PLANKS.get(), "infernal"),
		MALEVOLENT(TechnologicaBlocks.MALEVOLENT_PLANKS.get(), "malevolent");

		private final String name;
		private final Block planks;
		@SuppressWarnings("deprecation")
		public static final StringRepresentable.EnumCodec<TechnologicaBoat.Type> CODEC = StringRepresentable.fromEnum(TechnologicaBoat.Type::values);
		private static final IntFunction<TechnologicaBoat.Type> BY_ID = ByIdMap.continuous(Enum::ordinal, values(), ByIdMap.OutOfBoundsStrategy.ZERO);

		private Type(Block block, String name) {
			this.name = name;
			this.planks = block;
		}

		@Override
		public String getSerializedName() {
			return this.name;
		}

		public String getName() {
			return this.name;
		}

		public Block getPlanks() {
			return this.planks;
		}

		@Override
		public String toString() {
			return this.name;
		}

		public static TechnologicaBoat.Type byId(int id) {
			return BY_ID.apply(id);
		}

		@SuppressWarnings("deprecation")
		public static TechnologicaBoat.Type byName(String name) {
			return CODEC.byName(name, APRICOT);
		}
	}
}
