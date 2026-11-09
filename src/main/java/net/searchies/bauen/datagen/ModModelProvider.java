package net.searchies.bauen.datagen;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MultifaceBlock;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.ModelVariantOperator;
import net.minecraft.client.render.model.json.MultipartModelConditionBuilder;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.WeightedPool;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModItems;

import java.util.Map;
import java.util.function.BiConsumer;

import static net.minecraft.client.data.BlockStateModelGenerator.createWeightedVariant;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_BRICKS)
                .stairs(ModBlocks.MOSSY_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_BRICKS)
                .stairs(ModBlocks.CRACKED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHISELED_BRICKS)
                .stairs(ModBlocks.CHISELED_BRICKS_STAIRS)
                .slab(ModBlocks.CHISELED_BRICKS_SLAB)
                .wall(ModBlocks.CHISELED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_CHISELED_BRICKS)
                .stairs(ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_CHISELED_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_CHISELED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_CHISELED_BRICKS)
                .stairs(ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_CHISELED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_CHISELED_BRICKS_WALL);

        blockStateModelGenerator.registerAxisRotated(ModBlocks.GOLD_CHAIN, createWeightedVariant(TexturedModel.TEMPLATE_CHAIN.upload(ModBlocks.GOLD_CHAIN, blockStateModelGenerator.modelCollector)));
        blockStateModelGenerator.registerBars(ModBlocks.GOLD_BARS);
        blockStateModelGenerator.registerLantern(ModBlocks.GOLD_LANTERN);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_GOLD)
                .stairs(ModBlocks.CUT_GOLD_STAIRS)
                .slab(ModBlocks.CUT_GOLD_SLAB)
                .wall(ModBlocks.CUT_GOLD_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GOLD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_GRATE);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.GOLD_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.GOLD_DOOR);
        blockStateModelGenerator.registerLeafLitter(ModBlocks.GOLD_COINS);
        registerGoldHoards(blockStateModelGenerator);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MIXED_COBBLESTONE)
                .stairs(ModBlocks.MIXED_COBBLESTONE_STAIRS)
                .slab(ModBlocks.MIXED_COBBLESTONE_SLAB)
                .wall(ModBlocks.MIXED_COBBLESTONE_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.INDUSTRIAL_IRON_BLOCK)
                .stairs(ModBlocks.INDUSTRIAL_IRON_STAIRS)
                .slab(ModBlocks.INDUSTRIAL_IRON_SLAB)
                .wall(ModBlocks.INDUSTRIAL_IRON_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CUT_INDUSTRIAL_IRON)
                .stairs(ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS)
                .slab(ModBlocks.CUT_INDUSTRIAL_IRON_SLAB)
                .wall(ModBlocks.CUT_INDUSTRIAL_IRON_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARVED_INDUSTRIAL_IRON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INDUSTRIAL_IRON_GRATE);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.INDUSTRIAL_IRON_DOOR);

        blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.ICE)
                .stairs(ModBlocks.ICE_STAIRS)
                .slab(ModBlocks.ICE_SLAB)
                .wall(ModBlocks.ICE_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.PACKED_ICE)
                .stairs(ModBlocks.PACKED_ICE_STAIRS)
                .slab(ModBlocks.PACKED_ICE_SLAB)
                .wall(ModBlocks.PACKED_ICE_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.MUD)
                .stairs(ModBlocks.MUD_STAIRS)
                .slab(ModBlocks.MUD_SLAB)
                .wall(ModBlocks.MUD_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_PACKED_MUD)
                .stairs(ModBlocks.MOSSY_PACKED_MUD_STAIRS)
                .slab(ModBlocks.MOSSY_PACKED_MUD_SLAB)
                .wall(ModBlocks.MOSSY_PACKED_MUD_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_MUD_BRICKS)
                .stairs(ModBlocks.MOSSY_MUD_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_MUD_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_MUD_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_TUFF_BRICKS)
                .stairs(ModBlocks.MOSSY_TUFF_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_TUFF_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_TUFF_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_TUFF_BRICKS)
                .stairs(ModBlocks.CRACKED_TUFF_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_TUFF_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_TUFF_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SCULKED_DEEPSLATE_BRICKS)
                .stairs(ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS)
                .slab(ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB)
                .wall(ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MIDNIGHT_BRICKS)
                .stairs(ModBlocks.MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHISELED_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KAOLIN_CLAY);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TREATED_BRICKS)
                .stairs(ModBlocks.TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.TREATED_BRICKS_SLAB)
                .wall(ModBlocks.TREATED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_TREATED_BRICKS)
                .stairs(ModBlocks.MOSSY_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_TREATED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_TREATED_BRICKS)
                .stairs(ModBlocks.CRACKED_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_TREATED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHISELED_TREATED_BRICKS)
                .stairs(ModBlocks.CHISELED_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.CHISELED_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.CHISELED_TREATED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS)
                .stairs(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS)
                .stairs(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MIXED_BRICKS)
                .stairs(ModBlocks.MIXED_BRICKS_STAIRS)
                .slab(ModBlocks.MIXED_BRICKS_SLAB)
                .wall(ModBlocks.MIXED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_MIXED_BRICKS)
                .stairs(ModBlocks.MOSSY_MIXED_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_MIXED_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_MIXED_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_MIXED_BRICKS)
                .stairs(ModBlocks.CRACKED_MIXED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_MIXED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_MIXED_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_CALCITE)
                .stairs(ModBlocks.POLISHED_CALCITE_STAIRS)
                .slab(ModBlocks.POLISHED_CALCITE_SLAB)
                .wall(ModBlocks.POLISHED_CALCITE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CALCITE_BRICKS)
                .stairs(ModBlocks.CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.CALCITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_CALCITE_BRICKS)
                .stairs(ModBlocks.POLISHED_CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_CALCITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_CALCITE_BRICKS)
                .stairs(ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_CALCITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_CALCITE_BRICKS)
                .stairs(ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_CALCITE_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ANDESITE_BRICKS)
                .stairs(ModBlocks.ANDESITE_BRICKS_STAIRS)
                .slab(ModBlocks.ANDESITE_BRICKS_SLAB)
                .wall(ModBlocks.ANDESITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_ANDESITE_BRICKS)
                .stairs(ModBlocks.POLISHED_ANDESITE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_ANDESITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_ANDESITE_BRICKS)
                .stairs(ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_ANDESITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_ANDESITE_BRICKS)
                .stairs(ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_ANDESITE_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DIORITE_BRICKS)
                .stairs(ModBlocks.DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.DIORITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_DIORITE_BRICKS)
                .stairs(ModBlocks.POLISHED_DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_DIORITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_DIORITE_BRICKS)
                .stairs(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_DIORITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_DIORITE_BRICKS)
                .stairs(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_DIORITE_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_DRIPSTONE)
                .stairs(ModBlocks.POLISHED_DRIPSTONE_STAIRS)
                .slab(ModBlocks.POLISHED_DRIPSTONE_SLAB)
                .wall(ModBlocks.POLISHED_DRIPSTONE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DRIPSTONE_BRICKS)
                .stairs(ModBlocks.DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.DRIPSTONE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_DRIPSTONE_BRICKS)
                .stairs(ModBlocks.POLISHED_DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_DRIPSTONE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_DRIPSTONE_BRICKS)
                .stairs(ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_DRIPSTONE_BRICKS)
                .stairs(ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRANITE_BRICKS)
                .stairs(ModBlocks.GRANITE_BRICKS_STAIRS)
                .slab(ModBlocks.GRANITE_BRICKS_SLAB)
                .wall(ModBlocks.GRANITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_GRANITE_BRICKS)
                .stairs(ModBlocks.POLISHED_GRANITE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_GRANITE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_GRANITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_GRANITE_BRICKS)
                .stairs(ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_GRANITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_GRANITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_GRANITE_BRICKS)
                .stairs(ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_GRANITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_GRANITE_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OCEANSLATE)
                .stairs(ModBlocks.OCEANSLATE_STAIRS)
                .slab(ModBlocks.OCEANSLATE_SLAB)
                .wall(ModBlocks.OCEANSLATE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OCEANSLATE_BRICKS)
                .stairs(ModBlocks.OCEANSLATE_BRICKS_STAIRS)
                .slab(ModBlocks.OCEANSLATE_BRICKS_SLAB)
                .wall(ModBlocks.OCEANSLATE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OCEANSLATE_TILES)
                .stairs(ModBlocks.OCEANSLATE_TILES_STAIRS)
                .slab(ModBlocks.OCEANSLATE_TILES_SLAB)
                .wall(ModBlocks.OCEANSLATE_TILES_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_OCEANSLATE)
                .stairs(ModBlocks.POLISHED_OCEANSLATE_STAIRS)
                .slab(ModBlocks.POLISHED_OCEANSLATE_SLAB)
                .wall(ModBlocks.POLISHED_OCEANSLATE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_OCEANSLATE_BRICKS)
                .stairs(ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KELPY_OCEANSLATE_BRICKS)
                .stairs(ModBlocks.KELPY_OCEANSLATE_BRICKS_STAIRS)
                .slab(ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB)
                .wall(ModBlocks.KELPY_OCEANSLATE_BRICKS_WALL);

        registerSeat(ModBlocks.RED_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.ORANGE_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.YELLOW_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.LIME_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.GREEN_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.CYAN_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.LIGHT_BLUE_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.BLUE_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.PINK_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.MAGENTA_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.PURPLE_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.BROWN_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.LIGHT_GRAY_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.GRAY_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.BLACK_SEAT, blockStateModelGenerator);
        registerSeat(ModBlocks.WHITE_SEAT, blockStateModelGenerator);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_SEA_LANTERN);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_DARK_PRISMARINE)
            .stairs(ModBlocks.ABERRANT_DARK_PRISMARINE_STAIRS)
            .slab(ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB)
            .wall(ModBlocks.ABERRANT_DARK_PRISMARINE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_PRISMARINE)
            .stairs(ModBlocks.ABERRANT_PRISMARINE_STAIRS)
            .slab(ModBlocks.ABERRANT_PRISMARINE_SLAB)
            .wall(ModBlocks.ABERRANT_PRISMARINE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_PRISMARINE_BRICKS)
            .stairs(ModBlocks.ABERRANT_PRISMARINE_BRICKS_STAIRS)
            .slab(ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_OCEANSLATE)
            .stairs(ModBlocks.ABERRANT_OCEANSLATE_STAIRS)
            .slab(ModBlocks.ABERRANT_OCEANSLATE_SLAB)
            .wall(ModBlocks.ABERRANT_OCEANSLATE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_POLISHED_OCEANSLATE)
            .stairs(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_STAIRS)
            .slab(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB)
            .wall(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_OCEANSLATE_TILES)
            .stairs(ModBlocks.ABERRANT_OCEANSLATE_TILES_STAIRS)
            .slab(ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB)
            .wall(ModBlocks.ABERRANT_OCEANSLATE_TILES_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_OCEANSLATE_BRICKS)
            .stairs(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_STAIRS)
            .slab(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB)
            .wall(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS)
            .stairs(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_STAIRS)
            .slab(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_SLAB)
            .wall(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS)
            .stairs(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_STAIRS)
            .slab(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB)
            .wall(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_WALL);

        registerSandstone(ModBlocks.SOUL_SANDSTONE, blockStateModelGenerator, SOUL_SANDSTONE_MODELS)
            .stairs(ModBlocks.SOUL_SANDSTONE_STAIRS)
            .slab(ModBlocks.SOUL_SANDSTONE_SLAB)
            .wall(ModBlocks.SOUL_SANDSTONE_WALL);
        registerSandstone(ModBlocks.SMOOTH_SOUL_SANDSTONE, blockStateModelGenerator, SOUL_SANDSTONE_MODELS)
            .stairs(ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS)
            .slab(ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB)
            .wall(ModBlocks.SMOOTH_SOUL_SANDSTONE_WALL);
        registerSandstone(ModBlocks.CUT_SOUL_SANDSTONE, blockStateModelGenerator, SOUL_SANDSTONE_MODELS);
        registerSandstone(ModBlocks.CHISELED_SOUL_SANDSTONE, blockStateModelGenerator, SOUL_SANDSTONE_MODELS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_TERRACOTTA);

        registerSeat(ModBlocks.ABERRANT_RED_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_RED_CONCRETE)
            .stairs(ModBlocks.ABERRANT_RED_CONCRETE_STAIRS)
            .slab(ModBlocks.ABERRANT_RED_CONCRETE_SLAB)
            .wall(ModBlocks.ABERRANT_RED_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_RED_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_RED_TERRACOTTA)
            .stairs(ModBlocks.ABERRANT_RED_TERRACOTTA_STAIRS)
            .slab(ModBlocks.ABERRANT_RED_TERRACOTTA_SLAB)
            .wall(ModBlocks.ABERRANT_RED_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_ORANGE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_ORANGE_CONCRETE)
            .stairs(ModBlocks.ABERRANT_ORANGE_CONCRETE_STAIRS)
            .slab(ModBlocks.ABERRANT_ORANGE_CONCRETE_SLAB)
            .wall(ModBlocks.ABERRANT_ORANGE_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_ORANGE_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_ORANGE_TERRACOTTA)
            .stairs(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_STAIRS)
            .slab(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_SLAB)
            .wall(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_YELLOW_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_YELLOW_CONCRETE)
            .stairs(ModBlocks.ABERRANT_YELLOW_CONCRETE_STAIRS)
            .slab(ModBlocks.ABERRANT_YELLOW_CONCRETE_SLAB)
            .wall(ModBlocks.ABERRANT_YELLOW_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_YELLOW_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_YELLOW_TERRACOTTA)
            .stairs(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_STAIRS)
            .slab(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_SLAB)
            .wall(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_LIME_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_LIME_CONCRETE)
                .stairs(ModBlocks.ABERRANT_LIME_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_LIME_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_LIME_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_LIME_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_LIME_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_LIME_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_LIME_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_LIME_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_GREEN_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_GREEN_CONCRETE)
                .stairs(ModBlocks.ABERRANT_GREEN_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_GREEN_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_GREEN_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_GREEN_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_GREEN_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_GREEN_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_GREEN_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_GREEN_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_CYAN_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_CYAN_CONCRETE)
                .stairs(ModBlocks.ABERRANT_CYAN_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_CYAN_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_CYAN_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_CYAN_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_CYAN_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_CYAN_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_CYAN_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_CYAN_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_LIGHT_BLUE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE)
                .stairs(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_BLUE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_BLUE_CONCRETE)
                .stairs(ModBlocks.ABERRANT_BLUE_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_BLUE_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_BLUE_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_BLUE_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_BLUE_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_BLUE_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_BLUE_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_BLUE_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_PINK_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_PINK_CONCRETE)
                .stairs(ModBlocks.ABERRANT_PINK_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_PINK_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_PINK_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_PINK_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_PINK_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_PINK_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_PINK_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_PINK_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_MAGENTA_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_MAGENTA_CONCRETE)
                .stairs(ModBlocks.ABERRANT_MAGENTA_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_MAGENTA_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_MAGENTA_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_MAGENTA_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_PURPLE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_PURPLE_CONCRETE)
                .stairs(ModBlocks.ABERRANT_PURPLE_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_PURPLE_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_PURPLE_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_PURPLE_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_PURPLE_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_BROWN_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_BROWN_CONCRETE)
                .stairs(ModBlocks.ABERRANT_BROWN_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_BROWN_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_BROWN_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_BROWN_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_BROWN_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_BROWN_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_BROWN_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_BROWN_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_BLACK_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_BLACK_CONCRETE)
                .stairs(ModBlocks.ABERRANT_BLACK_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_BLACK_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_BLACK_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_BLACK_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_BLACK_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_BLACK_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_BLACK_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_BLACK_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_GRAY_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_GRAY_CONCRETE)
                .stairs(ModBlocks.ABERRANT_GRAY_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_GRAY_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_GRAY_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_GRAY_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_GRAY_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_GRAY_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_GRAY_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_GRAY_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_LIGHT_GRAY_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE)
                .stairs(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_WHITE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_WHITE_CONCRETE)
                .stairs(ModBlocks.ABERRANT_WHITE_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_WHITE_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_WHITE_CONCRETE_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_WHITE_CONCRETE_POWER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_WHITE_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_WHITE_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_WHITE_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_WHITE_TERRACOTTA_WALL);

        blockStateModelGenerator.registerSouthDefaultHorizontalFacing(TexturedModel.TEMPLATE_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_WHITE_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_ORANGE_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_MAGENTA_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_LIGHT_BLUE_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_YELLOW_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_LIME_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_PINK_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_GRAY_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_LIGHT_GRAY_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_CYAN_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_PURPLE_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_BLUE_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_BROWN_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_GREEN_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_RED_GLAZED_TERRACOTTA,
                ModBlocks.ABERRANT_BLACK_GLAZED_TERRACOTTA);

        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_RED_WOOL, ModBlocks.ABERRANT_RED_CARPET, ModBlocks.ABERRANT_RED_WOOL_STAIRS, ModBlocks.ABERRANT_RED_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_ORANGE_WOOL, ModBlocks.ABERRANT_ORANGE_CARPET, ModBlocks.ABERRANT_ORANGE_WOOL_STAIRS, ModBlocks.ABERRANT_ORANGE_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_YELLOW_WOOL, ModBlocks.ABERRANT_YELLOW_CARPET, ModBlocks.ABERRANT_YELLOW_WOOL_STAIRS, ModBlocks.ABERRANT_YELLOW_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_LIME_WOOL, ModBlocks.ABERRANT_LIME_CARPET, ModBlocks.ABERRANT_LIME_WOOL_STAIRS, ModBlocks.ABERRANT_LIME_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_GREEN_WOOL, ModBlocks.ABERRANT_GREEN_CARPET, ModBlocks.ABERRANT_GREEN_WOOL_STAIRS, ModBlocks.ABERRANT_GREEN_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_CYAN_WOOL, ModBlocks.ABERRANT_CYAN_CARPET, ModBlocks.ABERRANT_CYAN_WOOL_STAIRS, ModBlocks.ABERRANT_CYAN_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_LIGHT_BLUE_WOOL, ModBlocks.ABERRANT_LIGHT_BLUE_CARPET, ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_STAIRS, ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_BLUE_WOOL, ModBlocks.ABERRANT_BLUE_CARPET, ModBlocks.ABERRANT_BLUE_WOOL_STAIRS, ModBlocks.ABERRANT_BLUE_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_PINK_WOOL, ModBlocks.ABERRANT_PINK_CARPET, ModBlocks.ABERRANT_PINK_WOOL_STAIRS, ModBlocks.ABERRANT_PINK_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_MAGENTA_WOOL, ModBlocks.ABERRANT_MAGENTA_CARPET, ModBlocks.ABERRANT_MAGENTA_WOOL_STAIRS, ModBlocks.ABERRANT_MAGENTA_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_PURPLE_WOOL, ModBlocks.ABERRANT_PURPLE_CARPET, ModBlocks.ABERRANT_PURPLE_WOOL_STAIRS, ModBlocks.ABERRANT_PURPLE_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_BROWN_WOOL, ModBlocks.ABERRANT_BROWN_CARPET, ModBlocks.ABERRANT_BROWN_WOOL_STAIRS, ModBlocks.ABERRANT_BROWN_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_BLACK_WOOL, ModBlocks.ABERRANT_BLACK_CARPET, ModBlocks.ABERRANT_BLACK_WOOL_STAIRS, ModBlocks.ABERRANT_BLACK_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_GRAY_WOOL, ModBlocks.ABERRANT_GRAY_CARPET, ModBlocks.ABERRANT_GRAY_WOOL_STAIRS, ModBlocks.ABERRANT_GRAY_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_LIGHT_GRAY_WOOL, ModBlocks.ABERRANT_LIGHT_GRAY_CARPET, ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_STAIRS, ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_SLAB);
        registerCustomWoolAndCarpet(blockStateModelGenerator, ModBlocks.ABERRANT_WHITE_WOOL, ModBlocks.ABERRANT_WHITE_CARPET, ModBlocks.ABERRANT_WHITE_WOOL_STAIRS, ModBlocks.ABERRANT_WHITE_WOOL_SLAB);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BEETROOT_RESIN_BRICKS)
                .stairs(ModBlocks.BEETROOT_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.BEETROOT_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.BEETROOT_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BEETROOT_RESIN_BLOCK)
                .stairs(ModBlocks.BEETROOT_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.BEETROOT_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.BEETROOT_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_BEETROOT_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.BEETROOT_RESIN_CLUMP, ModItems.BEETROOT_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHORUS_RESIN_BRICKS)
                .stairs(ModBlocks.CHORUS_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.CHORUS_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.CHORUS_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHORUS_RESIN_BLOCK)
                .stairs(ModBlocks.CHORUS_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.CHORUS_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.CHORUS_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_CHORUS_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.CHORUS_RESIN_CLUMP, ModItems.CHORUS_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LEMON_RESIN_BRICKS)
                .stairs(ModBlocks.LEMON_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.LEMON_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.LEMON_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LEMON_RESIN_BLOCK)
                .stairs(ModBlocks.LEMON_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.LEMON_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.LEMON_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_LEMON_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.LEMON_RESIN_CLUMP, ModItems.LEMON_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLACIER_RESIN_BRICKS)
                .stairs(ModBlocks.GLACIER_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.GLACIER_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.GLACIER_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLACIER_RESIN_BLOCK)
                .stairs(ModBlocks.GLACIER_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.GLACIER_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.GLACIER_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GLACIER_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.GLACIER_RESIN_CLUMP, ModItems.GLACIER_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CARAMEL_RESIN_BRICKS)
                .stairs(ModBlocks.CARAMEL_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.CARAMEL_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.CARAMEL_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CARAMEL_RESIN_BLOCK)
                .stairs(ModBlocks.CARAMEL_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.CARAMEL_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.CARAMEL_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_CARAMEL_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.CARAMEL_RESIN_CLUMP, ModItems.CARAMEL_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TOXIC_RESIN_BRICKS)
                .stairs(ModBlocks.TOXIC_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.TOXIC_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.TOXIC_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TOXIC_RESIN_BLOCK)
                .stairs(ModBlocks.TOXIC_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.TOXIC_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.TOXIC_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_TOXIC_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.TOXIC_RESIN_CLUMP, ModItems.TOXIC_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JADE_RESIN_BRICKS)
                .stairs(ModBlocks.JADE_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.JADE_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.JADE_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JADE_RESIN_BLOCK)
                .stairs(ModBlocks.JADE_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.JADE_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.JADE_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_JADE_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.JADE_RESIN_CLUMP, ModItems.JADE_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BUBBLE_RESIN_BRICKS)
                .stairs(ModBlocks.BUBBLE_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.BUBBLE_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.BUBBLE_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BUBBLE_RESIN_BLOCK)
                .stairs(ModBlocks.BUBBLE_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.BUBBLE_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.BUBBLE_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_BUBBLE_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.BUBBLE_RESIN_CLUMP, ModItems.BUBBLE_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OCEAN_RESIN_BRICKS)
                .stairs(ModBlocks.OCEAN_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.OCEAN_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.OCEAN_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OCEAN_RESIN_BLOCK)
                .stairs(ModBlocks.OCEAN_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.OCEAN_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.OCEAN_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_OCEAN_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.OCEAN_RESIN_CLUMP, ModItems.OCEAN_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EMERALD_RESIN_BRICKS)
                .stairs(ModBlocks.EMERALD_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.EMERALD_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.EMERALD_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EMERALD_RESIN_BLOCK)
                .stairs(ModBlocks.EMERALD_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.EMERALD_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.EMERALD_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_EMERALD_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.EMERALD_RESIN_CLUMP, ModItems.EMERALD_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUSK_RESIN_BRICKS)
                .stairs(ModBlocks.DUSK_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.DUSK_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.DUSK_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUSK_RESIN_BLOCK)
                .stairs(ModBlocks.DUSK_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.DUSK_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.DUSK_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_DUSK_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.DUSK_RESIN_CLUMP, ModItems.DUSK_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DAYBREAK_RESIN_BRICKS)
                .stairs(ModBlocks.DAYBREAK_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.DAYBREAK_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DAYBREAK_RESIN_BLOCK)
                .stairs(ModBlocks.DAYBREAK_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.DAYBREAK_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_DAYBREAK_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.DAYBREAK_RESIN_CLUMP, ModItems.DAYBREAK_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SILT_RESIN_BRICKS)
                .stairs(ModBlocks.SILT_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.SILT_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.SILT_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SILT_RESIN_BLOCK)
                .stairs(ModBlocks.SILT_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.SILT_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.SILT_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_SILT_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.SILT_RESIN_CLUMP, ModItems.SILT_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRAPHITE_RESIN_BRICKS)
                .stairs(ModBlocks.GRAPHITE_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.GRAPHITE_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRAPHITE_RESIN_BLOCK)
                .stairs(ModBlocks.GRAPHITE_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.GRAPHITE_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GRAPHITE_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.GRAPHITE_RESIN_CLUMP, ModItems.GRAPHITE_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OBSIDIAN_RESIN_BRICKS)
                .stairs(ModBlocks.OBSIDIAN_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.OBSIDIAN_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OBSIDIAN_RESIN_BLOCK)
                .stairs(ModBlocks.OBSIDIAN_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.OBSIDIAN_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_OBSIDIAN_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.OBSIDIAN_RESIN_CLUMP, ModItems.OBSIDIAN_RESIN_CLUMP);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COCOA_RESIN_BRICKS)
                .stairs(ModBlocks.COCOA_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.COCOA_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.COCOA_RESIN_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COCOA_RESIN_BLOCK)
                .stairs(ModBlocks.COCOA_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.COCOA_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.COCOA_RESIN_BLOCK_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_COCOA_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.COCOA_RESIN_CLUMP, ModItems.COCOA_RESIN_CLUMP);


        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.POLISHED_RESIN)
                .stairs(ModBlocks.POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.POLISHED_RESIN_SLAB)
                .wall(ModBlocks.POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BEETROOT_POLISHED_RESIN)
                .stairs(ModBlocks.BEETROOT_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.BEETROOT_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.BEETROOT_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CARAMEL_POLISHED_RESIN)
                .stairs(ModBlocks.CARAMEL_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.CARAMEL_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.CARAMEL_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.LEMON_POLISHED_RESIN)
                .stairs(ModBlocks.LEMON_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.LEMON_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.LEMON_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.TOXIC_POLISHED_RESIN)
                .stairs(ModBlocks.TOXIC_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.TOXIC_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.TOXIC_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EMERALD_POLISHED_RESIN)
                .stairs(ModBlocks.EMERALD_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.EMERALD_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.EMERALD_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.JADE_POLISHED_RESIN)
                .stairs(ModBlocks.JADE_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.JADE_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.JADE_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OCEAN_POLISHED_RESIN)
                .stairs(ModBlocks.OCEAN_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.OCEAN_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.OCEAN_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GLACIER_POLISHED_RESIN)
                .stairs(ModBlocks.GLACIER_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.GLACIER_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.GLACIER_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BUBBLE_POLISHED_RESIN)
                .stairs(ModBlocks.BUBBLE_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.BUBBLE_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.BUBBLE_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DUSK_POLISHED_RESIN)
                .stairs(ModBlocks.DUSK_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.DUSK_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.DUSK_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHORUS_POLISHED_RESIN)
                .stairs(ModBlocks.CHORUS_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.CHORUS_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.CHORUS_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DAYBREAK_POLISHED_RESIN)
                .stairs(ModBlocks.DAYBREAK_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.DAYBREAK_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.DAYBREAK_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SILT_POLISHED_RESIN)
                .stairs(ModBlocks.SILT_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.SILT_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.SILT_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.GRAPHITE_POLISHED_RESIN)
                .stairs(ModBlocks.GRAPHITE_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.GRAPHITE_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.GRAPHITE_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OBSIDIAN_POLISHED_RESIN)
                .stairs(ModBlocks.OBSIDIAN_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.OBSIDIAN_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.OBSIDIAN_POLISHED_RESIN_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.COCOA_POLISHED_RESIN)
                .stairs(ModBlocks.COCOA_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.COCOA_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.COCOA_POLISHED_RESIN_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AMETHYST_TILES)
                .stairs(ModBlocks.AMETHYST_TILES_STAIRS)
                .slab(ModBlocks.AMETHYST_TILES_SLAB)
                .wall(ModBlocks.AMETHYST_TILES_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.AMETHYST_BRICKS)
                .stairs(ModBlocks.AMETHYST_BRICKS_STAIRS)
                .slab(ModBlocks.AMETHYST_BRICKS_SLAB)
                .wall(ModBlocks.AMETHYST_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_AMETHYST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_ABERRANT_AMETHYST);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_ABERRANT_AMETHYST_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_ABERRANT_AMETHYST_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.ABERRANT_AMETHYST_CLUSTER);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_AMETHYST_TILES)
                .stairs(ModBlocks.ABERRANT_AMETHYST_TILES_STAIRS)
                .slab(ModBlocks.ABERRANT_AMETHYST_TILES_SLAB)
                .wall(ModBlocks.ABERRANT_AMETHYST_TILES_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_AMETHYST_BRICKS)
                .stairs(ModBlocks.ABERRANT_AMETHYST_BRICKS_STAIRS)
                .slab(ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB)
                .wall(ModBlocks.ABERRANT_AMETHYST_BRICKS_WALL);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_SOUL_SOIL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_SOUL_SAND);
        registerSandstone(ModBlocks.ABERRANT_SOUL_SANDSTONE, blockStateModelGenerator, ABERRANT_SOUL_SANDSTONE_MODELS)
                .stairs(ModBlocks.ABERRANT_SOUL_SANDSTONE_STAIRS)
                .slab(ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB)
                .wall(ModBlocks.ABERRANT_SOUL_SANDSTONE_WALL);
        registerSandstone(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE, blockStateModelGenerator, ABERRANT_SOUL_SANDSTONE_MODELS)
                .stairs(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_STAIRS)
                .slab(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB)
                .wall(ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_WALL);
        registerSandstone(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE, blockStateModelGenerator, ABERRANT_SOUL_SANDSTONE_MODELS);
        registerSandstone(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, blockStateModelGenerator, ABERRANT_SOUL_SANDSTONE_MODELS);

        registerPumpkins(blockStateModelGenerator);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_OBSIDIAN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_CRYING_OBSIDIAN);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_NETHERRACK);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_NETHER_BRICKS)
                .stairs(ModBlocks.ABERRANT_NETHER_BRICKS_STAIRS)
                .slab(ModBlocks.ABERRANT_NETHER_BRICKS_SLAB)
                .wall(ModBlocks.ABERRANT_NETHER_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS)
                .stairs(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS)
                .stairs(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_STAIRS)
                .slab(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB)
                .wall(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_RED_NETHER_BRICKS)
                .stairs(ModBlocks.ABERRANT_RED_NETHER_BRICKS_STAIRS)
                .slab(ModBlocks.ABERRANT_RED_NETHER_BRICKS_SLAB)
                .wall(ModBlocks.ABERRANT_RED_NETHER_BRICKS_WALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_GLOWSTONE);

        registerRedstoneLamp(blockStateModelGenerator, ModBlocks.ABERRANT_REDSTONE_LAMP);

        blockStateModelGenerator.registerAxisRotated(ModBlocks.ABERRANT_OCHRE_FROGLIGHT, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.ABERRANT_VERDANT_FROGLIGHT, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.ABERRANT_PEARLESCENT_FROGLIGHT, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(Blocks.NETHERITE_BLOCK)
                .fence(ModBlocks.NETHERITE_FENCE);

        // Custom Copper //

        ModBlocks.ABERRANT_COPPER_BARS.getWaxingMap().forEach(blockStateModelGenerator::registerCopperBars);
        ModBlocks.ABERRANT_COPPER_LANTERNS.getWaxingMap().forEach(blockStateModelGenerator::registerCopperLantern);
        ModBlocks.ABERRANT_COPPER_CHAINS.getWaxingMap().forEach((block, waxed) -> {
            blockStateModelGenerator.registerCopperChain(block, waxed);
            blockStateModelGenerator.registerWaxable(block.asItem(), waxed.asItem());
        });

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.ABERRANT_CUT_COPPER)
                .family(BlockFamilies.CUT_COPPER)
                .stairs(ModBlocks.ABERRANT_CUT_COPPER_STAIRS)
                .slab(ModBlocks.ABERRANT_CUT_COPPER_SLAB)
                .parented(ModBlocks.ABERRANT_CUT_COPPER, ModBlocks.WAXED_ABERRANT_CUT_COPPER)
                .parented(ModBlocks.ABERRANT_CUT_COPPER_STAIRS, ModBlocks.WAXED_ABERRANT_CUT_COPPER_STAIRS)
                .parented(ModBlocks.ABERRANT_CUT_COPPER_SLAB, ModBlocks.WAXED_ABERRANT_CUT_COPPER_SLAB)
                .family(BlockFamilies.WAXED_CUT_COPPER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER)
                .family(BlockFamilies.EXPOSED_CUT_COPPER)
                .stairs(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_STAIRS)
                .slab(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_SLAB)
                .parented(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER, ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER)
                .parented(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_STAIRS, ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER_STAIRS)
                .parented(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_SLAB, ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER_SLAB)
                .family(BlockFamilies.WAXED_EXPOSED_CUT_COPPER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER)
                .family(BlockFamilies.WEATHERED_CUT_COPPER)
                .stairs(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_STAIRS)
                .slab(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_SLAB)
                .parented(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER, ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER)
                .parented(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_STAIRS, ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER_STAIRS)
                .parented(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_SLAB, ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER_SLAB)
                .family(BlockFamilies.WAXED_WEATHERED_CUT_COPPER);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER)
                .family(BlockFamilies.OXIDIZED_CUT_COPPER)
                .stairs(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_STAIRS)
                .slab(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_SLAB)
                .parented(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER, ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER)
                .parented(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_STAIRS, ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER_STAIRS)
                .parented(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_SLAB, ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER_SLAB)
                .family(BlockFamilies.WAXED_OXIDIZED_CUT_COPPER);

        blockStateModelGenerator.registerCopperBulb(ModBlocks.ABERRANT_COPPER_BULB);
        blockStateModelGenerator.registerWaxedCopperBulb(ModBlocks.ABERRANT_COPPER_BULB, ModBlocks.WAXED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.registerCopperBulb(ModBlocks.EXPOSED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.registerWaxedCopperBulb(ModBlocks.EXPOSED_ABERRANT_COPPER_BULB, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.registerCopperBulb(ModBlocks.WEATHERED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.registerWaxedCopperBulb(ModBlocks.WEATHERED_ABERRANT_COPPER_BULB, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.registerCopperBulb(ModBlocks.OXIDIZED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.registerWaxedCopperBulb(ModBlocks.OXIDIZED_ABERRANT_COPPER_BULB, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_BULB);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_COPPER_BLOCK);
        blockStateModelGenerator.registerParented(ModBlocks.ABERRANT_COPPER_BLOCK, ModBlocks.WAXED_ABERRANT_COPPER_BLOCK);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.registerParented(ModBlocks.ABERRANT_CHISELED_COPPER, ModBlocks.WAXED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXPOSED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.registerParented(ModBlocks.EXPOSED_ABERRANT_CHISELED_COPPER, ModBlocks.WAXED_EXPOSED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WEATHERED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.registerParented(ModBlocks.WEATHERED_ABERRANT_CHISELED_COPPER, ModBlocks.WAXED_WEATHERED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OXIDIZED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.registerParented(ModBlocks.OXIDIZED_ABERRANT_CHISELED_COPPER, ModBlocks.WAXED_OXIDIZED_ABERRANT_CHISELED_COPPER);

        blockStateModelGenerator.registerDoor(ModBlocks.ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.registerParentedDoor(ModBlocks.ABERRANT_COPPER_DOOR, ModBlocks.WAXED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.EXPOSED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.registerParentedDoor(ModBlocks.EXPOSED_ABERRANT_COPPER_DOOR, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.WEATHERED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.registerParentedDoor(ModBlocks.WEATHERED_ABERRANT_COPPER_DOOR, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.OXIDIZED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.registerParentedDoor(ModBlocks.OXIDIZED_ABERRANT_COPPER_DOOR, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_DOOR);

        blockStateModelGenerator.registerTrapdoor(ModBlocks.ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerParentedTrapdoor(ModBlocks.ABERRANT_COPPER_TRAPDOOR, ModBlocks.WAXED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.EXPOSED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerParentedTrapdoor(ModBlocks.EXPOSED_ABERRANT_COPPER_TRAPDOOR, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.WEATHERED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerParentedTrapdoor(ModBlocks.WEATHERED_ABERRANT_COPPER_TRAPDOOR, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.OXIDIZED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.registerParentedTrapdoor(ModBlocks.OXIDIZED_ABERRANT_COPPER_TRAPDOOR, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_TRAPDOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.registerParented(ModBlocks.ABERRANT_COPPER_GRATE, ModBlocks.WAXED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.EXPOSED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.registerParented(ModBlocks.EXPOSED_ABERRANT_COPPER_GRATE, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.WEATHERED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.registerParented(ModBlocks.WEATHERED_ABERRANT_COPPER_GRATE, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OXIDIZED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.registerParented(ModBlocks.OXIDIZED_ABERRANT_COPPER_GRATE, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_GRATE);

        registerResin(blockStateModelGenerator, ModBlocks.BRASS_POLISHED_RESIN, ModBlocks.BRASS_POLISHED_RESIN_STAIRS, ModBlocks.BRASS_POLISHED_RESIN_SLAB, ModBlocks.BRASS_POLISHED_RESIN_WALL, ModBlocks.BRASS_RESIN_BRICKS, ModBlocks.BRASS_RESIN_BRICKS_STAIRS, ModBlocks.BRASS_RESIN_BRICKS_SLAB, ModBlocks.BRASS_RESIN_BRICKS_WALL, ModBlocks.BRASS_RESIN_BLOCK, ModBlocks.BRASS_RESIN_BLOCK_STAIRS, ModBlocks.BRASS_RESIN_BLOCK_SLAB, ModBlocks.BRASS_RESIN_BLOCK_WALL, ModBlocks.CHISELED_BRASS_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.BRASS_RESIN_CLUMP, ModItems.BRASS_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.DANDELION_POLISHED_RESIN, ModBlocks.DANDELION_POLISHED_RESIN_STAIRS, ModBlocks.DANDELION_POLISHED_RESIN_SLAB, ModBlocks.DANDELION_POLISHED_RESIN_WALL, ModBlocks.DANDELION_RESIN_BRICKS, ModBlocks.DANDELION_RESIN_BRICKS_STAIRS, ModBlocks.DANDELION_RESIN_BRICKS_SLAB, ModBlocks.DANDELION_RESIN_BRICKS_WALL, ModBlocks.DANDELION_RESIN_BLOCK, ModBlocks.DANDELION_RESIN_BLOCK_STAIRS, ModBlocks.DANDELION_RESIN_BLOCK_SLAB, ModBlocks.DANDELION_RESIN_BLOCK_WALL, ModBlocks.CHISELED_DANDELION_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.DANDELION_RESIN_CLUMP, ModItems.DANDELION_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.BOG_POLISHED_RESIN, ModBlocks.BOG_POLISHED_RESIN_STAIRS, ModBlocks.BOG_POLISHED_RESIN_SLAB, ModBlocks.BOG_POLISHED_RESIN_WALL, ModBlocks.BOG_RESIN_BRICKS, ModBlocks.BOG_RESIN_BRICKS_STAIRS, ModBlocks.BOG_RESIN_BRICKS_SLAB, ModBlocks.BOG_RESIN_BRICKS_WALL, ModBlocks.BOG_RESIN_BLOCK, ModBlocks.BOG_RESIN_BLOCK_STAIRS, ModBlocks.BOG_RESIN_BLOCK_SLAB, ModBlocks.BOG_RESIN_BLOCK_WALL, ModBlocks.CHISELED_BOG_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.BOG_RESIN_CLUMP, ModItems.BOG_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.SCULK_POLISHED_RESIN, ModBlocks.SCULK_POLISHED_RESIN_STAIRS, ModBlocks.SCULK_POLISHED_RESIN_SLAB, ModBlocks.SCULK_POLISHED_RESIN_WALL, ModBlocks.SCULK_RESIN_BRICKS, ModBlocks.SCULK_RESIN_BRICKS_STAIRS, ModBlocks.SCULK_RESIN_BRICKS_SLAB, ModBlocks.SCULK_RESIN_BRICKS_WALL, ModBlocks.SCULK_RESIN_BLOCK, ModBlocks.SCULK_RESIN_BLOCK_STAIRS, ModBlocks.SCULK_RESIN_BLOCK_SLAB, ModBlocks.SCULK_RESIN_BLOCK_WALL, ModBlocks.CHISELED_SCULK_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.SCULK_RESIN_CLUMP, ModItems.SCULK_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.RETRO_POLISHED_RESIN, ModBlocks.RETRO_POLISHED_RESIN_STAIRS, ModBlocks.RETRO_POLISHED_RESIN_SLAB, ModBlocks.RETRO_POLISHED_RESIN_WALL, ModBlocks.RETRO_RESIN_BRICKS, ModBlocks.RETRO_RESIN_BRICKS_STAIRS, ModBlocks.RETRO_RESIN_BRICKS_SLAB, ModBlocks.RETRO_RESIN_BRICKS_WALL, ModBlocks.RETRO_RESIN_BLOCK, ModBlocks.RETRO_RESIN_BLOCK_STAIRS, ModBlocks.RETRO_RESIN_BLOCK_SLAB, ModBlocks.RETRO_RESIN_BLOCK_WALL, ModBlocks.CHISELED_RETRO_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.RETRO_RESIN_CLUMP, ModItems.RETRO_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.DUST_POLISHED_RESIN, ModBlocks.DUST_POLISHED_RESIN_STAIRS, ModBlocks.DUST_POLISHED_RESIN_SLAB, ModBlocks.DUST_POLISHED_RESIN_WALL, ModBlocks.DUST_RESIN_BRICKS, ModBlocks.DUST_RESIN_BRICKS_STAIRS, ModBlocks.DUST_RESIN_BRICKS_SLAB, ModBlocks.DUST_RESIN_BRICKS_WALL, ModBlocks.DUST_RESIN_BLOCK, ModBlocks.DUST_RESIN_BLOCK_STAIRS, ModBlocks.DUST_RESIN_BLOCK_SLAB, ModBlocks.DUST_RESIN_BLOCK_WALL, ModBlocks.CHISELED_DUST_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.DUST_RESIN_CLUMP, ModItems.DUST_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.BLOOD_POLISHED_RESIN, ModBlocks.BLOOD_POLISHED_RESIN_STAIRS, ModBlocks.BLOOD_POLISHED_RESIN_SLAB, ModBlocks.BLOOD_POLISHED_RESIN_WALL, ModBlocks.BLOOD_RESIN_BRICKS, ModBlocks.BLOOD_RESIN_BRICKS_STAIRS, ModBlocks.BLOOD_RESIN_BRICKS_SLAB, ModBlocks.BLOOD_RESIN_BRICKS_WALL, ModBlocks.BLOOD_RESIN_BLOCK, ModBlocks.BLOOD_RESIN_BLOCK_STAIRS, ModBlocks.BLOOD_RESIN_BLOCK_SLAB, ModBlocks.BLOOD_RESIN_BLOCK_WALL, ModBlocks.CHISELED_BLOOD_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.BLOOD_RESIN_CLUMP, ModItems.BLOOD_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.RUBY_POLISHED_RESIN, ModBlocks.RUBY_POLISHED_RESIN_STAIRS, ModBlocks.RUBY_POLISHED_RESIN_SLAB, ModBlocks.RUBY_POLISHED_RESIN_WALL, ModBlocks.RUBY_RESIN_BRICKS, ModBlocks.RUBY_RESIN_BRICKS_STAIRS, ModBlocks.RUBY_RESIN_BRICKS_SLAB, ModBlocks.RUBY_RESIN_BRICKS_WALL, ModBlocks.RUBY_RESIN_BLOCK, ModBlocks.RUBY_RESIN_BLOCK_STAIRS, ModBlocks.RUBY_RESIN_BLOCK_SLAB, ModBlocks.RUBY_RESIN_BLOCK_WALL, ModBlocks.CHISELED_RUBY_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.RUBY_RESIN_CLUMP, ModItems.RUBY_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.PEARL_POLISHED_RESIN, ModBlocks.PEARL_POLISHED_RESIN_STAIRS, ModBlocks.PEARL_POLISHED_RESIN_SLAB, ModBlocks.PEARL_POLISHED_RESIN_WALL, ModBlocks.PEARL_RESIN_BRICKS, ModBlocks.PEARL_RESIN_BRICKS_STAIRS, ModBlocks.PEARL_RESIN_BRICKS_SLAB, ModBlocks.PEARL_RESIN_BRICKS_WALL, ModBlocks.PEARL_RESIN_BLOCK, ModBlocks.PEARL_RESIN_BLOCK_STAIRS, ModBlocks.PEARL_RESIN_BLOCK_SLAB, ModBlocks.PEARL_RESIN_BLOCK_WALL, ModBlocks.CHISELED_PEARL_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.PEARL_RESIN_CLUMP, ModItems.PEARL_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.SNOWY_POLISHED_RESIN, ModBlocks.SNOWY_POLISHED_RESIN_STAIRS, ModBlocks.SNOWY_POLISHED_RESIN_SLAB, ModBlocks.SNOWY_POLISHED_RESIN_WALL, ModBlocks.SNOWY_RESIN_BRICKS, ModBlocks.SNOWY_RESIN_BRICKS_STAIRS, ModBlocks.SNOWY_RESIN_BRICKS_SLAB, ModBlocks.SNOWY_RESIN_BRICKS_WALL, ModBlocks.SNOWY_RESIN_BLOCK, ModBlocks.SNOWY_RESIN_BLOCK_STAIRS, ModBlocks.SNOWY_RESIN_BLOCK_SLAB, ModBlocks.SNOWY_RESIN_BLOCK_WALL, ModBlocks.CHISELED_SNOWY_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.SNOWY_RESIN_CLUMP, ModItems.SNOWY_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.SUBZERO_POLISHED_RESIN, ModBlocks.SUBZERO_POLISHED_RESIN_STAIRS, ModBlocks.SUBZERO_POLISHED_RESIN_SLAB, ModBlocks.SUBZERO_POLISHED_RESIN_WALL, ModBlocks.SUBZERO_RESIN_BRICKS, ModBlocks.SUBZERO_RESIN_BRICKS_STAIRS, ModBlocks.SUBZERO_RESIN_BRICKS_SLAB, ModBlocks.SUBZERO_RESIN_BRICKS_WALL, ModBlocks.SUBZERO_RESIN_BLOCK, ModBlocks.SUBZERO_RESIN_BLOCK_STAIRS, ModBlocks.SUBZERO_RESIN_BLOCK_SLAB, ModBlocks.SUBZERO_RESIN_BLOCK_WALL, ModBlocks.CHISELED_SUBZERO_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.SUBZERO_RESIN_CLUMP, ModItems.SUBZERO_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.GEM_POLISHED_RESIN, ModBlocks.GEM_POLISHED_RESIN_STAIRS, ModBlocks.GEM_POLISHED_RESIN_SLAB, ModBlocks.GEM_POLISHED_RESIN_WALL, ModBlocks.GEM_RESIN_BRICKS, ModBlocks.GEM_RESIN_BRICKS_STAIRS, ModBlocks.GEM_RESIN_BRICKS_SLAB, ModBlocks.GEM_RESIN_BRICKS_WALL, ModBlocks.GEM_RESIN_BLOCK, ModBlocks.GEM_RESIN_BLOCK_STAIRS, ModBlocks.GEM_RESIN_BLOCK_SLAB, ModBlocks.GEM_RESIN_BLOCK_WALL, ModBlocks.CHISELED_GEM_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.GEM_RESIN_CLUMP, ModItems.GEM_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.ROTTEN_POLISHED_RESIN, ModBlocks.ROTTEN_POLISHED_RESIN_STAIRS, ModBlocks.ROTTEN_POLISHED_RESIN_SLAB, ModBlocks.ROTTEN_POLISHED_RESIN_WALL, ModBlocks.ROTTEN_RESIN_BRICKS, ModBlocks.ROTTEN_RESIN_BRICKS_STAIRS, ModBlocks.ROTTEN_RESIN_BRICKS_SLAB, ModBlocks.ROTTEN_RESIN_BRICKS_WALL, ModBlocks.ROTTEN_RESIN_BLOCK, ModBlocks.ROTTEN_RESIN_BLOCK_STAIRS, ModBlocks.ROTTEN_RESIN_BLOCK_SLAB, ModBlocks.ROTTEN_RESIN_BLOCK_WALL, ModBlocks.CHISELED_ROTTEN_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.ROTTEN_RESIN_CLUMP, ModItems.ROTTEN_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.GRAPE_POLISHED_RESIN, ModBlocks.GRAPE_POLISHED_RESIN_STAIRS, ModBlocks.GRAPE_POLISHED_RESIN_SLAB, ModBlocks.GRAPE_POLISHED_RESIN_WALL, ModBlocks.GRAPE_RESIN_BRICKS, ModBlocks.GRAPE_RESIN_BRICKS_STAIRS, ModBlocks.GRAPE_RESIN_BRICKS_SLAB, ModBlocks.GRAPE_RESIN_BRICKS_WALL, ModBlocks.GRAPE_RESIN_BLOCK, ModBlocks.GRAPE_RESIN_BLOCK_STAIRS, ModBlocks.GRAPE_RESIN_BLOCK_SLAB, ModBlocks.GRAPE_RESIN_BLOCK_WALL, ModBlocks.CHISELED_GRAPE_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.GRAPE_RESIN_CLUMP, ModItems.GRAPE_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.REDSTONE_POLISHED_RESIN, ModBlocks.REDSTONE_POLISHED_RESIN_STAIRS, ModBlocks.REDSTONE_POLISHED_RESIN_SLAB, ModBlocks.REDSTONE_POLISHED_RESIN_WALL, ModBlocks.REDSTONE_RESIN_BRICKS, ModBlocks.REDSTONE_RESIN_BRICKS_STAIRS, ModBlocks.REDSTONE_RESIN_BRICKS_SLAB, ModBlocks.REDSTONE_RESIN_BRICKS_WALL, ModBlocks.REDSTONE_RESIN_BLOCK, ModBlocks.REDSTONE_RESIN_BLOCK_STAIRS, ModBlocks.REDSTONE_RESIN_BLOCK_SLAB, ModBlocks.REDSTONE_RESIN_BLOCK_WALL, ModBlocks.CHISELED_REDSTONE_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.REDSTONE_RESIN_CLUMP, ModItems.REDSTONE_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.COPPER_POLISHED_RESIN, ModBlocks.COPPER_POLISHED_RESIN_STAIRS, ModBlocks.COPPER_POLISHED_RESIN_SLAB, ModBlocks.COPPER_POLISHED_RESIN_WALL, ModBlocks.COPPER_RESIN_BRICKS, ModBlocks.COPPER_RESIN_BRICKS_STAIRS, ModBlocks.COPPER_RESIN_BRICKS_SLAB, ModBlocks.COPPER_RESIN_BRICKS_WALL, ModBlocks.COPPER_RESIN_BLOCK, ModBlocks.COPPER_RESIN_BLOCK_STAIRS, ModBlocks.COPPER_RESIN_BLOCK_SLAB, ModBlocks.COPPER_RESIN_BLOCK_WALL, ModBlocks.CHISELED_COPPER_RESIN_BRICKS);
        blockStateModelGenerator.registerMultifaceBlock(ModBlocks.COPPER_RESIN_CLUMP, ModItems.COPPER_RESIN_CLUMP);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.KAOLIN_CLAY_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIDNIGHT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.TROWEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ABERRANT_PASTE, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.GOLD_CHAIN.asItem(), Models.GENERATED);

        itemModelGenerator.register(ModItems.BEETROOT_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHORUS_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEMON_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLACIER_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARAMEL_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOXIC_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.JADE_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUBBLE_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.OCEAN_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMERALD_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUSK_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DAYBREAK_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SILT_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPHITE_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.OBSIDIAN_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCOA_RESIN_BRICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.ABERRANT_AMETHYST_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.ABERRANT_NETHER_BRICK, Models.GENERATED);

        itemModelGenerator.register(ModItems.BRASS_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DANDELION_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOG_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SCULK_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RETRO_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.DUST_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLOOD_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.RUBY_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.PEARL_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SNOWY_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUBZERO_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.GEM_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROTTEN_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPE_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.REDSTONE_RESIN_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COPPER_RESIN_BRICK, Models.GENERATED);
    }

    public void registerResin(BlockStateModelGenerator generator, Block polishedResin, Block polishedResinStairs, Block polishedResinSlab, Block polishedResinWall, Block resinBrick, Block resinBrickStairs, Block resinBrickSlab, Block resinBrickWall, Block resinBlock, Block resinBlockStairs, Block resinBlockSlab, Block resinBlockWall, Block chiseledResinBrick) {
        generator.registerCubeAllModelTexturePool(polishedResin)
                .stairs(polishedResinStairs)
                .slab(polishedResinSlab)
                .wall(polishedResinWall);
        generator.registerCubeAllModelTexturePool(resinBrick)
                .stairs(resinBrickStairs)
                .slab(resinBrickSlab)
                .wall(resinBrickWall);
        generator.registerCubeAllModelTexturePool(resinBlock)
                .stairs(resinBlockStairs)
                .slab(resinBlockSlab)
                .wall(resinBlockWall);
        generator.registerSimpleCubeAll(chiseledResinBrick);
    }

    public void registerSeat(Block block, BlockStateModelGenerator generator) {
        // Modified TextureMap.sideTopBottom()
        TextureMap textureMap = new TextureMap().put(TextureKey.SIDE, TextureMap.getSubId(block, "_side")).put(TextureKey.TOP, TextureMap.getSubId(block, "_top")).put(TextureKey.BOTTOM, Identifier.of(Bauen.MOD_ID, "block/seat_bottom"));

        WeightedVariant weightedVariant = BlockStateModelGenerator.createWeightedVariant(Models.SLAB.upload(block, textureMap, generator.modelCollector));
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, weightedVariant));
    }

    // Modified from Minecraft Sandstone datagen (it's so ugly...)
    static final Map<Block, TexturedModel> SOUL_SANDSTONE_MODELS =
    Map.of(ModBlocks.SOUL_SANDSTONE, TexturedModel.SIDE_TOP_BOTTOM_WALL.get(ModBlocks.SOUL_SANDSTONE),
            ModBlocks.SMOOTH_SOUL_SANDSTONE, TexturedModel.getCubeAll(TextureMap.getSubId(ModBlocks.SOUL_SANDSTONE, "_top")),
            ModBlocks.CUT_SOUL_SANDSTONE, TexturedModel.CUBE_COLUMN.get(ModBlocks.SOUL_SANDSTONE).textures(textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(ModBlocks.CUT_SOUL_SANDSTONE))),
            ModBlocks.CHISELED_SOUL_SANDSTONE, TexturedModel.CUBE_COLUMN.get(ModBlocks.CHISELED_SOUL_SANDSTONE).textures(textureMap -> {
                textureMap.put(TextureKey.END, TextureMap.getSubId(ModBlocks.SOUL_SANDSTONE, "_top"));
                textureMap.put(TextureKey.SIDE, TextureMap.getId(ModBlocks.CHISELED_SOUL_SANDSTONE));})
    );

    static final Map<Block, TexturedModel> ABERRANT_SOUL_SANDSTONE_MODELS =
    Map.of(ModBlocks.ABERRANT_SOUL_SANDSTONE, TexturedModel.SIDE_TOP_BOTTOM_WALL.get(ModBlocks.ABERRANT_SOUL_SANDSTONE),
            ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE, TexturedModel.getCubeAll(TextureMap.getSubId(ModBlocks.ABERRANT_SOUL_SANDSTONE, "_top")),
            ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE, TexturedModel.CUBE_COLUMN.get(ModBlocks.ABERRANT_SOUL_SANDSTONE).textures(textureMap -> textureMap.put(TextureKey.SIDE, TextureMap.getId(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE))),
            ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, TexturedModel.CUBE_COLUMN.get(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE).textures(textureMap -> {
                textureMap.put(TextureKey.END, TextureMap.getSubId(ModBlocks.ABERRANT_SOUL_SANDSTONE, "_top"));
                textureMap.put(TextureKey.SIDE, TextureMap.getId(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE));})
    );

    public final BlockStateModelGenerator.BlockTexturePool registerSandstone(Block block, BlockStateModelGenerator generator, Map<Block, TexturedModel> models) {
        TexturedModel texturedModel = models.getOrDefault(block, TexturedModel.CUBE_ALL.get(block));
        return generator.new BlockTexturePool(texturedModel.getTextures()).base(block, texturedModel.getModel());
    }

    private void registerPumpkins(BlockStateModelGenerator generator) {
        TextureMap textureMap = TextureMap.sideEnd(ModBlocks.ABERRANT_PUMPKIN);
        generator.blockStateCollector.accept(generator.createSingletonBlockState(ModBlocks.ABERRANT_PUMPKIN, createWeightedVariant(Models.CUBE_BOTTOM_TOP.upload(ModBlocks.ABERRANT_PUMPKIN, textureMap, generator.modelCollector))));
        generator.registerNorthDefaultHorizontalRotatable(ModBlocks.ABERRANT_CARVED_PUMPKIN, textureMap);
        generator.registerNorthDefaultHorizontalRotatable(ModBlocks.ABERRANT_JACK_O_LANTERN, textureMap);
    }

    // need this AND manual model json
    private void registerGoldHoards(BlockStateModelGenerator generator) {
        TextureMap textureMap = TextureMap.all(ModBlocks.GOLD_HOARD);
        WeightedVariant weightedVariant = createWeightedVariant(Models.CUBE_ALL.upload(ModBlocks.GOLD_HOARD_BLOCK, textureMap, generator.modelCollector));
        generator.blockStateCollector.accept(
            VariantsBlockModelDefinitionCreator.of(ModBlocks.GOLD_HOARD).with(
                BlockStateVariantMap.models(Properties.LAYERS).generate(
                        layers -> layers < 8 ? createWeightedVariant(ModelIds.getBlockSubModelId(ModBlocks.GOLD_HOARD, "_height" + layers * 2)) : weightedVariant
                )
            )
        );
        generator.registerParentedItemModel(ModBlocks.GOLD_HOARD, ModelIds.getBlockSubModelId(ModBlocks.GOLD_HOARD, "_height2"));
        generator.blockStateCollector.accept(generator.createSingletonBlockState(ModBlocks.GOLD_HOARD_BLOCK, weightedVariant));
    }

    public final void registerCustomWoolAndCarpet(BlockStateModelGenerator generator, Block wool, Block carpet, Block stairs, Block slab) {
        generator.registerCubeAllModelTexturePool(wool)
                .stairs(stairs)
                .slab(slab);
        WeightedVariant weightedVariant = BlockStateModelGenerator.createWeightedVariant(TexturedModel.CARPET.get(wool).upload(carpet, generator.modelCollector));
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(carpet, weightedVariant));
    }

    private void registerRedstoneLamp(BlockStateModelGenerator generator, Block block) {
        WeightedVariant weightedVariant = generator.createWeightedVariant(TexturedModel.CUBE_ALL.upload(block, generator.modelCollector));
        WeightedVariant weightedVariant2 = generator.createWeightedVariant(generator.createSubModel(block, "_on", Models.CUBE_ALL, TextureMap::all));
        generator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(generator.createBooleanModelMap(Properties.LIT, weightedVariant2, weightedVariant)));
    }
}
