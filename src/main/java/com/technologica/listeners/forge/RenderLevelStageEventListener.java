package com.technologica.listeners.forge;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.BufferBuilder.RenderedBuffer;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.Tesselator;
import com.mojang.blaze3d.vertex.VertexBuffer;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.technologica.registration.deferred.TechnologicaItems;
import com.technologica.registration.deferred.TechnologicaMobEffects;
import com.technologica.registration.deferred.TechnologicaSoundEvents;
import com.technologica.util.math.MathHelper;
import com.technologica.util.text.TechnologicaLocation;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLevelStageEvent;
import net.minecraftforge.client.event.RenderLevelStageEvent.Stage;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@Mod.EventBusSubscriber(bus = EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class RenderLevelStageEventListener {
	private static VertexBuffer sonarBuffer;
	private static int timer;
	private static BlockPos[] sonarBlocks;
	private static BlockPos origin;
	private static final ResourceLocation NIGHT_VISION = new TechnologicaLocation("shaders/post/night_vision.json");
	private static final ResourceLocation INVERSE = new ResourceLocation("shaders/post/invert.json");

	@SubscribeEvent
	public static void onRenderLevelStageEvent(final RenderLevelStageEvent event) {
		Minecraft minecraft = Minecraft.getInstance();
		LocalPlayer localPlayer = minecraft.player;

//		if (event.getStage() == Stage.AFTER_ENTITIES) {
//			Vec3 vec3 = event.getCamera().getPosition();
//			double d0 = vec3.x();
//			double d1 = vec3.y();
//			double d2 = vec3.z();
//			for (Entity entity : minecraft.level.entitiesForRendering()) {
//				if (entity != localPlayer && entity instanceof LivingEntity) {
//					if (minecraft.getEntityRenderDispatcher().shouldRender(entity, event.getFrustum(), d0, d1, d2) || entity.hasIndirectPassenger(localPlayer)) {
//
//						if (entity.tickCount == 0) {
//							entity.xOld = entity.getX();
//							entity.yOld = entity.getY();
//							entity.zOld = entity.getZ();
//						}
//						MultiBufferSource multibuffersource;
//						OutlineBufferSource outlinebuffersource = minecraft.renderBuffers().outlineBufferSource();
//						multibuffersource = outlinebuffersource;
//						int i = entity.getTeamColor();
//						outlinebuffersource.setColor(FastColor.ARGB32.red(i), FastColor.ARGB32.green(0), FastColor.ARGB32.blue(i), 255);
//						renderEntity(entity, d0, d1, d2, event.getPartialTick(), event.getPoseStack(), multibuffersource);
//					}
//				}
//			}
//		}


		// loadEffectOnCondition(minecraft, true, LIFESIGHT);
		loadEffectOnCondition(minecraft, localPlayer.getItemBySlot(EquipmentSlot.HEAD).getItem() == TechnologicaItems.NIGHT_VISION_GOGGLES.get(), NIGHT_VISION);
		loadEffectOnCondition(minecraft, localPlayer.hasEffect(TechnologicaMobEffects.HALLUCINIATION.get()), INVERSE);

		if (event.getStage() == Stage.AFTER_SOLID_BLOCKS && timer > 0) {
			MultiBufferSource.BufferSource multibuffersource$buffersource = minecraft.renderBuffers().bufferSource();
			VertexConsumer vertexConsumer = multibuffersource$buffersource.getBuffer(RenderType.lines());
			BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();

			sonarBuffer = new VertexBuffer(VertexBuffer.Usage.STATIC);
			if (sonarBlocks != null) {

				minecraft.getProfiler().push("sonar");
				BufferBuilder.RenderedBuffer bufferbuilder$renderedbuffer = buildSonar(bufferbuilder, vertexConsumer, event.getPoseStack(), event.getCamera().getEntity(), event);
				minecraft.getProfiler().pop();

				sonarBuffer.bind();
				sonarBuffer.upload(bufferbuilder$renderedbuffer);
				VertexBuffer.unbind();
				// sonarBuffer.close();
			}
		}

		if (timer == 1800) {
			localPlayer.playSound(TechnologicaSoundEvents.SONAR.get());
		}

		if (timer > 0) {
			timer--;
		}

		if (timer == 0) {
			sonarBlocks = null;
		}
	}

	private static RenderedBuffer buildSonar(BufferBuilder bufferBuilder, VertexConsumer vertexConsumer, PoseStack poseStack, Entity entity, final RenderLevelStageEvent event) {
		Minecraft minecraft = Minecraft.getInstance();
		bufferBuilder.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);

		// First ignore all blocks outside the player's frustum (field of view)
		minecraft.getProfiler().push("frustum_culling");
		List<BlockPos> sonarBlocksFrustumCulled = Arrays.stream(sonarBlocks).filter((sonarBlockPos) -> event.getFrustum().isVisible(minecraft.level.getBlockState(sonarBlockPos).getShape(minecraft.level, sonarBlockPos, CollisionContext.of(entity)).bounds().move(sonarBlockPos))).collect(Collectors.toList());
		minecraft.getProfiler().pop();
		
		// Second ignore all blocks that are fully culled
		minecraft.getProfiler().push("occlusion_culling");
		List<BlockPos> sonarBlocksOcclusionCulled = sonarBlocksFrustumCulled.stream().filter((sonarBlockPos) -> {
			boolean occluded = true;
			// for (Direction direction : Direction.values()) {
			// occluded = occluded & !Block.shouldRenderFace(minecraft.level.getBlockState(sonarBlockPos), minecraft.level, sonarBlockPos, direction, sonarBlockPos.relative(direction));
			// }
			return occluded;
		}).collect(Collectors.toList());
		minecraft.getProfiler().pop();
		
		minecraft.getProfiler().push("sonar_loop");
		sonarBlocksOcclusionCulled.forEach((sonarBlockPos) -> {

			minecraft.getProfiler().push("calculate_distance");
			float distance = MathHelper.trueBlockPosDistance(sonarBlockPos.getX(), sonarBlockPos.getY(), sonarBlockPos.getZ(), origin.getX(), origin.getY(), origin.getZ());
			minecraft.getProfiler().pop();

			minecraft.getProfiler().push("calculate_wave");
			float alpha = Mth.clamp(distance + (timer - minecraft.getPartialTick() - 1650) / 50 < 1 ? distance + (timer - minecraft.getPartialTick() - 1600) / 50 : Mth.clamp(-distance + (-timer - minecraft.getPartialTick() + 1800) / 50, 0.0F, 1.0F), -1.0F, 1.0F) * (1 - distance / 32);
			minecraft.getProfiler().pop();

			// Third only act upon blocks that are in the sonar wave
			minecraft.getProfiler().push("render");
			if (alpha > 0) {
				Vec3 vec3 = event.getCamera().getPosition();
				minecraft.getProfiler().push("voxel");
				renderOutline(poseStack, vertexConsumer, minecraft.level.getBlockState(sonarBlockPos).getCollisionShape(minecraft.level, sonarBlockPos, CollisionContext.of(entity)), sonarBlockPos.getX() - vec3.x(), sonarBlockPos.getY() - vec3.y(), sonarBlockPos.getZ() - vec3.z(), alpha);
				minecraft.getProfiler().pop();
			}
			minecraft.getProfiler().pop();
		});
		minecraft.getProfiler().pop();
		return bufferBuilder.end();
	}

	private static void renderOutline(PoseStack poseStack, VertexConsumer vertexConsumer, VoxelShape voxelShape, double posX2, double posY2, double posZ2, float alpha) {
		PoseStack.Pose posestack$pose = poseStack.last();
		voxelShape.forAllEdges((voxelX1, voxelY1, voxelZ1, voxelX2, voxelY2, voxelZ2) -> {
			float lengthX = (float) (voxelX2 - voxelX1);
			float lengthY = (float) (voxelY2 - voxelY1);
			float lengthZ = (float) (voxelZ2 - voxelZ1);
			float length = Mth.sqrt(lengthX * lengthX + lengthY * lengthY + lengthZ * lengthZ);
			lengthX /= length;
			lengthY /= length;
			lengthZ /= length;
			vertexConsumer.vertex(posestack$pose.pose(), (float) (voxelX1 + posX2), (float) (voxelY1 + posY2), (float) (voxelZ1 + posZ2)).color(0, 1, 0, alpha).normal(posestack$pose.normal(), lengthX, lengthY, lengthZ).endVertex();
			vertexConsumer.vertex(posestack$pose.pose(), (float) (voxelX2 + posX2), (float) (voxelY2 + posY2), (float) (voxelZ2 + posZ2)).color(0, 1, 0, alpha).normal(posestack$pose.normal(), lengthX, lengthY, lengthZ).endVertex();
		});
	}

	public static void setBlocks(BlockPos[] blocks, BlockPos playerPos) {
		timer = 1800;
		sonarBlocks = blocks;
		origin = playerPos;
	}

	private static void loadEffectOnCondition(Minecraft minecraft, boolean condition, ResourceLocation effect) {
		if (condition) {
			if (minecraft.gameRenderer.currentEffect() == null) {
				minecraft.gameRenderer.loadEffect(effect);
			}
		} else {
			if (minecraft.gameRenderer.currentEffect() != null) {
				if (minecraft.gameRenderer.currentEffect().getName().equals(effect.toString())) {
					minecraft.gameRenderer.shutdownEffect();
				}
			}
		}
	}

//	private static void renderEntity(Entity pEntity, double pCamX, double pCamY, double pCamZ, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBufferSource) {
//		double d0 = Mth.lerp(pPartialTick, pEntity.xOld, pEntity.getX());
//		double d1 = Mth.lerp(pPartialTick, pEntity.yOld, pEntity.getY());
//		double d2 = Mth.lerp(pPartialTick, pEntity.zOld, pEntity.getZ());
//		float f = Mth.lerp(pPartialTick, pEntity.yRotO, pEntity.getYRot());
//		Minecraft.getInstance().getEntityRenderDispatcher().render(pEntity, d0 - pCamX, d1 - pCamY, d2 - pCamZ, f, pPartialTick, pPoseStack, pBufferSource, Minecraft.getInstance().getEntityRenderDispatcher().getPackedLightCoords(pEntity, pPartialTick));
//	}
}
