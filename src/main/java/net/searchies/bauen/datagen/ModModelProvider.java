package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModItems;

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
//        registerGoldHoards(blockStateModelGenerator);
//        GoldHoardBlock.LAYERS.getValues().forEach(layer -> {
//            blockStateModelGenerator.createWeightedVariant()
//        });
//        WeightedVariant weightedVariant = BlockStateModelGenerator.createWeightedVariant(Models.CUBE_BOTTOM_TOP.upload(Blocks.GRASS_BLOCK, "_snow", textureMap, this.modelCollector));

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

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CALCITE_BRICKS)
                .stairs(ModBlocks.CALCITE_BRICKS_STAIRS)
                .slab(ModBlocks.CALCITE_BRICKS_SLAB)
                .wall(ModBlocks.CALCITE_BRICKS_WALL);
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
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MOSSY_DIORITE_BRICKS)
                .stairs(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.MOSSY_DIORITE_BRICKS_WALL);
        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.CRACKED_DIORITE_BRICKS)
                .stairs(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS)
                .slab(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB)
                .wall(ModBlocks.CRACKED_DIORITE_BRICKS_WALL);

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.DRIPSTONE_BRICKS)
                .stairs(ModBlocks.DRIPSTONE_BRICKS_STAIRS)
                .slab(ModBlocks.DRIPSTONE_BRICKS_SLAB)
                .wall(ModBlocks.DRIPSTONE_BRICKS_WALL);
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
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.KAOLIN_CLAY_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.MIDNIGHT_BRICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.TROWEL, Models.HANDHELD);
        itemModelGenerator.register(ModBlocks.GOLD_CHAIN.asItem(), Models.GENERATED);
    }

    public void registerSeat(Block block, BlockStateModelGenerator generator) {
        // Modified TextureMap.sideTopBottom()
        TextureMap textureMap = new TextureMap().put(TextureKey.SIDE, TextureMap.getSubId(block, "_side")).put(TextureKey.TOP, TextureMap.getSubId(block, "_top")).put(TextureKey.BOTTOM, Identifier.of(Bauen.MOD_ID, "block/seat_bottom"));

        WeightedVariant weightedVariant = BlockStateModelGenerator.createWeightedVariant(Models.SLAB.upload(block, textureMap, generator.modelCollector));
        generator.blockStateCollector.accept(BlockStateModelGenerator.createSingletonBlockState(block, weightedVariant));
    }

//    private void registerGoldHoards(BlockStateModelGenerator blockStateModelGenerator) {
//        TextureMap textureMap = TextureMap.all(ModBlocks.GOLD_HOARD);
//        WeightedVariant weightedVariant = createWeightedVariant(Models.CUBE_ALL.upload(ModBlocks.GOLD_HOARD_BLOCK, textureMap, blockStateModelGenerator.modelCollector));
//        blockStateModelGenerator.blockStateCollector.accept(
//            VariantsBlockModelDefinitionCreator.of(ModBlocks.GOLD_HOARD).with(
//                BlockStateVariantMap.models(Properties.LAYERS).generate(
//                        layers -> layers < 8 ? createWeightedVariant(ModelIds.getBlockSubModelId(ModBlocks.GOLD_HOARD, "_height" + layers * 2)) : weightedVariant
//                )
//            )
//        );
//        blockStateModelGenerator.registerParentedItemModel(ModBlocks.GOLD_HOARD, ModelIds.getBlockSubModelId(ModBlocks.GOLD_HOARD, "_height2"));
//        blockStateModelGenerator.blockStateCollector.accept(createSingletonBlockState(ModBlocks.GOLD_HOARD_BLOCK, weightedVariant));
//    }
}
