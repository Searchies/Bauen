package net.searchies.bauen.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup CUSTOM_BRICK_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Bauen.MOD_ID, "custom_brick_blocks_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.MOSSY_BRICKS))
                    .displayName(Text.translatable("itemgroup.bauen.custom_brick_blocks_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MOSSY_BRICKS);
                        entries.add(ModBlocks.CRACKED_BRICKS);
                        entries.add(ModBlocks.CHISELED_BRICKS);
                        entries.add(ModBlocks.MOSSY_CHISELED_BRICKS);
                        entries.add(ModBlocks.CRACKED_CHISELED_BRICKS);

                        entries.add(ModBlocks.MOSSY_PACKED_MUD);
                        entries.add(ModBlocks.MOSSY_MUD_BRICKS);
                        entries.add(ModBlocks.MOSSY_TUFF_BRICKS);
                        entries.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS);

                        entries.add(ModBlocks.TREATED_BRICKS);
                        entries.add(ModBlocks.MOSSY_TREATED_BRICKS);
                        entries.add(ModBlocks.CRACKED_TREATED_BRICKS);
                        entries.add(ModBlocks.CHISELED_TREATED_BRICKS);
                        entries.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
                        entries.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
                        entries.add(ModBlocks.MIXED_BRICKS);
                        entries.add(ModBlocks.MOSSY_MIXED_BRICKS);
                        entries.add(ModBlocks.CRACKED_MIXED_BRICKS);

                        entries.add(ModBlocks.CALCITE_BRICKS);
                        entries.add(ModBlocks.MOSSY_CALCITE_BRICKS);
                        entries.add(ModBlocks.CRACKED_CALCITE_BRICKS);

                        entries.add(ModBlocks.MIXED_COBBLESTONE);
                    }).build());

    public static final ItemGroup CUSTOM_GOLD_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Bauen.MOD_ID, "custom_gold_blocks_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.GOLD_COINS))
                    .displayName(Text.translatable("itemgroup.bauen.custom_gold_blocks_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.GOLD_CHAIN);
                        entries.add(ModBlocks.GOLD_LANTERN);
                        entries.add(ModBlocks.GOLD_BARS);
                        entries.add(ModBlocks.CUT_GOLD);
                        entries.add(ModBlocks.CHISELED_GOLD);
                        entries.add(ModBlocks.GOLD_GRATE);
                        entries.add(ModBlocks.GOLD_TRAPDOOR);
                        entries.add(ModBlocks.GOLD_DOOR);
                        entries.add(ModBlocks.GOLD_COINS);
                    }).build());

    public static final ItemGroup INDUSTRIAL_IRON_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Bauen.MOD_ID, "industrial_iron_blocks_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                    .displayName(Text.translatable("itemgroup.bauen.industrial_iron_blocks_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.INDUSTRIAL_IRON_BLOCK);
                        entries.add(ModBlocks.CUT_INDUSTRIAL_IRON);
                        entries.add(ModBlocks.CARVED_INDUSTRIAL_IRON);
                        entries.add(ModBlocks.INDUSTRIAL_IRON_GRATE);
                        entries.add(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
                        entries.add(ModBlocks.INDUSTRIAL_IRON_DOOR);
                    }).build());

    public static final ItemGroup MIDNIGHT_BRICKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Bauen.MOD_ID, "midnight_bricks_items_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                    .displayName(Text.translatable("itemgroup.bauen.midnight_bricks_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.KAOLIN_CLAY_BALL);
                        entries.add(ModBlocks.KAOLIN_CLAY);

                        entries.add(ModItems.MIDNIGHT_BRICK);
                        entries.add(ModBlocks.MIDNIGHT_BRICKS);
                        entries.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS);
                        entries.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS);
                        entries.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS);
                        entries.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
                        entries.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);
                    }).build());

    public static final ItemGroup CUSTOM_STONE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Bauen.MOD_ID, "custom_stone_group"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                    .displayName(Text.translatable("itemgroup.bauen.custom_stone_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MIXED_COBBLESTONE);
                    }).build());


    public static void registerModItemGroups() {
        Bauen.LOGGER.info(Bauen.MOD_ID + " || Registering ModItemGroups");
    }
}
