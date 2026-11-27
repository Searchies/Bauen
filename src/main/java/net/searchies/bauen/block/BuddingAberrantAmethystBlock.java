/*
 * Decompiled with CFR 0.2.2 (FabricMC 7c48b8c4).
 */
package net.searchies.bauen.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.AmethystBlock;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.searchies.bauen.init.ModBlocks;

public class BuddingAberrantAmethystBlock
        extends AmethystBlock {
    public static final MapCodec<BuddingAberrantAmethystBlock> CODEC = BuddingAberrantAmethystBlock.simpleCodec(BuddingAberrantAmethystBlock::new);
    public static final int GROW_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public MapCodec<BuddingAberrantAmethystBlock> codec() {
        return CODEC;
    }

    public BuddingAberrantAmethystBlock(BlockBehaviour.Properties settings) {
        super(settings);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (random.nextInt(5) != 0) {
            return;
        }
        Direction direction = UPDATE_SHAPE_ORDER[random.nextInt(UPDATE_SHAPE_ORDER.length)];
        BlockPos blockPos = pos.relative(direction);
        BlockState blockState = world.getBlockState(blockPos);
        Block block = null;
        if (BuddingAberrantAmethystBlock.canGrowIn(blockState)) {
            block = ModBlocks.SMALL_ABERRANT_AMETHYST_BUD;
        } else if (blockState.is(ModBlocks.SMALL_ABERRANT_AMETHYST_BUD) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
            block = ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD;
        } else if (blockState.is(ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
            block = ModBlocks.LARGE_ABERRANT_AMETHYST_BUD;
        } else if (blockState.is(ModBlocks.LARGE_ABERRANT_AMETHYST_BUD) && blockState.getValue(AmethystClusterBlock.FACING) == direction) {
            block = ModBlocks.ABERRANT_AMETHYST_CLUSTER;
        }
        if (block != null) {
            BlockState blockState2 = (block.defaultBlockState().setValue(AmethystClusterBlock.FACING, direction)).setValue(AmethystClusterBlock.WATERLOGGED, blockState.getFluidState().getType() == Fluids.WATER);
            world.setBlockAndUpdate(blockPos, blockState2);
        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.is(Blocks.WATER) && state.getFluidState().getAmount() == 8;
    }
}

