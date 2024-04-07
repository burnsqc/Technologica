package com.technologica.world.item;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.technologica.client.renderer.blockentity.ExcitationRenderer;
import com.technologica.registration.deferred.TechnologicaEntityTypes;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class Excitation extends Item {
	private ResourceLocation BASE_MODEL_LOCATION;

	public Excitation(Properties properties, String name) {
		super(properties);
		BASE_MODEL_LOCATION = new TechnologicaLocation("item/" + name + "_base");
	}

	@Override
	public boolean isFoil(ItemStack itemStack) {
		return true;
	}

	@Override
	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
		consumer.accept(new IClientItemExtensions() {
			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				return new ExcitationRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), BASE_MODEL_LOCATION);
			}
		});
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		Optional<Vec3> block = getTargetedBlock(playerIn, 16);
		if (!block.isEmpty()) {
			LightningBolt lightningboltentity = TechnologicaEntityTypes.MAGIC_LIGHTNING.get().create(level);
			lightningboltentity.moveTo(block.get());
			level.addFreshEntity(lightningboltentity);
		}

		return InteractionResultHolder.consume(playerIn.getItemInHand(handIn));
	}

	private Optional<Vec3> getTargetedBlock(Player player, int range) {
		Predicate<Entity> predicate = (p_113447_) -> {
			return !p_113447_.isSpectator() && p_113447_.isPickable();
		};
		HitResult entityhitresult = ProjectileUtil.getHitResultOnViewVector(player, predicate, range);
		if (entityhitresult == null) {
			return Optional.empty();
		} else {
			return entityhitresult instanceof BlockHitResult ? Optional.of(entityhitresult.getLocation()) : Optional.empty();
		}
	}
}
