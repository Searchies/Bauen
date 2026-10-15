package net.searchies.bauen.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import net.searchies.bauen.init.ModBlocks;

import java.util.Map;

public class AberrantPasteItem extends Item {
    private static final Map<Block, Block> GOO_MAP =
        Map.ofEntries(
            Map.entry(Blocks.SEA_LANTERN, ModBlocks.ABERRANT_SEA_LANTERN),
            Map.entry(Blocks.DARK_PRISMARINE, ModBlocks.ABERRANT_DARK_PRISMARINE),
            Map.entry(Blocks.PRISMARINE, ModBlocks.ABERRANT_PRISMARINE),
            Map.entry(Blocks.PRISMARINE_BRICKS, ModBlocks.ABERRANT_PRISMARINE_BRICKS),
            Map.entry(ModBlocks.OCEANSLATE, ModBlocks.ABERRANT_OCEANSLATE),
            Map.entry(ModBlocks.POLISHED_OCEANSLATE, ModBlocks.ABERRANT_POLISHED_OCEANSLATE),
            Map.entry(ModBlocks.OCEANSLATE_TILES, ModBlocks.ABERRANT_OCEANSLATE_TILES),
            Map.entry(ModBlocks.OCEANSLATE_BRICKS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS),
            Map.entry(ModBlocks.CRACKED_OCEANSLATE_BRICKS, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS),
            Map.entry(ModBlocks.KELPY_OCEANSLATE_BRICKS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS),
            Map.entry(Blocks.TERRACOTTA, ModBlocks.ABERRANT_TERRACOTTA),
            Map.entry(Blocks.RED_WOOL, ModBlocks.ABERRANT_RED_WOOL),
            Map.entry(ModBlocks.RED_SEAT, ModBlocks.ABERRANT_RED_SEAT),
            Map.entry(Blocks.RED_CONCRETE, ModBlocks.ABERRANT_RED_CONCRETE),
            Map.entry(Blocks.RED_CONCRETE_POWDER, ModBlocks.ABERRANT_RED_CONCRETE_POWER),
            Map.entry(Blocks.RED_TERRACOTTA, ModBlocks.ABERRANT_RED_TERRACOTTA),
            Map.entry(Blocks.RED_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_RED_GLAZED_TERRACOTTA),
            Map.entry(Blocks.ORANGE_WOOL, ModBlocks.ABERRANT_ORANGE_WOOL),
            Map.entry(ModBlocks.ORANGE_SEAT, ModBlocks.ABERRANT_ORANGE_SEAT),
            Map.entry(Blocks.ORANGE_CONCRETE, ModBlocks.ABERRANT_ORANGE_CONCRETE),
            Map.entry(Blocks.ORANGE_CONCRETE_POWDER, ModBlocks.ABERRANT_ORANGE_CONCRETE_POWER),
            Map.entry(Blocks.ORANGE_TERRACOTTA, ModBlocks.ABERRANT_ORANGE_TERRACOTTA),
            Map.entry(Blocks.ORANGE_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_ORANGE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.YELLOW_WOOL, ModBlocks.ABERRANT_YELLOW_WOOL),
            Map.entry(ModBlocks.YELLOW_SEAT, ModBlocks.ABERRANT_YELLOW_SEAT),
            Map.entry(Blocks.YELLOW_CONCRETE, ModBlocks.ABERRANT_YELLOW_CONCRETE),
            Map.entry(Blocks.YELLOW_CONCRETE_POWDER, ModBlocks.ABERRANT_YELLOW_CONCRETE_POWER),
            Map.entry(Blocks.YELLOW_TERRACOTTA, ModBlocks.ABERRANT_YELLOW_TERRACOTTA),
            Map.entry(Blocks.YELLOW_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_YELLOW_GLAZED_TERRACOTTA),
            Map.entry(Blocks.LIME_WOOL, ModBlocks.ABERRANT_LIME_WOOL),
            Map.entry(ModBlocks.LIME_SEAT, ModBlocks.ABERRANT_LIME_SEAT),
            Map.entry(Blocks.LIME_CONCRETE, ModBlocks.ABERRANT_LIME_CONCRETE),
            Map.entry(Blocks.LIME_CONCRETE_POWDER, ModBlocks.ABERRANT_LIME_CONCRETE_POWER),
            Map.entry(Blocks.LIME_TERRACOTTA, ModBlocks.ABERRANT_LIME_TERRACOTTA),
            Map.entry(Blocks.LIME_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_LIME_GLAZED_TERRACOTTA),
            Map.entry(Blocks.GREEN_WOOL, ModBlocks.ABERRANT_GREEN_WOOL),
            Map.entry(ModBlocks.GREEN_SEAT, ModBlocks.ABERRANT_GREEN_SEAT),
            Map.entry(Blocks.GREEN_CONCRETE, ModBlocks.ABERRANT_GREEN_CONCRETE),
            Map.entry(Blocks.GREEN_CONCRETE_POWDER, ModBlocks.ABERRANT_GREEN_CONCRETE_POWER),
            Map.entry(Blocks.GREEN_TERRACOTTA, ModBlocks.ABERRANT_GREEN_TERRACOTTA),
            Map.entry(Blocks.GREEN_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_GREEN_GLAZED_TERRACOTTA),
            Map.entry(Blocks.CYAN_WOOL, ModBlocks.ABERRANT_CYAN_WOOL),
            Map.entry(ModBlocks.CYAN_SEAT, ModBlocks.ABERRANT_CYAN_SEAT),
            Map.entry(Blocks.CYAN_CONCRETE, ModBlocks.ABERRANT_CYAN_CONCRETE),
            Map.entry(Blocks.CYAN_CONCRETE_POWDER, ModBlocks.ABERRANT_CYAN_CONCRETE_POWER),
            Map.entry(Blocks.CYAN_TERRACOTTA, ModBlocks.ABERRANT_CYAN_TERRACOTTA),
            Map.entry(Blocks.CYAN_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_CYAN_GLAZED_TERRACOTTA),
            Map.entry(Blocks.LIGHT_BLUE_WOOL, ModBlocks.ABERRANT_LIGHT_BLUE_WOOL),
            Map.entry(ModBlocks.LIGHT_BLUE_SEAT, ModBlocks.ABERRANT_LIGHT_BLUE_SEAT),
            Map.entry(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE),
            Map.entry(Blocks.LIGHT_BLUE_CONCRETE_POWDER, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_POWER),
            Map.entry(Blocks.LIGHT_BLUE_TERRACOTTA, ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA),
            Map.entry(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_LIGHT_BLUE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.BLUE_WOOL, ModBlocks.ABERRANT_BLUE_WOOL),
            Map.entry(ModBlocks.BLUE_SEAT, ModBlocks.ABERRANT_BLUE_SEAT),
            Map.entry(Blocks.BLUE_CONCRETE, ModBlocks.ABERRANT_BLUE_CONCRETE),
            Map.entry(Blocks.BLUE_CONCRETE_POWDER, ModBlocks.ABERRANT_BLUE_CONCRETE_POWER),
            Map.entry(Blocks.BLUE_TERRACOTTA, ModBlocks.ABERRANT_BLUE_TERRACOTTA),
            Map.entry(Blocks.BLUE_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_BLUE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.PINK_WOOL, ModBlocks.ABERRANT_PINK_WOOL),
            Map.entry(ModBlocks.PINK_SEAT, ModBlocks.ABERRANT_PINK_SEAT),
            Map.entry(Blocks.PINK_CONCRETE, ModBlocks.ABERRANT_PINK_CONCRETE),
            Map.entry(Blocks.PINK_CONCRETE_POWDER, ModBlocks.ABERRANT_PINK_CONCRETE_POWER),
            Map.entry(Blocks.PINK_TERRACOTTA, ModBlocks.ABERRANT_PINK_TERRACOTTA),
            Map.entry(Blocks.PINK_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_PINK_GLAZED_TERRACOTTA),
            Map.entry(Blocks.MAGENTA_WOOL, ModBlocks.ABERRANT_MAGENTA_WOOL),
            Map.entry(ModBlocks.MAGENTA_SEAT, ModBlocks.ABERRANT_MAGENTA_SEAT),
            Map.entry(Blocks.MAGENTA_CONCRETE, ModBlocks.ABERRANT_MAGENTA_CONCRETE),
            Map.entry(Blocks.MAGENTA_CONCRETE_POWDER, ModBlocks.ABERRANT_MAGENTA_CONCRETE_POWER),
            Map.entry(Blocks.MAGENTA_TERRACOTTA, ModBlocks.ABERRANT_MAGENTA_TERRACOTTA),
            Map.entry(Blocks.MAGENTA_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_MAGENTA_GLAZED_TERRACOTTA),
            Map.entry(Blocks.PURPLE_WOOL, ModBlocks.ABERRANT_PURPLE_WOOL),
            Map.entry(ModBlocks.PURPLE_SEAT, ModBlocks.ABERRANT_PURPLE_SEAT),
            Map.entry(Blocks.PURPLE_CONCRETE, ModBlocks.ABERRANT_PURPLE_CONCRETE),
            Map.entry(Blocks.PURPLE_CONCRETE_POWDER, ModBlocks.ABERRANT_PURPLE_CONCRETE_POWER),
            Map.entry(Blocks.PURPLE_TERRACOTTA, ModBlocks.ABERRANT_PURPLE_TERRACOTTA),
            Map.entry(Blocks.PURPLE_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_PURPLE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.BROWN_WOOL, ModBlocks.ABERRANT_BROWN_WOOL),
            Map.entry(ModBlocks.BROWN_SEAT, ModBlocks.ABERRANT_BROWN_SEAT),
            Map.entry(Blocks.BROWN_CONCRETE, ModBlocks.ABERRANT_BROWN_CONCRETE),
            Map.entry(Blocks.BROWN_CONCRETE_POWDER, ModBlocks.ABERRANT_BROWN_CONCRETE_POWER),
            Map.entry(Blocks.BROWN_TERRACOTTA, ModBlocks.ABERRANT_BROWN_TERRACOTTA),
            Map.entry(Blocks.BROWN_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_BROWN_GLAZED_TERRACOTTA),
            Map.entry(Blocks.BLACK_WOOL, ModBlocks.ABERRANT_BLACK_WOOL),
            Map.entry(ModBlocks.BLACK_SEAT, ModBlocks.ABERRANT_BLACK_SEAT),
            Map.entry(Blocks.BLACK_CONCRETE, ModBlocks.ABERRANT_BLACK_CONCRETE),
            Map.entry(Blocks.BLACK_CONCRETE_POWDER, ModBlocks.ABERRANT_BLACK_CONCRETE_POWER),
            Map.entry(Blocks.BLACK_TERRACOTTA, ModBlocks.ABERRANT_BLACK_TERRACOTTA),
            Map.entry(Blocks.BLACK_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_BLACK_GLAZED_TERRACOTTA),
            Map.entry(Blocks.GRAY_WOOL, ModBlocks.ABERRANT_GRAY_WOOL),
            Map.entry(ModBlocks.GRAY_SEAT, ModBlocks.ABERRANT_GRAY_SEAT),
            Map.entry(Blocks.GRAY_CONCRETE, ModBlocks.ABERRANT_GRAY_CONCRETE),
            Map.entry(Blocks.GRAY_CONCRETE_POWDER, ModBlocks.ABERRANT_GRAY_CONCRETE_POWER),
            Map.entry(Blocks.GRAY_TERRACOTTA, ModBlocks.ABERRANT_GRAY_TERRACOTTA),
            Map.entry(Blocks.GRAY_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_GRAY_GLAZED_TERRACOTTA),
            Map.entry(Blocks.LIGHT_GRAY_WOOL, ModBlocks.ABERRANT_LIGHT_GRAY_WOOL),
            Map.entry(ModBlocks.LIGHT_GRAY_SEAT, ModBlocks.ABERRANT_LIGHT_GRAY_SEAT),
            Map.entry(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE),
            Map.entry(Blocks.LIGHT_GRAY_CONCRETE_POWDER, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_POWER),
            Map.entry(Blocks.LIGHT_GRAY_TERRACOTTA, ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA),
            Map.entry(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_LIGHT_GRAY_GLAZED_TERRACOTTA),
            Map.entry(Blocks.WHITE_WOOL, ModBlocks.ABERRANT_WHITE_WOOL),
            Map.entry(ModBlocks.WHITE_SEAT, ModBlocks.ABERRANT_WHITE_SEAT),
            Map.entry(Blocks.WHITE_CONCRETE, ModBlocks.ABERRANT_WHITE_CONCRETE),
            Map.entry(Blocks.WHITE_CONCRETE_POWDER, ModBlocks.ABERRANT_WHITE_CONCRETE_POWER),
            Map.entry(Blocks.WHITE_TERRACOTTA, ModBlocks.ABERRANT_WHITE_TERRACOTTA),
            Map.entry(Blocks.WHITE_GLAZED_TERRACOTTA, ModBlocks.ABERRANT_WHITE_GLAZED_TERRACOTTA),
            Map.entry(Blocks.RED_CARPET, ModBlocks.ABERRANT_RED_CARPET),
            Map.entry(Blocks.ORANGE_CARPET, ModBlocks.ABERRANT_ORANGE_CARPET),
            Map.entry(Blocks.YELLOW_CARPET, ModBlocks.ABERRANT_YELLOW_CARPET),
            Map.entry(Blocks.LIME_CARPET, ModBlocks.ABERRANT_LIME_CARPET),
            Map.entry(Blocks.GREEN_CARPET, ModBlocks.ABERRANT_GREEN_CARPET),
            Map.entry(Blocks.CYAN_CARPET, ModBlocks.ABERRANT_CYAN_CARPET),
            Map.entry(Blocks.LIGHT_BLUE_CARPET, ModBlocks.ABERRANT_LIGHT_BLUE_CARPET),
            Map.entry(Blocks.BLUE_CARPET, ModBlocks.ABERRANT_BLUE_CARPET),
            Map.entry(Blocks.PINK_CARPET, ModBlocks.ABERRANT_PINK_CARPET),
            Map.entry(Blocks.MAGENTA_CARPET, ModBlocks.ABERRANT_MAGENTA_CARPET),
            Map.entry(Blocks.PURPLE_CARPET, ModBlocks.ABERRANT_PURPLE_CARPET),
            Map.entry(Blocks.BROWN_CARPET, ModBlocks.ABERRANT_BROWN_CARPET),
            Map.entry(Blocks.BLACK_CARPET, ModBlocks.ABERRANT_BLACK_CARPET),
            Map.entry(Blocks.GRAY_CARPET, ModBlocks.ABERRANT_GRAY_CARPET),
            Map.entry(Blocks.LIGHT_GRAY_CARPET, ModBlocks.ABERRANT_LIGHT_GRAY_CARPET),
            Map.entry(Blocks.WHITE_CARPET, ModBlocks.ABERRANT_WHITE_CARPET)

        );

    public AberrantPasteItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockState blockState = world.getBlockState(context.getBlockPos());
        Block block = blockState.getBlock();

        if (GOO_MAP.containsKey(block)) {
            if (!world.isClient()) {
                world.setBlockState(context.getBlockPos(), GOO_MAP.get(block).getDefaultState());

                context.getStack().decrement(1);

                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_HONEYCOMB_WAX_ON, SoundCategory.BLOCKS);

                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }
}
