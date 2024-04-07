package com.technologica.world.item;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.technologica.client.renderer.blockentity.IgnitionRenderer;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

public class Ignition extends Item {
	private ResourceLocation BASE_MODEL_LOCATION;

	public Ignition(Properties properties, String name) {
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
				return new IgnitionRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), BASE_MODEL_LOCATION);
			}
		});
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level level, Player playerIn, InteractionHand handIn) {
		Optional<Entity> entity = getTargetedEntity(playerIn, 16);
		if (!entity.isEmpty()) {
			entity.get().setSecondsOnFire(5);
		}

		return InteractionResultHolder.consume(playerIn.getItemInHand(handIn));
	}

	private Optional<Entity> getTargetedEntity(Player player, int range) {
		if (player == null) {
			return Optional.empty();
		} else {
			Vec3 vec3 = player.getEyePosition();
			Vec3 vec31 = player.getViewVector(1.0F).scale(range);
			Vec3 vec32 = vec3.add(vec31);
			AABB aabb = player.getBoundingBox().expandTowards(vec31).inflate(1.0D);
			int i = range * range;
			Predicate<Entity> predicate = (p_113447_) -> {
				return !p_113447_.isSpectator() && p_113447_.isPickable();
			};
			EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(player, vec3, vec32, aabb, predicate, i);
			if (entityhitresult == null) {
				return Optional.empty();
			} else {
				return vec3.distanceToSqr(entityhitresult.getLocation()) > i ? Optional.empty() : Optional.of(entityhitresult.getEntity());
			}
		}
	}
}
