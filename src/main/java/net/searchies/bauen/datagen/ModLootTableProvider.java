package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.entry.AlternativeEntry;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryWrapper;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.block.GoldHoardBlock;
import net.searchies.bauen.block.ModBlocks;
import net.searchies.bauen.item.ModItems;

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

//        addDrop(ModBlocks.GOLD_HOARD, (Block block) -> LootTable.builder().pool(LootPool.builder().conditionally(EntityPropertiesLootCondition.create(LootContext.EntityReference.THIS)).with(AlternativeEntry.builder(new LootPoolEntry.Builder[]{AlternativeEntry.builder(GoldHoardBlock.LAYERS.getValues(), layers -> ((LeafEntry.Builder) ItemEntry.builder(ModBlocks.GOLD_COINS).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(GoldHoardBlock.LAYERS, layers.intValue())))).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(layers.intValue() / 2)))), AlternativeEntry.builder(GoldHoardBlock.LAYERS.getValues(), layers -> layers == 8 ? ItemEntry.builder(ModBlocks.GOLD_HOARD_BLOCK) : ((LootPoolEntry.Builder)((Object)ItemEntry.builder(ModBlocks.GOLD_COINS).apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(layers.intValue() / 2))))).conditionally(BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(GoldHoardBlock.LAYERS, layers.intValue()))))}))));

//        addDrop(ModBlocks.GOLD_HOARD_BLOCK, (Block block) -> drops(block, ModBlocks.GOLD_COINS, ConstantLootNumberProvider.create(4.0f)));

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


        addDrop(ModBlocks.CALCITE_BRICKS);
        addDrop(ModBlocks.CALCITE_BRICKS_STAIRS);
        addDrop(ModBlocks.CALCITE_BRICKS_SLAB, slabDrops(ModBlocks.CALCITE_BRICKS_SLAB));
        addDrop(ModBlocks.CALCITE_BRICKS_WALL);

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

        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS);
        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS);
        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB, slabDrops(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB));
        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS_WALL);

        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS);
        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS);
        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB, slabDrops(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB));
        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS_WALL);


        addDrop(ModBlocks.DRIPSTONE_BRICKS);
        addDrop(ModBlocks.DRIPSTONE_BRICKS_STAIRS);
        addDrop(ModBlocks.DRIPSTONE_BRICKS_SLAB, slabDrops(ModBlocks.DRIPSTONE_BRICKS_SLAB));
        addDrop(ModBlocks.DRIPSTONE_BRICKS_WALL);

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
    }
}
