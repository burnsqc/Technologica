package com.technologica.server.commands;

import java.util.ArrayList;
import java.util.List;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.technologica.listeners.forge.RenderLevelStageEventListener;
import com.technologica.util.math.MathHelper;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;

public class SonarCommand {
	static final LiteralArgumentBuilder<CommandSourceStack> COMMAND = Commands.literal("sonar").requires((commandSourceStack) -> commandSourceStack.hasPermission(2)).then(Commands.literal("ping").executes((commandContext) -> ping(commandContext.getSource(), -1)));

	private static int ping(CommandSourceStack stack, int duration) {
		int maxDistance = 32;
		BlockPos playerPos = stack.getPlayer().blockPosition();
		List<BlockPos> sonarBlocks = new ArrayList<BlockPos>();
		ServerLevel serverLevel = stack.getLevel();
		for (int posX = playerPos.getX() - maxDistance; posX < playerPos.getX() + maxDistance; posX++) {
			for (int posY = playerPos.getY() - maxDistance; posY < playerPos.getY() + maxDistance; posY++) {
				for (int posZ = playerPos.getZ() - maxDistance; posZ < playerPos.getZ() + maxDistance; posZ++) {
					BlockPos blockPos = new BlockPos(posX, posY, posZ);
					BlockState blockState = serverLevel.getBlockState(blockPos);

					// First ignore all "invisible" blocks like water
					if (blockState.getRenderShape() != RenderShape.INVISIBLE && !blockState.getCollisionShape(serverLevel, blockPos, CollisionContext.of(stack.getPlayer())).isEmpty()) {
						float distance = MathHelper.trueBlockPosDistance(blockPos.getX(), blockPos.getY(), blockPos.getZ(), playerPos.getX(), playerPos.getY(), playerPos.getZ());

						// Second ignore all blocks too far away to be relevant to the sonar ping
						if (distance < maxDistance) {
							sonarBlocks.add(blockPos);
						}
					}
				}
			}
		}
		BlockPos[] poses = new BlockPos[sonarBlocks.size()];
		RenderLevelStageEventListener.setBlocks(sonarBlocks.toArray(poses), playerPos);
		return duration;
	}
}