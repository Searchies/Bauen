package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.LimitCountLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.operator.BoundedIntUnaryOperator;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.searchies.bauen.block.GoldHoardBlock;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput,
                           CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.MOSSY_BRICKS);
        addDrop(ModBlocks.MOSSY_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_BRICKS);
        addDrop(ModBlocks.CRACKED_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_BRICKS_WALL);

        addDrop(ModBlocks.CHISELED_BRICKS);
        addDrop(ModBlocks.CHISELED_BRICKS_STAIRS);
        addDrop(ModBlocks.CHISELED_BRICKS_SLAB, slabDrops(ModBlocks.CHISELED_BRICKS_SLAB));
        addDrop(ModBlocks.CHISELED_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_CHISELED_BRICKS);
        addDrop(ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_CHISELED_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_CHISELED_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_CHISELED_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_CHISELED_BRICKS);
        addDrop(ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_CHISELED_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_CHISELED_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_CHISELED_BRICKS_WALL);

        addDrop(ModBlocks.GOLD_CHAIN);
        addDrop(ModBlocks.GOLD_LANTERN);
        addDrop(ModBlocks.GOLD_BARS);
        addDrop(ModBlocks.CUT_GOLD);
        addDrop(ModBlocks.CHISELED_GOLD);
        addDrop(ModBlocks.GOLD_GRATE);
        addDrop(ModBlocks.GOLD_TRAPDOOR);
        addDrop(ModBlocks.GOLD_DOOR, doorDrops(ModBlocks.GOLD_DOOR));
        addDrop(ModBlocks.GOLD_COINS, segmentedDrops(ModBlocks.GOLD_COINS));

        addDrop(ModBlocks.GOLD_HOARD, (Block block) -> LootTable.builder().pool(LootPool.builder().conditionally(EntityPropertiesLootCondition.create(LootContext.EntityReference.THIS)).with(AlternativeEntry.builder(new LootPoolEntry.Builder[]{AlternativeEntry.builder(GoldHoardBlock.LAYERS.getValues(), layers -> ((LeafEntry.Builder) ItemEntry.builder(ModBlocks.GOLD_COINS).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(GoldHoardBlock.LAYERS, layers.intValue())))).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(layers.intValue() / 2)))), AlternativeEntry.builder(GoldHoardBlock.LAYERS.getValues(), layers -> layers == 8 ? ItemEntry.builder(ModBlocks.GOLD_HOARD_BLOCK) : ((LootPoolEntry.Builder)((Object)ItemEntry.builder(ModBlocks.GOLD_COINS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(layers.intValue() / 2))))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(GoldHoardBlock.LAYERS, layers.intValue()))))}))));

        addDrop(ModBlocks.GOLD_HOARD_BLOCK, (Block block) -> drops(block, ModBlocks.GOLD_COINS, ConstantLootNumberProvider.create(4.0f)));

        addDrop(ModBlocks.MIXED_COBBLESTONE);
        addDrop(ModBlocks.MIXED_COBBLESTONE_STAIRS);
        addDrop(ModBlocks.MIXED_COBBLESTONE_SLAB, slabDrops(ModBlocks.MIXED_COBBLESTONE_SLAB));
        addDrop(ModBlocks.MIXED_COBBLESTONE_WALL);

        addDrop(ModBlocks.INDUSTRIAL_IRON_BLOCK);
        addDrop(ModBlocks.INDUSTRIAL_IRON_STAIRS);
        addDrop(ModBlocks.INDUSTRIAL_IRON_SLAB, slabDrops(ModBlocks.INDUSTRIAL_IRON_SLAB));
        addDrop(ModBlocks.INDUSTRIAL_IRON_WALL);

        addDrop(ModBlocks.CUT_INDUSTRIAL_IRON);
        addDrop(ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS);
        addDrop(ModBlocks.CUT_INDUSTRIAL_IRON_SLAB, slabDrops(ModBlocks.CUT_INDUSTRIAL_IRON_SLAB));
        addDrop(ModBlocks.CUT_INDUSTRIAL_IRON_WALL);

        addDrop(ModBlocks.CARVED_INDUSTRIAL_IRON);
        addDrop(ModBlocks.INDUSTRIAL_IRON_GRATE);
        addDrop(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
        addDrop(ModBlocks.INDUSTRIAL_IRON_DOOR, doorDrops(ModBlocks.INDUSTRIAL_IRON_DOOR));

        addDrop(ModBlocks.ICE_STAIRS);
        addDrop(ModBlocks.ICE_SLAB, slabDrops(ModBlocks.ICE_SLAB));
        addDrop(ModBlocks.ICE_WALL);

        addDrop(ModBlocks.PACKED_ICE_STAIRS);
        addDrop(ModBlocks.PACKED_ICE_SLAB, slabDrops(ModBlocks.PACKED_ICE_SLAB));
        addDrop(ModBlocks.PACKED_ICE_WALL);

        addDrop(ModBlocks.MUD_STAIRS);
        addDrop(ModBlocks.MUD_SLAB, slabDrops(ModBlocks.MUD_SLAB));
        addDrop(ModBlocks.MUD_WALL);

        addDrop(ModBlocks.MOSSY_PACKED_MUD);
        addDrop(ModBlocks.MOSSY_PACKED_MUD_STAIRS);
        addDrop(ModBlocks.MOSSY_PACKED_MUD_SLAB, slabDrops(ModBlocks.MOSSY_PACKED_MUD_SLAB));
        addDrop(ModBlocks.MOSSY_PACKED_MUD_WALL);

        addDrop(ModBlocks.MOSSY_MUD_BRICKS);
        addDrop(ModBlocks.MOSSY_MUD_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_MUD_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_MUD_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_MUD_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_TUFF_BRICKS);
        addDrop(ModBlocks.MOSSY_TUFF_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_TUFF_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_TUFF_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_TUFF_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_TUFF_BRICKS);
        addDrop(ModBlocks.CRACKED_TUFF_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_TUFF_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_TUFF_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_TUFF_BRICKS_WALL);

        addDrop(ModBlocks.SCULKED_DEEPSLATE_BRICKS);
        addDrop(ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS);
        addDrop(ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB, slabDrops(ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB));
        addDrop(ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL);

        addDrop(ModBlocks.KAOLIN_CLAY, block -> drops(block, ModItems.KAOLIN_CLAY_BALL, ConstantLootNumberProvider.create(4.0F)));

        addDrop(ModBlocks.MIDNIGHT_BRICKS);
        addDrop(ModBlocks.MIDNIGHT_BRICKS_STAIRS);
        addDrop(ModBlocks.MIDNIGHT_BRICKS_SLAB, slabDrops(ModBlocks.MIDNIGHT_BRICKS_SLAB));
        addDrop(ModBlocks.MIDNIGHT_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL);

        addDrop(ModBlocks.CHISELED_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS);
        addDrop(ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB, slabDrops(ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB));
        addDrop(ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL);

        addDrop(ModBlocks.TREATED_BRICKS);
        addDrop(ModBlocks.TREATED_BRICKS_STAIRS);
        addDrop(ModBlocks.TREATED_BRICKS_SLAB, slabDrops(ModBlocks.TREATED_BRICKS_SLAB));
        addDrop(ModBlocks.TREATED_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_TREATED_BRICKS);
        addDrop(ModBlocks.MOSSY_TREATED_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_TREATED_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_TREATED_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_TREATED_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_TREATED_BRICKS);
        addDrop(ModBlocks.CRACKED_TREATED_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_TREATED_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_TREATED_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_TREATED_BRICKS_WALL);

        addDrop(ModBlocks.CHISELED_TREATED_BRICKS);
        addDrop(ModBlocks.CHISELED_TREATED_BRICKS_STAIRS);
        addDrop(ModBlocks.CHISELED_TREATED_BRICKS_SLAB, slabDrops(ModBlocks.CHISELED_TREATED_BRICKS_SLAB));
        addDrop(ModBlocks.CHISELED_TREATED_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
        addDrop(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
        addDrop(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL);

        addDrop(ModBlocks.MIXED_BRICKS);
        addDrop(ModBlocks.MIXED_BRICKS_STAIRS);
        addDrop(ModBlocks.MIXED_BRICKS_SLAB, slabDrops(ModBlocks.MIXED_BRICKS_SLAB));
        addDrop(ModBlocks.MIXED_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_MIXED_BRICKS);
        addDrop(ModBlocks.MOSSY_MIXED_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_MIXED_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_MIXED_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_MIXED_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_MIXED_BRICKS);
        addDrop(ModBlocks.CRACKED_MIXED_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_MIXED_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_MIXED_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_MIXED_BRICKS_WALL);


        addDrop(ModBlocks.POLISHED_CALCITE);
        addDrop(ModBlocks.POLISHED_CALCITE_STAIRS);
        addDrop(ModBlocks.POLISHED_CALCITE_SLAB, slabDrops(ModBlocks.POLISHED_CALCITE_SLAB));
        addDrop(ModBlocks.POLISHED_CALCITE_WALL);

        addDrop(ModBlocks.CALCITE_BRICKS);
        addDrop(ModBlocks.CALCITE_BRICKS_STAIRS);
        addDrop(ModBlocks.CALCITE_BRICKS_SLAB, slabDrops(ModBlocks.CALCITE_BRICKS_SLAB));
        addDrop(ModBlocks.CALCITE_BRICKS_WALL);

        addDrop(ModBlocks.POLISHED_CALCITE_BRICKS);
        addDrop(ModBlocks.POLISHED_CALCITE_BRICKS_STAIRS);
        addDrop(ModBlocks.POLISHED_CALCITE_BRICKS_SLAB, slabDrops(ModBlocks.POLISHED_CALCITE_BRICKS_SLAB));
        addDrop(ModBlocks.POLISHED_CALCITE_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_CALCITE_BRICKS);
        addDrop(ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_CALCITE_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_CALCITE_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_CALCITE_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_CALCITE_BRICKS);
        addDrop(ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_CALCITE_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_CALCITE_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_CALCITE_BRICKS_WALL);


        addDrop(ModBlocks.ANDESITE_BRICKS);
        addDrop(ModBlocks.ANDESITE_BRICKS_STAIRS);
        addDrop(ModBlocks.ANDESITE_BRICKS_SLAB, slabDrops(ModBlocks.ANDESITE_BRICKS_SLAB));
        addDrop(ModBlocks.ANDESITE_BRICKS_WALL);

        addDrop(ModBlocks.POLISHED_ANDESITE_BRICKS);
        addDrop(ModBlocks.POLISHED_ANDESITE_BRICKS_STAIRS);
        addDrop(ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB, slabDrops(ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB));
        addDrop(ModBlocks.POLISHED_ANDESITE_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_ANDESITE_BRICKS);
        addDrop(ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_ANDESITE_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_ANDESITE_BRICKS);
        addDrop(ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_ANDESITE_BRICKS_WALL);


        addDrop(ModBlocks.DIORITE_BRICKS);
        addDrop(ModBlocks.DIORITE_BRICKS_STAIRS);
        addDrop(ModBlocks.DIORITE_BRICKS_SLAB, slabDrops(ModBlocks.DIORITE_BRICKS_SLAB));
        addDrop(ModBlocks.DIORITE_BRICKS_WALL);

        addDrop(ModBlocks.POLISHED_DIORITE_BRICKS);
        addDrop(ModBlocks.POLISHED_DIORITE_BRICKS_STAIRS);
        addDrop(ModBlocks.POLISHED_DIORITE_BRICKS_SLAB, slabDrops(ModBlocks.POLISHED_DIORITE_BRICKS_SLAB));
        addDrop(ModBlocks.POLISHED_DIORITE_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS);
        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS);
        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS_WALL);


        addDrop(ModBlocks.POLISHED_DRIPSTONE);
        addDrop(ModBlocks.POLISHED_DRIPSTONE_STAIRS);
        addDrop(ModBlocks.POLISHED_DRIPSTONE_SLAB, slabDrops(ModBlocks.POLISHED_DRIPSTONE_SLAB));
        addDrop(ModBlocks.POLISHED_DRIPSTONE_WALL);

        addDrop(ModBlocks.DRIPSTONE_BRICKS);
        addDrop(ModBlocks.DRIPSTONE_BRICKS_STAIRS);
        addDrop(ModBlocks.DRIPSTONE_BRICKS_SLAB, slabDrops(ModBlocks.DRIPSTONE_BRICKS_SLAB));
        addDrop(ModBlocks.DRIPSTONE_BRICKS_WALL);

        addDrop(ModBlocks.POLISHED_DRIPSTONE_BRICKS);
        addDrop(ModBlocks.POLISHED_DRIPSTONE_BRICKS_STAIRS);
        addDrop(ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB, slabDrops(ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB));
        addDrop(ModBlocks.POLISHED_DRIPSTONE_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_DRIPSTONE_BRICKS);
        addDrop(ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_DRIPSTONE_BRICKS);
        addDrop(ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL);


        addDrop(ModBlocks.GRANITE_BRICKS);
        addDrop(ModBlocks.GRANITE_BRICKS_STAIRS);
        addDrop(ModBlocks.GRANITE_BRICKS_SLAB, slabDrops(ModBlocks.GRANITE_BRICKS_SLAB));
        addDrop(ModBlocks.GRANITE_BRICKS_WALL);

        addDrop(ModBlocks.POLISHED_GRANITE_BRICKS);
        addDrop(ModBlocks.POLISHED_GRANITE_BRICKS_STAIRS);
        addDrop(ModBlocks.POLISHED_GRANITE_BRICKS_SLAB, slabDrops(ModBlocks.POLISHED_GRANITE_BRICKS_SLAB));
        addDrop(ModBlocks.POLISHED_GRANITE_BRICKS_WALL);

        addDrop(ModBlocks.MOSSY_GRANITE_BRICKS);
        addDrop(ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_GRANITE_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_GRANITE_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_GRANITE_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_GRANITE_BRICKS);
        addDrop(ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_GRANITE_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_GRANITE_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_GRANITE_BRICKS_WALL);


        addDrop(ModBlocks.OCEANSLATE);
        addDrop(ModBlocks.OCEANSLATE_STAIRS);
        addDrop(ModBlocks.OCEANSLATE_SLAB, slabDrops(ModBlocks.OCEANSLATE_SLAB));
        addDrop(ModBlocks.OCEANSLATE_WALL);

        addDrop(ModBlocks.OCEANSLATE_BRICKS);
        addDrop(ModBlocks.OCEANSLATE_BRICKS_STAIRS);
        addDrop(ModBlocks.OCEANSLATE_BRICKS_SLAB, slabDrops(ModBlocks.OCEANSLATE_BRICKS_SLAB));
        addDrop(ModBlocks.OCEANSLATE_BRICKS_WALL);

        addDrop(ModBlocks.OCEANSLATE_TILES);
        addDrop(ModBlocks.OCEANSLATE_TILES_STAIRS);
        addDrop(ModBlocks.OCEANSLATE_TILES_SLAB, slabDrops(ModBlocks.OCEANSLATE_TILES_SLAB));
        addDrop(ModBlocks.OCEANSLATE_TILES_WALL);

        addDrop(ModBlocks.POLISHED_OCEANSLATE);
        addDrop(ModBlocks.POLISHED_OCEANSLATE_STAIRS);
        addDrop(ModBlocks.POLISHED_OCEANSLATE_SLAB, slabDrops(ModBlocks.POLISHED_OCEANSLATE_SLAB));
        addDrop(ModBlocks.POLISHED_OCEANSLATE_WALL);

        addDrop(ModBlocks.CRACKED_OCEANSLATE_BRICKS);
        addDrop(ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL);

        addDrop(ModBlocks.KELPY_OCEANSLATE_BRICKS);
        addDrop(ModBlocks.KELPY_OCEANSLATE_BRICKS_STAIRS);
        addDrop(ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB, slabDrops(ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB));
        addDrop(ModBlocks.KELPY_OCEANSLATE_BRICKS_WALL);

        addDrop(ModBlocks.RED_SEAT);
        addDrop(ModBlocks.ORANGE_SEAT);
        addDrop(ModBlocks.YELLOW_SEAT);
        addDrop(ModBlocks.LIME_SEAT);
        addDrop(ModBlocks.GREEN_SEAT);
        addDrop(ModBlocks.CYAN_SEAT);
        addDrop(ModBlocks.LIGHT_BLUE_SEAT);
        addDrop(ModBlocks.BLUE_SEAT);
        addDrop(ModBlocks.PINK_SEAT);
        addDrop(ModBlocks.MAGENTA_SEAT);
        addDrop(ModBlocks.PURPLE_SEAT);
        addDrop(ModBlocks.BROWN_SEAT);
        addDrop(ModBlocks.LIGHT_GRAY_SEAT);
        addDrop(ModBlocks.GRAY_SEAT);
        addDrop(ModBlocks.BLACK_SEAT);
        addDrop(ModBlocks.WHITE_SEAT);

        addDrop(ModBlocks.ABERRANT);
        addDrop(ModBlocks.ABERRANT_SEA_LANTERN);
        addDrop(ModBlocks.ABERRANT_DARK_PRISMARINE);
        addDrop(ModBlocks.ABERRANT_DARK_PRISMARINE_STAIRS);
        addDrop(ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB, slabDrops(ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB));
        addDrop(ModBlocks.ABERRANT_DARK_PRISMARINE_WALL);
        addDrop(ModBlocks.ABERRANT_PRISMARINE);
        addDrop(ModBlocks.ABERRANT_PRISMARINE_STAIRS);
        addDrop(ModBlocks.ABERRANT_PRISMARINE_SLAB, slabDrops(ModBlocks.ABERRANT_PRISMARINE_SLAB));
        addDrop(ModBlocks.ABERRANT_PRISMARINE_WALL);
        addDrop(ModBlocks.ABERRANT_PRISMARINE_BRICKS);
        addDrop(ModBlocks.ABERRANT_PRISMARINE_BRICKS_STAIRS);
        addDrop(ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB, slabDrops(ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB));
        addDrop(ModBlocks.ABERRANT_OCEANSLATE);
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_STAIRS);
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_SLAB, slabDrops(ModBlocks.ABERRANT_OCEANSLATE_SLAB));
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_WALL);
        addDrop(ModBlocks.ABERRANT_POLISHED_OCEANSLATE);
        addDrop(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_STAIRS);
        addDrop(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB, slabDrops(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB));
        addDrop(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_WALL);
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_TILES);
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_TILES_STAIRS);
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB, slabDrops(ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB));
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_TILES_WALL);
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_BRICKS);
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_STAIRS);
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB, slabDrops(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB));
        addDrop(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_WALL);
        addDrop(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS);
        addDrop(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_SLAB, slabDrops(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_WALL);
        addDrop(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS);
        addDrop(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_STAIRS);
        addDrop(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB, slabDrops(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB));
        addDrop(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_WALL);

        addDrop(ModBlocks.SOUL_SANDSTONE);
        addDrop(ModBlocks.SOUL_SANDSTONE_STAIRS);
        addDrop(ModBlocks.SOUL_SANDSTONE_SLAB, slabDrops(ModBlocks.SOUL_SANDSTONE_SLAB));
        addDrop(ModBlocks.SOUL_SANDSTONE_WALL);
        addDrop(ModBlocks.CUT_SOUL_SANDSTONE);
        addDrop(ModBlocks.CHISELED_SOUL_SANDSTONE);
        addDrop(ModBlocks.SMOOTH_SOUL_SANDSTONE);
        addDrop(ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS);
        addDrop(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, slabDrops(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB));
        addDrop(ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL);

        addDrop(ModBlocks.ABERRANT_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_RED_WOOL);
        addDrop(ModBlocks.ABERRANT_RED_SEAT);
        addDrop(ModBlocks.ABERRANT_RED_CONCRETE);
        addDrop(ModBlocks.ABERRANT_RED_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_RED_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_RED_GLAZED_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_RED_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_RED_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_RED_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_RED_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_RED_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_RED_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_RED_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_RED_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_RED_CONCRETE_SLAB));

        addDrop(ModBlocks.ABERRANT_ORANGE_WOOL);
        addDrop(ModBlocks.ABERRANT_ORANGE_SEAT);
        addDrop(ModBlocks.ABERRANT_ORANGE_CONCRETE);
        addDrop(ModBlocks.ABERRANT_ORANGE_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_ORANGE_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_ORANGE_GLAZED_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_ORANGE_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_ORANGE_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_ORANGE_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_ORANGE_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_ORANGE_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_ORANGE_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_SLAB));

        addDrop(ModBlocks.ABERRANT_YELLOW_WOOL);
        addDrop(ModBlocks.ABERRANT_YELLOW_SEAT);
        addDrop(ModBlocks.ABERRANT_YELLOW_CONCRETE);
        addDrop(ModBlocks.ABERRANT_YELLOW_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_YELLOW_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_YELLOW_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_LIME_WOOL);
        addDrop(ModBlocks.ABERRANT_LIME_SEAT);
        addDrop(ModBlocks.ABERRANT_LIME_CONCRETE);
        addDrop(ModBlocks.ABERRANT_LIME_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_LIME_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_LIME_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_GREEN_WOOL);
        addDrop(ModBlocks.ABERRANT_GREEN_SEAT);
        addDrop(ModBlocks.ABERRANT_GREEN_CONCRETE);
        addDrop(ModBlocks.ABERRANT_GREEN_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_GREEN_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_GREEN_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_CYAN_WOOL);
        addDrop(ModBlocks.ABERRANT_CYAN_SEAT);
        addDrop(ModBlocks.ABERRANT_CYAN_CONCRETE);
        addDrop(ModBlocks.ABERRANT_CYAN_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_CYAN_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_CYAN_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_SEAT);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_BLUE_WOOL);
        addDrop(ModBlocks.ABERRANT_BLUE_SEAT);
        addDrop(ModBlocks.ABERRANT_BLUE_CONCRETE);
        addDrop(ModBlocks.ABERRANT_BLUE_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_BLUE_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_BLUE_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_PINK_WOOL);
        addDrop(ModBlocks.ABERRANT_PINK_SEAT);
        addDrop(ModBlocks.ABERRANT_PINK_CONCRETE);
        addDrop(ModBlocks.ABERRANT_PINK_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_PINK_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_PINK_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_MAGENTA_WOOL);
        addDrop(ModBlocks.ABERRANT_MAGENTA_SEAT);
        addDrop(ModBlocks.ABERRANT_MAGENTA_CONCRETE);
        addDrop(ModBlocks.ABERRANT_MAGENTA_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_MAGENTA_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_PURPLE_WOOL);
        addDrop(ModBlocks.ABERRANT_PURPLE_SEAT);
        addDrop(ModBlocks.ABERRANT_PURPLE_CONCRETE);
        addDrop(ModBlocks.ABERRANT_PURPLE_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_PURPLE_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_PURPLE_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_BROWN_WOOL);
        addDrop(ModBlocks.ABERRANT_BROWN_SEAT);
        addDrop(ModBlocks.ABERRANT_BROWN_CONCRETE);
        addDrop(ModBlocks.ABERRANT_BROWN_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_BROWN_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_BROWN_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_BLACK_WOOL);
        addDrop(ModBlocks.ABERRANT_BLACK_SEAT);
        addDrop(ModBlocks.ABERRANT_BLACK_CONCRETE);
        addDrop(ModBlocks.ABERRANT_BLACK_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_BLACK_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_BLACK_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_GRAY_WOOL);
        addDrop(ModBlocks.ABERRANT_GRAY_SEAT);
        addDrop(ModBlocks.ABERRANT_GRAY_CONCRETE);
        addDrop(ModBlocks.ABERRANT_GRAY_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_GRAY_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_GRAY_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_SEAT);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_WHITE_WOOL);
        addDrop(ModBlocks.ABERRANT_WHITE_SEAT);
        addDrop(ModBlocks.ABERRANT_WHITE_CONCRETE);
        addDrop(ModBlocks.ABERRANT_WHITE_CONCRETE_POWER);
        addDrop(ModBlocks.ABERRANT_WHITE_TERRACOTTA);
        addDrop(ModBlocks.ABERRANT_WHITE_GLAZED_TERRACOTTA);

        addDrop(ModBlocks.ABERRANT_YELLOW_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_YELLOW_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_YELLOW_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_YELLOW_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_YELLOW_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_YELLOW_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_LIME_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIME_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_LIME_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_LIME_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIME_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_LIME_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_LIME_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIME_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_LIME_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_GREEN_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_GREEN_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_GREEN_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_GREEN_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_GREEN_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_GREEN_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_GREEN_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_GREEN_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_GREEN_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_CYAN_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_CYAN_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_CYAN_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_CYAN_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_CYAN_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_CYAN_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_CYAN_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_CYAN_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_CYAN_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_BLUE_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_BLUE_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_BLUE_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_BLUE_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_BLUE_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_BLUE_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_BLUE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_BLUE_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_BLUE_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_PINK_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_PINK_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_PINK_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_PINK_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_PINK_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_PINK_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_PINK_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_PINK_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_PINK_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_MAGENTA_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_MAGENTA_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_MAGENTA_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_MAGENTA_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_MAGENTA_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_MAGENTA_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_PURPLE_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_PURPLE_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_PURPLE_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_PURPLE_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_PURPLE_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_PURPLE_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_BROWN_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_BROWN_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_BROWN_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_BROWN_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_BROWN_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_BROWN_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_BROWN_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_BROWN_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_BROWN_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_BLACK_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_BLACK_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_BLACK_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_BLACK_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_BLACK_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_BLACK_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_BLACK_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_BLACK_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_BLACK_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_GRAY_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_GRAY_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_GRAY_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_GRAY_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_GRAY_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_GRAY_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_GRAY_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_GRAY_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_GRAY_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_SLAB));
        addDrop(ModBlocks.ABERRANT_WHITE_WOOL_STAIRS);
        addDrop(ModBlocks.ABERRANT_WHITE_WOOL_SLAB, slabDrops(ModBlocks.ABERRANT_WHITE_WOOL_SLAB));
        addDrop(ModBlocks.ABERRANT_WHITE_CONCRETE_STAIRS);
        addDrop(ModBlocks.ABERRANT_WHITE_CONCRETE_SLAB, slabDrops(ModBlocks.ABERRANT_WHITE_CONCRETE_SLAB));
        addDrop(ModBlocks.ABERRANT_WHITE_TERRACOTTA_STAIRS);
        addDrop(ModBlocks.ABERRANT_WHITE_TERRACOTTA_SLAB, slabDrops(ModBlocks.ABERRANT_WHITE_TERRACOTTA_SLAB));

        addDrop(ModBlocks.ABERRANT_RED_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_RED_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_ORANGE_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_YELLOW_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_LIME_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_LIME_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_GREEN_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_GREEN_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_CYAN_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_CYAN_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_BLUE_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_BLUE_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_PINK_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_PINK_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_MAGENTA_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_PURPLE_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_BROWN_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_BROWN_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_BLACK_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_BLACK_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_GRAY_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_GRAY_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_WALL);
        addDrop(ModBlocks.ABERRANT_WHITE_CONCRETE_WALL);
        addDrop(ModBlocks.ABERRANT_WHITE_TERRACOTTA_WALL);

        addDrop(ModBlocks.ABERRANT_RED_CARPET);
        addDrop(ModBlocks.ABERRANT_ORANGE_CARPET);
        addDrop(ModBlocks.ABERRANT_YELLOW_CARPET);
        addDrop(ModBlocks.ABERRANT_LIME_CARPET);
        addDrop(ModBlocks.ABERRANT_GREEN_CARPET);
        addDrop(ModBlocks.ABERRANT_CYAN_CARPET);
        addDrop(ModBlocks.ABERRANT_LIGHT_BLUE_CARPET);
        addDrop(ModBlocks.ABERRANT_BLUE_CARPET);
        addDrop(ModBlocks.ABERRANT_PINK_CARPET);
        addDrop(ModBlocks.ABERRANT_MAGENTA_CARPET);
        addDrop(ModBlocks.ABERRANT_PURPLE_CARPET);
        addDrop(ModBlocks.ABERRANT_BROWN_CARPET);
        addDrop(ModBlocks.ABERRANT_BLACK_CARPET);
        addDrop(ModBlocks.ABERRANT_GRAY_CARPET);
        addDrop(ModBlocks.ABERRANT_LIGHT_GRAY_CARPET);
        addDrop(ModBlocks.ABERRANT_WHITE_CARPET);

        addDrop(ModBlocks.BEETROOT_RESIN_BRICKS);
        addDrop(ModBlocks.BEETROOT_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.BEETROOT_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.BEETROOT_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.BEETROOT_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.BEETROOT_RESIN_BLOCK);
        addDrop(ModBlocks.BEETROOT_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.BEETROOT_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.BEETROOT_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.BEETROOT_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_BEETROOT_RESIN_BRICKS);
        addDrop(ModBlocks.BEETROOT_RESIN_CLUMP);

        addDrop(ModBlocks.CHORUS_RESIN_BRICKS);
        addDrop(ModBlocks.CHORUS_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.CHORUS_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.CHORUS_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.CHORUS_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.CHORUS_RESIN_BLOCK);
        addDrop(ModBlocks.CHORUS_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.CHORUS_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.CHORUS_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.CHORUS_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_CHORUS_RESIN_BRICKS);
        addDrop(ModBlocks.CHORUS_RESIN_CLUMP);

        addDrop(ModBlocks.LEMON_RESIN_BRICKS);
        addDrop(ModBlocks.LEMON_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.LEMON_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.LEMON_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.LEMON_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.LEMON_RESIN_BLOCK);
        addDrop(ModBlocks.LEMON_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.LEMON_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.LEMON_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.LEMON_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_LEMON_RESIN_BRICKS);
        addDrop(ModBlocks.LEMON_RESIN_CLUMP);

        addDrop(ModBlocks.GLACIER_RESIN_BRICKS);
        addDrop(ModBlocks.GLACIER_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.GLACIER_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.GLACIER_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.GLACIER_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.GLACIER_RESIN_BLOCK);
        addDrop(ModBlocks.GLACIER_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.GLACIER_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.GLACIER_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.GLACIER_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_GLACIER_RESIN_BRICKS);
        addDrop(ModBlocks.GLACIER_RESIN_CLUMP);

        addDrop(ModBlocks.CARAMEL_RESIN_BRICKS);
        addDrop(ModBlocks.CARAMEL_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.CARAMEL_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.CARAMEL_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.CARAMEL_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.CARAMEL_RESIN_BLOCK);
        addDrop(ModBlocks.CARAMEL_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.CARAMEL_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.CARAMEL_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.CARAMEL_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_CARAMEL_RESIN_BRICKS);
        addDrop(ModBlocks.CARAMEL_RESIN_CLUMP);

        addDrop(ModBlocks.TOXIC_RESIN_BRICKS);
        addDrop(ModBlocks.TOXIC_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.TOXIC_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.TOXIC_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.TOXIC_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.TOXIC_RESIN_BLOCK);
        addDrop(ModBlocks.TOXIC_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.TOXIC_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.TOXIC_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.TOXIC_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_TOXIC_RESIN_BRICKS);
        addDrop(ModBlocks.TOXIC_RESIN_CLUMP);

        addDrop(ModBlocks.JADE_RESIN_BRICKS);
        addDrop(ModBlocks.JADE_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.JADE_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.JADE_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.JADE_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.JADE_RESIN_BLOCK);
        addDrop(ModBlocks.JADE_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.JADE_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.JADE_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.JADE_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_JADE_RESIN_BRICKS);
        addDrop(ModBlocks.JADE_RESIN_CLUMP);

        addDrop(ModBlocks.BUBBLE_RESIN_BRICKS);
        addDrop(ModBlocks.BUBBLE_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.BUBBLE_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.BUBBLE_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.BUBBLE_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.BUBBLE_RESIN_BLOCK);
        addDrop(ModBlocks.BUBBLE_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.BUBBLE_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.BUBBLE_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.BUBBLE_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_BUBBLE_RESIN_BRICKS);
        addDrop(ModBlocks.BUBBLE_RESIN_CLUMP);

        addDrop(ModBlocks.OCEAN_RESIN_BRICKS);
        addDrop(ModBlocks.OCEAN_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.OCEAN_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.OCEAN_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.OCEAN_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.OCEAN_RESIN_BLOCK);
        addDrop(ModBlocks.OCEAN_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.OCEAN_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.OCEAN_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.OCEAN_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_OCEAN_RESIN_BRICKS);
        addDrop(ModBlocks.OCEAN_RESIN_CLUMP);

        addDrop(ModBlocks.EMERALD_RESIN_BRICKS);
        addDrop(ModBlocks.EMERALD_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.EMERALD_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.EMERALD_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.EMERALD_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.EMERALD_RESIN_BLOCK);
        addDrop(ModBlocks.EMERALD_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.EMERALD_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.EMERALD_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.EMERALD_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_EMERALD_RESIN_BRICKS);
        addDrop(ModBlocks.EMERALD_RESIN_CLUMP);

        addDrop(ModBlocks.DUSK_RESIN_BRICKS);
        addDrop(ModBlocks.DUSK_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.DUSK_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.DUSK_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.DUSK_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.DUSK_RESIN_BLOCK);
        addDrop(ModBlocks.DUSK_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.DUSK_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.DUSK_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.DUSK_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_DUSK_RESIN_BRICKS);
        addDrop(ModBlocks.DUSK_RESIN_CLUMP);

        addDrop(ModBlocks.DAYBREAK_RESIN_BRICKS);
        addDrop(ModBlocks.DAYBREAK_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.DAYBREAK_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.DAYBREAK_RESIN_BLOCK);
        addDrop(ModBlocks.DAYBREAK_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.DAYBREAK_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_DAYBREAK_RESIN_BRICKS);
        addDrop(ModBlocks.DAYBREAK_RESIN_CLUMP);

        addDrop(ModBlocks.SILT_RESIN_BRICKS);
        addDrop(ModBlocks.SILT_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.SILT_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.SILT_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.SILT_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.SILT_RESIN_BLOCK);
        addDrop(ModBlocks.SILT_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.SILT_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.SILT_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.SILT_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_SILT_RESIN_BRICKS);
        addDrop(ModBlocks.SILT_RESIN_CLUMP);

        addDrop(ModBlocks.GRAPHITE_RESIN_BRICKS);
        addDrop(ModBlocks.GRAPHITE_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.GRAPHITE_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.GRAPHITE_RESIN_BLOCK);
        addDrop(ModBlocks.GRAPHITE_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.GRAPHITE_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_GRAPHITE_RESIN_BRICKS);
        addDrop(ModBlocks.GRAPHITE_RESIN_CLUMP);

        addDrop(ModBlocks.OBSIDIAN_RESIN_BRICKS);
        addDrop(ModBlocks.OBSIDIAN_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.OBSIDIAN_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.OBSIDIAN_RESIN_BLOCK);
        addDrop(ModBlocks.OBSIDIAN_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.OBSIDIAN_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_OBSIDIAN_RESIN_BRICKS);
        addDrop(ModBlocks.OBSIDIAN_RESIN_CLUMP);

        addDrop(ModBlocks.COCOA_RESIN_BRICKS);
        addDrop(ModBlocks.COCOA_RESIN_BRICKS_STAIRS);
        addDrop(ModBlocks.COCOA_RESIN_BRICKS_SLAB, slabDrops(ModBlocks.COCOA_RESIN_BRICKS_SLAB));
        addDrop(ModBlocks.COCOA_RESIN_BRICKS_WALL);
        addDrop(ModBlocks.COCOA_RESIN_BLOCK);
        addDrop(ModBlocks.COCOA_RESIN_BLOCK_STAIRS);
        addDrop(ModBlocks.COCOA_RESIN_BLOCK_SLAB, slabDrops(ModBlocks.COCOA_RESIN_BLOCK_SLAB));
        addDrop(ModBlocks.COCOA_RESIN_BLOCK_WALL);
        addDrop(ModBlocks.CHISELED_COCOA_RESIN_BRICKS);
        addDrop(ModBlocks.COCOA_RESIN_CLUMP);

        addDrop(ModBlocks.POLISHED_RESIN);
        addDrop(ModBlocks.POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.POLISHED_RESIN_SLAB, slabDrops(ModBlocks.POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.POLISHED_RESIN_WALL);
        addDrop(ModBlocks.BEETROOT_POLISHED_RESIN);
        addDrop(ModBlocks.BEETROOT_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.BEETROOT_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.BEETROOT_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.BEETROOT_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.CARAMEL_POLISHED_RESIN);
        addDrop(ModBlocks.CARAMEL_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.CARAMEL_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.CARAMEL_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.CARAMEL_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.LEMON_POLISHED_RESIN);
        addDrop(ModBlocks.LEMON_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.LEMON_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.LEMON_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.LEMON_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.TOXIC_POLISHED_RESIN);
        addDrop(ModBlocks.TOXIC_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.TOXIC_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.TOXIC_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.TOXIC_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.EMERALD_POLISHED_RESIN);
        addDrop(ModBlocks.EMERALD_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.EMERALD_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.EMERALD_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.EMERALD_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.JADE_POLISHED_RESIN);
        addDrop(ModBlocks.JADE_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.JADE_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.JADE_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.JADE_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.OCEAN_POLISHED_RESIN);
        addDrop(ModBlocks.OCEAN_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.OCEAN_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.OCEAN_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.OCEAN_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.GLACIER_POLISHED_RESIN);
        addDrop(ModBlocks.GLACIER_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.GLACIER_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.GLACIER_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.GLACIER_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.BUBBLE_POLISHED_RESIN);
        addDrop(ModBlocks.BUBBLE_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.BUBBLE_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.BUBBLE_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.BUBBLE_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.DUSK_POLISHED_RESIN);
        addDrop(ModBlocks.DUSK_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.DUSK_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.DUSK_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.DUSK_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.CHORUS_POLISHED_RESIN);
        addDrop(ModBlocks.CHORUS_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.CHORUS_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.CHORUS_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.CHORUS_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.DAYBREAK_POLISHED_RESIN);
        addDrop(ModBlocks.DAYBREAK_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.DAYBREAK_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.DAYBREAK_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.DAYBREAK_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.SILT_POLISHED_RESIN);
        addDrop(ModBlocks.SILT_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.SILT_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.SILT_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.SILT_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.GRAPHITE_POLISHED_RESIN);
        addDrop(ModBlocks.GRAPHITE_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.GRAPHITE_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.GRAPHITE_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.GRAPHITE_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.OBSIDIAN_POLISHED_RESIN);
        addDrop(ModBlocks.OBSIDIAN_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.OBSIDIAN_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.OBSIDIAN_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.OBSIDIAN_POLISHED_RESIN_WALL);
        addDrop(ModBlocks.COCOA_POLISHED_RESIN);
        addDrop(ModBlocks.COCOA_POLISHED_RESIN_STAIRS);
        addDrop(ModBlocks.COCOA_POLISHED_RESIN_SLAB, slabDrops(ModBlocks.COCOA_POLISHED_RESIN_SLAB));
        addDrop(ModBlocks.COCOA_POLISHED_RESIN_WALL);

        addDrop(ModBlocks.AMETHYST_TILES);
        addDrop(ModBlocks.AMETHYST_BRICKS);

        addDrop(ModBlocks.ABERRANT_AMETHYST_BLOCK);
        addDrop(ModBlocks.BUDDING_ABERRANT_AMETHYST, dropsNothing());
        addDropWithSilkTouch(ModBlocks.SMALL_ABERRANT_AMETHYST_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_ABERRANT_AMETHYST_BUD);
        addDrop(ModBlocks.ABERRANT_AMETHYST_CLUSTER, (Block block) -> dropsWithSilkTouch((Block)block, ((LeafEntry.Builder)((LootPoolEntry.Builder)((Object)((LeafEntry.Builder) ItemEntry.builder(ModItems.ABERRANT_AMETHYST_SHARD).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4.0f)))).apply(ApplyBonusLootFunction.oreDrops(((RegistryWrapper.Impl)registries.getOrThrow(RegistryKeys.ENCHANTMENT)).getOrThrow(Enchantments.FORTUNE))))).conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create().tag((RegistryWrapper.Impl)registries.getOrThrow(RegistryKeys.ITEM), ItemTags.CLUSTER_MAX_HARVESTABLES)))).alternatively((LootPoolEntry.Builder)this.applyExplosionDecay((ItemConvertible)block, ItemEntry.builder(ModItems.ABERRANT_AMETHYST_SHARD).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0f)))))));

        addDrop(ModBlocks.ABERRANT_AMETHYST_TILES);
        addDrop(ModBlocks.ABERRANT_AMETHYST_BRICKS);

        addDrop(ModBlocks.AMETHYST_TILES_STAIRS);
        addDrop(ModBlocks.AMETHYST_TILES_SLAB, slabDrops(ModBlocks.AMETHYST_TILES_SLAB));
        addDrop(ModBlocks.AMETHYST_TILES_WALL);
        addDrop(ModBlocks.AMETHYST_BRICKS_STAIRS);
        addDrop(ModBlocks.AMETHYST_BRICKS_SLAB, slabDrops(ModBlocks.AMETHYST_BRICKS_SLAB));
        addDrop(ModBlocks.AMETHYST_BRICKS_WALL);
        addDrop(ModBlocks.ABERRANT_AMETHYST_TILES_STAIRS);
        addDrop(ModBlocks.ABERRANT_AMETHYST_TILES_SLAB, slabDrops(ModBlocks.ABERRANT_AMETHYST_TILES_SLAB));
        addDrop(ModBlocks.ABERRANT_AMETHYST_TILES_WALL);
        addDrop(ModBlocks.ABERRANT_AMETHYST_BRICKS_STAIRS);
        addDrop(ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB, slabDrops(ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB));
        addDrop(ModBlocks.ABERRANT_AMETHYST_BRICKS_WALL);

        addDrop(ModBlocks.ABERRANT_SOUL_SANDSTONE);
        addDrop(ModBlocks.ABERRANT_SOUL_SANDSTONE_STAIRS);
        addDrop(ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB, slabDrops(ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB));
        addDrop(ModBlocks.ABERRANT_SOUL_SANDSTONE_WALL);
        addDrop(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE);
        addDrop(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE);
        addDrop(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE);
        addDrop(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_STAIRS);
        addDrop(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB, slabDrops(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB));
        addDrop(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_WALL);

        addDrop(ModBlocks.ABERRANT_PUMPKIN);
        addDrop(ModBlocks.ABERRANT_CARVED_PUMPKIN);
        addDrop(ModBlocks.ABERRANT_JACK_O_LANTERN);

        addDrop(ModBlocks.ABERRANT_OBSIDIAN);
        addDrop(ModBlocks.ABERRANT_CRYING_OBSIDIAN);

        addDrop(ModBlocks.ABERRANT_NETHERRACK);
        addDrop(ModBlocks.ABERRANT_NETHER_BRICKS);
        addDrop(ModBlocks.ABERRANT_NETHER_BRICKS_STAIRS);
        addDrop(ModBlocks.ABERRANT_NETHER_BRICKS_SLAB, slabDrops(ModBlocks.ABERRANT_NETHER_BRICKS_SLAB));
        addDrop(ModBlocks.ABERRANT_NETHER_BRICKS_WALL);
        addDrop(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS);
        addDrop(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_WALL);
        addDrop(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS);
        addDrop(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_STAIRS);
        addDrop(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB, slabDrops(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB));
        addDrop(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_WALL);
        addDrop(ModBlocks.ABERRANT_RED_NETHER_BRICKS);
        addDrop(ModBlocks.ABERRANT_RED_NETHER_BRICKS_STAIRS);
        addDrop(ModBlocks.ABERRANT_RED_NETHER_BRICKS_SLAB, slabDrops(ModBlocks.ABERRANT_RED_NETHER_BRICKS_SLAB));
        addDrop(ModBlocks.ABERRANT_RED_NETHER_BRICKS_WALL);

        addDrop(ModBlocks.ABERRANT_GLOWSTONE, (Block block) -> dropsWithSilkTouch((Block)block, (LootPoolEntry.Builder)applyExplosionDecay((ItemConvertible)block, ((LeafEntry.Builder)((LeafEntry.Builder)ItemEntry.builder(Items.GLOWSTONE_DUST).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0f, 4.0f)))).apply(ApplyBonusLootFunction.uniformBonusCount(((RegistryWrapper.Impl)registries.getOrThrow(RegistryKeys.ENCHANTMENT)).getOrThrow(Enchantments.FORTUNE)))).apply(LimitCountLootFunction.builder(BoundedIntUnaryOperator.create(1, 4))))));
    }
}
