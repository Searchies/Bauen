package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.searchies.bauen.block.ModBlocks;
import net.searchies.bauen.item.ModItems;

import static net.minecraft.client.data.BlockStateModelGenerator.createWeightedVariant;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_CHISELED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_CHISELED_BRICKS);

        blockStateModelGenerator.registerItemModel(ModBlocks.GOLD_CHAIN);
        blockStateModelGenerator.registerAxisRotated(ModBlocks.GOLD_CHAIN, createWeightedVariant(TexturedModel.TEMPLATE_CHAIN.upload(ModBlocks.GOLD_CHAIN, blockStateModelGenerator.modelCollector)));
        blockStateModelGenerator.registerBars(ModBlocks.GOLD_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CUT_GOLD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GOLD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_GRATE);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.GOLD_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.GOLD_DOOR);
        blockStateModelGenerator.registerLeafLitter(ModBlocks.GOLD_COINS);
        blockStateModelGenerator.registerLantern(ModBlocks.GOLD_LANTERN);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MIXED_COBBLESTONE);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INDUSTRIAL_IRON_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CUT_INDUSTRIAL_IRON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CARVED_INDUSTRIAL_IRON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.INDUSTRIAL_IRON_GRATE);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.INDUSTRIAL_IRON_DOOR);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_PACKED_MUD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_MUD_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_TUFF_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCULKED_DEEPSLATE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MIDNIGHT_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_MIDNIGHT_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_MIDNIGHT_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_MIDNIGHT_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KAOLIN_CLAY);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.TREATED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_TREATED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_TREATED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_TREATED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MIXED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_MIXED_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_MIXED_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CALCITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_CALCITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_CALCITE_BRICKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.KAOLIN_CLAY_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIDNIGHT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.TROWEL, Models.HANDHELD);
    }
}
