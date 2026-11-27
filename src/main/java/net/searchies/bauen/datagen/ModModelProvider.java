package net.searchies.bauen.datagen;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.BlockModelGenerators.BlockFamilyProvider;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModItems;

import java.util.Map;
import java.util.function.BiConsumer;

import static net.minecraft.client.data.models.BlockModelGenerators.plainVariant;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.family(ModBlocks.MOSSY_BRICKS)
                .stairs(ModBlocks.MOSSY_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.CRACKED_BRICKS)
                .stairs(ModBlocks.CRACKED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.CHISELED_BRICKS)
                .stairs(ModBlocks.CHISELED_BRICKS_STAIRS)
                .slab(ModBlocks.CHISELED_BRICKS_SLAB)
                .wall(ModBlocks.CHISELED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_CHISELED_BRICKS)
                .stairs(ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_CHISELED_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_CHISELED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_CHISELED_BRICKS)
                .stairs(ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_CHISELED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_CHISELED_BRICKS_WALL);

        blockStateModelGenerator.createAxisAlignedPillarBlockCustomModel(ModBlocks.GOLD_CHAIN, plainVariant(TexturedModel.CHAIN.create(ModBlocks.GOLD_CHAIN, blockStateModelGenerator.modelOutput)));
        blockStateModelGenerator.createBarsAndItem(ModBlocks.GOLD_BARS);
        blockStateModelGenerator.createLantern(ModBlocks.GOLD_LANTERN);
        blockStateModelGenerator.family(ModBlocks.CUT_GOLD)
                .stairs(ModBlocks.CUT_GOLD_STAIRS)
                .slab(ModBlocks.CUT_GOLD_SLAB)
                .wall(ModBlocks.CUT_GOLD_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_GOLD);
        blockStateModelGenerator.createTrivialCube(ModBlocks.GOLD_GRATE);
        blockStateModelGenerator.createTrapdoor(ModBlocks.GOLD_TRAPDOOR);
        blockStateModelGenerator.createDoor(ModBlocks.GOLD_DOOR);
        blockStateModelGenerator.createLeafLitter(ModBlocks.GOLD_COINS);
        registerGoldHoards(blockStateModelGenerator);

        blockStateModelGenerator.family(ModBlocks.MIXED_COBBLESTONE)
                .stairs(ModBlocks.MIXED_COBBLESTONE_STAIRS)
                .slab(ModBlocks.MIXED_COBBLESTONE_SLAB)
                .wall(ModBlocks.MIXED_COBBLESTONE_WALL);

        blockStateModelGenerator.family(ModBlocks.INDUSTRIAL_IRON_BLOCK)
                .stairs(ModBlocks.INDUSTRIAL_IRON_STAIRS)
                .slab(ModBlocks.INDUSTRIAL_IRON_SLAB)
                .wall(ModBlocks.INDUSTRIAL_IRON_WALL);
        blockStateModelGenerator.family(ModBlocks.CUT_INDUSTRIAL_IRON)
                .stairs(ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS)
                .slab(ModBlocks.CUT_INDUSTRIAL_IRON_SLAB)
                .wall(ModBlocks.CUT_INDUSTRIAL_IRON_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CARVED_INDUSTRIAL_IRON);
        blockStateModelGenerator.createTrivialCube(ModBlocks.INDUSTRIAL_IRON_GRATE);
        blockStateModelGenerator.createTrapdoor(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
        blockStateModelGenerator.createDoor(ModBlocks.INDUSTRIAL_IRON_DOOR);

        blockStateModelGenerator.family(Blocks.ICE)
                .stairs(ModBlocks.ICE_STAIRS)
                .slab(ModBlocks.ICE_SLAB)
                .wall(ModBlocks.ICE_WALL);

        blockStateModelGenerator.family(Blocks.PACKED_ICE)
                .stairs(ModBlocks.PACKED_ICE_STAIRS)
                .slab(ModBlocks.PACKED_ICE_SLAB)
                .wall(ModBlocks.PACKED_ICE_WALL);

        blockStateModelGenerator.family(Blocks.MUD)
                .stairs(ModBlocks.MUD_STAIRS)
                .slab(ModBlocks.MUD_SLAB)
                .wall(ModBlocks.MUD_WALL);

        blockStateModelGenerator.family(ModBlocks.MOSSY_PACKED_MUD)
                .stairs(ModBlocks.MOSSY_PACKED_MUD_STAIRS)
                .slab(ModBlocks.MOSSY_PACKED_MUD_SLAB)
                .wall(ModBlocks.MOSSY_PACKED_MUD_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_MUD_BRICKS)
                .stairs(ModBlocks.MOSSY_MUD_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_MUD_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_MUD_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_TUFF_BRICKS)
                .stairs(ModBlocks.MOSSY_TUFF_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_TUFF_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_TUFF_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_TUFF_BRICKS)
                .stairs(ModBlocks.CRACKED_TUFF_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_TUFF_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_TUFF_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.SCULKED_DEEPSLATE_BRICKS)
                .stairs(ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS)
                .slab(ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB)
                .wall(ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.MIDNIGHT_BRICKS)
                .stairs(ModBlocks.MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CHISELED_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS)
                .stairs(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL);

        blockStateModelGenerator.createTrivialCube(ModBlocks.KAOLIN_CLAY);

        blockStateModelGenerator.family(ModBlocks.TREATED_BRICKS)
                .stairs(ModBlocks.TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.TREATED_BRICKS_SLAB)
                .wall(ModBlocks.TREATED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_TREATED_BRICKS)
                .stairs(ModBlocks.MOSSY_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_TREATED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_TREATED_BRICKS)
                .stairs(ModBlocks.CRACKED_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_TREATED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CHISELED_TREATED_BRICKS)
                .stairs(ModBlocks.CHISELED_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.CHISELED_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.CHISELED_TREATED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS)
                .stairs(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS)
                .stairs(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MIXED_BRICKS)
                .stairs(ModBlocks.MIXED_BRICKS_STAIRS)
                .slab(ModBlocks.MIXED_BRICKS_SLAB)
                .wall(ModBlocks.MIXED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_MIXED_BRICKS)
                .stairs(ModBlocks.MOSSY_MIXED_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_MIXED_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_MIXED_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_MIXED_BRICKS)
                .stairs(ModBlocks.CRACKED_MIXED_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_MIXED_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_MIXED_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.POLISHED_CALCITE)
                .stairs(ModBlocks.POLISHED_CALCITE_STAIRS)
                .slab(ModBlocks.POLISHED_CALCITE_SLAB)
                .wall(ModBlocks.POLISHED_CALCITE_WALL);
        blockStateModelGenerator.family(ModBlocks.CALCITE_BRICKS)
                .stairs(ModBlocks.CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.CALCITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.POLISHED_CALCITE_BRICKS)
                .stairs(ModBlocks.POLISHED_CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_CALCITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_CALCITE_BRICKS)
                .stairs(ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_CALCITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_CALCITE_BRICKS)
                .stairs(ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_CALCITE_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.ANDESITE_BRICKS)
                .stairs(ModBlocks.ANDESITE_BRICKS_STAIRS)
                .slab(ModBlocks.ANDESITE_BRICKS_SLAB)
                .wall(ModBlocks.ANDESITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.POLISHED_ANDESITE_BRICKS)
                .stairs(ModBlocks.POLISHED_ANDESITE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_ANDESITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_ANDESITE_BRICKS)
                .stairs(ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_ANDESITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_ANDESITE_BRICKS)
                .stairs(ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_ANDESITE_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.DIORITE_BRICKS)
                .stairs(ModBlocks.DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.DIORITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.POLISHED_DIORITE_BRICKS)
                .stairs(ModBlocks.POLISHED_DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_DIORITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_DIORITE_BRICKS)
                .stairs(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_DIORITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_DIORITE_BRICKS)
                .stairs(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_DIORITE_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.POLISHED_DRIPSTONE)
                .stairs(ModBlocks.POLISHED_DRIPSTONE_STAIRS)
                .slab(ModBlocks.POLISHED_DRIPSTONE_SLAB)
                .wall(ModBlocks.POLISHED_DRIPSTONE_WALL);
        blockStateModelGenerator.family(ModBlocks.DRIPSTONE_BRICKS)
                .stairs(ModBlocks.DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.DRIPSTONE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.POLISHED_DRIPSTONE_BRICKS)
                .stairs(ModBlocks.POLISHED_DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_DRIPSTONE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_DRIPSTONE_BRICKS)
                .stairs(ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_DRIPSTONE_BRICKS)
                .stairs(ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.GRANITE_BRICKS)
                .stairs(ModBlocks.GRANITE_BRICKS_STAIRS)
                .slab(ModBlocks.GRANITE_BRICKS_SLAB)
                .wall(ModBlocks.GRANITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.POLISHED_GRANITE_BRICKS)
                .stairs(ModBlocks.POLISHED_GRANITE_BRICKS_STAIRS)
                .slab(ModBlocks.POLISHED_GRANITE_BRICKS_SLAB)
                .wall(ModBlocks.POLISHED_GRANITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.MOSSY_GRANITE_BRICKS)
                .stairs(ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_GRANITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_GRANITE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_GRANITE_BRICKS)
                .stairs(ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_GRANITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_GRANITE_BRICKS_WALL);

        blockStateModelGenerator.family(ModBlocks.OCEANSLATE)
                .stairs(ModBlocks.OCEANSLATE_STAIRS)
                .slab(ModBlocks.OCEANSLATE_SLAB)
                .wall(ModBlocks.OCEANSLATE_WALL);
        blockStateModelGenerator.family(ModBlocks.OCEANSLATE_BRICKS)
                .stairs(ModBlocks.OCEANSLATE_BRICKS_STAIRS)
                .slab(ModBlocks.OCEANSLATE_BRICKS_SLAB)
                .wall(ModBlocks.OCEANSLATE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.OCEANSLATE_TILES)
                .stairs(ModBlocks.OCEANSLATE_TILES_STAIRS)
                .slab(ModBlocks.OCEANSLATE_TILES_SLAB)
                .wall(ModBlocks.OCEANSLATE_TILES_WALL);
        blockStateModelGenerator.family(ModBlocks.POLISHED_OCEANSLATE)
                .stairs(ModBlocks.POLISHED_OCEANSLATE_STAIRS)
                .slab(ModBlocks.POLISHED_OCEANSLATE_SLAB)
                .wall(ModBlocks.POLISHED_OCEANSLATE_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_OCEANSLATE_BRICKS)
                .stairs(ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.KELPY_OCEANSLATE_BRICKS)
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

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_SEA_LANTERN);

        blockStateModelGenerator.family(ModBlocks.ABERRANT_DARK_PRISMARINE)
            .stairs(ModBlocks.ABERRANT_DARK_PRISMARINE_STAIRS)
            .slab(ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB)
            .wall(ModBlocks.ABERRANT_DARK_PRISMARINE_WALL);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_PRISMARINE)
            .stairs(ModBlocks.ABERRANT_PRISMARINE_STAIRS)
            .slab(ModBlocks.ABERRANT_PRISMARINE_SLAB)
            .wall(ModBlocks.ABERRANT_PRISMARINE_WALL);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_PRISMARINE_BRICKS)
            .stairs(ModBlocks.ABERRANT_PRISMARINE_BRICKS_STAIRS)
            .slab(ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_OCEANSLATE)
            .stairs(ModBlocks.ABERRANT_OCEANSLATE_STAIRS)
            .slab(ModBlocks.ABERRANT_OCEANSLATE_SLAB)
            .wall(ModBlocks.ABERRANT_OCEANSLATE_WALL);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_POLISHED_OCEANSLATE)
            .stairs(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_STAIRS)
            .slab(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB)
            .wall(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_WALL);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_OCEANSLATE_TILES)
            .stairs(ModBlocks.ABERRANT_OCEANSLATE_TILES_STAIRS)
            .slab(ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB)
            .wall(ModBlocks.ABERRANT_OCEANSLATE_TILES_WALL);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_OCEANSLATE_BRICKS)
            .stairs(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_STAIRS)
            .slab(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB)
            .wall(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS)
            .stairs(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_STAIRS)
            .slab(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_SLAB)
            .wall(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS)
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

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_TERRACOTTA);

        registerSeat(ModBlocks.ABERRANT_RED_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_RED_CONCRETE)
            .stairs(ModBlocks.ABERRANT_RED_CONCRETE_STAIRS)
            .slab(ModBlocks.ABERRANT_RED_CONCRETE_SLAB)
            .wall(ModBlocks.ABERRANT_RED_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_RED_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_RED_TERRACOTTA)
            .stairs(ModBlocks.ABERRANT_RED_TERRACOTTA_STAIRS)
            .slab(ModBlocks.ABERRANT_RED_TERRACOTTA_SLAB)
            .wall(ModBlocks.ABERRANT_RED_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_ORANGE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_ORANGE_CONCRETE)
            .stairs(ModBlocks.ABERRANT_ORANGE_CONCRETE_STAIRS)
            .slab(ModBlocks.ABERRANT_ORANGE_CONCRETE_SLAB)
            .wall(ModBlocks.ABERRANT_ORANGE_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_ORANGE_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_ORANGE_TERRACOTTA)
            .stairs(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_STAIRS)
            .slab(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_SLAB)
            .wall(ModBlocks.ABERRANT_ORANGE_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_YELLOW_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_YELLOW_CONCRETE)
            .stairs(ModBlocks.ABERRANT_YELLOW_CONCRETE_STAIRS)
            .slab(ModBlocks.ABERRANT_YELLOW_CONCRETE_SLAB)
            .wall(ModBlocks.ABERRANT_YELLOW_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_YELLOW_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_YELLOW_TERRACOTTA)
            .stairs(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_STAIRS)
            .slab(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_SLAB)
            .wall(ModBlocks.ABERRANT_YELLOW_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_LIME_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_LIME_CONCRETE)
                .stairs(ModBlocks.ABERRANT_LIME_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_LIME_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_LIME_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_LIME_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_LIME_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_LIME_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_LIME_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_LIME_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_GREEN_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_GREEN_CONCRETE)
                .stairs(ModBlocks.ABERRANT_GREEN_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_GREEN_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_GREEN_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_GREEN_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_GREEN_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_GREEN_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_GREEN_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_GREEN_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_CYAN_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_CYAN_CONCRETE)
                .stairs(ModBlocks.ABERRANT_CYAN_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_CYAN_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_CYAN_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_CYAN_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_CYAN_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_CYAN_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_CYAN_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_CYAN_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_LIGHT_BLUE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE)
                .stairs(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_BLUE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_BLUE_CONCRETE)
                .stairs(ModBlocks.ABERRANT_BLUE_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_BLUE_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_BLUE_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_BLUE_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_BLUE_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_BLUE_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_BLUE_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_BLUE_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_PINK_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_PINK_CONCRETE)
                .stairs(ModBlocks.ABERRANT_PINK_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_PINK_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_PINK_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_PINK_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_PINK_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_PINK_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_PINK_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_PINK_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_MAGENTA_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_MAGENTA_CONCRETE)
                .stairs(ModBlocks.ABERRANT_MAGENTA_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_MAGENTA_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_MAGENTA_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_MAGENTA_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_PURPLE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_PURPLE_CONCRETE)
                .stairs(ModBlocks.ABERRANT_PURPLE_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_PURPLE_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_PURPLE_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_PURPLE_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_PURPLE_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_PURPLE_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_BROWN_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_BROWN_CONCRETE)
                .stairs(ModBlocks.ABERRANT_BROWN_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_BROWN_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_BROWN_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_BROWN_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_BROWN_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_BROWN_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_BROWN_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_BROWN_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_BLACK_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_BLACK_CONCRETE)
                .stairs(ModBlocks.ABERRANT_BLACK_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_BLACK_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_BLACK_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_BLACK_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_BLACK_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_BLACK_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_BLACK_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_BLACK_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_GRAY_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_GRAY_CONCRETE)
                .stairs(ModBlocks.ABERRANT_GRAY_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_GRAY_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_GRAY_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_GRAY_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_GRAY_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_GRAY_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_GRAY_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_GRAY_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_LIGHT_GRAY_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE)
                .stairs(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_WALL);

        registerSeat(ModBlocks.ABERRANT_WHITE_SEAT, blockStateModelGenerator);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_WHITE_CONCRETE)
                .stairs(ModBlocks.ABERRANT_WHITE_CONCRETE_STAIRS)
                .slab(ModBlocks.ABERRANT_WHITE_CONCRETE_SLAB)
                .wall(ModBlocks.ABERRANT_WHITE_CONCRETE_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_WHITE_CONCRETE_POWER);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_WHITE_TERRACOTTA)
                .stairs(ModBlocks.ABERRANT_WHITE_TERRACOTTA_STAIRS)
                .slab(ModBlocks.ABERRANT_WHITE_TERRACOTTA_SLAB)
                .wall(ModBlocks.ABERRANT_WHITE_TERRACOTTA_WALL);

        blockStateModelGenerator.createColoredBlockWithStateRotations(TexturedModel.GLAZED_TERRACOTTA,
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

        blockStateModelGenerator.family(ModBlocks.BEETROOT_RESIN_BRICKS)
                .stairs(ModBlocks.BEETROOT_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.BEETROOT_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.BEETROOT_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.BEETROOT_RESIN_BLOCK)
                .stairs(ModBlocks.BEETROOT_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.BEETROOT_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.BEETROOT_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_BEETROOT_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.BEETROOT_RESIN_CLUMP, ModItems.BEETROOT_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.CHORUS_RESIN_BRICKS)
                .stairs(ModBlocks.CHORUS_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.CHORUS_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.CHORUS_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CHORUS_RESIN_BLOCK)
                .stairs(ModBlocks.CHORUS_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.CHORUS_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.CHORUS_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_CHORUS_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.CHORUS_RESIN_CLUMP, ModItems.CHORUS_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.LEMON_RESIN_BRICKS)
                .stairs(ModBlocks.LEMON_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.LEMON_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.LEMON_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.LEMON_RESIN_BLOCK)
                .stairs(ModBlocks.LEMON_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.LEMON_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.LEMON_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_LEMON_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.LEMON_RESIN_CLUMP, ModItems.LEMON_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.GLACIER_RESIN_BRICKS)
                .stairs(ModBlocks.GLACIER_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.GLACIER_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.GLACIER_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.GLACIER_RESIN_BLOCK)
                .stairs(ModBlocks.GLACIER_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.GLACIER_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.GLACIER_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_GLACIER_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.GLACIER_RESIN_CLUMP, ModItems.GLACIER_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.CARAMEL_RESIN_BRICKS)
                .stairs(ModBlocks.CARAMEL_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.CARAMEL_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.CARAMEL_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CARAMEL_RESIN_BLOCK)
                .stairs(ModBlocks.CARAMEL_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.CARAMEL_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.CARAMEL_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_CARAMEL_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.CARAMEL_RESIN_CLUMP, ModItems.CARAMEL_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.TOXIC_RESIN_BRICKS)
                .stairs(ModBlocks.TOXIC_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.TOXIC_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.TOXIC_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.TOXIC_RESIN_BLOCK)
                .stairs(ModBlocks.TOXIC_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.TOXIC_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.TOXIC_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_TOXIC_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.TOXIC_RESIN_CLUMP, ModItems.TOXIC_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.JADE_RESIN_BRICKS)
                .stairs(ModBlocks.JADE_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.JADE_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.JADE_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.JADE_RESIN_BLOCK)
                .stairs(ModBlocks.JADE_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.JADE_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.JADE_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_JADE_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.JADE_RESIN_CLUMP, ModItems.JADE_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.BUBBLE_RESIN_BRICKS)
                .stairs(ModBlocks.BUBBLE_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.BUBBLE_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.BUBBLE_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.BUBBLE_RESIN_BLOCK)
                .stairs(ModBlocks.BUBBLE_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.BUBBLE_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.BUBBLE_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_BUBBLE_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.BUBBLE_RESIN_CLUMP, ModItems.BUBBLE_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.OCEAN_RESIN_BRICKS)
                .stairs(ModBlocks.OCEAN_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.OCEAN_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.OCEAN_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.OCEAN_RESIN_BLOCK)
                .stairs(ModBlocks.OCEAN_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.OCEAN_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.OCEAN_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_OCEAN_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.OCEAN_RESIN_CLUMP, ModItems.OCEAN_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.EMERALD_RESIN_BRICKS)
                .stairs(ModBlocks.EMERALD_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.EMERALD_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.EMERALD_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.EMERALD_RESIN_BLOCK)
                .stairs(ModBlocks.EMERALD_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.EMERALD_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.EMERALD_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_EMERALD_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.EMERALD_RESIN_CLUMP, ModItems.EMERALD_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.DUSK_RESIN_BRICKS)
                .stairs(ModBlocks.DUSK_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.DUSK_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.DUSK_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.DUSK_RESIN_BLOCK)
                .stairs(ModBlocks.DUSK_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.DUSK_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.DUSK_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_DUSK_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.DUSK_RESIN_CLUMP, ModItems.DUSK_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.DAYBREAK_RESIN_BRICKS)
                .stairs(ModBlocks.DAYBREAK_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.DAYBREAK_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.DAYBREAK_RESIN_BLOCK)
                .stairs(ModBlocks.DAYBREAK_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.DAYBREAK_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_DAYBREAK_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.DAYBREAK_RESIN_CLUMP, ModItems.DAYBREAK_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.SILT_RESIN_BRICKS)
                .stairs(ModBlocks.SILT_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.SILT_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.SILT_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.SILT_RESIN_BLOCK)
                .stairs(ModBlocks.SILT_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.SILT_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.SILT_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_SILT_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.SILT_RESIN_CLUMP, ModItems.SILT_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.GRAPHITE_RESIN_BRICKS)
                .stairs(ModBlocks.GRAPHITE_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.GRAPHITE_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.GRAPHITE_RESIN_BLOCK)
                .stairs(ModBlocks.GRAPHITE_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.GRAPHITE_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_GRAPHITE_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.GRAPHITE_RESIN_CLUMP, ModItems.GRAPHITE_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.OBSIDIAN_RESIN_BRICKS)
                .stairs(ModBlocks.OBSIDIAN_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.OBSIDIAN_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.OBSIDIAN_RESIN_BLOCK)
                .stairs(ModBlocks.OBSIDIAN_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.OBSIDIAN_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_OBSIDIAN_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.OBSIDIAN_RESIN_CLUMP, ModItems.OBSIDIAN_RESIN_CLUMP);

        blockStateModelGenerator.family(ModBlocks.COCOA_RESIN_BRICKS)
                .stairs(ModBlocks.COCOA_RESIN_BRICKS_STAIRS)
                .slab(ModBlocks.COCOA_RESIN_BRICKS_SLAB)
                .wall(ModBlocks.COCOA_RESIN_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.COCOA_RESIN_BLOCK)
                .stairs(ModBlocks.COCOA_RESIN_BLOCK_STAIRS)
                .slab(ModBlocks.COCOA_RESIN_BLOCK_SLAB)
                .wall(ModBlocks.COCOA_RESIN_BLOCK_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.CHISELED_COCOA_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.COCOA_RESIN_CLUMP, ModItems.COCOA_RESIN_CLUMP);


        blockStateModelGenerator.family(ModBlocks.POLISHED_RESIN)
                .stairs(ModBlocks.POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.POLISHED_RESIN_SLAB)
                .wall(ModBlocks.POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.BEETROOT_POLISHED_RESIN)
                .stairs(ModBlocks.BEETROOT_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.BEETROOT_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.BEETROOT_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.CARAMEL_POLISHED_RESIN)
                .stairs(ModBlocks.CARAMEL_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.CARAMEL_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.CARAMEL_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.LEMON_POLISHED_RESIN)
                .stairs(ModBlocks.LEMON_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.LEMON_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.LEMON_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.TOXIC_POLISHED_RESIN)
                .stairs(ModBlocks.TOXIC_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.TOXIC_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.TOXIC_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.EMERALD_POLISHED_RESIN)
                .stairs(ModBlocks.EMERALD_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.EMERALD_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.EMERALD_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.JADE_POLISHED_RESIN)
                .stairs(ModBlocks.JADE_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.JADE_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.JADE_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.OCEAN_POLISHED_RESIN)
                .stairs(ModBlocks.OCEAN_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.OCEAN_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.OCEAN_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.GLACIER_POLISHED_RESIN)
                .stairs(ModBlocks.GLACIER_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.GLACIER_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.GLACIER_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.BUBBLE_POLISHED_RESIN)
                .stairs(ModBlocks.BUBBLE_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.BUBBLE_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.BUBBLE_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.DUSK_POLISHED_RESIN)
                .stairs(ModBlocks.DUSK_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.DUSK_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.DUSK_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.CHORUS_POLISHED_RESIN)
                .stairs(ModBlocks.CHORUS_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.CHORUS_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.CHORUS_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.DAYBREAK_POLISHED_RESIN)
                .stairs(ModBlocks.DAYBREAK_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.DAYBREAK_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.DAYBREAK_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.SILT_POLISHED_RESIN)
                .stairs(ModBlocks.SILT_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.SILT_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.SILT_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.GRAPHITE_POLISHED_RESIN)
                .stairs(ModBlocks.GRAPHITE_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.GRAPHITE_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.GRAPHITE_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.OBSIDIAN_POLISHED_RESIN)
                .stairs(ModBlocks.OBSIDIAN_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.OBSIDIAN_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.OBSIDIAN_POLISHED_RESIN_WALL);
        blockStateModelGenerator.family(ModBlocks.COCOA_POLISHED_RESIN)
                .stairs(ModBlocks.COCOA_POLISHED_RESIN_STAIRS)
                .slab(ModBlocks.COCOA_POLISHED_RESIN_SLAB)
                .wall(ModBlocks.COCOA_POLISHED_RESIN_WALL);

        blockStateModelGenerator.family(ModBlocks.AMETHYST_TILES)
                .stairs(ModBlocks.AMETHYST_TILES_STAIRS)
                .slab(ModBlocks.AMETHYST_TILES_SLAB)
                .wall(ModBlocks.AMETHYST_TILES_WALL);
        blockStateModelGenerator.family(ModBlocks.AMETHYST_BRICKS)
                .stairs(ModBlocks.AMETHYST_BRICKS_STAIRS)
                .slab(ModBlocks.AMETHYST_BRICKS_SLAB)
                .wall(ModBlocks.AMETHYST_BRICKS_WALL);

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_AMETHYST_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.BUDDING_ABERRANT_AMETHYST);
        blockStateModelGenerator.createAmethystCluster(ModBlocks.SMALL_ABERRANT_AMETHYST_BUD);
        blockStateModelGenerator.createAmethystCluster(ModBlocks.MEDIUM_ABERRANT_AMETHYST_BUD);
        blockStateModelGenerator.createAmethystCluster(ModBlocks.LARGE_ABERRANT_AMETHYST_BUD);
        blockStateModelGenerator.createAmethystCluster(ModBlocks.ABERRANT_AMETHYST_CLUSTER);

        blockStateModelGenerator.family(ModBlocks.ABERRANT_AMETHYST_TILES)
                .stairs(ModBlocks.ABERRANT_AMETHYST_TILES_STAIRS)
                .slab(ModBlocks.ABERRANT_AMETHYST_TILES_SLAB)
                .wall(ModBlocks.ABERRANT_AMETHYST_TILES_WALL);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_AMETHYST_BRICKS)
                .stairs(ModBlocks.ABERRANT_AMETHYST_BRICKS_STAIRS)
                .slab(ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB)
                .wall(ModBlocks.ABERRANT_AMETHYST_BRICKS_WALL);

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_SOUL_SOIL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_SOUL_SAND);
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

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_OBSIDIAN);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_CRYING_OBSIDIAN);

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_NETHERRACK);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_NETHER_BRICKS)
                .stairs(ModBlocks.ABERRANT_NETHER_BRICKS_STAIRS)
                .slab(ModBlocks.ABERRANT_NETHER_BRICKS_SLAB)
                .wall(ModBlocks.ABERRANT_NETHER_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS)
                .stairs(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS)
                .stairs(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_STAIRS)
                .slab(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB)
                .wall(ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_WALL);
        blockStateModelGenerator.family(ModBlocks.ABERRANT_RED_NETHER_BRICKS)
                .stairs(ModBlocks.ABERRANT_RED_NETHER_BRICKS_STAIRS)
                .slab(ModBlocks.ABERRANT_RED_NETHER_BRICKS_SLAB)
                .wall(ModBlocks.ABERRANT_RED_NETHER_BRICKS_WALL);
        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_GLOWSTONE);

        registerRedstoneLamp(blockStateModelGenerator, ModBlocks.ABERRANT_REDSTONE_LAMP);

        blockStateModelGenerator.createRotatedPillarWithHorizontalVariant(ModBlocks.ABERRANT_OCHRE_FROGLIGHT, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
        blockStateModelGenerator.createRotatedPillarWithHorizontalVariant(ModBlocks.ABERRANT_VERDANT_FROGLIGHT, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);
        blockStateModelGenerator.createRotatedPillarWithHorizontalVariant(ModBlocks.ABERRANT_PEARLESCENT_FROGLIGHT, TexturedModel.COLUMN, TexturedModel.COLUMN_HORIZONTAL);

        blockStateModelGenerator.family(Blocks.NETHERITE_BLOCK)
                .fence(ModBlocks.NETHERITE_FENCE);

        // Custom Copper //

        ModBlocks.ABERRANT_COPPER_BARS.waxedMapping().forEach(blockStateModelGenerator::createBarsAndItem);
        ModBlocks.ABERRANT_COPPER_LANTERNS.waxedMapping().forEach(blockStateModelGenerator::createCopperLantern);
        ModBlocks.ABERRANT_COPPER_CHAINS.waxedMapping().forEach((block, waxed) -> {
            blockStateModelGenerator.createCopperChain(block, waxed);
            blockStateModelGenerator.createCopperChainItem(block.asItem(), waxed.asItem());
        });

        blockStateModelGenerator.family(ModBlocks.ABERRANT_CUT_COPPER)
                .stairs(ModBlocks.ABERRANT_CUT_COPPER_STAIRS)
                .slab(ModBlocks.ABERRANT_CUT_COPPER_SLAB);
        blockStateModelGenerator.copyModel(ModBlocks.ABERRANT_CUT_COPPER, ModBlocks.WAXED_ABERRANT_CUT_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.ABERRANT_CUT_COPPER_STAIRS, ModBlocks.WAXED_ABERRANT_CUT_COPPER_STAIRS);
        blockStateModelGenerator.copyModel(ModBlocks.ABERRANT_CUT_COPPER_SLAB, ModBlocks.WAXED_ABERRANT_CUT_COPPER_SLAB);

        blockStateModelGenerator.family(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER)
                .stairs(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_STAIRS)
                .slab(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_SLAB);
        blockStateModelGenerator.copyModel(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER, ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_STAIRS, ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER_STAIRS);
        blockStateModelGenerator.copyModel(ModBlocks.EXPOSED_ABERRANT_CUT_COPPER_SLAB, ModBlocks.WAXED_EXPOSED_ABERRANT_CUT_COPPER_SLAB);

        blockStateModelGenerator.family(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER)
                .stairs(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_STAIRS)
                .slab(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_SLAB);
        blockStateModelGenerator.copyModel(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER, ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_STAIRS, ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER_STAIRS);
        blockStateModelGenerator.copyModel(ModBlocks.WEATHERED_ABERRANT_CUT_COPPER_SLAB, ModBlocks.WAXED_WEATHERED_ABERRANT_CUT_COPPER_SLAB);

        blockStateModelGenerator.family(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER)
                .stairs(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_STAIRS)
                .slab(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_SLAB);
        blockStateModelGenerator.copyModel(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER, ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_STAIRS, ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER_STAIRS);
        blockStateModelGenerator.copyModel(ModBlocks.OXIDIZED_ABERRANT_CUT_COPPER_SLAB, ModBlocks.WAXED_OXIDIZED_ABERRANT_CUT_COPPER_SLAB);

        blockStateModelGenerator.createCopperBulb(ModBlocks.ABERRANT_COPPER_BULB);
        blockStateModelGenerator.copyCopperBulbModel(ModBlocks.ABERRANT_COPPER_BULB, ModBlocks.WAXED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.createCopperBulb(ModBlocks.EXPOSED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.copyCopperBulbModel(ModBlocks.EXPOSED_ABERRANT_COPPER_BULB, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.createCopperBulb(ModBlocks.WEATHERED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.copyCopperBulbModel(ModBlocks.WEATHERED_ABERRANT_COPPER_BULB, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.createCopperBulb(ModBlocks.OXIDIZED_ABERRANT_COPPER_BULB);
        blockStateModelGenerator.copyCopperBulbModel(ModBlocks.OXIDIZED_ABERRANT_COPPER_BULB, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_BULB);

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_COPPER_BLOCK);
        blockStateModelGenerator.copyModel(ModBlocks.ABERRANT_COPPER_BLOCK, ModBlocks.WAXED_ABERRANT_COPPER_BLOCK);
        blockStateModelGenerator.createTrivialCube(ModBlocks.EXPOSED_ABERRANT_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.EXPOSED_ABERRANT_COPPER, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER);
        blockStateModelGenerator.createTrivialCube(ModBlocks.WEATHERED_ABERRANT_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.WEATHERED_ABERRANT_COPPER, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER);
        blockStateModelGenerator.createTrivialCube(ModBlocks.OXIDIZED_ABERRANT_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.OXIDIZED_ABERRANT_COPPER, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER);

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.ABERRANT_CHISELED_COPPER, ModBlocks.WAXED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.createTrivialCube(ModBlocks.EXPOSED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.EXPOSED_ABERRANT_CHISELED_COPPER, ModBlocks.WAXED_EXPOSED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.createTrivialCube(ModBlocks.WEATHERED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.WEATHERED_ABERRANT_CHISELED_COPPER, ModBlocks.WAXED_WEATHERED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.createTrivialCube(ModBlocks.OXIDIZED_ABERRANT_CHISELED_COPPER);
        blockStateModelGenerator.copyModel(ModBlocks.OXIDIZED_ABERRANT_CHISELED_COPPER, ModBlocks.WAXED_OXIDIZED_ABERRANT_CHISELED_COPPER);

        blockStateModelGenerator.createDoor(ModBlocks.ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.copyDoorModel(ModBlocks.ABERRANT_COPPER_DOOR, ModBlocks.WAXED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.createDoor(ModBlocks.EXPOSED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.copyDoorModel(ModBlocks.EXPOSED_ABERRANT_COPPER_DOOR, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.createDoor(ModBlocks.WEATHERED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.copyDoorModel(ModBlocks.WEATHERED_ABERRANT_COPPER_DOOR, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.createDoor(ModBlocks.OXIDIZED_ABERRANT_COPPER_DOOR);
        blockStateModelGenerator.copyDoorModel(ModBlocks.OXIDIZED_ABERRANT_COPPER_DOOR, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_DOOR);

        blockStateModelGenerator.createTrapdoor(ModBlocks.ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.copyTrapdoorModel(ModBlocks.ABERRANT_COPPER_TRAPDOOR, ModBlocks.WAXED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.createTrapdoor(ModBlocks.EXPOSED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.copyTrapdoorModel(ModBlocks.EXPOSED_ABERRANT_COPPER_TRAPDOOR, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.createTrapdoor(ModBlocks.WEATHERED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.copyTrapdoorModel(ModBlocks.WEATHERED_ABERRANT_COPPER_TRAPDOOR, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.createTrapdoor(ModBlocks.OXIDIZED_ABERRANT_COPPER_TRAPDOOR);
        blockStateModelGenerator.copyTrapdoorModel(ModBlocks.OXIDIZED_ABERRANT_COPPER_TRAPDOOR, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_TRAPDOOR);

        blockStateModelGenerator.createTrivialCube(ModBlocks.ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.copyModel(ModBlocks.ABERRANT_COPPER_GRATE, ModBlocks.WAXED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.EXPOSED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.copyModel(ModBlocks.EXPOSED_ABERRANT_COPPER_GRATE, ModBlocks.WAXED_EXPOSED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.WEATHERED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.copyModel(ModBlocks.WEATHERED_ABERRANT_COPPER_GRATE, ModBlocks.WAXED_WEATHERED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.createTrivialCube(ModBlocks.OXIDIZED_ABERRANT_COPPER_GRATE);
        blockStateModelGenerator.copyModel(ModBlocks.OXIDIZED_ABERRANT_COPPER_GRATE, ModBlocks.WAXED_OXIDIZED_ABERRANT_COPPER_GRATE);

        registerResin(blockStateModelGenerator, ModBlocks.BRASS_POLISHED_RESIN, ModBlocks.BRASS_POLISHED_RESIN_STAIRS, ModBlocks.BRASS_POLISHED_RESIN_SLAB, ModBlocks.BRASS_POLISHED_RESIN_WALL, ModBlocks.BRASS_RESIN_BRICKS, ModBlocks.BRASS_RESIN_BRICKS_STAIRS, ModBlocks.BRASS_RESIN_BRICKS_SLAB, ModBlocks.BRASS_RESIN_BRICKS_WALL, ModBlocks.BRASS_RESIN_BLOCK, ModBlocks.BRASS_RESIN_BLOCK_STAIRS, ModBlocks.BRASS_RESIN_BLOCK_SLAB, ModBlocks.BRASS_RESIN_BLOCK_WALL, ModBlocks.CHISELED_BRASS_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.BRASS_RESIN_CLUMP, ModItems.BRASS_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.DANDELION_POLISHED_RESIN, ModBlocks.DANDELION_POLISHED_RESIN_STAIRS, ModBlocks.DANDELION_POLISHED_RESIN_SLAB, ModBlocks.DANDELION_POLISHED_RESIN_WALL, ModBlocks.DANDELION_RESIN_BRICKS, ModBlocks.DANDELION_RESIN_BRICKS_STAIRS, ModBlocks.DANDELION_RESIN_BRICKS_SLAB, ModBlocks.DANDELION_RESIN_BRICKS_WALL, ModBlocks.DANDELION_RESIN_BLOCK, ModBlocks.DANDELION_RESIN_BLOCK_STAIRS, ModBlocks.DANDELION_RESIN_BLOCK_SLAB, ModBlocks.DANDELION_RESIN_BLOCK_WALL, ModBlocks.CHISELED_DANDELION_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.DANDELION_RESIN_CLUMP, ModItems.DANDELION_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.BOG_POLISHED_RESIN, ModBlocks.BOG_POLISHED_RESIN_STAIRS, ModBlocks.BOG_POLISHED_RESIN_SLAB, ModBlocks.BOG_POLISHED_RESIN_WALL, ModBlocks.BOG_RESIN_BRICKS, ModBlocks.BOG_RESIN_BRICKS_STAIRS, ModBlocks.BOG_RESIN_BRICKS_SLAB, ModBlocks.BOG_RESIN_BRICKS_WALL, ModBlocks.BOG_RESIN_BLOCK, ModBlocks.BOG_RESIN_BLOCK_STAIRS, ModBlocks.BOG_RESIN_BLOCK_SLAB, ModBlocks.BOG_RESIN_BLOCK_WALL, ModBlocks.CHISELED_BOG_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.BOG_RESIN_CLUMP, ModItems.BOG_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.SCULK_POLISHED_RESIN, ModBlocks.SCULK_POLISHED_RESIN_STAIRS, ModBlocks.SCULK_POLISHED_RESIN_SLAB, ModBlocks.SCULK_POLISHED_RESIN_WALL, ModBlocks.SCULK_RESIN_BRICKS, ModBlocks.SCULK_RESIN_BRICKS_STAIRS, ModBlocks.SCULK_RESIN_BRICKS_SLAB, ModBlocks.SCULK_RESIN_BRICKS_WALL, ModBlocks.SCULK_RESIN_BLOCK, ModBlocks.SCULK_RESIN_BLOCK_STAIRS, ModBlocks.SCULK_RESIN_BLOCK_SLAB, ModBlocks.SCULK_RESIN_BLOCK_WALL, ModBlocks.CHISELED_SCULK_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.SCULK_RESIN_CLUMP, ModItems.SCULK_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.RETRO_POLISHED_RESIN, ModBlocks.RETRO_POLISHED_RESIN_STAIRS, ModBlocks.RETRO_POLISHED_RESIN_SLAB, ModBlocks.RETRO_POLISHED_RESIN_WALL, ModBlocks.RETRO_RESIN_BRICKS, ModBlocks.RETRO_RESIN_BRICKS_STAIRS, ModBlocks.RETRO_RESIN_BRICKS_SLAB, ModBlocks.RETRO_RESIN_BRICKS_WALL, ModBlocks.RETRO_RESIN_BLOCK, ModBlocks.RETRO_RESIN_BLOCK_STAIRS, ModBlocks.RETRO_RESIN_BLOCK_SLAB, ModBlocks.RETRO_RESIN_BLOCK_WALL, ModBlocks.CHISELED_RETRO_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.RETRO_RESIN_CLUMP, ModItems.RETRO_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.DUST_POLISHED_RESIN, ModBlocks.DUST_POLISHED_RESIN_STAIRS, ModBlocks.DUST_POLISHED_RESIN_SLAB, ModBlocks.DUST_POLISHED_RESIN_WALL, ModBlocks.DUST_RESIN_BRICKS, ModBlocks.DUST_RESIN_BRICKS_STAIRS, ModBlocks.DUST_RESIN_BRICKS_SLAB, ModBlocks.DUST_RESIN_BRICKS_WALL, ModBlocks.DUST_RESIN_BLOCK, ModBlocks.DUST_RESIN_BLOCK_STAIRS, ModBlocks.DUST_RESIN_BLOCK_SLAB, ModBlocks.DUST_RESIN_BLOCK_WALL, ModBlocks.CHISELED_DUST_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.DUST_RESIN_CLUMP, ModItems.DUST_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.BLOOD_POLISHED_RESIN, ModBlocks.BLOOD_POLISHED_RESIN_STAIRS, ModBlocks.BLOOD_POLISHED_RESIN_SLAB, ModBlocks.BLOOD_POLISHED_RESIN_WALL, ModBlocks.BLOOD_RESIN_BRICKS, ModBlocks.BLOOD_RESIN_BRICKS_STAIRS, ModBlocks.BLOOD_RESIN_BRICKS_SLAB, ModBlocks.BLOOD_RESIN_BRICKS_WALL, ModBlocks.BLOOD_RESIN_BLOCK, ModBlocks.BLOOD_RESIN_BLOCK_STAIRS, ModBlocks.BLOOD_RESIN_BLOCK_SLAB, ModBlocks.BLOOD_RESIN_BLOCK_WALL, ModBlocks.CHISELED_BLOOD_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.BLOOD_RESIN_CLUMP, ModItems.BLOOD_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.RUBY_POLISHED_RESIN, ModBlocks.RUBY_POLISHED_RESIN_STAIRS, ModBlocks.RUBY_POLISHED_RESIN_SLAB, ModBlocks.RUBY_POLISHED_RESIN_WALL, ModBlocks.RUBY_RESIN_BRICKS, ModBlocks.RUBY_RESIN_BRICKS_STAIRS, ModBlocks.RUBY_RESIN_BRICKS_SLAB, ModBlocks.RUBY_RESIN_BRICKS_WALL, ModBlocks.RUBY_RESIN_BLOCK, ModBlocks.RUBY_RESIN_BLOCK_STAIRS, ModBlocks.RUBY_RESIN_BLOCK_SLAB, ModBlocks.RUBY_RESIN_BLOCK_WALL, ModBlocks.CHISELED_RUBY_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.RUBY_RESIN_CLUMP, ModItems.RUBY_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.PEARL_POLISHED_RESIN, ModBlocks.PEARL_POLISHED_RESIN_STAIRS, ModBlocks.PEARL_POLISHED_RESIN_SLAB, ModBlocks.PEARL_POLISHED_RESIN_WALL, ModBlocks.PEARL_RESIN_BRICKS, ModBlocks.PEARL_RESIN_BRICKS_STAIRS, ModBlocks.PEARL_RESIN_BRICKS_SLAB, ModBlocks.PEARL_RESIN_BRICKS_WALL, ModBlocks.PEARL_RESIN_BLOCK, ModBlocks.PEARL_RESIN_BLOCK_STAIRS, ModBlocks.PEARL_RESIN_BLOCK_SLAB, ModBlocks.PEARL_RESIN_BLOCK_WALL, ModBlocks.CHISELED_PEARL_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.PEARL_RESIN_CLUMP, ModItems.PEARL_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.SNOWY_POLISHED_RESIN, ModBlocks.SNOWY_POLISHED_RESIN_STAIRS, ModBlocks.SNOWY_POLISHED_RESIN_SLAB, ModBlocks.SNOWY_POLISHED_RESIN_WALL, ModBlocks.SNOWY_RESIN_BRICKS, ModBlocks.SNOWY_RESIN_BRICKS_STAIRS, ModBlocks.SNOWY_RESIN_BRICKS_SLAB, ModBlocks.SNOWY_RESIN_BRICKS_WALL, ModBlocks.SNOWY_RESIN_BLOCK, ModBlocks.SNOWY_RESIN_BLOCK_STAIRS, ModBlocks.SNOWY_RESIN_BLOCK_SLAB, ModBlocks.SNOWY_RESIN_BLOCK_WALL, ModBlocks.CHISELED_SNOWY_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.SNOWY_RESIN_CLUMP, ModItems.SNOWY_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.SUBZERO_POLISHED_RESIN, ModBlocks.SUBZERO_POLISHED_RESIN_STAIRS, ModBlocks.SUBZERO_POLISHED_RESIN_SLAB, ModBlocks.SUBZERO_POLISHED_RESIN_WALL, ModBlocks.SUBZERO_RESIN_BRICKS, ModBlocks.SUBZERO_RESIN_BRICKS_STAIRS, ModBlocks.SUBZERO_RESIN_BRICKS_SLAB, ModBlocks.SUBZERO_RESIN_BRICKS_WALL, ModBlocks.SUBZERO_RESIN_BLOCK, ModBlocks.SUBZERO_RESIN_BLOCK_STAIRS, ModBlocks.SUBZERO_RESIN_BLOCK_SLAB, ModBlocks.SUBZERO_RESIN_BLOCK_WALL, ModBlocks.CHISELED_SUBZERO_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.SUBZERO_RESIN_CLUMP, ModItems.SUBZERO_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.GEM_POLISHED_RESIN, ModBlocks.GEM_POLISHED_RESIN_STAIRS, ModBlocks.GEM_POLISHED_RESIN_SLAB, ModBlocks.GEM_POLISHED_RESIN_WALL, ModBlocks.GEM_RESIN_BRICKS, ModBlocks.GEM_RESIN_BRICKS_STAIRS, ModBlocks.GEM_RESIN_BRICKS_SLAB, ModBlocks.GEM_RESIN_BRICKS_WALL, ModBlocks.GEM_RESIN_BLOCK, ModBlocks.GEM_RESIN_BLOCK_STAIRS, ModBlocks.GEM_RESIN_BLOCK_SLAB, ModBlocks.GEM_RESIN_BLOCK_WALL, ModBlocks.CHISELED_GEM_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.GEM_RESIN_CLUMP, ModItems.GEM_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.ROTTEN_POLISHED_RESIN, ModBlocks.ROTTEN_POLISHED_RESIN_STAIRS, ModBlocks.ROTTEN_POLISHED_RESIN_SLAB, ModBlocks.ROTTEN_POLISHED_RESIN_WALL, ModBlocks.ROTTEN_RESIN_BRICKS, ModBlocks.ROTTEN_RESIN_BRICKS_STAIRS, ModBlocks.ROTTEN_RESIN_BRICKS_SLAB, ModBlocks.ROTTEN_RESIN_BRICKS_WALL, ModBlocks.ROTTEN_RESIN_BLOCK, ModBlocks.ROTTEN_RESIN_BLOCK_STAIRS, ModBlocks.ROTTEN_RESIN_BLOCK_SLAB, ModBlocks.ROTTEN_RESIN_BLOCK_WALL, ModBlocks.CHISELED_ROTTEN_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.ROTTEN_RESIN_CLUMP, ModItems.ROTTEN_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.GRAPE_POLISHED_RESIN, ModBlocks.GRAPE_POLISHED_RESIN_STAIRS, ModBlocks.GRAPE_POLISHED_RESIN_SLAB, ModBlocks.GRAPE_POLISHED_RESIN_WALL, ModBlocks.GRAPE_RESIN_BRICKS, ModBlocks.GRAPE_RESIN_BRICKS_STAIRS, ModBlocks.GRAPE_RESIN_BRICKS_SLAB, ModBlocks.GRAPE_RESIN_BRICKS_WALL, ModBlocks.GRAPE_RESIN_BLOCK, ModBlocks.GRAPE_RESIN_BLOCK_STAIRS, ModBlocks.GRAPE_RESIN_BLOCK_SLAB, ModBlocks.GRAPE_RESIN_BLOCK_WALL, ModBlocks.CHISELED_GRAPE_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.GRAPE_RESIN_CLUMP, ModItems.GRAPE_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.REDSTONE_POLISHED_RESIN, ModBlocks.REDSTONE_POLISHED_RESIN_STAIRS, ModBlocks.REDSTONE_POLISHED_RESIN_SLAB, ModBlocks.REDSTONE_POLISHED_RESIN_WALL, ModBlocks.REDSTONE_RESIN_BRICKS, ModBlocks.REDSTONE_RESIN_BRICKS_STAIRS, ModBlocks.REDSTONE_RESIN_BRICKS_SLAB, ModBlocks.REDSTONE_RESIN_BRICKS_WALL, ModBlocks.REDSTONE_RESIN_BLOCK, ModBlocks.REDSTONE_RESIN_BLOCK_STAIRS, ModBlocks.REDSTONE_RESIN_BLOCK_SLAB, ModBlocks.REDSTONE_RESIN_BLOCK_WALL, ModBlocks.CHISELED_REDSTONE_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.REDSTONE_RESIN_CLUMP, ModItems.REDSTONE_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.COPPER_POLISHED_RESIN, ModBlocks.COPPER_POLISHED_RESIN_STAIRS, ModBlocks.COPPER_POLISHED_RESIN_SLAB, ModBlocks.COPPER_POLISHED_RESIN_WALL, ModBlocks.COPPER_RESIN_BRICKS, ModBlocks.COPPER_RESIN_BRICKS_STAIRS, ModBlocks.COPPER_RESIN_BRICKS_SLAB, ModBlocks.COPPER_RESIN_BRICKS_WALL, ModBlocks.COPPER_RESIN_BLOCK, ModBlocks.COPPER_RESIN_BLOCK_STAIRS, ModBlocks.COPPER_RESIN_BLOCK_SLAB, ModBlocks.COPPER_RESIN_BLOCK_WALL, ModBlocks.CHISELED_COPPER_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.COPPER_RESIN_CLUMP, ModItems.COPPER_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.SWEETBERRY_POLISHED_RESIN, ModBlocks.SWEETBERRY_POLISHED_RESIN_STAIRS, ModBlocks.SWEETBERRY_POLISHED_RESIN_SLAB, ModBlocks.SWEETBERRY_POLISHED_RESIN_WALL, ModBlocks.SWEETBERRY_RESIN_BRICKS, ModBlocks.SWEETBERRY_RESIN_BRICKS_STAIRS, ModBlocks.SWEETBERRY_RESIN_BRICKS_SLAB, ModBlocks.SWEETBERRY_RESIN_BRICKS_WALL, ModBlocks.SWEETBERRY_RESIN_BLOCK, ModBlocks.SWEETBERRY_RESIN_BLOCK_STAIRS, ModBlocks.SWEETBERRY_RESIN_BLOCK_SLAB, ModBlocks.SWEETBERRY_RESIN_BLOCK_WALL, ModBlocks.CHISELED_SWEETBERRY_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.SWEETBERRY_RESIN_CLUMP, ModItems.SWEETBERRY_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.KELP_POLISHED_RESIN, ModBlocks.KELP_POLISHED_RESIN_STAIRS, ModBlocks.KELP_POLISHED_RESIN_SLAB, ModBlocks.KELP_POLISHED_RESIN_WALL, ModBlocks.KELP_RESIN_BRICKS, ModBlocks.KELP_RESIN_BRICKS_STAIRS, ModBlocks.KELP_RESIN_BRICKS_SLAB, ModBlocks.KELP_RESIN_BRICKS_WALL, ModBlocks.KELP_RESIN_BLOCK, ModBlocks.KELP_RESIN_BLOCK_STAIRS, ModBlocks.KELP_RESIN_BLOCK_SLAB, ModBlocks.KELP_RESIN_BLOCK_WALL, ModBlocks.CHISELED_KELP_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.KELP_RESIN_CLUMP, ModItems.KELP_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.GLITTER_POLISHED_RESIN, ModBlocks.GLITTER_POLISHED_RESIN_STAIRS, ModBlocks.GLITTER_POLISHED_RESIN_SLAB, ModBlocks.GLITTER_POLISHED_RESIN_WALL, ModBlocks.GLITTER_RESIN_BRICKS, ModBlocks.GLITTER_RESIN_BRICKS_STAIRS, ModBlocks.GLITTER_RESIN_BRICKS_SLAB, ModBlocks.GLITTER_RESIN_BRICKS_WALL, ModBlocks.GLITTER_RESIN_BLOCK, ModBlocks.GLITTER_RESIN_BLOCK_STAIRS, ModBlocks.GLITTER_RESIN_BLOCK_SLAB, ModBlocks.GLITTER_RESIN_BLOCK_WALL, ModBlocks.CHISELED_GLITTER_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.GLITTER_RESIN_CLUMP, ModItems.GLITTER_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.BLAZE_POLISHED_RESIN, ModBlocks.BLAZE_POLISHED_RESIN_STAIRS, ModBlocks.BLAZE_POLISHED_RESIN_SLAB, ModBlocks.BLAZE_POLISHED_RESIN_WALL, ModBlocks.BLAZE_RESIN_BRICKS, ModBlocks.BLAZE_RESIN_BRICKS_STAIRS, ModBlocks.BLAZE_RESIN_BRICKS_SLAB, ModBlocks.BLAZE_RESIN_BRICKS_WALL, ModBlocks.BLAZE_RESIN_BLOCK, ModBlocks.BLAZE_RESIN_BLOCK_STAIRS, ModBlocks.BLAZE_RESIN_BLOCK_SLAB, ModBlocks.BLAZE_RESIN_BLOCK_WALL, ModBlocks.CHISELED_BLAZE_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.BLAZE_RESIN_CLUMP, ModItems.BLAZE_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.ZAP_POLISHED_RESIN, ModBlocks.ZAP_POLISHED_RESIN_STAIRS, ModBlocks.ZAP_POLISHED_RESIN_SLAB, ModBlocks.ZAP_POLISHED_RESIN_WALL, ModBlocks.ZAP_RESIN_BRICKS, ModBlocks.ZAP_RESIN_BRICKS_STAIRS, ModBlocks.ZAP_RESIN_BRICKS_SLAB, ModBlocks.ZAP_RESIN_BRICKS_WALL, ModBlocks.ZAP_RESIN_BLOCK, ModBlocks.ZAP_RESIN_BLOCK_STAIRS, ModBlocks.ZAP_RESIN_BLOCK_SLAB, ModBlocks.ZAP_RESIN_BLOCK_WALL, ModBlocks.CHISELED_ZAP_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.ZAP_RESIN_CLUMP, ModItems.ZAP_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.NIGHTWAY_POLISHED_RESIN, ModBlocks.NIGHTWAY_POLISHED_RESIN_STAIRS, ModBlocks.NIGHTWAY_POLISHED_RESIN_SLAB, ModBlocks.NIGHTWAY_POLISHED_RESIN_WALL, ModBlocks.NIGHTWAY_RESIN_BRICKS, ModBlocks.NIGHTWAY_RESIN_BRICKS_STAIRS, ModBlocks.NIGHTWAY_RESIN_BRICKS_SLAB, ModBlocks.NIGHTWAY_RESIN_BRICKS_WALL, ModBlocks.NIGHTWAY_RESIN_BLOCK, ModBlocks.NIGHTWAY_RESIN_BLOCK_STAIRS, ModBlocks.NIGHTWAY_RESIN_BLOCK_SLAB, ModBlocks.NIGHTWAY_RESIN_BLOCK_WALL, ModBlocks.CHISELED_NIGHTWAY_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.NIGHTWAY_RESIN_CLUMP, ModItems.NIGHTWAY_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.RIPE_POLISHED_RESIN, ModBlocks.RIPE_POLISHED_RESIN_STAIRS, ModBlocks.RIPE_POLISHED_RESIN_SLAB, ModBlocks.RIPE_POLISHED_RESIN_WALL, ModBlocks.RIPE_RESIN_BRICKS, ModBlocks.RIPE_RESIN_BRICKS_STAIRS, ModBlocks.RIPE_RESIN_BRICKS_SLAB, ModBlocks.RIPE_RESIN_BRICKS_WALL, ModBlocks.RIPE_RESIN_BLOCK, ModBlocks.RIPE_RESIN_BLOCK_STAIRS, ModBlocks.RIPE_RESIN_BLOCK_SLAB, ModBlocks.RIPE_RESIN_BLOCK_WALL, ModBlocks.CHISELED_RIPE_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.RIPE_RESIN_CLUMP, ModItems.RIPE_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.SLUDGE_POLISHED_RESIN, ModBlocks.SLUDGE_POLISHED_RESIN_STAIRS, ModBlocks.SLUDGE_POLISHED_RESIN_SLAB, ModBlocks.SLUDGE_POLISHED_RESIN_WALL, ModBlocks.SLUDGE_RESIN_BRICKS, ModBlocks.SLUDGE_RESIN_BRICKS_STAIRS, ModBlocks.SLUDGE_RESIN_BRICKS_SLAB, ModBlocks.SLUDGE_RESIN_BRICKS_WALL, ModBlocks.SLUDGE_RESIN_BLOCK, ModBlocks.SLUDGE_RESIN_BLOCK_STAIRS, ModBlocks.SLUDGE_RESIN_BLOCK_SLAB, ModBlocks.SLUDGE_RESIN_BLOCK_WALL, ModBlocks.CHISELED_SLUDGE_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.SLUDGE_RESIN_CLUMP, ModItems.SLUDGE_RESIN_CLUMP);

        registerResin(blockStateModelGenerator, ModBlocks.ARMADILLO_POLISHED_RESIN, ModBlocks.ARMADILLO_POLISHED_RESIN_STAIRS, ModBlocks.ARMADILLO_POLISHED_RESIN_SLAB, ModBlocks.ARMADILLO_POLISHED_RESIN_WALL, ModBlocks.ARMADILLO_RESIN_BRICKS, ModBlocks.ARMADILLO_RESIN_BRICKS_STAIRS, ModBlocks.ARMADILLO_RESIN_BRICKS_SLAB, ModBlocks.ARMADILLO_RESIN_BRICKS_WALL, ModBlocks.ARMADILLO_RESIN_BLOCK, ModBlocks.ARMADILLO_RESIN_BLOCK_STAIRS, ModBlocks.ARMADILLO_RESIN_BLOCK_SLAB, ModBlocks.ARMADILLO_RESIN_BLOCK_WALL, ModBlocks.CHISELED_ARMADILLO_RESIN_BRICKS);
        blockStateModelGenerator.createMultiface(ModBlocks.ARMADILLO_RESIN_CLUMP, ModItems.ARMADILLO_RESIN_CLUMP);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        itemModelGenerator.generateFlatItem(ModItems.KAOLIN_CLAY_BALL, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.MIDNIGHT_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TROWEL, ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ABERRANT_PASTE, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModBlocks.GOLD_CHAIN.asItem(), ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.BEETROOT_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CHORUS_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.LEMON_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GLACIER_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.CARAMEL_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.TOXIC_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.JADE_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BUBBLE_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OCEAN_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.EMERALD_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DUSK_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DAYBREAK_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SILT_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GRAPHITE_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.OBSIDIAN_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.COCOA_RESIN_BRICK, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.ABERRANT_AMETHYST_SHARD, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ABERRANT_NETHER_BRICK, ModelTemplates.FLAT_ITEM);

        itemModelGenerator.generateFlatItem(ModItems.BRASS_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DANDELION_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BOG_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SCULK_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RETRO_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.DUST_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BLOOD_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RUBY_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.PEARL_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SNOWY_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SUBZERO_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GEM_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ROTTEN_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GRAPE_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.REDSTONE_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.COPPER_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SWEETBERRY_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.KELP_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.GLITTER_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.BLAZE_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ZAP_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.NIGHTWAY_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.RIPE_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.SLUDGE_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
        itemModelGenerator.generateFlatItem(ModItems.ARMADILLO_RESIN_BRICK, ModelTemplates.FLAT_ITEM);
    }

    public void registerResin(BlockModelGenerators generator, Block polishedResin, Block polishedResinStairs, Block polishedResinSlab, Block polishedResinWall, Block resinBrick, Block resinBrickStairs, Block resinBrickSlab, Block resinBrickWall, Block resinBlock, Block resinBlockStairs, Block resinBlockSlab, Block resinBlockWall, Block chiseledResinBrick) {
        generator.family(polishedResin)
                .stairs(polishedResinStairs)
                .slab(polishedResinSlab)
                .wall(polishedResinWall);
        generator.family(resinBrick)
                .stairs(resinBrickStairs)
                .slab(resinBrickSlab)
                .wall(resinBrickWall);
        generator.family(resinBlock)
                .stairs(resinBlockStairs)
                .slab(resinBlockSlab)
                .wall(resinBlockWall);
        generator.createTrivialCube(chiseledResinBrick);
    }

    public void registerSeat(Block block, BlockModelGenerators generator) {
        // Modified TextureMap.sideTopBottom()
        TextureMapping textureMap = new TextureMapping().put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_side")).put(TextureSlot.TOP, TextureMapping.getBlockTexture(block, "_top")).put(TextureSlot.BOTTOM, Identifier.fromNamespaceAndPath(Bauen.MOD_ID, "block/seat_bottom"));

        MultiVariant weightedVariant = BlockModelGenerators.plainVariant(ModelTemplates.SLAB_BOTTOM.create(block, textureMap, generator.modelOutput));
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, weightedVariant));
    }

    // Modified from Minecraft Sandstone datagen (it's so ugly...)
    static final Map<Block, TexturedModel> SOUL_SANDSTONE_MODELS =
    Map.of(ModBlocks.SOUL_SANDSTONE, TexturedModel.TOP_BOTTOM_WITH_WALL.get(ModBlocks.SOUL_SANDSTONE),
            ModBlocks.SMOOTH_SOUL_SANDSTONE, TexturedModel.createAllSame(TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top")),
            ModBlocks.CUT_SOUL_SANDSTONE, TexturedModel.COLUMN.get(ModBlocks.SOUL_SANDSTONE).updateTextures(textureMap -> textureMap.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CUT_SOUL_SANDSTONE))),
            ModBlocks.CHISELED_SOUL_SANDSTONE, TexturedModel.COLUMN.get(ModBlocks.CHISELED_SOUL_SANDSTONE).updateTextures(textureMap -> {
                textureMap.put(TextureSlot.END, TextureMapping.getBlockTexture(ModBlocks.SOUL_SANDSTONE, "_top"));
                textureMap.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.CHISELED_SOUL_SANDSTONE));})
    );

    static final Map<Block, TexturedModel> ABERRANT_SOUL_SANDSTONE_MODELS =
    Map.of(ModBlocks.ABERRANT_SOUL_SANDSTONE, TexturedModel.TOP_BOTTOM_WITH_WALL.get(ModBlocks.ABERRANT_SOUL_SANDSTONE),
            ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE, TexturedModel.createAllSame(TextureMapping.getBlockTexture(ModBlocks.ABERRANT_SOUL_SANDSTONE, "_top")),
            ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE, TexturedModel.COLUMN.get(ModBlocks.ABERRANT_SOUL_SANDSTONE).updateTextures(textureMap -> textureMap.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE))),
            ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, TexturedModel.COLUMN.get(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE).updateTextures(textureMap -> {
                textureMap.put(TextureSlot.END, TextureMapping.getBlockTexture(ModBlocks.ABERRANT_SOUL_SANDSTONE, "_top"));
                textureMap.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE));})
    );

    public final BlockModelGenerators.BlockFamilyProvider registerSandstone(Block block, BlockModelGenerators generator, Map<Block, TexturedModel> models) {
        TexturedModel texturedModel = models.getOrDefault(block, TexturedModel.CUBE.get(block));
        return generator.new BlockFamilyProvider(texturedModel.getMapping()).fullBlock(block, texturedModel.getTemplate());
    }

    private void registerPumpkins(BlockModelGenerators generator) {
        TextureMapping textureMap = TextureMapping.column(ModBlocks.ABERRANT_PUMPKIN);
        generator.blockStateOutput.accept(generator.createSimpleBlock(ModBlocks.ABERRANT_PUMPKIN, plainVariant(ModelTemplates.CUBE_BOTTOM_TOP.create(ModBlocks.ABERRANT_PUMPKIN, textureMap, generator.modelOutput))));
        generator.createPumpkinVariant(ModBlocks.ABERRANT_CARVED_PUMPKIN, textureMap);
        generator.createPumpkinVariant(ModBlocks.ABERRANT_JACK_O_LANTERN, textureMap);
    }

    // need this AND manual model json
    private void registerGoldHoards(BlockModelGenerators generator) {
        TextureMapping textureMap = TextureMapping.cube(ModBlocks.GOLD_HOARD);
        MultiVariant weightedVariant = plainVariant(ModelTemplates.CUBE_ALL.create(ModBlocks.GOLD_HOARD_BLOCK, textureMap, generator.modelOutput));
        generator.blockStateOutput.accept(
            MultiVariantGenerator.dispatch(ModBlocks.GOLD_HOARD).with(
                PropertyDispatch.initial(BlockStateProperties.LAYERS).generate(
                        layers -> layers < 8 ? plainVariant(ModelLocationUtils.getModelLocation(ModBlocks.GOLD_HOARD, "_height" + layers * 2)) : weightedVariant
                )
            )
        );
        generator.registerSimpleItemModel(ModBlocks.GOLD_HOARD, ModelLocationUtils.getModelLocation(ModBlocks.GOLD_HOARD, "_height2"));
        generator.blockStateOutput.accept(generator.createSimpleBlock(ModBlocks.GOLD_HOARD_BLOCK, weightedVariant));
    }

    public final void registerCustomWoolAndCarpet(BlockModelGenerators generator, Block wool, Block carpet, Block stairs, Block slab) {
        generator.family(wool)
                .stairs(stairs)
                .slab(slab);
        MultiVariant weightedVariant = BlockModelGenerators.plainVariant(TexturedModel.CARPET.get(wool).create(carpet, generator.modelOutput));
        generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(carpet, weightedVariant));
    }

    private void registerRedstoneLamp(BlockModelGenerators generator, Block block) {
        MultiVariant weightedVariant = generator.plainVariant(TexturedModel.CUBE.create(block, generator.modelOutput));
        MultiVariant weightedVariant2 = generator.plainVariant(generator.createSuffixedVariant(block, "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube));
        generator.blockStateOutput.accept(MultiVariantGenerator.dispatch(block).with(generator.createBooleanModelDispatch(BlockStateProperties.LIT, weightedVariant2, weightedVariant)));
    }
}
