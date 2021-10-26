package com.technologica.world.gen.surfacebuilders;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.technologica.block.TechnologicaBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

public class CraterFieldsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
	private static final BlockState TERRACOTTA = Blocks.TERRACOTTA.getDefaultState();
	private static final BlockState RED_TERRACOTTA = Blocks.RED_TERRACOTTA.getDefaultState();
	private static final BlockState ORANGE_TERRACOTTA = Blocks.ORANGE_TERRACOTTA.getDefaultState();
	private static final BlockState YELLOW_TERRACOTTA = Blocks.YELLOW_TERRACOTTA.getDefaultState();
	private static final BlockState BROWN_TERRACOTTA = Blocks.BROWN_TERRACOTTA.getDefaultState();
	private static final BlockState WHITE_TERRACOTTA = Blocks.WHITE_TERRACOTTA.getDefaultState();
	private static final BlockState LIGHT_GRAY_TERRACOTTA = Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState();
	private static final BlockState SALT = TechnologicaBlocks.SALT.get().getDefaultState();
	private static final BlockState BRINE = TechnologicaBlocks.BRINE.get().getDefaultState();
		
	protected BlockState[] blockStateArray;
	protected long field_215433_b;
	
	protected PerlinNoiseGenerator field_215435_c;
	protected PerlinNoiseGenerator field_215437_d;
	protected PerlinNoiseGenerator field_215439_e;

	public CraterFieldsSurfaceBuilder(Codec<SurfaceBuilderConfig> codec) {
		super(codec);
	}

	@SuppressWarnings("deprecation")
	public void buildSurface(Random randomIn, IChunk chunkIn, Biome biomeIn, int posXIn, int posZIn, int startHeightIn, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
		int posX = posXIn & 15;
		int posZ = posZIn & 15;
		
		ISurfaceBuilderConfig isurfacebuilderconfig = biomeIn.getGenerationSettings().getSurfaceBuilderConfig();
		
		BlockState blockstate = WHITE_TERRACOTTA;
		BlockState blockstate1 = isurfacebuilderconfig.getUnder();
		BlockState blockstate2 = isurfacebuilderconfig.getTop();
		BlockState blockstate3 = blockstate1;
		
		int k = (int) (noise / 3.0D + 3.0D + randomIn.nextDouble() * 0.25D);
		int l = -1;
		int i1 = 0;
		
		boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
		boolean flag1 = false;
		
		BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

		for(int posY = startHeightIn; posY >= 0; --posY) {
			if (i1 < 15) {
				blockpos$mutable.setPos(posX, posY, posZ);
				BlockState blockstate4 = chunkIn.getBlockState(blockpos$mutable);
	            
	            if (blockstate4.isAir()) {
	            	l = -1;
	            } else if (blockstate4.matchesBlock(defaultBlock.getBlock())) {
	            	if (l == -1) {
	            		flag1 = false;
	                  
	            		if (k <= 0) {
	            			blockstate = Blocks.AIR.getDefaultState();
	            			blockstate3 = defaultBlock;
	            		} else if (posY >= seaLevel - 4 && posY <= seaLevel + 1) {
	            			blockstate = WHITE_TERRACOTTA;
	            			blockstate3 = blockstate1;
	            		}

	            		if (posY < seaLevel && (blockstate == null || blockstate.isAir())) {
	            			blockstate = BRINE;
	            		}

	            		l = k + Math.max(0, posY - seaLevel);
	                              		
	            		if (posY >= seaLevel - 1) {
	            			if (posY > seaLevel + 3 + k) {
	            				BlockState blockstate5;
	                        
	            				if (posY >= 64 && posY <= 127) {
	            					blockstate5 = flag ? TERRACOTTA : this.getBlockState(posXIn, posY, posZIn);
	            				} else {
	            					blockstate5 = ORANGE_TERRACOTTA;
	            				}

	            				chunkIn.setBlockState(blockpos$mutable, blockstate5, false);
	            			} else if (posY <= seaLevel) {
	            				chunkIn.setBlockState(blockpos$mutable, SALT, false);	
	            				flag1 = true;
	            			} else {
	            				chunkIn.setBlockState(blockpos$mutable, blockstate2, false);
	            				flag1 = true;
	            			}
	            			
	            		} else {
	            			chunkIn.setBlockState(blockpos$mutable, blockstate3, false);
	            			Block block = blockstate3.getBlock();
	                    
	            			if (block == Blocks.WHITE_TERRACOTTA || block == Blocks.ORANGE_TERRACOTTA || block == Blocks.MAGENTA_TERRACOTTA || block == Blocks.LIGHT_BLUE_TERRACOTTA || block == Blocks.YELLOW_TERRACOTTA || block == Blocks.LIME_TERRACOTTA || block == Blocks.PINK_TERRACOTTA || block == Blocks.GRAY_TERRACOTTA || block == Blocks.LIGHT_GRAY_TERRACOTTA || block == Blocks.CYAN_TERRACOTTA || block == Blocks.PURPLE_TERRACOTTA || block == Blocks.BLUE_TERRACOTTA || block == Blocks.BROWN_TERRACOTTA || block == Blocks.GREEN_TERRACOTTA || block == Blocks.RED_TERRACOTTA || block == Blocks.BLACK_TERRACOTTA) {
	            				chunkIn.setBlockState(blockpos$mutable, ORANGE_TERRACOTTA, false);
	            			}
	            		}
	            		
	            	} else if (l > 0) {
	            		--l;
	            		
	            		if (flag1) {
	            			chunkIn.setBlockState(blockpos$mutable, ORANGE_TERRACOTTA, false);
	            		} else {
	            			chunkIn.setBlockState(blockpos$mutable, this.getBlockState(posXIn, posY, posZIn), false);
	            		}
	            	}

	            	++i1;
	            }
			}
		}
	}

	public void setSeed(long seed) {
		if (this.field_215433_b != seed || this.blockStateArray == null) {
			this.func_215430_b(seed);
		}

		if (this.field_215433_b != seed || this.field_215435_c == null || this.field_215437_d == null) {
			SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
			this.field_215435_c = new PerlinNoiseGenerator(sharedseedrandom, IntStream.rangeClosed(-3, 0));
			this.field_215437_d = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
		}

		this.field_215433_b = seed;
	}

	protected void func_215430_b(long p_215430_1_) {
		this.blockStateArray = new BlockState[64];
		Arrays.fill(this.blockStateArray, TERRACOTTA);
		SharedSeedRandom sharedseedrandom = new SharedSeedRandom(p_215430_1_);
		this.field_215439_e = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));

		for (int l1 = 0; l1 < 64; ++l1) {
			l1 += sharedseedrandom.nextInt(5) + 1;
			if (l1 < 64) {
				this.blockStateArray[l1] = ORANGE_TERRACOTTA;
			}
		}

		int i2 = sharedseedrandom.nextInt(4) + 2;

		for (int i = 0; i < i2; ++i) {
			int j = sharedseedrandom.nextInt(3) + 1;
			int k = sharedseedrandom.nextInt(64);

			for (int l = 0; k + l < 64 && l < j; ++l) {
				this.blockStateArray[k + l] = YELLOW_TERRACOTTA;
			}
		}

		int j2 = sharedseedrandom.nextInt(4) + 2;

		for (int k2 = 0; k2 < j2; ++k2) {
			int i3 = sharedseedrandom.nextInt(3) + 2;
			int l3 = sharedseedrandom.nextInt(64);

			for (int i1 = 0; l3 + i1 < 64 && i1 < i3; ++i1) {
				this.blockStateArray[l3 + i1] = BROWN_TERRACOTTA;
			}
		}

		int l2 = sharedseedrandom.nextInt(4) + 2;

		for (int j3 = 0; j3 < l2; ++j3) {
			int i4 = sharedseedrandom.nextInt(3) + 1;
			int k4 = sharedseedrandom.nextInt(64);

			for (int j1 = 0; k4 + j1 < 64 && j1 < i4; ++j1) {
				this.blockStateArray[k4 + j1] = RED_TERRACOTTA;
			}
		}

		int k3 = sharedseedrandom.nextInt(3) + 3;
		int j4 = 0;

		for (int l4 = 0; l4 < k3; ++l4) {
			j4 += sharedseedrandom.nextInt(16) + 4;

			for (int k1 = 0; j4 + k1 < 64 && k1 < 1; ++k1) {
				this.blockStateArray[j4 + k1] = WHITE_TERRACOTTA;
				if (j4 + k1 > 1 && sharedseedrandom.nextBoolean()) {
					this.blockStateArray[j4 + k1 - 1] = LIGHT_GRAY_TERRACOTTA;
				}

				if (j4 + k1 < 63 && sharedseedrandom.nextBoolean()) {
					this.blockStateArray[j4 + k1 + 1] = LIGHT_GRAY_TERRACOTTA;
				}
			}
		}
	}

	protected BlockState getBlockState(int posXIn, int posYIn, int posZIn) {
		int i = (int) Math.round(this.field_215439_e.noiseAt((double) posXIn / 512.0D, (double) posZIn / 512.0D, false) * 2.0D);
		return this.blockStateArray[(posYIn + i + 64) % 64];
	}
}
