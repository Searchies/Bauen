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
    public static final ItemGroup BAUEN_BLOCKS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Bauen.MOD_ID, "bauen_blocks_group"),
            FabricItemGroup.builder()
                .icon(() -> new ItemStack(ModBlocks.TREATED_BRICKS))
                .displayName(Text.translatable("itemgroup.bauen.bauen_blocks_group"))
                .entries((displayContext, entries) -> {
                    // Custom Bricks //
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

                    // Gold Blocks //
                    entries.add(ModBlocks.GOLD_CHAIN);
                    entries.add(ModBlocks.GOLD_LANTERN);
                    entries.add(ModBlocks.GOLD_BARS);
                    entries.add(ModBlocks.CUT_GOLD);
                    entries.add(ModBlocks.CHISELED_GOLD);
                    entries.add(ModBlocks.GOLD_GRATE);
                    entries.add(ModBlocks.GOLD_TRAPDOOR);
                    entries.add(ModBlocks.GOLD_DOOR);
                    entries.add(ModBlocks.GOLD_COINS);
                    entries.add(ModBlocks.GOLD_HOARD);

                    // Kaolin Clay //
                    entries.add(ModItems.KAOLIN_CLAY_BALL);
                    entries.add(ModBlocks.KAOLIN_CLAY);

                    // Midnight Bricks //
                    entries.add(ModItems.MIDNIGHT_BRICK);
                    entries.add(ModBlocks.MIDNIGHT_BRICKS);
                    entries.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS);
                    entries.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS);
                    entries.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS);
                    entries.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
                    entries.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);

                    // Iron Blocks //
                    entries.add(ModBlocks.INDUSTRIAL_IRON_BLOCK);
                    entries.add(ModBlocks.CUT_INDUSTRIAL_IRON);
                    entries.add(ModBlocks.CARVED_INDUSTRIAL_IRON);
                    entries.add(ModBlocks.INDUSTRIAL_IRON_GRATE);
                    entries.add(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
                    entries.add(ModBlocks.INDUSTRIAL_IRON_DOOR);

                    entries.add(ModBlocks.MIXED_COBBLESTONE);

                    // Calcite Bricks //
                    entries.add(ModBlocks.CALCITE_BRICKS);
                    entries.add(ModBlocks.MOSSY_CALCITE_BRICKS);
                    entries.add(ModBlocks.CRACKED_CALCITE_BRICKS);

                    // Andesite Bricks //
                    entries.add(ModBlocks.ANDESITE_BRICKS);
                    entries.add(ModBlocks.MOSSY_ANDESITE_BRICKS);
                    entries.add(ModBlocks.CRACKED_ANDESITE_BRICKS);

                    // Diorite Bricks //
                    entries.add(ModBlocks.DIORITE_BRICKS);
                    entries.add(ModBlocks.MOSSY_DIORITE_BRICKS);
                    entries.add(ModBlocks.CRACKED_DIORITE_BRICKS);

                    // Dripstone Bricks //
                    entries.add(ModBlocks.DRIPSTONE_BRICKS);
                    entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS);
                    entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS);

                    // Granite Bricks //
                    entries.add(ModBlocks.GRANITE_BRICKS);
                    entries.add(ModBlocks.MOSSY_GRANITE_BRICKS);
                    entries.add(ModBlocks.CRACKED_GRANITE_BRICKS);

                    // Oceanslate //
                    entries.add(ModBlocks.OCEANSLATE);
                    entries.add(ModBlocks.OCEANSLATE_BRICKS);
                    entries.add(ModBlocks.OCEANSLATE_TILES);
                    entries.add(ModBlocks.POLISHED_OCEANSLATE);
                    entries.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS);
                    entries.add(ModBlocks.KELPY_OCEANSLATE_BRICKS);
                }).build());

    public static void registerModItemGroups() {
        Bauen.LOGGER.info(Bauen.MOD_ID + " || Registering ModItemGroups");
    }
}
