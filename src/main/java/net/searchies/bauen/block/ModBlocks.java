package net.searchies.bauen.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.UndergroundConfiguredFeatures;
import net.searchies.bauen.Bauen;

import java.util.function.Function;

public class ModBlocks {

    private static final AbstractBlock.Settings ABS_COPPER = AbstractBlock.Settings.create().requiresTool().strength(3.0F, 6.0F).instrument(NoteBlockInstrument.BASEDRUM).nonOpaque();
    private static final AbstractBlock.Settings ABS_BRICKS = AbstractBlock.Settings.copy(Blocks.BRICKS);
    private static final AbstractBlock.Settings ABS_DOOR = AbstractBlock.Settings.create().strength(3.0F, 6.0F).nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    private static final AbstractBlock.Settings ABS_TRAPDOOR = AbstractBlock.Settings.create().requiresTool().strength(3.0F, 6.0F).nonOpaque().allowsSpawning(Blocks::never);

    public static final Block MOSSY_BRICKS = registerBlock("mossy_bricks", ABS_BRICKS);
    public static final Block CRACKED_BRICKS = registerBlock("cracked_bricks", ABS_BRICKS);
    public static final Block CHISELED_BRICKS = registerBlock("chiseled_bricks", ABS_BRICKS);
    public static final Block MOSSY_CHISELED_BRICKS = registerBlock("mossy_chiseled_bricks", ABS_BRICKS);
    public static final Block CRACKED_CHISELED_BRICKS = registerBlock("cracked_chiseled_bricks", ABS_BRICKS);

    public static final Block CUT_GOLD = registerBlock("cut_gold", ABS_COPPER);
    public static final Block CHISELED_GOLD = registerBlock("chiseled_gold", ABS_COPPER);
    public static final Block GOLD_GRATE = registerBlock("gold_grate", ABS_COPPER);
    public static final Block GOLD_CHAIN = registerCustomBlock("gold_chain", ChainBlock::new, ABS_COPPER);
    public static final Block GOLD_LANTERN = registerCustomBlock("gold_lantern", LanternBlock::new,
            AbstractBlock.Settings.copy(Blocks.LANTERN).strength(3.0F, 6.0F));
    public static final Block GOLD_BARS = registerCustomBlock("gold_bars", PaneBlock::new, ABS_COPPER);
    public static final Block GOLD_TRAPDOOR = registerCustomBlock("gold_trapdoor", settings -> new TrapdoorBlock(BlockSetType.COPPER, settings), ABS_TRAPDOOR);
    public static final Block GOLD_DOOR = registerCustomBlock("gold_door", settings -> new DoorBlock(BlockSetType.COPPER, settings), ABS_DOOR);
    public static final Block GOLD_COINS = registerCustomBlock("gold_coins", LeafLitterBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.GOLD).replaceable().noCollision().sounds(BlockSoundGroup.LEAF_LITTER).pistonBehavior(PistonBehavior.DESTROY));

    public static final Block MIXED_COBBLESTONE = registerBlock("mixed_cobblestone", AbstractBlock.Settings.copy(Blocks.COBBLESTONE).strength(3.0F));

    public static final Block INDUSTRIAL_IRON_BLOCK = registerBlock("industrial_iron_block", ABS_COPPER);
    public static final Block CUT_INDUSTRIAL_IRON = registerBlock("cut_industrial_iron", ABS_COPPER);
    public static final Block CARVED_INDUSTRIAL_IRON = registerBlock("carved_industrial_iron", ABS_COPPER);
    public static final Block INDUSTRIAL_IRON_GRATE = registerBlock("industrial_iron_grate", ABS_COPPER);
    public static final Block INDUSTRIAL_IRON_TRAPDOOR = registerCustomBlock("industrial_iron_trapdoor", settings -> new TrapdoorBlock(BlockSetType.COPPER, settings), ABS_TRAPDOOR);
    public static final Block INDUSTRIAL_IRON_DOOR = registerCustomBlock("industrial_iron_door", settings -> new DoorBlock(BlockSetType.COPPER, settings), ABS_DOOR);

    public static final Block MOSSY_PACKED_MUD = registerBlock("mossy_packed_mud", ABS_BRICKS);
    public static final Block MOSSY_MUD_BRICKS = registerBlock("mossy_mud_bricks", ABS_BRICKS);
    public static final Block MOSSY_TUFF_BRICKS = registerBlock("mossy_tuff_bricks", ABS_BRICKS);
    public static final Block SCULKED_DEEPSLATE_BRICKS = registerBlock("sculked_deepslate_bricks", ABS_BRICKS);

    public static final Block MIDNIGHT_BRICKS = registerBlock("midnight_bricks", ABS_BRICKS);
    public static final Block MOSSY_MIDNIGHT_BRICKS = registerBlock("mossy_midnight_bricks", ABS_BRICKS);
    public static final Block CRACKED_MIDNIGHT_BRICKS = registerBlock("cracked_midnight_bricks", ABS_BRICKS);
    public static final Block CHISELED_MIDNIGHT_BRICKS = registerBlock("chiseled_midnight_bricks", ABS_BRICKS);
    public static final Block MOSSY_CHISELED_MIDNIGHT_BRICKS = registerBlock("mossy_chiseled_midnight_bricks", ABS_BRICKS);
    public static final Block CRACKED_CHISELED_MIDNIGHT_BRICKS = registerBlock("cracked_chiseled_midnight_bricks", ABS_BRICKS);

    public static final Block KAOLIN_CLAY = registerBlock("kaolin_clay", AbstractBlock.Settings.copy(Blocks.CLAY));

    public static final Block TREATED_BRICKS = registerBlock("treated_bricks", ABS_BRICKS);
    public static final Block MOSSY_TREATED_BRICKS = registerBlock("mossy_treated_bricks", ABS_BRICKS);
    public static final Block CRACKED_TREATED_BRICKS = registerBlock("cracked_treated_bricks", ABS_BRICKS);
    public static final Block CHISELED_TREATED_BRICKS = registerBlock("chiseled_treated_bricks", ABS_BRICKS);
    public static final Block MOSSY_CHISELED_TREATED_BRICKS = registerBlock("mossy_chiseled_treated_bricks", ABS_BRICKS);
    public static final Block CRACKED_CHISELED_TREATED_BRICKS = registerBlock("cracked_chiseled_treated_bricks", ABS_BRICKS);
    public static final Block MIXED_BRICKS = registerBlock("mixed_bricks", ABS_BRICKS);
    public static final Block MOSSY_MIXED_BRICKS = registerBlock("mossy_mixed_bricks", ABS_BRICKS);
    public static final Block CRACKED_MIXED_BRICKS = registerBlock("cracked_mixed_bricks", ABS_BRICKS);

    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks", ABS_BRICKS);
    public static final Block MOSSY_CALCITE_BRICKS = registerBlock("mossy_calcite_bricks", ABS_BRICKS);
    public static final Block CRACKED_CALCITE_BRICKS = registerBlock("cracked_calcite_bricks", ABS_BRICKS);

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Bauen.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static Block registerCustomBlock(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Bauen.MOD_ID, name));
        Block block = factory.apply(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bauen.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        Bauen.LOGGER.info(Bauen.MOD_ID + " || Registering ModBlocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.MOSSY_BRICKS);
            entries.add(ModBlocks.CRACKED_BRICKS);
            entries.add(ModBlocks.CHISELED_BRICKS);
            entries.add(ModBlocks.MOSSY_CHISELED_BRICKS);
            entries.add(ModBlocks.CRACKED_CHISELED_BRICKS);

            entries.add(ModBlocks.GOLD_CHAIN);
            entries.add(ModBlocks.GOLD_LANTERN);
            entries.add(ModBlocks.GOLD_BARS);
            entries.add(ModBlocks.CUT_GOLD);
            entries.add(ModBlocks.CHISELED_GOLD);
            entries.add(ModBlocks.GOLD_GRATE);
            entries.add(ModBlocks.GOLD_TRAPDOOR);
            entries.add(ModBlocks.GOLD_DOOR);
            entries.add(ModBlocks.GOLD_COINS);

            entries.add(ModBlocks.MIXED_COBBLESTONE);

            entries.add(ModBlocks.INDUSTRIAL_IRON_BLOCK);
            entries.add(ModBlocks.CUT_INDUSTRIAL_IRON);
            entries.add(ModBlocks.CARVED_INDUSTRIAL_IRON);
            entries.add(ModBlocks.INDUSTRIAL_IRON_GRATE);
            entries.add(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
            entries.add(ModBlocks.INDUSTRIAL_IRON_DOOR);

            entries.add(ModBlocks.MOSSY_PACKED_MUD);
            entries.add(ModBlocks.MOSSY_MUD_BRICKS);
            entries.add(ModBlocks.MOSSY_TUFF_BRICKS);
            entries.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS);

            entries.add(ModBlocks.MIDNIGHT_BRICKS);
            entries.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);

            entries.add(ModBlocks.KAOLIN_CLAY);

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
        });
    }
}
