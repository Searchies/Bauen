package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        return new RecipeGenerator(registries, exporter) {
            @Override
            public void generate() {

                // CUSTOM BRICK BLOCKS //

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICKS)
                    .input(Blocks.BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_BRICKS))
                    .criterion(hasItem(ModBlocks.MOSSY_BRICKS), conditionsFromItem(ModBlocks.MOSSY_BRICKS))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICKS_SLAB, ModBlocks.MOSSY_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICKS_WALL, ModBlocks.MOSSY_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_BRICKS)
                    .input(ModBlocks.CHISELED_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_CHISELED_BRICKS))
                    .criterion(hasItem(ModBlocks.MOSSY_CHISELED_BRICKS), conditionsFromItem(ModBlocks.MOSSY_CHISELED_BRICKS))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_BRICKS_WALL, ModBlocks.MOSSY_CHISELED_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_BRICKS, 0.1F, 200
                )
                .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_BRICKS))
                    .criterion(hasItem(ModBlocks.CRACKED_BRICKS), conditionsFromItem(ModBlocks.CRACKED_BRICKS))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICKS_SLAB, ModBlocks.CRACKED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICKS_WALL, ModBlocks.CRACKED_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.CHISELED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_BRICKS, 0.1F, 200
                )
                .criterion(hasItem(ModBlocks.CHISELED_BRICKS), conditionsFromItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_CHISELED_BRICKS))
                    .criterion(hasItem(ModBlocks.CRACKED_CHISELED_BRICKS), conditionsFromItem(ModBlocks.CRACKED_CHISELED_BRICKS))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_BRICKS_WALL, ModBlocks.CRACKED_CHISELED_BRICKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRICKS, Blocks.BRICKS);
                createStairsRecipe(ModBlocks.CHISELED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CHISELED_BRICKS))
                    .criterion(hasItem(ModBlocks.CHISELED_BRICKS), conditionsFromItem(ModBlocks.CHISELED_BRICKS))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRICKS_SLAB, ModBlocks.CHISELED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRICKS_WALL, ModBlocks.CHISELED_BRICKS);

                createStairsRecipe(ModBlocks.ICE_STAIRS, Ingredient.ofItem(Blocks.ICE))
                    .criterion(hasItem(Blocks.ICE), conditionsFromItem(Blocks.ICE))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_SLAB, Blocks.ICE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_WALL, Blocks.ICE);

                createStairsRecipe(ModBlocks.PACKED_ICE_STAIRS, Ingredient.ofItem(Blocks.PACKED_ICE))
                    .criterion(hasItem(Blocks.PACKED_ICE), conditionsFromItem(Blocks.PACKED_ICE))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_SLAB, Blocks.PACKED_ICE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_WALL, Blocks.PACKED_ICE);

                createStairsRecipe(ModBlocks.MUD_STAIRS, Ingredient.ofItem(Blocks.MUD))
                    .criterion(hasItem(Blocks.MUD), conditionsFromItem(Blocks.MUD))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_SLAB, Blocks.MUD);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_WALL, Blocks.MUD);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_PACKED_MUD, 1)
                    .input(Blocks.PACKED_MUD)
                    .input(Items.VINE)
                    .criterion("has_packed_mud", conditionsFromItem(Blocks.PACKED_MUD))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_PACKED_MUD_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_PACKED_MUD))
                    .criterion(hasItem(ModBlocks.MOSSY_PACKED_MUD), conditionsFromItem(ModBlocks.MOSSY_PACKED_MUD))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_PACKED_MUD_SLAB, ModBlocks.MOSSY_PACKED_MUD);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_PACKED_MUD_WALL, ModBlocks.MOSSY_PACKED_MUD);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS, 4)
                    .input('#', ModBlocks.MOSSY_PACKED_MUD)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.MOSSY_PACKED_MUD), conditionsFromItem(ModBlocks.MOSSY_PACKED_MUD))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_MUD_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_MUD_BRICKS))
                    .criterion(hasItem(ModBlocks.MOSSY_MUD_BRICKS), conditionsFromItem(ModBlocks.MOSSY_MUD_BRICKS))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS_SLAB, ModBlocks.MOSSY_MUD_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS_WALL, ModBlocks.MOSSY_MUD_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TUFF_BRICKS, 1)
                    .input(Blocks.TUFF_BRICKS)
                    .input(Items.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_TUFF_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_TUFF_BRICKS))
                    .criterion(hasItem(ModBlocks.MOSSY_TUFF_BRICKS), conditionsFromItem(ModBlocks.MOSSY_TUFF_BRICKS))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TUFF_BRICKS_SLAB, ModBlocks.MOSSY_TUFF_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TUFF_BRICKS_WALL, ModBlocks.MOSSY_TUFF_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                                Ingredient.ofItem(Blocks.TUFF_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.CRACKED_TUFF_BRICKS, 0.1F, 200
                        )
                        .criterion(hasItem(Blocks.TUFF_BRICKS), conditionsFromItem(Blocks.TUFF_BRICKS))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_TUFF_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_TUFF_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_TUFF_BRICKS), conditionsFromItem(ModBlocks.CRACKED_TUFF_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_TUFF_BRICKS_SLAB, ModBlocks.CRACKED_TUFF_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_TUFF_BRICKS_WALL, ModBlocks.CRACKED_TUFF_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULKED_DEEPSLATE_BRICKS, 1)
                    .input(Blocks.DEEPSLATE_BRICKS)
                    .input(Items.SCULK)
                    .criterion("has_deepslate_bricks", conditionsFromItem(Blocks.DEEPSLATE_BRICKS))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.SCULKED_DEEPSLATE_BRICKS))
                    .criterion(hasItem(ModBlocks.SCULKED_DEEPSLATE_BRICKS), conditionsFromItem(ModBlocks.SCULKED_DEEPSLATE_BRICKS))
                    .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB, ModBlocks.SCULKED_DEEPSLATE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL, ModBlocks.SCULKED_DEEPSLATE_BRICKS);

                // CUSTOM GOLD BLOCKS //

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.GOLD_CHAIN)
                    .input('I', Items.GOLD_INGOT)
                    .input('N', Items.GOLD_NUGGET)
                    .pattern("N")
                    .pattern("I")
                    .pattern("N")
                    .criterion("has_gold_nugget", conditionsFromItem(Items.GOLD_NUGGET))
                    .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                    .offerTo(exporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.GOLD_LANTERN)
                    .input('#', Items.TORCH)
                    .input('X', Items.GOLD_NUGGET)
                    .pattern("XXX")
                    .pattern("X#X")
                    .pattern("XXX")
                    .criterion("has_gold_nugget", conditionsFromItem(Items.GOLD_NUGGET))
                    .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                    .offerTo(exporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.GOLD_BARS, 16)
                    .input('#', Items.GOLD_INGOT)
                    .pattern("###")
                    .pattern("###")
                    .criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
                    .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD, Blocks.GOLD_BLOCK, 9);
                createStairsRecipe(ModBlocks.CUT_GOLD_STAIRS, Ingredient.ofItem(ModBlocks.CUT_GOLD))
                        .criterion(hasItem(ModBlocks.CUT_GOLD), conditionsFromItem(ModBlocks.CUT_GOLD))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD_SLAB, ModBlocks.CUT_GOLD);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD_WALL, ModBlocks.CUT_GOLD);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GOLD, Blocks.GOLD_BLOCK, 4);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_TRAPDOOR, Items.GOLD_INGOT);
                offerGrateRecipe(ModBlocks.GOLD_GRATE, Blocks.GOLD_BLOCK);
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(Items.GOLD_NUGGET), RecipeCategory.MISC, ModBlocks.GOLD_COINS , 0.1F, 200)
                    .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                    .offerTo(exporter);
                createDoorRecipe(ModBlocks.GOLD_DOOR, Ingredient.ofItem(Items.GOLD_INGOT))
                    .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                    .offerTo(exporter);
//                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_HOARD, 8)
//                    .input('#', ModBlocks.GOLD_COINS)
//                    .pattern("##")
//                    .pattern("##")
//                    .criterion(hasItem(ModBlocks.GOLD_COINS), conditionsFromItem(ModBlocks.GOLD_COINS))
//                    .offerTo(exporter);

                // INDUSTRIAL IRON BLOCKS //

                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_BLOCK, Items.IRON_INGOT);
                createStairsRecipe(ModBlocks.INDUSTRIAL_IRON_STAIRS, Ingredient.ofItem(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                        .criterion(hasItem(ModBlocks.INDUSTRIAL_IRON_BLOCK), conditionsFromItem(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_SLAB, ModBlocks.INDUSTRIAL_IRON_BLOCK);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_WALL, ModBlocks.INDUSTRIAL_IRON_BLOCK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_INDUSTRIAL_IRON, ModBlocks.INDUSTRIAL_IRON_BLOCK, 4);
                createStairsRecipe(ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS, Ingredient.ofItem(ModBlocks.CUT_INDUSTRIAL_IRON))
                        .criterion(hasItem(ModBlocks.CUT_INDUSTRIAL_IRON), conditionsFromItem(ModBlocks.CUT_INDUSTRIAL_IRON))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_INDUSTRIAL_IRON_SLAB, ModBlocks.CUT_INDUSTRIAL_IRON);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_INDUSTRIAL_IRON_WALL, ModBlocks.CUT_INDUSTRIAL_IRON);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARVED_INDUSTRIAL_IRON, ModBlocks.INDUSTRIAL_IRON_BLOCK, 4);
                offerGrateRecipe(ModBlocks.INDUSTRIAL_IRON_GRATE, ModBlocks.INDUSTRIAL_IRON_BLOCK);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_TRAPDOOR, ModBlocks.INDUSTRIAL_IRON_BLOCK);
                createDoorRecipe(ModBlocks.INDUSTRIAL_IRON_DOOR, Ingredient.ofItem(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                    .criterion(hasItem(ModBlocks.INDUSTRIAL_IRON_BLOCK), conditionsFromItem(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                    .offerTo(exporter);

                // STONE STUFF //

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_COBBLESTONE, 2)
                        .input(Blocks.COBBLED_DEEPSLATE)
                        .input(Blocks.COBBLESTONE)
                        .criterion("has_cobblestone", conditionsFromItem(Items.CLAY_BALL))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.MIXED_COBBLESTONE_STAIRS, Ingredient.ofItem(ModBlocks.MIXED_COBBLESTONE))
                        .criterion(hasItem(ModBlocks.MIXED_COBBLESTONE), conditionsFromItem(ModBlocks.MIXED_COBBLESTONE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_COBBLESTONE_SLAB, ModBlocks.MIXED_COBBLESTONE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_COBBLESTONE_WALL, ModBlocks.MIXED_COBBLESTONE);

                // CLAY STUFF //

                createShapeless(RecipeCategory.MISC, ModItems.KAOLIN_CLAY_BALL, 4)
                    .input(Items.CLAY_BALL, 2)
                    .input(Items.AMETHYST_SHARD)
                    .criterion("has_clay_ball", conditionsFromItem(Items.CLAY_BALL))
                    .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KAOLIN_CLAY, ModItems.KAOLIN_CLAY_BALL);
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(ModItems.KAOLIN_CLAY_BALL), RecipeCategory.MISC, ModItems.MIDNIGHT_BRICK, 0.3F, 200)
                    .criterion(hasItem(ModItems.KAOLIN_CLAY_BALL), conditionsFromItem(ModItems.KAOLIN_CLAY_BALL))
                    .offerTo(exporter);

                // MIDNIGHT BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIDNIGHT_BRICKS, 4)
                    .input('#', ModItems.MIDNIGHT_BRICK)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModItems.MIDNIGHT_BRICK), conditionsFromItem(ModItems.MIDNIGHT_BRICK))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MIDNIGHT_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MIDNIGHT_BRICKS))
                        .criterion(hasItem(ModBlocks.MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.MIDNIGHT_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIDNIGHT_BRICKS_SLAB, ModBlocks.MIDNIGHT_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIDNIGHT_BRICKS_WALL, ModBlocks.MIDNIGHT_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIDNIGHT_BRICKS)
                    .input(ModBlocks.MIDNIGHT_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_MIDNIGHT_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.MOSSY_MIDNIGHT_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB, ModBlocks.MOSSY_MIDNIGHT_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL, ModBlocks.MOSSY_MIDNIGHT_BRICKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MIDNIGHT_BRICKS, ModBlocks.MIDNIGHT_BRICKS);
                createStairsRecipe(ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                        .criterion(hasItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CHISELED_MIDNIGHT_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL, ModBlocks.CHISELED_MIDNIGHT_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS)
                    .input(ModBlocks.CHISELED_MIDNIGHT_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.MIDNIGHT_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_MIDNIGHT_BRICKS, 0.1F, 200
                )
                .criterion(hasItem(ModBlocks.MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.MIDNIGHT_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_MIDNIGHT_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.CRACKED_MIDNIGHT_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CRACKED_MIDNIGHT_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL, ModBlocks.CRACKED_MIDNIGHT_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS, 0.1F, 200
                )
                .criterion(hasItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);

                // MIXED BRICKS //

                CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItem(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREATED_BRICKS, 0.1F, 200)
                    .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                    .offerTo(exporter, getBlastingItemPath(Blocks.BRICKS));
                createStairsRecipe(ModBlocks.TREATED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.TREATED_BRICKS))
                        .criterion(hasItem(ModBlocks.TREATED_BRICKS), conditionsFromItem(ModBlocks.TREATED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREATED_BRICKS_SLAB, ModBlocks.TREATED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREATED_BRICKS_WALL, ModBlocks.TREATED_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TREATED_BRICKS)
                    .input(ModBlocks.TREATED_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_TREATED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_TREATED_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_TREATED_BRICKS), conditionsFromItem(ModBlocks.MOSSY_TREATED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TREATED_BRICKS_SLAB, ModBlocks.MOSSY_TREATED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TREATED_BRICKS_WALL, ModBlocks.MOSSY_TREATED_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.TREATED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_TREATED_BRICKS, 0.1F, 200)
                    .criterion(hasItem(ModBlocks.TREATED_BRICKS), conditionsFromItem(ModBlocks.TREATED_BRICKS))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_TREATED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_TREATED_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_TREATED_BRICKS), conditionsFromItem(ModBlocks.CRACKED_TREATED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_TREATED_BRICKS_SLAB, ModBlocks.CRACKED_TREATED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_TREATED_BRICKS_WALL, ModBlocks.CRACKED_TREATED_BRICKS);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TREATED_BRICKS, ModBlocks.TREATED_BRICKS);
                createStairsRecipe(ModBlocks.CHISELED_TREATED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CHISELED_TREATED_BRICKS))
                        .criterion(hasItem(ModBlocks.CHISELED_TREATED_BRICKS), conditionsFromItem(ModBlocks.CHISELED_TREATED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TREATED_BRICKS_SLAB, ModBlocks.CHISELED_TREATED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TREATED_BRICKS_WALL, ModBlocks.CHISELED_TREATED_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS)
                    .input(ModBlocks.CHISELED_TREATED_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS), conditionsFromItem(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.CHISELED_TREATED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_TREATED_BRICKS, 0.1F, 200)
                    .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS), conditionsFromItem(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_BRICKS, 4)
                    .input(ModBlocks.TREATED_BRICKS)
                    .input(Blocks.BRICKS)
                    .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MIXED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MIXED_BRICKS))
                        .criterion(hasItem(ModBlocks.MIXED_BRICKS), conditionsFromItem(ModBlocks.MIXED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_BRICKS_SLAB, ModBlocks.MIXED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_BRICKS_WALL, ModBlocks.MIXED_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIXED_BRICKS)
                    .input(ModBlocks.MIXED_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_MIXED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_MIXED_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_MIXED_BRICKS), conditionsFromItem(ModBlocks.MOSSY_MIXED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIXED_BRICKS_SLAB, ModBlocks.MOSSY_MIXED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIXED_BRICKS_WALL, ModBlocks.MOSSY_MIXED_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.MIXED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_MIXED_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.MIXED_BRICKS), conditionsFromItem(ModBlocks.MIXED_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_MIXED_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_MIXED_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_MIXED_BRICKS), conditionsFromItem(ModBlocks.CRACKED_MIXED_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MIXED_BRICKS_SLAB, ModBlocks.CRACKED_MIXED_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MIXED_BRICKS_WALL, ModBlocks.CRACKED_MIXED_BRICKS);

                // CALCITE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE, 4)
                    .input('#', Blocks.CALCITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.CALCITE), conditionsFromItem(Blocks.CALCITE))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE, Blocks.CALCITE);
                createStairsRecipe(ModBlocks.POLISHED_CALCITE_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_CALCITE))
                        .criterion(hasItem(ModBlocks.POLISHED_CALCITE), conditionsFromItem(ModBlocks.POLISHED_CALCITE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB, ModBlocks.POLISHED_CALCITE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_WALL, ModBlocks.POLISHED_CALCITE);


                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS, 4)
                    .input('#', ModBlocks.POLISHED_CALCITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.POLISHED_CALCITE), conditionsFromItem(ModBlocks.POLISHED_CALCITE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.CALCITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CALCITE_BRICKS))
                        .criterion(hasItem(ModBlocks.CALCITE_BRICKS), conditionsFromItem(ModBlocks.CALCITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS_SLAB, ModBlocks.CALCITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS_WALL, ModBlocks.CALCITE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS, 4)
                    .input('#', ModBlocks.CALCITE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.CALCITE_BRICKS), conditionsFromItem(ModBlocks.CALCITE_BRICKS))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS, ModBlocks.CALCITE_BRICKS);
                createStairsRecipe(ModBlocks.POLISHED_CALCITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_CALCITE_BRICKS))
                        .criterion(hasItem(ModBlocks.POLISHED_CALCITE_BRICKS), conditionsFromItem(ModBlocks.POLISHED_CALCITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS_SLAB, ModBlocks.POLISHED_CALCITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS_WALL, ModBlocks.POLISHED_CALCITE_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CALCITE_BRICKS)
                    .input(ModBlocks.CALCITE_BRICKS)
                    .input(Blocks.PALE_MOSS_BLOCK)
                    .criterion(hasItem(Blocks.PALE_MOSS_BLOCK), conditionsFromItem(Blocks.PALE_MOSS_BLOCK))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_CALCITE_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_CALCITE_BRICKS), conditionsFromItem(ModBlocks.MOSSY_CALCITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CALCITE_BRICKS_SLAB, ModBlocks.MOSSY_CALCITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CALCITE_BRICKS_WALL, ModBlocks.MOSSY_CALCITE_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.CALCITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CALCITE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.CALCITE_BRICKS), conditionsFromItem(ModBlocks.CALCITE_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_CALCITE_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_CALCITE_BRICKS), conditionsFromItem(ModBlocks.CRACKED_CALCITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CALCITE_BRICKS_SLAB, ModBlocks.CRACKED_CALCITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CALCITE_BRICKS_WALL, ModBlocks.CRACKED_CALCITE_BRICKS);

                // ANDESITE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS, 4)
                    .input('#', Blocks.POLISHED_ANDESITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.POLISHED_ANDESITE), conditionsFromItem(Blocks.POLISHED_ANDESITE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.ANDESITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.ANDESITE_BRICKS))
                        .criterion(hasItem(ModBlocks.ANDESITE_BRICKS), conditionsFromItem(ModBlocks.ANDESITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS_SLAB, ModBlocks.ANDESITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS_WALL, ModBlocks.ANDESITE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS, 4)
                    .input('#', ModBlocks.ANDESITE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.ANDESITE_BRICKS), conditionsFromItem(ModBlocks.ANDESITE_BRICKS))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS, ModBlocks.ANDESITE_BRICKS);
                createStairsRecipe(ModBlocks.POLISHED_ANDESITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_ANDESITE_BRICKS))
                        .criterion(hasItem(ModBlocks.POLISHED_ANDESITE_BRICKS), conditionsFromItem(ModBlocks.POLISHED_ANDESITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB, ModBlocks.POLISHED_ANDESITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS_WALL, ModBlocks.POLISHED_ANDESITE_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_ANDESITE_BRICKS)
                    .input(ModBlocks.ANDESITE_BRICKS)
                    .input(Blocks.VINE)
                    .criterion(hasItem(Blocks.VINE), conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_ANDESITE_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_ANDESITE_BRICKS), conditionsFromItem(ModBlocks.MOSSY_ANDESITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB, ModBlocks.MOSSY_ANDESITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_ANDESITE_BRICKS_WALL, ModBlocks.MOSSY_ANDESITE_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.ANDESITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_ANDESITE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.ANDESITE_BRICKS), conditionsFromItem(ModBlocks.ANDESITE_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_ANDESITE_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_ANDESITE_BRICKS), conditionsFromItem(ModBlocks.CRACKED_ANDESITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB, ModBlocks.CRACKED_ANDESITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ANDESITE_BRICKS_WALL, ModBlocks.CRACKED_ANDESITE_BRICKS);

                // DIORITE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS, 4)
                    .input('#', Blocks.POLISHED_DIORITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.POLISHED_DIORITE), conditionsFromItem(Blocks.POLISHED_DIORITE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.DIORITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.DIORITE_BRICKS))
                        .criterion(hasItem(ModBlocks.DIORITE_BRICKS), conditionsFromItem(ModBlocks.DIORITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS_SLAB, ModBlocks.DIORITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS_WALL, ModBlocks.DIORITE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS, 4)
                    .input('#', ModBlocks.DIORITE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.DIORITE_BRICKS), conditionsFromItem(ModBlocks.DIORITE_BRICKS))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS, ModBlocks.DIORITE_BRICKS);
                createStairsRecipe(ModBlocks.POLISHED_DIORITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_DIORITE_BRICKS))
                        .criterion(hasItem(ModBlocks.POLISHED_DIORITE_BRICKS), conditionsFromItem(ModBlocks.POLISHED_DIORITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS_SLAB, ModBlocks.POLISHED_DIORITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS_WALL, ModBlocks.POLISHED_DIORITE_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DIORITE_BRICKS)
                    .input(ModBlocks.DIORITE_BRICKS)
                    .input(Blocks.VINE)
                    .criterion(hasItem(Blocks.VINE), conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_DIORITE_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_DIORITE_BRICKS), conditionsFromItem(ModBlocks.MOSSY_DIORITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DIORITE_BRICKS_SLAB, ModBlocks.MOSSY_DIORITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DIORITE_BRICKS_WALL, ModBlocks.MOSSY_DIORITE_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.DIORITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_DIORITE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.DIORITE_BRICKS), conditionsFromItem(ModBlocks.DIORITE_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_DIORITE_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_DIORITE_BRICKS), conditionsFromItem(ModBlocks.CRACKED_DIORITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DIORITE_BRICKS_SLAB, ModBlocks.CRACKED_DIORITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DIORITE_BRICKS_WALL, ModBlocks.CRACKED_DIORITE_BRICKS);

                // DRIPSTONE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE, 4)
                    .input('#', Blocks.DRIPSTONE_BLOCK)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.DRIPSTONE_BLOCK), conditionsFromItem(Blocks.DRIPSTONE_BLOCK))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
                createStairsRecipe(ModBlocks.POLISHED_DRIPSTONE_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_DRIPSTONE))
                        .criterion(hasItem(ModBlocks.POLISHED_DRIPSTONE), conditionsFromItem(ModBlocks.POLISHED_DRIPSTONE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_SLAB, ModBlocks.POLISHED_DRIPSTONE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_WALL, ModBlocks.POLISHED_DRIPSTONE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS, 4)
                    .input('#', ModBlocks.POLISHED_DRIPSTONE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.POLISHED_DRIPSTONE), conditionsFromItem(ModBlocks.POLISHED_DRIPSTONE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.DRIPSTONE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.DRIPSTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.DRIPSTONE_BRICKS), conditionsFromItem(ModBlocks.DRIPSTONE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS_SLAB, ModBlocks.DRIPSTONE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS_WALL, ModBlocks.DRIPSTONE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS, 4)
                    .input('#', ModBlocks.DRIPSTONE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.DRIPSTONE_BRICKS), conditionsFromItem(ModBlocks.DRIPSTONE_BRICKS))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS);
                createStairsRecipe(ModBlocks.POLISHED_DRIPSTONE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_DRIPSTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.POLISHED_DRIPSTONE_BRICKS), conditionsFromItem(ModBlocks.POLISHED_DRIPSTONE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB, ModBlocks.POLISHED_DRIPSTONE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS_WALL, ModBlocks.POLISHED_DRIPSTONE_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DRIPSTONE_BRICKS)
                    .input(ModBlocks.DRIPSTONE_BRICKS)
                    .input(Blocks.VINE)
                    .criterion(hasItem(Blocks.VINE), conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_DRIPSTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_DRIPSTONE_BRICKS), conditionsFromItem(ModBlocks.MOSSY_DRIPSTONE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB, ModBlocks.MOSSY_DRIPSTONE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL, ModBlocks.MOSSY_DRIPSTONE_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.DRIPSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_DRIPSTONE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.DRIPSTONE_BRICKS), conditionsFromItem(ModBlocks.DRIPSTONE_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_DRIPSTONE_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_DRIPSTONE_BRICKS), conditionsFromItem(ModBlocks.CRACKED_DRIPSTONE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB, ModBlocks.CRACKED_DRIPSTONE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL, ModBlocks.CRACKED_DRIPSTONE_BRICKS);

                // GRANITE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS, 4)
                    .input('#', Blocks.POLISHED_GRANITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.POLISHED_GRANITE), conditionsFromItem(Blocks.POLISHED_GRANITE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.GRANITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.GRANITE_BRICKS))
                        .criterion(hasItem(ModBlocks.GRANITE_BRICKS), conditionsFromItem(ModBlocks.GRANITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS_SLAB, ModBlocks.GRANITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS_WALL, ModBlocks.GRANITE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS, 4)
                    .input('#', ModBlocks.GRANITE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.GRANITE_BRICKS), conditionsFromItem(ModBlocks.GRANITE_BRICKS))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS, ModBlocks.GRANITE_BRICKS);
                createStairsRecipe(ModBlocks.POLISHED_GRANITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_GRANITE_BRICKS))
                        .criterion(hasItem(ModBlocks.POLISHED_GRANITE_BRICKS), conditionsFromItem(ModBlocks.POLISHED_GRANITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS_SLAB, ModBlocks.POLISHED_GRANITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS_WALL, ModBlocks.POLISHED_GRANITE_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_GRANITE_BRICKS)
                    .input(ModBlocks.GRANITE_BRICKS)
                    .input(Blocks.VINE)
                    .criterion(hasItem(Blocks.VINE), conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.MOSSY_GRANITE_BRICKS))
                        .criterion(hasItem(ModBlocks.MOSSY_GRANITE_BRICKS), conditionsFromItem(ModBlocks.MOSSY_GRANITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_GRANITE_BRICKS_SLAB, ModBlocks.MOSSY_GRANITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_GRANITE_BRICKS_WALL, ModBlocks.MOSSY_GRANITE_BRICKS);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.GRANITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_GRANITE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.GRANITE_BRICKS), conditionsFromItem(ModBlocks.GRANITE_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_GRANITE_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_GRANITE_BRICKS), conditionsFromItem(ModBlocks.CRACKED_GRANITE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_GRANITE_BRICKS_SLAB, ModBlocks.CRACKED_GRANITE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_GRANITE_BRICKS_WALL, ModBlocks.CRACKED_GRANITE_BRICKS);

                // OCEANSLATE //

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE, 4)
                    .input(Items.COPPER_NUGGET, 2)
                    .input(Blocks.DEEPSLATE, 2)
                    .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.OCEANSLATE_STAIRS, Ingredient.ofItem(ModBlocks.OCEANSLATE))
                        .criterion(hasItem(ModBlocks.OCEANSLATE), conditionsFromItem(ModBlocks.OCEANSLATE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_SLAB, ModBlocks.OCEANSLATE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_WALL, ModBlocks.OCEANSLATE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_BRICKS, 4)
                    .input('#', ModBlocks.POLISHED_OCEANSLATE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.POLISHED_OCEANSLATE), conditionsFromItem(ModBlocks.POLISHED_OCEANSLATE))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.OCEANSLATE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.OCEANSLATE_BRICKS))
                        .criterion(hasItem(ModBlocks.OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_BRICKS_SLAB, ModBlocks.OCEANSLATE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_BRICKS_WALL, ModBlocks.OCEANSLATE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES, 4)
                    .input('#', ModBlocks.OCEANSLATE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.OCEANSLATE_BRICKS))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES, ModBlocks.OCEANSLATE);
                createStairsRecipe(ModBlocks.OCEANSLATE_TILES_STAIRS, Ingredient.ofItem(ModBlocks.OCEANSLATE_TILES))
                        .criterion(hasItem(ModBlocks.OCEANSLATE_TILES), conditionsFromItem(ModBlocks.OCEANSLATE_TILES))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES_SLAB, ModBlocks.OCEANSLATE_TILES);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES_WALL, ModBlocks.OCEANSLATE_TILES);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE, 4)
                    .input('#', ModBlocks.OCEANSLATE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.OCEANSLATE), conditionsFromItem(ModBlocks.OCEANSLATE))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE, ModBlocks.OCEANSLATE);
                createStairsRecipe(ModBlocks.POLISHED_OCEANSLATE_STAIRS, Ingredient.ofItem(ModBlocks.POLISHED_OCEANSLATE))
                        .criterion(hasItem(ModBlocks.POLISHED_OCEANSLATE), conditionsFromItem(ModBlocks.POLISHED_OCEANSLATE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE_SLAB, ModBlocks.POLISHED_OCEANSLATE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE_WALL, ModBlocks.POLISHED_OCEANSLATE);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.OCEANSLATE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_OCEANSLATE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.OCEANSLATE_BRICKS))
                .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_OCEANSLATE_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.CRACKED_OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB, ModBlocks.CRACKED_OCEANSLATE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL, ModBlocks.CRACKED_OCEANSLATE_BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_OCEANSLATE_BRICKS)
                    .input(ModBlocks.OCEANSLATE_BRICKS)
                    .input(Blocks.KELP)
                    .criterion(hasItem(Blocks.KELP), conditionsFromItem(Blocks.KELP))
                    .offerTo(exporter);
                createStairsRecipe(ModBlocks.KELPY_OCEANSLATE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.KELPY_OCEANSLATE_BRICKS))
                        .criterion(hasItem(ModBlocks.KELPY_OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.KELPY_OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB, ModBlocks.KELPY_OCEANSLATE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_OCEANSLATE_BRICKS_WALL, ModBlocks.KELPY_OCEANSLATE_BRICKS);

                // SEATS //
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_SEAT, 4)
                        .input('W', Blocks.RED_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.RED_WOOL), conditionsFromItem(Blocks.RED_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_SEAT, 4)
                        .input('W', Blocks.ORANGE_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.ORANGE_WOOL), conditionsFromItem(Blocks.ORANGE_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_SEAT, 4)
                        .input('W', Blocks.YELLOW_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.YELLOW_WOOL), conditionsFromItem(Blocks.YELLOW_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_SEAT, 4)
                        .input('W', Blocks.LIME_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.LIME_WOOL), conditionsFromItem(Blocks.LIME_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_SEAT, 4)
                        .input('W', Blocks.GREEN_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.GREEN_WOOL), conditionsFromItem(Blocks.GREEN_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_SEAT, 4)
                        .input('W', Blocks.CYAN_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.CYAN_WOOL), conditionsFromItem(Blocks.CYAN_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_SEAT, 4)
                        .input('W', Blocks.LIGHT_BLUE_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.LIGHT_BLUE_WOOL), conditionsFromItem(Blocks.LIGHT_BLUE_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_SEAT, 4)
                        .input('W', Blocks.BLUE_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.BLUE_WOOL), conditionsFromItem(Blocks.BLUE_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SEAT, 4)
                        .input('W', Blocks.PINK_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.PINK_WOOL), conditionsFromItem(Blocks.PINK_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_SEAT, 4)
                        .input('W', Blocks.MAGENTA_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.MAGENTA_WOOL), conditionsFromItem(Blocks.MAGENTA_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_SEAT, 4)
                        .input('W', Blocks.PURPLE_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.PURPLE_WOOL), conditionsFromItem(Blocks.PURPLE_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_SEAT, 4)
                        .input('W', Blocks.BROWN_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.BROWN_WOOL), conditionsFromItem(Blocks.BROWN_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_SEAT, 4)
                        .input('W', Blocks.LIGHT_GRAY_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.LIGHT_GRAY_WOOL), conditionsFromItem(Blocks.LIGHT_GRAY_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_SEAT, 4)
                        .input('W', Blocks.GRAY_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.GRAY_WOOL), conditionsFromItem(Blocks.GRAY_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_SEAT, 4)
                        .input('W', Blocks.BLACK_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.BLACK_WOOL), conditionsFromItem(Blocks.BLACK_WOOL))
                        .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_SEAT, 4)
                        .input('W', Blocks.WHITE_WOOL)
                        .input('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .criterion(hasItem(Blocks.WHITE_WOOL), conditionsFromItem(Blocks.WHITE_WOOL))
                        .offerTo(exporter);

                List<Item> list = List.of(Items.BLACK_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.CYAN_DYE, Items.GRAY_DYE, Items.GREEN_DYE, Items.LIGHT_BLUE_DYE, Items.LIGHT_GRAY_DYE, Items.LIME_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.PINK_DYE, Items.PURPLE_DYE, Items.RED_DYE, Items.YELLOW_DYE, Items.WHITE_DYE);
                List<Item> list2 = List.of(ModBlocks.BLACK_SEAT.asItem(), ModBlocks.BLUE_SEAT.asItem(), ModBlocks.BROWN_SEAT.asItem(), ModBlocks.CYAN_SEAT.asItem(), ModBlocks.GRAY_SEAT.asItem(), ModBlocks.GREEN_SEAT.asItem(), ModBlocks.LIGHT_BLUE_SEAT.asItem(), ModBlocks.LIGHT_GRAY_SEAT.asItem(), ModBlocks.LIME_SEAT.asItem(), ModBlocks.MAGENTA_SEAT.asItem(), ModBlocks.ORANGE_SEAT.asItem(), ModBlocks.PINK_SEAT.asItem(), ModBlocks.PURPLE_SEAT.asItem(), ModBlocks.RED_SEAT.asItem(), ModBlocks.YELLOW_SEAT.asItem(), ModBlocks.WHITE_SEAT.asItem());
                offerDyeableRecipes(list, list2, "seat_dye", RecipeCategory.BUILDING_BLOCKS);

                // TROWEL //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TROWEL)
                    .input('I', Items.IRON_INGOT)
                    .input('S', Items.STICK)
                    .pattern(" I")
                    .pattern("S ")
                    .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);

                // ABERRANT //

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ABERRANT_PASTE, 8)
                    .input(Items.GLOW_BERRIES)
                    .input(Items.AMETHYST_SHARD)
                    .input(Items.GLOW_INK_SAC)
                    .criterion(hasItem(Items.GLOW_BERRIES), conditionsFromItem(Items.GLOW_BERRIES))
                    .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT)
                    .input(ModItems.ABERRANT_PASTE, 4)
                    .criterion(hasItem(ModItems.ABERRANT_PASTE), conditionsFromItem(ModItems.ABERRANT_PASTE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SEA_LANTERN, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.SEA_LANTERN)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.SEA_LANTERN), conditionsFromItem(Blocks.SEA_LANTERN))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_DARK_PRISMARINE, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', Blocks.DARK_PRISMARINE)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(Blocks.DARK_PRISMARINE), conditionsFromItem(Blocks.DARK_PRISMARINE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ABERRANT_DARK_PRISMARINE_STAIRS, Ingredient.ofItem(ModBlocks.ABERRANT_DARK_PRISMARINE))
                        .criterion(hasItem(ModBlocks.ABERRANT_DARK_PRISMARINE), conditionsFromItem(ModBlocks.ABERRANT_DARK_PRISMARINE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB, ModBlocks.ABERRANT_DARK_PRISMARINE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_DARK_PRISMARINE_WALL, ModBlocks.ABERRANT_DARK_PRISMARINE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', Blocks.PRISMARINE)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(Blocks.PRISMARINE), conditionsFromItem(Blocks.PRISMARINE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ABERRANT_PRISMARINE_STAIRS, Ingredient.ofItem(ModBlocks.ABERRANT_PRISMARINE))
                        .criterion(hasItem(ModBlocks.ABERRANT_PRISMARINE), conditionsFromItem(ModBlocks.ABERRANT_PRISMARINE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_SLAB, ModBlocks.ABERRANT_PRISMARINE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_WALL, ModBlocks.ABERRANT_PRISMARINE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_BRICKS, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', Blocks.PRISMARINE_BRICKS)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(Blocks.PRISMARINE_BRICKS), conditionsFromItem(Blocks.PRISMARINE_BRICKS))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ABERRANT_PRISMARINE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.ABERRANT_PRISMARINE_BRICKS))
                        .criterion(hasItem(ModBlocks.ABERRANT_PRISMARINE_BRICKS), conditionsFromItem(ModBlocks.ABERRANT_PRISMARINE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB, ModBlocks.ABERRANT_PRISMARINE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', ModBlocks.OCEANSLATE)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(ModBlocks.OCEANSLATE), conditionsFromItem(ModBlocks.OCEANSLATE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ABERRANT_OCEANSLATE_STAIRS, Ingredient.ofItem(ModBlocks.ABERRANT_OCEANSLATE))
                        .criterion(hasItem(ModBlocks.ABERRANT_OCEANSLATE), conditionsFromItem(ModBlocks.ABERRANT_OCEANSLATE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_SLAB, ModBlocks.ABERRANT_OCEANSLATE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_WALL, ModBlocks.ABERRANT_OCEANSLATE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_POLISHED_OCEANSLATE, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', ModBlocks.POLISHED_OCEANSLATE)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(ModBlocks.POLISHED_OCEANSLATE), conditionsFromItem(ModBlocks.POLISHED_OCEANSLATE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_STAIRS, Ingredient.ofItem(ModBlocks.ABERRANT_POLISHED_OCEANSLATE))
                        .criterion(hasItem(ModBlocks.ABERRANT_POLISHED_OCEANSLATE), conditionsFromItem(ModBlocks.ABERRANT_POLISHED_OCEANSLATE))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB, ModBlocks.ABERRANT_POLISHED_OCEANSLATE);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_POLISHED_OCEANSLATE_WALL, ModBlocks.ABERRANT_POLISHED_OCEANSLATE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_TILES, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', ModBlocks.OCEANSLATE_TILES)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(ModBlocks.OCEANSLATE_TILES), conditionsFromItem(ModBlocks.OCEANSLATE_TILES))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ABERRANT_OCEANSLATE_TILES_STAIRS, Ingredient.ofItem(ModBlocks.ABERRANT_OCEANSLATE_TILES))
                        .criterion(hasItem(ModBlocks.ABERRANT_OCEANSLATE_TILES), conditionsFromItem(ModBlocks.ABERRANT_OCEANSLATE_TILES))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB, ModBlocks.ABERRANT_OCEANSLATE_TILES);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_TILES_WALL, ModBlocks.ABERRANT_OCEANSLATE_TILES);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', ModBlocks.OCEANSLATE_BRICKS)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(ModBlocks.OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.ABERRANT_OCEANSLATE_BRICKS))
                        .criterion(hasItem(ModBlocks.ABERRANT_OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.ABERRANT_OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB, ModBlocks.ABERRANT_OCEANSLATE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS_WALL, ModBlocks.ABERRANT_OCEANSLATE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', ModBlocks.CRACKED_OCEANSLATE_BRICKS)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(ModBlocks.CRACKED_OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.CRACKED_OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS))
                        .criterion(hasItem(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_SLAB, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_WALL, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS, 8)
                        .input('P', ModItems.ABERRANT_PASTE)
                        .input('B', ModBlocks.KELPY_OCEANSLATE_BRICKS)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .criterion(hasItem(ModBlocks.KELPY_OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.KELPY_OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_STAIRS, Ingredient.ofItem(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS))
                        .criterion(hasItem(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS))
                        .offerTo(exporter);
                offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS);
                offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_WALL, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS);

                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE, Blocks.SOUL_SAND);
                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_SLAB,
                        Ingredient.ofItems(ModBlocks.SOUL_SANDSTONE, ModBlocks.CHISELED_SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.SOUL_SANDSTONE), conditionsFromItem(ModBlocks.SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.CHISELED_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.CHISELED_SOUL_SANDSTONE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.SOUL_SANDSTONE_STAIRS,
                        Ingredient.ofItems(ModBlocks.SOUL_SANDSTONE, ModBlocks.CHISELED_SOUL_SANDSTONE, ModBlocks.CUT_SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.SOUL_SANDSTONE), conditionsFromItem(ModBlocks.SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.CHISELED_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.CHISELED_SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.CUT_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.CUT_SOUL_SANDSTONE))
                        .offerTo(exporter);
                offerWallRecipe(RecipeCategory.DECORATIONS, ModBlocks.SOUL_SANDSTONE_WALL, ModBlocks.SOUL_SANDSTONE);
                offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE_SLAB);
                offerCutCopperRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);

                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(ModBlocks.SOUL_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SOUL_SANDSTONE.asItem(),0.1f, 200)
                    .criterion(hasItem(ModBlocks.SOUL_SANDSTONE), conditionsFromItem(ModBlocks.SOUL_SANDSTONE))
                    .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_SLAB, ModBlocks.SOUL_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_STAIRS, ModBlocks.SOUL_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.SOUL_SANDSTONE_WALL, ModBlocks.SOUL_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, ModBlocks.SMOOTH_SOUL_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, ModBlocks.SMOOTH_SOUL_SANDSTONE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.TERRACOTTA), conditionsFromItem(Blocks.TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.RED_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.RED_WOOL), conditionsFromItem(Blocks.RED_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_RED_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_RED_WOOL), conditionsFromItem(ModBlocks.ABERRANT_RED_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.RED_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.RED_CONCRETE), conditionsFromItem(Blocks.RED_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.RED_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.RED_CONCRETE_POWDER), conditionsFromItem(Blocks.RED_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.RED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.RED_TERRACOTTA), conditionsFromItem(Blocks.RED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.RED_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.RED_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.RED_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.ORANGE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.ORANGE_WOOL), conditionsFromItem(Blocks.ORANGE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_ORANGE_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_ORANGE_WOOL), conditionsFromItem(ModBlocks.ABERRANT_ORANGE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.ORANGE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.ORANGE_CONCRETE), conditionsFromItem(Blocks.ORANGE_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.ORANGE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.ORANGE_CONCRETE_POWDER), conditionsFromItem(Blocks.ORANGE_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.ORANGE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.ORANGE_TERRACOTTA), conditionsFromItem(Blocks.ORANGE_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.ORANGE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.ORANGE_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.ORANGE_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.YELLOW_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.YELLOW_WOOL), conditionsFromItem(Blocks.YELLOW_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_YELLOW_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_YELLOW_WOOL), conditionsFromItem(ModBlocks.ABERRANT_YELLOW_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.YELLOW_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.YELLOW_CONCRETE), conditionsFromItem(Blocks.YELLOW_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.YELLOW_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.YELLOW_CONCRETE_POWDER), conditionsFromItem(Blocks.YELLOW_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.YELLOW_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.YELLOW_TERRACOTTA), conditionsFromItem(Blocks.YELLOW_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.YELLOW_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.YELLOW_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.YELLOW_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIME_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIME_WOOL), conditionsFromItem(Blocks.LIME_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_LIME_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_LIME_WOOL), conditionsFromItem(ModBlocks.ABERRANT_LIME_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIME_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIME_CONCRETE), conditionsFromItem(Blocks.LIME_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIME_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIME_CONCRETE_POWDER), conditionsFromItem(Blocks.LIME_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIME_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIME_TERRACOTTA), conditionsFromItem(Blocks.LIME_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIME_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIME_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.LIME_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GREEN_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GREEN_WOOL), conditionsFromItem(Blocks.GREEN_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_GREEN_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_GREEN_WOOL), conditionsFromItem(ModBlocks.ABERRANT_GREEN_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GREEN_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GREEN_CONCRETE), conditionsFromItem(Blocks.GREEN_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GREEN_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GREEN_CONCRETE_POWDER), conditionsFromItem(Blocks.GREEN_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GREEN_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GREEN_TERRACOTTA), conditionsFromItem(Blocks.GREEN_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GREEN_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GREEN_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.GREEN_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.CYAN_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.CYAN_WOOL), conditionsFromItem(Blocks.CYAN_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_CYAN_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_CYAN_WOOL), conditionsFromItem(ModBlocks.ABERRANT_CYAN_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.CYAN_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.CYAN_CONCRETE), conditionsFromItem(Blocks.CYAN_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.CYAN_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.CYAN_CONCRETE_POWDER), conditionsFromItem(Blocks.CYAN_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.CYAN_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.CYAN_TERRACOTTA), conditionsFromItem(Blocks.CYAN_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.CYAN_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.CYAN_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.CYAN_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_BLUE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_BLUE_WOOL), conditionsFromItem(Blocks.LIGHT_BLUE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_LIGHT_BLUE_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL), conditionsFromItem(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_BLUE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_BLUE_CONCRETE), conditionsFromItem(Blocks.LIGHT_BLUE_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_BLUE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_BLUE_CONCRETE_POWDER), conditionsFromItem(Blocks.LIGHT_BLUE_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_BLUE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_BLUE_TERRACOTTA), conditionsFromItem(Blocks.LIGHT_BLUE_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLUE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLUE_WOOL), conditionsFromItem(Blocks.BLUE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_BLUE_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_BLUE_WOOL), conditionsFromItem(ModBlocks.ABERRANT_BLUE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLUE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLUE_CONCRETE), conditionsFromItem(Blocks.BLUE_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLUE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLUE_CONCRETE_POWDER), conditionsFromItem(Blocks.BLUE_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLUE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLUE_TERRACOTTA), conditionsFromItem(Blocks.BLUE_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLUE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLUE_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.BLUE_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PINK_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PINK_WOOL), conditionsFromItem(Blocks.PINK_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_PINK_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_PINK_WOOL), conditionsFromItem(ModBlocks.ABERRANT_PINK_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PINK_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PINK_CONCRETE), conditionsFromItem(Blocks.PINK_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PINK_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PINK_CONCRETE_POWDER), conditionsFromItem(Blocks.PINK_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PINK_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PINK_TERRACOTTA), conditionsFromItem(Blocks.PINK_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PINK_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PINK_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.PINK_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.MAGENTA_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.MAGENTA_WOOL), conditionsFromItem(Blocks.MAGENTA_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_MAGENTA_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_MAGENTA_WOOL), conditionsFromItem(ModBlocks.ABERRANT_MAGENTA_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.MAGENTA_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.MAGENTA_CONCRETE), conditionsFromItem(Blocks.MAGENTA_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.MAGENTA_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.MAGENTA_CONCRETE_POWDER), conditionsFromItem(Blocks.MAGENTA_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.MAGENTA_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.MAGENTA_TERRACOTTA), conditionsFromItem(Blocks.MAGENTA_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.MAGENTA_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.MAGENTA_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.MAGENTA_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PURPLE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PURPLE_WOOL), conditionsFromItem(Blocks.PURPLE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_PURPLE_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_PURPLE_WOOL), conditionsFromItem(ModBlocks.ABERRANT_PURPLE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PURPLE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PURPLE_CONCRETE), conditionsFromItem(Blocks.PURPLE_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PURPLE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PURPLE_CONCRETE_POWDER), conditionsFromItem(Blocks.PURPLE_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PURPLE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PURPLE_TERRACOTTA), conditionsFromItem(Blocks.PURPLE_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PURPLE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PURPLE_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.PURPLE_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BROWN_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BROWN_WOOL), conditionsFromItem(Blocks.BROWN_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_BROWN_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_BROWN_WOOL), conditionsFromItem(ModBlocks.ABERRANT_BROWN_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BROWN_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BROWN_CONCRETE), conditionsFromItem(Blocks.BROWN_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BROWN_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BROWN_CONCRETE_POWDER), conditionsFromItem(Blocks.BROWN_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BROWN_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BROWN_TERRACOTTA), conditionsFromItem(Blocks.BROWN_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BROWN_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BROWN_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.BROWN_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLACK_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLACK_WOOL), conditionsFromItem(Blocks.BLACK_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_BLACK_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_BLACK_WOOL), conditionsFromItem(ModBlocks.ABERRANT_BLACK_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLACK_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLACK_CONCRETE), conditionsFromItem(Blocks.BLACK_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLACK_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLACK_CONCRETE_POWDER), conditionsFromItem(Blocks.BLACK_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLACK_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLACK_TERRACOTTA), conditionsFromItem(Blocks.BLACK_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLACK_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLACK_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.BLACK_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GRAY_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GRAY_WOOL), conditionsFromItem(Blocks.GRAY_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_GRAY_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_GRAY_WOOL), conditionsFromItem(ModBlocks.ABERRANT_GRAY_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GRAY_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GRAY_CONCRETE), conditionsFromItem(Blocks.GRAY_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GRAY_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GRAY_CONCRETE_POWDER), conditionsFromItem(Blocks.GRAY_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GRAY_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GRAY_TERRACOTTA), conditionsFromItem(Blocks.GRAY_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GRAY_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GRAY_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.GRAY_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_GRAY_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_GRAY_WOOL), conditionsFromItem(Blocks.LIGHT_GRAY_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_LIGHT_GRAY_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL), conditionsFromItem(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_GRAY_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_GRAY_CONCRETE), conditionsFromItem(Blocks.LIGHT_GRAY_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_GRAY_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_GRAY_CONCRETE_POWDER), conditionsFromItem(Blocks.LIGHT_GRAY_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_GRAY_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_GRAY_TERRACOTTA), conditionsFromItem(Blocks.LIGHT_GRAY_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_WOOL, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.WHITE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.WHITE_WOOL), conditionsFromItem(Blocks.WHITE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_SEAT, 4)
                    .input('W', ModBlocks.ABERRANT_WHITE_WOOL)
                    .input('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .criterion(hasItem(ModBlocks.ABERRANT_WHITE_WOOL), conditionsFromItem(ModBlocks.ABERRANT_WHITE_WOOL))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_CONCRETE, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.WHITE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.WHITE_CONCRETE), conditionsFromItem(Blocks.WHITE_CONCRETE))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_CONCRETE_POWER, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.WHITE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.WHITE_CONCRETE_POWDER), conditionsFromItem(Blocks.WHITE_CONCRETE_POWDER))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.WHITE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.WHITE_TERRACOTTA), conditionsFromItem(Blocks.WHITE_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_GLAZED_TERRACOTTA, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.WHITE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.WHITE_GLAZED_TERRACOTTA), conditionsFromItem(Blocks.WHITE_GLAZED_TERRACOTTA))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.RED_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.RED_CARPET), conditionsFromItem(Blocks.RED_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.ORANGE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.ORANGE_CARPET), conditionsFromItem(Blocks.ORANGE_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.YELLOW_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.YELLOW_CARPET), conditionsFromItem(Blocks.YELLOW_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIME_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIME_CARPET), conditionsFromItem(Blocks.LIME_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GREEN_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GREEN_CARPET), conditionsFromItem(Blocks.GREEN_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.CYAN_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.CYAN_CARPET), conditionsFromItem(Blocks.CYAN_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_BLUE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_BLUE_CARPET), conditionsFromItem(Blocks.LIGHT_BLUE_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLUE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLUE_CARPET), conditionsFromItem(Blocks.BLUE_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PINK_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PINK_CARPET), conditionsFromItem(Blocks.PINK_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.MAGENTA_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.MAGENTA_CARPET), conditionsFromItem(Blocks.MAGENTA_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.PURPLE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.PURPLE_CARPET), conditionsFromItem(Blocks.PURPLE_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BROWN_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BROWN_CARPET), conditionsFromItem(Blocks.BROWN_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.BLACK_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.BLACK_CARPET), conditionsFromItem(Blocks.BLACK_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.GRAY_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.GRAY_CARPET), conditionsFromItem(Blocks.GRAY_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.LIGHT_GRAY_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.LIGHT_GRAY_CARPET), conditionsFromItem(Blocks.LIGHT_GRAY_CARPET))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_CARPET, 8)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('B', Blocks.WHITE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .criterion(hasItem(Blocks.WHITE_CARPET), conditionsFromItem(Blocks.WHITE_CARPET))
                    .offerTo(exporter);

                // Custom Resin //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.BEETROOT_RESIN_CLUMP, 9)
                    .input('D', Items.RED_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.BEETROOT_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BLOCK)
                    .input(ModItems.BEETROOT_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.BEETROOT_RESIN_CLUMP), conditionsFromItem(ModItems.BEETROOT_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BLOCK_STAIRS, ModBlocks.BEETROOT_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.BEETROOT_RESIN_BLOCK_SLAB, ModBlocks.BEETROOT_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BLOCK_WALL, ModBlocks.BEETROOT_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.BEETROOT_RESIN_CLUMP), RecipeCategory.MISC, ModItems.BEETROOT_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.BEETROOT_RESIN_CLUMP), conditionsFromItem(ModItems.BEETROOT_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BRICKS, ModItems.BEETROOT_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BRICKS_SLAB, ModBlocks.BEETROOT_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BRICKS_STAIRS, ModBlocks.BEETROOT_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.BEETROOT_RESIN_BRICKS_WALL, ModBlocks.BEETROOT_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BEETROOT_RESIN_BRICKS, ModBlocks.BEETROOT_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.CHORUS_RESIN_CLUMP, 9)
                    .input('D', Items.PURPLE_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BLOCK)
                    .input(ModItems.CHORUS_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.CHORUS_RESIN_CLUMP), conditionsFromItem(ModItems.CHORUS_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BLOCK_STAIRS, ModBlocks.CHORUS_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CHORUS_RESIN_BLOCK_SLAB, ModBlocks.CHORUS_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BLOCK_WALL, ModBlocks.CHORUS_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.CHORUS_RESIN_CLUMP), RecipeCategory.MISC, ModItems.CHORUS_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.CHORUS_RESIN_CLUMP), conditionsFromItem(ModItems.CHORUS_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BRICKS, ModItems.CHORUS_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BRICKS_SLAB, ModBlocks.CHORUS_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BRICKS_STAIRS, ModBlocks.CHORUS_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CHORUS_RESIN_BRICKS_WALL, ModBlocks.CHORUS_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CHORUS_RESIN_BRICKS, ModBlocks.CHORUS_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.LEMON_RESIN_CLUMP, 9)
                    .input('D', Items.YELLOW_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BLOCK)
                    .input(ModItems.LEMON_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.LEMON_RESIN_CLUMP), conditionsFromItem(ModItems.LEMON_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BLOCK_STAIRS, ModBlocks.LEMON_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.LEMON_RESIN_BLOCK_SLAB, ModBlocks.LEMON_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BLOCK_WALL, ModBlocks.LEMON_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.LEMON_RESIN_CLUMP), RecipeCategory.MISC, ModItems.LEMON_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.LEMON_RESIN_CLUMP), conditionsFromItem(ModItems.LEMON_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BRICKS, ModItems.LEMON_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BRICKS_SLAB, ModBlocks.LEMON_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BRICKS_STAIRS, ModBlocks.LEMON_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.LEMON_RESIN_BRICKS_WALL, ModBlocks.LEMON_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_LEMON_RESIN_BRICKS, ModBlocks.LEMON_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GLACIER_RESIN_CLUMP, 9)
                    .input('D', Items.LIGHT_BLUE_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BLOCK)
                    .input(ModItems.GLACIER_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.GLACIER_RESIN_CLUMP), conditionsFromItem(ModItems.GLACIER_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BLOCK_STAIRS, ModBlocks.GLACIER_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.GLACIER_RESIN_BLOCK_SLAB, ModBlocks.GLACIER_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BLOCK_WALL, ModBlocks.GLACIER_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.GLACIER_RESIN_CLUMP), RecipeCategory.MISC, ModItems.GLACIER_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.GLACIER_RESIN_CLUMP), conditionsFromItem(ModItems.GLACIER_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BRICKS, ModItems.GLACIER_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BRICKS_SLAB, ModBlocks.GLACIER_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BRICKS_STAIRS, ModBlocks.GLACIER_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.GLACIER_RESIN_BRICKS_WALL, ModBlocks.GLACIER_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GLACIER_RESIN_BRICKS, ModBlocks.GLACIER_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.CARAMEL_RESIN_CLUMP, 9)
                    .input('D', Items.ORANGE_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BLOCK)
                    .input(ModItems.CARAMEL_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.CARAMEL_RESIN_CLUMP), conditionsFromItem(ModItems.CARAMEL_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BLOCK_STAIRS, ModBlocks.CARAMEL_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CARAMEL_RESIN_BLOCK_SLAB, ModBlocks.CARAMEL_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BLOCK_WALL, ModBlocks.CARAMEL_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.CARAMEL_RESIN_CLUMP), RecipeCategory.MISC, ModItems.CARAMEL_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.CARAMEL_RESIN_CLUMP), conditionsFromItem(ModItems.CARAMEL_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BRICKS, ModItems.CARAMEL_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BRICKS_SLAB, ModBlocks.CARAMEL_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BRICKS_STAIRS, ModBlocks.CARAMEL_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.CARAMEL_RESIN_BRICKS_WALL, ModBlocks.CARAMEL_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CARAMEL_RESIN_BRICKS, ModBlocks.CARAMEL_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TOXIC_RESIN_CLUMP, 9)
                    .input('D', Items.LIME_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BLOCK)
                    .input(ModItems.TOXIC_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.TOXIC_RESIN_CLUMP), conditionsFromItem(ModItems.TOXIC_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BLOCK_STAIRS, ModBlocks.TOXIC_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.TOXIC_RESIN_BLOCK_SLAB, ModBlocks.TOXIC_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BLOCK_WALL, ModBlocks.TOXIC_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.TOXIC_RESIN_CLUMP), RecipeCategory.MISC, ModItems.TOXIC_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.TOXIC_RESIN_CLUMP), conditionsFromItem(ModItems.TOXIC_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BRICKS, ModItems.TOXIC_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BRICKS_SLAB, ModBlocks.TOXIC_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BRICKS_STAIRS, ModBlocks.TOXIC_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.TOXIC_RESIN_BRICKS_WALL, ModBlocks.TOXIC_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TOXIC_RESIN_BRICKS, ModBlocks.TOXIC_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.JADE_RESIN_CLUMP, 9)
                    .input('D', Items.CYAN_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BLOCK)
                    .input(ModItems.JADE_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.JADE_RESIN_CLUMP), conditionsFromItem(ModItems.JADE_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BLOCK_STAIRS, ModBlocks.JADE_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.JADE_RESIN_BLOCK_SLAB, ModBlocks.JADE_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BLOCK_WALL, ModBlocks.JADE_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.JADE_RESIN_CLUMP), RecipeCategory.MISC, ModItems.JADE_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.JADE_RESIN_CLUMP), conditionsFromItem(ModItems.JADE_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BRICKS, ModItems.JADE_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BRICKS_SLAB, ModBlocks.JADE_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BRICKS_STAIRS, ModBlocks.JADE_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.JADE_RESIN_BRICKS_WALL, ModBlocks.JADE_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_JADE_RESIN_BRICKS, ModBlocks.JADE_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.BUBBLE_RESIN_CLUMP, 9)
                    .input('D', Items.CYAN_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BLOCK)
                    .input(ModItems.BUBBLE_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.BUBBLE_RESIN_CLUMP), conditionsFromItem(ModItems.BUBBLE_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BLOCK_STAIRS, ModBlocks.BUBBLE_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.BUBBLE_RESIN_BLOCK_SLAB, ModBlocks.BUBBLE_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BLOCK_WALL, ModBlocks.BUBBLE_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.BUBBLE_RESIN_CLUMP), RecipeCategory.MISC, ModItems.BUBBLE_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.BUBBLE_RESIN_CLUMP), conditionsFromItem(ModItems.BUBBLE_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BRICKS, ModItems.BUBBLE_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BRICKS_SLAB, ModBlocks.BUBBLE_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BRICKS_STAIRS, ModBlocks.BUBBLE_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.BUBBLE_RESIN_BRICKS_WALL, ModBlocks.BUBBLE_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BUBBLE_RESIN_BRICKS, ModBlocks.BUBBLE_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.OCEAN_RESIN_CLUMP, 9)
                    .input('D', Items.BLUE_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BLOCK)
                    .input(ModItems.OCEAN_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.OCEAN_RESIN_CLUMP), conditionsFromItem(ModItems.OCEAN_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BLOCK_STAIRS, ModBlocks.OCEAN_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.OCEAN_RESIN_BLOCK_SLAB, ModBlocks.OCEAN_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BLOCK_WALL, ModBlocks.OCEAN_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.OCEAN_RESIN_CLUMP), RecipeCategory.MISC, ModItems.OCEAN_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.OCEAN_RESIN_CLUMP), conditionsFromItem(ModItems.OCEAN_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BRICKS, ModItems.OCEAN_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BRICKS_SLAB, ModBlocks.OCEAN_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BRICKS_STAIRS, ModBlocks.OCEAN_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.OCEAN_RESIN_BRICKS_WALL, ModBlocks.OCEAN_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_OCEAN_RESIN_BRICKS, ModBlocks.OCEAN_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.EMERALD_RESIN_CLUMP, 9)
                    .input('D', Items.GREEN_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BLOCK)
                    .input(ModItems.EMERALD_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.EMERALD_RESIN_CLUMP), conditionsFromItem(ModItems.EMERALD_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BLOCK_STAIRS, ModBlocks.EMERALD_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.EMERALD_RESIN_BLOCK_SLAB, ModBlocks.EMERALD_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BLOCK_WALL, ModBlocks.EMERALD_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.EMERALD_RESIN_CLUMP), RecipeCategory.MISC, ModItems.EMERALD_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.EMERALD_RESIN_CLUMP), conditionsFromItem(ModItems.EMERALD_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BRICKS, ModItems.EMERALD_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BRICKS_SLAB, ModBlocks.EMERALD_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BRICKS_STAIRS, ModBlocks.EMERALD_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.EMERALD_RESIN_BRICKS_WALL, ModBlocks.EMERALD_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_EMERALD_RESIN_BRICKS, ModBlocks.EMERALD_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DUSK_RESIN_CLUMP, 9)
                    .input('D', Items.MAGENTA_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BLOCK)
                    .input(ModItems.DUSK_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.DUSK_RESIN_CLUMP), conditionsFromItem(ModItems.DUSK_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BLOCK_STAIRS, ModBlocks.DUSK_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.DUSK_RESIN_BLOCK_SLAB, ModBlocks.DUSK_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BLOCK_WALL, ModBlocks.DUSK_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.DUSK_RESIN_CLUMP), RecipeCategory.MISC, ModItems.DUSK_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.DUSK_RESIN_CLUMP), conditionsFromItem(ModItems.DUSK_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BRICKS, ModItems.DUSK_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BRICKS_SLAB, ModBlocks.DUSK_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BRICKS_STAIRS, ModBlocks.DUSK_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.DUSK_RESIN_BRICKS_WALL, ModBlocks.DUSK_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DUSK_RESIN_BRICKS, ModBlocks.DUSK_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DAYBREAK_RESIN_CLUMP, 9)
                    .input('D', Items.WHITE_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BLOCK)
                    .input(ModItems.DAYBREAK_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.DAYBREAK_RESIN_CLUMP), conditionsFromItem(ModItems.DAYBREAK_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BLOCK_STAIRS, ModBlocks.DAYBREAK_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB, ModBlocks.DAYBREAK_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BLOCK_WALL, ModBlocks.DAYBREAK_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.DAYBREAK_RESIN_CLUMP), RecipeCategory.MISC, ModItems.DAYBREAK_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.DAYBREAK_RESIN_CLUMP), conditionsFromItem(ModItems.DAYBREAK_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BRICKS, ModItems.DAYBREAK_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB, ModBlocks.DAYBREAK_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BRICKS_STAIRS, ModBlocks.DAYBREAK_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.DAYBREAK_RESIN_BRICKS_WALL, ModBlocks.DAYBREAK_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DAYBREAK_RESIN_BRICKS, ModBlocks.DAYBREAK_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SILT_RESIN_CLUMP, 9)
                    .input('D', Items.LIGHT_GRAY_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BLOCK)
                    .input(ModItems.SILT_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.SILT_RESIN_CLUMP), conditionsFromItem(ModItems.SILT_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BLOCK_STAIRS, ModBlocks.SILT_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.SILT_RESIN_BLOCK_SLAB, ModBlocks.SILT_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BLOCK_WALL, ModBlocks.SILT_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.SILT_RESIN_CLUMP), RecipeCategory.MISC, ModItems.SILT_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.SILT_RESIN_CLUMP), conditionsFromItem(ModItems.SILT_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BRICKS, ModItems.SILT_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BRICKS_SLAB, ModBlocks.SILT_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BRICKS_STAIRS, ModBlocks.SILT_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.SILT_RESIN_BRICKS_WALL, ModBlocks.SILT_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SILT_RESIN_BRICKS, ModBlocks.SILT_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAPHITE_RESIN_CLUMP, 9)
                    .input('D', Items.GRAY_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BLOCK)
                    .input(ModItems.GRAPHITE_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.GRAPHITE_RESIN_CLUMP), conditionsFromItem(ModItems.GRAPHITE_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BLOCK_STAIRS, ModBlocks.GRAPHITE_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB, ModBlocks.GRAPHITE_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BLOCK_WALL, ModBlocks.GRAPHITE_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.GRAPHITE_RESIN_CLUMP), RecipeCategory.MISC, ModItems.GRAPHITE_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.GRAPHITE_RESIN_CLUMP), conditionsFromItem(ModItems.GRAPHITE_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BRICKS, ModItems.GRAPHITE_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB, ModBlocks.GRAPHITE_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BRICKS_STAIRS, ModBlocks.GRAPHITE_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.GRAPHITE_RESIN_BRICKS_WALL, ModBlocks.GRAPHITE_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GRAPHITE_RESIN_BRICKS, ModBlocks.GRAPHITE_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_RESIN_CLUMP, 9)
                    .input('D', Items.BLACK_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BLOCK)
                    .input(ModItems.OBSIDIAN_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.OBSIDIAN_RESIN_CLUMP), conditionsFromItem(ModItems.OBSIDIAN_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BLOCK_STAIRS, ModBlocks.OBSIDIAN_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB, ModBlocks.OBSIDIAN_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BLOCK_WALL, ModBlocks.OBSIDIAN_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.OBSIDIAN_RESIN_CLUMP), RecipeCategory.MISC, ModItems.OBSIDIAN_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.OBSIDIAN_RESIN_CLUMP), conditionsFromItem(ModItems.OBSIDIAN_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BRICKS, ModItems.OBSIDIAN_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB, ModBlocks.OBSIDIAN_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BRICKS_STAIRS, ModBlocks.OBSIDIAN_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.OBSIDIAN_RESIN_BRICKS_WALL, ModBlocks.OBSIDIAN_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_OBSIDIAN_RESIN_BRICKS, ModBlocks.OBSIDIAN_RESIN_BRICKS);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.COCOA_RESIN_CLUMP, 9)
                    .input('D', Items.BROWN_DYE)
                    .input('P', ModItems.ABERRANT_PASTE)
                    .input('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .criterion(hasItem(Items.RESIN_CLUMP), conditionsFromItem(Items.RESIN_CLUMP))
                    .offerTo(exporter);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BLOCK);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BLOCK)
                    .input(ModItems.COCOA_RESIN_CLUMP, 9)
                    .criterion(hasItem(ModItems.COCOA_RESIN_CLUMP), conditionsFromItem(ModItems.COCOA_RESIN_CLUMP))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BLOCK_STAIRS, ModBlocks.COCOA_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.COCOA_RESIN_BLOCK_SLAB, ModBlocks.COCOA_RESIN_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BLOCK_WALL, ModBlocks.COCOA_RESIN_BLOCK);

                CookingRecipeJsonBuilder.createSmelting(
                        Ingredient.ofItem(ModItems.COCOA_RESIN_CLUMP), RecipeCategory.MISC, ModItems.COCOA_RESIN_BRICK, 0.1f, 200)
                        .criterion(hasItem(ModItems.COCOA_RESIN_CLUMP), conditionsFromItem(ModItems.COCOA_RESIN_CLUMP))
                        .offerTo(exporter);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BRICKS, ModItems.COCOA_RESIN_BRICK);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BRICKS_SLAB, ModBlocks.COCOA_RESIN_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BRICKS_STAIRS, ModBlocks.COCOA_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.COCOA_RESIN_BRICKS_WALL, ModBlocks.COCOA_RESIN_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_COCOA_RESIN_BRICKS, ModBlocks.COCOA_RESIN_BRICKS);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RESIN, Blocks.RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_POLISHED_RESIN, ModBlocks.BEETROOT_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_POLISHED_RESIN, ModBlocks.CARAMEL_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_POLISHED_RESIN, ModBlocks.LEMON_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_POLISHED_RESIN, ModBlocks.TOXIC_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_POLISHED_RESIN, ModBlocks.EMERALD_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_POLISHED_RESIN, ModBlocks.JADE_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_POLISHED_RESIN, ModBlocks.OCEAN_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_POLISHED_RESIN, ModBlocks.GLACIER_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_POLISHED_RESIN, ModBlocks.BUBBLE_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_POLISHED_RESIN, ModBlocks.DUSK_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_POLISHED_RESIN, ModBlocks.CHORUS_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_POLISHED_RESIN, ModBlocks.SILT_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_POLISHED_RESIN, ModBlocks.GRAPHITE_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_POLISHED_RESIN, ModBlocks.OBSIDIAN_RESIN_BLOCK);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_POLISHED_RESIN, ModBlocks.COCOA_RESIN_BLOCK);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES, Blocks.AMETHYST_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES_SLAB, ModBlocks.AMETHYST_TILES, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES_STAIRS, ModBlocks.AMETHYST_TILES);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.AMETHYST_TILES_WALL, ModBlocks.AMETHYST_TILES);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS, ModBlocks.AMETHYST_TILES);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS_SLAB, ModBlocks.AMETHYST_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS_STAIRS, ModBlocks.AMETHYST_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.AMETHYST_BRICKS_WALL, ModBlocks.AMETHYST_BRICKS);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_BLOCK, ModItems.ABERRANT_AMETHYST_SHARD);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_TILES, ModBlocks.ABERRANT_AMETHYST_BLOCK);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_TILES_SLAB, ModBlocks.ABERRANT_AMETHYST_TILES, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_TILES_STAIRS, ModBlocks.ABERRANT_AMETHYST_TILES);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.ABERRANT_AMETHYST_TILES_WALL, ModBlocks.ABERRANT_AMETHYST_TILES);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_BRICKS, ModBlocks.ABERRANT_AMETHYST_TILES);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB, ModBlocks.ABERRANT_AMETHYST_BRICKS, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_BRICKS_STAIRS, ModBlocks.ABERRANT_AMETHYST_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.ABERRANT_AMETHYST_BRICKS_WALL, ModBlocks.ABERRANT_AMETHYST_BRICKS);

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB,
                        Ingredient.ofItems(ModBlocks.ABERRANT_SOUL_SANDSTONE, ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.ABERRANT_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.ABERRANT_SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE))
                        .offerTo(exporter);
                createStairsRecipe(ModBlocks.ABERRANT_SOUL_SANDSTONE_STAIRS,
                        Ingredient.ofItems(ModBlocks.ABERRANT_SOUL_SANDSTONE, ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.ABERRANT_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.ABERRANT_SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE))
                        .criterion(hasItem(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE))
                        .offerTo(exporter);
                offerWallRecipe(RecipeCategory.DECORATIONS, ModBlocks.ABERRANT_SOUL_SANDSTONE_WALL, ModBlocks.ABERRANT_SOUL_SANDSTONE);
                offerChiseledBlockRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB);
                offerCutCopperRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SANDSTONE);

                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(ModBlocks.ABERRANT_SOUL_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE.asItem(),0.1f, 200)
                        .criterion(hasItem(ModBlocks.ABERRANT_SOUL_SANDSTONE), conditionsFromItem(ModBlocks.ABERRANT_SOUL_SANDSTONE))
                        .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB, ModBlocks.ABERRANT_SOUL_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SOUL_SANDSTONE_STAIRS, ModBlocks.ABERRANT_SOUL_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.ABERRANT_SOUL_SANDSTONE_WALL, ModBlocks.ABERRANT_SOUL_SANDSTONE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SANDSTONE);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE, 2);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_STAIRS, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_JACK_O_LANTERN)
                    .input('A', ModBlocks.ABERRANT_CARVED_PUMPKIN)
                    .input('B', Blocks.SOUL_TORCH)
                    .pattern("A")
                    .pattern("B")
                    .criterion(hasItem(ModBlocks.ABERRANT_CARVED_PUMPKIN), conditionsFromItem(ModBlocks.ABERRANT_CARVED_PUMPKIN))
                    .offerTo(exporter);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_NETHER_BRICKS, ModItems.ABERRANT_NETHER_BRICK);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.ABERRANT_NETHERRACK), RecipeCategory.MISC, ModItems.ABERRANT_NETHER_BRICK, 0.1f, 200)
                    .criterion(hasItem(ModBlocks.ABERRANT_NETHERRACK), conditionsFromItem(ModBlocks.ABERRANT_NETHERRACK))
                    .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS, ModBlocks.ABERRANT_NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_STAIRS, ModBlocks.ABERRANT_NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB, ModBlocks.ABERRANT_NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_WALL, ModBlocks.ABERRANT_NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS, ModBlocks.ABERRANT_NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_STAIRS, ModBlocks.ABERRANT_NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB, ModBlocks.ABERRANT_NETHER_BRICKS);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_WALL, ModBlocks.ABERRANT_NETHER_BRICKS);
            }

            public void offer2x2CompactingRecipe4(RecipeCategory category, ItemConvertible output, ItemConvertible input) {
                createShaped(category, output, 4)
                    .input(Character.valueOf('#'), input)
                    .pattern("##")
                    .pattern("##")
                    .criterion(RecipeGenerator.hasItem(input), conditionsFromItem(input))
                    .offerTo(exporter);
            }
        };
    }



    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
