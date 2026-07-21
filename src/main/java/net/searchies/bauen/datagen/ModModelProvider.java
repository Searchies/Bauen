package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.Properties;
import net.searchies.bauen.block.ModBlocks;
import net.searchies.bauen.item.ModItems;

import static net.minecraft.client.data.BlockStateModelGenerator.createSingletonBlockState;
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

        blockStateModelGenerator.registerAxisRotated(ModBlocks.GOLD_CHAIN, createWeightedVariant(TexturedModel.TEMPLATE_CHAIN.upload(ModBlocks.GOLD_CHAIN, blockStateModelGenerator.modelCollector)));
        blockStateModelGenerator.registerBars(ModBlocks.GOLD_BARS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CUT_GOLD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CHISELED_GOLD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GOLD_GRATE);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.GOLD_TRAPDOOR);
        blockStateModelGenerator.registerDoor(ModBlocks.GOLD_DOOR);
        blockStateModelGenerator.registerLeafLitter(ModBlocks.GOLD_COINS);
        registerHoards(blockStateModelGenerator);
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

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ANDESITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_ANDESITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_ANDESITE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DIORITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_DIORITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_DIORITE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DRIPSTONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_DRIPSTONE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_DRIPSTONE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRANITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MOSSY_GRANITE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_GRANITE_BRICKS);

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OCEANSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OCEANSLATE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.OCEANSLATE_TILES);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POLISHED_OCEANSLATE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_OCEANSLATE_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.KELPY_OCEANSLATE_BRICKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.KAOLIN_CLAY_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIDNIGHT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.TROWEL, Models.HANDHELD);
    }

    private void registerHoards(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textureMap = TextureMap.all(ModBlocks.GOLD_HOARD);
        WeightedVariant weightedVariant = createWeightedVariant(Models.CUBE_ALL.upload(ModBlocks.GOLD_HOARD_BLOCK, textureMap, blockStateModelGenerator.modelCollector));
        blockStateModelGenerator.blockStateCollector.accept(
            VariantsBlockModelDefinitionCreator.of(ModBlocks.GOLD_HOARD).with(
                BlockStateVariantMap.models(Properties.LAYERS).generate(
                        layers -> layers < 8 ? createWeightedVariant(ModelIds.getBlockSubModelId(ModBlocks.GOLD_HOARD, "_height" + layers * 2)) : weightedVariant
                )
            )
        );
        blockStateModelGenerator.registerParentedItemModel(ModBlocks.GOLD_HOARD, ModelIds.getBlockSubModelId(ModBlocks.GOLD_HOARD, "_height2"));
        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(ModBlocks.GOLD_HOARD_BLOCK, weightedVariant));
    }
}
