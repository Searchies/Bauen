/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package net.searchies.bauen.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AmethystBlock;
import net.minecraft.block.AmethystClusterBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.searchies.bauen.init.ModBlocks;

public class BuddingAberrantAmethystBlock
        extends AmethystBlock {
    public static final MapCodec<BuddingAberrantAmethystBlock> CODEC = BuddingAberrantAmethystBlock.createCodec(BuddingAberrantAmethystBlock::new);
    public static final int GROW_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public MapCodec<BuddingAberrantAmethystBlock> getCodec() {
        return CODEC;
    }

    public BuddingAberrantAmethystBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(5) != 0) {
            return;
        }
        Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        Block block = null;
        if (BuddingAberrantAmethystBlock.canGrowIn(blockState)) {
            block = ModBlocks.SMALL_ABERRANT_AMETHYST_BUD;
        } else if (blockState.isOf(ModBlocks.SMALL_ABERRANT_AMETHYST_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
            block = ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD;
        } else if (blockState.isOf(ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
            block = ModBlocks.LARGE_ABERRANT_AMETHYST_BUD;
        } else if (blockState.isOf(ModBlocks.LARGE_ABERRANT_AMETHYST_BUD) && blockState.get(AmethystClusterBlock.FACING) == direction) {
            block = ModBlocks.ABERRANT_AMETHYST_CLUSTER;
        }
        if (block != null) {
            BlockState blockState2 = (block.getDefaultState().with(AmethystClusterBlock.FACING, direction)).with(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
            world.setBlockState(blockPos, blockState2);
        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}

