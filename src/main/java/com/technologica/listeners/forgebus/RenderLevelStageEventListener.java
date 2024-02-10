package com.technologica.listeners.forgebus;

import com.mojang.blaze3d.vertex.PoseStack;
import com.technologica.registration.deferred.TechnologicaMobEffects;

import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class RenderLevelStageEventListener {
	@SubscribeEvent
	public void onRenderLevelStageEvent(final RenderLevelStageEvent event) {

		PoseStack poseStack = event.getPoseStack();
		Minecraft minecraft = Minecraft.getInstance();
		ClientLevel level = minecraft.level;
		LocalPlayer localPlayer = minecraft.player;
		float partialTick = minecraft.getPartialTick();
		EntityRenderDispatcher entityRenderDispatcher = minecraft.getEntityRenderDispatcher();
		RenderBuffers renderBuffers = minecraft.renderBuffers();
		Vec3 vec3 = event.getCamera().getPosition();
		double d0 = vec3.x();
		double d1 = vec3.y();
		double d2 = vec3.z();
		LevelRenderer levelRenderer = event.getLevelRenderer();
		Camera camera = event.getCamera();
		Frustum frustum = event.getFrustum();

		if (localPlayer.hasEffect(TechnologicaMobEffects.LIFESIGHT.get())) {
			if (event.getStage() == Stage.AFTER_PARTICLES) {
				for (Entity entity : level.entitiesForRendering()) {
					if ((entityRenderDispatcher.shouldRender(entity, frustum, d0, d1, d2) || entity.hasIndirectPassenger(minecraft.player)) && entity instanceof LivingEntity) {
						BlockPos blockpos = entity.blockPosition();
						if ((level.isOutsideBuildHeight(blockpos.getY()) || levelRenderer.isChunkCompiled(blockpos)) && (entity != camera.getEntity() || camera.isDetached() || camera.getEntity() instanceof LivingEntity && ((LivingEntity) camera.getEntity()).isSleeping()) && (!(entity instanceof LocalPlayer) || camera.getEntity() == entity || (entity == minecraft.player && !minecraft.player.isSpectator()))) {
							if (entity.tickCount == 0) {
								entity.xOld = entity.getX();
								entity.yOld = entity.getY();
								entity.zOld = entity.getZ();
							}
							MultiBufferSource multibuffersource;
							OutlineBufferSource outlinebuffersource = renderBuffers.outlineBufferSource();
							multibuffersource = outlinebuffersource;
							outlinebuffersource.setColor((int) (255 * (Mth.sin((event.getRenderTick() + partialTick) / 10) + 1) / 2), 0, (int) (255 * (Mth.sin((event.getRenderTick() + partialTick) / 10) + 1) / 2), 50);
							this.renderEntity(entity, d0, d1, d2, partialTick, poseStack, multibuffersource, entityRenderDispatcher);
						}
					}
				}
			}
		}
	}

	private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float partialTick, PoseStack poseStack, MultiBufferSource multiBufferSource, EntityRenderDispatcher entityRenderDispatcher) {
		double d0 = Mth.lerp(partialTick, entity.xOld, entity.getX());
		double d1 = Mth.lerp(partialTick, entity.yOld, entity.getY());
		double d2 = Mth.lerp(partialTick, entity.zOld, entity.getZ());
		float f = Mth.lerp(partialTick, entity.yRotO, entity.getYRot());
		entityRenderDispatcher.render(entity, d0 - cameraX, d1 - cameraY, d2 - cameraZ, f, partialTick, poseStack, multiBufferSource, entityRenderDispatcher.getPackedLightCoords(entity, partialTick));
	}
}