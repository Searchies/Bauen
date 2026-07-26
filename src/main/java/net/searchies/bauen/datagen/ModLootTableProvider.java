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
        addDrop(ModBlocks.CRACKED_BRICKS);
        addDrop(ModBlocks.CHISELED_BRICKS);
        addDrop(ModBlocks.MOSSY_CHISELED_BRICKS);
        addDrop(ModBlocks.CRACKED_CHISELED_BRICKS);

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

        addDrop(ModBlocks.INDUSTRIAL_IRON_BLOCK);
        addDrop(ModBlocks.CUT_INDUSTRIAL_IRON);
        addDrop(ModBlocks.CARVED_INDUSTRIAL_IRON);
        addDrop(ModBlocks.INDUSTRIAL_IRON_GRATE);
        addDrop(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
        addDrop(ModBlocks.INDUSTRIAL_IRON_DOOR, doorDrops(ModBlocks.INDUSTRIAL_IRON_DOOR));

        addDrop(ModBlocks.MOSSY_PACKED_MUD);
        addDrop(ModBlocks.MOSSY_MUD_BRICKS);
        addDrop(ModBlocks.MOSSY_TUFF_BRICKS);
        addDrop(ModBlocks.SCULKED_DEEPSLATE_BRICKS);

        addDrop(ModBlocks.KAOLIN_CLAY, block -> drops(block, ModItems.KAOLIN_CLAY_BALL, ConstantLootNumberProvider.create(4.0F)));

        addDrop(ModBlocks.MIDNIGHT_BRICKS);
        addDrop(ModBlocks.MOSSY_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.CRACKED_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.CHISELED_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
        addDrop(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);

        addDrop(ModBlocks.TREATED_BRICKS);
        addDrop(ModBlocks.MOSSY_TREATED_BRICKS);
        addDrop(ModBlocks.CRACKED_TREATED_BRICKS);
        addDrop(ModBlocks.CHISELED_TREATED_BRICKS);
        addDrop(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
        addDrop(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
        addDrop(ModBlocks.MIXED_BRICKS);
        addDrop(ModBlocks.MOSSY_MIXED_BRICKS);
        addDrop(ModBlocks.CRACKED_MIXED_BRICKS);

        addDrop(ModBlocks.CALCITE_BRICKS);
        addDrop(ModBlocks.MOSSY_CALCITE_BRICKS);
        addDrop(ModBlocks.CRACKED_CALCITE_BRICKS);

        addDrop(ModBlocks.ANDESITE_BRICKS);
        addDrop(ModBlocks.MOSSY_ANDESITE_BRICKS);
        addDrop(ModBlocks.CRACKED_ANDESITE_BRICKS);

        addDrop(ModBlocks.DIORITE_BRICKS);
        addDrop(ModBlocks.MOSSY_DIORITE_BRICKS);
        addDrop(ModBlocks.CRACKED_DIORITE_BRICKS);

        addDrop(ModBlocks.DRIPSTONE_BRICKS);
        addDrop(ModBlocks.MOSSY_DRIPSTONE_BRICKS);
        addDrop(ModBlocks.CRACKED_DRIPSTONE_BRICKS);

        addDrop(ModBlocks.GRANITE_BRICKS);
        addDrop(ModBlocks.MOSSY_GRANITE_BRICKS);
        addDrop(ModBlocks.CRACKED_GRANITE_BRICKS);

        addDrop(ModBlocks.OCEANSLATE);
        addDrop(ModBlocks.OCEANSLATE_BRICKS);
        addDrop(ModBlocks.OCEANSLATE_TILES);
        addDrop(ModBlocks.POLISHED_OCEANSLATE);
        addDrop(ModBlocks.CRACKED_OCEANSLATE_BRICKS);
        addDrop(ModBlocks.KELPY_OCEANSLATE_BRICKS);

    }

    private int half(int layerNumber) {
        return layerNumber / 2;
    }
}
