package net.searchies.bauen.init;

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
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.block.GoldHoardBlock;
import net.searchies.bauen.block.SeatBlock;

import java.util.function.Function;

public class ModBlocks {

    private static final AbstractBlock.Settings ABS_COPPER = AbstractBlock.Settings.create().requiresTool().strength(3.0F, 6.0F).instrument(NoteBlockInstrument.BASEDRUM).nonOpaque();
    private static final AbstractBlock.Settings ABS_CHAIN = AbstractBlock.Settings.copy(Blocks.COPPER_CHAINS.unaffected());
    private static final AbstractBlock.Settings ABS_BRICKS = AbstractBlock.Settings.copy(Blocks.BRICKS);
    private static final AbstractBlock.Settings ABS_COBBLE = AbstractBlock.Settings.copy(Blocks.COBBLESTONE).strength(3.0F);
    private static final AbstractBlock.Settings ABS_DOOR = AbstractBlock.Settings.create().strength(3.0F, 6.0F).nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    private static final AbstractBlock.Settings ABS_TRAPDOOR = AbstractBlock.Settings.create().requiresTool().strength(3.0F, 6.0F).nonOpaque().allowsSpawning(Blocks::never);
    private static final AbstractBlock.Settings ABS_MUD = AbstractBlock.Settings.copy(Blocks.MUD);
    private static final AbstractBlock.Settings ABS_TUFF = AbstractBlock.Settings.copy(Blocks.TUFF);
    private static final AbstractBlock.Settings ABS_CALCITE = AbstractBlock.Settings.copy(Blocks.CALCITE);
    private static final AbstractBlock.Settings ABS_DRIPSTONE = AbstractBlock.Settings.copy(Blocks.DRIPSTONE_BLOCK);
    private static final AbstractBlock.Settings ABS_ICE = AbstractBlock.Settings.copy(Blocks.ICE);
    private static final AbstractBlock.Settings ABS_PACKED_ICE = AbstractBlock.Settings.copy(Blocks.PACKED_ICE);
    private static final AbstractBlock.Settings ABS_SEA_LANTERN = AbstractBlock.Settings.copy(Blocks.SEA_LANTERN);
    private static final AbstractBlock.Settings ABS_PRISMARINE = AbstractBlock.Settings.copy(Blocks.PRISMARINE);
    private static final AbstractBlock.Settings ABS_SANDSTONE = AbstractBlock.Settings.copy(Blocks.SANDSTONE);
    private static final AbstractBlock.Settings ABS_TERRACOTA = AbstractBlock.Settings.copy(Blocks.TERRACOTTA);
    private static final AbstractBlock.Settings ABS_RESIN_BLOCK = AbstractBlock.Settings.copy(Blocks.RESIN_BLOCK);
    private static final AbstractBlock.Settings ABS_CLUMPS = AbstractBlock.Settings.copy(Blocks.RESIN_CLUMP);
    private static final AbstractBlock.Settings ABS_AMETHYST = AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK);
    private static final AbstractBlock.Settings ABS_BUDDING_AMETHYST = AbstractBlock.Settings.copy(Blocks.BUDDING_AMETHYST);
    private static final AbstractBlock.Settings ABS_AMETHYST_CLUSTER = AbstractBlock.Settings.copy(Blocks.AMETHYST_CLUSTER);
    private static final AbstractBlock.Settings ABS_LARGE_AMETHYST_BUD = AbstractBlock.Settings.copy(Blocks.LARGE_AMETHYST_BUD);
    private static final AbstractBlock.Settings ABS_MEDIUM_AMETHYST_BUD = AbstractBlock.Settings.copy(Blocks.MEDIUM_AMETHYST_BUD);
    private static final AbstractBlock.Settings ABS_SMALL_AMETHYST_BUD = AbstractBlock.Settings.copy(Blocks.SMALL_AMETHYST_BUD);
    private static final AbstractBlock.Settings ABS_NETHER_BRICKS = AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS);
    private static final AbstractBlock.Settings ABS_RED_NETHER_BRICKS = AbstractBlock.Settings.copy(Blocks.RED_NETHER_BRICKS);

    public static final Block MOSSY_BRICKS = registerBlock("mossy_bricks", ABS_BRICKS);
    public static final Block MOSSY_BRICKS_STAIRS = registerCustomBlock("mossy_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_BRICKS_SLAB = registerCustomBlock("mossy_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_BRICKS_WALL = registerCustomBlock("mossy_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_BRICKS = registerBlock("cracked_bricks", ABS_BRICKS);
    public static final Block CRACKED_BRICKS_STAIRS = registerCustomBlock("cracked_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_BRICKS_SLAB = registerCustomBlock("cracked_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_BRICKS_WALL = registerCustomBlock("cracked_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CHISELED_BRICKS = registerBlock("chiseled_bricks", ABS_BRICKS);
    public static final Block CHISELED_BRICKS_STAIRS = registerCustomBlock("chiseled_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CHISELED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CHISELED_BRICKS_SLAB = registerCustomBlock("chiseled_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CHISELED_BRICKS_WALL = registerCustomBlock("chiseled_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_CHISELED_BRICKS = registerBlock("mossy_chiseled_bricks", ABS_BRICKS);
    public static final Block MOSSY_CHISELED_BRICKS_STAIRS = registerCustomBlock("mossy_chiseled_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_CHISELED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_CHISELED_BRICKS_SLAB = registerCustomBlock("mossy_chiseled_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_CHISELED_BRICKS_WALL = registerCustomBlock("mossy_chiseled_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_CHISELED_BRICKS = registerBlock("cracked_chiseled_bricks", ABS_BRICKS);
    public static final Block CRACKED_CHISELED_BRICKS_STAIRS = registerCustomBlock("cracked_chiseled_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_CHISELED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_CHISELED_BRICKS_SLAB = registerCustomBlock("cracked_chiseled_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_CHISELED_BRICKS_WALL = registerCustomBlock("cracked_chiseled_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CUT_GOLD = registerBlock("cut_gold", ABS_COPPER);
    public static final Block CUT_GOLD_STAIRS = registerCustomBlock("cut_gold_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CUT_GOLD.getDefaultState(), ABS_COPPER), ABS_COPPER);
    public static final Block CUT_GOLD_SLAB = registerCustomBlock("cut_gold_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_COPPER), ABS_COPPER);
    public static final Block CUT_GOLD_WALL = registerCustomBlock("cut_gold_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_COPPER), ABS_COPPER);

    public static final Block CHISELED_GOLD = registerBlock("chiseled_gold", ABS_COPPER);
    public static final Block GOLD_GRATE = registerBlock("gold_grate", ABS_COPPER);
    public static final Block GOLD_CHAIN = registerCustomBlock("gold_chain", ChainBlock::new, ABS_CHAIN);
    public static final Block GOLD_LANTERN = registerCustomBlock("gold_lantern", LanternBlock::new,
            AbstractBlock.Settings.copy(Blocks.LANTERN).strength(3.0F, 6.0F));
    public static final Block GOLD_BARS = registerCustomBlock("gold_bars", PaneBlock::new, ABS_COPPER);
    public static final Block GOLD_TRAPDOOR = registerCustomBlock("gold_trapdoor", settings -> new TrapdoorBlock(BlockSetType.COPPER, settings), ABS_TRAPDOOR);
    public static final Block GOLD_DOOR = registerCustomBlock("gold_door", settings -> new DoorBlock(BlockSetType.COPPER, settings), ABS_DOOR);
    public static final Block GOLD_COINS = registerCustomBlock("gold_coins", LeafLitterBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.GOLD).replaceable().noCollision().sounds(BlockSoundGroup.CHAIN).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block GOLD_HOARD = registerCustomBlock("gold_hoard", GoldHoardBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.GOLD).replaceable().notSolid().ticksRandomly().strength(2.0f,4.0f).requiresTool().sounds(BlockSoundGroup.CHAIN).blockVision((state, world, pos) -> state.get(GoldHoardBlock.LAYERS) >= 8).pistonBehavior(PistonBehavior.DESTROY));
    public static final Block GOLD_HOARD_BLOCK = registerBlock("gold_hoard_block",
            AbstractBlock.Settings.create().mapColor(MapColor.GOLD).requiresTool().strength(3.0f,6.0f).sounds(BlockSoundGroup.CHAIN));

    public static final Block MIXED_COBBLESTONE = registerBlock("mixed_cobblestone", ABS_COBBLE);
    public static final Block MIXED_COBBLESTONE_STAIRS = registerCustomBlock("mixed_cobblestone_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MIXED_COBBLESTONE.getDefaultState(), ABS_COBBLE), ABS_COBBLE);
    public static final Block MIXED_COBBLESTONE_SLAB = registerCustomBlock("mixed_cobblestone_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_COBBLE), ABS_COBBLE);
    public static final Block MIXED_COBBLESTONE_WALL = registerCustomBlock("mixed_cobblestone_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_COBBLE), ABS_COBBLE);

    public static final Block INDUSTRIAL_IRON_BLOCK = registerBlock("industrial_iron_block", ABS_COPPER);
    public static final Block INDUSTRIAL_IRON_STAIRS = registerCustomBlock("industrial_iron_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.INDUSTRIAL_IRON_BLOCK.getDefaultState(), ABS_COPPER), ABS_COPPER);
    public static final Block INDUSTRIAL_IRON_SLAB = registerCustomBlock("industrial_iron_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_COPPER), ABS_COPPER);
    public static final Block INDUSTRIAL_IRON_WALL = registerCustomBlock("industrial_iron_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_COPPER), ABS_COPPER);

    public static final Block CUT_INDUSTRIAL_IRON = registerBlock("cut_industrial_iron", ABS_COPPER);
    public static final Block CUT_INDUSTRIAL_IRON_STAIRS = registerCustomBlock("cut_industrial_iron_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CUT_INDUSTRIAL_IRON.getDefaultState(), ABS_COPPER), ABS_COPPER);
    public static final Block CUT_INDUSTRIAL_IRON_SLAB = registerCustomBlock("cut_industrial_iron_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_COPPER), ABS_COPPER);
    public static final Block CUT_INDUSTRIAL_IRON_WALL = registerCustomBlock("cut_industrial_iron_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_COPPER), ABS_COPPER);

    public static final Block CARVED_INDUSTRIAL_IRON = registerBlock("carved_industrial_iron", ABS_COPPER);
    public static final Block INDUSTRIAL_IRON_GRATE = registerBlock("industrial_iron_grate", ABS_COPPER);
    public static final Block INDUSTRIAL_IRON_TRAPDOOR = registerCustomBlock("industrial_iron_trapdoor", settings -> new TrapdoorBlock(BlockSetType.COPPER, settings), ABS_TRAPDOOR);
    public static final Block INDUSTRIAL_IRON_DOOR = registerCustomBlock("industrial_iron_door", settings -> new DoorBlock(BlockSetType.COPPER, settings), ABS_DOOR);

    public static final Block ICE_STAIRS = registerCustomBlock("ice_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(Blocks.ICE.getDefaultState(), ABS_ICE), ABS_ICE);
    public static final Block ICE_SLAB = registerCustomBlock("ice_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_ICE), ABS_ICE);
    public static final Block ICE_WALL = registerCustomBlock("ice_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_ICE), ABS_ICE);

    public static final Block PACKED_ICE_STAIRS = registerCustomBlock("packed_ice_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(Blocks.PACKED_ICE.getDefaultState(), ABS_PACKED_ICE), ABS_PACKED_ICE);
    public static final Block PACKED_ICE_SLAB = registerCustomBlock("packed_ice_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PACKED_ICE), ABS_PACKED_ICE);
    public static final Block PACKED_ICE_WALL = registerCustomBlock("packed_ice_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PACKED_ICE), ABS_PACKED_ICE);

    public static final Block MUD_STAIRS = registerCustomBlock("mud_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(Blocks.MUD.getDefaultState(), ABS_MUD), ABS_MUD);
    public static final Block MUD_SLAB = registerCustomBlock("mud_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_MUD), ABS_MUD);
    public static final Block MUD_WALL = registerCustomBlock("mud_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_MUD), ABS_MUD);

    public static final Block MOSSY_PACKED_MUD = registerBlock("mossy_packed_mud", ABS_MUD);
    public static final Block MOSSY_PACKED_MUD_STAIRS = registerCustomBlock("mossy_packed_mud_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_PACKED_MUD.getDefaultState(), ABS_MUD), ABS_MUD);
    public static final Block MOSSY_PACKED_MUD_SLAB = registerCustomBlock("mossy_packed_mud_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_MUD), ABS_MUD);
    public static final Block MOSSY_PACKED_MUD_WALL = registerCustomBlock("mossy_packed_mud_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_MUD), ABS_MUD);

    public static final Block MOSSY_MUD_BRICKS = registerBlock("mossy_mud_bricks", ABS_BRICKS);
    public static final Block MOSSY_MUD_BRICKS_STAIRS = registerCustomBlock("mossy_mud_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_MUD_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_MUD_BRICKS_SLAB = registerCustomBlock("mossy_mud_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_MUD_BRICKS_WALL = registerCustomBlock("mossy_mud_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_TUFF_BRICKS = registerBlock("mossy_tuff_bricks", ABS_TUFF);
    public static final Block MOSSY_TUFF_BRICKS_STAIRS = registerCustomBlock("mossy_tuff_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_TUFF_BRICKS.getDefaultState(), ABS_TUFF), ABS_TUFF);
    public static final Block MOSSY_TUFF_BRICKS_SLAB = registerCustomBlock("mossy_tuff_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_TUFF), ABS_TUFF);
    public static final Block MOSSY_TUFF_BRICKS_WALL = registerCustomBlock("mossy_tuff_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_TUFF), ABS_TUFF);

    public static final Block CRACKED_TUFF_BRICKS = registerBlock("cracked_tuff_bricks", ABS_TUFF);
    public static final Block CRACKED_TUFF_BRICKS_STAIRS = registerCustomBlock("cracked_tuff_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_TUFF_BRICKS.getDefaultState(), ABS_TUFF), ABS_TUFF);
    public static final Block CRACKED_TUFF_BRICKS_SLAB = registerCustomBlock("cracked_tuff_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_TUFF), ABS_TUFF);
    public static final Block CRACKED_TUFF_BRICKS_WALL = registerCustomBlock("cracked_tuff_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_TUFF), ABS_TUFF);

    public static final Block SCULKED_DEEPSLATE_BRICKS = registerBlock("sculked_deepslate_bricks", ABS_BRICKS);
    public static final Block SCULKED_DEEPSLATE_BRICKS_STAIRS = registerCustomBlock("sculked_deepslate_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.SCULKED_DEEPSLATE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block SCULKED_DEEPSLATE_BRICKS_SLAB = registerCustomBlock("sculked_deepslate_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block SCULKED_DEEPSLATE_BRICKS_WALL = registerCustomBlock("sculked_deepslate_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MIDNIGHT_BRICKS = registerBlock("midnight_bricks", ABS_BRICKS);
    public static final Block MIDNIGHT_BRICKS_STAIRS = registerCustomBlock("midnight_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MIDNIGHT_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MIDNIGHT_BRICKS_SLAB = registerCustomBlock("midnight_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MIDNIGHT_BRICKS_WALL = registerCustomBlock("midnight_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_MIDNIGHT_BRICKS = registerBlock("mossy_midnight_bricks", ABS_BRICKS);
    public static final Block MOSSY_MIDNIGHT_BRICKS_STAIRS = registerCustomBlock("mossy_midnight_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_MIDNIGHT_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_MIDNIGHT_BRICKS_SLAB = registerCustomBlock("mossy_midnight_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_MIDNIGHT_BRICKS_WALL = registerCustomBlock("mossy_midnight_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_MIDNIGHT_BRICKS = registerBlock("cracked_midnight_bricks", ABS_BRICKS);
    public static final Block CRACKED_MIDNIGHT_BRICKS_STAIRS = registerCustomBlock("cracked_midnight_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_MIDNIGHT_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_MIDNIGHT_BRICKS_SLAB = registerCustomBlock("cracked_midnight_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_MIDNIGHT_BRICKS_WALL = registerCustomBlock("cracked_midnight_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CHISELED_MIDNIGHT_BRICKS = registerBlock("chiseled_midnight_bricks", ABS_BRICKS);
    public static final Block CHISELED_MIDNIGHT_BRICKS_STAIRS = registerCustomBlock("chiseled_midnight_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CHISELED_MIDNIGHT_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CHISELED_MIDNIGHT_BRICKS_SLAB = registerCustomBlock("chiseled_midnight_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CHISELED_MIDNIGHT_BRICKS_WALL = registerCustomBlock("chiseled_midnight_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_CHISELED_MIDNIGHT_BRICKS = registerBlock("mossy_chiseled_midnight_bricks", ABS_BRICKS);
    public static final Block MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS = registerCustomBlock("mossy_chiseled_midnight_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB = registerCustomBlock("mossy_chiseled_midnight_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL = registerCustomBlock("mossy_chiseled_midnight_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_CHISELED_MIDNIGHT_BRICKS = registerBlock("cracked_chiseled_midnight_bricks", ABS_BRICKS);
    public static final Block CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS = registerCustomBlock("cracked_chiseled_midnight_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB = registerCustomBlock("cracked_chiseled_midnight_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL = registerCustomBlock("cracked_chiseled_midnight_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block KAOLIN_CLAY = registerBlock("kaolin_clay", AbstractBlock.Settings.copy(Blocks.CLAY));

    public static final Block TREATED_BRICKS = registerBlock("treated_bricks", ABS_BRICKS);
    public static final Block TREATED_BRICKS_STAIRS = registerCustomBlock("treated_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.TREATED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block TREATED_BRICKS_SLAB = registerCustomBlock("treated_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block TREATED_BRICKS_WALL = registerCustomBlock("treated_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_TREATED_BRICKS = registerBlock("mossy_treated_bricks", ABS_BRICKS);
    public static final Block MOSSY_TREATED_BRICKS_STAIRS = registerCustomBlock("mossy_treated_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_TREATED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_TREATED_BRICKS_SLAB = registerCustomBlock("mossy_treated_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_TREATED_BRICKS_WALL = registerCustomBlock("mossy_treated_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_TREATED_BRICKS = registerBlock("cracked_treated_bricks", ABS_BRICKS);
    public static final Block CRACKED_TREATED_BRICKS_STAIRS = registerCustomBlock("cracked_treated_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_TREATED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_TREATED_BRICKS_SLAB = registerCustomBlock("cracked_treated_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_TREATED_BRICKS_WALL = registerCustomBlock("cracked_treated_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CHISELED_TREATED_BRICKS = registerBlock("chiseled_treated_bricks", ABS_BRICKS);
    public static final Block CHISELED_TREATED_BRICKS_STAIRS = registerCustomBlock("chiseled_treated_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_TREATED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CHISELED_TREATED_BRICKS_SLAB = registerCustomBlock("chiseled_treated_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CHISELED_TREATED_BRICKS_WALL = registerCustomBlock("chiseled_treated_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_CHISELED_TREATED_BRICKS = registerBlock("mossy_chiseled_treated_bricks", ABS_BRICKS);
    public static final Block MOSSY_CHISELED_TREATED_BRICKS_STAIRS = registerCustomBlock("mossy_chiseled_treated_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_CHISELED_TREATED_BRICKS_SLAB = registerCustomBlock("mossy_chiseled_treated_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_CHISELED_TREATED_BRICKS_WALL = registerCustomBlock("mossy_chiseled_treated_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_CHISELED_TREATED_BRICKS = registerBlock("cracked_chiseled_treated_bricks", ABS_BRICKS);
    public static final Block CRACKED_CHISELED_TREATED_BRICKS_STAIRS = registerCustomBlock("cracked_chiseled_treated_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_CHISELED_TREATED_BRICKS_SLAB = registerCustomBlock("cracked_chiseled_treated_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_CHISELED_TREATED_BRICKS_WALL = registerCustomBlock("cracked_chiseled_treated_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MIXED_BRICKS = registerBlock("mixed_bricks", ABS_BRICKS);
    public static final Block MIXED_BRICKS_STAIRS = registerCustomBlock("mixed_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MIXED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MIXED_BRICKS_SLAB = registerCustomBlock("mixed_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MIXED_BRICKS_WALL = registerCustomBlock("mixed_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_MIXED_BRICKS = registerBlock("mossy_mixed_bricks", ABS_BRICKS);
    public static final Block MOSSY_MIXED_BRICKS_STAIRS = registerCustomBlock("mossy_mixed_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_MIXED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_MIXED_BRICKS_SLAB = registerCustomBlock("mossy_mixed_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_MIXED_BRICKS_WALL = registerCustomBlock("mossy_mixed_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_MIXED_BRICKS = registerBlock("cracked_mixed_bricks", ABS_BRICKS);
    public static final Block CRACKED_MIXED_BRICKS_STAIRS = registerCustomBlock("cracked_mixed_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_MIXED_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_MIXED_BRICKS_SLAB = registerCustomBlock("cracked_mixed_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_MIXED_BRICKS_WALL = registerCustomBlock("cracked_mixed_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block POLISHED_CALCITE = registerBlock("polished_calcite", ABS_CALCITE);
    public static final Block POLISHED_CALCITE_STAIRS = registerCustomBlock("polished_calcite_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_CALCITE.getDefaultState(), ABS_CALCITE), ABS_CALCITE);
    public static final Block POLISHED_CALCITE_SLAB = registerCustomBlock("polished_calcite_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_CALCITE), ABS_CALCITE);
    public static final Block POLISHED_CALCITE_WALL = registerCustomBlock("polished_calcite_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_CALCITE), ABS_CALCITE);

    public static final Block POLISHED_CALCITE_BRICKS = registerBlock("polished_calcite_bricks", ABS_CALCITE);
    public static final Block POLISHED_CALCITE_BRICKS_STAIRS = registerCustomBlock("polished_calcite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_CALCITE_BRICKS.getDefaultState(), ABS_CALCITE), ABS_CALCITE);
    public static final Block POLISHED_CALCITE_BRICKS_SLAB = registerCustomBlock("polished_calcite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_CALCITE), ABS_CALCITE);
    public static final Block POLISHED_CALCITE_BRICKS_WALL = registerCustomBlock("polished_calcite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_CALCITE), ABS_CALCITE);

    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks", ABS_CALCITE);
    public static final Block CALCITE_BRICKS_STAIRS = registerCustomBlock("calcite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CALCITE_BRICKS.getDefaultState(), ABS_CALCITE), ABS_CALCITE);
    public static final Block CALCITE_BRICKS_SLAB = registerCustomBlock("calcite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_CALCITE), ABS_CALCITE);
    public static final Block CALCITE_BRICKS_WALL = registerCustomBlock("calcite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_CALCITE), ABS_CALCITE);

    public static final Block MOSSY_CALCITE_BRICKS = registerBlock("mossy_calcite_bricks", ABS_CALCITE);
    public static final Block MOSSY_CALCITE_BRICKS_STAIRS = registerCustomBlock("mossy_calcite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_CALCITE_BRICKS.getDefaultState(), ABS_CALCITE), ABS_CALCITE);
    public static final Block MOSSY_CALCITE_BRICKS_SLAB = registerCustomBlock("mossy_calcite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_CALCITE), ABS_CALCITE);
    public static final Block MOSSY_CALCITE_BRICKS_WALL = registerCustomBlock("mossy_calcite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_CALCITE), ABS_CALCITE);

    public static final Block CRACKED_CALCITE_BRICKS = registerBlock("cracked_calcite_bricks", ABS_CALCITE);
    public static final Block CRACKED_CALCITE_BRICKS_STAIRS = registerCustomBlock("cracked_calcite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_CALCITE_BRICKS.getDefaultState(), ABS_CALCITE), ABS_CALCITE);
    public static final Block CRACKED_CALCITE_BRICKS_SLAB = registerCustomBlock("cracked_calcite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_CALCITE), ABS_CALCITE);
    public static final Block CRACKED_CALCITE_BRICKS_WALL = registerCustomBlock("cracked_calcite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_CALCITE), ABS_CALCITE);

    public static final Block POLISHED_ANDESITE_BRICKS = registerBlock("polished_andesite_bricks", ABS_BRICKS);
    public static final Block POLISHED_ANDESITE_BRICKS_STAIRS = registerCustomBlock("polished_andesite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_ANDESITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_ANDESITE_BRICKS_SLAB = registerCustomBlock("polished_andesite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_ANDESITE_BRICKS_WALL = registerCustomBlock("polished_andesite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block ANDESITE_BRICKS = registerBlock("andesite_bricks", ABS_BRICKS);
    public static final Block ANDESITE_BRICKS_STAIRS = registerCustomBlock("andesite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ANDESITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block ANDESITE_BRICKS_SLAB = registerCustomBlock("andesite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block ANDESITE_BRICKS_WALL = registerCustomBlock("andesite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_ANDESITE_BRICKS = registerBlock("mossy_andesite_bricks", ABS_BRICKS);
    public static final Block MOSSY_ANDESITE_BRICKS_STAIRS = registerCustomBlock("mossy_andesite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_ANDESITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_ANDESITE_BRICKS_SLAB = registerCustomBlock("mossy_andesite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_ANDESITE_BRICKS_WALL = registerCustomBlock("mossy_andesite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_ANDESITE_BRICKS = registerBlock("cracked_andesite_bricks", ABS_BRICKS);
    public static final Block CRACKED_ANDESITE_BRICKS_STAIRS = registerCustomBlock("cracked_andesite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_ANDESITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_ANDESITE_BRICKS_SLAB = registerCustomBlock("cracked_andesite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_ANDESITE_BRICKS_WALL = registerCustomBlock("cracked_andesite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block POLISHED_DIORITE_BRICKS = registerBlock("polished_diorite_bricks", ABS_BRICKS);
    public static final Block POLISHED_DIORITE_BRICKS_STAIRS = registerCustomBlock("polished_diorite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_DIORITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_DIORITE_BRICKS_SLAB = registerCustomBlock("polished_diorite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_DIORITE_BRICKS_WALL = registerCustomBlock("polished_diorite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block DIORITE_BRICKS = registerBlock("diorite_bricks", ABS_BRICKS);
    public static final Block DIORITE_BRICKS_STAIRS = registerCustomBlock("diorite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DIORITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block DIORITE_BRICKS_SLAB = registerCustomBlock("diorite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block DIORITE_BRICKS_WALL = registerCustomBlock("diorite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_DIORITE_BRICKS = registerBlock("mossy_diorite_bricks", ABS_BRICKS);
    public static final Block MOSSY_DIORITE_BRICKS_STAIRS = registerCustomBlock("mossy_diorite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_DIORITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_DIORITE_BRICKS_SLAB = registerCustomBlock("mossy_diorite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_DIORITE_BRICKS_WALL = registerCustomBlock("mossy_diorite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_DIORITE_BRICKS = registerBlock("cracked_diorite_bricks", ABS_BRICKS);
    public static final Block CRACKED_DIORITE_BRICKS_STAIRS = registerCustomBlock("cracked_diorite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_DIORITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_DIORITE_BRICKS_SLAB = registerCustomBlock("cracked_diorite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_DIORITE_BRICKS_WALL = registerCustomBlock("cracked_diorite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block POLISHED_DRIPSTONE = registerBlock("polished_dripstone", ABS_DRIPSTONE);
    public static final Block POLISHED_DRIPSTONE_STAIRS = registerCustomBlock("polished_dripstone_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_DRIPSTONE.getDefaultState(), ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block POLISHED_DRIPSTONE_SLAB = registerCustomBlock("polished_dripstone_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block POLISHED_DRIPSTONE_WALL = registerCustomBlock("polished_dripstone_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);

    public static final Block DRIPSTONE_BRICKS = registerBlock("dripstone_bricks", ABS_DRIPSTONE);
    public static final Block DRIPSTONE_BRICKS_STAIRS = registerCustomBlock("dripstone_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DRIPSTONE_BRICKS.getDefaultState(), ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block DRIPSTONE_BRICKS_SLAB = registerCustomBlock("dripstone_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block DRIPSTONE_BRICKS_WALL = registerCustomBlock("dripstone_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);

    public static final Block POLISHED_DRIPSTONE_BRICKS = registerBlock("polished_dripstone_bricks", ABS_DRIPSTONE);
    public static final Block POLISHED_DRIPSTONE_BRICKS_STAIRS = registerCustomBlock("polished_dripstone_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_DRIPSTONE_BRICKS.getDefaultState(), ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block POLISHED_DRIPSTONE_BRICKS_SLAB = registerCustomBlock("polished_dripstone_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block POLISHED_DRIPSTONE_BRICKS_WALL = registerCustomBlock("polished_dripstone_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);

    public static final Block MOSSY_DRIPSTONE_BRICKS = registerBlock("mossy_dripstone_bricks", ABS_DRIPSTONE);
    public static final Block MOSSY_DRIPSTONE_BRICKS_STAIRS = registerCustomBlock("mossy_dripstone_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_DRIPSTONE_BRICKS.getDefaultState(), ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block MOSSY_DRIPSTONE_BRICKS_SLAB = registerCustomBlock("mossy_dripstone_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block MOSSY_DRIPSTONE_BRICKS_WALL = registerCustomBlock("mossy_dripstone_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);

    public static final Block CRACKED_DRIPSTONE_BRICKS = registerBlock("cracked_dripstone_bricks", ABS_DRIPSTONE);
    public static final Block CRACKED_DRIPSTONE_BRICKS_STAIRS = registerCustomBlock("cracked_dripstone_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_DRIPSTONE_BRICKS.getDefaultState(), ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block CRACKED_DRIPSTONE_BRICKS_SLAB = registerCustomBlock("cracked_dripstone_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);
    public static final Block CRACKED_DRIPSTONE_BRICKS_WALL = registerCustomBlock("cracked_dripstone_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_DRIPSTONE), ABS_DRIPSTONE);

    public static final Block POLISHED_GRANITE_BRICKS = registerBlock("polished_granite_bricks", ABS_BRICKS);
    public static final Block POLISHED_GRANITE_BRICKS_STAIRS = registerCustomBlock("polished_granite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_GRANITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_GRANITE_BRICKS_SLAB = registerCustomBlock("polished_granite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_GRANITE_BRICKS_WALL = registerCustomBlock("polished_granite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block GRANITE_BRICKS = registerBlock("granite_bricks", ABS_BRICKS);
    public static final Block GRANITE_BRICKS_STAIRS = registerCustomBlock("granite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.GRANITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block GRANITE_BRICKS_SLAB = registerCustomBlock("granite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block GRANITE_BRICKS_WALL = registerCustomBlock("granite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_GRANITE_BRICKS = registerBlock("mossy_granite_bricks", ABS_BRICKS);
    public static final Block MOSSY_GRANITE_BRICKS_STAIRS = registerCustomBlock("mossy_granite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_GRANITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_GRANITE_BRICKS_SLAB = registerCustomBlock("mossy_granite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_GRANITE_BRICKS_WALL = registerCustomBlock("mossy_granite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_GRANITE_BRICKS = registerBlock("cracked_granite_bricks", ABS_BRICKS);
    public static final Block CRACKED_GRANITE_BRICKS_STAIRS = registerCustomBlock("cracked_granite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_GRANITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_GRANITE_BRICKS_SLAB = registerCustomBlock("cracked_granite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_GRANITE_BRICKS_WALL = registerCustomBlock("cracked_granite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block OCEANSLATE = registerBlock("oceanslate", ABS_BRICKS);
    public static final Block OCEANSLATE_STAIRS = registerCustomBlock("oceanslate_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OCEANSLATE.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEANSLATE_SLAB = registerCustomBlock("oceanslate_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEANSLATE_WALL = registerCustomBlock("oceanslate_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block OCEANSLATE_BRICKS = registerBlock("oceanslate_bricks", ABS_BRICKS);
    public static final Block OCEANSLATE_BRICKS_STAIRS = registerCustomBlock("oceanslate_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OCEANSLATE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEANSLATE_BRICKS_SLAB = registerCustomBlock("oceanslate_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEANSLATE_BRICKS_WALL = registerCustomBlock("oceanslate_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block OCEANSLATE_TILES = registerBlock("oceanslate_tiles", ABS_BRICKS);
    public static final Block OCEANSLATE_TILES_STAIRS = registerCustomBlock("oceanslate_tiles_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OCEANSLATE_TILES.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEANSLATE_TILES_SLAB = registerCustomBlock("oceanslate_tiles_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEANSLATE_TILES_WALL = registerCustomBlock("oceanslate_tiles_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block POLISHED_OCEANSLATE = registerBlock("polished_oceanslate", ABS_BRICKS);
    public static final Block POLISHED_OCEANSLATE_STAIRS = registerCustomBlock("polished_oceanslate_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_OCEANSLATE.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_OCEANSLATE_SLAB = registerCustomBlock("polished_oceanslate_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_OCEANSLATE_WALL = registerCustomBlock("polished_oceanslate_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_OCEANSLATE_BRICKS = registerBlock("cracked_oceanslate_bricks", ABS_BRICKS);
    public static final Block CRACKED_OCEANSLATE_BRICKS_STAIRS = registerCustomBlock("cracked_oceanslate_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_OCEANSLATE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_OCEANSLATE_BRICKS_SLAB = registerCustomBlock("cracked_oceanslate_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_OCEANSLATE_BRICKS_WALL = registerCustomBlock("cracked_oceanslate_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block KELPY_OCEANSLATE_BRICKS = registerBlock("kelpy_oceanslate_bricks", ABS_BRICKS);
    public static final Block KELPY_OCEANSLATE_BRICKS_STAIRS = registerCustomBlock("kelpy_oceanslate_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.KELPY_OCEANSLATE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block KELPY_OCEANSLATE_BRICKS_SLAB = registerCustomBlock("kelpy_oceanslate_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block KELPY_OCEANSLATE_BRICKS_WALL = registerCustomBlock("kelpy_oceanslate_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block RED_SEAT = registerCustomBlock("red_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.RED_WOOL).strength(0.4f));
    public static final Block ORANGE_SEAT = registerCustomBlock("orange_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL).strength(0.4f));
    public static final Block YELLOW_SEAT = registerCustomBlock("yellow_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL).strength(0.4f));
    public static final Block LIME_SEAT = registerCustomBlock("lime_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.LIME_WOOL).strength(0.4f));
    public static final Block GREEN_SEAT = registerCustomBlock("green_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.GREEN_WOOL).strength(0.4f));
    public static final Block CYAN_SEAT = registerCustomBlock("cyan_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.CYAN_WOOL).strength(0.4f));
    public static final Block LIGHT_BLUE_SEAT = registerCustomBlock("light_blue_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL).strength(0.4f));
    public static final Block BLUE_SEAT = registerCustomBlock("blue_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.BLUE_WOOL).strength(0.4f));
    public static final Block PINK_SEAT = registerCustomBlock("pink_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.PINK_WOOL).strength(0.4f));
    public static final Block MAGENTA_SEAT = registerCustomBlock("magenta_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL).strength(0.4f));
    public static final Block PURPLE_SEAT = registerCustomBlock("purple_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL).strength(0.4f));
    public static final Block BROWN_SEAT = registerCustomBlock("brown_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.BROWN_WOOL).strength(0.4f));
    public static final Block LIGHT_GRAY_SEAT = registerCustomBlock("light_gray_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL).strength(0.4f));
    public static final Block GRAY_SEAT = registerCustomBlock("gray_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.GRAY_WOOL).strength(0.4f));
    public static final Block BLACK_SEAT = registerCustomBlock("black_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.BLACK_WOOL).strength(0.4f));
    public static final Block WHITE_SEAT = registerCustomBlock("white_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(Blocks.WHITE_WOOL).strength(0.4f));

    public static final Block ABERRANT = registerBlock("aberrant",  ABS_BRICKS);
    public static final Block ABERRANT_SEA_LANTERN = registerBlock("aberrant_sea_lantern",  ABS_SEA_LANTERN);
    public static final Block ABERRANT_DARK_PRISMARINE = registerBlock("aberrant_dark_prismarine",  ABS_PRISMARINE);
    public static final Block ABERRANT_DARK_PRISMARINE_STAIRS = registerCustomBlock("aberrant_dark_prismarine_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_DARK_PRISMARINE.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_DARK_PRISMARINE_SLAB = registerCustomBlock("aberrant_dark_prismarine_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_DARK_PRISMARINE_WALL = registerCustomBlock("aberrant_dark_prismarine_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_PRISMARINE = registerBlock("aberrant_prismarine",  ABS_PRISMARINE);
    public static final Block ABERRANT_PRISMARINE_STAIRS = registerCustomBlock("aberrant_prismarine_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_PRISMARINE.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_PRISMARINE_SLAB = registerCustomBlock("aberrant_prismarine_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_PRISMARINE_WALL = registerCustomBlock("aberrant_prismarine_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_PRISMARINE_BRICKS = registerBlock("aberrant_prismarine_bricks",  ABS_PRISMARINE);
    public static final Block ABERRANT_PRISMARINE_BRICKS_STAIRS = registerCustomBlock("aberrant_prismarine_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_PRISMARINE_BRICKS.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_PRISMARINE_BRICKS_SLAB = registerCustomBlock("aberrant_prismarine_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE = registerBlock("aberrant_oceanslate",  ABS_BRICKS);
    public static final Block ABERRANT_OCEANSLATE_STAIRS = registerCustomBlock("aberrant_oceanslate_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_OCEANSLATE.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE_SLAB = registerCustomBlock("aberrant_oceanslate_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE_WALL = registerCustomBlock("aberrant_oceanslate_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_POLISHED_OCEANSLATE = registerBlock("aberrant_polished_oceanslate",  ABS_BRICKS);
    public static final Block ABERRANT_POLISHED_OCEANSLATE_STAIRS = registerCustomBlock("aberrant_polished_oceanslate_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_POLISHED_OCEANSLATE.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_POLISHED_OCEANSLATE_SLAB = registerCustomBlock("aberrant_polished_oceanslate_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_POLISHED_OCEANSLATE_WALL = registerCustomBlock("aberrant_polished_oceanslate_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE_TILES = registerBlock("aberrant_oceanslate_tiles",  ABS_BRICKS);
    public static final Block ABERRANT_OCEANSLATE_TILES_STAIRS = registerCustomBlock("aberrant_oceanslate_tiles_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_OCEANSLATE_TILES.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE_TILES_SLAB = registerCustomBlock("aberrant_oceanslate_tiles_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE_TILES_WALL = registerCustomBlock("aberrant_oceanslate_tiles_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE_BRICKS = registerBlock("aberrant_oceanslate_bricks",  ABS_BRICKS);
    public static final Block ABERRANT_OCEANSLATE_BRICKS_STAIRS = registerCustomBlock("aberrant_oceanslate_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_OCEANSLATE_BRICKS.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE_BRICKS_SLAB = registerCustomBlock("aberrant_oceanslate_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block ABERRANT_OCEANSLATE_BRICKS_WALL = registerCustomBlock("aberrant_oceanslate_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block CRACKED_ABERRANT_OCEANSLATE_BRICKS = registerBlock("cracked_aberrant_oceanslate_bricks",  ABS_BRICKS);
    public static final Block CRACKED_ABERRANT_OCEANSLATE_BRICKS_STAIRS = registerCustomBlock("cracked_aberrant_oceanslate_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block CRACKED_ABERRANT_OCEANSLATE_BRICKS_SLAB = registerCustomBlock("cracked_aberrant_oceanslate_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block CRACKED_ABERRANT_OCEANSLATE_BRICKS_WALL = registerCustomBlock("cracked_aberrant_oceanslate_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block KELPY_ABERRANT_OCEANSLATE_BRICKS = registerBlock("kelpy_aberrant_oceanslate_bricks",  ABS_BRICKS);
    public static final Block KELPY_ABERRANT_OCEANSLATE_BRICKS_STAIRS = registerCustomBlock("kelpy_aberrant_oceanslate_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS.getDefaultState(), ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB = registerCustomBlock("kelpy_aberrant_oceanslate_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_PRISMARINE), ABS_PRISMARINE);
    public static final Block KELPY_ABERRANT_OCEANSLATE_BRICKS_WALL = registerCustomBlock("kelpy_aberrant_oceanslate_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_PRISMARINE), ABS_PRISMARINE);

    public static final Block SOUL_SANDSTONE = registerBlock("soul_sandstone",  ABS_SANDSTONE);
    public static final Block SOUL_SANDSTONE_STAIRS = registerCustomBlock("soul_sandstone_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.SOUL_SANDSTONE.getDefaultState(), ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block SOUL_SANDSTONE_SLAB = registerCustomBlock("soul_sandstone_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block SOUL_SANDSTONE_WALL = registerCustomBlock("soul_sandstone_wall",  (AbstractBlock.Settings settings) -> new WallBlock(ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block CUT_SOUL_SANDSTONE = registerBlock("cut_soul_sandstone",  ABS_SANDSTONE);
    public static final Block CHISELED_SOUL_SANDSTONE = registerBlock("chiseled_soul_sandstone",  ABS_SANDSTONE);
    public static final Block SMOOTH_SOUL_SANDSTONE = registerBlock("smooth_soul_sandstone",  ABS_SANDSTONE);
    public static final Block SMOOTH_SOUL_SANDSTONE_STAIRS = registerCustomBlock("smooth_soul_sandstone_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.SMOOTH_SOUL_SANDSTONE.getDefaultState(), ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block SMOOTH_SOUL_SANDSTONE_SLAB = registerCustomBlock("smooth_soul_sandstone_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block SMOOTH_SOUL_SANDSTONE_WALL = registerCustomBlock("smooth_soul_sandstone_wall",  (AbstractBlock.Settings settings) -> new WallBlock(ABS_SANDSTONE), ABS_SANDSTONE);

    public static final Block ABERRANT_TERRACOTTA = registerBlock("aberrant_terracotta", ABS_TERRACOTA);

    public static final Block ABERRANT_RED_WOOL = registerCustomBlock("aberrant_red_wool", Block::new, AbstractBlock.Settings.copy(Blocks.RED_WOOL));

    public static final Block ABERRANT_RED_SEAT = registerCustomBlock("aberrant_red_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_RED_WOOL).strength(0.4f));
    public static final Block ABERRANT_RED_CONCRETE = registerCustomBlock("aberrant_red_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.RED_CONCRETE));
    public static final Block ABERRANT_RED_CONCRETE_POWER = registerCustomBlock("aberrant_red_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_RED_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.RED_CONCRETE_POWDER));
    public static final Block ABERRANT_RED_TERRACOTTA = registerBlock("aberrant_red_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_RED_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_red_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.RED_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_ORANGE_WOOL = registerCustomBlock("aberrant_orange_wool", Block::new, AbstractBlock.Settings.copy(Blocks.ORANGE_WOOL));
    public static final Block ABERRANT_ORANGE_SEAT = registerCustomBlock("aberrant_orange_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_ORANGE_WOOL).strength(0.4f));
    public static final Block ABERRANT_ORANGE_CONCRETE = registerCustomBlock("aberrant_orange_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE));
    public static final Block ABERRANT_ORANGE_CONCRETE_POWER = registerCustomBlock("aberrant_orange_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_ORANGE_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE_POWDER));
    public static final Block ABERRANT_ORANGE_TERRACOTTA = registerBlock("aberrant_orange_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_ORANGE_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_orange_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.ORANGE_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_YELLOW_WOOL = registerCustomBlock("aberrant_yellow_wool", Block::new, AbstractBlock.Settings.copy(Blocks.YELLOW_WOOL));
    public static final Block ABERRANT_YELLOW_SEAT = registerCustomBlock("aberrant_yellow_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_YELLOW_WOOL).strength(0.4f));
    public static final Block ABERRANT_YELLOW_CONCRETE = registerCustomBlock("aberrant_yellow_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE));
    public static final Block ABERRANT_YELLOW_CONCRETE_POWER = registerCustomBlock("aberrant_yellow_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_YELLOW_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE_POWDER));
    public static final Block ABERRANT_YELLOW_TERRACOTTA = registerBlock("aberrant_yellow_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_YELLOW_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_yellow_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.YELLOW_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_LIME_WOOL = registerCustomBlock("aberrant_lime_wool", Block::new, AbstractBlock.Settings.copy(Blocks.LIME_WOOL));
    public static final Block ABERRANT_LIME_SEAT = registerCustomBlock("aberrant_lime_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_LIME_WOOL).strength(0.4f));
    public static final Block ABERRANT_LIME_CONCRETE = registerCustomBlock("aberrant_lime_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE));
    public static final Block ABERRANT_LIME_CONCRETE_POWER = registerCustomBlock("aberrant_lime_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_LIME_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE_POWDER));
    public static final Block ABERRANT_LIME_TERRACOTTA = registerBlock("aberrant_lime_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_LIME_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_lime_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.LIME_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_GREEN_WOOL = registerCustomBlock("aberrant_green_wool", Block::new, AbstractBlock.Settings.copy(Blocks.GREEN_WOOL));
    public static final Block ABERRANT_GREEN_SEAT = registerCustomBlock("aberrant_green_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_GREEN_WOOL).strength(0.4f));
    public static final Block ABERRANT_GREEN_CONCRETE = registerCustomBlock("aberrant_green_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE));
    public static final Block ABERRANT_GREEN_CONCRETE_POWER = registerCustomBlock("aberrant_green_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_GREEN_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE_POWDER));
    public static final Block ABERRANT_GREEN_TERRACOTTA = registerBlock("aberrant_green_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_GREEN_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_green_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.GREEN_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_CYAN_WOOL = registerCustomBlock("aberrant_cyan_wool", Block::new, AbstractBlock.Settings.copy(Blocks.CYAN_WOOL));
    public static final Block ABERRANT_CYAN_SEAT = registerCustomBlock("aberrant_cyan_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_CYAN_WOOL).strength(0.4f));
    public static final Block ABERRANT_CYAN_CONCRETE = registerCustomBlock("aberrant_cyan_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE));
    public static final Block ABERRANT_CYAN_CONCRETE_POWER = registerCustomBlock("aberrant_cyan_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_CYAN_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE_POWDER));
    public static final Block ABERRANT_CYAN_TERRACOTTA = registerBlock("aberrant_cyan_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_CYAN_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_cyan_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.CYAN_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_LIGHT_BLUE_WOOL = registerCustomBlock("aberrant_light_blue_wool", Block::new, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_WOOL));
    public static final Block ABERRANT_LIGHT_BLUE_SEAT = registerCustomBlock("aberrant_light_blue_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL).strength(0.4f));
    public static final Block ABERRANT_LIGHT_BLUE_CONCRETE = registerCustomBlock("aberrant_light_blue_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE));
    public static final Block ABERRANT_LIGHT_BLUE_CONCRETE_POWER = registerCustomBlock("aberrant_light_blue_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE_POWDER));
    public static final Block ABERRANT_LIGHT_BLUE_TERRACOTTA = registerBlock("aberrant_light_blue_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_LIGHT_BLUE_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_light_blue_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_BLUE_WOOL = registerCustomBlock("aberrant_blue_wool", Block::new, AbstractBlock.Settings.copy(Blocks.BLUE_WOOL));
    public static final Block ABERRANT_BLUE_SEAT = registerCustomBlock("aberrant_blue_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_BLUE_WOOL).strength(0.4f));
    public static final Block ABERRANT_BLUE_CONCRETE = registerCustomBlock("aberrant_blue_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE));
    public static final Block ABERRANT_BLUE_CONCRETE_POWER = registerCustomBlock("aberrant_blue_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_BLUE_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE_POWDER));
    public static final Block ABERRANT_BLUE_TERRACOTTA = registerBlock("aberrant_blue_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_BLUE_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_blue_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.BLUE_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_PINK_WOOL = registerCustomBlock("aberrant_pink_wool", Block::new, AbstractBlock.Settings.copy(Blocks.PINK_WOOL));
    public static final Block ABERRANT_PINK_SEAT = registerCustomBlock("aberrant_pink_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_PINK_WOOL).strength(0.4f));
    public static final Block ABERRANT_PINK_CONCRETE = registerCustomBlock("aberrant_pink_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE));
    public static final Block ABERRANT_PINK_CONCRETE_POWER = registerCustomBlock("aberrant_pink_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_PINK_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE_POWDER));
    public static final Block ABERRANT_PINK_TERRACOTTA = registerBlock("aberrant_pink_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_PINK_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_pink_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.PINK_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_MAGENTA_WOOL = registerCustomBlock("aberrant_magenta_wool", Block::new, AbstractBlock.Settings.copy(Blocks.MAGENTA_WOOL));
    public static final Block ABERRANT_MAGENTA_SEAT = registerCustomBlock("aberrant_magenta_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_MAGENTA_WOOL).strength(0.4f));
    public static final Block ABERRANT_MAGENTA_CONCRETE = registerCustomBlock("aberrant_magenta_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE));
    public static final Block ABERRANT_MAGENTA_CONCRETE_POWER = registerCustomBlock("aberrant_magenta_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_MAGENTA_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE_POWDER));
    public static final Block ABERRANT_MAGENTA_TERRACOTTA = registerBlock("aberrant_magenta_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_MAGENTA_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_magenta_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.MAGENTA_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_PURPLE_WOOL = registerCustomBlock("aberrant_purple_wool", Block::new, AbstractBlock.Settings.copy(Blocks.PURPLE_WOOL));
    public static final Block ABERRANT_PURPLE_SEAT = registerCustomBlock("aberrant_purple_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_PURPLE_WOOL).strength(0.4f));
    public static final Block ABERRANT_PURPLE_CONCRETE = registerCustomBlock("aberrant_purple_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE));
    public static final Block ABERRANT_PURPLE_CONCRETE_POWER = registerCustomBlock("aberrant_purple_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_PURPLE_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE_POWDER));
    public static final Block ABERRANT_PURPLE_TERRACOTTA = registerBlock("aberrant_purple_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_PURPLE_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_purple_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.PURPLE_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_BROWN_WOOL = registerCustomBlock("aberrant_brown_wool", Block::new, AbstractBlock.Settings.copy(Blocks.BROWN_WOOL));
    public static final Block ABERRANT_BROWN_SEAT = registerCustomBlock("aberrant_brown_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_BROWN_WOOL).strength(0.4f));
    public static final Block ABERRANT_BROWN_CONCRETE = registerCustomBlock("aberrant_brown_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE));
    public static final Block ABERRANT_BROWN_CONCRETE_POWER = registerCustomBlock("aberrant_brown_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_BROWN_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE_POWDER));
    public static final Block ABERRANT_BROWN_TERRACOTTA = registerBlock("aberrant_brown_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_BROWN_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_brown_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.BROWN_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_BLACK_WOOL = registerCustomBlock("aberrant_black_wool", Block::new, AbstractBlock.Settings.copy(Blocks.BLACK_WOOL));
    public static final Block ABERRANT_BLACK_SEAT = registerCustomBlock("aberrant_black_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_BLACK_WOOL).strength(0.4f));
    public static final Block ABERRANT_BLACK_CONCRETE = registerCustomBlock("aberrant_black_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE));
    public static final Block ABERRANT_BLACK_CONCRETE_POWER = registerCustomBlock("aberrant_black_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_BLACK_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE_POWDER));
    public static final Block ABERRANT_BLACK_TERRACOTTA = registerBlock("aberrant_black_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_BLACK_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_black_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.BLACK_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_GRAY_WOOL = registerCustomBlock("aberrant_gray_wool", Block::new, AbstractBlock.Settings.copy(Blocks.GRAY_WOOL));
    public static final Block ABERRANT_GRAY_SEAT = registerCustomBlock("aberrant_gray_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_GRAY_WOOL).strength(0.4f));
    public static final Block ABERRANT_GRAY_CONCRETE = registerCustomBlock("aberrant_gray_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE));
    public static final Block ABERRANT_GRAY_CONCRETE_POWER = registerCustomBlock("aberrant_gray_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_GRAY_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE_POWDER));
    public static final Block ABERRANT_GRAY_TERRACOTTA = registerBlock("aberrant_gray_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_GRAY_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_gray_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.GRAY_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_LIGHT_GRAY_WOOL = registerCustomBlock("aberrant_light_gray_wool", Block::new, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_WOOL));
    public static final Block ABERRANT_LIGHT_GRAY_SEAT = registerCustomBlock("aberrant_light_gray_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL).strength(0.4f));
    public static final Block ABERRANT_LIGHT_GRAY_CONCRETE = registerCustomBlock("aberrant_light_gray_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE));
    public static final Block ABERRANT_LIGHT_GRAY_CONCRETE_POWER = registerCustomBlock("aberrant_light_gray_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE_POWDER));
    public static final Block ABERRANT_LIGHT_GRAY_TERRACOTTA = registerBlock("aberrant_light_gray_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_LIGHT_GRAY_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_light_gray_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_WHITE_WOOL = registerCustomBlock("aberrant_white_wool", Block::new, AbstractBlock.Settings.copy(Blocks.WHITE_WOOL));
    public static final Block ABERRANT_WHITE_SEAT = registerCustomBlock("aberrant_white_seat", settings -> new SeatBlock(settings.nonOpaque()), AbstractBlock.Settings.copy(ModBlocks.ABERRANT_WHITE_WOOL).strength(0.4f));
    public static final Block ABERRANT_WHITE_CONCRETE = registerCustomBlock("aberrant_white_concrete", Block::new, AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE));
    public static final Block ABERRANT_WHITE_CONCRETE_POWER = registerCustomBlock("aberrant_white_concrete_powder", settings -> new ConcretePowderBlock(ModBlocks.ABERRANT_WHITE_CONCRETE, settings), AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE_POWDER));
    public static final Block ABERRANT_WHITE_TERRACOTTA = registerBlock("aberrant_white_terracotta", ABS_TERRACOTA);
    public static final Block ABERRANT_WHITE_GLAZED_TERRACOTTA = registerCustomBlock("aberrant_white_glazed_terracotta", GlazedTerracottaBlock::new, AbstractBlock.Settings.copy(Blocks.WHITE_GLAZED_TERRACOTTA));

    public static final Block ABERRANT_RED_CARPET = registerCustomBlock("aberrant_red_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.RED, settings), AbstractBlock.Settings.copy(Blocks.RED_CARPET));
    public static final Block ABERRANT_ORANGE_CARPET = registerCustomBlock("aberrant_orange_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.ORANGE, settings), AbstractBlock.Settings.copy(Blocks.ORANGE_CARPET));
    public static final Block ABERRANT_YELLOW_CARPET = registerCustomBlock("aberrant_yellow_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.YELLOW, settings), AbstractBlock.Settings.copy(Blocks.YELLOW_CARPET));
    public static final Block ABERRANT_LIME_CARPET = registerCustomBlock("aberrant_lime_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.LIME, settings), AbstractBlock.Settings.copy(Blocks.LIME_CARPET));
    public static final Block ABERRANT_GREEN_CARPET = registerCustomBlock("aberrant_green_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.GREEN, settings), AbstractBlock.Settings.copy(Blocks.GREEN_CARPET));
    public static final Block ABERRANT_CYAN_CARPET = registerCustomBlock("aberrant_cyan_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.CYAN, settings), AbstractBlock.Settings.copy(Blocks.CYAN_CARPET));
    public static final Block ABERRANT_LIGHT_BLUE_CARPET = registerCustomBlock("aberrant_light_blue_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.LIGHT_BLUE, settings), AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CARPET));
    public static final Block ABERRANT_BLUE_CARPET = registerCustomBlock("aberrant_blue_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.BLUE, settings), AbstractBlock.Settings.copy(Blocks.BLUE_CARPET));
    public static final Block ABERRANT_PINK_CARPET = registerCustomBlock("aberrant_pink_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.PINK, settings), AbstractBlock.Settings.copy(Blocks.PINK_CARPET));
    public static final Block ABERRANT_MAGENTA_CARPET = registerCustomBlock("aberrant_magenta_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.MAGENTA, settings), AbstractBlock.Settings.copy(Blocks.MAGENTA_CARPET));
    public static final Block ABERRANT_PURPLE_CARPET = registerCustomBlock("aberrant_purple_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.PURPLE, settings), AbstractBlock.Settings.copy(Blocks.PURPLE_CARPET));
    public static final Block ABERRANT_BROWN_CARPET = registerCustomBlock("aberrant_brown_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.BROWN, settings), AbstractBlock.Settings.copy(Blocks.BROWN_CARPET));
    public static final Block ABERRANT_BLACK_CARPET = registerCustomBlock("aberrant_black_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.BLACK, settings), AbstractBlock.Settings.copy(Blocks.BLACK_CARPET));
    public static final Block ABERRANT_GRAY_CARPET = registerCustomBlock("aberrant_gray_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.GRAY, settings), AbstractBlock.Settings.copy(Blocks.GRAY_CARPET));
    public static final Block ABERRANT_LIGHT_GRAY_CARPET = registerCustomBlock("aberrant_light_gray_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.LIGHT_GRAY, settings), AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CARPET));
    public static final Block ABERRANT_WHITE_CARPET = registerCustomBlock("aberrant_white_carpet", (AbstractBlock.Settings settings) -> new DyedCarpetBlock(DyeColor.WHITE, settings), AbstractBlock.Settings.copy(Blocks.WHITE_CARPET));

    public static final Block BEETROOT_RESIN_BRICKS = registerBlock("beetroot_resin_bricks", ABS_BRICKS);
    public static final Block BEETROOT_RESIN_BRICKS_STAIRS = registerCustomBlock("beetroot_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.BEETROOT_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block BEETROOT_RESIN_BRICKS_SLAB = registerCustomBlock("beetroot_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block BEETROOT_RESIN_BRICKS_WALL = registerCustomBlock("beetroot_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block BEETROOT_RESIN_BLOCK = registerBlock("beetroot_resin_block", ABS_RESIN_BLOCK);
    public static final Block BEETROOT_RESIN_BLOCK_STAIRS = registerCustomBlock("beetroot_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.BEETROOT_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block BEETROOT_RESIN_BLOCK_SLAB = registerCustomBlock("beetroot_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block BEETROOT_RESIN_BLOCK_WALL = registerCustomBlock("beetroot_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_BEETROOT_RESIN_BRICKS = registerBlock("chiseled_beetroot_resin_bricks", ABS_BRICKS);
    public static final Block BEETROOT_RESIN_CLUMP = registerCustomBlockNotItem("beetroot_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block CHORUS_RESIN_BRICKS = registerBlock("chorus_resin_bricks", ABS_BRICKS);
    public static final Block CHORUS_RESIN_BRICKS_STAIRS = registerCustomBlock("chorus_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CHORUS_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CHORUS_RESIN_BRICKS_SLAB = registerCustomBlock("chorus_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CHORUS_RESIN_BRICKS_WALL = registerCustomBlock("chorus_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CHORUS_RESIN_BLOCK = registerBlock("chorus_resin_block", ABS_RESIN_BLOCK);
    public static final Block CHORUS_RESIN_BLOCK_STAIRS = registerCustomBlock("chorus_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CHORUS_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHORUS_RESIN_BLOCK_SLAB = registerCustomBlock("chorus_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHORUS_RESIN_BLOCK_WALL = registerCustomBlock("chorus_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_CHORUS_RESIN_BRICKS = registerBlock("chiseled_chorus_resin_bricks", ABS_BRICKS);
    public static final Block CHORUS_RESIN_CLUMP = registerCustomBlockNotItem("chorus_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block LEMON_RESIN_BRICKS = registerBlock("lemon_resin_bricks", ABS_BRICKS);
    public static final Block LEMON_RESIN_BRICKS_STAIRS = registerCustomBlock("lemon_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.LEMON_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block LEMON_RESIN_BRICKS_SLAB = registerCustomBlock("lemon_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block LEMON_RESIN_BRICKS_WALL = registerCustomBlock("lemon_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block LEMON_RESIN_BLOCK = registerBlock("lemon_resin_block", ABS_RESIN_BLOCK);
    public static final Block LEMON_RESIN_BLOCK_STAIRS = registerCustomBlock("lemon_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.LEMON_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block LEMON_RESIN_BLOCK_SLAB = registerCustomBlock("lemon_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block LEMON_RESIN_BLOCK_WALL = registerCustomBlock("lemon_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_LEMON_RESIN_BRICKS = registerBlock("chiseled_lemon_resin_bricks", ABS_BRICKS);
    public static final Block LEMON_RESIN_CLUMP = registerCustomBlockNotItem("lemon_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block GLACIER_RESIN_BRICKS = registerBlock("glacier_resin_bricks", ABS_BRICKS);
    public static final Block GLACIER_RESIN_BRICKS_STAIRS = registerCustomBlock("glacier_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.GLACIER_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block GLACIER_RESIN_BRICKS_SLAB = registerCustomBlock("glacier_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block GLACIER_RESIN_BRICKS_WALL = registerCustomBlock("glacier_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block GLACIER_RESIN_BLOCK = registerBlock("glacier_resin_block", ABS_RESIN_BLOCK);
    public static final Block GLACIER_RESIN_BLOCK_STAIRS = registerCustomBlock("glacier_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.GLACIER_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block GLACIER_RESIN_BLOCK_SLAB = registerCustomBlock("glacier_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block GLACIER_RESIN_BLOCK_WALL = registerCustomBlock("glacier_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_GLACIER_RESIN_BRICKS = registerBlock("chiseled_glacier_resin_bricks", ABS_BRICKS);
    public static final Block GLACIER_RESIN_CLUMP = registerCustomBlockNotItem("glacier_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block CARAMEL_RESIN_BRICKS = registerBlock("caramel_resin_bricks", ABS_BRICKS);
    public static final Block CARAMEL_RESIN_BRICKS_STAIRS = registerCustomBlock("caramel_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CARAMEL_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CARAMEL_RESIN_BRICKS_SLAB = registerCustomBlock("caramel_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CARAMEL_RESIN_BRICKS_WALL = registerCustomBlock("caramel_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CARAMEL_RESIN_BLOCK = registerBlock("caramel_resin_block", ABS_RESIN_BLOCK);
    public static final Block CARAMEL_RESIN_BLOCK_STAIRS = registerCustomBlock("caramel_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CARAMEL_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CARAMEL_RESIN_BLOCK_SLAB = registerCustomBlock("caramel_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CARAMEL_RESIN_BLOCK_WALL = registerCustomBlock("caramel_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_CARAMEL_RESIN_BRICKS = registerBlock("chiseled_caramel_resin_bricks", ABS_BRICKS);
    public static final Block CARAMEL_RESIN_CLUMP = registerCustomBlockNotItem("caramel_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block TOXIC_RESIN_BRICKS = registerBlock("toxic_resin_bricks", ABS_BRICKS);
    public static final Block TOXIC_RESIN_BRICKS_STAIRS = registerCustomBlock("toxic_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.TOXIC_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block TOXIC_RESIN_BRICKS_SLAB = registerCustomBlock("toxic_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block TOXIC_RESIN_BRICKS_WALL = registerCustomBlock("toxic_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block TOXIC_RESIN_BLOCK = registerBlock("toxic_resin_block", ABS_RESIN_BLOCK);
    public static final Block TOXIC_RESIN_BLOCK_STAIRS = registerCustomBlock("toxic_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.TOXIC_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block TOXIC_RESIN_BLOCK_SLAB = registerCustomBlock("toxic_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block TOXIC_RESIN_BLOCK_WALL = registerCustomBlock("toxic_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_TOXIC_RESIN_BRICKS = registerBlock("chiseled_toxic_resin_bricks", ABS_BRICKS);
    public static final Block TOXIC_RESIN_CLUMP = registerCustomBlockNotItem("toxic_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block JADE_RESIN_BRICKS = registerBlock("jade_resin_bricks", ABS_BRICKS);
    public static final Block JADE_RESIN_BRICKS_STAIRS = registerCustomBlock("jade_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.JADE_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block JADE_RESIN_BRICKS_SLAB = registerCustomBlock("jade_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block JADE_RESIN_BRICKS_WALL = registerCustomBlock("jade_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block JADE_RESIN_BLOCK = registerBlock("jade_resin_block", ABS_RESIN_BLOCK);
    public static final Block JADE_RESIN_BLOCK_STAIRS = registerCustomBlock("jade_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.JADE_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block JADE_RESIN_BLOCK_SLAB = registerCustomBlock("jade_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block JADE_RESIN_BLOCK_WALL = registerCustomBlock("jade_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_JADE_RESIN_BRICKS = registerBlock("chiseled_jade_resin_bricks", ABS_BRICKS);
    public static final Block JADE_RESIN_CLUMP = registerCustomBlockNotItem("jade_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block BUBBLE_RESIN_BRICKS = registerBlock("bubble_resin_bricks", ABS_BRICKS);
    public static final Block BUBBLE_RESIN_BRICKS_STAIRS = registerCustomBlock("bubble_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.BUBBLE_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block BUBBLE_RESIN_BRICKS_SLAB = registerCustomBlock("bubble_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block BUBBLE_RESIN_BRICKS_WALL = registerCustomBlock("bubble_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block BUBBLE_RESIN_BLOCK = registerBlock("bubble_resin_block", ABS_RESIN_BLOCK);
    public static final Block BUBBLE_RESIN_BLOCK_STAIRS = registerCustomBlock("bubble_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.BUBBLE_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block BUBBLE_RESIN_BLOCK_SLAB = registerCustomBlock("bubble_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block BUBBLE_RESIN_BLOCK_WALL = registerCustomBlock("bubble_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_BUBBLE_RESIN_BRICKS = registerBlock("chiseled_bubble_resin_bricks", ABS_BRICKS);
    public static final Block BUBBLE_RESIN_CLUMP = registerCustomBlockNotItem("bubble_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block OCEAN_RESIN_BRICKS = registerBlock("ocean_resin_bricks", ABS_BRICKS);
    public static final Block OCEAN_RESIN_BRICKS_STAIRS = registerCustomBlock("ocean_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OCEAN_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEAN_RESIN_BRICKS_SLAB = registerCustomBlock("ocean_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEAN_RESIN_BRICKS_WALL = registerCustomBlock("ocean_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block OCEAN_RESIN_BLOCK = registerBlock("ocean_resin_block", ABS_RESIN_BLOCK);
    public static final Block OCEAN_RESIN_BLOCK_STAIRS = registerCustomBlock("ocean_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OCEAN_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block OCEAN_RESIN_BLOCK_SLAB = registerCustomBlock("ocean_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block OCEAN_RESIN_BLOCK_WALL = registerCustomBlock("ocean_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_OCEAN_RESIN_BRICKS = registerBlock("chiseled_ocean_resin_bricks", ABS_BRICKS);
    public static final Block OCEAN_RESIN_CLUMP = registerCustomBlockNotItem("ocean_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block EMERALD_RESIN_BRICKS = registerBlock("emerald_resin_bricks", ABS_BRICKS);
    public static final Block EMERALD_RESIN_BRICKS_STAIRS = registerCustomBlock("emerald_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.EMERALD_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block EMERALD_RESIN_BRICKS_SLAB = registerCustomBlock("emerald_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block EMERALD_RESIN_BRICKS_WALL = registerCustomBlock("emerald_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block EMERALD_RESIN_BLOCK = registerBlock("emerald_resin_block", ABS_RESIN_BLOCK);
    public static final Block EMERALD_RESIN_BLOCK_STAIRS = registerCustomBlock("emerald_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.EMERALD_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block EMERALD_RESIN_BLOCK_SLAB = registerCustomBlock("emerald_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block EMERALD_RESIN_BLOCK_WALL = registerCustomBlock("emerald_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_EMERALD_RESIN_BRICKS = registerBlock("chiseled_emerald_resin_bricks", ABS_BRICKS);
    public static final Block EMERALD_RESIN_CLUMP = registerCustomBlockNotItem("emerald_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block DUSK_RESIN_BRICKS = registerBlock("dusk_resin_bricks", ABS_BRICKS);
    public static final Block DUSK_RESIN_BRICKS_STAIRS = registerCustomBlock("dusk_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DUSK_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block DUSK_RESIN_BRICKS_SLAB = registerCustomBlock("dusk_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block DUSK_RESIN_BRICKS_WALL = registerCustomBlock("dusk_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block DUSK_RESIN_BLOCK = registerBlock("dusk_resin_block", ABS_RESIN_BLOCK);
    public static final Block DUSK_RESIN_BLOCK_STAIRS = registerCustomBlock("dusk_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DUSK_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block DUSK_RESIN_BLOCK_SLAB = registerCustomBlock("dusk_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block DUSK_RESIN_BLOCK_WALL = registerCustomBlock("dusk_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_DUSK_RESIN_BRICKS = registerBlock("chiseled_dusk_resin_bricks", ABS_BRICKS);
    public static final Block DUSK_RESIN_CLUMP = registerCustomBlockNotItem("dusk_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block DAYBREAK_RESIN_BRICKS = registerBlock("daybreak_resin_bricks", ABS_BRICKS);
    public static final Block DAYBREAK_RESIN_BRICKS_STAIRS = registerCustomBlock("daybreak_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DAYBREAK_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block DAYBREAK_RESIN_BRICKS_SLAB = registerCustomBlock("daybreak_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block DAYBREAK_RESIN_BRICKS_WALL = registerCustomBlock("daybreak_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block DAYBREAK_RESIN_BLOCK = registerBlock("daybreak_resin_block", ABS_RESIN_BLOCK);
    public static final Block DAYBREAK_RESIN_BLOCK_STAIRS = registerCustomBlock("daybreak_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DAYBREAK_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block DAYBREAK_RESIN_BLOCK_SLAB = registerCustomBlock("daybreak_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block DAYBREAK_RESIN_BLOCK_WALL = registerCustomBlock("daybreak_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_DAYBREAK_RESIN_BRICKS = registerBlock("chiseled_daybreak_resin_bricks", ABS_BRICKS);
    public static final Block DAYBREAK_RESIN_CLUMP = registerCustomBlockNotItem("daybreak_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block SILT_RESIN_BRICKS = registerBlock("silt_resin_bricks", ABS_BRICKS);
    public static final Block SILT_RESIN_BRICKS_STAIRS = registerCustomBlock("silt_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.SILT_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block SILT_RESIN_BRICKS_SLAB = registerCustomBlock("silt_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block SILT_RESIN_BRICKS_WALL = registerCustomBlock("silt_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block SILT_RESIN_BLOCK = registerBlock("silt_resin_block", ABS_RESIN_BLOCK);
    public static final Block SILT_RESIN_BLOCK_STAIRS = registerCustomBlock("silt_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.SILT_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block SILT_RESIN_BLOCK_SLAB = registerCustomBlock("silt_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block SILT_RESIN_BLOCK_WALL = registerCustomBlock("silt_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_SILT_RESIN_BRICKS = registerBlock("chiseled_silt_resin_bricks", ABS_BRICKS);
    public static final Block SILT_RESIN_CLUMP = registerCustomBlockNotItem("silt_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block GRAPHITE_RESIN_BRICKS = registerBlock("graphite_resin_bricks", ABS_BRICKS);
    public static final Block GRAPHITE_RESIN_BRICKS_STAIRS = registerCustomBlock("graphite_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.GRAPHITE_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block GRAPHITE_RESIN_BRICKS_SLAB = registerCustomBlock("graphite_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block GRAPHITE_RESIN_BRICKS_WALL = registerCustomBlock("graphite_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block GRAPHITE_RESIN_BLOCK = registerBlock("graphite_resin_block", ABS_RESIN_BLOCK);
    public static final Block GRAPHITE_RESIN_BLOCK_STAIRS = registerCustomBlock("graphite_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.GRAPHITE_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block GRAPHITE_RESIN_BLOCK_SLAB = registerCustomBlock("graphite_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block GRAPHITE_RESIN_BLOCK_WALL = registerCustomBlock("graphite_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_GRAPHITE_RESIN_BRICKS = registerBlock("chiseled_graphite_resin_bricks", ABS_BRICKS);
    public static final Block GRAPHITE_RESIN_CLUMP = registerCustomBlockNotItem("graphite_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block OBSIDIAN_RESIN_BRICKS = registerBlock("obsidian_resin_bricks", ABS_BRICKS);
    public static final Block OBSIDIAN_RESIN_BRICKS_STAIRS = registerCustomBlock("obsidian_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OBSIDIAN_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block OBSIDIAN_RESIN_BRICKS_SLAB = registerCustomBlock("obsidian_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block OBSIDIAN_RESIN_BRICKS_WALL = registerCustomBlock("obsidian_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block OBSIDIAN_RESIN_BLOCK = registerBlock("obsidian_resin_block", ABS_RESIN_BLOCK);
    public static final Block OBSIDIAN_RESIN_BLOCK_STAIRS = registerCustomBlock("obsidian_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OBSIDIAN_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block OBSIDIAN_RESIN_BLOCK_SLAB = registerCustomBlock("obsidian_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block OBSIDIAN_RESIN_BLOCK_WALL = registerCustomBlock("obsidian_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_OBSIDIAN_RESIN_BRICKS = registerBlock("chiseled_obsidian_resin_bricks", ABS_BRICKS);
    public static final Block OBSIDIAN_RESIN_CLUMP = registerCustomBlockNotItem("obsidian_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block COCOA_RESIN_BRICKS = registerBlock("cocoa_resin_bricks", ABS_BRICKS);
    public static final Block COCOA_RESIN_BRICKS_STAIRS = registerCustomBlock("cocoa_resin_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.COCOA_RESIN_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block COCOA_RESIN_BRICKS_SLAB = registerCustomBlock("cocoa_resin_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block COCOA_RESIN_BRICKS_WALL = registerCustomBlock("cocoa_resin_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block COCOA_RESIN_BLOCK = registerBlock("cocoa_resin_block", ABS_RESIN_BLOCK);
    public static final Block COCOA_RESIN_BLOCK_STAIRS = registerCustomBlock("cocoa_resin_block_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.COCOA_RESIN_BLOCK.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block COCOA_RESIN_BLOCK_SLAB = registerCustomBlock("cocoa_resin_block_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block COCOA_RESIN_BLOCK_WALL = registerCustomBlock("cocoa_resin_block_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHISELED_COCOA_RESIN_BRICKS = registerBlock("chiseled_cocoa_resin_bricks", ABS_BRICKS);
    public static final Block COCOA_RESIN_CLUMP = registerCustomBlockNotItem("cocoa_resin_clump", MultifaceBlock::new, ABS_CLUMPS);

    public static final Block POLISHED_RESIN = registerBlock("polished_resin", ABS_RESIN_BLOCK);
    public static final Block POLISHED_RESIN_STAIRS = registerCustomBlock("polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block POLISHED_RESIN_SLAB = registerCustomBlock("polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block POLISHED_RESIN_WALL = registerCustomBlock("polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block BEETROOT_POLISHED_RESIN = registerBlock("beetroot_polished_resin", ABS_RESIN_BLOCK);
    public static final Block BEETROOT_POLISHED_RESIN_STAIRS = registerCustomBlock("beetroot_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.BEETROOT_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block BEETROOT_POLISHED_RESIN_SLAB = registerCustomBlock("beetroot_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block BEETROOT_POLISHED_RESIN_WALL = registerCustomBlock("beetroot_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block CARAMEL_POLISHED_RESIN = registerBlock("caramel_polished_resin", ABS_RESIN_BLOCK);
    public static final Block CARAMEL_POLISHED_RESIN_STAIRS = registerCustomBlock("caramel_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CARAMEL_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CARAMEL_POLISHED_RESIN_SLAB = registerCustomBlock("caramel_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CARAMEL_POLISHED_RESIN_WALL = registerCustomBlock("caramel_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block LEMON_POLISHED_RESIN = registerBlock("lemon_polished_resin", ABS_RESIN_BLOCK);
    public static final Block LEMON_POLISHED_RESIN_STAIRS = registerCustomBlock("lemon_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.LEMON_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block LEMON_POLISHED_RESIN_SLAB = registerCustomBlock("lemon_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block LEMON_POLISHED_RESIN_WALL = registerCustomBlock("lemon_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block TOXIC_POLISHED_RESIN = registerBlock("toxic_polished_resin", ABS_RESIN_BLOCK);
    public static final Block TOXIC_POLISHED_RESIN_STAIRS = registerCustomBlock("toxic_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.TOXIC_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block TOXIC_POLISHED_RESIN_SLAB = registerCustomBlock("toxic_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block TOXIC_POLISHED_RESIN_WALL = registerCustomBlock("toxic_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block EMERALD_POLISHED_RESIN = registerBlock("emerald_polished_resin", ABS_RESIN_BLOCK);
    public static final Block EMERALD_POLISHED_RESIN_STAIRS = registerCustomBlock("emerald_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.EMERALD_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block EMERALD_POLISHED_RESIN_SLAB = registerCustomBlock("emerald_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block EMERALD_POLISHED_RESIN_WALL = registerCustomBlock("emerald_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block JADE_POLISHED_RESIN = registerBlock("jade_polished_resin", ABS_RESIN_BLOCK);
    public static final Block JADE_POLISHED_RESIN_STAIRS = registerCustomBlock("jade_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.JADE_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block JADE_POLISHED_RESIN_SLAB = registerCustomBlock("jade_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block JADE_POLISHED_RESIN_WALL = registerCustomBlock("jade_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block OCEAN_POLISHED_RESIN = registerBlock("ocean_polished_resin", ABS_RESIN_BLOCK);
    public static final Block OCEAN_POLISHED_RESIN_STAIRS = registerCustomBlock("ocean_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OCEAN_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block OCEAN_POLISHED_RESIN_SLAB = registerCustomBlock("ocean_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block OCEAN_POLISHED_RESIN_WALL = registerCustomBlock("ocean_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block GLACIER_POLISHED_RESIN = registerBlock("glacier_polished_resin", ABS_RESIN_BLOCK);
    public static final Block GLACIER_POLISHED_RESIN_STAIRS = registerCustomBlock("glacier_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.GLACIER_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block GLACIER_POLISHED_RESIN_SLAB = registerCustomBlock("glacier_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block GLACIER_POLISHED_RESIN_WALL = registerCustomBlock("glacier_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block BUBBLE_POLISHED_RESIN = registerBlock("bubble_polished_resin", ABS_RESIN_BLOCK);
    public static final Block BUBBLE_POLISHED_RESIN_STAIRS = registerCustomBlock("bubble_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.BUBBLE_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block BUBBLE_POLISHED_RESIN_SLAB = registerCustomBlock("bubble_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block BUBBLE_POLISHED_RESIN_WALL = registerCustomBlock("bubble_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block DUSK_POLISHED_RESIN = registerBlock("dusk_polished_resin", ABS_RESIN_BLOCK);
    public static final Block DUSK_POLISHED_RESIN_STAIRS = registerCustomBlock("dusk_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DUSK_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block DUSK_POLISHED_RESIN_SLAB = registerCustomBlock("dusk_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block DUSK_POLISHED_RESIN_WALL = registerCustomBlock("dusk_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block CHORUS_POLISHED_RESIN = registerBlock("chorus_polished_resin", ABS_RESIN_BLOCK);
    public static final Block CHORUS_POLISHED_RESIN_STAIRS = registerCustomBlock("chorus_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CHORUS_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHORUS_POLISHED_RESIN_SLAB = registerCustomBlock("chorus_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block CHORUS_POLISHED_RESIN_WALL = registerCustomBlock("chorus_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block DAYBREAK_POLISHED_RESIN = registerBlock("daybreak_polished_resin", ABS_RESIN_BLOCK);
    public static final Block DAYBREAK_POLISHED_RESIN_STAIRS = registerCustomBlock("daybreak_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DAYBREAK_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block DAYBREAK_POLISHED_RESIN_SLAB = registerCustomBlock("daybreak_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block DAYBREAK_POLISHED_RESIN_WALL = registerCustomBlock("daybreak_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block SILT_POLISHED_RESIN = registerBlock("silt_polished_resin", ABS_RESIN_BLOCK);
    public static final Block SILT_POLISHED_RESIN_STAIRS = registerCustomBlock("silt_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.SILT_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block SILT_POLISHED_RESIN_SLAB = registerCustomBlock("silt_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block SILT_POLISHED_RESIN_WALL = registerCustomBlock("silt_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block GRAPHITE_POLISHED_RESIN = registerBlock("graphite_polished_resin", ABS_RESIN_BLOCK);
    public static final Block GRAPHITE_POLISHED_RESIN_STAIRS = registerCustomBlock("graphite_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.GRAPHITE_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block GRAPHITE_POLISHED_RESIN_SLAB = registerCustomBlock("graphite_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block GRAPHITE_POLISHED_RESIN_WALL = registerCustomBlock("graphite_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block OBSIDIAN_POLISHED_RESIN = registerBlock("obsidian_polished_resin", ABS_RESIN_BLOCK);
    public static final Block OBSIDIAN_POLISHED_RESIN_STAIRS = registerCustomBlock("obsidian_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.OBSIDIAN_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block OBSIDIAN_POLISHED_RESIN_SLAB = registerCustomBlock("obsidian_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block OBSIDIAN_POLISHED_RESIN_WALL = registerCustomBlock("obsidian_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block COCOA_POLISHED_RESIN = registerBlock("cocoa_polished_resin", ABS_RESIN_BLOCK);
    public static final Block COCOA_POLISHED_RESIN_STAIRS = registerCustomBlock("cocoa_polished_resin_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.COCOA_POLISHED_RESIN.getDefaultState(), ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block COCOA_POLISHED_RESIN_SLAB = registerCustomBlock("cocoa_polished_resin_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);
    public static final Block COCOA_POLISHED_RESIN_WALL = registerCustomBlock("cocoa_polished_resin_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_RESIN_BLOCK), ABS_RESIN_BLOCK);

    public static final Block AMETHYST_TILES = registerBlock("amethyst_tiles", ABS_AMETHYST);
    public static final Block AMETHYST_TILES_STAIRS = registerCustomBlock("amethyst_tiles_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.AMETHYST_TILES.getDefaultState(), ABS_AMETHYST), ABS_AMETHYST);
    public static final Block AMETHYST_TILES_SLAB = registerCustomBlock("amethyst_tiles_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_AMETHYST), ABS_AMETHYST);
    public static final Block AMETHYST_TILES_WALL = registerCustomBlock("amethyst_tiles_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_AMETHYST), ABS_AMETHYST);

    public static final Block AMETHYST_BRICKS = registerBlock("amethyst_bricks", ABS_AMETHYST);
    public static final Block AMETHYST_BRICKS_STAIRS = registerCustomBlock("amethyst_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.AMETHYST_BRICKS.getDefaultState(), ABS_AMETHYST), ABS_AMETHYST);
    public static final Block AMETHYST_BRICKS_SLAB = registerCustomBlock("amethyst_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_AMETHYST), ABS_AMETHYST);
    public static final Block AMETHYST_BRICKS_WALL = registerCustomBlock("amethyst_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_AMETHYST), ABS_AMETHYST);

    public static final Block ABERRANT_AMETHYST_BLOCK = registerBlock("aberrant_amethyst_block", ABS_AMETHYST);
    public static final Block BUDDING_ABERRANT_AMETHYST = registerBlock("budding_aberrant_amethyst", ABS_BUDDING_AMETHYST);
    public static final Block SMALL_ABERRANT_AMETHYST_BUD = registerCustomBlock("small_aberrant_amethyst_bud", (AbstractBlock.Settings settings) -> new AmethystClusterBlock(3.0f, 8.0f, ABS_SMALL_AMETHYST_BUD), ABS_SMALL_AMETHYST_BUD);
    public static final Block MEDIUM_ABERRANT_AMETHYST_BUD = registerCustomBlock("medium_aberrant_amethyst_bud", (AbstractBlock.Settings settings) -> new AmethystClusterBlock(4.0f, 10.0f, ABS_MEDIUM_AMETHYST_BUD), ABS_MEDIUM_AMETHYST_BUD);
    public static final Block LARGE_ABERRANT_AMETHYST_BUD = registerCustomBlock("large_aberrant_amethyst_bud", (AbstractBlock.Settings settings) -> new AmethystClusterBlock(5.0f, 10.0f, ABS_LARGE_AMETHYST_BUD), ABS_LARGE_AMETHYST_BUD);
    public static final Block ABERRANT_AMETHYST_CLUSTER = registerCustomBlock("aberrant_amethyst_cluster", (AbstractBlock.Settings settings) -> new AmethystClusterBlock(7.0f, 10.0f, ABS_AMETHYST_CLUSTER), ABS_AMETHYST_CLUSTER);

    public static final Block ABERRANT_AMETHYST_TILES = registerBlock("aberrant_amethyst_tiles", ABS_AMETHYST);
    public static final Block ABERRANT_AMETHYST_TILES_STAIRS = registerCustomBlock("aberrant_amethyst_tiles_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_AMETHYST_TILES.getDefaultState(), ABS_AMETHYST), ABS_AMETHYST);
    public static final Block ABERRANT_AMETHYST_TILES_SLAB = registerCustomBlock("aberrant_amethyst_tiles_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_AMETHYST), ABS_AMETHYST);
    public static final Block ABERRANT_AMETHYST_TILES_WALL = registerCustomBlock("aberrant_amethyst_tiles_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_AMETHYST), ABS_AMETHYST);

    public static final Block ABERRANT_AMETHYST_BRICKS = registerBlock("aberrant_amethyst_bricks", ABS_AMETHYST);
    public static final Block ABERRANT_AMETHYST_BRICKS_STAIRS = registerCustomBlock("aberrant_amethyst_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_AMETHYST_BRICKS.getDefaultState(), ABS_AMETHYST), ABS_AMETHYST);
    public static final Block ABERRANT_AMETHYST_BRICKS_SLAB = registerCustomBlock("aberrant_amethyst_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_AMETHYST), ABS_AMETHYST);
    public static final Block ABERRANT_AMETHYST_BRICKS_WALL = registerCustomBlock("aberrant_amethyst_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_AMETHYST), ABS_AMETHYST);

    public static final Block ABERRANT_SOUL_SANDSTONE = registerBlock("aberrant_soul_sandstone",  ABS_SANDSTONE);
    public static final Block ABERRANT_SOUL_SANDSTONE_STAIRS = registerCustomBlock("aberrant_soul_sandstone_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_SOUL_SANDSTONE.getDefaultState(), ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block ABERRANT_SOUL_SANDSTONE_SLAB = registerCustomBlock("aberrant_soul_sandstone_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block ABERRANT_SOUL_SANDSTONE_WALL = registerCustomBlock("aberrant_soul_sandstone_wall",  (AbstractBlock.Settings settings) -> new WallBlock(ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block ABERRANT_CUT_SOUL_SANDSTONE = registerBlock("aberrant_cut_soul_sandstone",  ABS_SANDSTONE);
    public static final Block ABERRANT_CHISELED_SOUL_SANDSTONE = registerBlock("aberrant_chiseled_soul_sandstone",  ABS_SANDSTONE);
    public static final Block ABERRANT_SMOOTH_SOUL_SANDSTONE = registerBlock("aberrant_smooth_soul_sandstone",  ABS_SANDSTONE);
    public static final Block ABERRANT_SMOOTH_SOUL_SANDSTONE_STAIRS = registerCustomBlock("aberrant_smooth_soul_sandstone_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE.getDefaultState(), ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB = registerCustomBlock("aberrant_smooth_soul_sandstone_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_SANDSTONE), ABS_SANDSTONE);
    public static final Block ABERRANT_SMOOTH_SOUL_SANDSTONE_WALL = registerCustomBlock("aberrant_smooth_soul_sandstone_wall",  (AbstractBlock.Settings settings) -> new WallBlock(ABS_SANDSTONE), ABS_SANDSTONE);

    public static final Block ABERRANT_PUMPKIN = registerCustomBlock("aberrant_pumpkin", PumpkinBlock::new, AbstractBlock.Settings.copy(Blocks.PUMPKIN));
    public static final Block ABERRANT_CARVED_PUMPKIN = registerCustomBlock("aberrant_carved_pumpkin", CarvedPumpkinBlock::new, AbstractBlock.Settings.copy(Blocks.CARVED_PUMPKIN));
    public static final Block ABERRANT_JACK_O_LANTERN = registerCustomBlock("aberrant_jack_o_lantern", CarvedPumpkinBlock::new, AbstractBlock.Settings.copy(Blocks.JACK_O_LANTERN));

    public static final Block ABERRANT_OBSIDIAN = registerBlock("aberrant_obsidian", AbstractBlock.Settings.copy(Blocks.OBSIDIAN));
    public static final Block ABERRANT_CRYING_OBSIDIAN = registerCustomBlock("aberrant_crying_obsidian", CryingObsidianBlock::new, AbstractBlock.Settings.copy(Blocks.CRYING_OBSIDIAN));

    public static final Block ABERRANT_NETHERRACK = registerBlock("aberrant_netherrack", AbstractBlock.Settings.copy(Blocks.NETHERRACK));

    public static final Block ABERRANT_NETHER_BRICKS = registerBlock("aberrant_nether_bricks", ABS_NETHER_BRICKS);
    public static final Block ABERRANT_NETHER_BRICKS_STAIRS = registerCustomBlock("aberrant_nether_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_NETHER_BRICKS.getDefaultState(), ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);
    public static final Block ABERRANT_NETHER_BRICKS_SLAB = registerCustomBlock("aberrant_nether_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);
    public static final Block ABERRANT_NETHER_BRICKS_WALL = registerCustomBlock("aberrant_nether_bricks_wall",  (AbstractBlock.Settings settings) -> new WallBlock(ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);

    public static final Block CRACKED_ABERRANT_NETHER_BRICKS = registerBlock("cracked_aberrant_nether_bricks", ABS_NETHER_BRICKS);
    public static final Block CRACKED_ABERRANT_NETHER_BRICKS_STAIRS = registerCustomBlock("cracked_aberrant_nether_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS.getDefaultState(), ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);
    public static final Block CRACKED_ABERRANT_NETHER_BRICKS_SLAB = registerCustomBlock("cracked_aberrant_nether_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);
    public static final Block CRACKED_ABERRANT_NETHER_BRICKS_WALL = registerCustomBlock("cracked_aberrant_nether_bricks_wall",  (AbstractBlock.Settings settings) -> new WallBlock(ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);

    public static final Block CHISELED_ABERRANT_NETHER_BRICKS = registerBlock("chiseled_aberrant_nether_bricks", ABS_NETHER_BRICKS);
    public static final Block CHISELED_ABERRANT_NETHER_BRICKS_STAIRS = registerCustomBlock("chiseled_aberrant_nether_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS.getDefaultState(), ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);
    public static final Block CHISELED_ABERRANT_NETHER_BRICKS_SLAB = registerCustomBlock("chiseled_aberrant_nether_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);
    public static final Block CHISELED_ABERRANT_NETHER_BRICKS_WALL = registerCustomBlock("chiseled_aberrant_nether_bricks_wall",  (AbstractBlock.Settings settings) -> new WallBlock(ABS_NETHER_BRICKS), ABS_NETHER_BRICKS);

    public static final Block ABERRANT_RED_NETHER_BRICKS = registerBlock("aberrant_red_nether_bricks", ABS_RED_NETHER_BRICKS);
    public static final Block ABERRANT_RED_NETHER_BRICKS_STAIRS = registerCustomBlock("aberrant_red_nether_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.ABERRANT_RED_NETHER_BRICKS.getDefaultState(), ABS_RED_NETHER_BRICKS), ABS_RED_NETHER_BRICKS);
    public static final Block ABERRANT_RED_NETHER_BRICKS_SLAB = registerCustomBlock("aberrant_red_nether_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_RED_NETHER_BRICKS), ABS_RED_NETHER_BRICKS);
    public static final Block ABERRANT_RED_NETHER_BRICKS_WALL = registerCustomBlock("aberrant_red_nether_bricks_wall",  (AbstractBlock.Settings settings) -> new WallBlock(ABS_RED_NETHER_BRICKS), ABS_RED_NETHER_BRICKS);

    public static final Block ABERRANT_GLOWSTONE = registerBlock("aberrant_glowstone", AbstractBlock.Settings.copy(Blocks.GLOWSTONE));

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

    private static Block registerCustomBlockNotItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Bauen.MOD_ID, name));
        Block block = factory.apply(blockSettings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bauen.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

//    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
//        return Blocks.register(Blocks.keyOf(id), factory, settings);
//    }
//
//    public static Block register(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
//        Block block = factory.apply(settings.registryKey(key));
//        return Registry.register(Registries.BLOCK, key, block);
//    }

    public static void registerModBlocks() {
        Bauen.LOGGER.info(Bauen.MOD_ID + " || Registering ModBlocks");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.MOSSY_BRICKS);
            entries.add(ModBlocks.MOSSY_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_BRICKS);
            entries.add(ModBlocks.CRACKED_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_BRICKS_WALL);
            entries.add(ModBlocks.CHISELED_BRICKS);
            entries.add(ModBlocks.CHISELED_BRICKS_STAIRS);
            entries.add(ModBlocks.CHISELED_BRICKS_SLAB);
            entries.add(ModBlocks.CHISELED_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_CHISELED_BRICKS);
            entries.add(ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_CHISELED_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_CHISELED_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_CHISELED_BRICKS);
            entries.add(ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_CHISELED_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_CHISELED_BRICKS_WALL);

            entries.add(ModBlocks.GOLD_CHAIN);
            entries.add(ModBlocks.GOLD_LANTERN);
            entries.add(ModBlocks.GOLD_BARS);
            entries.add(ModBlocks.CUT_GOLD);
            entries.add(ModBlocks.CUT_GOLD_STAIRS);
            entries.add(ModBlocks.CUT_GOLD_SLAB);
            entries.add(ModBlocks.CUT_GOLD_WALL);
            entries.add(ModBlocks.CHISELED_GOLD);
            entries.add(ModBlocks.GOLD_GRATE);
            entries.add(ModBlocks.GOLD_TRAPDOOR);
            entries.add(ModBlocks.GOLD_DOOR);
            entries.add(ModBlocks.GOLD_COINS);
            entries.add(ModBlocks.GOLD_HOARD);
            entries.add(ModBlocks.GOLD_HOARD_BLOCK);

            entries.add(ModBlocks.MIXED_COBBLESTONE);
            entries.add(ModBlocks.MIXED_COBBLESTONE_STAIRS);
            entries.add(ModBlocks.MIXED_COBBLESTONE_SLAB);
            entries.add(ModBlocks.MIXED_COBBLESTONE_WALL);

            entries.add(ModBlocks.INDUSTRIAL_IRON_BLOCK);
            entries.add(ModBlocks.INDUSTRIAL_IRON_STAIRS);
            entries.add(ModBlocks.INDUSTRIAL_IRON_SLAB);
            entries.add(ModBlocks.INDUSTRIAL_IRON_WALL);
            entries.add(ModBlocks.CUT_INDUSTRIAL_IRON);
            entries.add(ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS);
            entries.add(ModBlocks.CUT_INDUSTRIAL_IRON_SLAB);
            entries.add(ModBlocks.CUT_INDUSTRIAL_IRON_WALL);
            entries.add(ModBlocks.CARVED_INDUSTRIAL_IRON);
            entries.add(ModBlocks.INDUSTRIAL_IRON_GRATE);
            entries.add(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
            entries.add(ModBlocks.INDUSTRIAL_IRON_DOOR);

            entries.add(ModBlocks.ICE_STAIRS);
            entries.add(ModBlocks.ICE_SLAB);
            entries.add(ModBlocks.ICE_WALL);
            entries.add(ModBlocks.PACKED_ICE_STAIRS);
            entries.add(ModBlocks.PACKED_ICE_SLAB);
            entries.add(ModBlocks.PACKED_ICE_WALL);
            entries.add(ModBlocks.MUD_STAIRS);
            entries.add(ModBlocks.MUD_SLAB);
            entries.add(ModBlocks.MUD_WALL);
            entries.add(ModBlocks.MOSSY_PACKED_MUD);
            entries.add(ModBlocks.MOSSY_PACKED_MUD_STAIRS);
            entries.add(ModBlocks.MOSSY_PACKED_MUD_SLAB);
            entries.add(ModBlocks.MOSSY_PACKED_MUD_WALL);
            entries.add(ModBlocks.MOSSY_MUD_BRICKS);
            entries.add(ModBlocks.MOSSY_MUD_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_MUD_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_MUD_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_TUFF_BRICKS);
            entries.add(ModBlocks.MOSSY_TUFF_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_TUFF_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_TUFF_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_TUFF_BRICKS);
            entries.add(ModBlocks.CRACKED_TUFF_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_TUFF_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_TUFF_BRICKS_WALL);
            entries.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS);
            entries.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS);
            entries.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB);
            entries.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL);

            entries.add(ModBlocks.MIDNIGHT_BRICKS);
            entries.add(ModBlocks.MIDNIGHT_BRICKS_STAIRS);
            entries.add(ModBlocks.MIDNIGHT_BRICKS_SLAB);
            entries.add(ModBlocks.MIDNIGHT_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL);
            entries.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS);
            entries.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB);
            entries.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);
            entries.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL);

            entries.add(ModBlocks.KAOLIN_CLAY);

            entries.add(ModBlocks.TREATED_BRICKS);
            entries.add(ModBlocks.TREATED_BRICKS_STAIRS);
            entries.add(ModBlocks.TREATED_BRICKS_SLAB);
            entries.add(ModBlocks.TREATED_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_TREATED_BRICKS);
            entries.add(ModBlocks.MOSSY_TREATED_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_TREATED_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_TREATED_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_TREATED_BRICKS);
            entries.add(ModBlocks.CRACKED_TREATED_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_TREATED_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_TREATED_BRICKS_WALL);
            entries.add(ModBlocks.CHISELED_TREATED_BRICKS);
            entries.add(ModBlocks.CHISELED_TREATED_BRICKS_STAIRS);
            entries.add(ModBlocks.CHISELED_TREATED_BRICKS_SLAB);
            entries.add(ModBlocks.CHISELED_TREATED_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
            entries.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
            entries.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL);
            entries.add(ModBlocks.MIXED_BRICKS);
            entries.add(ModBlocks.MIXED_BRICKS_STAIRS);
            entries.add(ModBlocks.MIXED_BRICKS_SLAB);
            entries.add(ModBlocks.MIXED_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_MIXED_BRICKS);
            entries.add(ModBlocks.MOSSY_MIXED_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_MIXED_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_MIXED_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_MIXED_BRICKS);
            entries.add(ModBlocks.CRACKED_MIXED_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_MIXED_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_MIXED_BRICKS_WALL);

            entries.add(ModBlocks.POLISHED_CALCITE);
            entries.add(ModBlocks.POLISHED_CALCITE_STAIRS);
            entries.add(ModBlocks.POLISHED_CALCITE_SLAB);
            entries.add(ModBlocks.POLISHED_CALCITE_WALL);
            entries.add(ModBlocks.CALCITE_BRICKS);
            entries.add(ModBlocks.CALCITE_BRICKS_STAIRS);
            entries.add(ModBlocks.CALCITE_BRICKS_SLAB);
            entries.add(ModBlocks.CALCITE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_CALCITE_BRICKS);
            entries.add(ModBlocks.POLISHED_CALCITE_BRICKS_STAIRS);
            entries.add(ModBlocks.POLISHED_CALCITE_BRICKS_SLAB);
            entries.add(ModBlocks.POLISHED_CALCITE_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_CALCITE_BRICKS);
            entries.add(ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_CALCITE_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_CALCITE_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_CALCITE_BRICKS);
            entries.add(ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_CALCITE_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_CALCITE_BRICKS_WALL);

            entries.add(ModBlocks.ANDESITE_BRICKS);
            entries.add(ModBlocks.ANDESITE_BRICKS_STAIRS);
            entries.add(ModBlocks.ANDESITE_BRICKS_SLAB);
            entries.add(ModBlocks.ANDESITE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_ANDESITE_BRICKS);
            entries.add(ModBlocks.POLISHED_ANDESITE_BRICKS_STAIRS);
            entries.add(ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB);
            entries.add(ModBlocks.POLISHED_ANDESITE_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_ANDESITE_BRICKS);
            entries.add(ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_ANDESITE_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_ANDESITE_BRICKS);
            entries.add(ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_ANDESITE_BRICKS_WALL);

            entries.add(ModBlocks.DIORITE_BRICKS);
            entries.add(ModBlocks.DIORITE_BRICKS_STAIRS);
            entries.add(ModBlocks.DIORITE_BRICKS_SLAB);
            entries.add(ModBlocks.DIORITE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_DIORITE_BRICKS);
            entries.add(ModBlocks.POLISHED_DIORITE_BRICKS_STAIRS);
            entries.add(ModBlocks.POLISHED_DIORITE_BRICKS_SLAB);
            entries.add(ModBlocks.POLISHED_DIORITE_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_DIORITE_BRICKS);
            entries.add(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_DIORITE_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_DIORITE_BRICKS);
            entries.add(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_DIORITE_BRICKS_WALL);

            entries.add(ModBlocks.POLISHED_DRIPSTONE);
            entries.add(ModBlocks.POLISHED_DRIPSTONE_STAIRS);
            entries.add(ModBlocks.POLISHED_DRIPSTONE_SLAB);
            entries.add(ModBlocks.POLISHED_DRIPSTONE_WALL);
            entries.add(ModBlocks.DRIPSTONE_BRICKS);
            entries.add(ModBlocks.DRIPSTONE_BRICKS_STAIRS);
            entries.add(ModBlocks.DRIPSTONE_BRICKS_SLAB);
            entries.add(ModBlocks.DRIPSTONE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_DRIPSTONE_BRICKS);
            entries.add(ModBlocks.POLISHED_DRIPSTONE_BRICKS_STAIRS);
            entries.add(ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB);
            entries.add(ModBlocks.POLISHED_DRIPSTONE_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS);
            entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS);
            entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL);

            entries.add(ModBlocks.GRANITE_BRICKS);
            entries.add(ModBlocks.GRANITE_BRICKS_STAIRS);
            entries.add(ModBlocks.GRANITE_BRICKS_SLAB);
            entries.add(ModBlocks.GRANITE_BRICKS_WALL);
            entries.add(ModBlocks.POLISHED_GRANITE_BRICKS);
            entries.add(ModBlocks.POLISHED_GRANITE_BRICKS_STAIRS);
            entries.add(ModBlocks.POLISHED_GRANITE_BRICKS_SLAB);
            entries.add(ModBlocks.POLISHED_GRANITE_BRICKS_WALL);
            entries.add(ModBlocks.MOSSY_GRANITE_BRICKS);
            entries.add(ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS);
            entries.add(ModBlocks.MOSSY_GRANITE_BRICKS_SLAB);
            entries.add(ModBlocks.MOSSY_GRANITE_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_GRANITE_BRICKS);
            entries.add(ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_GRANITE_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_GRANITE_BRICKS_WALL);

            entries.add(ModBlocks.OCEANSLATE);
            entries.add(ModBlocks.OCEANSLATE_STAIRS);
            entries.add(ModBlocks.OCEANSLATE_SLAB);
            entries.add(ModBlocks.OCEANSLATE_WALL);
            entries.add(ModBlocks.OCEANSLATE_BRICKS);
            entries.add(ModBlocks.OCEANSLATE_BRICKS_STAIRS);
            entries.add(ModBlocks.OCEANSLATE_BRICKS_SLAB);
            entries.add(ModBlocks.OCEANSLATE_BRICKS_WALL);
            entries.add(ModBlocks.OCEANSLATE_TILES);
            entries.add(ModBlocks.OCEANSLATE_TILES_STAIRS);
            entries.add(ModBlocks.OCEANSLATE_TILES_SLAB);
            entries.add(ModBlocks.OCEANSLATE_TILES_WALL);
            entries.add(ModBlocks.POLISHED_OCEANSLATE);
            entries.add(ModBlocks.POLISHED_OCEANSLATE_STAIRS);
            entries.add(ModBlocks.POLISHED_OCEANSLATE_SLAB);
            entries.add(ModBlocks.POLISHED_OCEANSLATE_WALL);
            entries.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS);
            entries.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL);
            entries.add(ModBlocks.KELPY_OCEANSLATE_BRICKS);
            entries.add(ModBlocks.KELPY_OCEANSLATE_BRICKS_STAIRS);
            entries.add(ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB);
            entries.add(ModBlocks.KELPY_OCEANSLATE_BRICKS_WALL);

            entries.add(ModBlocks.RED_SEAT);
            entries.add(ModBlocks.ORANGE_SEAT);
            entries.add(ModBlocks.YELLOW_SEAT);
            entries.add(ModBlocks.LIME_SEAT);
            entries.add(ModBlocks.GREEN_SEAT);
            entries.add(ModBlocks.CYAN_SEAT);
            entries.add(ModBlocks.LIGHT_BLUE_SEAT);
            entries.add(ModBlocks.BLUE_SEAT);
            entries.add(ModBlocks.PINK_SEAT);
            entries.add(ModBlocks.MAGENTA_SEAT);
            entries.add(ModBlocks.PURPLE_SEAT);
            entries.add(ModBlocks.BROWN_SEAT);
            entries.add(ModBlocks.LIGHT_GRAY_SEAT);
            entries.add(ModBlocks.GRAY_SEAT);
            entries.add(ModBlocks.BLACK_SEAT);
            entries.add(ModBlocks.WHITE_SEAT);

            entries.add(ModBlocks.ABERRANT);
            entries.add(ModBlocks.ABERRANT_SEA_LANTERN);
            entries.add(ModBlocks.ABERRANT_DARK_PRISMARINE);
            entries.add(ModBlocks.ABERRANT_DARK_PRISMARINE_STAIRS);
            entries.add(ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB);
            entries.add(ModBlocks.ABERRANT_DARK_PRISMARINE_WALL);
            entries.add(ModBlocks.ABERRANT_PRISMARINE);
            entries.add(ModBlocks.ABERRANT_PRISMARINE_STAIRS);
            entries.add(ModBlocks.ABERRANT_PRISMARINE_SLAB);
            entries.add(ModBlocks.ABERRANT_PRISMARINE_WALL);
            entries.add(ModBlocks.ABERRANT_PRISMARINE_BRICKS);
            entries.add(ModBlocks.ABERRANT_PRISMARINE_BRICKS_STAIRS);
            entries.add(ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_STAIRS);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_SLAB);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_WALL);
            entries.add(ModBlocks.ABERRANT_POLISHED_OCEANSLATE);
            entries.add(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_STAIRS);
            entries.add(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB);
            entries.add(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_WALL);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_TILES);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_TILES_STAIRS);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_TILES_WALL);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_BRICKS);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_STAIRS);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB);
            entries.add(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS);
            entries.add(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_WALL);
            entries.add(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS);
            entries.add(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_STAIRS);
            entries.add(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB);
            entries.add(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_WALL);

            entries.add(ModBlocks.SOUL_SANDSTONE);
            entries.add(ModBlocks.SOUL_SANDSTONE_STAIRS);
            entries.add(ModBlocks.SOUL_SANDSTONE_SLAB);
            entries.add(ModBlocks.SOUL_SANDSTONE_WALL);
            entries.add(ModBlocks.CUT_SOUL_SANDSTONE);
            entries.add(ModBlocks.CHISELED_SOUL_SANDSTONE);
            entries.add(ModBlocks.SMOOTH_SOUL_SANDSTONE);
            entries.add(ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS);
            entries.add(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB);
            entries.add(ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL);

            entries.add(ModBlocks.ABERRANT_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_RED_WOOL);
            entries.add(ModBlocks.ABERRANT_RED_SEAT);
            entries.add(ModBlocks.ABERRANT_RED_CONCRETE);
            entries.add(ModBlocks.ABERRANT_RED_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_RED_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_RED_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_ORANGE_WOOL);
            entries.add(ModBlocks.ABERRANT_ORANGE_SEAT);
            entries.add(ModBlocks.ABERRANT_ORANGE_CONCRETE);
            entries.add(ModBlocks.ABERRANT_ORANGE_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_ORANGE_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_ORANGE_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_YELLOW_WOOL);
            entries.add(ModBlocks.ABERRANT_YELLOW_SEAT);
            entries.add(ModBlocks.ABERRANT_YELLOW_CONCRETE);
            entries.add(ModBlocks.ABERRANT_YELLOW_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_YELLOW_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_YELLOW_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_LIME_WOOL);
            entries.add(ModBlocks.ABERRANT_LIME_SEAT);
            entries.add(ModBlocks.ABERRANT_LIME_CONCRETE);
            entries.add(ModBlocks.ABERRANT_LIME_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_LIME_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_LIME_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_GREEN_WOOL);
            entries.add(ModBlocks.ABERRANT_GREEN_SEAT);
            entries.add(ModBlocks.ABERRANT_GREEN_CONCRETE);
            entries.add(ModBlocks.ABERRANT_GREEN_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_GREEN_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_GREEN_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_CYAN_WOOL);
            entries.add(ModBlocks.ABERRANT_CYAN_SEAT);
            entries.add(ModBlocks.ABERRANT_CYAN_CONCRETE);
            entries.add(ModBlocks.ABERRANT_CYAN_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_CYAN_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_CYAN_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL);
            entries.add(ModBlocks.ABERRANT_LIGHT_BLUE_SEAT);
            entries.add(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE);
            entries.add(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_LIGHT_BLUE_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_BLUE_WOOL);
            entries.add(ModBlocks.ABERRANT_BLUE_SEAT);
            entries.add(ModBlocks.ABERRANT_BLUE_CONCRETE);
            entries.add(ModBlocks.ABERRANT_BLUE_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_BLUE_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_BLUE_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_PINK_WOOL);
            entries.add(ModBlocks.ABERRANT_PINK_SEAT);
            entries.add(ModBlocks.ABERRANT_PINK_CONCRETE);
            entries.add(ModBlocks.ABERRANT_PINK_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_PINK_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_PINK_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_MAGENTA_WOOL);
            entries.add(ModBlocks.ABERRANT_MAGENTA_SEAT);
            entries.add(ModBlocks.ABERRANT_MAGENTA_CONCRETE);
            entries.add(ModBlocks.ABERRANT_MAGENTA_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_MAGENTA_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_PURPLE_WOOL);
            entries.add(ModBlocks.ABERRANT_PURPLE_SEAT);
            entries.add(ModBlocks.ABERRANT_PURPLE_CONCRETE);
            entries.add(ModBlocks.ABERRANT_PURPLE_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_PURPLE_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_PURPLE_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_BROWN_WOOL);
            entries.add(ModBlocks.ABERRANT_BROWN_SEAT);
            entries.add(ModBlocks.ABERRANT_BROWN_CONCRETE);
            entries.add(ModBlocks.ABERRANT_BROWN_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_BROWN_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_BROWN_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_BLACK_WOOL);
            entries.add(ModBlocks.ABERRANT_BLACK_SEAT);
            entries.add(ModBlocks.ABERRANT_BLACK_CONCRETE);
            entries.add(ModBlocks.ABERRANT_BLACK_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_BLACK_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_BLACK_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_GRAY_WOOL);
            entries.add(ModBlocks.ABERRANT_GRAY_SEAT);
            entries.add(ModBlocks.ABERRANT_GRAY_CONCRETE);
            entries.add(ModBlocks.ABERRANT_GRAY_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_GRAY_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_GRAY_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL);
            entries.add(ModBlocks.ABERRANT_LIGHT_GRAY_SEAT);
            entries.add(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE);
            entries.add(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_LIGHT_GRAY_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_WHITE_WOOL);
            entries.add(ModBlocks.ABERRANT_WHITE_SEAT);
            entries.add(ModBlocks.ABERRANT_WHITE_CONCRETE);
            entries.add(ModBlocks.ABERRANT_WHITE_CONCRETE_POWER);
            entries.add(ModBlocks.ABERRANT_WHITE_TERRACOTTA);
            entries.add(ModBlocks.ABERRANT_WHITE_GLAZED_TERRACOTTA);

            entries.add(ModBlocks.ABERRANT_RED_CARPET);
            entries.add(ModBlocks.ABERRANT_ORANGE_CARPET);
            entries.add(ModBlocks.ABERRANT_YELLOW_CARPET);
            entries.add(ModBlocks.ABERRANT_LIME_CARPET);
            entries.add(ModBlocks.ABERRANT_GREEN_CARPET);
            entries.add(ModBlocks.ABERRANT_CYAN_CARPET);
            entries.add(ModBlocks.ABERRANT_LIGHT_BLUE_CARPET);
            entries.add(ModBlocks.ABERRANT_BLUE_CARPET);
            entries.add(ModBlocks.ABERRANT_PINK_CARPET);
            entries.add(ModBlocks.ABERRANT_MAGENTA_CARPET);
            entries.add(ModBlocks.ABERRANT_PURPLE_CARPET);
            entries.add(ModBlocks.ABERRANT_BROWN_CARPET);
            entries.add(ModBlocks.ABERRANT_BLACK_CARPET);
            entries.add(ModBlocks.ABERRANT_GRAY_CARPET);
            entries.add(ModBlocks.ABERRANT_LIGHT_GRAY_CARPET);
            entries.add(ModBlocks.ABERRANT_WHITE_CARPET);

            entries.add(ModBlocks.BEETROOT_RESIN_BRICKS);
            entries.add(ModBlocks.BEETROOT_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.BEETROOT_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.BEETROOT_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.BEETROOT_RESIN_BLOCK);
            entries.add(ModBlocks.BEETROOT_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.BEETROOT_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.BEETROOT_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_BEETROOT_RESIN_BRICKS);

            entries.add(ModBlocks.CHORUS_RESIN_BRICKS);
            entries.add(ModBlocks.CHORUS_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.CHORUS_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.CHORUS_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.CHORUS_RESIN_BLOCK);
            entries.add(ModBlocks.CHORUS_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.CHORUS_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.CHORUS_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_CHORUS_RESIN_BRICKS);

            entries.add(ModBlocks.LEMON_RESIN_BRICKS);
            entries.add(ModBlocks.LEMON_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.LEMON_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.LEMON_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.LEMON_RESIN_BLOCK);
            entries.add(ModBlocks.LEMON_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.LEMON_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.LEMON_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_LEMON_RESIN_BRICKS);

            entries.add(ModBlocks.GLACIER_RESIN_BRICKS);
            entries.add(ModBlocks.GLACIER_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.GLACIER_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.GLACIER_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.GLACIER_RESIN_BLOCK);
            entries.add(ModBlocks.GLACIER_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.GLACIER_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.GLACIER_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_GLACIER_RESIN_BRICKS);

            entries.add(ModBlocks.CARAMEL_RESIN_BRICKS);
            entries.add(ModBlocks.CARAMEL_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.CARAMEL_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.CARAMEL_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.CARAMEL_RESIN_BLOCK);
            entries.add(ModBlocks.CARAMEL_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.CARAMEL_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.CARAMEL_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_CARAMEL_RESIN_BRICKS);

            entries.add(ModBlocks.TOXIC_RESIN_BRICKS);
            entries.add(ModBlocks.TOXIC_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.TOXIC_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.TOXIC_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.TOXIC_RESIN_BLOCK);
            entries.add(ModBlocks.TOXIC_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.TOXIC_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.TOXIC_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_TOXIC_RESIN_BRICKS);

            entries.add(ModBlocks.JADE_RESIN_BRICKS);
            entries.add(ModBlocks.JADE_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.JADE_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.JADE_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.JADE_RESIN_BLOCK);
            entries.add(ModBlocks.JADE_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.JADE_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.JADE_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_JADE_RESIN_BRICKS);

            entries.add(ModBlocks.BUBBLE_RESIN_BRICKS);
            entries.add(ModBlocks.BUBBLE_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.BUBBLE_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.BUBBLE_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.BUBBLE_RESIN_BLOCK);
            entries.add(ModBlocks.BUBBLE_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.BUBBLE_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.BUBBLE_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_BUBBLE_RESIN_BRICKS);

            entries.add(ModBlocks.OCEAN_RESIN_BRICKS);
            entries.add(ModBlocks.OCEAN_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.OCEAN_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.OCEAN_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.OCEAN_RESIN_BLOCK);
            entries.add(ModBlocks.OCEAN_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.OCEAN_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.OCEAN_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_OCEAN_RESIN_BRICKS);

            entries.add(ModBlocks.EMERALD_RESIN_BRICKS);
            entries.add(ModBlocks.EMERALD_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.EMERALD_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.EMERALD_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.EMERALD_RESIN_BLOCK);
            entries.add(ModBlocks.EMERALD_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.EMERALD_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.EMERALD_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_EMERALD_RESIN_BRICKS);

            entries.add(ModBlocks.DUSK_RESIN_BRICKS);
            entries.add(ModBlocks.DUSK_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.DUSK_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.DUSK_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.DUSK_RESIN_BLOCK);
            entries.add(ModBlocks.DUSK_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.DUSK_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.DUSK_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_DUSK_RESIN_BRICKS);

            entries.add(ModBlocks.DAYBREAK_RESIN_BRICKS);
            entries.add(ModBlocks.DAYBREAK_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.DAYBREAK_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.DAYBREAK_RESIN_BLOCK);
            entries.add(ModBlocks.DAYBREAK_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.DAYBREAK_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_DAYBREAK_RESIN_BRICKS);

            entries.add(ModBlocks.SILT_RESIN_BRICKS);
            entries.add(ModBlocks.SILT_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.SILT_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.SILT_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.SILT_RESIN_BLOCK);
            entries.add(ModBlocks.SILT_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.SILT_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.SILT_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_SILT_RESIN_BRICKS);

            entries.add(ModBlocks.GRAPHITE_RESIN_BRICKS);
            entries.add(ModBlocks.GRAPHITE_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.GRAPHITE_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.GRAPHITE_RESIN_BLOCK);
            entries.add(ModBlocks.GRAPHITE_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.GRAPHITE_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_GRAPHITE_RESIN_BRICKS);

            entries.add(ModBlocks.OBSIDIAN_RESIN_BRICKS);
            entries.add(ModBlocks.OBSIDIAN_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.OBSIDIAN_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.OBSIDIAN_RESIN_BLOCK);
            entries.add(ModBlocks.OBSIDIAN_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.OBSIDIAN_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_OBSIDIAN_RESIN_BRICKS);

            entries.add(ModBlocks.COCOA_RESIN_BRICKS);
            entries.add(ModBlocks.COCOA_RESIN_BRICKS_STAIRS);
            entries.add(ModBlocks.COCOA_RESIN_BRICKS_SLAB);
            entries.add(ModBlocks.COCOA_RESIN_BRICKS_WALL);
            entries.add(ModBlocks.COCOA_RESIN_BLOCK);
            entries.add(ModBlocks.COCOA_RESIN_BLOCK_STAIRS);
            entries.add(ModBlocks.COCOA_RESIN_BLOCK_SLAB);
            entries.add(ModBlocks.COCOA_RESIN_BLOCK_WALL);
            entries.add(ModBlocks.CHISELED_COCOA_RESIN_BRICKS);

            entries.add(ModBlocks.POLISHED_RESIN);
            entries.add(ModBlocks.POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.POLISHED_RESIN_WALL);
            entries.add(ModBlocks.BEETROOT_POLISHED_RESIN);
            entries.add(ModBlocks.BEETROOT_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.BEETROOT_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.BEETROOT_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.CARAMEL_POLISHED_RESIN);
            entries.add(ModBlocks.CARAMEL_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.CARAMEL_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.CARAMEL_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.LEMON_POLISHED_RESIN);
            entries.add(ModBlocks.LEMON_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.LEMON_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.LEMON_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.TOXIC_POLISHED_RESIN);
            entries.add(ModBlocks.TOXIC_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.TOXIC_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.TOXIC_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.EMERALD_POLISHED_RESIN);
            entries.add(ModBlocks.EMERALD_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.EMERALD_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.EMERALD_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.JADE_POLISHED_RESIN);
            entries.add(ModBlocks.JADE_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.JADE_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.JADE_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.OCEAN_POLISHED_RESIN);
            entries.add(ModBlocks.OCEAN_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.OCEAN_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.OCEAN_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.GLACIER_POLISHED_RESIN);
            entries.add(ModBlocks.GLACIER_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.GLACIER_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.GLACIER_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.BUBBLE_POLISHED_RESIN);
            entries.add(ModBlocks.BUBBLE_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.BUBBLE_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.BUBBLE_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.DUSK_POLISHED_RESIN);
            entries.add(ModBlocks.DUSK_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.DUSK_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.DUSK_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.CHORUS_POLISHED_RESIN);
            entries.add(ModBlocks.CHORUS_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.CHORUS_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.CHORUS_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.DAYBREAK_POLISHED_RESIN);
            entries.add(ModBlocks.DAYBREAK_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.DAYBREAK_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.DAYBREAK_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.SILT_POLISHED_RESIN);
            entries.add(ModBlocks.SILT_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.SILT_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.SILT_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.GRAPHITE_POLISHED_RESIN);
            entries.add(ModBlocks.GRAPHITE_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.GRAPHITE_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.GRAPHITE_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.OBSIDIAN_POLISHED_RESIN);
            entries.add(ModBlocks.OBSIDIAN_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.OBSIDIAN_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.OBSIDIAN_POLISHED_RESIN_WALL);
            entries.add(ModBlocks.COCOA_POLISHED_RESIN);
            entries.add(ModBlocks.COCOA_POLISHED_RESIN_STAIRS);
            entries.add(ModBlocks.COCOA_POLISHED_RESIN_SLAB);
            entries.add(ModBlocks.COCOA_POLISHED_RESIN_WALL);

            entries.add(ModBlocks.AMETHYST_TILES);
            entries.add(ModBlocks.AMETHYST_BRICKS);

            entries.add(ModBlocks.ABERRANT_AMETHYST_BLOCK);
            entries.add(ModBlocks.BUDDING_ABERRANT_AMETHYST);
            entries.add(ModBlocks.SMALL_ABERRANT_AMETHYST_BUD);
            entries.add(ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD);
            entries.add(ModBlocks.LARGE_ABERRANT_AMETHYST_BUD);
            entries.add(ModBlocks.ABERRANT_AMETHYST_CLUSTER);
            entries.add(ModBlocks.ABERRANT_AMETHYST_TILES);
            entries.add(ModBlocks.ABERRANT_AMETHYST_BRICKS);
            entries.add(ModBlocks.AMETHYST_TILES_STAIRS);
            entries.add(ModBlocks.AMETHYST_TILES_SLAB);
            entries.add(ModBlocks.AMETHYST_TILES_WALL);
            entries.add(ModBlocks.AMETHYST_BRICKS_STAIRS);
            entries.add(ModBlocks.AMETHYST_BRICKS_SLAB);
            entries.add(ModBlocks.AMETHYST_BRICKS_WALL);
            entries.add(ModBlocks.ABERRANT_AMETHYST_TILES_STAIRS);
            entries.add(ModBlocks.ABERRANT_AMETHYST_TILES_SLAB);
            entries.add(ModBlocks.ABERRANT_AMETHYST_TILES_WALL);
            entries.add(ModBlocks.ABERRANT_AMETHYST_BRICKS_STAIRS);
            entries.add(ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB);
            entries.add(ModBlocks.ABERRANT_AMETHYST_BRICKS_WALL);

            entries.add(ModBlocks.ABERRANT_SOUL_SANDSTONE);
            entries.add(ModBlocks.ABERRANT_SOUL_SANDSTONE_STAIRS);
            entries.add(ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB);
            entries.add(ModBlocks.ABERRANT_SOUL_SANDSTONE_WALL);
            entries.add(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE);
            entries.add(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE);
            entries.add(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE);
            entries.add(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_STAIRS);
            entries.add(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB);
            entries.add(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_WALL);

            entries.add(ModBlocks.ABERRANT_PUMPKIN);
            entries.add(ModBlocks.ABERRANT_CARVED_PUMPKIN);
            entries.add(ModBlocks.ABERRANT_JACK_O_LANTERN);

            entries.add(ModBlocks.ABERRANT_OBSIDIAN);
            entries.add(ModBlocks.ABERRANT_CRYING_OBSIDIAN);

            entries.add(ModBlocks.ABERRANT_NETHERRACK);
            entries.add(ModBlocks.ABERRANT_NETHER_BRICKS);
            entries.add(ModBlocks.ABERRANT_NETHER_BRICKS_STAIRS);
            entries.add(ModBlocks.ABERRANT_NETHER_BRICKS_SLAB);
            entries.add(ModBlocks.ABERRANT_NETHER_BRICKS_WALL);
            entries.add(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS);
            entries.add(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_STAIRS);
            entries.add(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB);
            entries.add(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_WALL);
            entries.add(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS);
            entries.add(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_STAIRS);
            entries.add(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB);
            entries.add(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_WALL);
            entries.add(ModBlocks.ABERRANT_RED_NETHER_BRICKS);
            entries.add(ModBlocks.ABERRANT_RED_NETHER_BRICKS_STAIRS);
            entries.add(ModBlocks.ABERRANT_RED_NETHER_BRICKS_SLAB);
            entries.add(ModBlocks.ABERRANT_RED_NETHER_BRICKS_WALL);
            entries.add(ModBlocks.ABERRANT_GLOWSTONE);
        });
    }
}
