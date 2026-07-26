package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.searchies.bauen.block.ModBlocks;
import net.searchies.bauen.item.ModItems;

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

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_BRICKS)
                    .input(ModBlocks.CHISELED_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_BRICKS, 0.1F, 200
                )
                .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter);

                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.CHISELED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_BRICKS, 0.1F, 200
                )
                .criterion(hasItem(ModBlocks.CHISELED_BRICKS), conditionsFromItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                .offerTo(exporter);

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRICKS, Blocks.BRICKS);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_PACKED_MUD, 1)
                    .input(Blocks.PACKED_MUD)
                    .input(Items.VINE)
                    .criterion("has_packed_mud", conditionsFromItem(Blocks.PACKED_MUD))
                    .offerTo(exporter);

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS, 4)
                    .input('#', ModBlocks.MOSSY_PACKED_MUD)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.MOSSY_PACKED_MUD), conditionsFromItem(ModBlocks.MOSSY_PACKED_MUD))
                    .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TUFF_BRICKS, 1)
                    .input(Blocks.TUFF_BRICKS)
                    .input(Items.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULKED_DEEPSLATE_BRICKS, 1)
                    .input(Blocks.DEEPSLATE_BRICKS)
                    .input(Items.SCULK)
                    .criterion("has_deepslate_bricks", conditionsFromItem(Blocks.DEEPSLATE_BRICKS))
                    .offerTo(exporter);


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

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD, Blocks.GOLD_BLOCK, 4);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GOLD, Blocks.GOLD_BLOCK, 4);
                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_TRAPDOOR, Items.GOLD_INGOT);
                offerGrateRecipe(ModBlocks.GOLD_GRATE, Blocks.GOLD_BLOCK);
                CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItem(Items.GOLD_NUGGET), RecipeCategory.MISC, ModBlocks.GOLD_COINS , 0.1F, 200)
                    .criterion(hasItem(Items.GOLD_NUGGET), conditionsFromItem(Items.GOLD_NUGGET))
                    .offerTo(exporter);
                createDoorRecipe(ModBlocks.GOLD_DOOR, Ingredient.ofItem(Items.GOLD_INGOT))
                    .criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
                    .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_HOARD, 8)
                    .input('#', ModBlocks.GOLD_COINS)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.GOLD_COINS), conditionsFromItem(ModBlocks.GOLD_COINS))
                    .offerTo(exporter);

                // INDUSTRIAL IRON BLOCKS //

                offer2x2CompactingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_BLOCK, Items.IRON_INGOT);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_INDUSTRIAL_IRON, ModBlocks.INDUSTRIAL_IRON_BLOCK, 4);
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

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIDNIGHT_BRICKS)
                    .input('#', ModItems.MIDNIGHT_BRICK)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModItems.MIDNIGHT_BRICK), conditionsFromItem(ModItems.MIDNIGHT_BRICK))
                    .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIDNIGHT_BRICKS)
                    .input(ModBlocks.MIDNIGHT_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MIDNIGHT_BRICKS, ModBlocks.MIDNIGHT_BRICKS);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS)
                    .input(ModBlocks.CHISELED_MIDNIGHT_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS, 0.1F, 200
                )
                .criterion(hasItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS), conditionsFromItem(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                .offerTo(exporter);

                // MIXED BRICKS //

                CookingRecipeJsonBuilder.createBlasting(Ingredient.ofItem(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREATED_BRICKS, 0.1F, 200)
                    .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                    .offerTo(exporter, getBlastingItemPath(Blocks.BRICKS));
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TREATED_BRICKS)
                    .input(ModBlocks.TREATED_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.TREATED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_TREATED_BRICKS, 0.1F, 200)
                    .criterion(hasItem(ModBlocks.TREATED_BRICKS), conditionsFromItem(ModBlocks.TREATED_BRICKS))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TREATED_BRICKS, ModBlocks.TREATED_BRICKS);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS)
                    .input(ModBlocks.CHISELED_TREATED_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.CHISELED_TREATED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_TREATED_BRICKS, 0.1F, 200)
                    .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                    .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_BRICKS)
                    .input(ModBlocks.TREATED_BRICKS)
                    .input(Blocks.BRICKS)
                    .criterion("has_bricks", conditionsFromItem(Blocks.BRICKS))
                    .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIXED_BRICKS)
                    .input(ModBlocks.MIXED_BRICKS)
                    .input(Blocks.VINE)
                    .criterion("has_vine", conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.MIXED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_MIXED_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.MIXED_BRICKS), conditionsFromItem(ModBlocks.MIXED_BRICKS))
                .offerTo(exporter);

                // CALCITE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS)
                    .input('#', Blocks.CALCITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.CALCITE), conditionsFromItem(Blocks.CALCITE))
                    .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CALCITE_BRICKS)
                    .input(ModBlocks.CALCITE_BRICKS)
                    .input(Blocks.PALE_MOSS_BLOCK)
                    .criterion(hasItem(Blocks.PALE_MOSS_BLOCK), conditionsFromItem(Blocks.PALE_MOSS_BLOCK))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.CALCITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CALCITE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.CALCITE_BRICKS), conditionsFromItem(ModBlocks.CALCITE_BRICKS))
                .offerTo(exporter);

                // ANDESITE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS)
                    .input('#', Blocks.ANDESITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.ANDESITE), conditionsFromItem(Blocks.ANDESITE))
                    .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_ANDESITE_BRICKS)
                    .input(ModBlocks.ANDESITE_BRICKS)
                    .input(Blocks.VINE)
                    .criterion(hasItem(Blocks.VINE), conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.ANDESITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_ANDESITE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.ANDESITE_BRICKS), conditionsFromItem(ModBlocks.ANDESITE_BRICKS))
                .offerTo(exporter);

                // DIORITE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS)
                    .input('#', Blocks.DIORITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.DIORITE), conditionsFromItem(Blocks.DIORITE))
                    .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DIORITE_BRICKS)
                    .input(ModBlocks.DIORITE_BRICKS)
                    .input(Blocks.VINE)
                    .criterion(hasItem(Blocks.VINE), conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.DIORITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_DIORITE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.DIORITE_BRICKS), conditionsFromItem(ModBlocks.DIORITE_BRICKS))
                .offerTo(exporter);

                // DRIPSTONE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS)
                    .input('#', Blocks.DRIPSTONE_BLOCK)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.DRIPSTONE_BLOCK), conditionsFromItem(Blocks.DRIPSTONE_BLOCK))
                    .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DRIPSTONE_BRICKS)
                    .input(ModBlocks.DRIPSTONE_BRICKS)
                    .input(Blocks.VINE)
                    .criterion(hasItem(Blocks.VINE), conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.DRIPSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_DRIPSTONE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.DRIPSTONE_BRICKS), conditionsFromItem(ModBlocks.DRIPSTONE_BRICKS))
                .offerTo(exporter);

                // GRANITE BRICKS //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS)
                    .input('#', Blocks.GRANITE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(Blocks.GRANITE), conditionsFromItem(Blocks.GRANITE))
                    .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_GRANITE_BRICKS)
                    .input(ModBlocks.GRANITE_BRICKS)
                    .input(Blocks.VINE)
                    .criterion(hasItem(Blocks.VINE), conditionsFromItem(Blocks.VINE))
                    .offerTo(exporter);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.GRANITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_GRANITE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.GRANITE_BRICKS), conditionsFromItem(ModBlocks.GRANITE_BRICKS))
                .offerTo(exporter);

                // OCEANSLATE //

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE)
                    .input(Items.COPPER_NUGGET, 2)
                    .input(Blocks.DEEPSLATE, 2)
                    .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE))
                .offerTo(exporter);
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_BRICKS)
                    .input('#', ModBlocks.OCEANSLATE)
                    .pattern("##")
                    .pattern("##")
                    .criterion(hasItem(ModBlocks.OCEANSLATE), conditionsFromItem(ModBlocks.OCEANSLATE))
                    .offerTo(exporter);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES, ModBlocks.OCEANSLATE);
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE, ModBlocks.OCEANSLATE);
                CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItem(ModBlocks.OCEANSLATE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_OCEANSLATE_BRICKS, 0.1F, 200)
                .criterion(hasItem(ModBlocks.OCEANSLATE_BRICKS), conditionsFromItem(ModBlocks.OCEANSLATE_BRICKS))
                .offerTo(exporter);
                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_OCEANSLATE_BRICKS)
                    .input(ModBlocks.OCEANSLATE_BRICKS)
                    .input(Blocks.KELP)
                    .criterion(hasItem(Blocks.KELP), conditionsFromItem(Blocks.KELP))
                    .offerTo(exporter);

                // TROWEL //

                createShaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TROWEL)
                    .input('I', Items.IRON_INGOT)
                    .input('S', Items.STICK)
                    .pattern(" I")
                    .pattern("S ")
                    .criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
                    .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
