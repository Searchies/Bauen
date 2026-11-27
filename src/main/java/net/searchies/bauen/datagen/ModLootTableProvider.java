package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.IntRange;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.LimitCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.MatchTool;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.searchies.bauen.block.GoldHoardBlock;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput,
                           CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.MOSSY_BRICKS);
        dropSelf(ModBlocks.MOSSY_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_BRICKS);
        dropSelf(ModBlocks.CRACKED_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_BRICKS_WALL);

        dropSelf(ModBlocks.CHISELED_BRICKS);
        dropSelf(ModBlocks.CHISELED_BRICKS_STAIRS);
        add(ModBlocks.CHISELED_BRICKS_SLAB, createSlabItemTable(ModBlocks.CHISELED_BRICKS_SLAB));
        dropSelf(ModBlocks.CHISELED_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_CHISELED_BRICKS);
        dropSelf(ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_CHISELED_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_CHISELED_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_CHISELED_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_CHISELED_BRICKS);
        dropSelf(ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_CHISELED_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_CHISELED_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_CHISELED_BRICKS_WALL);

        dropSelf(ModBlocks.GOLD_CHAIN);
        dropSelf(ModBlocks.GOLD_LANTERN);
        dropSelf(ModBlocks.GOLD_BARS);
        dropSelf(ModBlocks.CUT_GOLD);
        dropSelf(ModBlocks.CHISELED_GOLD);
        dropSelf(ModBlocks.GOLD_GRATE);
        dropSelf(ModBlocks.GOLD_TRAPDOOR);
        add(ModBlocks.GOLD_DOOR, createDoorTable(ModBlocks.GOLD_DOOR));
        add(ModBlocks.GOLD_COINS, createSegmentedBlockDrops(ModBlocks.GOLD_COINS));

        add(ModBlocks.GOLD_HOARD, (Block block) -> LootTable.lootTable().withPool(LootPool.lootPool().when(LootItemEntityPropertyCondition.entityPresent(LootContext.EntityTarget.THIS)).add(AlternativesEntry.alternatives(new LootPoolEntryContainer.Builder[]{AlternativesEntry.alternatives(GoldHoardBlock.LAYERS.getPossibleValues(), layers -> ((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(ModBlocks.GOLD_COINS).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldHoardBlock.LAYERS, layers.intValue())))).apply(SetItemCountFunction.setCount(ConstantValue.exactly(layers.intValue() / 2)))), AlternativesEntry.alternatives(GoldHoardBlock.LAYERS.getPossibleValues(), layers -> layers == 8 ? LootItem.lootTableItem(ModBlocks.GOLD_HOARD_BLOCK) : ((LootPoolEntryContainer.Builder)((Object)LootItem.lootTableItem(ModBlocks.GOLD_COINS).apply(SetItemCountFunction.setCount(ConstantValue.exactly(layers.intValue() / 2))))).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(GoldHoardBlock.LAYERS, layers.intValue()))))}))));

        add(ModBlocks.GOLD_HOARD_BLOCK, (Block block) -> createSingleItemTableWithSilkTouch(block, ModBlocks.GOLD_COINS, ConstantValue.exactly(4.0f)));

        dropSelf(ModBlocks.MIXED_COBBLESTONE);
        dropSelf(ModBlocks.MIXED_COBBLESTONE_STAIRS);
        add(ModBlocks.MIXED_COBBLESTONE_SLAB, createSlabItemTable(ModBlocks.MIXED_COBBLESTONE_SLAB));
        dropSelf(ModBlocks.MIXED_COBBLESTONE_WALL);

        dropSelf(ModBlocks.INDUSTRIAL_IRON_BLOCK);
        dropSelf(ModBlocks.INDUSTRIAL_IRON_STAIRS);
        add(ModBlocks.INDUSTRIAL_IRON_SLAB, createSlabItemTable(ModBlocks.INDUSTRIAL_IRON_SLAB));
        dropSelf(ModBlocks.INDUSTRIAL_IRON_WALL);

        dropSelf(ModBlocks.CUT_INDUSTRIAL_IRON);
        dropSelf(ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS);
        add(ModBlocks.CUT_INDUSTRIAL_IRON_SLAB, createSlabItemTable(ModBlocks.CUT_INDUSTRIAL_IRON_SLAB));
        dropSelf(ModBlocks.CUT_INDUSTRIAL_IRON_WALL);

        dropSelf(ModBlocks.CARVED_INDUSTRIAL_IRON);
        dropSelf(ModBlocks.INDUSTRIAL_IRON_GRATE);
        dropSelf(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
        add(ModBlocks.INDUSTRIAL_IRON_DOOR, createDoorTable(ModBlocks.INDUSTRIAL_IRON_DOOR));

        dropSelf(ModBlocks.ICE_STAIRS);
        add(ModBlocks.ICE_SLAB, createSlabItemTable(ModBlocks.ICE_SLAB));
        dropSelf(ModBlocks.ICE_WALL);

        dropSelf(ModBlocks.PACKED_ICE_STAIRS);
        add(ModBlocks.PACKED_ICE_SLAB, createSlabItemTable(ModBlocks.PACKED_ICE_SLAB));
        dropSelf(ModBlocks.PACKED_ICE_WALL);

        dropSelf(ModBlocks.MUD_STAIRS);
        add(ModBlocks.MUD_SLAB, createSlabItemTable(ModBlocks.MUD_SLAB));
        dropSelf(ModBlocks.MUD_WALL);

        dropSelf(ModBlocks.MOSSY_PACKED_MUD);
        dropSelf(ModBlocks.MOSSY_PACKED_MUD_STAIRS);
        add(ModBlocks.MOSSY_PACKED_MUD_SLAB, createSlabItemTable(ModBlocks.MOSSY_PACKED_MUD_SLAB));
        dropSelf(ModBlocks.MOSSY_PACKED_MUD_WALL);

        dropSelf(ModBlocks.MOSSY_MUD_BRICKS);
        dropSelf(ModBlocks.MOSSY_MUD_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_MUD_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_MUD_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_MUD_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_TUFF_BRICKS);
        dropSelf(ModBlocks.MOSSY_TUFF_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_TUFF_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_TUFF_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_TUFF_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_TUFF_BRICKS);
        dropSelf(ModBlocks.CRACKED_TUFF_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_TUFF_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_TUFF_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_TUFF_BRICKS_WALL);

        dropSelf(ModBlocks.SCULKED_DEEPSLATE_BRICKS);
        dropSelf(ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS);
        add(ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB, createSlabItemTable(ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB));
        dropSelf(ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL);

        add(ModBlocks.KAOLIN_CLAY, block -> createSingleItemTableWithSilkTouch(block, ModItems.KAOLIN_CLAY_BALL, ConstantValue.exactly(4.0F)));

        dropSelf(ModBlocks.MIDNIGHT_BRICKS);
        dropSelf(ModBlocks.MIDNIGHT_BRICKS_STAIRS);
        add(ModBlocks.MIDNIGHT_BRICKS_SLAB, createSlabItemTable(ModBlocks.MIDNIGHT_BRICKS_SLAB));
        dropSelf(ModBlocks.MIDNIGHT_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_MIDNIGHT_BRICKS);
        dropSelf(ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_MIDNIGHT_BRICKS);
        dropSelf(ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL);

        dropSelf(ModBlocks.CHISELED_MIDNIGHT_BRICKS);
        dropSelf(ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS);
        add(ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB, createSlabItemTable(ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB));
        dropSelf(ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
        dropSelf(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);
        dropSelf(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL);

        dropSelf(ModBlocks.TREATED_BRICKS);
        dropSelf(ModBlocks.TREATED_BRICKS_STAIRS);
        add(ModBlocks.TREATED_BRICKS_SLAB, createSlabItemTable(ModBlocks.TREATED_BRICKS_SLAB));
        dropSelf(ModBlocks.TREATED_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_TREATED_BRICKS);
        dropSelf(ModBlocks.MOSSY_TREATED_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_TREATED_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_TREATED_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_TREATED_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_TREATED_BRICKS);
        dropSelf(ModBlocks.CRACKED_TREATED_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_TREATED_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_TREATED_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_TREATED_BRICKS_WALL);

        dropSelf(ModBlocks.CHISELED_TREATED_BRICKS);
        dropSelf(ModBlocks.CHISELED_TREATED_BRICKS_STAIRS);
        add(ModBlocks.CHISELED_TREATED_BRICKS_SLAB, createSlabItemTable(ModBlocks.CHISELED_TREATED_BRICKS_SLAB));
        dropSelf(ModBlocks.CHISELED_TREATED_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
        dropSelf(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
        dropSelf(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL);

        dropSelf(ModBlocks.MIXED_BRICKS);
        dropSelf(ModBlocks.MIXED_BRICKS_STAIRS);
        add(ModBlocks.MIXED_BRICKS_SLAB, createSlabItemTable(ModBlocks.MIXED_BRICKS_SLAB));
        dropSelf(ModBlocks.MIXED_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_MIXED_BRICKS);
        dropSelf(ModBlocks.MOSSY_MIXED_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_MIXED_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_MIXED_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_MIXED_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_MIXED_BRICKS);
        dropSelf(ModBlocks.CRACKED_MIXED_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_MIXED_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_MIXED_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_MIXED_BRICKS_WALL);


        dropSelf(ModBlocks.POLISHED_CALCITE);
        dropSelf(ModBlocks.POLISHED_CALCITE_STAIRS);
        add(ModBlocks.POLISHED_CALCITE_SLAB, createSlabItemTable(ModBlocks.POLISHED_CALCITE_SLAB));
        dropSelf(ModBlocks.POLISHED_CALCITE_WALL);

        dropSelf(ModBlocks.CALCITE_BRICKS);
        dropSelf(ModBlocks.CALCITE_BRICKS_STAIRS);
        add(ModBlocks.CALCITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.CALCITE_BRICKS_SLAB));
        dropSelf(ModBlocks.CALCITE_BRICKS_WALL);

        dropSelf(ModBlocks.POLISHED_CALCITE_BRICKS);
        dropSelf(ModBlocks.POLISHED_CALCITE_BRICKS_STAIRS);
        add(ModBlocks.POLISHED_CALCITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.POLISHED_CALCITE_BRICKS_SLAB));
        dropSelf(ModBlocks.POLISHED_CALCITE_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_CALCITE_BRICKS);
        dropSelf(ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_CALCITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_CALCITE_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_CALCITE_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_CALCITE_BRICKS);
        dropSelf(ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_CALCITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_CALCITE_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_CALCITE_BRICKS_WALL);


        dropSelf(ModBlocks.ANDESITE_BRICKS);
        dropSelf(ModBlocks.ANDESITE_BRICKS_STAIRS);
        add(ModBlocks.ANDESITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.ANDESITE_BRICKS_SLAB));
        dropSelf(ModBlocks.ANDESITE_BRICKS_WALL);

        dropSelf(ModBlocks.POLISHED_ANDESITE_BRICKS);
        dropSelf(ModBlocks.POLISHED_ANDESITE_BRICKS_STAIRS);
        add(ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB));
        dropSelf(ModBlocks.POLISHED_ANDESITE_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_ANDESITE_BRICKS);
        dropSelf(ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_ANDESITE_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_ANDESITE_BRICKS);
        dropSelf(ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_ANDESITE_BRICKS_WALL);


        dropSelf(ModBlocks.DIORITE_BRICKS);
        dropSelf(ModBlocks.DIORITE_BRICKS_STAIRS);
        add(ModBlocks.DIORITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.DIORITE_BRICKS_SLAB));
        dropSelf(ModBlocks.DIORITE_BRICKS_WALL);

        dropSelf(ModBlocks.POLISHED_DIORITE_BRICKS);
        dropSelf(ModBlocks.POLISHED_DIORITE_BRICKS_STAIRS);
        add(ModBlocks.POLISHED_DIORITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.POLISHED_DIORITE_BRICKS_SLAB));
        dropSelf(ModBlocks.POLISHED_DIORITE_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_DIORITE_BRICKS);
        dropSelf(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_DIORITE_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_DIORITE_BRICKS);
        dropSelf(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_DIORITE_BRICKS_WALL);


        dropSelf(ModBlocks.POLISHED_DRIPSTONE);
        dropSelf(ModBlocks.POLISHED_DRIPSTONE_STAIRS);
        add(ModBlocks.POLISHED_DRIPSTONE_SLAB, createSlabItemTable(ModBlocks.POLISHED_DRIPSTONE_SLAB));
        dropSelf(ModBlocks.POLISHED_DRIPSTONE_WALL);

        dropSelf(ModBlocks.DRIPSTONE_BRICKS);
        dropSelf(ModBlocks.DRIPSTONE_BRICKS_STAIRS);
        add(ModBlocks.DRIPSTONE_BRICKS_SLAB, createSlabItemTable(ModBlocks.DRIPSTONE_BRICKS_SLAB));
        dropSelf(ModBlocks.DRIPSTONE_BRICKS_WALL);

        dropSelf(ModBlocks.POLISHED_DRIPSTONE_BRICKS);
        dropSelf(ModBlocks.POLISHED_DRIPSTONE_BRICKS_STAIRS);
        add(ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB, createSlabItemTable(ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB));
        dropSelf(ModBlocks.POLISHED_DRIPSTONE_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_DRIPSTONE_BRICKS);
        dropSelf(ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_DRIPSTONE_BRICKS);
        dropSelf(ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL);


        dropSelf(ModBlocks.GRANITE_BRICKS);
        dropSelf(ModBlocks.GRANITE_BRICKS_STAIRS);
        add(ModBlocks.GRANITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.GRANITE_BRICKS_SLAB));
        dropSelf(ModBlocks.GRANITE_BRICKS_WALL);

        dropSelf(ModBlocks.POLISHED_GRANITE_BRICKS);
        dropSelf(ModBlocks.POLISHED_GRANITE_BRICKS_STAIRS);
        add(ModBlocks.POLISHED_GRANITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.POLISHED_GRANITE_BRICKS_SLAB));
        dropSelf(ModBlocks.POLISHED_GRANITE_BRICKS_WALL);

        dropSelf(ModBlocks.MOSSY_GRANITE_BRICKS);
        dropSelf(ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS);
        add(ModBlocks.MOSSY_GRANITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.MOSSY_GRANITE_BRICKS_SLAB));
        dropSelf(ModBlocks.MOSSY_GRANITE_BRICKS_WALL);

        dropSelf(ModBlocks.CRACKED_GRANITE_BRICKS);
        dropSelf(ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_GRANITE_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_GRANITE_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_GRANITE_BRICKS_WALL);


        dropSelf(ModBlocks.OCEANSLATE);
        dropSelf(ModBlocks.OCEANSLATE_STAIRS);
        add(ModBlocks.OCEANSLATE_SLAB, createSlabItemTable(ModBlocks.OCEANSLATE_SLAB));
        dropSelf(ModBlocks.OCEANSLATE_WALL);

        dropSelf(ModBlocks.OCEANSLATE_BRICKS);
        dropSelf(ModBlocks.OCEANSLATE_BRICKS_STAIRS);
        add(ModBlocks.OCEANSLATE_BRICKS_SLAB, createSlabItemTable(ModBlocks.OCEANSLATE_BRICKS_SLAB));
        dropSelf(ModBlocks.OCEANSLATE_BRICKS_WALL);

        dropSelf(ModBlocks.OCEANSLATE_TILES);
        dropSelf(ModBlocks.OCEANSLATE_TILES_STAIRS);
        add(ModBlocks.OCEANSLATE_TILES_SLAB, createSlabItemTable(ModBlocks.OCEANSLATE_TILES_SLAB));
        dropSelf(ModBlocks.OCEANSLATE_TILES_WALL);

        dropSelf(ModBlocks.POLISHED_OCEANSLATE);
        dropSelf(ModBlocks.POLISHED_OCEANSLATE_STAIRS);
        add(ModBlocks.POLISHED_OCEANSLATE_SLAB, createSlabItemTable(ModBlocks.POLISHED_OCEANSLATE_SLAB));
        dropSelf(ModBlocks.POLISHED_OCEANSLATE_WALL);

        dropSelf(ModBlocks.CRACKED_OCEANSLATE_BRICKS);
        dropSelf(ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL);

        dropSelf(ModBlocks.KELPY_OCEANSLATE_BRICKS);
        dropSelf(ModBlocks.KELPY_OCEANSLATE_BRICKS_STAIRS);
        add(ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB, createSlabItemTable(ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB));
        dropSelf(ModBlocks.KELPY_OCEANSLATE_BRICKS_WALL);

        dropSelf(ModBlocks.RED_SEAT);
        dropSelf(ModBlocks.ORANGE_SEAT);
        dropSelf(ModBlocks.YELLOW_SEAT);
        dropSelf(ModBlocks.LIME_SEAT);
        dropSelf(ModBlocks.GREEN_SEAT);
        dropSelf(ModBlocks.CYAN_SEAT);
        dropSelf(ModBlocks.LIGHT_BLUE_SEAT);
        dropSelf(ModBlocks.BLUE_SEAT);
        dropSelf(ModBlocks.PINK_SEAT);
        dropSelf(ModBlocks.MAGENTA_SEAT);
        dropSelf(ModBlocks.PURPLE_SEAT);
        dropSelf(ModBlocks.BROWN_SEAT);
        dropSelf(ModBlocks.LIGHT_GRAY_SEAT);
        dropSelf(ModBlocks.GRAY_SEAT);
        dropSelf(ModBlocks.BLACK_SEAT);
        dropSelf(ModBlocks.WHITE_SEAT);

        dropSelf(ModBlocks.ABERRANT);
        dropSelf(ModBlocks.ABERRANT_SEA_LANTERN);
        dropSelf(ModBlocks.ABERRANT_DARK_PRISMARINE);
        dropSelf(ModBlocks.ABERRANT_DARK_PRISMARINE_STAIRS);
        add(ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB));
        dropSelf(ModBlocks.ABERRANT_DARK_PRISMARINE_WALL);
        dropSelf(ModBlocks.ABERRANT_PRISMARINE);
        dropSelf(ModBlocks.ABERRANT_PRISMARINE_STAIRS);
        add(ModBlocks.ABERRANT_PRISMARINE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_PRISMARINE_SLAB));
        dropSelf(ModBlocks.ABERRANT_PRISMARINE_WALL);
        dropSelf(ModBlocks.ABERRANT_PRISMARINE_BRICKS);
        dropSelf(ModBlocks.ABERRANT_PRISMARINE_BRICKS_STAIRS);
        add(ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB, createSlabItemTable(ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB));
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE);
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE_STAIRS);
        add(ModBlocks.ABERRANT_OCEANSLATE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_OCEANSLATE_SLAB));
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE_WALL);
        dropSelf(ModBlocks.ABERRANT_POLISHED_OCEANSLATE);
        dropSelf(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_STAIRS);
        add(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB));
        dropSelf(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_WALL);
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE_TILES);
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE_TILES_STAIRS);
        add(ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB, createSlabItemTable(ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB));
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE_TILES_WALL);
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE_BRICKS);
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_STAIRS);
        add(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB, createSlabItemTable(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB));
        dropSelf(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_WALL);
        dropSelf(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS);
        dropSelf(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_SLAB, createSlabItemTable(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_WALL);
        dropSelf(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS);
        dropSelf(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_STAIRS);
        add(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB, createSlabItemTable(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB));
        dropSelf(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_WALL);

        dropSelf(ModBlocks.SOUL_SANDSTONE);
        dropSelf(ModBlocks.SOUL_SANDSTONE_STAIRS);
        add(ModBlocks.SOUL_SANDSTONE_SLAB, createSlabItemTable(ModBlocks.SOUL_SANDSTONE_SLAB));
        dropSelf(ModBlocks.SOUL_SANDSTONE_WALL);
        dropSelf(ModBlocks.CUT_SOUL_SANDSTONE);
        dropSelf(ModBlocks.CHISELED_SOUL_SANDSTONE);
        dropSelf(ModBlocks.SMOOTH_SOUL_SANDSTONE);
        dropSelf(ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS);
        add(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, createSlabItemTable(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB));
        dropSelf(ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL);

        dropSelf(ModBlocks.ABERRANT_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_RED_WOOL);
        dropSelf(ModBlocks.ABERRANT_RED_SEAT);
        dropSelf(ModBlocks.ABERRANT_RED_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_RED_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_RED_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_RED_GLAZED_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_RED_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_RED_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_RED_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_RED_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_RED_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_RED_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_RED_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_RED_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_RED_CONCRETE_SLAB));

        dropSelf(ModBlocks.ABERRANT_ORANGE_WOOL);
        dropSelf(ModBlocks.ABERRANT_ORANGE_SEAT);
        dropSelf(ModBlocks.ABERRANT_ORANGE_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_ORANGE_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_ORANGE_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_ORANGE_GLAZED_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_ORANGE_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_ORANGE_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_ORANGE_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_ORANGE_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_ORANGE_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_ORANGE_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_SLAB));

        dropSelf(ModBlocks.ABERRANT_YELLOW_WOOL);
        dropSelf(ModBlocks.ABERRANT_YELLOW_SEAT);
        dropSelf(ModBlocks.ABERRANT_YELLOW_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_YELLOW_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_YELLOW_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_YELLOW_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_LIME_WOOL);
        dropSelf(ModBlocks.ABERRANT_LIME_SEAT);
        dropSelf(ModBlocks.ABERRANT_LIME_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_LIME_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_LIME_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_LIME_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_GREEN_WOOL);
        dropSelf(ModBlocks.ABERRANT_GREEN_SEAT);
        dropSelf(ModBlocks.ABERRANT_GREEN_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_GREEN_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_GREEN_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_GREEN_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_CYAN_WOOL);
        dropSelf(ModBlocks.ABERRANT_CYAN_SEAT);
        dropSelf(ModBlocks.ABERRANT_CYAN_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_CYAN_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_CYAN_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_CYAN_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL);
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_SEAT);
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_BLUE_WOOL);
        dropSelf(ModBlocks.ABERRANT_BLUE_SEAT);
        dropSelf(ModBlocks.ABERRANT_BLUE_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_BLUE_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_BLUE_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_BLUE_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_PINK_WOOL);
        dropSelf(ModBlocks.ABERRANT_PINK_SEAT);
        dropSelf(ModBlocks.ABERRANT_PINK_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_PINK_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_PINK_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_PINK_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_MAGENTA_WOOL);
        dropSelf(ModBlocks.ABERRANT_MAGENTA_SEAT);
        dropSelf(ModBlocks.ABERRANT_MAGENTA_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_MAGENTA_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_MAGENTA_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_PURPLE_WOOL);
        dropSelf(ModBlocks.ABERRANT_PURPLE_SEAT);
        dropSelf(ModBlocks.ABERRANT_PURPLE_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_PURPLE_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_PURPLE_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_PURPLE_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_BROWN_WOOL);
        dropSelf(ModBlocks.ABERRANT_BROWN_SEAT);
        dropSelf(ModBlocks.ABERRANT_BROWN_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_BROWN_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_BROWN_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_BROWN_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_BLACK_WOOL);
        dropSelf(ModBlocks.ABERRANT_BLACK_SEAT);
        dropSelf(ModBlocks.ABERRANT_BLACK_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_BLACK_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_BLACK_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_BLACK_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_GRAY_WOOL);
        dropSelf(ModBlocks.ABERRANT_GRAY_SEAT);
        dropSelf(ModBlocks.ABERRANT_GRAY_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_GRAY_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_GRAY_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_GRAY_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL);
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_SEAT);
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_WHITE_WOOL);
        dropSelf(ModBlocks.ABERRANT_WHITE_SEAT);
        dropSelf(ModBlocks.ABERRANT_WHITE_CONCRETE);
        dropSelf(ModBlocks.ABERRANT_WHITE_CONCRETE_POWER);
        dropSelf(ModBlocks.ABERRANT_WHITE_TERRACOTTA);
        dropSelf(ModBlocks.ABERRANT_WHITE_GLAZED_TERRACOTTA);

        dropSelf(ModBlocks.ABERRANT_YELLOW_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_YELLOW_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_YELLOW_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_YELLOW_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_YELLOW_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_YELLOW_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIME_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_LIME_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIME_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIME_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_LIME_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIME_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIME_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_LIME_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIME_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_GREEN_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_GREEN_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_GREEN_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_GREEN_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_GREEN_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_GREEN_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_GREEN_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_GREEN_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_GREEN_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_CYAN_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_CYAN_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_CYAN_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_CYAN_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_CYAN_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_CYAN_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_CYAN_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_CYAN_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_CYAN_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_BLUE_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_BLUE_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BLUE_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_BLUE_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_BLUE_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BLUE_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_BLUE_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_BLUE_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BLUE_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_PINK_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_PINK_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_PINK_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_PINK_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_PINK_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_PINK_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_PINK_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_PINK_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_PINK_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_MAGENTA_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_MAGENTA_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_MAGENTA_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_MAGENTA_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_MAGENTA_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_MAGENTA_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_PURPLE_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_PURPLE_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_PURPLE_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_PURPLE_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_PURPLE_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_PURPLE_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_BROWN_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_BROWN_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BROWN_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_BROWN_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_BROWN_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BROWN_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_BROWN_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_BROWN_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BROWN_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_BLACK_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_BLACK_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BLACK_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_BLACK_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_BLACK_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BLACK_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_BLACK_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_BLACK_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_BLACK_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_GRAY_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_GRAY_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_GRAY_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_GRAY_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_GRAY_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_GRAY_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_GRAY_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_GRAY_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_GRAY_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_SLAB));
        dropSelf(ModBlocks.ABERRANT_WHITE_WOOL_STAIRS);
        add(ModBlocks.ABERRANT_WHITE_WOOL_SLAB, createSlabItemTable(ModBlocks.ABERRANT_WHITE_WOOL_SLAB));
        dropSelf(ModBlocks.ABERRANT_WHITE_CONCRETE_STAIRS);
        add(ModBlocks.ABERRANT_WHITE_CONCRETE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_WHITE_CONCRETE_SLAB));
        dropSelf(ModBlocks.ABERRANT_WHITE_TERRACOTTA_STAIRS);
        add(ModBlocks.ABERRANT_WHITE_TERRACOTTA_SLAB, createSlabItemTable(ModBlocks.ABERRANT_WHITE_TERRACOTTA_SLAB));

        dropSelf(ModBlocks.ABERRANT_RED_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_RED_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_ORANGE_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_YELLOW_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_LIME_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_LIME_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_GREEN_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_GREEN_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_CYAN_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_CYAN_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_BLUE_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_BLUE_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_PINK_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_PINK_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_MAGENTA_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_PURPLE_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_BROWN_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_BROWN_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_BLACK_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_BLACK_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_GRAY_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_GRAY_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_WALL);
        dropSelf(ModBlocks.ABERRANT_WHITE_CONCRETE_WALL);
        dropSelf(ModBlocks.ABERRANT_WHITE_TERRACOTTA_WALL);

        dropSelf(ModBlocks.ABERRANT_RED_CARPET);
        dropSelf(ModBlocks.ABERRANT_ORANGE_CARPET);
        dropSelf(ModBlocks.ABERRANT_YELLOW_CARPET);
        dropSelf(ModBlocks.ABERRANT_LIME_CARPET);
        dropSelf(ModBlocks.ABERRANT_GREEN_CARPET);
        dropSelf(ModBlocks.ABERRANT_CYAN_CARPET);
        dropSelf(ModBlocks.ABERRANT_LIGHT_BLUE_CARPET);
        dropSelf(ModBlocks.ABERRANT_BLUE_CARPET);
        dropSelf(ModBlocks.ABERRANT_PINK_CARPET);
        dropSelf(ModBlocks.ABERRANT_MAGENTA_CARPET);
        dropSelf(ModBlocks.ABERRANT_PURPLE_CARPET);
        dropSelf(ModBlocks.ABERRANT_BROWN_CARPET);
        dropSelf(ModBlocks.ABERRANT_BLACK_CARPET);
        dropSelf(ModBlocks.ABERRANT_GRAY_CARPET);
        dropSelf(ModBlocks.ABERRANT_LIGHT_GRAY_CARPET);
        dropSelf(ModBlocks.ABERRANT_WHITE_CARPET);

        dropSelf(ModBlocks.BEETROOT_RESIN_BRICKS);
        dropSelf(ModBlocks.BEETROOT_RESIN_BRICKS_STAIRS);
        add(ModBlocks.BEETROOT_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.BEETROOT_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.BEETROOT_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.BEETROOT_RESIN_BLOCK);
        dropSelf(ModBlocks.BEETROOT_RESIN_BLOCK_STAIRS);
        add(ModBlocks.BEETROOT_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.BEETROOT_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.BEETROOT_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_BEETROOT_RESIN_BRICKS);
        dropSelf(ModBlocks.BEETROOT_RESIN_CLUMP);

        dropSelf(ModBlocks.CHORUS_RESIN_BRICKS);
        dropSelf(ModBlocks.CHORUS_RESIN_BRICKS_STAIRS);
        add(ModBlocks.CHORUS_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.CHORUS_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.CHORUS_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.CHORUS_RESIN_BLOCK);
        dropSelf(ModBlocks.CHORUS_RESIN_BLOCK_STAIRS);
        add(ModBlocks.CHORUS_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.CHORUS_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.CHORUS_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_CHORUS_RESIN_BRICKS);
        dropSelf(ModBlocks.CHORUS_RESIN_CLUMP);

        dropSelf(ModBlocks.LEMON_RESIN_BRICKS);
        dropSelf(ModBlocks.LEMON_RESIN_BRICKS_STAIRS);
        add(ModBlocks.LEMON_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.LEMON_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.LEMON_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.LEMON_RESIN_BLOCK);
        dropSelf(ModBlocks.LEMON_RESIN_BLOCK_STAIRS);
        add(ModBlocks.LEMON_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.LEMON_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.LEMON_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_LEMON_RESIN_BRICKS);
        dropSelf(ModBlocks.LEMON_RESIN_CLUMP);

        dropSelf(ModBlocks.GLACIER_RESIN_BRICKS);
        dropSelf(ModBlocks.GLACIER_RESIN_BRICKS_STAIRS);
        add(ModBlocks.GLACIER_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.GLACIER_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.GLACIER_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.GLACIER_RESIN_BLOCK);
        dropSelf(ModBlocks.GLACIER_RESIN_BLOCK_STAIRS);
        add(ModBlocks.GLACIER_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.GLACIER_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.GLACIER_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_GLACIER_RESIN_BRICKS);
        dropSelf(ModBlocks.GLACIER_RESIN_CLUMP);

        dropSelf(ModBlocks.CARAMEL_RESIN_BRICKS);
        dropSelf(ModBlocks.CARAMEL_RESIN_BRICKS_STAIRS);
        add(ModBlocks.CARAMEL_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.CARAMEL_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.CARAMEL_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.CARAMEL_RESIN_BLOCK);
        dropSelf(ModBlocks.CARAMEL_RESIN_BLOCK_STAIRS);
        add(ModBlocks.CARAMEL_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.CARAMEL_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.CARAMEL_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_CARAMEL_RESIN_BRICKS);
        dropSelf(ModBlocks.CARAMEL_RESIN_CLUMP);

        dropSelf(ModBlocks.TOXIC_RESIN_BRICKS);
        dropSelf(ModBlocks.TOXIC_RESIN_BRICKS_STAIRS);
        add(ModBlocks.TOXIC_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.TOXIC_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.TOXIC_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.TOXIC_RESIN_BLOCK);
        dropSelf(ModBlocks.TOXIC_RESIN_BLOCK_STAIRS);
        add(ModBlocks.TOXIC_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.TOXIC_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.TOXIC_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_TOXIC_RESIN_BRICKS);
        dropSelf(ModBlocks.TOXIC_RESIN_CLUMP);

        dropSelf(ModBlocks.JADE_RESIN_BRICKS);
        dropSelf(ModBlocks.JADE_RESIN_BRICKS_STAIRS);
        add(ModBlocks.JADE_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.JADE_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.JADE_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.JADE_RESIN_BLOCK);
        dropSelf(ModBlocks.JADE_RESIN_BLOCK_STAIRS);
        add(ModBlocks.JADE_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.JADE_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.JADE_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_JADE_RESIN_BRICKS);
        dropSelf(ModBlocks.JADE_RESIN_CLUMP);

        dropSelf(ModBlocks.BUBBLE_RESIN_BRICKS);
        dropSelf(ModBlocks.BUBBLE_RESIN_BRICKS_STAIRS);
        add(ModBlocks.BUBBLE_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.BUBBLE_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.BUBBLE_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.BUBBLE_RESIN_BLOCK);
        dropSelf(ModBlocks.BUBBLE_RESIN_BLOCK_STAIRS);
        add(ModBlocks.BUBBLE_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.BUBBLE_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.BUBBLE_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_BUBBLE_RESIN_BRICKS);
        dropSelf(ModBlocks.BUBBLE_RESIN_CLUMP);

        dropSelf(ModBlocks.OCEAN_RESIN_BRICKS);
        dropSelf(ModBlocks.OCEAN_RESIN_BRICKS_STAIRS);
        add(ModBlocks.OCEAN_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.OCEAN_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.OCEAN_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.OCEAN_RESIN_BLOCK);
        dropSelf(ModBlocks.OCEAN_RESIN_BLOCK_STAIRS);
        add(ModBlocks.OCEAN_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.OCEAN_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.OCEAN_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_OCEAN_RESIN_BRICKS);
        dropSelf(ModBlocks.OCEAN_RESIN_CLUMP);

        dropSelf(ModBlocks.EMERALD_RESIN_BRICKS);
        dropSelf(ModBlocks.EMERALD_RESIN_BRICKS_STAIRS);
        add(ModBlocks.EMERALD_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.EMERALD_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.EMERALD_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.EMERALD_RESIN_BLOCK);
        dropSelf(ModBlocks.EMERALD_RESIN_BLOCK_STAIRS);
        add(ModBlocks.EMERALD_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.EMERALD_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.EMERALD_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_EMERALD_RESIN_BRICKS);
        dropSelf(ModBlocks.EMERALD_RESIN_CLUMP);

        dropSelf(ModBlocks.DUSK_RESIN_BRICKS);
        dropSelf(ModBlocks.DUSK_RESIN_BRICKS_STAIRS);
        add(ModBlocks.DUSK_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.DUSK_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.DUSK_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.DUSK_RESIN_BLOCK);
        dropSelf(ModBlocks.DUSK_RESIN_BLOCK_STAIRS);
        add(ModBlocks.DUSK_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.DUSK_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.DUSK_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_DUSK_RESIN_BRICKS);
        dropSelf(ModBlocks.DUSK_RESIN_CLUMP);

        dropSelf(ModBlocks.DAYBREAK_RESIN_BRICKS);
        dropSelf(ModBlocks.DAYBREAK_RESIN_BRICKS_STAIRS);
        add(ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.DAYBREAK_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.DAYBREAK_RESIN_BLOCK);
        dropSelf(ModBlocks.DAYBREAK_RESIN_BLOCK_STAIRS);
        add(ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.DAYBREAK_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_DAYBREAK_RESIN_BRICKS);
        dropSelf(ModBlocks.DAYBREAK_RESIN_CLUMP);

        dropSelf(ModBlocks.SILT_RESIN_BRICKS);
        dropSelf(ModBlocks.SILT_RESIN_BRICKS_STAIRS);
        add(ModBlocks.SILT_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.SILT_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.SILT_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.SILT_RESIN_BLOCK);
        dropSelf(ModBlocks.SILT_RESIN_BLOCK_STAIRS);
        add(ModBlocks.SILT_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.SILT_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.SILT_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_SILT_RESIN_BRICKS);
        dropSelf(ModBlocks.SILT_RESIN_CLUMP);

        dropSelf(ModBlocks.GRAPHITE_RESIN_BRICKS);
        dropSelf(ModBlocks.GRAPHITE_RESIN_BRICKS_STAIRS);
        add(ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.GRAPHITE_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.GRAPHITE_RESIN_BLOCK);
        dropSelf(ModBlocks.GRAPHITE_RESIN_BLOCK_STAIRS);
        add(ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.GRAPHITE_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_GRAPHITE_RESIN_BRICKS);
        dropSelf(ModBlocks.GRAPHITE_RESIN_CLUMP);

        dropSelf(ModBlocks.OBSIDIAN_RESIN_BRICKS);
        dropSelf(ModBlocks.OBSIDIAN_RESIN_BRICKS_STAIRS);
        add(ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.OBSIDIAN_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.OBSIDIAN_RESIN_BLOCK);
        dropSelf(ModBlocks.OBSIDIAN_RESIN_BLOCK_STAIRS);
        add(ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.OBSIDIAN_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_OBSIDIAN_RESIN_BRICKS);
        dropSelf(ModBlocks.OBSIDIAN_RESIN_CLUMP);

        dropSelf(ModBlocks.COCOA_RESIN_BRICKS);
        dropSelf(ModBlocks.COCOA_RESIN_BRICKS_STAIRS);
        add(ModBlocks.COCOA_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.COCOA_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.COCOA_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.COCOA_RESIN_BLOCK);
        dropSelf(ModBlocks.COCOA_RESIN_BLOCK_STAIRS);
        add(ModBlocks.COCOA_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.COCOA_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.COCOA_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_COCOA_RESIN_BRICKS);
        dropSelf(ModBlocks.COCOA_RESIN_CLUMP);

        dropSelf(ModBlocks.POLISHED_RESIN);
        dropSelf(ModBlocks.POLISHED_RESIN_STAIRS);
        add(ModBlocks.POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.BEETROOT_POLISHED_RESIN);
        dropSelf(ModBlocks.BEETROOT_POLISHED_RESIN_STAIRS);
        add(ModBlocks.BEETROOT_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.BEETROOT_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.BEETROOT_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.CARAMEL_POLISHED_RESIN);
        dropSelf(ModBlocks.CARAMEL_POLISHED_RESIN_STAIRS);
        add(ModBlocks.CARAMEL_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.CARAMEL_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.CARAMEL_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.LEMON_POLISHED_RESIN);
        dropSelf(ModBlocks.LEMON_POLISHED_RESIN_STAIRS);
        add(ModBlocks.LEMON_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.LEMON_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.LEMON_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.TOXIC_POLISHED_RESIN);
        dropSelf(ModBlocks.TOXIC_POLISHED_RESIN_STAIRS);
        add(ModBlocks.TOXIC_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.TOXIC_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.TOXIC_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.EMERALD_POLISHED_RESIN);
        dropSelf(ModBlocks.EMERALD_POLISHED_RESIN_STAIRS);
        add(ModBlocks.EMERALD_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.EMERALD_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.EMERALD_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.JADE_POLISHED_RESIN);
        dropSelf(ModBlocks.JADE_POLISHED_RESIN_STAIRS);
        add(ModBlocks.JADE_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.JADE_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.JADE_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.OCEAN_POLISHED_RESIN);
        dropSelf(ModBlocks.OCEAN_POLISHED_RESIN_STAIRS);
        add(ModBlocks.OCEAN_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.OCEAN_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.OCEAN_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.GLACIER_POLISHED_RESIN);
        dropSelf(ModBlocks.GLACIER_POLISHED_RESIN_STAIRS);
        add(ModBlocks.GLACIER_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.GLACIER_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.GLACIER_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.BUBBLE_POLISHED_RESIN);
        dropSelf(ModBlocks.BUBBLE_POLISHED_RESIN_STAIRS);
        add(ModBlocks.BUBBLE_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.BUBBLE_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.BUBBLE_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.DUSK_POLISHED_RESIN);
        dropSelf(ModBlocks.DUSK_POLISHED_RESIN_STAIRS);
        add(ModBlocks.DUSK_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.DUSK_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.DUSK_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.CHORUS_POLISHED_RESIN);
        dropSelf(ModBlocks.CHORUS_POLISHED_RESIN_STAIRS);
        add(ModBlocks.CHORUS_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.CHORUS_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.CHORUS_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.DAYBREAK_POLISHED_RESIN);
        dropSelf(ModBlocks.DAYBREAK_POLISHED_RESIN_STAIRS);
        add(ModBlocks.DAYBREAK_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.DAYBREAK_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.DAYBREAK_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.SILT_POLISHED_RESIN);
        dropSelf(ModBlocks.SILT_POLISHED_RESIN_STAIRS);
        add(ModBlocks.SILT_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.SILT_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.SILT_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.GRAPHITE_POLISHED_RESIN);
        dropSelf(ModBlocks.GRAPHITE_POLISHED_RESIN_STAIRS);
        add(ModBlocks.GRAPHITE_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.GRAPHITE_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.GRAPHITE_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.OBSIDIAN_POLISHED_RESIN);
        dropSelf(ModBlocks.OBSIDIAN_POLISHED_RESIN_STAIRS);
        add(ModBlocks.OBSIDIAN_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.OBSIDIAN_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.OBSIDIAN_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.COCOA_POLISHED_RESIN);
        dropSelf(ModBlocks.COCOA_POLISHED_RESIN_STAIRS);
        add(ModBlocks.COCOA_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.COCOA_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.COCOA_POLISHED_RESIN_WALL);

        dropSelf(ModBlocks.AMETHYST_TILES);
        dropSelf(ModBlocks.AMETHYST_BRICKS);

        dropSelf(ModBlocks.ABERRANT_AMETHYST_BLOCK);
        add(ModBlocks.BUDDING_ABERRANT_AMETHYST, noDrop());
        dropWhenSilkTouch(ModBlocks.SMALL_ABERRANT_AMETHYST_BUD);
        dropWhenSilkTouch(ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD);
        dropWhenSilkTouch(ModBlocks.LARGE_ABERRANT_AMETHYST_BUD);
        add(ModBlocks.ABERRANT_AMETHYST_CLUSTER, (Block block) -> createSilkTouchDispatchTable((Block)block, ((LootPoolSingletonContainer.Builder)((LootPoolEntryContainer.Builder)((Object)((LootPoolSingletonContainer.Builder) LootItem.lootTableItem(ModItems.ABERRANT_AMETHYST_SHARD).apply(SetItemCountFunction.setCount(ConstantValue.exactly(4.0f)))).apply(ApplyBonusCount.addOreBonusCount(((HolderLookup.RegistryLookup)registries.lookupOrThrow(Registries.ENCHANTMENT)).getOrThrow(Enchantments.FORTUNE))))).when(MatchTool.toolMatches(ItemPredicate.Builder.item().of((HolderLookup.RegistryLookup)registries.lookupOrThrow(Registries.ITEM), ItemTags.CLUSTER_MAX_HARVESTABLES)))).otherwise((LootPoolEntryContainer.Builder)this.applyExplosionDecay((ItemLike)block, LootItem.lootTableItem(ModItems.ABERRANT_AMETHYST_SHARD).apply(SetItemCountFunction.setCount(ConstantValue.exactly(2.0f)))))));

        dropSelf(ModBlocks.ABERRANT_AMETHYST_TILES);
        dropSelf(ModBlocks.ABERRANT_AMETHYST_BRICKS);

        dropSelf(ModBlocks.AMETHYST_TILES_STAIRS);
        add(ModBlocks.AMETHYST_TILES_SLAB, createSlabItemTable(ModBlocks.AMETHYST_TILES_SLAB));
        dropSelf(ModBlocks.AMETHYST_TILES_WALL);
        dropSelf(ModBlocks.AMETHYST_BRICKS_STAIRS);
        add(ModBlocks.AMETHYST_BRICKS_SLAB, createSlabItemTable(ModBlocks.AMETHYST_BRICKS_SLAB));
        dropSelf(ModBlocks.AMETHYST_BRICKS_WALL);
        dropSelf(ModBlocks.ABERRANT_AMETHYST_TILES_STAIRS);
        add(ModBlocks.ABERRANT_AMETHYST_TILES_SLAB, createSlabItemTable(ModBlocks.ABERRANT_AMETHYST_TILES_SLAB));
        dropSelf(ModBlocks.ABERRANT_AMETHYST_TILES_WALL);
        dropSelf(ModBlocks.ABERRANT_AMETHYST_BRICKS_STAIRS);
        add(ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB, createSlabItemTable(ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB));
        dropSelf(ModBlocks.ABERRANT_AMETHYST_BRICKS_WALL);

        dropSelf(ModBlocks.ABERRANT_SOUL_SOIL);
        dropSelf(ModBlocks.ABERRANT_SOUL_SAND);
        dropSelf(ModBlocks.ABERRANT_SOUL_SANDSTONE);
        dropSelf(ModBlocks.ABERRANT_SOUL_SANDSTONE_STAIRS);
        add(ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB));
        dropSelf(ModBlocks.ABERRANT_SOUL_SANDSTONE_WALL);
        dropSelf(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE);
        dropSelf(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE);
        dropSelf(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE);
        dropSelf(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_STAIRS);
        add(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB, createSlabItemTable(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB));
        dropSelf(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_WALL);

        dropSelf(ModBlocks.ABERRANT_PUMPKIN);
        dropSelf(ModBlocks.ABERRANT_CARVED_PUMPKIN);
        dropSelf(ModBlocks.ABERRANT_JACK_O_LANTERN);

        dropSelf(ModBlocks.ABERRANT_OBSIDIAN);
        dropSelf(ModBlocks.ABERRANT_CRYING_OBSIDIAN);

        dropSelf(ModBlocks.ABERRANT_NETHERRACK);
        dropSelf(ModBlocks.ABERRANT_NETHER_BRICKS);
        dropSelf(ModBlocks.ABERRANT_NETHER_BRICKS_STAIRS);
        add(ModBlocks.ABERRANT_NETHER_BRICKS_SLAB, createSlabItemTable(ModBlocks.ABERRANT_NETHER_BRICKS_SLAB));
        dropSelf(ModBlocks.ABERRANT_NETHER_BRICKS_WALL);
        dropSelf(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS);
        dropSelf(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_STAIRS);
        add(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB, createSlabItemTable(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB));
        dropSelf(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_WALL);
        dropSelf(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS);
        dropSelf(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_STAIRS);
        add(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB, createSlabItemTable(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB));
        dropSelf(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_WALL);
        dropSelf(ModBlocks.ABERRANT_RED_NETHER_BRICKS);
        dropSelf(ModBlocks.ABERRANT_RED_NETHER_BRICKS_STAIRS);
        add(ModBlocks.ABERRANT_RED_NETHER_BRICKS_SLAB, createSlabItemTable(ModBlocks.ABERRANT_RED_NETHER_BRICKS_SLAB));
        dropSelf(ModBlocks.ABERRANT_RED_NETHER_BRICKS_WALL);

        add(ModBlocks.ABERRANT_GLOWSTONE, (Block block) -> createSilkTouchDispatchTable((Block)block, (LootPoolEntryContainer.Builder)applyExplosionDecay((ItemLike)block, ((LootPoolSingletonContainer.Builder)((LootPoolSingletonContainer.Builder)LootItem.lootTableItem(Items.GLOWSTONE_DUST).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 4.0f)))).apply(ApplyBonusCount.addUniformBonusCount(((HolderLookup.RegistryLookup)registries.lookupOrThrow(Registries.ENCHANTMENT)).getOrThrow(Enchantments.FORTUNE)))).apply(LimitCount.limitCount(IntRange.range(1, 4))))));

        dropSelf(ModBlocks.ABERRANT_REDSTONE_LAMP);
        dropSelf(ModBlocks.ABERRANT_OCHRE_FROGLIGHT);
        dropSelf(ModBlocks.ABERRANT_VERDANT_FROGLIGHT);
        dropSelf(ModBlocks.ABERRANT_PEARLESCENT_FROGLIGHT);

        dropSelf(ModBlocks.NETHERITE_FENCE);

        ModBlocks.ABERRANT_COPPER_CHAINS.forEach(this::dropSelf);
        ModBlocks.ABERRANT_COPPER_LANTERNS.forEach(this::dropSelf);
        ModBlocks.ABERRANT_COPPER_BARS.forEach(this::dropSelf);

        dropSelf(ModBlocks.ABERRANT_CUT_COPPER);
        dropSelf(ModBlocks.ABERRANT_CUT_COPPER_STAIRS);
        add(ModBlocks.ABERRANT_CUT_COPPER_SLAB, createSlabItemTable(ModBlocks.ABERRANT_CUT_COPPER_SLAB));
        dropSelf(ModBlocks.ABERRANT_CHISELED_COPPER);
        dropSelf(ModBlocks.ABERRANT_COPPER_BLOCK);
        dropSelf(ModBlocks.ABERRANT_COPPER_TRAPDOOR);
        dropSelf(ModBlocks.ABERRANT_COPPER_GRATE);
        add(ModBlocks.ABERRANT_COPPER_DOOR, createDoorTable(ModBlocks.ABERRANT_COPPER_DOOR));
        dropSelf(ModBlocks.ABERRANT_COPPER_BULB);

        dropSelf(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER);
        dropSelf(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_STAIRS);
        add(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_SLAB, createSlabItemTable(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_SLAB));
        dropSelf(ModBlocks.EXPOSED_ABERRANT_CHISELED_COPPER);
        dropSelf(ModBlocks.EXPOSED_ABERRANT_COPPER);
        dropSelf(ModBlocks.EXPOSED_ABERRANT_COPPER_TRAPDOOR);
        dropSelf(ModBlocks.EXPOSED_ABERRANT_COPPER_GRATE);
        add(ModBlocks.EXPOSED_ABERRANT_COPPER_DOOR, createDoorTable(ModBlocks.EXPOSED_ABERRANT_COPPER_DOOR));
        dropSelf(ModBlocks.EXPOSED_ABERRANT_COPPER_BULB);
        dropSelf(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER);
        dropSelf(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_STAIRS);
        add(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_SLAB, createSlabItemTable(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_SLAB));
        dropSelf(ModBlocks.WEATHERED_ABERRANT_CHISELED_COPPER);
        dropSelf(ModBlocks.WEATHERED_ABERRANT_COPPER);
        dropSelf(ModBlocks.WEATHERED_ABERRANT_COPPER_TRAPDOOR);
        dropSelf(ModBlocks.WEATHERED_ABERRANT_COPPER_GRATE);
        add(ModBlocks.WEATHERED_ABERRANT_COPPER_DOOR, createDoorTable(ModBlocks.WEATHERED_ABERRANT_COPPER_DOOR));
        dropSelf(ModBlocks.WEATHERED_ABERRANT_COPPER_BULB);
        dropSelf(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER);
        dropSelf(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_STAIRS);
        add(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_SLAB, createSlabItemTable(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_SLAB));
        dropSelf(ModBlocks.OXIDIZED_ABERRANT_CHISELED_COPPER);
        dropSelf(ModBlocks.OXIDIZED_ABERRANT_COPPER);
        dropSelf(ModBlocks.OXIDIZED_ABERRANT_COPPER_TRAPDOOR);
        dropSelf(ModBlocks.OXIDIZED_ABERRANT_COPPER_GRATE);
        add(ModBlocks.OXIDIZED_ABERRANT_COPPER_DOOR, createDoorTable(ModBlocks.OXIDIZED_ABERRANT_COPPER_DOOR));
        dropSelf(ModBlocks.OXIDIZED_ABERRANT_COPPER_BULB);

        dropSelf(ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER);
        dropSelf(ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER_STAIRS);
        add(ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER_SLAB, createSlabItemTable(ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER_SLAB));
        dropSelf(ModBlocks.WAXED_EXPOSED_ABERRANT_CHISELED_COPPER);
        dropSelf(ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER);
        dropSelf(ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_TRAPDOOR);
        dropSelf(ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_GRATE);
        add(ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_DOOR, createDoorTable(ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_DOOR));
        dropSelf(ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_BULB);
        dropSelf(ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER);
        dropSelf(ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER_STAIRS);
        add(ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER_SLAB, createSlabItemTable(ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER_SLAB));
        dropSelf(ModBlocks.WAXED_WEATHERED_ABERRANT_CHISELED_COPPER);
        dropSelf(ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER);
        dropSelf(ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_TRAPDOOR);
        dropSelf(ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_GRATE);
        add(ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_DOOR, createDoorTable(ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_DOOR));
        dropSelf(ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_BULB);
        dropSelf(ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER);
        dropSelf(ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER_STAIRS);
        add(ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER_SLAB, createSlabItemTable(ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER_SLAB));
        dropSelf(ModBlocks.WAXED_OXIDIZED_ABERRANT_CHISELED_COPPER);
        dropSelf(ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER);
        dropSelf(ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_TRAPDOOR);
        dropSelf(ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_GRATE);
        add(ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_DOOR, createDoorTable(ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_DOOR));
        dropSelf(ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_BULB);

        dropSelf(ModBlocks.BRASS_POLISHED_RESIN);
        dropSelf(ModBlocks.BRASS_POLISHED_RESIN_STAIRS);
        add(ModBlocks.BRASS_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.BRASS_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.BRASS_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.BRASS_RESIN_BRICKS);
        dropSelf(ModBlocks.BRASS_RESIN_BRICKS_STAIRS);
        add(ModBlocks.BRASS_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.BRASS_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.BRASS_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.BRASS_RESIN_BLOCK);
        dropSelf(ModBlocks.BRASS_RESIN_BLOCK_STAIRS);
        add(ModBlocks.BRASS_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.BRASS_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.BRASS_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_BRASS_RESIN_BRICKS);
        dropSelf(ModBlocks.BRASS_RESIN_CLUMP);

        dropSelf(ModBlocks.DANDELION_POLISHED_RESIN);
        dropSelf(ModBlocks.DANDELION_POLISHED_RESIN_STAIRS);
        add(ModBlocks.DANDELION_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.DANDELION_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.DANDELION_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.DANDELION_RESIN_BRICKS);
        dropSelf(ModBlocks.DANDELION_RESIN_BRICKS_STAIRS);
        add(ModBlocks.DANDELION_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.DANDELION_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.DANDELION_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.DANDELION_RESIN_BLOCK);
        dropSelf(ModBlocks.DANDELION_RESIN_BLOCK_STAIRS);
        add(ModBlocks.DANDELION_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.DANDELION_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.DANDELION_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_DANDELION_RESIN_BRICKS);
        dropSelf(ModBlocks.DANDELION_RESIN_CLUMP);

        dropSelf(ModBlocks.BOG_POLISHED_RESIN);
        dropSelf(ModBlocks.BOG_POLISHED_RESIN_STAIRS);
        add(ModBlocks.BOG_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.BOG_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.BOG_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.BOG_RESIN_BRICKS);
        dropSelf(ModBlocks.BOG_RESIN_BRICKS_STAIRS);
        add(ModBlocks.BOG_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.BOG_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.BOG_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.BOG_RESIN_BLOCK);
        dropSelf(ModBlocks.BOG_RESIN_BLOCK_STAIRS);
        add(ModBlocks.BOG_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.BOG_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.BOG_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_BOG_RESIN_BRICKS);
        dropSelf(ModBlocks.BOG_RESIN_CLUMP);

        dropSelf(ModBlocks.SCULK_POLISHED_RESIN);
        dropSelf(ModBlocks.SCULK_POLISHED_RESIN_STAIRS);
        add(ModBlocks.SCULK_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.SCULK_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.SCULK_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.SCULK_RESIN_BRICKS);
        dropSelf(ModBlocks.SCULK_RESIN_BRICKS_STAIRS);
        add(ModBlocks.SCULK_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.SCULK_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.SCULK_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.SCULK_RESIN_BLOCK);
        dropSelf(ModBlocks.SCULK_RESIN_BLOCK_STAIRS);
        add(ModBlocks.SCULK_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.SCULK_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.SCULK_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_SCULK_RESIN_BRICKS);
        dropSelf(ModBlocks.SCULK_RESIN_CLUMP);

        dropSelf(ModBlocks.RETRO_POLISHED_RESIN);
        dropSelf(ModBlocks.RETRO_POLISHED_RESIN_STAIRS);
        add(ModBlocks.RETRO_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.RETRO_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.RETRO_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.RETRO_RESIN_BRICKS);
        dropSelf(ModBlocks.RETRO_RESIN_BRICKS_STAIRS);
        add(ModBlocks.RETRO_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.RETRO_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.RETRO_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.RETRO_RESIN_BLOCK);
        dropSelf(ModBlocks.RETRO_RESIN_BLOCK_STAIRS);
        add(ModBlocks.RETRO_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.RETRO_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.RETRO_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_RETRO_RESIN_BRICKS);
        dropSelf(ModBlocks.RETRO_RESIN_CLUMP);

        dropSelf(ModBlocks.DUST_POLISHED_RESIN);
        dropSelf(ModBlocks.DUST_POLISHED_RESIN_STAIRS);
        add(ModBlocks.DUST_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.DUST_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.DUST_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.DUST_RESIN_BRICKS);
        dropSelf(ModBlocks.DUST_RESIN_BRICKS_STAIRS);
        add(ModBlocks.DUST_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.DUST_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.DUST_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.DUST_RESIN_BLOCK);
        dropSelf(ModBlocks.DUST_RESIN_BLOCK_STAIRS);
        add(ModBlocks.DUST_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.DUST_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.DUST_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_DUST_RESIN_BRICKS);
        dropSelf(ModBlocks.DUST_RESIN_CLUMP);

        dropSelf(ModBlocks.BLOOD_POLISHED_RESIN);
        dropSelf(ModBlocks.BLOOD_POLISHED_RESIN_STAIRS);
        add(ModBlocks.BLOOD_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.BLOOD_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.BLOOD_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.BLOOD_RESIN_BRICKS);
        dropSelf(ModBlocks.BLOOD_RESIN_BRICKS_STAIRS);
        add(ModBlocks.BLOOD_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.BLOOD_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.BLOOD_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.BLOOD_RESIN_BLOCK);
        dropSelf(ModBlocks.BLOOD_RESIN_BLOCK_STAIRS);
        add(ModBlocks.BLOOD_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.BLOOD_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.BLOOD_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_BLOOD_RESIN_BRICKS);
        dropSelf(ModBlocks.BLOOD_RESIN_CLUMP);

        dropSelf(ModBlocks.RUBY_POLISHED_RESIN);
        dropSelf(ModBlocks.RUBY_POLISHED_RESIN_STAIRS);
        add(ModBlocks.RUBY_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.RUBY_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.RUBY_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.RUBY_RESIN_BRICKS);
        dropSelf(ModBlocks.RUBY_RESIN_BRICKS_STAIRS);
        add(ModBlocks.RUBY_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.RUBY_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.RUBY_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.RUBY_RESIN_BLOCK);
        dropSelf(ModBlocks.RUBY_RESIN_BLOCK_STAIRS);
        add(ModBlocks.RUBY_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.RUBY_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.RUBY_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_RUBY_RESIN_BRICKS);
        dropSelf(ModBlocks.RUBY_RESIN_CLUMP);

        dropSelf(ModBlocks.PEARL_POLISHED_RESIN);
        dropSelf(ModBlocks.PEARL_POLISHED_RESIN_STAIRS);
        add(ModBlocks.PEARL_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.PEARL_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.PEARL_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.PEARL_RESIN_BRICKS);
        dropSelf(ModBlocks.PEARL_RESIN_BRICKS_STAIRS);
        add(ModBlocks.PEARL_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.PEARL_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.PEARL_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.PEARL_RESIN_BLOCK);
        dropSelf(ModBlocks.PEARL_RESIN_BLOCK_STAIRS);
        add(ModBlocks.PEARL_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.PEARL_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.PEARL_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_PEARL_RESIN_BRICKS);
        dropSelf(ModBlocks.PEARL_RESIN_CLUMP);

        dropSelf(ModBlocks.SNOWY_POLISHED_RESIN);
        dropSelf(ModBlocks.SNOWY_POLISHED_RESIN_STAIRS);
        add(ModBlocks.SNOWY_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.SNOWY_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.SNOWY_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.SNOWY_RESIN_BRICKS);
        dropSelf(ModBlocks.SNOWY_RESIN_BRICKS_STAIRS);
        add(ModBlocks.SNOWY_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.SNOWY_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.SNOWY_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.SNOWY_RESIN_BLOCK);
        dropSelf(ModBlocks.SNOWY_RESIN_BLOCK_STAIRS);
        add(ModBlocks.SNOWY_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.SNOWY_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.SNOWY_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_SNOWY_RESIN_BRICKS);
        dropSelf(ModBlocks.SNOWY_RESIN_CLUMP);

        dropSelf(ModBlocks.SUBZERO_POLISHED_RESIN);
        dropSelf(ModBlocks.SUBZERO_POLISHED_RESIN_STAIRS);
        add(ModBlocks.SUBZERO_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.SUBZERO_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.SUBZERO_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.SUBZERO_RESIN_BRICKS);
        dropSelf(ModBlocks.SUBZERO_RESIN_BRICKS_STAIRS);
        add(ModBlocks.SUBZERO_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.SUBZERO_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.SUBZERO_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.SUBZERO_RESIN_BLOCK);
        dropSelf(ModBlocks.SUBZERO_RESIN_BLOCK_STAIRS);
        add(ModBlocks.SUBZERO_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.SUBZERO_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.SUBZERO_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_SUBZERO_RESIN_BRICKS);
        dropSelf(ModBlocks.SUBZERO_RESIN_CLUMP);

        dropSelf(ModBlocks.GEM_POLISHED_RESIN);
        dropSelf(ModBlocks.GEM_POLISHED_RESIN_STAIRS);
        add(ModBlocks.GEM_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.GEM_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.GEM_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.GEM_RESIN_BRICKS);
        dropSelf(ModBlocks.GEM_RESIN_BRICKS_STAIRS);
        add(ModBlocks.GEM_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.GEM_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.GEM_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.GEM_RESIN_BLOCK);
        dropSelf(ModBlocks.GEM_RESIN_BLOCK_STAIRS);
        add(ModBlocks.GEM_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.GEM_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.GEM_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_GEM_RESIN_BRICKS);
        dropSelf(ModBlocks.GEM_RESIN_CLUMP);

        dropSelf(ModBlocks.ROTTEN_POLISHED_RESIN);
        dropSelf(ModBlocks.ROTTEN_POLISHED_RESIN_STAIRS);
        add(ModBlocks.ROTTEN_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.ROTTEN_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.ROTTEN_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.ROTTEN_RESIN_BRICKS);
        dropSelf(ModBlocks.ROTTEN_RESIN_BRICKS_STAIRS);
        add(ModBlocks.ROTTEN_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.ROTTEN_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.ROTTEN_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.ROTTEN_RESIN_BLOCK);
        dropSelf(ModBlocks.ROTTEN_RESIN_BLOCK_STAIRS);
        add(ModBlocks.ROTTEN_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.ROTTEN_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.ROTTEN_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_ROTTEN_RESIN_BRICKS);
        dropSelf(ModBlocks.ROTTEN_RESIN_CLUMP);

        dropSelf(ModBlocks.GRAPE_POLISHED_RESIN);
        dropSelf(ModBlocks.GRAPE_POLISHED_RESIN_STAIRS);
        add(ModBlocks.GRAPE_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.GRAPE_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.GRAPE_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.GRAPE_RESIN_BRICKS);
        dropSelf(ModBlocks.GRAPE_RESIN_BRICKS_STAIRS);
        add(ModBlocks.GRAPE_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.GRAPE_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.GRAPE_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.GRAPE_RESIN_BLOCK);
        dropSelf(ModBlocks.GRAPE_RESIN_BLOCK_STAIRS);
        add(ModBlocks.GRAPE_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.GRAPE_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.GRAPE_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_GRAPE_RESIN_BRICKS);
        dropSelf(ModBlocks.GRAPE_RESIN_CLUMP);

        dropSelf(ModBlocks.REDSTONE_POLISHED_RESIN);
        dropSelf(ModBlocks.REDSTONE_POLISHED_RESIN_STAIRS);
        add(ModBlocks.REDSTONE_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.REDSTONE_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.REDSTONE_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.REDSTONE_RESIN_BRICKS);
        dropSelf(ModBlocks.REDSTONE_RESIN_BRICKS_STAIRS);
        add(ModBlocks.REDSTONE_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.REDSTONE_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.REDSTONE_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.REDSTONE_RESIN_BLOCK);
        dropSelf(ModBlocks.REDSTONE_RESIN_BLOCK_STAIRS);
        add(ModBlocks.REDSTONE_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.REDSTONE_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.REDSTONE_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_REDSTONE_RESIN_BRICKS);
        dropSelf(ModBlocks.REDSTONE_RESIN_CLUMP);

        dropSelf(ModBlocks.COPPER_POLISHED_RESIN);
        dropSelf(ModBlocks.COPPER_POLISHED_RESIN_STAIRS);
        add(ModBlocks.COPPER_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.COPPER_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.COPPER_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.COPPER_RESIN_BRICKS);
        dropSelf(ModBlocks.COPPER_RESIN_BRICKS_STAIRS);
        add(ModBlocks.COPPER_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.COPPER_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.COPPER_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.COPPER_RESIN_BLOCK);
        dropSelf(ModBlocks.COPPER_RESIN_BLOCK_STAIRS);
        add(ModBlocks.COPPER_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.COPPER_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.COPPER_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_COPPER_RESIN_BRICKS);
        dropSelf(ModBlocks.COPPER_RESIN_CLUMP);

        dropSelf(ModBlocks.SWEETBERRY_POLISHED_RESIN);
        dropSelf(ModBlocks.SWEETBERRY_POLISHED_RESIN_STAIRS);
        add(ModBlocks.SWEETBERRY_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.SWEETBERRY_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.SWEETBERRY_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.SWEETBERRY_RESIN_BRICKS);
        dropSelf(ModBlocks.SWEETBERRY_RESIN_BRICKS_STAIRS);
        add(ModBlocks.SWEETBERRY_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.SWEETBERRY_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.SWEETBERRY_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.SWEETBERRY_RESIN_BLOCK);
        dropSelf(ModBlocks.SWEETBERRY_RESIN_BLOCK_STAIRS);
        add(ModBlocks.SWEETBERRY_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.SWEETBERRY_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.SWEETBERRY_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_SWEETBERRY_RESIN_BRICKS);
        dropSelf(ModBlocks.SWEETBERRY_RESIN_CLUMP);

        dropSelf(ModBlocks.KELP_POLISHED_RESIN);
        dropSelf(ModBlocks.KELP_POLISHED_RESIN_STAIRS);
        add(ModBlocks.KELP_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.KELP_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.KELP_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.KELP_RESIN_BRICKS);
        dropSelf(ModBlocks.KELP_RESIN_BRICKS_STAIRS);
        add(ModBlocks.KELP_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.KELP_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.KELP_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.KELP_RESIN_BLOCK);
        dropSelf(ModBlocks.KELP_RESIN_BLOCK_STAIRS);
        add(ModBlocks.KELP_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.KELP_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.KELP_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_KELP_RESIN_BRICKS);
        dropSelf(ModBlocks.KELP_RESIN_CLUMP);

        dropSelf(ModBlocks.GLITTER_POLISHED_RESIN);
        dropSelf(ModBlocks.GLITTER_POLISHED_RESIN_STAIRS);
        add(ModBlocks.GLITTER_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.GLITTER_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.GLITTER_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.GLITTER_RESIN_BRICKS);
        dropSelf(ModBlocks.GLITTER_RESIN_BRICKS_STAIRS);
        add(ModBlocks.GLITTER_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.GLITTER_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.GLITTER_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.GLITTER_RESIN_BLOCK);
        dropSelf(ModBlocks.GLITTER_RESIN_BLOCK_STAIRS);
        add(ModBlocks.GLITTER_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.GLITTER_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.GLITTER_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_GLITTER_RESIN_BRICKS);
        dropSelf(ModBlocks.GLITTER_RESIN_CLUMP);

        dropSelf(ModBlocks.BLAZE_POLISHED_RESIN);
        dropSelf(ModBlocks.BLAZE_POLISHED_RESIN_STAIRS);
        add(ModBlocks.BLAZE_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.BLAZE_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.BLAZE_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.BLAZE_RESIN_BRICKS);
        dropSelf(ModBlocks.BLAZE_RESIN_BRICKS_STAIRS);
        add(ModBlocks.BLAZE_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.BLAZE_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.BLAZE_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.BLAZE_RESIN_BLOCK);
        dropSelf(ModBlocks.BLAZE_RESIN_BLOCK_STAIRS);
        add(ModBlocks.BLAZE_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.BLAZE_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.BLAZE_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_BLAZE_RESIN_BRICKS);
        dropSelf(ModBlocks.BLAZE_RESIN_CLUMP);

        dropSelf(ModBlocks.ZAP_POLISHED_RESIN);
        dropSelf(ModBlocks.ZAP_POLISHED_RESIN_STAIRS);
        add(ModBlocks.ZAP_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.ZAP_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.ZAP_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.ZAP_RESIN_BRICKS);
        dropSelf(ModBlocks.ZAP_RESIN_BRICKS_STAIRS);
        add(ModBlocks.ZAP_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.ZAP_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.ZAP_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.ZAP_RESIN_BLOCK);
        dropSelf(ModBlocks.ZAP_RESIN_BLOCK_STAIRS);
        add(ModBlocks.ZAP_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.ZAP_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.ZAP_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_ZAP_RESIN_BRICKS);
        dropSelf(ModBlocks.ZAP_RESIN_CLUMP);

        dropSelf(ModBlocks.NIGHTWAY_POLISHED_RESIN);
        dropSelf(ModBlocks.NIGHTWAY_POLISHED_RESIN_STAIRS);
        add(ModBlocks.NIGHTWAY_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.NIGHTWAY_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.NIGHTWAY_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.NIGHTWAY_RESIN_BRICKS);
        dropSelf(ModBlocks.NIGHTWAY_RESIN_BRICKS_STAIRS);
        add(ModBlocks.NIGHTWAY_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.NIGHTWAY_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.NIGHTWAY_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.NIGHTWAY_RESIN_BLOCK);
        dropSelf(ModBlocks.NIGHTWAY_RESIN_BLOCK_STAIRS);
        add(ModBlocks.NIGHTWAY_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.NIGHTWAY_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.NIGHTWAY_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_NIGHTWAY_RESIN_BRICKS);
        dropSelf(ModBlocks.NIGHTWAY_RESIN_CLUMP);

        dropSelf(ModBlocks.RIPE_POLISHED_RESIN);
        dropSelf(ModBlocks.RIPE_POLISHED_RESIN_STAIRS);
        add(ModBlocks.RIPE_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.RIPE_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.RIPE_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.RIPE_RESIN_BRICKS);
        dropSelf(ModBlocks.RIPE_RESIN_BRICKS_STAIRS);
        add(ModBlocks.RIPE_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.RIPE_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.RIPE_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.RIPE_RESIN_BLOCK);
        dropSelf(ModBlocks.RIPE_RESIN_BLOCK_STAIRS);
        add(ModBlocks.RIPE_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.RIPE_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.RIPE_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_RIPE_RESIN_BRICKS);
        dropSelf(ModBlocks.RIPE_RESIN_CLUMP);

        dropSelf(ModBlocks.SLUDGE_POLISHED_RESIN);
        dropSelf(ModBlocks.SLUDGE_POLISHED_RESIN_STAIRS);
        add(ModBlocks.SLUDGE_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.SLUDGE_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.SLUDGE_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.SLUDGE_RESIN_BRICKS);
        dropSelf(ModBlocks.SLUDGE_RESIN_BRICKS_STAIRS);
        add(ModBlocks.SLUDGE_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.SLUDGE_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.SLUDGE_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.SLUDGE_RESIN_BLOCK);
        dropSelf(ModBlocks.SLUDGE_RESIN_BLOCK_STAIRS);
        add(ModBlocks.SLUDGE_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.SLUDGE_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.SLUDGE_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_SLUDGE_RESIN_BRICKS);
        dropSelf(ModBlocks.SLUDGE_RESIN_CLUMP);

        dropSelf(ModBlocks.ARMADILLO_POLISHED_RESIN);
        dropSelf(ModBlocks.ARMADILLO_POLISHED_RESIN_STAIRS);
        add(ModBlocks.ARMADILLO_POLISHED_RESIN_SLAB, createSlabItemTable(ModBlocks.ARMADILLO_POLISHED_RESIN_SLAB));
        dropSelf(ModBlocks.ARMADILLO_POLISHED_RESIN_WALL);
        dropSelf(ModBlocks.ARMADILLO_RESIN_BRICKS);
        dropSelf(ModBlocks.ARMADILLO_RESIN_BRICKS_STAIRS);
        add(ModBlocks.ARMADILLO_RESIN_BRICKS_SLAB, createSlabItemTable(ModBlocks.ARMADILLO_RESIN_BRICKS_SLAB));
        dropSelf(ModBlocks.ARMADILLO_RESIN_BRICKS_WALL);
        dropSelf(ModBlocks.ARMADILLO_RESIN_BLOCK);
        dropSelf(ModBlocks.ARMADILLO_RESIN_BLOCK_STAIRS);
        add(ModBlocks.ARMADILLO_RESIN_BLOCK_SLAB, createSlabItemTable(ModBlocks.ARMADILLO_RESIN_BLOCK_SLAB));
        dropSelf(ModBlocks.ARMADILLO_RESIN_BLOCK_WALL);
        dropSelf(ModBlocks.CHISELED_ARMADILLO_RESIN_BRICKS);
        dropSelf(ModBlocks.ARMADILLO_RESIN_CLUMP);
    }
}
