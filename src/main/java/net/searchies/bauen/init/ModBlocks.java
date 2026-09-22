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
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.block.SeatBlock;

import java.util.function.Function;

public class ModBlocks {

    private static final AbstractBlock.Settings ABS_COPPER = AbstractBlock.Settings.create().requiresTool().strength(3.0F, 6.0F).instrument(NoteBlockInstrument.BASEDRUM).nonOpaque();
    private static final AbstractBlock.Settings ABS_BRICKS = AbstractBlock.Settings.copy(Blocks.BRICKS);
    private static final AbstractBlock.Settings ABS_COBBLE = AbstractBlock.Settings.copy(Blocks.COBBLESTONE).strength(3.0F);
    private static final AbstractBlock.Settings ABS_DOOR = AbstractBlock.Settings.create().strength(3.0F, 6.0F).nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    private static final AbstractBlock.Settings ABS_TRAPDOOR = AbstractBlock.Settings.create().requiresTool().strength(3.0F, 6.0F).nonOpaque().allowsSpawning(Blocks::never);
    private static final AbstractBlock.Settings ABS_MUD = AbstractBlock.Settings.copy(Blocks.MUD);
    private static final AbstractBlock.Settings ABS_ICE = AbstractBlock.Settings.copy(Blocks.ICE);
    private static final AbstractBlock.Settings ABS_PACKED_ICE = AbstractBlock.Settings.copy(Blocks.PACKED_ICE);

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
    public static final Block GOLD_CHAIN = registerCustomBlock("gold_chain", ChainBlock::new, ABS_COPPER);
    public static final Block GOLD_LANTERN = registerCustomBlock("gold_lantern", LanternBlock::new,
            AbstractBlock.Settings.copy(Blocks.LANTERN).strength(3.0F, 6.0F));
    public static final Block GOLD_BARS = registerCustomBlock("gold_bars", PaneBlock::new, ABS_COPPER);
    public static final Block GOLD_TRAPDOOR = registerCustomBlock("gold_trapdoor", settings -> new TrapdoorBlock(BlockSetType.COPPER, settings), ABS_TRAPDOOR);
    public static final Block GOLD_DOOR = registerCustomBlock("gold_door", settings -> new DoorBlock(BlockSetType.COPPER, settings), ABS_DOOR);
    public static final Block GOLD_COINS = registerCustomBlock("gold_coins", LeafLitterBlock::new,
            AbstractBlock.Settings.create().mapColor(MapColor.GOLD).replaceable().noCollision().sounds(BlockSoundGroup.CHAIN).pistonBehavior(PistonBehavior.DESTROY));
//    public static final Block GOLD_HOARD = registerCustomBlock("gold_hoard", GoldHoardBlock::new,
//            AbstractBlock.Settings.create().mapColor(MapColor.GOLD).replaceable().notSolid().ticksRandomly().strength(2.0f,4.0f).requiresTool().sounds(BlockSoundGroup.CHAIN).blockVision((state, world, pos) -> state.get(GoldHoardBlock.LAYERS) >= 8).pistonBehavior(PistonBehavior.DESTROY));
//    public static final Block GOLD_HOARD_BLOCK = registerBlock("gold_hoard_block",
//            AbstractBlock.Settings.create().mapColor(MapColor.GOLD).requiresTool().strength(3.0f,6.0f).sounds(BlockSoundGroup.CHAIN));

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

    public static final Block MOSSY_PACKED_MUD = registerBlock("mossy_packed_mud", ABS_BRICKS);
    public static final Block MOSSY_PACKED_MUD_STAIRS = registerCustomBlock("mossy_packed_mud_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_PACKED_MUD.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_PACKED_MUD_SLAB = registerCustomBlock("mossy_packed_mud_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_PACKED_MUD_WALL = registerCustomBlock("mossy_packed_mud_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_MUD_BRICKS = registerBlock("mossy_mud_bricks", ABS_BRICKS);
    public static final Block MOSSY_MUD_BRICKS_STAIRS = registerCustomBlock("mossy_mud_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_MUD_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_MUD_BRICKS_SLAB = registerCustomBlock("mossy_mud_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_MUD_BRICKS_WALL = registerCustomBlock("mossy_mud_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_TUFF_BRICKS = registerBlock("mossy_tuff_bricks", ABS_BRICKS);
    public static final Block MOSSY_TUFF_BRICKS_STAIRS = registerCustomBlock("mossy_tuff_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_TUFF_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_TUFF_BRICKS_SLAB = registerCustomBlock("mossy_tuff_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_TUFF_BRICKS_WALL = registerCustomBlock("mossy_tuff_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

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

    public static final Block POLISHED_CALCITE = registerBlock("polished_calcite", ABS_BRICKS);
    public static final Block POLISHED_CALCITE_STAIRS = registerCustomBlock("polished_calcite_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_CALCITE.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_CALCITE_SLAB = registerCustomBlock("polished_calcite_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_CALCITE_WALL = registerCustomBlock("polished_calcite_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block POLISHED_CALCITE_BRICKS = registerBlock("polished_calcite_bricks", ABS_BRICKS);
    public static final Block POLISHED_CALCITE_BRICKS_STAIRS = registerCustomBlock("polished_calcite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_CALCITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_CALCITE_BRICKS_SLAB = registerCustomBlock("polished_calcite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_CALCITE_BRICKS_WALL = registerCustomBlock("polished_calcite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CALCITE_BRICKS = registerBlock("calcite_bricks", ABS_BRICKS);
    public static final Block CALCITE_BRICKS_STAIRS = registerCustomBlock("calcite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CALCITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CALCITE_BRICKS_SLAB = registerCustomBlock("calcite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CALCITE_BRICKS_WALL = registerCustomBlock("calcite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_CALCITE_BRICKS = registerBlock("mossy_calcite_bricks", ABS_BRICKS);
    public static final Block MOSSY_CALCITE_BRICKS_STAIRS = registerCustomBlock("mossy_calcite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_CALCITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_CALCITE_BRICKS_SLAB = registerCustomBlock("mossy_calcite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_CALCITE_BRICKS_WALL = registerCustomBlock("mossy_calcite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_CALCITE_BRICKS = registerBlock("cracked_calcite_bricks", ABS_BRICKS);
    public static final Block CRACKED_CALCITE_BRICKS_STAIRS = registerCustomBlock("cracked_calcite_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_CALCITE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_CALCITE_BRICKS_SLAB = registerCustomBlock("cracked_calcite_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_CALCITE_BRICKS_WALL = registerCustomBlock("cracked_calcite_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

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

    public static final Block POLISHED_DRIPSTONE = registerBlock("polished_dripstone", ABS_BRICKS);
    public static final Block POLISHED_DRIPSTONE_STAIRS = registerCustomBlock("polished_dripstone_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_DRIPSTONE.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_DRIPSTONE_SLAB = registerCustomBlock("polished_dripstone_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_DRIPSTONE_WALL = registerCustomBlock("polished_dripstone_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block DRIPSTONE_BRICKS = registerBlock("dripstone_bricks", ABS_BRICKS);
    public static final Block DRIPSTONE_BRICKS_STAIRS = registerCustomBlock("dripstone_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.DRIPSTONE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block DRIPSTONE_BRICKS_SLAB = registerCustomBlock("dripstone_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block DRIPSTONE_BRICKS_WALL = registerCustomBlock("dripstone_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block POLISHED_DRIPSTONE_BRICKS = registerBlock("polished_dripstone_bricks", ABS_BRICKS);
    public static final Block POLISHED_DRIPSTONE_BRICKS_STAIRS = registerCustomBlock("polished_dripstone_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.POLISHED_DRIPSTONE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_DRIPSTONE_BRICKS_SLAB = registerCustomBlock("polished_dripstone_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block POLISHED_DRIPSTONE_BRICKS_WALL = registerCustomBlock("polished_dripstone_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block MOSSY_DRIPSTONE_BRICKS = registerBlock("mossy_dripstone_bricks", ABS_BRICKS);
    public static final Block MOSSY_DRIPSTONE_BRICKS_STAIRS = registerCustomBlock("mossy_dripstone_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.MOSSY_DRIPSTONE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_DRIPSTONE_BRICKS_SLAB = registerCustomBlock("mossy_dripstone_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block MOSSY_DRIPSTONE_BRICKS_WALL = registerCustomBlock("mossy_dripstone_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

    public static final Block CRACKED_DRIPSTONE_BRICKS = registerBlock("cracked_dripstone_bricks", ABS_BRICKS);
    public static final Block CRACKED_DRIPSTONE_BRICKS_STAIRS = registerCustomBlock("cracked_dripstone_bricks_stairs", (AbstractBlock.Settings settings) -> new StairsBlock(ModBlocks.CRACKED_DRIPSTONE_BRICKS.getDefaultState(), ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_DRIPSTONE_BRICKS_SLAB = registerCustomBlock("cracked_dripstone_bricks_slab", (AbstractBlock.Settings settings) -> new SlabBlock(ABS_BRICKS), ABS_BRICKS);
    public static final Block CRACKED_DRIPSTONE_BRICKS_WALL = registerCustomBlock("cracked_dripstone_bricks_wall", (AbstractBlock.Settings settings) -> new WallBlock(ABS_BRICKS), ABS_BRICKS);

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
//            entries.add(ModBlocks.GOLD_HOARD);
//            entries.add(ModBlocks.GOLD_HOARD_BLOCK);

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
        });
    }
}
