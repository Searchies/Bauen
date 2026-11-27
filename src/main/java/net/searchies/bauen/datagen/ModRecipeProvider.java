package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModItems;
import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput exporter) {
        return new RecipeProvider(registries, exporter) {
            @Override
            public void buildRecipes() {

                // CUSTOM BRICK BLOCKS //

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICKS)
                    .requires(Blocks.BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy("has_vine", has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_BRICKS))
                    .unlockedBy(getHasName(ModBlocks.MOSSY_BRICKS), has(ModBlocks.MOSSY_BRICKS))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICKS_SLAB, ModBlocks.MOSSY_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICKS_WALL, ModBlocks.MOSSY_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_BRICKS, ModBlocks.MOSSY_BRICKS_STAIRS, ModBlocks.MOSSY_BRICKS_SLAB, ModBlocks.MOSSY_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_BRICKS)
                    .requires(ModBlocks.CHISELED_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy("has_vine", has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_CHISELED_BRICKS))
                    .unlockedBy(getHasName(ModBlocks.MOSSY_CHISELED_BRICKS), has(ModBlocks.MOSSY_CHISELED_BRICKS))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_BRICKS_WALL, ModBlocks.MOSSY_CHISELED_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_CHISELED_BRICKS, ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS, ModBlocks.MOSSY_CHISELED_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_BRICKS, 0.1F, 200
                )
                .unlockedBy("has_bricks", has(Blocks.BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_BRICKS))
                    .unlockedBy(getHasName(ModBlocks.CRACKED_BRICKS), has(ModBlocks.CRACKED_BRICKS))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICKS_SLAB, ModBlocks.CRACKED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICKS_WALL, ModBlocks.CRACKED_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_BRICKS, ModBlocks.CRACKED_BRICKS_STAIRS, ModBlocks.CRACKED_BRICKS_SLAB, ModBlocks.CRACKED_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.CHISELED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_BRICKS, 0.1F, 200
                )
                .unlockedBy(getHasName(ModBlocks.CHISELED_BRICKS), has(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_CHISELED_BRICKS))
                    .unlockedBy(getHasName(ModBlocks.CRACKED_CHISELED_BRICKS), has(ModBlocks.CRACKED_CHISELED_BRICKS))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_BRICKS_WALL, ModBlocks.CRACKED_CHISELED_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_CHISELED_BRICKS, ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS, ModBlocks.CRACKED_CHISELED_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_BRICKS_WALL);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRICKS, Blocks.BRICKS);
                stairBuilder(ModBlocks.CHISELED_BRICKS_STAIRS, Ingredient.of(ModBlocks.CHISELED_BRICKS))
                    .unlockedBy(getHasName(ModBlocks.CHISELED_BRICKS), has(ModBlocks.CHISELED_BRICKS))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRICKS_SLAB, ModBlocks.CHISELED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BRICKS_WALL, ModBlocks.CHISELED_BRICKS);
                easyStonecutting(ModBlocks.CHISELED_BRICKS, ModBlocks.CHISELED_BRICKS_STAIRS, ModBlocks.CHISELED_BRICKS_SLAB, ModBlocks.CHISELED_BRICKS_WALL);

                stairBuilder(ModBlocks.ICE_STAIRS, Ingredient.of(Blocks.ICE))
                    .unlockedBy(getHasName(Blocks.ICE), has(Blocks.ICE))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_SLAB, Blocks.ICE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ICE_WALL, Blocks.ICE);
                easyStonecutting(Blocks.ICE, ModBlocks.ICE_STAIRS, ModBlocks.ICE_SLAB, ModBlocks.ICE_WALL);

                stairBuilder(ModBlocks.PACKED_ICE_STAIRS, Ingredient.of(Blocks.PACKED_ICE))
                    .unlockedBy(getHasName(Blocks.PACKED_ICE), has(Blocks.PACKED_ICE))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_SLAB, Blocks.PACKED_ICE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PACKED_ICE_WALL, Blocks.PACKED_ICE);
                easyStonecutting(Blocks.PACKED_ICE, ModBlocks.PACKED_ICE_STAIRS, ModBlocks.PACKED_ICE_SLAB, ModBlocks.PACKED_ICE_WALL);

                stairBuilder(ModBlocks.MUD_STAIRS, Ingredient.of(Blocks.MUD))
                    .unlockedBy(getHasName(Blocks.MUD), has(Blocks.MUD))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_SLAB, Blocks.MUD);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MUD_WALL, Blocks.MUD);
                easyStonecutting(Blocks.MUD, ModBlocks.MUD_STAIRS, ModBlocks.MUD_SLAB, ModBlocks.MUD_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_PACKED_MUD, 1)
                    .requires(Blocks.PACKED_MUD)
                    .requires(Items.VINE)
                    .unlockedBy("has_packed_mud", has(Blocks.PACKED_MUD))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_PACKED_MUD_STAIRS, Ingredient.of(ModBlocks.MOSSY_PACKED_MUD))
                    .unlockedBy(getHasName(ModBlocks.MOSSY_PACKED_MUD), has(ModBlocks.MOSSY_PACKED_MUD))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_PACKED_MUD_SLAB, ModBlocks.MOSSY_PACKED_MUD);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_PACKED_MUD_WALL, ModBlocks.MOSSY_PACKED_MUD);
                easyStonecutting(ModBlocks.MOSSY_PACKED_MUD, ModBlocks.MOSSY_PACKED_MUD_STAIRS, ModBlocks.MOSSY_PACKED_MUD_SLAB, ModBlocks.MOSSY_PACKED_MUD_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS, 4)
                    .define('#', ModBlocks.MOSSY_PACKED_MUD)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.MOSSY_PACKED_MUD), has(ModBlocks.MOSSY_PACKED_MUD))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_MUD_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_MUD_BRICKS))
                    .unlockedBy(getHasName(ModBlocks.MOSSY_MUD_BRICKS), has(ModBlocks.MOSSY_MUD_BRICKS))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS_SLAB, ModBlocks.MOSSY_MUD_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS_WALL, ModBlocks.MOSSY_MUD_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_MUD_BRICKS, ModBlocks.MOSSY_MUD_BRICKS_STAIRS, ModBlocks.MOSSY_MUD_BRICKS_SLAB, ModBlocks.MOSSY_MUD_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TUFF_BRICKS, 1)
                    .requires(Blocks.TUFF_BRICKS)
                    .requires(Items.VINE)
                    .unlockedBy("has_vine", has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_TUFF_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_TUFF_BRICKS))
                    .unlockedBy(getHasName(ModBlocks.MOSSY_TUFF_BRICKS), has(ModBlocks.MOSSY_TUFF_BRICKS))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TUFF_BRICKS_SLAB, ModBlocks.MOSSY_TUFF_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TUFF_BRICKS_WALL, ModBlocks.MOSSY_TUFF_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_TUFF_BRICKS, ModBlocks.MOSSY_TUFF_BRICKS_STAIRS, ModBlocks.MOSSY_TUFF_BRICKS_SLAB, ModBlocks.MOSSY_TUFF_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                                Ingredient.of(Blocks.TUFF_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                                ModBlocks.CRACKED_TUFF_BRICKS, 0.1F, 200
                        )
                        .unlockedBy(getHasName(Blocks.TUFF_BRICKS), has(Blocks.TUFF_BRICKS))
                        .save(output);
                stairBuilder(ModBlocks.CRACKED_TUFF_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_TUFF_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_TUFF_BRICKS), has(ModBlocks.CRACKED_TUFF_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_TUFF_BRICKS_SLAB, ModBlocks.CRACKED_TUFF_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_TUFF_BRICKS_WALL, ModBlocks.CRACKED_TUFF_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_TUFF_BRICKS, ModBlocks.CRACKED_TUFF_BRICKS_STAIRS, ModBlocks.CRACKED_TUFF_BRICKS_SLAB, ModBlocks.CRACKED_TUFF_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULKED_DEEPSLATE_BRICKS, 1)
                    .requires(Blocks.DEEPSLATE_BRICKS)
                    .requires(Items.SCULK)
                    .unlockedBy("has_deepslate_bricks", has(Blocks.DEEPSLATE_BRICKS))
                    .save(output);
                stairBuilder(ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS, Ingredient.of(ModBlocks.SCULKED_DEEPSLATE_BRICKS))
                    .unlockedBy(getHasName(ModBlocks.SCULKED_DEEPSLATE_BRICKS), has(ModBlocks.SCULKED_DEEPSLATE_BRICKS))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB, ModBlocks.SCULKED_DEEPSLATE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL, ModBlocks.SCULKED_DEEPSLATE_BRICKS);
                easyStonecutting(ModBlocks.SCULKED_DEEPSLATE_BRICKS, ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS, ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB, ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL);

                // CUSTOM GOLD BLOCKS //

                shaped(RecipeCategory.DECORATIONS, ModBlocks.GOLD_CHAIN)
                    .define('I', Items.GOLD_INGOT)
                    .define('N', Items.GOLD_NUGGET)
                    .pattern("N")
                    .pattern("I")
                    .pattern("N")
                    .unlockedBy("has_gold_nugget", has(Items.GOLD_NUGGET))
                    .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                    .save(output);

                shaped(RecipeCategory.DECORATIONS, ModBlocks.GOLD_LANTERN)
                    .define('#', Items.TORCH)
                    .define('X', Items.GOLD_NUGGET)
                    .pattern("XXX")
                    .pattern("X#X")
                    .pattern("XXX")
                    .unlockedBy("has_gold_nugget", has(Items.GOLD_NUGGET))
                    .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                    .save(output);

                shaped(RecipeCategory.DECORATIONS, ModBlocks.GOLD_BARS, 16)
                    .define('#', Items.GOLD_INGOT)
                    .pattern("###")
                    .pattern("###")
                    .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                    .save(output);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD, Blocks.GOLD_BLOCK, 9);
                stairBuilder(ModBlocks.CUT_GOLD_STAIRS, Ingredient.of(ModBlocks.CUT_GOLD))
                        .unlockedBy(getHasName(ModBlocks.CUT_GOLD), has(ModBlocks.CUT_GOLD))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD_SLAB, ModBlocks.CUT_GOLD);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_GOLD_WALL, ModBlocks.CUT_GOLD);
                easyStonecutting(ModBlocks.CUT_GOLD, ModBlocks.CUT_GOLD_STAIRS, ModBlocks.CUT_GOLD_SLAB, ModBlocks.CUT_GOLD_WALL);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GOLD, Blocks.GOLD_BLOCK, 4);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_TRAPDOOR, Items.GOLD_INGOT);
                grate(ModBlocks.GOLD_GRATE, Blocks.GOLD_BLOCK);
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(Items.GOLD_NUGGET), RecipeCategory.MISC, ModBlocks.GOLD_COINS , 0.1F, 200)
                    .unlockedBy(getHasName(Items.GOLD_NUGGET), has(Items.GOLD_NUGGET))
                    .save(output);
                doorBuilder(ModBlocks.GOLD_DOOR, Ingredient.of(Items.GOLD_INGOT))
                    .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                    .save(output);
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_HOARD, 8)
                    .define('#', ModBlocks.GOLD_COINS)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.GOLD_COINS), has(ModBlocks.GOLD_COINS))
                    .save(output);

                // INDUSTRIAL IRON BLOCKS //

                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_BLOCK, Items.IRON_INGOT);
                stairBuilder(ModBlocks.INDUSTRIAL_IRON_STAIRS, Ingredient.of(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                        .unlockedBy(getHasName(ModBlocks.INDUSTRIAL_IRON_BLOCK), has(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_SLAB, ModBlocks.INDUSTRIAL_IRON_BLOCK);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_WALL, ModBlocks.INDUSTRIAL_IRON_BLOCK);
                easyStonecutting(ModBlocks.INDUSTRIAL_IRON_BLOCK, ModBlocks.INDUSTRIAL_IRON_STAIRS, ModBlocks.INDUSTRIAL_IRON_SLAB, ModBlocks.INDUSTRIAL_IRON_WALL);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_INDUSTRIAL_IRON, ModBlocks.INDUSTRIAL_IRON_BLOCK, 4);
                stairBuilder(ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS, Ingredient.of(ModBlocks.CUT_INDUSTRIAL_IRON))
                        .unlockedBy(getHasName(ModBlocks.CUT_INDUSTRIAL_IRON), has(ModBlocks.CUT_INDUSTRIAL_IRON))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_INDUSTRIAL_IRON_SLAB, ModBlocks.CUT_INDUSTRIAL_IRON);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_INDUSTRIAL_IRON_WALL, ModBlocks.CUT_INDUSTRIAL_IRON);
                easyStonecutting(ModBlocks.CUT_INDUSTRIAL_IRON, ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS, ModBlocks.CUT_INDUSTRIAL_IRON_SLAB, ModBlocks.CUT_INDUSTRIAL_IRON_WALL);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARVED_INDUSTRIAL_IRON, ModBlocks.INDUSTRIAL_IRON_BLOCK, 4);
                grate(ModBlocks.INDUSTRIAL_IRON_GRATE, ModBlocks.INDUSTRIAL_IRON_BLOCK);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.INDUSTRIAL_IRON_TRAPDOOR, ModBlocks.INDUSTRIAL_IRON_BLOCK);
                doorBuilder(ModBlocks.INDUSTRIAL_IRON_DOOR, Ingredient.of(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                    .unlockedBy(getHasName(ModBlocks.INDUSTRIAL_IRON_BLOCK), has(ModBlocks.INDUSTRIAL_IRON_BLOCK))
                    .save(output);

                // STONE STUFF //

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_COBBLESTONE, 2)
                        .requires(Blocks.COBBLED_DEEPSLATE)
                        .requires(Blocks.COBBLESTONE)
                        .unlockedBy("has_cobblestone", has(Items.CLAY_BALL))
                        .save(output);
                stairBuilder(ModBlocks.MIXED_COBBLESTONE_STAIRS, Ingredient.of(ModBlocks.MIXED_COBBLESTONE))
                        .unlockedBy(getHasName(ModBlocks.MIXED_COBBLESTONE), has(ModBlocks.MIXED_COBBLESTONE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_COBBLESTONE_SLAB, ModBlocks.MIXED_COBBLESTONE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_COBBLESTONE_WALL, ModBlocks.MIXED_COBBLESTONE);
                easyStonecutting(ModBlocks.MIXED_COBBLESTONE, ModBlocks.MIXED_COBBLESTONE_STAIRS, ModBlocks.MIXED_COBBLESTONE_SLAB, ModBlocks.MIXED_COBBLESTONE_WALL);

                // CLAY STUFF //

                shapeless(RecipeCategory.MISC, ModItems.KAOLIN_CLAY_BALL, 4)
                    .requires(Items.CLAY_BALL, 2)
                    .requires(Items.AMETHYST_SHARD)
                    .unlockedBy("has_clay_ball", has(Items.CLAY_BALL))
                    .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KAOLIN_CLAY, ModItems.KAOLIN_CLAY_BALL);
                SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.KAOLIN_CLAY_BALL), RecipeCategory.MISC, ModItems.MIDNIGHT_BRICK, 0.3F, 200)
                    .unlockedBy(getHasName(ModItems.KAOLIN_CLAY_BALL), has(ModItems.KAOLIN_CLAY_BALL))
                    .save(output);

                // MIDNIGHT BRICKS //

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIDNIGHT_BRICKS, 4)
                    .define('#', ModItems.MIDNIGHT_BRICK)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModItems.MIDNIGHT_BRICK), has(ModItems.MIDNIGHT_BRICK))
                    .save(output);
                stairBuilder(ModBlocks.MIDNIGHT_BRICKS_STAIRS, Ingredient.of(ModBlocks.MIDNIGHT_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MIDNIGHT_BRICKS), has(ModBlocks.MIDNIGHT_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIDNIGHT_BRICKS_SLAB, ModBlocks.MIDNIGHT_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIDNIGHT_BRICKS_WALL, ModBlocks.MIDNIGHT_BRICKS);
                easyStonecutting(ModBlocks.MIDNIGHT_BRICKS, ModBlocks.MIDNIGHT_BRICKS_STAIRS, ModBlocks.MIDNIGHT_BRICKS_SLAB, ModBlocks.MIDNIGHT_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIDNIGHT_BRICKS)
                    .requires(ModBlocks.MIDNIGHT_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy("has_vine", has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_MIDNIGHT_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_MIDNIGHT_BRICKS), has(ModBlocks.MOSSY_MIDNIGHT_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB, ModBlocks.MOSSY_MIDNIGHT_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL, ModBlocks.MOSSY_MIDNIGHT_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_MIDNIGHT_BRICKS, ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS, ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB, ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MIDNIGHT_BRICKS, ModBlocks.MIDNIGHT_BRICKS);
                stairBuilder(ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS, Ingredient.of(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CHISELED_MIDNIGHT_BRICKS), has(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CHISELED_MIDNIGHT_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL, ModBlocks.CHISELED_MIDNIGHT_BRICKS);
                easyStonecutting(ModBlocks.CHISELED_MIDNIGHT_BRICKS, ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS, ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS)
                    .requires(ModBlocks.CHISELED_MIDNIGHT_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy("has_vine", has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS), has(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.MIDNIGHT_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_MIDNIGHT_BRICKS, 0.1F, 200
                )
                .unlockedBy(getHasName(ModBlocks.MIDNIGHT_BRICKS), has(ModBlocks.MIDNIGHT_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_MIDNIGHT_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_MIDNIGHT_BRICKS), has(ModBlocks.CRACKED_MIDNIGHT_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CRACKED_MIDNIGHT_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL, ModBlocks.CRACKED_MIDNIGHT_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_MIDNIGHT_BRICKS, ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS, ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.CHISELED_MIDNIGHT_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS, 0.1F, 200
                )
                .unlockedBy(getHasName(ModBlocks.CHISELED_MIDNIGHT_BRICKS), has(ModBlocks.CHISELED_MIDNIGHT_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS), has(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL);

                // MIXED BRICKS //

                SimpleCookingRecipeBuilder.blasting(Ingredient.of(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREATED_BRICKS, 0.1F, 200)
                    .unlockedBy("has_bricks", has(Blocks.BRICKS))
                    .save(output, getBlastingRecipeName(Blocks.BRICKS));
                stairBuilder(ModBlocks.TREATED_BRICKS_STAIRS, Ingredient.of(ModBlocks.TREATED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.TREATED_BRICKS), has(ModBlocks.TREATED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREATED_BRICKS_SLAB, ModBlocks.TREATED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TREATED_BRICKS_WALL, ModBlocks.TREATED_BRICKS);
                easyStonecutting(ModBlocks.TREATED_BRICKS, ModBlocks.TREATED_BRICKS_STAIRS, ModBlocks.TREATED_BRICKS_SLAB, ModBlocks.TREATED_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TREATED_BRICKS)
                    .requires(ModBlocks.TREATED_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy("has_vine", has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_TREATED_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_TREATED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_TREATED_BRICKS), has(ModBlocks.MOSSY_TREATED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TREATED_BRICKS_SLAB, ModBlocks.MOSSY_TREATED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_TREATED_BRICKS_WALL, ModBlocks.MOSSY_TREATED_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_TREATED_BRICKS, ModBlocks.MOSSY_TREATED_BRICKS_STAIRS, ModBlocks.MOSSY_TREATED_BRICKS_SLAB, ModBlocks.MOSSY_TREATED_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.TREATED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_TREATED_BRICKS, 0.1F, 200)
                    .unlockedBy(getHasName(ModBlocks.TREATED_BRICKS), has(ModBlocks.TREATED_BRICKS))
                    .save(output);
                stairBuilder(ModBlocks.CRACKED_TREATED_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_TREATED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_TREATED_BRICKS), has(ModBlocks.CRACKED_TREATED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_TREATED_BRICKS_SLAB, ModBlocks.CRACKED_TREATED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_TREATED_BRICKS_WALL, ModBlocks.CRACKED_TREATED_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_TREATED_BRICKS, ModBlocks.CRACKED_TREATED_BRICKS_STAIRS, ModBlocks.CRACKED_TREATED_BRICKS_SLAB, ModBlocks.CRACKED_TREATED_BRICKS_WALL);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TREATED_BRICKS, ModBlocks.TREATED_BRICKS);
                stairBuilder(ModBlocks.CHISELED_TREATED_BRICKS_STAIRS, Ingredient.of(ModBlocks.CHISELED_TREATED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CHISELED_TREATED_BRICKS), has(ModBlocks.CHISELED_TREATED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TREATED_BRICKS_SLAB, ModBlocks.CHISELED_TREATED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TREATED_BRICKS_WALL, ModBlocks.CHISELED_TREATED_BRICKS);
                easyStonecutting(ModBlocks.CHISELED_TREATED_BRICKS, ModBlocks.CHISELED_TREATED_BRICKS_STAIRS, ModBlocks.CHISELED_TREATED_BRICKS_SLAB, ModBlocks.CHISELED_TREATED_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS)
                    .requires(ModBlocks.CHISELED_TREATED_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy("has_vine", has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS), has(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB, ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.CHISELED_TREATED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CHISELED_TREATED_BRICKS, 0.1F, 200)
                    .unlockedBy("has_bricks", has(Blocks.BRICKS))
                    .save(output);
                stairBuilder(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS), has(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB, ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_BRICKS, 4)
                    .requires(ModBlocks.TREATED_BRICKS)
                    .requires(Blocks.BRICKS)
                    .unlockedBy("has_bricks", has(Blocks.BRICKS))
                    .save(output);
                stairBuilder(ModBlocks.MIXED_BRICKS_STAIRS, Ingredient.of(ModBlocks.MIXED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MIXED_BRICKS), has(ModBlocks.MIXED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_BRICKS_SLAB, ModBlocks.MIXED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MIXED_BRICKS_WALL, ModBlocks.MIXED_BRICKS);
                easyStonecutting(ModBlocks.MIXED_BRICKS, ModBlocks.MIXED_BRICKS_STAIRS, ModBlocks.MIXED_BRICKS_SLAB, ModBlocks.MIXED_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIXED_BRICKS)
                    .requires(ModBlocks.MIXED_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy("has_vine", has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_MIXED_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_MIXED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_MIXED_BRICKS), has(ModBlocks.MOSSY_MIXED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIXED_BRICKS_SLAB, ModBlocks.MOSSY_MIXED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MIXED_BRICKS_WALL, ModBlocks.MOSSY_MIXED_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_MIXED_BRICKS, ModBlocks.MOSSY_MIXED_BRICKS_STAIRS, ModBlocks.MOSSY_MIXED_BRICKS_SLAB, ModBlocks.MOSSY_MIXED_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.MIXED_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_MIXED_BRICKS, 0.1F, 200)
                .unlockedBy(getHasName(ModBlocks.MIXED_BRICKS), has(ModBlocks.MIXED_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_MIXED_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_MIXED_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_MIXED_BRICKS), has(ModBlocks.CRACKED_MIXED_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MIXED_BRICKS_SLAB, ModBlocks.CRACKED_MIXED_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MIXED_BRICKS_WALL, ModBlocks.CRACKED_MIXED_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_MIXED_BRICKS, ModBlocks.CRACKED_MIXED_BRICKS_STAIRS, ModBlocks.CRACKED_MIXED_BRICKS_SLAB, ModBlocks.CRACKED_MIXED_BRICKS_WALL);

                // CALCITE BRICKS //

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE, 4)
                    .define('#', Blocks.CALCITE)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE, Blocks.CALCITE);
                stairBuilder(ModBlocks.POLISHED_CALCITE_STAIRS, Ingredient.of(ModBlocks.POLISHED_CALCITE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_CALCITE), has(ModBlocks.POLISHED_CALCITE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB, ModBlocks.POLISHED_CALCITE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_WALL, ModBlocks.POLISHED_CALCITE);
                easyStonecutting(ModBlocks.POLISHED_CALCITE, ModBlocks.POLISHED_CALCITE_STAIRS, ModBlocks.POLISHED_CALCITE_SLAB, ModBlocks.POLISHED_CALCITE_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS, 4)
                    .define('#', ModBlocks.POLISHED_CALCITE)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.POLISHED_CALCITE), has(ModBlocks.POLISHED_CALCITE))
                    .save(output);
                stairBuilder(ModBlocks.CALCITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.CALCITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CALCITE_BRICKS), has(ModBlocks.CALCITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS_SLAB, ModBlocks.CALCITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_BRICKS_WALL, ModBlocks.CALCITE_BRICKS);
                easyStonecutting(ModBlocks.CALCITE_BRICKS, ModBlocks.CALCITE_BRICKS_STAIRS, ModBlocks.CALCITE_BRICKS_SLAB, ModBlocks.CALCITE_BRICKS_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS, 4)
                    .define('#', ModBlocks.CALCITE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.CALCITE_BRICKS), has(ModBlocks.CALCITE_BRICKS))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS, ModBlocks.CALCITE_BRICKS);
                stairBuilder(ModBlocks.POLISHED_CALCITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.POLISHED_CALCITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_CALCITE_BRICKS), has(ModBlocks.POLISHED_CALCITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS_SLAB, ModBlocks.POLISHED_CALCITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_BRICKS_WALL, ModBlocks.POLISHED_CALCITE_BRICKS);
                easyStonecutting(ModBlocks.POLISHED_CALCITE_BRICKS, ModBlocks.POLISHED_CALCITE_BRICKS_STAIRS, ModBlocks.POLISHED_CALCITE_BRICKS_SLAB, ModBlocks.POLISHED_CALCITE_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CALCITE_BRICKS)
                    .requires(ModBlocks.CALCITE_BRICKS)
                    .requires(Blocks.PALE_MOSS_BLOCK)
                    .unlockedBy(getHasName(Blocks.PALE_MOSS_BLOCK), has(Blocks.PALE_MOSS_BLOCK))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_CALCITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_CALCITE_BRICKS), has(ModBlocks.MOSSY_CALCITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CALCITE_BRICKS_SLAB, ModBlocks.MOSSY_CALCITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_CALCITE_BRICKS_WALL, ModBlocks.MOSSY_CALCITE_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_CALCITE_BRICKS, ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS, ModBlocks.MOSSY_CALCITE_BRICKS_SLAB, ModBlocks.MOSSY_CALCITE_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.CALCITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_CALCITE_BRICKS, 0.1F, 200)
                .unlockedBy(getHasName(ModBlocks.CALCITE_BRICKS), has(ModBlocks.CALCITE_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_CALCITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_CALCITE_BRICKS), has(ModBlocks.CRACKED_CALCITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CALCITE_BRICKS_SLAB, ModBlocks.CRACKED_CALCITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_CALCITE_BRICKS_WALL, ModBlocks.CRACKED_CALCITE_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_CALCITE_BRICKS, ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS, ModBlocks.CRACKED_CALCITE_BRICKS_SLAB, ModBlocks.CRACKED_CALCITE_BRICKS_WALL);

                // ANDESITE BRICKS //

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS, 4)
                    .define('#', Blocks.POLISHED_ANDESITE)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(Blocks.POLISHED_ANDESITE), has(Blocks.POLISHED_ANDESITE))
                    .save(output);
                stairBuilder(ModBlocks.ANDESITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.ANDESITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.ANDESITE_BRICKS), has(ModBlocks.ANDESITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS_SLAB, ModBlocks.ANDESITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ANDESITE_BRICKS_WALL, ModBlocks.ANDESITE_BRICKS);
                easyStonecutting(ModBlocks.ANDESITE_BRICKS, ModBlocks.ANDESITE_BRICKS_STAIRS, ModBlocks.ANDESITE_BRICKS_SLAB, ModBlocks.ANDESITE_BRICKS_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS, 4)
                    .define('#', ModBlocks.ANDESITE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.ANDESITE_BRICKS), has(ModBlocks.ANDESITE_BRICKS))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS, ModBlocks.ANDESITE_BRICKS);
                stairBuilder(ModBlocks.POLISHED_ANDESITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.POLISHED_ANDESITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_ANDESITE_BRICKS), has(ModBlocks.POLISHED_ANDESITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB, ModBlocks.POLISHED_ANDESITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_BRICKS_WALL, ModBlocks.POLISHED_ANDESITE_BRICKS);
                easyStonecutting(ModBlocks.POLISHED_ANDESITE_BRICKS, ModBlocks.POLISHED_ANDESITE_BRICKS_STAIRS, ModBlocks.POLISHED_ANDESITE_BRICKS_SLAB, ModBlocks.POLISHED_ANDESITE_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_ANDESITE_BRICKS)
                    .requires(ModBlocks.ANDESITE_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy(getHasName(Blocks.VINE), has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_ANDESITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_ANDESITE_BRICKS), has(ModBlocks.MOSSY_ANDESITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB, ModBlocks.MOSSY_ANDESITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_ANDESITE_BRICKS_WALL, ModBlocks.MOSSY_ANDESITE_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_ANDESITE_BRICKS, ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS, ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB, ModBlocks.MOSSY_ANDESITE_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.ANDESITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_ANDESITE_BRICKS, 0.1F, 200)
                .unlockedBy(getHasName(ModBlocks.ANDESITE_BRICKS), has(ModBlocks.ANDESITE_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_ANDESITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_ANDESITE_BRICKS), has(ModBlocks.CRACKED_ANDESITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB, ModBlocks.CRACKED_ANDESITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ANDESITE_BRICKS_WALL, ModBlocks.CRACKED_ANDESITE_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_ANDESITE_BRICKS, ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS, ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB, ModBlocks.CRACKED_ANDESITE_BRICKS_WALL);

                // DIORITE BRICKS //

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS, 4)
                    .define('#', Blocks.POLISHED_DIORITE)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(Blocks.POLISHED_DIORITE), has(Blocks.POLISHED_DIORITE))
                    .save(output);
                stairBuilder(ModBlocks.DIORITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.DIORITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.DIORITE_BRICKS), has(ModBlocks.DIORITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS_SLAB, ModBlocks.DIORITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DIORITE_BRICKS_WALL, ModBlocks.DIORITE_BRICKS);
                easyStonecutting(ModBlocks.DIORITE_BRICKS, ModBlocks.DIORITE_BRICKS_STAIRS, ModBlocks.DIORITE_BRICKS_SLAB, ModBlocks.DIORITE_BRICKS_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS, 4)
                    .define('#', ModBlocks.DIORITE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.DIORITE_BRICKS), has(ModBlocks.DIORITE_BRICKS))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS, ModBlocks.DIORITE_BRICKS);
                stairBuilder(ModBlocks.POLISHED_DIORITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.POLISHED_DIORITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_DIORITE_BRICKS), has(ModBlocks.POLISHED_DIORITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS_SLAB, ModBlocks.POLISHED_DIORITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_BRICKS_WALL, ModBlocks.POLISHED_DIORITE_BRICKS);
                easyStonecutting(ModBlocks.POLISHED_DIORITE_BRICKS, ModBlocks.POLISHED_DIORITE_BRICKS_STAIRS, ModBlocks.POLISHED_DIORITE_BRICKS_SLAB, ModBlocks.POLISHED_DIORITE_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DIORITE_BRICKS)
                    .requires(ModBlocks.DIORITE_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy(getHasName(Blocks.VINE), has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_DIORITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_DIORITE_BRICKS), has(ModBlocks.MOSSY_DIORITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DIORITE_BRICKS_SLAB, ModBlocks.MOSSY_DIORITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DIORITE_BRICKS_WALL, ModBlocks.MOSSY_DIORITE_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_DIORITE_BRICKS, ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS, ModBlocks.MOSSY_DIORITE_BRICKS_SLAB, ModBlocks.MOSSY_DIORITE_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.DIORITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_DIORITE_BRICKS, 0.1F, 200)
                .unlockedBy(getHasName(ModBlocks.DIORITE_BRICKS), has(ModBlocks.DIORITE_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_DIORITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_DIORITE_BRICKS), has(ModBlocks.CRACKED_DIORITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DIORITE_BRICKS_SLAB, ModBlocks.CRACKED_DIORITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DIORITE_BRICKS_WALL, ModBlocks.CRACKED_DIORITE_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_DIORITE_BRICKS, ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS, ModBlocks.CRACKED_DIORITE_BRICKS_SLAB, ModBlocks.CRACKED_DIORITE_BRICKS_WALL);

                // DRIPSTONE BRICKS //

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE, 4)
                    .define('#', Blocks.DRIPSTONE_BLOCK)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(Blocks.DRIPSTONE_BLOCK), has(Blocks.DRIPSTONE_BLOCK))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK);
                stairBuilder(ModBlocks.POLISHED_DRIPSTONE_STAIRS, Ingredient.of(ModBlocks.POLISHED_DRIPSTONE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_DRIPSTONE), has(ModBlocks.POLISHED_DRIPSTONE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_SLAB, ModBlocks.POLISHED_DRIPSTONE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_WALL, ModBlocks.POLISHED_DRIPSTONE);
                easyStonecutting(ModBlocks.POLISHED_DRIPSTONE, ModBlocks.POLISHED_DRIPSTONE_STAIRS, ModBlocks.POLISHED_DRIPSTONE_SLAB, ModBlocks.POLISHED_DRIPSTONE_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS, 4)
                    .define('#', ModBlocks.POLISHED_DRIPSTONE)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.POLISHED_DRIPSTONE), has(ModBlocks.POLISHED_DRIPSTONE))
                    .save(output);
                stairBuilder(ModBlocks.DRIPSTONE_BRICKS_STAIRS, Ingredient.of(ModBlocks.DRIPSTONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.DRIPSTONE_BRICKS), has(ModBlocks.DRIPSTONE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS_SLAB, ModBlocks.DRIPSTONE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_BRICKS_WALL, ModBlocks.DRIPSTONE_BRICKS);
                easyStonecutting(ModBlocks.DRIPSTONE_BRICKS, ModBlocks.DRIPSTONE_BRICKS_STAIRS, ModBlocks.DRIPSTONE_BRICKS_SLAB, ModBlocks.DRIPSTONE_BRICKS_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS, 4)
                    .define('#', ModBlocks.DRIPSTONE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.DRIPSTONE_BRICKS), has(ModBlocks.DRIPSTONE_BRICKS))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS);
                stairBuilder(ModBlocks.POLISHED_DRIPSTONE_BRICKS_STAIRS, Ingredient.of(ModBlocks.POLISHED_DRIPSTONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_DRIPSTONE_BRICKS), has(ModBlocks.POLISHED_DRIPSTONE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB, ModBlocks.POLISHED_DRIPSTONE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS_WALL, ModBlocks.POLISHED_DRIPSTONE_BRICKS);
                easyStonecutting(ModBlocks.POLISHED_DRIPSTONE_BRICKS, ModBlocks.POLISHED_DRIPSTONE_BRICKS_STAIRS, ModBlocks.POLISHED_DRIPSTONE_BRICKS_SLAB, ModBlocks.POLISHED_DRIPSTONE_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DRIPSTONE_BRICKS)
                    .requires(ModBlocks.DRIPSTONE_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy(getHasName(Blocks.VINE), has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_DRIPSTONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_DRIPSTONE_BRICKS), has(ModBlocks.MOSSY_DRIPSTONE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB, ModBlocks.MOSSY_DRIPSTONE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL, ModBlocks.MOSSY_DRIPSTONE_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_DRIPSTONE_BRICKS, ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS, ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB, ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.DRIPSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_DRIPSTONE_BRICKS, 0.1F, 200)
                .unlockedBy(getHasName(ModBlocks.DRIPSTONE_BRICKS), has(ModBlocks.DRIPSTONE_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_DRIPSTONE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_DRIPSTONE_BRICKS), has(ModBlocks.CRACKED_DRIPSTONE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB, ModBlocks.CRACKED_DRIPSTONE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL, ModBlocks.CRACKED_DRIPSTONE_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_DRIPSTONE_BRICKS, ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS, ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB, ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL);

                // GRANITE BRICKS //

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS, 4)
                    .define('#', Blocks.POLISHED_GRANITE)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(Blocks.POLISHED_GRANITE), has(Blocks.POLISHED_GRANITE))
                    .save(output);
                stairBuilder(ModBlocks.GRANITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.GRANITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.GRANITE_BRICKS), has(ModBlocks.GRANITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS_SLAB, ModBlocks.GRANITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRANITE_BRICKS_WALL, ModBlocks.GRANITE_BRICKS);
                easyStonecutting(ModBlocks.GRANITE_BRICKS, ModBlocks.GRANITE_BRICKS_STAIRS, ModBlocks.GRANITE_BRICKS_SLAB, ModBlocks.GRANITE_BRICKS_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS, 4)
                    .define('#', ModBlocks.GRANITE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.GRANITE_BRICKS), has(ModBlocks.GRANITE_BRICKS))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS, ModBlocks.GRANITE_BRICKS);
                stairBuilder(ModBlocks.POLISHED_GRANITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.POLISHED_GRANITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_GRANITE_BRICKS), has(ModBlocks.POLISHED_GRANITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS_SLAB, ModBlocks.POLISHED_GRANITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_BRICKS_WALL, ModBlocks.POLISHED_GRANITE_BRICKS);
                easyStonecutting(ModBlocks.POLISHED_GRANITE_BRICKS, ModBlocks.POLISHED_GRANITE_BRICKS_STAIRS, ModBlocks.POLISHED_GRANITE_BRICKS_SLAB, ModBlocks.POLISHED_GRANITE_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_GRANITE_BRICKS)
                    .requires(ModBlocks.GRANITE_BRICKS)
                    .requires(Blocks.VINE)
                    .unlockedBy(getHasName(Blocks.VINE), has(Blocks.VINE))
                    .save(output);
                stairBuilder(ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.MOSSY_GRANITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.MOSSY_GRANITE_BRICKS), has(ModBlocks.MOSSY_GRANITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_GRANITE_BRICKS_SLAB, ModBlocks.MOSSY_GRANITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_GRANITE_BRICKS_WALL, ModBlocks.MOSSY_GRANITE_BRICKS);
                easyStonecutting(ModBlocks.MOSSY_GRANITE_BRICKS, ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS, ModBlocks.MOSSY_GRANITE_BRICKS_SLAB, ModBlocks.MOSSY_GRANITE_BRICKS_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.GRANITE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_GRANITE_BRICKS, 0.1F, 200)
                .unlockedBy(getHasName(ModBlocks.GRANITE_BRICKS), has(ModBlocks.GRANITE_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_GRANITE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_GRANITE_BRICKS), has(ModBlocks.CRACKED_GRANITE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_GRANITE_BRICKS_SLAB, ModBlocks.CRACKED_GRANITE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_GRANITE_BRICKS_WALL, ModBlocks.CRACKED_GRANITE_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_GRANITE_BRICKS, ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS, ModBlocks.CRACKED_GRANITE_BRICKS_SLAB, ModBlocks.CRACKED_GRANITE_BRICKS_WALL);

                // OCEANSLATE //

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE, 4)
                    .requires(Items.COPPER_NUGGET, 2)
                    .requires(Blocks.DEEPSLATE, 2)
                    .unlockedBy(getHasName(Blocks.DEEPSLATE), has(Blocks.DEEPSLATE))
                .save(output);
                stairBuilder(ModBlocks.OCEANSLATE_STAIRS, Ingredient.of(ModBlocks.OCEANSLATE))
                        .unlockedBy(getHasName(ModBlocks.OCEANSLATE), has(ModBlocks.OCEANSLATE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_SLAB, ModBlocks.OCEANSLATE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_WALL, ModBlocks.OCEANSLATE);
                easyStonecutting(ModBlocks.OCEANSLATE, ModBlocks.OCEANSLATE_STAIRS, ModBlocks.OCEANSLATE_SLAB, ModBlocks.OCEANSLATE_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_BRICKS, 4)
                    .define('#', ModBlocks.POLISHED_OCEANSLATE)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.POLISHED_OCEANSLATE), has(ModBlocks.POLISHED_OCEANSLATE))
                    .save(output);
                stairBuilder(ModBlocks.OCEANSLATE_BRICKS_STAIRS, Ingredient.of(ModBlocks.OCEANSLATE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.OCEANSLATE_BRICKS), has(ModBlocks.OCEANSLATE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_BRICKS_SLAB, ModBlocks.OCEANSLATE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_BRICKS_WALL, ModBlocks.OCEANSLATE_BRICKS);
                easyStonecutting(ModBlocks.OCEANSLATE_BRICKS, ModBlocks.OCEANSLATE_BRICKS_STAIRS, ModBlocks.OCEANSLATE_BRICKS_SLAB, ModBlocks.OCEANSLATE_BRICKS_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES, 4)
                    .define('#', ModBlocks.OCEANSLATE_BRICKS)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.OCEANSLATE_BRICKS), has(ModBlocks.OCEANSLATE_BRICKS))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES, ModBlocks.OCEANSLATE);
                stairBuilder(ModBlocks.OCEANSLATE_TILES_STAIRS, Ingredient.of(ModBlocks.OCEANSLATE_TILES))
                        .unlockedBy(getHasName(ModBlocks.OCEANSLATE_TILES), has(ModBlocks.OCEANSLATE_TILES))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES_SLAB, ModBlocks.OCEANSLATE_TILES);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEANSLATE_TILES_WALL, ModBlocks.OCEANSLATE_TILES);
                easyStonecutting(ModBlocks.OCEANSLATE_TILES, ModBlocks.OCEANSLATE_TILES_STAIRS, ModBlocks.OCEANSLATE_TILES_SLAB, ModBlocks.OCEANSLATE_TILES_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE, 4)
                    .define('#', ModBlocks.OCEANSLATE)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(getHasName(ModBlocks.OCEANSLATE), has(ModBlocks.OCEANSLATE))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE, ModBlocks.OCEANSLATE);
                stairBuilder(ModBlocks.POLISHED_OCEANSLATE_STAIRS, Ingredient.of(ModBlocks.POLISHED_OCEANSLATE))
                        .unlockedBy(getHasName(ModBlocks.POLISHED_OCEANSLATE), has(ModBlocks.POLISHED_OCEANSLATE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE_SLAB, ModBlocks.POLISHED_OCEANSLATE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_OCEANSLATE_WALL, ModBlocks.POLISHED_OCEANSLATE);
                easyStonecutting(ModBlocks.POLISHED_OCEANSLATE, ModBlocks.POLISHED_OCEANSLATE_STAIRS, ModBlocks.POLISHED_OCEANSLATE_SLAB, ModBlocks.POLISHED_OCEANSLATE_WALL);

                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.OCEANSLATE_BRICKS), RecipeCategory.BUILDING_BLOCKS,
                    ModBlocks.CRACKED_OCEANSLATE_BRICKS, 0.1F, 200)
                .unlockedBy(getHasName(ModBlocks.OCEANSLATE_BRICKS), has(ModBlocks.OCEANSLATE_BRICKS))
                .save(output);
                stairBuilder(ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS, Ingredient.of(ModBlocks.CRACKED_OCEANSLATE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.CRACKED_OCEANSLATE_BRICKS), has(ModBlocks.CRACKED_OCEANSLATE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB, ModBlocks.CRACKED_OCEANSLATE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL, ModBlocks.CRACKED_OCEANSLATE_BRICKS);
                easyStonecutting(ModBlocks.CRACKED_OCEANSLATE_BRICKS, ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS, ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB, ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_OCEANSLATE_BRICKS)
                    .requires(ModBlocks.OCEANSLATE_BRICKS)
                    .requires(Blocks.KELP)
                    .unlockedBy(getHasName(Blocks.KELP), has(Blocks.KELP))
                    .save(output);
                stairBuilder(ModBlocks.KELPY_OCEANSLATE_BRICKS_STAIRS, Ingredient.of(ModBlocks.KELPY_OCEANSLATE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.KELPY_OCEANSLATE_BRICKS), has(ModBlocks.KELPY_OCEANSLATE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB, ModBlocks.KELPY_OCEANSLATE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_OCEANSLATE_BRICKS_WALL, ModBlocks.KELPY_OCEANSLATE_BRICKS);
                easyStonecutting(ModBlocks.KELPY_OCEANSLATE_BRICKS, ModBlocks.KELPY_OCEANSLATE_BRICKS_STAIRS, ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB, ModBlocks.KELPY_OCEANSLATE_BRICKS_WALL);

                // SEATS //
                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_SEAT, 4)
                        .define('W', Blocks.RED_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.RED_WOOL), has(Blocks.RED_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ORANGE_SEAT, 4)
                        .define('W', Blocks.ORANGE_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.ORANGE_WOOL), has(Blocks.ORANGE_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.YELLOW_SEAT, 4)
                        .define('W', Blocks.YELLOW_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.YELLOW_WOOL), has(Blocks.YELLOW_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIME_SEAT, 4)
                        .define('W', Blocks.LIME_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.LIME_WOOL), has(Blocks.LIME_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_SEAT, 4)
                        .define('W', Blocks.GREEN_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.GREEN_WOOL), has(Blocks.GREEN_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CYAN_SEAT, 4)
                        .define('W', Blocks.CYAN_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.CYAN_WOOL), has(Blocks.CYAN_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_BLUE_SEAT, 4)
                        .define('W', Blocks.LIGHT_BLUE_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.LIGHT_BLUE_WOOL), has(Blocks.LIGHT_BLUE_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLUE_SEAT, 4)
                        .define('W', Blocks.BLUE_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.BLUE_WOOL), has(Blocks.BLUE_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PINK_SEAT, 4)
                        .define('W', Blocks.PINK_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.PINK_WOOL), has(Blocks.PINK_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MAGENTA_SEAT, 4)
                        .define('W', Blocks.MAGENTA_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.MAGENTA_WOOL), has(Blocks.MAGENTA_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPLE_SEAT, 4)
                        .define('W', Blocks.PURPLE_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.PURPLE_WOOL), has(Blocks.PURPLE_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BROWN_SEAT, 4)
                        .define('W', Blocks.BROWN_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.BROWN_WOOL), has(Blocks.BROWN_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LIGHT_GRAY_SEAT, 4)
                        .define('W', Blocks.LIGHT_GRAY_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.LIGHT_GRAY_WOOL), has(Blocks.LIGHT_GRAY_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAY_SEAT, 4)
                        .define('W', Blocks.GRAY_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.GRAY_WOOL), has(Blocks.GRAY_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BLACK_SEAT, 4)
                        .define('W', Blocks.BLACK_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.BLACK_WOOL), has(Blocks.BLACK_WOOL))
                        .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_SEAT, 4)
                        .define('W', Blocks.WHITE_WOOL)
                        .define('S', ItemTags.WOODEN_SLABS)
                        .pattern("WW")
                        .pattern("SS")
                        .unlockedBy(getHasName(Blocks.WHITE_WOOL), has(Blocks.WHITE_WOOL))
                        .save(output);

                List<Item> list = List.of(Items.BLACK_DYE, Items.BLUE_DYE, Items.BROWN_DYE, Items.CYAN_DYE, Items.GRAY_DYE, Items.GREEN_DYE, Items.LIGHT_BLUE_DYE, Items.LIGHT_GRAY_DYE, Items.LIME_DYE, Items.MAGENTA_DYE, Items.ORANGE_DYE, Items.PINK_DYE, Items.PURPLE_DYE, Items.RED_DYE, Items.YELLOW_DYE, Items.WHITE_DYE);
                List<Item> list2 = List.of(ModBlocks.BLACK_SEAT.asItem(), ModBlocks.BLUE_SEAT.asItem(), ModBlocks.BROWN_SEAT.asItem(), ModBlocks.CYAN_SEAT.asItem(), ModBlocks.GRAY_SEAT.asItem(), ModBlocks.GREEN_SEAT.asItem(), ModBlocks.LIGHT_BLUE_SEAT.asItem(), ModBlocks.LIGHT_GRAY_SEAT.asItem(), ModBlocks.LIME_SEAT.asItem(), ModBlocks.MAGENTA_SEAT.asItem(), ModBlocks.ORANGE_SEAT.asItem(), ModBlocks.PINK_SEAT.asItem(), ModBlocks.PURPLE_SEAT.asItem(), ModBlocks.RED_SEAT.asItem(), ModBlocks.YELLOW_SEAT.asItem(), ModBlocks.WHITE_SEAT.asItem());
                colorItemWithDye(list, list2, "seat_dye", RecipeCategory.BUILDING_BLOCKS);

                // TROWEL //

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TROWEL)
                    .define('I', Items.IRON_INGOT)
                    .define('S', Items.STICK)
                    .pattern(" I")
                    .pattern("S ")
                    .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                    .save(output);

                // ABERRANT //

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.ABERRANT_PASTE, 8)
                    .requires(Items.GLOW_BERRIES)
                    .requires(Items.AMETHYST_SHARD)
                    .requires(Items.GLOW_INK_SAC)
                    .unlockedBy(getHasName(Items.GLOW_BERRIES), has(Items.GLOW_BERRIES))
                    .save(output);

                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT)
                    .requires(ModItems.ABERRANT_PASTE, 4)
                    .unlockedBy(getHasName(ModItems.ABERRANT_PASTE), has(ModItems.ABERRANT_PASTE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SEA_LANTERN, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.SEA_LANTERN)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.SEA_LANTERN), has(Blocks.SEA_LANTERN))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_DARK_PRISMARINE, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', Blocks.DARK_PRISMARINE)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(Blocks.DARK_PRISMARINE), has(Blocks.DARK_PRISMARINE))
                        .save(output);
                stairBuilder(ModBlocks.ABERRANT_DARK_PRISMARINE_STAIRS, Ingredient.of(ModBlocks.ABERRANT_DARK_PRISMARINE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_DARK_PRISMARINE), has(ModBlocks.ABERRANT_DARK_PRISMARINE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB, ModBlocks.ABERRANT_DARK_PRISMARINE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_DARK_PRISMARINE_WALL, ModBlocks.ABERRANT_DARK_PRISMARINE);
                easyStonecutting(ModBlocks.ABERRANT_DARK_PRISMARINE, ModBlocks.ABERRANT_DARK_PRISMARINE_STAIRS, ModBlocks.ABERRANT_DARK_PRISMARINE_SLAB, ModBlocks.ABERRANT_DARK_PRISMARINE_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', Blocks.PRISMARINE)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(Blocks.PRISMARINE), has(Blocks.PRISMARINE))
                        .save(output);
                stairBuilder(ModBlocks.ABERRANT_PRISMARINE_STAIRS, Ingredient.of(ModBlocks.ABERRANT_PRISMARINE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_PRISMARINE), has(ModBlocks.ABERRANT_PRISMARINE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_SLAB, ModBlocks.ABERRANT_PRISMARINE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_WALL, ModBlocks.ABERRANT_PRISMARINE);
                easyStonecutting(ModBlocks.ABERRANT_PRISMARINE, ModBlocks.ABERRANT_PRISMARINE_STAIRS, ModBlocks.ABERRANT_PRISMARINE_SLAB, ModBlocks.ABERRANT_PRISMARINE_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_BRICKS, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', Blocks.PRISMARINE_BRICKS)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(Blocks.PRISMARINE_BRICKS), has(Blocks.PRISMARINE_BRICKS))
                        .save(output);
                stairBuilder(ModBlocks.ABERRANT_PRISMARINE_BRICKS_STAIRS, Ingredient.of(ModBlocks.ABERRANT_PRISMARINE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_PRISMARINE_BRICKS), has(ModBlocks.ABERRANT_PRISMARINE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB, ModBlocks.ABERRANT_PRISMARINE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_BRICKS_STAIRS, ModBlocks.ABERRANT_PRISMARINE_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PRISMARINE_BRICKS_SLAB, ModBlocks.ABERRANT_PRISMARINE_BRICKS, 2);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', ModBlocks.OCEANSLATE)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(ModBlocks.OCEANSLATE), has(ModBlocks.OCEANSLATE))
                        .save(output);
                stairBuilder(ModBlocks.ABERRANT_OCEANSLATE_STAIRS, Ingredient.of(ModBlocks.ABERRANT_OCEANSLATE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_OCEANSLATE), has(ModBlocks.ABERRANT_OCEANSLATE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_SLAB, ModBlocks.ABERRANT_OCEANSLATE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_WALL, ModBlocks.ABERRANT_OCEANSLATE);
                easyStonecutting(ModBlocks.ABERRANT_OCEANSLATE, ModBlocks.ABERRANT_OCEANSLATE_STAIRS, ModBlocks.ABERRANT_OCEANSLATE_SLAB, ModBlocks.ABERRANT_OCEANSLATE_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_POLISHED_OCEANSLATE, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', ModBlocks.POLISHED_OCEANSLATE)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(ModBlocks.POLISHED_OCEANSLATE), has(ModBlocks.POLISHED_OCEANSLATE))
                        .save(output);
                stairBuilder(ModBlocks.ABERRANT_POLISHED_OCEANSLATE_STAIRS, Ingredient.of(ModBlocks.ABERRANT_POLISHED_OCEANSLATE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_POLISHED_OCEANSLATE), has(ModBlocks.ABERRANT_POLISHED_OCEANSLATE))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB, ModBlocks.ABERRANT_POLISHED_OCEANSLATE);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_POLISHED_OCEANSLATE_WALL, ModBlocks.ABERRANT_POLISHED_OCEANSLATE);
                easyStonecutting(ModBlocks.ABERRANT_POLISHED_OCEANSLATE, ModBlocks.ABERRANT_POLISHED_OCEANSLATE_STAIRS, ModBlocks.ABERRANT_POLISHED_OCEANSLATE_SLAB, ModBlocks.ABERRANT_POLISHED_OCEANSLATE_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_TILES, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', ModBlocks.OCEANSLATE_TILES)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(ModBlocks.OCEANSLATE_TILES), has(ModBlocks.OCEANSLATE_TILES))
                        .save(output);
                stairBuilder(ModBlocks.ABERRANT_OCEANSLATE_TILES_STAIRS, Ingredient.of(ModBlocks.ABERRANT_OCEANSLATE_TILES))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_OCEANSLATE_TILES), has(ModBlocks.ABERRANT_OCEANSLATE_TILES))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB, ModBlocks.ABERRANT_OCEANSLATE_TILES);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_TILES_WALL, ModBlocks.ABERRANT_OCEANSLATE_TILES);
                easyStonecutting(ModBlocks.ABERRANT_OCEANSLATE_TILES, ModBlocks.ABERRANT_OCEANSLATE_TILES_STAIRS, ModBlocks.ABERRANT_OCEANSLATE_TILES_SLAB, ModBlocks.ABERRANT_OCEANSLATE_TILES_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', ModBlocks.OCEANSLATE_BRICKS)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(ModBlocks.OCEANSLATE_BRICKS), has(ModBlocks.OCEANSLATE_BRICKS))
                        .save(output);
                stairBuilder(ModBlocks.ABERRANT_OCEANSLATE_BRICKS_STAIRS, Ingredient.of(ModBlocks.ABERRANT_OCEANSLATE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_OCEANSLATE_BRICKS), has(ModBlocks.ABERRANT_OCEANSLATE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB, ModBlocks.ABERRANT_OCEANSLATE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS_WALL, ModBlocks.ABERRANT_OCEANSLATE_BRICKS);
                easyStonecutting(ModBlocks.ABERRANT_OCEANSLATE_BRICKS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS_STAIRS, ModBlocks.ABERRANT_OCEANSLATE_BRICKS_SLAB, ModBlocks.ABERRANT_OCEANSLATE_BRICKS_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', ModBlocks.CRACKED_OCEANSLATE_BRICKS)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(ModBlocks.CRACKED_OCEANSLATE_BRICKS), has(ModBlocks.CRACKED_OCEANSLATE_BRICKS))
                        .save(output);
                easyStonecutting(ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_STAIRS, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_SLAB, ModBlocks.CRACKED_ABERRANT_OCEANSLATE_BRICKS_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS, 8)
                        .define('P', ModItems.ABERRANT_PASTE)
                        .define('B', ModBlocks.KELPY_OCEANSLATE_BRICKS)
                        .pattern("BBB")
                        .pattern("BPB")
                        .pattern("BBB")
                        .unlockedBy(getHasName(ModBlocks.KELPY_OCEANSLATE_BRICKS), has(ModBlocks.KELPY_OCEANSLATE_BRICKS))
                        .save(output);
                stairBuilder(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_STAIRS, Ingredient.of(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS))
                        .unlockedBy(getHasName(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS), has(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS))
                        .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS);
                wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_WALL, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS);
                easyStonecutting(ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_STAIRS, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_SLAB, ModBlocks.KELPY_ABERRANT_OCEANSLATE_BRICKS_WALL);

                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE, Blocks.SOUL_SAND);
                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_SLAB,
                        Ingredient.of(ModBlocks.SOUL_SANDSTONE, ModBlocks.CHISELED_SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.SOUL_SANDSTONE), has(ModBlocks.SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.CHISELED_SOUL_SANDSTONE), has(ModBlocks.CHISELED_SOUL_SANDSTONE))
                        .save(output);
                stairBuilder(ModBlocks.SOUL_SANDSTONE_STAIRS,
                        Ingredient.of(ModBlocks.SOUL_SANDSTONE, ModBlocks.CHISELED_SOUL_SANDSTONE, ModBlocks.CUT_SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.SOUL_SANDSTONE), has(ModBlocks.SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.CHISELED_SOUL_SANDSTONE), has(ModBlocks.CHISELED_SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.CUT_SOUL_SANDSTONE), has(ModBlocks.CUT_SOUL_SANDSTONE))
                        .save(output);
                wall(RecipeCategory.DECORATIONS, ModBlocks.SOUL_SANDSTONE_WALL, ModBlocks.SOUL_SANDSTONE);
                chiseled(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE_SLAB);
                cut(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);

                SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.SOUL_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SOUL_SANDSTONE.asItem(),0.1f, 200)
                    .unlockedBy(getHasName(ModBlocks.SOUL_SANDSTONE), has(ModBlocks.SOUL_SANDSTONE))
                    .save(output);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_SLAB, ModBlocks.SOUL_SANDSTONE, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SOUL_SANDSTONE_STAIRS, ModBlocks.SOUL_SANDSTONE);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SOUL_SANDSTONE_WALL, ModBlocks.SOUL_SANDSTONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SOUL_SANDSTONE, ModBlocks.SOUL_SANDSTONE);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SOUL_SANDSTONE_SLAB, ModBlocks.SMOOTH_SOUL_SANDSTONE, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SOUL_SANDSTONE_STAIRS, ModBlocks.SMOOTH_SOUL_SANDSTONE);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.TERRACOTTA), has(Blocks.TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.RED_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.RED_WOOL), has(Blocks.RED_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_RED_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_RED_WOOL), has(ModBlocks.ABERRANT_RED_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.RED_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.RED_CONCRETE), has(Blocks.RED_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.RED_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.RED_CONCRETE_POWDER), has(Blocks.RED_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.RED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.RED_TERRACOTTA), has(Blocks.RED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.RED_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.RED_GLAZED_TERRACOTTA), has(Blocks.RED_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.ORANGE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.ORANGE_WOOL), has(Blocks.ORANGE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_ORANGE_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_ORANGE_WOOL), has(ModBlocks.ABERRANT_ORANGE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.ORANGE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.ORANGE_CONCRETE), has(Blocks.ORANGE_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.ORANGE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.ORANGE_CONCRETE_POWDER), has(Blocks.ORANGE_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.ORANGE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.ORANGE_TERRACOTTA), has(Blocks.ORANGE_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.ORANGE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.ORANGE_GLAZED_TERRACOTTA), has(Blocks.ORANGE_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.YELLOW_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.YELLOW_WOOL), has(Blocks.YELLOW_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_YELLOW_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_YELLOW_WOOL), has(ModBlocks.ABERRANT_YELLOW_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.YELLOW_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.YELLOW_CONCRETE), has(Blocks.YELLOW_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.YELLOW_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.YELLOW_CONCRETE_POWDER), has(Blocks.YELLOW_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.YELLOW_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.YELLOW_TERRACOTTA), has(Blocks.YELLOW_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.YELLOW_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.YELLOW_GLAZED_TERRACOTTA), has(Blocks.YELLOW_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIME_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIME_WOOL), has(Blocks.LIME_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_LIME_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_LIME_WOOL), has(ModBlocks.ABERRANT_LIME_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIME_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIME_CONCRETE), has(Blocks.LIME_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIME_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIME_CONCRETE_POWDER), has(Blocks.LIME_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIME_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIME_TERRACOTTA), has(Blocks.LIME_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIME_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIME_GLAZED_TERRACOTTA), has(Blocks.LIME_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GREEN_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GREEN_WOOL), has(Blocks.GREEN_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_GREEN_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_GREEN_WOOL), has(ModBlocks.ABERRANT_GREEN_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GREEN_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GREEN_CONCRETE), has(Blocks.GREEN_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GREEN_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GREEN_CONCRETE_POWDER), has(Blocks.GREEN_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GREEN_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GREEN_TERRACOTTA), has(Blocks.GREEN_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GREEN_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GREEN_GLAZED_TERRACOTTA), has(Blocks.GREEN_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.CYAN_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.CYAN_WOOL), has(Blocks.CYAN_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_CYAN_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_CYAN_WOOL), has(ModBlocks.ABERRANT_CYAN_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.CYAN_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.CYAN_CONCRETE), has(Blocks.CYAN_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.CYAN_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.CYAN_CONCRETE_POWDER), has(Blocks.CYAN_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.CYAN_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.CYAN_TERRACOTTA), has(Blocks.CYAN_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.CYAN_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.CYAN_GLAZED_TERRACOTTA), has(Blocks.CYAN_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_BLUE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_BLUE_WOOL), has(Blocks.LIGHT_BLUE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_LIGHT_BLUE_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL), has(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_BLUE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_BLUE_CONCRETE), has(Blocks.LIGHT_BLUE_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_BLUE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_BLUE_CONCRETE_POWDER), has(Blocks.LIGHT_BLUE_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_BLUE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_BLUE_TERRACOTTA), has(Blocks.LIGHT_BLUE_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA), has(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLUE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLUE_WOOL), has(Blocks.BLUE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_BLUE_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_BLUE_WOOL), has(ModBlocks.ABERRANT_BLUE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLUE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLUE_CONCRETE), has(Blocks.BLUE_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLUE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLUE_CONCRETE_POWDER), has(Blocks.BLUE_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLUE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLUE_TERRACOTTA), has(Blocks.BLUE_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLUE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLUE_GLAZED_TERRACOTTA), has(Blocks.BLUE_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PINK_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PINK_WOOL), has(Blocks.PINK_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_PINK_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_PINK_WOOL), has(ModBlocks.ABERRANT_PINK_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PINK_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PINK_CONCRETE), has(Blocks.PINK_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PINK_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PINK_CONCRETE_POWDER), has(Blocks.PINK_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PINK_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PINK_TERRACOTTA), has(Blocks.PINK_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PINK_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PINK_GLAZED_TERRACOTTA), has(Blocks.PINK_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.MAGENTA_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.MAGENTA_WOOL), has(Blocks.MAGENTA_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_MAGENTA_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_MAGENTA_WOOL), has(ModBlocks.ABERRANT_MAGENTA_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.MAGENTA_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.MAGENTA_CONCRETE), has(Blocks.MAGENTA_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.MAGENTA_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.MAGENTA_CONCRETE_POWDER), has(Blocks.MAGENTA_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.MAGENTA_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.MAGENTA_TERRACOTTA), has(Blocks.MAGENTA_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.MAGENTA_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.MAGENTA_GLAZED_TERRACOTTA), has(Blocks.MAGENTA_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PURPLE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PURPLE_WOOL), has(Blocks.PURPLE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_PURPLE_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_PURPLE_WOOL), has(ModBlocks.ABERRANT_PURPLE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PURPLE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PURPLE_CONCRETE), has(Blocks.PURPLE_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PURPLE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PURPLE_CONCRETE_POWDER), has(Blocks.PURPLE_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PURPLE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PURPLE_TERRACOTTA), has(Blocks.PURPLE_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PURPLE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PURPLE_GLAZED_TERRACOTTA), has(Blocks.PURPLE_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BROWN_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BROWN_WOOL), has(Blocks.BROWN_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_BROWN_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_BROWN_WOOL), has(ModBlocks.ABERRANT_BROWN_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BROWN_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BROWN_CONCRETE), has(Blocks.BROWN_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BROWN_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BROWN_CONCRETE_POWDER), has(Blocks.BROWN_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BROWN_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BROWN_TERRACOTTA), has(Blocks.BROWN_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BROWN_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BROWN_GLAZED_TERRACOTTA), has(Blocks.BROWN_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLACK_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLACK_WOOL), has(Blocks.BLACK_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_BLACK_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_BLACK_WOOL), has(ModBlocks.ABERRANT_BLACK_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLACK_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLACK_CONCRETE), has(Blocks.BLACK_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLACK_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLACK_CONCRETE_POWDER), has(Blocks.BLACK_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLACK_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLACK_TERRACOTTA), has(Blocks.BLACK_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLACK_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLACK_GLAZED_TERRACOTTA), has(Blocks.BLACK_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GRAY_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GRAY_WOOL), has(Blocks.GRAY_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_GRAY_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_GRAY_WOOL), has(ModBlocks.ABERRANT_GRAY_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GRAY_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GRAY_CONCRETE), has(Blocks.GRAY_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GRAY_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GRAY_CONCRETE_POWDER), has(Blocks.GRAY_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GRAY_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GRAY_TERRACOTTA), has(Blocks.GRAY_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GRAY_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GRAY_GLAZED_TERRACOTTA), has(Blocks.GRAY_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_GRAY_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_GRAY_WOOL), has(Blocks.LIGHT_GRAY_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_LIGHT_GRAY_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL), has(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_GRAY_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_GRAY_CONCRETE), has(Blocks.LIGHT_GRAY_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_GRAY_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_GRAY_CONCRETE_POWDER), has(Blocks.LIGHT_GRAY_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_GRAY_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_GRAY_TERRACOTTA), has(Blocks.LIGHT_GRAY_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA), has(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_WOOL, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.WHITE_WOOL)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.WHITE_WOOL), has(Blocks.WHITE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_SEAT, 4)
                    .define('W', ModBlocks.ABERRANT_WHITE_WOOL)
                    .define('S', ItemTags.WOODEN_SLABS)
                    .pattern("WW")
                    .pattern("SS")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_WHITE_WOOL), has(ModBlocks.ABERRANT_WHITE_WOOL))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_CONCRETE, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.WHITE_CONCRETE)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.WHITE_CONCRETE), has(Blocks.WHITE_CONCRETE))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_CONCRETE_POWER, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.WHITE_CONCRETE_POWDER)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.WHITE_CONCRETE_POWDER), has(Blocks.WHITE_CONCRETE_POWDER))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.WHITE_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.WHITE_TERRACOTTA), has(Blocks.WHITE_TERRACOTTA))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_GLAZED_TERRACOTTA, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.WHITE_GLAZED_TERRACOTTA)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.WHITE_GLAZED_TERRACOTTA), has(Blocks.WHITE_GLAZED_TERRACOTTA))
                    .save(output);

                easyRecipe(ModBlocks.ABERRANT_RED_WOOL, ModBlocks.ABERRANT_RED_WOOL_STAIRS, ModBlocks.ABERRANT_RED_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_RED_CONCRETE, ModBlocks.ABERRANT_RED_CONCRETE_STAIRS, ModBlocks.ABERRANT_RED_CONCRETE_SLAB, ModBlocks.ABERRANT_RED_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_RED_TERRACOTTA, ModBlocks.ABERRANT_RED_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_RED_TERRACOTTA_SLAB, ModBlocks.ABERRANT_RED_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_ORANGE_WOOL, ModBlocks.ABERRANT_ORANGE_WOOL_STAIRS, ModBlocks.ABERRANT_ORANGE_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_ORANGE_CONCRETE, ModBlocks.ABERRANT_ORANGE_CONCRETE_STAIRS, ModBlocks.ABERRANT_ORANGE_CONCRETE_SLAB, ModBlocks.ABERRANT_ORANGE_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_ORANGE_TERRACOTTA, ModBlocks.ABERRANT_ORANGE_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_ORANGE_TERRACOTTA_SLAB, ModBlocks.ABERRANT_ORANGE_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_YELLOW_WOOL, ModBlocks.ABERRANT_YELLOW_WOOL_STAIRS, ModBlocks.ABERRANT_YELLOW_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_YELLOW_CONCRETE, ModBlocks.ABERRANT_YELLOW_CONCRETE_STAIRS, ModBlocks.ABERRANT_YELLOW_CONCRETE_SLAB, ModBlocks.ABERRANT_YELLOW_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_YELLOW_TERRACOTTA, ModBlocks.ABERRANT_YELLOW_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_YELLOW_TERRACOTTA_SLAB, ModBlocks.ABERRANT_YELLOW_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_LIME_WOOL, ModBlocks.ABERRANT_LIME_WOOL_STAIRS, ModBlocks.ABERRANT_LIME_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_LIME_CONCRETE, ModBlocks.ABERRANT_LIME_CONCRETE_STAIRS, ModBlocks.ABERRANT_LIME_CONCRETE_SLAB, ModBlocks.ABERRANT_LIME_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_LIME_TERRACOTTA, ModBlocks.ABERRANT_LIME_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_LIME_TERRACOTTA_SLAB, ModBlocks.ABERRANT_LIME_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_GREEN_WOOL, ModBlocks.ABERRANT_GREEN_WOOL_STAIRS, ModBlocks.ABERRANT_GREEN_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_GREEN_CONCRETE, ModBlocks.ABERRANT_GREEN_CONCRETE_STAIRS, ModBlocks.ABERRANT_GREEN_CONCRETE_SLAB, ModBlocks.ABERRANT_GREEN_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_GREEN_TERRACOTTA, ModBlocks.ABERRANT_GREEN_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_GREEN_TERRACOTTA_SLAB, ModBlocks.ABERRANT_GREEN_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_CYAN_WOOL, ModBlocks.ABERRANT_CYAN_WOOL_STAIRS, ModBlocks.ABERRANT_CYAN_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_CYAN_CONCRETE, ModBlocks.ABERRANT_CYAN_CONCRETE_STAIRS, ModBlocks.ABERRANT_CYAN_CONCRETE_SLAB, ModBlocks.ABERRANT_CYAN_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_CYAN_TERRACOTTA, ModBlocks.ABERRANT_CYAN_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_CYAN_TERRACOTTA_SLAB, ModBlocks.ABERRANT_CYAN_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_LIGHT_BLUE_WOOL, ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_STAIRS, ModBlocks.ABERRANT_LIGHT_BLUE_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_STAIRS, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_SLAB, ModBlocks.ABERRANT_LIGHT_BLUE_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA, ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_SLAB, ModBlocks.ABERRANT_LIGHT_BLUE_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_BLUE_WOOL, ModBlocks.ABERRANT_BLUE_WOOL_STAIRS, ModBlocks.ABERRANT_BLUE_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_BLUE_CONCRETE, ModBlocks.ABERRANT_BLUE_CONCRETE_STAIRS, ModBlocks.ABERRANT_BLUE_CONCRETE_SLAB, ModBlocks.ABERRANT_BLUE_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_BLUE_TERRACOTTA, ModBlocks.ABERRANT_BLUE_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_BLUE_TERRACOTTA_SLAB, ModBlocks.ABERRANT_BLUE_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_PINK_WOOL, ModBlocks.ABERRANT_PINK_WOOL_STAIRS, ModBlocks.ABERRANT_PINK_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_PINK_CONCRETE, ModBlocks.ABERRANT_PINK_CONCRETE_STAIRS, ModBlocks.ABERRANT_PINK_CONCRETE_SLAB, ModBlocks.ABERRANT_PINK_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_PINK_TERRACOTTA, ModBlocks.ABERRANT_PINK_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_PINK_TERRACOTTA_SLAB, ModBlocks.ABERRANT_PINK_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_MAGENTA_WOOL, ModBlocks.ABERRANT_MAGENTA_WOOL_STAIRS, ModBlocks.ABERRANT_MAGENTA_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_MAGENTA_CONCRETE, ModBlocks.ABERRANT_MAGENTA_CONCRETE_STAIRS, ModBlocks.ABERRANT_MAGENTA_CONCRETE_SLAB, ModBlocks.ABERRANT_MAGENTA_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_MAGENTA_TERRACOTTA, ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_SLAB, ModBlocks.ABERRANT_MAGENTA_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_PURPLE_WOOL, ModBlocks.ABERRANT_PURPLE_WOOL_STAIRS, ModBlocks.ABERRANT_PURPLE_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_PURPLE_CONCRETE, ModBlocks.ABERRANT_PURPLE_CONCRETE_STAIRS, ModBlocks.ABERRANT_PURPLE_CONCRETE_SLAB, ModBlocks.ABERRANT_PURPLE_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_PURPLE_TERRACOTTA, ModBlocks.ABERRANT_PURPLE_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_PURPLE_TERRACOTTA_SLAB, ModBlocks.ABERRANT_PURPLE_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_BROWN_WOOL, ModBlocks.ABERRANT_BROWN_WOOL_STAIRS, ModBlocks.ABERRANT_BROWN_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_BROWN_CONCRETE, ModBlocks.ABERRANT_BROWN_CONCRETE_STAIRS, ModBlocks.ABERRANT_BROWN_CONCRETE_SLAB, ModBlocks.ABERRANT_BROWN_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_BROWN_TERRACOTTA, ModBlocks.ABERRANT_BROWN_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_BROWN_TERRACOTTA_SLAB, ModBlocks.ABERRANT_BROWN_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_BLACK_WOOL, ModBlocks.ABERRANT_BLACK_WOOL_STAIRS, ModBlocks.ABERRANT_BLACK_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_BLACK_CONCRETE, ModBlocks.ABERRANT_BLACK_CONCRETE_STAIRS, ModBlocks.ABERRANT_BLACK_CONCRETE_SLAB, ModBlocks.ABERRANT_BLACK_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_BLACK_TERRACOTTA, ModBlocks.ABERRANT_BLACK_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_BLACK_TERRACOTTA_SLAB, ModBlocks.ABERRANT_BLACK_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_GRAY_WOOL, ModBlocks.ABERRANT_GRAY_WOOL_STAIRS, ModBlocks.ABERRANT_GRAY_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_GRAY_CONCRETE, ModBlocks.ABERRANT_GRAY_CONCRETE_STAIRS, ModBlocks.ABERRANT_GRAY_CONCRETE_SLAB, ModBlocks.ABERRANT_GRAY_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_GRAY_TERRACOTTA, ModBlocks.ABERRANT_GRAY_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_GRAY_TERRACOTTA_SLAB, ModBlocks.ABERRANT_GRAY_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_LIGHT_GRAY_WOOL, ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_STAIRS, ModBlocks.ABERRANT_LIGHT_GRAY_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_STAIRS, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_SLAB, ModBlocks.ABERRANT_LIGHT_GRAY_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA, ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_SLAB, ModBlocks.ABERRANT_LIGHT_GRAY_TERRACOTTA_WALL);

                easyRecipe(ModBlocks.ABERRANT_WHITE_WOOL, ModBlocks.ABERRANT_WHITE_WOOL_STAIRS, ModBlocks.ABERRANT_WHITE_WOOL_SLAB);
                easyRecipe(ModBlocks.ABERRANT_WHITE_CONCRETE, ModBlocks.ABERRANT_WHITE_CONCRETE_STAIRS, ModBlocks.ABERRANT_WHITE_CONCRETE_SLAB, ModBlocks.ABERRANT_WHITE_CONCRETE_WALL);
                easyRecipe(ModBlocks.ABERRANT_WHITE_TERRACOTTA, ModBlocks.ABERRANT_WHITE_TERRACOTTA_STAIRS, ModBlocks.ABERRANT_WHITE_TERRACOTTA_SLAB, ModBlocks.ABERRANT_WHITE_TERRACOTTA_WALL);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_RED_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.RED_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.RED_CARPET), has(Blocks.RED_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_ORANGE_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.ORANGE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.ORANGE_CARPET), has(Blocks.ORANGE_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_YELLOW_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.YELLOW_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.YELLOW_CARPET), has(Blocks.YELLOW_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIME_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIME_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIME_CARPET), has(Blocks.LIME_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GREEN_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GREEN_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GREEN_CARPET), has(Blocks.GREEN_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CYAN_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.CYAN_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.CYAN_CARPET), has(Blocks.CYAN_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_BLUE_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_BLUE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_BLUE_CARPET), has(Blocks.LIGHT_BLUE_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLUE_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLUE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLUE_CARPET), has(Blocks.BLUE_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PINK_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PINK_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PINK_CARPET), has(Blocks.PINK_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_MAGENTA_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.MAGENTA_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.MAGENTA_CARPET), has(Blocks.MAGENTA_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_PURPLE_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.PURPLE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.PURPLE_CARPET), has(Blocks.PURPLE_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BROWN_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BROWN_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BROWN_CARPET), has(Blocks.BROWN_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_BLACK_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.BLACK_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.BLACK_CARPET), has(Blocks.BLACK_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_GRAY_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.GRAY_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.GRAY_CARPET), has(Blocks.GRAY_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_LIGHT_GRAY_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.LIGHT_GRAY_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.LIGHT_GRAY_CARPET), has(Blocks.LIGHT_GRAY_CARPET))
                    .save(output);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_WHITE_CARPET, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', Blocks.WHITE_CARPET)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(Blocks.WHITE_CARPET), has(Blocks.WHITE_CARPET))
                    .save(output);

                // Custom Resin //

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.BEETROOT_RESIN_CLUMP, 9)
                    .define('D', Items.RED_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.BEETROOT_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BLOCK)
                    .requires(ModItems.BEETROOT_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.BEETROOT_RESIN_CLUMP), has(ModItems.BEETROOT_RESIN_CLUMP))
                    .save(output);
                easyStonecutting(ModBlocks.BEETROOT_RESIN_BLOCK, ModBlocks.BEETROOT_RESIN_BLOCK_STAIRS, ModBlocks.BEETROOT_RESIN_BLOCK_SLAB, ModBlocks.BEETROOT_RESIN_BLOCK_WALL);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.BEETROOT_RESIN_CLUMP), RecipeCategory.MISC, ModItems.BEETROOT_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.BEETROOT_RESIN_CLUMP), has(ModItems.BEETROOT_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_RESIN_BRICKS, ModItems.BEETROOT_RESIN_BRICK);

                easyStonecutting(ModBlocks.BEETROOT_RESIN_BRICKS, ModBlocks.BEETROOT_RESIN_BRICKS_STAIRS, ModBlocks.BEETROOT_RESIN_BRICKS_SLAB, ModBlocks.BEETROOT_RESIN_BRICKS_WALL);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BEETROOT_RESIN_BRICKS, ModBlocks.BEETROOT_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.CHORUS_RESIN_CLUMP, 9)
                    .define('D', Items.PURPLE_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BLOCK)
                    .requires(ModItems.CHORUS_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.CHORUS_RESIN_CLUMP), has(ModItems.CHORUS_RESIN_CLUMP))
                    .save(output);
                easyStonecutting(ModBlocks.CHORUS_RESIN_BLOCK, ModBlocks.CHORUS_RESIN_BLOCK_STAIRS, ModBlocks.CHORUS_RESIN_BLOCK_SLAB, ModBlocks.CHORUS_RESIN_BLOCK_WALL);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.CHORUS_RESIN_CLUMP), RecipeCategory.MISC, ModItems.CHORUS_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.CHORUS_RESIN_CLUMP), has(ModItems.CHORUS_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHORUS_RESIN_BRICKS, ModItems.CHORUS_RESIN_BRICK);

                easyStonecutting(ModBlocks.CHORUS_RESIN_BRICKS, ModBlocks.CHORUS_RESIN_BRICKS_STAIRS, ModBlocks.CHORUS_RESIN_BRICKS_SLAB, ModBlocks.CHORUS_RESIN_BRICKS_WALL);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CHORUS_RESIN_BRICKS, ModBlocks.CHORUS_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.LEMON_RESIN_CLUMP, 9)
                    .define('D', Items.YELLOW_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BLOCK)
                    .requires(ModItems.LEMON_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.LEMON_RESIN_CLUMP), has(ModItems.LEMON_RESIN_CLUMP))
                    .save(output);
                easyStonecutting(ModBlocks.LEMON_RESIN_BLOCK, ModBlocks.LEMON_RESIN_BLOCK_STAIRS, ModBlocks.LEMON_RESIN_BLOCK_SLAB, ModBlocks.LEMON_RESIN_BLOCK_WALL);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.LEMON_RESIN_CLUMP), RecipeCategory.MISC, ModItems.LEMON_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.LEMON_RESIN_CLUMP), has(ModItems.LEMON_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_RESIN_BRICKS, ModItems.LEMON_RESIN_BRICK);

                easyStonecutting(ModBlocks.LEMON_RESIN_BRICKS, ModBlocks.LEMON_RESIN_BRICKS_STAIRS, ModBlocks.LEMON_RESIN_BRICKS_SLAB, ModBlocks.LEMON_RESIN_BRICKS_WALL);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_LEMON_RESIN_BRICKS, ModBlocks.LEMON_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GLACIER_RESIN_CLUMP, 9)
                    .define('D', Items.LIGHT_BLUE_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BLOCK)
                    .requires(ModItems.GLACIER_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.GLACIER_RESIN_CLUMP), has(ModItems.GLACIER_RESIN_CLUMP))
                    .save(output);
                easyStonecutting(ModBlocks.GLACIER_RESIN_BLOCK, ModBlocks.GLACIER_RESIN_BLOCK_STAIRS, ModBlocks.GLACIER_RESIN_BLOCK_SLAB, ModBlocks.GLACIER_RESIN_BLOCK_WALL);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.GLACIER_RESIN_CLUMP), RecipeCategory.MISC, ModItems.GLACIER_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.GLACIER_RESIN_CLUMP), has(ModItems.GLACIER_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_RESIN_BRICKS, ModItems.GLACIER_RESIN_BRICK);

                easyStonecutting(ModBlocks.GLACIER_RESIN_BRICKS, ModBlocks.GLACIER_RESIN_BRICKS_STAIRS, ModBlocks.GLACIER_RESIN_BRICKS_SLAB, ModBlocks.GLACIER_RESIN_BRICKS_WALL);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GLACIER_RESIN_BRICKS, ModBlocks.GLACIER_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.CARAMEL_RESIN_CLUMP, 9)
                    .define('D', Items.ORANGE_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BLOCK)
                    .requires(ModItems.CARAMEL_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.CARAMEL_RESIN_CLUMP), has(ModItems.CARAMEL_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BLOCK_STAIRS, ModBlocks.CARAMEL_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.CARAMEL_RESIN_BLOCK_SLAB, ModBlocks.CARAMEL_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BLOCK_WALL, ModBlocks.CARAMEL_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.CARAMEL_RESIN_CLUMP), RecipeCategory.MISC, ModItems.CARAMEL_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.CARAMEL_RESIN_CLUMP), has(ModItems.CARAMEL_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_RESIN_BRICKS, ModItems.CARAMEL_RESIN_BRICK);

                easyStonecutting(ModBlocks.CARAMEL_RESIN_BRICKS, ModBlocks.CARAMEL_RESIN_BRICKS_STAIRS, ModBlocks.CARAMEL_RESIN_BRICKS_SLAB, ModBlocks.CARAMEL_RESIN_BRICKS_WALL);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_CARAMEL_RESIN_BRICKS, ModBlocks.CARAMEL_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.TOXIC_RESIN_CLUMP, 9)
                    .define('D', Items.LIME_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BLOCK)
                    .requires(ModItems.TOXIC_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.TOXIC_RESIN_CLUMP), has(ModItems.TOXIC_RESIN_CLUMP))
                    .save(output);
                easyStonecutting(ModBlocks.TOXIC_RESIN_BLOCK, ModBlocks.TOXIC_RESIN_BLOCK_STAIRS, ModBlocks.TOXIC_RESIN_BLOCK_SLAB, ModBlocks.TOXIC_RESIN_BLOCK_WALL);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.TOXIC_RESIN_CLUMP), RecipeCategory.MISC, ModItems.TOXIC_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.TOXIC_RESIN_CLUMP), has(ModItems.TOXIC_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_RESIN_BRICKS, ModItems.TOXIC_RESIN_BRICK);

                easyStonecutting(ModBlocks.TOXIC_RESIN_BRICKS, ModBlocks.TOXIC_RESIN_BRICKS_STAIRS, ModBlocks.TOXIC_RESIN_BRICKS_SLAB, ModBlocks.TOXIC_RESIN_BRICKS_WALL);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_TOXIC_RESIN_BRICKS, ModBlocks.TOXIC_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.JADE_RESIN_CLUMP, 9)
                    .define('D', Items.CYAN_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BLOCK)
                    .requires(ModItems.JADE_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.JADE_RESIN_CLUMP), has(ModItems.JADE_RESIN_CLUMP))
                    .save(output);
                easyStonecutting(ModBlocks.JADE_RESIN_BLOCK, ModBlocks.JADE_RESIN_BLOCK_STAIRS, ModBlocks.JADE_RESIN_BLOCK_SLAB, ModBlocks.JADE_RESIN_BLOCK_WALL);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.JADE_RESIN_CLUMP), RecipeCategory.MISC, ModItems.JADE_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.JADE_RESIN_CLUMP), has(ModItems.JADE_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_RESIN_BRICKS, ModItems.JADE_RESIN_BRICK);

                easyStonecutting(ModBlocks.JADE_RESIN_BRICKS, ModBlocks.JADE_RESIN_BRICKS_STAIRS, ModBlocks.JADE_RESIN_BRICKS_SLAB, ModBlocks.JADE_RESIN_BRICKS_WALL);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_JADE_RESIN_BRICKS, ModBlocks.JADE_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.BUBBLE_RESIN_CLUMP, 9)
                    .define('D', Items.CYAN_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BLOCK)
                    .requires(ModItems.BUBBLE_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.BUBBLE_RESIN_CLUMP), has(ModItems.BUBBLE_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BLOCK_STAIRS, ModBlocks.BUBBLE_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BUBBLE_RESIN_BLOCK_SLAB, ModBlocks.BUBBLE_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BLOCK_WALL, ModBlocks.BUBBLE_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.BUBBLE_RESIN_CLUMP), RecipeCategory.MISC, ModItems.BUBBLE_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.BUBBLE_RESIN_CLUMP), has(ModItems.BUBBLE_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BRICKS, ModItems.BUBBLE_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BRICKS_SLAB, ModBlocks.BUBBLE_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_RESIN_BRICKS_STAIRS, ModBlocks.BUBBLE_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.BUBBLE_RESIN_BRICKS_WALL, ModBlocks.BUBBLE_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_BUBBLE_RESIN_BRICKS, ModBlocks.BUBBLE_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.OCEAN_RESIN_CLUMP, 9)
                    .define('D', Items.BLUE_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BLOCK)
                    .requires(ModItems.OCEAN_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.OCEAN_RESIN_CLUMP), has(ModItems.OCEAN_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BLOCK_STAIRS, ModBlocks.OCEAN_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.OCEAN_RESIN_BLOCK_SLAB, ModBlocks.OCEAN_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BLOCK_WALL, ModBlocks.OCEAN_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.OCEAN_RESIN_CLUMP), RecipeCategory.MISC, ModItems.OCEAN_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.OCEAN_RESIN_CLUMP), has(ModItems.OCEAN_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BRICKS, ModItems.OCEAN_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BRICKS_SLAB, ModBlocks.OCEAN_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_RESIN_BRICKS_STAIRS, ModBlocks.OCEAN_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.OCEAN_RESIN_BRICKS_WALL, ModBlocks.OCEAN_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_OCEAN_RESIN_BRICKS, ModBlocks.OCEAN_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.EMERALD_RESIN_CLUMP, 9)
                    .define('D', Items.GREEN_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BLOCK)
                    .requires(ModItems.EMERALD_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.EMERALD_RESIN_CLUMP), has(ModItems.EMERALD_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BLOCK_STAIRS, ModBlocks.EMERALD_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.EMERALD_RESIN_BLOCK_SLAB, ModBlocks.EMERALD_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BLOCK_WALL, ModBlocks.EMERALD_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.EMERALD_RESIN_CLUMP), RecipeCategory.MISC, ModItems.EMERALD_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.EMERALD_RESIN_CLUMP), has(ModItems.EMERALD_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BRICKS, ModItems.EMERALD_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BRICKS_SLAB, ModBlocks.EMERALD_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_RESIN_BRICKS_STAIRS, ModBlocks.EMERALD_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.EMERALD_RESIN_BRICKS_WALL, ModBlocks.EMERALD_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_EMERALD_RESIN_BRICKS, ModBlocks.EMERALD_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DUSK_RESIN_CLUMP, 9)
                    .define('D', Items.MAGENTA_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BLOCK)
                    .requires(ModItems.DUSK_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.DUSK_RESIN_CLUMP), has(ModItems.DUSK_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BLOCK_STAIRS, ModBlocks.DUSK_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DUSK_RESIN_BLOCK_SLAB, ModBlocks.DUSK_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BLOCK_WALL, ModBlocks.DUSK_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.DUSK_RESIN_CLUMP), RecipeCategory.MISC, ModItems.DUSK_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.DUSK_RESIN_CLUMP), has(ModItems.DUSK_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BRICKS, ModItems.DUSK_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BRICKS_SLAB, ModBlocks.DUSK_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_RESIN_BRICKS_STAIRS, ModBlocks.DUSK_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DUSK_RESIN_BRICKS_WALL, ModBlocks.DUSK_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DUSK_RESIN_BRICKS, ModBlocks.DUSK_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.DAYBREAK_RESIN_CLUMP, 9)
                    .define('D', Items.WHITE_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BLOCK)
                    .requires(ModItems.DAYBREAK_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.DAYBREAK_RESIN_CLUMP), has(ModItems.DAYBREAK_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BLOCK_STAIRS, ModBlocks.DAYBREAK_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DAYBREAK_RESIN_BLOCK_SLAB, ModBlocks.DAYBREAK_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BLOCK_WALL, ModBlocks.DAYBREAK_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.DAYBREAK_RESIN_CLUMP), RecipeCategory.MISC, ModItems.DAYBREAK_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.DAYBREAK_RESIN_CLUMP), has(ModItems.DAYBREAK_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BRICKS, ModItems.DAYBREAK_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BRICKS_SLAB, ModBlocks.DAYBREAK_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_RESIN_BRICKS_STAIRS, ModBlocks.DAYBREAK_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.DAYBREAK_RESIN_BRICKS_WALL, ModBlocks.DAYBREAK_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_DAYBREAK_RESIN_BRICKS, ModBlocks.DAYBREAK_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.SILT_RESIN_CLUMP, 9)
                    .define('D', Items.LIGHT_GRAY_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BLOCK)
                    .requires(ModItems.SILT_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.SILT_RESIN_CLUMP), has(ModItems.SILT_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BLOCK_STAIRS, ModBlocks.SILT_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SILT_RESIN_BLOCK_SLAB, ModBlocks.SILT_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BLOCK_WALL, ModBlocks.SILT_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.SILT_RESIN_CLUMP), RecipeCategory.MISC, ModItems.SILT_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.SILT_RESIN_CLUMP), has(ModItems.SILT_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BRICKS, ModItems.SILT_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BRICKS_SLAB, ModBlocks.SILT_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_RESIN_BRICKS_STAIRS, ModBlocks.SILT_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.SILT_RESIN_BRICKS_WALL, ModBlocks.SILT_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_SILT_RESIN_BRICKS, ModBlocks.SILT_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.GRAPHITE_RESIN_CLUMP, 9)
                    .define('D', Items.GRAY_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BLOCK)
                    .requires(ModItems.GRAPHITE_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.GRAPHITE_RESIN_CLUMP), has(ModItems.GRAPHITE_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BLOCK_STAIRS, ModBlocks.GRAPHITE_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GRAPHITE_RESIN_BLOCK_SLAB, ModBlocks.GRAPHITE_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BLOCK_WALL, ModBlocks.GRAPHITE_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.GRAPHITE_RESIN_CLUMP), RecipeCategory.MISC, ModItems.GRAPHITE_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.GRAPHITE_RESIN_CLUMP), has(ModItems.GRAPHITE_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BRICKS, ModItems.GRAPHITE_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BRICKS_SLAB, ModBlocks.GRAPHITE_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_RESIN_BRICKS_STAIRS, ModBlocks.GRAPHITE_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.GRAPHITE_RESIN_BRICKS_WALL, ModBlocks.GRAPHITE_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_GRAPHITE_RESIN_BRICKS, ModBlocks.GRAPHITE_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.OBSIDIAN_RESIN_CLUMP, 9)
                    .define('D', Items.BLACK_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BLOCK)
                    .requires(ModItems.OBSIDIAN_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.OBSIDIAN_RESIN_CLUMP), has(ModItems.OBSIDIAN_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BLOCK_STAIRS, ModBlocks.OBSIDIAN_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.OBSIDIAN_RESIN_BLOCK_SLAB, ModBlocks.OBSIDIAN_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BLOCK_WALL, ModBlocks.OBSIDIAN_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.OBSIDIAN_RESIN_CLUMP), RecipeCategory.MISC, ModItems.OBSIDIAN_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.OBSIDIAN_RESIN_CLUMP), has(ModItems.OBSIDIAN_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BRICKS, ModItems.OBSIDIAN_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BRICKS_SLAB, ModBlocks.OBSIDIAN_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_RESIN_BRICKS_STAIRS, ModBlocks.OBSIDIAN_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.OBSIDIAN_RESIN_BRICKS_WALL, ModBlocks.OBSIDIAN_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_OBSIDIAN_RESIN_BRICKS, ModBlocks.OBSIDIAN_RESIN_BRICKS);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.COCOA_RESIN_CLUMP, 9)
                    .define('D', Items.BROWN_DYE)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('C', Items.RESIN_CLUMP)
                    .pattern("CDC")
                    .pattern("CPC")
                    .pattern("CCC")
                    .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                    .save(output);

//                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.CHORUS_RESIN_CLUMP, RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BLOCK);
                shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BLOCK)
                    .requires(ModItems.COCOA_RESIN_CLUMP, 9)
                    .unlockedBy(getHasName(ModItems.COCOA_RESIN_CLUMP), has(ModItems.COCOA_RESIN_CLUMP))
                    .save(output);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BLOCK_STAIRS, ModBlocks.COCOA_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.COCOA_RESIN_BLOCK_SLAB, ModBlocks.COCOA_RESIN_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BLOCK_WALL, ModBlocks.COCOA_RESIN_BLOCK);

                SimpleCookingRecipeBuilder.smelting(
                        Ingredient.of(ModItems.COCOA_RESIN_CLUMP), RecipeCategory.MISC, ModItems.COCOA_RESIN_BRICK, 0.1f, 200)
                        .unlockedBy(getHasName(ModItems.COCOA_RESIN_CLUMP), has(ModItems.COCOA_RESIN_CLUMP))
                        .save(output);
                twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BRICKS, ModItems.COCOA_RESIN_BRICK);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BRICKS_SLAB, ModBlocks.COCOA_RESIN_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_RESIN_BRICKS_STAIRS, ModBlocks.COCOA_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.COCOA_RESIN_BRICKS_WALL, ModBlocks.COCOA_RESIN_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_COCOA_RESIN_BRICKS, ModBlocks.COCOA_RESIN_BRICKS);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_RESIN, Blocks.RESIN_BLOCK);
                easyStonecutting(ModBlocks.POLISHED_RESIN, ModBlocks.POLISHED_RESIN_STAIRS, ModBlocks.POLISHED_RESIN_SLAB, ModBlocks.POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEETROOT_POLISHED_RESIN, ModBlocks.BEETROOT_RESIN_BLOCK);
                easyStonecutting(ModBlocks.BEETROOT_POLISHED_RESIN, ModBlocks.BEETROOT_POLISHED_RESIN_STAIRS, ModBlocks.BEETROOT_POLISHED_RESIN_SLAB, ModBlocks.BEETROOT_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CARAMEL_POLISHED_RESIN, ModBlocks.CARAMEL_RESIN_BLOCK);
                easyStonecutting(ModBlocks.CARAMEL_POLISHED_RESIN, ModBlocks.CARAMEL_POLISHED_RESIN_STAIRS, ModBlocks.CARAMEL_POLISHED_RESIN_SLAB, ModBlocks.CARAMEL_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LEMON_POLISHED_RESIN, ModBlocks.LEMON_RESIN_BLOCK);
                easyStonecutting(ModBlocks.LEMON_POLISHED_RESIN, ModBlocks.LEMON_POLISHED_RESIN_STAIRS, ModBlocks.LEMON_POLISHED_RESIN_SLAB, ModBlocks.LEMON_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TOXIC_POLISHED_RESIN, ModBlocks.TOXIC_RESIN_BLOCK);
                easyStonecutting(ModBlocks.TOXIC_POLISHED_RESIN, ModBlocks.TOXIC_POLISHED_RESIN_STAIRS, ModBlocks.TOXIC_POLISHED_RESIN_SLAB, ModBlocks.TOXIC_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.EMERALD_POLISHED_RESIN, ModBlocks.EMERALD_RESIN_BLOCK);
                easyStonecutting(ModBlocks.EMERALD_POLISHED_RESIN, ModBlocks.EMERALD_POLISHED_RESIN_STAIRS, ModBlocks.EMERALD_POLISHED_RESIN_SLAB, ModBlocks.EMERALD_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.JADE_POLISHED_RESIN, ModBlocks.JADE_RESIN_BLOCK);
                easyStonecutting(ModBlocks.JADE_POLISHED_RESIN, ModBlocks.JADE_POLISHED_RESIN_STAIRS, ModBlocks.JADE_POLISHED_RESIN_SLAB, ModBlocks.JADE_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OCEAN_POLISHED_RESIN, ModBlocks.OCEAN_RESIN_BLOCK);
                easyStonecutting(ModBlocks.OCEAN_POLISHED_RESIN, ModBlocks.OCEAN_POLISHED_RESIN_STAIRS, ModBlocks.OCEAN_POLISHED_RESIN_SLAB, ModBlocks.OCEAN_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GLACIER_POLISHED_RESIN, ModBlocks.GLACIER_RESIN_BLOCK);
                easyStonecutting(ModBlocks.GLACIER_POLISHED_RESIN, ModBlocks.GLACIER_POLISHED_RESIN_STAIRS, ModBlocks.GLACIER_POLISHED_RESIN_SLAB, ModBlocks.GLACIER_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUBBLE_POLISHED_RESIN, ModBlocks.BUBBLE_RESIN_BLOCK);
                easyStonecutting(ModBlocks.BUBBLE_POLISHED_RESIN, ModBlocks.BUBBLE_POLISHED_RESIN_STAIRS, ModBlocks.BUBBLE_POLISHED_RESIN_SLAB, ModBlocks.BUBBLE_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DUSK_POLISHED_RESIN, ModBlocks.DUSK_RESIN_BLOCK);
                easyStonecutting(ModBlocks.DUSK_POLISHED_RESIN, ModBlocks.DUSK_POLISHED_RESIN_STAIRS, ModBlocks.DUSK_POLISHED_RESIN_SLAB, ModBlocks.DUSK_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAYBREAK_POLISHED_RESIN, ModBlocks.CHORUS_RESIN_BLOCK);
                easyStonecutting(ModBlocks.DAYBREAK_POLISHED_RESIN, ModBlocks.DAYBREAK_POLISHED_RESIN_STAIRS, ModBlocks.DAYBREAK_POLISHED_RESIN_SLAB, ModBlocks.DAYBREAK_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SILT_POLISHED_RESIN, ModBlocks.SILT_RESIN_BLOCK);
                easyStonecutting(ModBlocks.SILT_POLISHED_RESIN, ModBlocks.SILT_POLISHED_RESIN_STAIRS, ModBlocks.SILT_POLISHED_RESIN_SLAB, ModBlocks.SILT_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GRAPHITE_POLISHED_RESIN, ModBlocks.GRAPHITE_RESIN_BLOCK);
                easyStonecutting(ModBlocks.GRAPHITE_POLISHED_RESIN, ModBlocks.GRAPHITE_POLISHED_RESIN_STAIRS, ModBlocks.GRAPHITE_POLISHED_RESIN_SLAB, ModBlocks.GRAPHITE_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.OBSIDIAN_POLISHED_RESIN, ModBlocks.OBSIDIAN_RESIN_BLOCK);
                easyStonecutting(ModBlocks.OBSIDIAN_POLISHED_RESIN, ModBlocks.OBSIDIAN_POLISHED_RESIN_STAIRS, ModBlocks.OBSIDIAN_POLISHED_RESIN_SLAB, ModBlocks.OBSIDIAN_POLISHED_RESIN_WALL);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COCOA_POLISHED_RESIN, ModBlocks.COCOA_RESIN_BLOCK);
                easyStonecutting(ModBlocks.COCOA_POLISHED_RESIN, ModBlocks.COCOA_POLISHED_RESIN_STAIRS, ModBlocks.COCOA_POLISHED_RESIN_SLAB, ModBlocks.COCOA_POLISHED_RESIN_WALL);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES, Blocks.AMETHYST_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES_SLAB, ModBlocks.AMETHYST_TILES, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_TILES_STAIRS, ModBlocks.AMETHYST_TILES);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.AMETHYST_TILES_WALL, ModBlocks.AMETHYST_TILES);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS, ModBlocks.AMETHYST_TILES);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS_SLAB, ModBlocks.AMETHYST_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AMETHYST_BRICKS_STAIRS, ModBlocks.AMETHYST_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.AMETHYST_BRICKS_WALL, ModBlocks.AMETHYST_BRICKS);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_BLOCK, ModItems.ABERRANT_AMETHYST_SHARD);
                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_TILES, ModBlocks.ABERRANT_AMETHYST_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_TILES_SLAB, ModBlocks.ABERRANT_AMETHYST_TILES, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_TILES_STAIRS, ModBlocks.ABERRANT_AMETHYST_TILES);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.ABERRANT_AMETHYST_TILES_WALL, ModBlocks.ABERRANT_AMETHYST_TILES);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_BRICKS, ModBlocks.ABERRANT_AMETHYST_TILES);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_BRICKS_SLAB, ModBlocks.ABERRANT_AMETHYST_BRICKS, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_AMETHYST_BRICKS_STAIRS, ModBlocks.ABERRANT_AMETHYST_BRICKS);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.ABERRANT_AMETHYST_BRICKS_WALL, ModBlocks.ABERRANT_AMETHYST_BRICKS);

                aberrantRecipe(ModBlocks.ABERRANT_SOUL_SAND, Blocks.SOUL_SAND);
                aberrantRecipe(ModBlocks.ABERRANT_SOUL_SOIL, Blocks.SOUL_SOIL);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SAND);
                slabBuilder(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB,
                        Ingredient.of(ModBlocks.ABERRANT_SOUL_SANDSTONE, ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_SOUL_SANDSTONE), has(ModBlocks.ABERRANT_SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE), has(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE))
                        .save(output);
                stairBuilder(ModBlocks.ABERRANT_SOUL_SANDSTONE_STAIRS,
                        Ingredient.of(ModBlocks.ABERRANT_SOUL_SANDSTONE, ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_SOUL_SANDSTONE), has(ModBlocks.ABERRANT_SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE), has(ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE))
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE), has(ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE))
                        .save(output);
                wall(RecipeCategory.DECORATIONS, ModBlocks.ABERRANT_SOUL_SANDSTONE_WALL, ModBlocks.ABERRANT_SOUL_SANDSTONE);
                chiseled(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB);
                cut(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SANDSTONE);

                SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.ABERRANT_SOUL_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE.asItem(),0.1f, 200)
                        .unlockedBy(getHasName(ModBlocks.ABERRANT_SOUL_SANDSTONE), has(ModBlocks.ABERRANT_SOUL_SANDSTONE))
                        .save(output);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CUT_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SANDSTONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SOUL_SANDSTONE_SLAB, ModBlocks.ABERRANT_SOUL_SANDSTONE, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SOUL_SANDSTONE_STAIRS, ModBlocks.ABERRANT_SOUL_SANDSTONE);
                stonecutterResultFromBase(RecipeCategory.DECORATIONS, ModBlocks.ABERRANT_SOUL_SANDSTONE_WALL, ModBlocks.ABERRANT_SOUL_SANDSTONE);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CHISELED_SOUL_SANDSTONE, ModBlocks.ABERRANT_SOUL_SANDSTONE);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_SLAB, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE_STAIRS, ModBlocks.ABERRANT_SMOOTH_SOUL_SANDSTONE);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_JACK_O_LANTERN)
                    .define('A', ModBlocks.ABERRANT_CARVED_PUMPKIN)
                    .define('B', Blocks.SOUL_TORCH)
                    .pattern("A")
                    .pattern("B")
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_CARVED_PUMPKIN), has(ModBlocks.ABERRANT_CARVED_PUMPKIN))
                    .save(output);

                aberrantRecipe(ModBlocks.ABERRANT_OBSIDIAN, Blocks.OBSIDIAN);
                aberrantRecipe(ModBlocks.ABERRANT_CRYING_OBSIDIAN, Blocks.CRYING_OBSIDIAN);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_NETHER_BRICKS, ModItems.ABERRANT_NETHER_BRICK);
                SimpleCookingRecipeBuilder.smelting(
                    Ingredient.of(ModBlocks.ABERRANT_NETHERRACK), RecipeCategory.MISC, ModItems.ABERRANT_NETHER_BRICK, 0.1f, 200)
                    .unlockedBy(getHasName(ModBlocks.ABERRANT_NETHERRACK), has(ModBlocks.ABERRANT_NETHERRACK))
                    .save(output);

                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS, ModBlocks.ABERRANT_NETHER_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_STAIRS, ModBlocks.ABERRANT_NETHER_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_SLAB, ModBlocks.ABERRANT_NETHER_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_ABERRANT_NETHER_BRICKS_WALL, ModBlocks.ABERRANT_NETHER_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS, ModBlocks.ABERRANT_NETHER_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_STAIRS, ModBlocks.ABERRANT_NETHER_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_SLAB, ModBlocks.ABERRANT_NETHER_BRICKS);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_ABERRANT_NETHER_BRICKS_WALL, ModBlocks.ABERRANT_NETHER_BRICKS);

                aberrantRecipe(ModBlocks.ABERRANT_RED_NETHER_BRICKS, Blocks.RED_NETHER_BRICKS);
                easyStonecutting(ModBlocks.ABERRANT_RED_NETHER_BRICKS, ModBlocks.ABERRANT_RED_NETHER_BRICKS_STAIRS,
                        ModBlocks.ABERRANT_RED_NETHER_BRICKS_SLAB, ModBlocks.ABERRANT_RED_NETHER_BRICKS_WALL);
                aberrantRecipe(ModBlocks.ABERRANT_GLOWSTONE, Blocks.GLOWSTONE);

                aberrantRecipe(ModBlocks.ABERRANT_REDSTONE_LAMP, Blocks.REDSTONE_LAMP);
                aberrantRecipe(ModBlocks.ABERRANT_OCHRE_FROGLIGHT, Blocks.OCHRE_FROGLIGHT);
                aberrantRecipe(ModBlocks.ABERRANT_VERDANT_FROGLIGHT, Blocks.VERDANT_FROGLIGHT);
                aberrantRecipe(ModBlocks.ABERRANT_PEARLESCENT_FROGLIGHT, Blocks.PEARLESCENT_FROGLIGHT);

                shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.NETHERITE_FENCE)
                        .define('N', Blocks.NETHERITE_BLOCK)
                        .define('G', Blocks.GOLD_BLOCK)
                        .pattern("NGN")
                        .pattern("NGN")
                        .unlockedBy(getHasName(Blocks.NETHERITE_BLOCK), has(Blocks.NETHERITE_BLOCK))
                        .save(output);

                aberrantRecipe(ModBlocks.ABERRANT_COPPER_BLOCK, Blocks.COPPER_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CUT_COPPER, ModBlocks.ABERRANT_COPPER_BLOCK, 4);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CUT_COPPER_STAIRS, ModBlocks.ABERRANT_COPPER_BLOCK, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CUT_COPPER_SLAB, ModBlocks.ABERRANT_COPPER_BLOCK, 3);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_CHISELED_COPPER, ModBlocks.ABERRANT_COPPER_BLOCK, 4);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_COPPER_DOOR, ModBlocks.ABERRANT_COPPER_BLOCK, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_COPPER_TRAPDOOR, ModBlocks.ABERRANT_COPPER_BLOCK, 2);
                copperBulb(ModBlocks.ABERRANT_COPPER_BULB, ModBlocks.ABERRANT_COPPER_BLOCK);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_COPPER_CHAINS.unaffected(), ModBlocks.ABERRANT_COPPER_BLOCK, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_COPPER_LANTERNS.unaffected(), ModBlocks.ABERRANT_COPPER_BLOCK, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABERRANT_COPPER_BARS.unaffected(), ModBlocks.ABERRANT_COPPER_BLOCK, 2);

                clumpRecipe(ModItems.BRASS_RESIN_CLUMP, Items.ORANGE_DYE, Items.YELLOW_DYE);
                resinRecipe(ModItems.BRASS_RESIN_CLUMP, ModItems.BRASS_RESIN_BRICK, ModBlocks.BRASS_RESIN_BLOCK, ModBlocks.BRASS_RESIN_BLOCK_STAIRS, ModBlocks.BRASS_RESIN_BLOCK_SLAB, ModBlocks.BRASS_RESIN_BLOCK_WALL, ModBlocks.BRASS_POLISHED_RESIN, ModBlocks.BRASS_POLISHED_RESIN_STAIRS, ModBlocks.BRASS_POLISHED_RESIN_SLAB, ModBlocks.BRASS_POLISHED_RESIN_WALL, ModBlocks.BRASS_RESIN_BRICKS, ModBlocks.BRASS_RESIN_BRICKS_STAIRS, ModBlocks.BRASS_RESIN_BRICKS_SLAB, ModBlocks.BRASS_RESIN_BRICKS_WALL, ModBlocks.CHISELED_BRASS_RESIN_BRICKS);

                clumpRecipe(ModItems.DANDELION_RESIN_CLUMP, Items.WHITE_DYE, Items.YELLOW_DYE);
                resinRecipe(ModItems.DANDELION_RESIN_CLUMP, ModItems.DANDELION_RESIN_BRICK, ModBlocks.DANDELION_RESIN_BLOCK, ModBlocks.DANDELION_RESIN_BLOCK_STAIRS, ModBlocks.DANDELION_RESIN_BLOCK_SLAB, ModBlocks.DANDELION_RESIN_BLOCK_WALL, ModBlocks.DANDELION_POLISHED_RESIN, ModBlocks.DANDELION_POLISHED_RESIN_STAIRS, ModBlocks.DANDELION_POLISHED_RESIN_SLAB, ModBlocks.DANDELION_POLISHED_RESIN_WALL, ModBlocks.DANDELION_RESIN_BRICKS, ModBlocks.DANDELION_RESIN_BRICKS_STAIRS, ModBlocks.DANDELION_RESIN_BRICKS_SLAB, ModBlocks.DANDELION_RESIN_BRICKS_WALL, ModBlocks.CHISELED_DANDELION_RESIN_BRICKS);

                clumpRecipe(ModItems.BOG_RESIN_CLUMP, Items.GREEN_DYE, Items.BLACK_DYE);
                resinRecipe(ModItems.BOG_RESIN_CLUMP, ModItems.BOG_RESIN_BRICK, ModBlocks.BOG_RESIN_BLOCK, ModBlocks.BOG_RESIN_BLOCK_STAIRS, ModBlocks.BOG_RESIN_BLOCK_SLAB, ModBlocks.BOG_RESIN_BLOCK_WALL, ModBlocks.BOG_POLISHED_RESIN, ModBlocks.BOG_POLISHED_RESIN_STAIRS, ModBlocks.BOG_POLISHED_RESIN_SLAB, ModBlocks.BOG_POLISHED_RESIN_WALL, ModBlocks.BOG_RESIN_BRICKS, ModBlocks.BOG_RESIN_BRICKS_STAIRS, ModBlocks.BOG_RESIN_BRICKS_SLAB, ModBlocks.BOG_RESIN_BRICKS_WALL, ModBlocks.CHISELED_BOG_RESIN_BRICKS);

                clumpRecipe(ModItems.SCULK_RESIN_CLUMP, Items.CYAN_DYE, Items.BLACK_DYE);
                resinRecipe(ModItems.SCULK_RESIN_CLUMP, ModItems.SCULK_RESIN_BRICK, ModBlocks.SCULK_RESIN_BLOCK, ModBlocks.SCULK_RESIN_BLOCK_STAIRS, ModBlocks.SCULK_RESIN_BLOCK_SLAB, ModBlocks.SCULK_RESIN_BLOCK_WALL, ModBlocks.SCULK_POLISHED_RESIN, ModBlocks.SCULK_POLISHED_RESIN_STAIRS, ModBlocks.SCULK_POLISHED_RESIN_SLAB, ModBlocks.SCULK_POLISHED_RESIN_WALL, ModBlocks.SCULK_RESIN_BRICKS, ModBlocks.SCULK_RESIN_BRICKS_STAIRS, ModBlocks.SCULK_RESIN_BRICKS_SLAB, ModBlocks.SCULK_RESIN_BRICKS_WALL, ModBlocks.CHISELED_SCULK_RESIN_BRICKS);

                clumpRecipe(ModItems.RETRO_RESIN_CLUMP, Items.LIME_DYE, Items.LIGHT_GRAY_DYE);
                resinRecipe(ModItems.RETRO_RESIN_CLUMP, ModItems.RETRO_RESIN_BRICK, ModBlocks.RETRO_RESIN_BLOCK, ModBlocks.RETRO_RESIN_BLOCK_STAIRS, ModBlocks.RETRO_RESIN_BLOCK_SLAB, ModBlocks.RETRO_RESIN_BLOCK_WALL, ModBlocks.RETRO_POLISHED_RESIN, ModBlocks.RETRO_POLISHED_RESIN_STAIRS, ModBlocks.RETRO_POLISHED_RESIN_SLAB, ModBlocks.RETRO_POLISHED_RESIN_WALL, ModBlocks.RETRO_RESIN_BRICKS, ModBlocks.RETRO_RESIN_BRICKS_STAIRS, ModBlocks.RETRO_RESIN_BRICKS_SLAB, ModBlocks.RETRO_RESIN_BRICKS_WALL, ModBlocks.CHISELED_RETRO_RESIN_BRICKS);

                clumpRecipe(ModItems.DUST_RESIN_CLUMP, Items.BROWN_DYE, Items.GRAY_DYE);
                resinRecipe(ModItems.DUST_RESIN_CLUMP, ModItems.DUST_RESIN_BRICK, ModBlocks.DUST_RESIN_BLOCK, ModBlocks.DUST_RESIN_BLOCK_STAIRS, ModBlocks.DUST_RESIN_BLOCK_SLAB, ModBlocks.DUST_RESIN_BLOCK_WALL, ModBlocks.DUST_POLISHED_RESIN, ModBlocks.DUST_POLISHED_RESIN_STAIRS, ModBlocks.DUST_POLISHED_RESIN_SLAB, ModBlocks.DUST_POLISHED_RESIN_WALL, ModBlocks.DUST_RESIN_BRICKS, ModBlocks.DUST_RESIN_BRICKS_STAIRS, ModBlocks.DUST_RESIN_BRICKS_SLAB, ModBlocks.DUST_RESIN_BRICKS_WALL, ModBlocks.CHISELED_DUST_RESIN_BRICKS);

                clumpRecipe(ModItems.BLOOD_RESIN_CLUMP, Items.RED_DYE, Items.MAGENTA_DYE);
                resinRecipe(ModItems.BLOOD_RESIN_CLUMP, ModItems.BLOOD_RESIN_BRICK, ModBlocks.BLOOD_RESIN_BLOCK, ModBlocks.BLOOD_RESIN_BLOCK_STAIRS, ModBlocks.BLOOD_RESIN_BLOCK_SLAB, ModBlocks.BLOOD_RESIN_BLOCK_WALL, ModBlocks.BLOOD_POLISHED_RESIN, ModBlocks.BLOOD_POLISHED_RESIN_STAIRS, ModBlocks.BLOOD_POLISHED_RESIN_SLAB, ModBlocks.BLOOD_POLISHED_RESIN_WALL, ModBlocks.BLOOD_RESIN_BRICKS, ModBlocks.BLOOD_RESIN_BRICKS_STAIRS, ModBlocks.BLOOD_RESIN_BRICKS_SLAB, ModBlocks.BLOOD_RESIN_BRICKS_WALL, ModBlocks.CHISELED_BLOOD_RESIN_BRICKS);

                clumpRecipe(ModItems.RUBY_RESIN_CLUMP, Items.RED_DYE, Items.PINK_DYE);
                resinRecipe(ModItems.RUBY_RESIN_CLUMP, ModItems.RUBY_RESIN_BRICK, ModBlocks.RUBY_RESIN_BLOCK, ModBlocks.RUBY_RESIN_BLOCK_STAIRS, ModBlocks.RUBY_RESIN_BLOCK_SLAB, ModBlocks.RUBY_RESIN_BLOCK_WALL, ModBlocks.RUBY_POLISHED_RESIN, ModBlocks.RUBY_POLISHED_RESIN_STAIRS, ModBlocks.RUBY_POLISHED_RESIN_SLAB, ModBlocks.RUBY_POLISHED_RESIN_WALL, ModBlocks.RUBY_RESIN_BRICKS, ModBlocks.RUBY_RESIN_BRICKS_STAIRS, ModBlocks.RUBY_RESIN_BRICKS_SLAB, ModBlocks.RUBY_RESIN_BRICKS_WALL, ModBlocks.CHISELED_RUBY_RESIN_BRICKS);

                clumpRecipe(ModItems.PEARL_RESIN_CLUMP, Items.WHITE_DYE, Items.LIGHT_GRAY_DYE);
                resinRecipe(ModItems.PEARL_RESIN_CLUMP, ModItems.PEARL_RESIN_BRICK, ModBlocks.PEARL_RESIN_BLOCK, ModBlocks.PEARL_RESIN_BLOCK_STAIRS, ModBlocks.PEARL_RESIN_BLOCK_SLAB, ModBlocks.PEARL_RESIN_BLOCK_WALL, ModBlocks.PEARL_POLISHED_RESIN, ModBlocks.PEARL_POLISHED_RESIN_STAIRS, ModBlocks.PEARL_POLISHED_RESIN_SLAB, ModBlocks.PEARL_POLISHED_RESIN_WALL, ModBlocks.PEARL_RESIN_BRICKS, ModBlocks.PEARL_RESIN_BRICKS_STAIRS, ModBlocks.PEARL_RESIN_BRICKS_SLAB, ModBlocks.PEARL_RESIN_BRICKS_WALL, ModBlocks.CHISELED_PEARL_RESIN_BRICKS);

                clumpRecipe(ModItems.SNOWY_RESIN_CLUMP, Items.WHITE_DYE, Items.LIGHT_BLUE_DYE);
                resinRecipe(ModItems.SNOWY_RESIN_CLUMP, ModItems.SNOWY_RESIN_BRICK, ModBlocks.SNOWY_RESIN_BLOCK, ModBlocks.SNOWY_RESIN_BLOCK_STAIRS, ModBlocks.SNOWY_RESIN_BLOCK_SLAB, ModBlocks.SNOWY_RESIN_BLOCK_WALL, ModBlocks.SNOWY_POLISHED_RESIN, ModBlocks.SNOWY_POLISHED_RESIN_STAIRS, ModBlocks.SNOWY_POLISHED_RESIN_SLAB, ModBlocks.SNOWY_POLISHED_RESIN_WALL, ModBlocks.SNOWY_RESIN_BRICKS, ModBlocks.SNOWY_RESIN_BRICKS_STAIRS, ModBlocks.SNOWY_RESIN_BRICKS_SLAB, ModBlocks.SNOWY_RESIN_BRICKS_WALL, ModBlocks.CHISELED_SNOWY_RESIN_BRICKS);

                clumpRecipe(ModItems.SUBZERO_RESIN_CLUMP, Items.PURPLE_DYE, Items.BLUE_DYE);
                resinRecipe(ModItems.SUBZERO_RESIN_CLUMP, ModItems.SUBZERO_RESIN_BRICK, ModBlocks.SUBZERO_RESIN_BLOCK, ModBlocks.SUBZERO_RESIN_BLOCK_STAIRS, ModBlocks.SUBZERO_RESIN_BLOCK_SLAB, ModBlocks.SUBZERO_RESIN_BLOCK_WALL, ModBlocks.SUBZERO_POLISHED_RESIN, ModBlocks.SUBZERO_POLISHED_RESIN_STAIRS, ModBlocks.SUBZERO_POLISHED_RESIN_SLAB, ModBlocks.SUBZERO_POLISHED_RESIN_WALL, ModBlocks.SUBZERO_RESIN_BRICKS, ModBlocks.SUBZERO_RESIN_BRICKS_STAIRS, ModBlocks.SUBZERO_RESIN_BRICKS_SLAB, ModBlocks.SUBZERO_RESIN_BRICKS_WALL, ModBlocks.CHISELED_SUBZERO_RESIN_BRICKS);

                clumpRecipe(ModItems.GEM_RESIN_CLUMP, Items.CYAN_DYE, Items.LIGHT_BLUE_DYE);
                resinRecipe(ModItems.GEM_RESIN_CLUMP, ModItems.GEM_RESIN_BRICK, ModBlocks.GEM_RESIN_BLOCK, ModBlocks.GEM_RESIN_BLOCK_STAIRS, ModBlocks.GEM_RESIN_BLOCK_SLAB, ModBlocks.GEM_RESIN_BLOCK_WALL, ModBlocks.GEM_POLISHED_RESIN, ModBlocks.GEM_POLISHED_RESIN_STAIRS, ModBlocks.GEM_POLISHED_RESIN_SLAB, ModBlocks.GEM_POLISHED_RESIN_WALL, ModBlocks.GEM_RESIN_BRICKS, ModBlocks.GEM_RESIN_BRICKS_STAIRS, ModBlocks.GEM_RESIN_BRICKS_SLAB, ModBlocks.GEM_RESIN_BRICKS_WALL, ModBlocks.CHISELED_GEM_RESIN_BRICKS);

                clumpRecipe(ModItems.ROTTEN_RESIN_CLUMP, Items.ORANGE_DYE, Items.BROWN_DYE);
                resinRecipe(ModItems.ROTTEN_RESIN_CLUMP, ModItems.ROTTEN_RESIN_BRICK, ModBlocks.ROTTEN_RESIN_BLOCK, ModBlocks.ROTTEN_RESIN_BLOCK_STAIRS, ModBlocks.ROTTEN_RESIN_BLOCK_SLAB, ModBlocks.ROTTEN_RESIN_BLOCK_WALL, ModBlocks.ROTTEN_POLISHED_RESIN, ModBlocks.ROTTEN_POLISHED_RESIN_STAIRS, ModBlocks.ROTTEN_POLISHED_RESIN_SLAB, ModBlocks.ROTTEN_POLISHED_RESIN_WALL, ModBlocks.ROTTEN_RESIN_BRICKS, ModBlocks.ROTTEN_RESIN_BRICKS_STAIRS, ModBlocks.ROTTEN_RESIN_BRICKS_SLAB, ModBlocks.ROTTEN_RESIN_BRICKS_WALL, ModBlocks.CHISELED_ROTTEN_RESIN_BRICKS);

                clumpRecipe(ModItems.GRAPE_RESIN_CLUMP, Items.PURPLE_DYE, Items.MAGENTA_DYE);
                resinRecipe(ModItems.GRAPE_RESIN_CLUMP, ModItems.GRAPE_RESIN_BRICK, ModBlocks.GRAPE_RESIN_BLOCK, ModBlocks.GRAPE_RESIN_BLOCK_STAIRS, ModBlocks.GRAPE_RESIN_BLOCK_SLAB, ModBlocks.GRAPE_RESIN_BLOCK_WALL, ModBlocks.GRAPE_POLISHED_RESIN, ModBlocks.GRAPE_POLISHED_RESIN_STAIRS, ModBlocks.GRAPE_POLISHED_RESIN_SLAB, ModBlocks.GRAPE_POLISHED_RESIN_WALL, ModBlocks.GRAPE_RESIN_BRICKS, ModBlocks.GRAPE_RESIN_BRICKS_STAIRS, ModBlocks.GRAPE_RESIN_BRICKS_SLAB, ModBlocks.GRAPE_RESIN_BRICKS_WALL, ModBlocks.CHISELED_GRAPE_RESIN_BRICKS);

                clumpRecipe(ModItems.REDSTONE_RESIN_CLUMP, Items.RED_DYE, Items.RED_DYE);
                resinRecipe(ModItems.REDSTONE_RESIN_CLUMP, ModItems.REDSTONE_RESIN_BRICK, ModBlocks.REDSTONE_RESIN_BLOCK, ModBlocks.REDSTONE_RESIN_BLOCK_STAIRS, ModBlocks.REDSTONE_RESIN_BLOCK_SLAB, ModBlocks.REDSTONE_RESIN_BLOCK_WALL, ModBlocks.REDSTONE_POLISHED_RESIN, ModBlocks.REDSTONE_POLISHED_RESIN_STAIRS, ModBlocks.REDSTONE_POLISHED_RESIN_SLAB, ModBlocks.REDSTONE_POLISHED_RESIN_WALL, ModBlocks.REDSTONE_RESIN_BRICKS, ModBlocks.REDSTONE_RESIN_BRICKS_STAIRS, ModBlocks.REDSTONE_RESIN_BRICKS_SLAB, ModBlocks.REDSTONE_RESIN_BRICKS_WALL, ModBlocks.CHISELED_REDSTONE_RESIN_BRICKS);

                clumpRecipe(ModItems.COPPER_RESIN_CLUMP, Items.GRAY_DYE, Items.COPPER_INGOT);
                resinRecipe(ModItems.COPPER_RESIN_CLUMP, ModItems.COPPER_RESIN_BRICK, ModBlocks.COPPER_RESIN_BLOCK, ModBlocks.COPPER_RESIN_BLOCK_STAIRS, ModBlocks.COPPER_RESIN_BLOCK_SLAB, ModBlocks.COPPER_RESIN_BLOCK_WALL, ModBlocks.COPPER_POLISHED_RESIN, ModBlocks.COPPER_POLISHED_RESIN_STAIRS, ModBlocks.COPPER_POLISHED_RESIN_SLAB, ModBlocks.COPPER_POLISHED_RESIN_WALL, ModBlocks.COPPER_RESIN_BRICKS, ModBlocks.COPPER_RESIN_BRICKS_STAIRS, ModBlocks.COPPER_RESIN_BRICKS_SLAB, ModBlocks.COPPER_RESIN_BRICKS_WALL, ModBlocks.CHISELED_COPPER_RESIN_BRICKS);

                clumpRecipe(ModItems.SWEETBERRY_RESIN_CLUMP, Items.RED_DYE, Items.BLACK_DYE);
                resinRecipe(ModItems.SWEETBERRY_RESIN_CLUMP, ModItems.SWEETBERRY_RESIN_BRICK, ModBlocks.SWEETBERRY_RESIN_BLOCK, ModBlocks.SWEETBERRY_RESIN_BLOCK_STAIRS, ModBlocks.SWEETBERRY_RESIN_BLOCK_SLAB, ModBlocks.SWEETBERRY_RESIN_BLOCK_WALL, ModBlocks.SWEETBERRY_POLISHED_RESIN, ModBlocks.SWEETBERRY_POLISHED_RESIN_STAIRS, ModBlocks.SWEETBERRY_POLISHED_RESIN_SLAB, ModBlocks.SWEETBERRY_POLISHED_RESIN_WALL, ModBlocks.SWEETBERRY_RESIN_BRICKS, ModBlocks.SWEETBERRY_RESIN_BRICKS_STAIRS, ModBlocks.SWEETBERRY_RESIN_BRICKS_SLAB, ModBlocks.SWEETBERRY_RESIN_BRICKS_WALL, ModBlocks.CHISELED_SWEETBERRY_RESIN_BRICKS);

                clumpRecipe(ModItems.KELP_RESIN_CLUMP, Items.LIME_DYE, Items.GRAY_DYE);
                resinRecipe(ModItems.KELP_RESIN_CLUMP, ModItems.KELP_RESIN_BRICK, ModBlocks.KELP_RESIN_BLOCK, ModBlocks.KELP_RESIN_BLOCK_STAIRS, ModBlocks.KELP_RESIN_BLOCK_SLAB, ModBlocks.KELP_RESIN_BLOCK_WALL, ModBlocks.KELP_POLISHED_RESIN, ModBlocks.KELP_POLISHED_RESIN_STAIRS, ModBlocks.KELP_POLISHED_RESIN_SLAB, ModBlocks.KELP_POLISHED_RESIN_WALL, ModBlocks.KELP_RESIN_BRICKS, ModBlocks.KELP_RESIN_BRICKS_STAIRS, ModBlocks.KELP_RESIN_BRICKS_SLAB, ModBlocks.KELP_RESIN_BRICKS_WALL, ModBlocks.CHISELED_KELP_RESIN_BRICKS);

                clumpRecipe(ModItems.GLITTER_RESIN_CLUMP, Items.MAGENTA_DYE, Items.PINK_DYE);
                resinRecipe(ModItems.GLITTER_RESIN_CLUMP, ModItems.GLITTER_RESIN_BRICK, ModBlocks.GLITTER_RESIN_BLOCK, ModBlocks.GLITTER_RESIN_BLOCK_STAIRS, ModBlocks.GLITTER_RESIN_BLOCK_SLAB, ModBlocks.GLITTER_RESIN_BLOCK_WALL, ModBlocks.GLITTER_POLISHED_RESIN, ModBlocks.GLITTER_POLISHED_RESIN_STAIRS, ModBlocks.GLITTER_POLISHED_RESIN_SLAB, ModBlocks.GLITTER_POLISHED_RESIN_WALL, ModBlocks.GLITTER_RESIN_BRICKS, ModBlocks.GLITTER_RESIN_BRICKS_STAIRS, ModBlocks.GLITTER_RESIN_BRICKS_SLAB, ModBlocks.GLITTER_RESIN_BRICKS_WALL, ModBlocks.CHISELED_GLITTER_RESIN_BRICKS);

                clumpRecipe(ModItems.BLAZE_RESIN_CLUMP, Items.RED_DYE, Items.ORANGE_DYE);
                resinRecipe(ModItems.BLAZE_RESIN_CLUMP, ModItems.BLAZE_RESIN_BRICK, ModBlocks.BLAZE_RESIN_BLOCK, ModBlocks.BLAZE_RESIN_BLOCK_STAIRS, ModBlocks.BLAZE_RESIN_BLOCK_SLAB, ModBlocks.BLAZE_RESIN_BLOCK_WALL, ModBlocks.BLAZE_POLISHED_RESIN, ModBlocks.BLAZE_POLISHED_RESIN_STAIRS, ModBlocks.BLAZE_POLISHED_RESIN_SLAB, ModBlocks.BLAZE_POLISHED_RESIN_WALL, ModBlocks.BLAZE_RESIN_BRICKS, ModBlocks.BLAZE_RESIN_BRICKS_STAIRS, ModBlocks.BLAZE_RESIN_BRICKS_SLAB, ModBlocks.BLAZE_RESIN_BRICKS_WALL, ModBlocks.CHISELED_BLAZE_RESIN_BRICKS);

                clumpRecipe(ModItems.ZAP_RESIN_CLUMP, Items.LIGHT_BLUE_DYE, Items.PURPLE_DYE);
                resinRecipe(ModItems.ZAP_RESIN_CLUMP, ModItems.ZAP_RESIN_BRICK, ModBlocks.ZAP_RESIN_BLOCK, ModBlocks.ZAP_RESIN_BLOCK_STAIRS, ModBlocks.ZAP_RESIN_BLOCK_SLAB, ModBlocks.ZAP_RESIN_BLOCK_WALL, ModBlocks.ZAP_POLISHED_RESIN, ModBlocks.ZAP_POLISHED_RESIN_STAIRS, ModBlocks.ZAP_POLISHED_RESIN_SLAB, ModBlocks.ZAP_POLISHED_RESIN_WALL, ModBlocks.ZAP_RESIN_BRICKS, ModBlocks.ZAP_RESIN_BRICKS_STAIRS, ModBlocks.ZAP_RESIN_BRICKS_SLAB, ModBlocks.ZAP_RESIN_BRICKS_WALL, ModBlocks.CHISELED_ZAP_RESIN_BRICKS);

                clumpRecipe(ModItems.NIGHTWAY_RESIN_CLUMP, Items.BLACK_DYE, Items.PINK_DYE);
                resinRecipe(ModItems.NIGHTWAY_RESIN_CLUMP, ModItems.NIGHTWAY_RESIN_BRICK, ModBlocks.NIGHTWAY_RESIN_BLOCK, ModBlocks.NIGHTWAY_RESIN_BLOCK_STAIRS, ModBlocks.NIGHTWAY_RESIN_BLOCK_SLAB, ModBlocks.NIGHTWAY_RESIN_BLOCK_WALL, ModBlocks.NIGHTWAY_POLISHED_RESIN, ModBlocks.NIGHTWAY_POLISHED_RESIN_STAIRS, ModBlocks.NIGHTWAY_POLISHED_RESIN_SLAB, ModBlocks.NIGHTWAY_POLISHED_RESIN_WALL, ModBlocks.NIGHTWAY_RESIN_BRICKS, ModBlocks.NIGHTWAY_RESIN_BRICKS_STAIRS, ModBlocks.NIGHTWAY_RESIN_BRICKS_SLAB, ModBlocks.NIGHTWAY_RESIN_BRICKS_WALL, ModBlocks.CHISELED_NIGHTWAY_RESIN_BRICKS);

                clumpRecipe(ModItems.RIPE_RESIN_CLUMP, Items.BLACK_DYE, Items.YELLOW_DYE);
                resinRecipe(ModItems.RIPE_RESIN_CLUMP, ModItems.RIPE_RESIN_BRICK, ModBlocks.RIPE_RESIN_BLOCK, ModBlocks.RIPE_RESIN_BLOCK_STAIRS, ModBlocks.RIPE_RESIN_BLOCK_SLAB, ModBlocks.RIPE_RESIN_BLOCK_WALL, ModBlocks.RIPE_POLISHED_RESIN, ModBlocks.RIPE_POLISHED_RESIN_STAIRS, ModBlocks.RIPE_POLISHED_RESIN_SLAB, ModBlocks.RIPE_POLISHED_RESIN_WALL, ModBlocks.RIPE_RESIN_BRICKS, ModBlocks.RIPE_RESIN_BRICKS_STAIRS, ModBlocks.RIPE_RESIN_BRICKS_SLAB, ModBlocks.RIPE_RESIN_BRICKS_WALL, ModBlocks.CHISELED_RIPE_RESIN_BRICKS);

                clumpRecipe(ModItems.SLUDGE_RESIN_CLUMP, Items.ORANGE_DYE, Items.LIME_DYE);
                resinRecipe(ModItems.SLUDGE_RESIN_CLUMP, ModItems.SLUDGE_RESIN_BRICK, ModBlocks.SLUDGE_RESIN_BLOCK, ModBlocks.SLUDGE_RESIN_BLOCK_STAIRS, ModBlocks.SLUDGE_RESIN_BLOCK_SLAB, ModBlocks.SLUDGE_RESIN_BLOCK_WALL, ModBlocks.SLUDGE_POLISHED_RESIN, ModBlocks.SLUDGE_POLISHED_RESIN_STAIRS, ModBlocks.SLUDGE_POLISHED_RESIN_SLAB, ModBlocks.SLUDGE_POLISHED_RESIN_WALL, ModBlocks.SLUDGE_RESIN_BRICKS, ModBlocks.SLUDGE_RESIN_BRICKS_STAIRS, ModBlocks.SLUDGE_RESIN_BRICKS_SLAB, ModBlocks.SLUDGE_RESIN_BRICKS_WALL, ModBlocks.CHISELED_SLUDGE_RESIN_BRICKS);

                clumpRecipe(ModItems.ARMADILLO_RESIN_CLUMP, Items.BLACK_DYE, Items.MAGENTA_DYE);
                resinRecipe(ModItems.ARMADILLO_RESIN_CLUMP, ModItems.ARMADILLO_RESIN_BRICK, ModBlocks.ARMADILLO_RESIN_BLOCK, ModBlocks.ARMADILLO_RESIN_BLOCK_STAIRS, ModBlocks.ARMADILLO_RESIN_BLOCK_SLAB, ModBlocks.ARMADILLO_RESIN_BLOCK_WALL, ModBlocks.ARMADILLO_POLISHED_RESIN, ModBlocks.ARMADILLO_POLISHED_RESIN_STAIRS, ModBlocks.ARMADILLO_POLISHED_RESIN_SLAB, ModBlocks.ARMADILLO_POLISHED_RESIN_WALL, ModBlocks.ARMADILLO_RESIN_BRICKS, ModBlocks.ARMADILLO_RESIN_BRICKS_STAIRS, ModBlocks.ARMADILLO_RESIN_BRICKS_SLAB, ModBlocks.ARMADILLO_RESIN_BRICKS_WALL, ModBlocks.CHISELED_ARMADILLO_RESIN_BRICKS);
            }

            public void clumpRecipe(Item clump, Item dye, Item dye2) {
                if (dye2 == null) {
                    shaped(RecipeCategory.BUILDING_BLOCKS, clump, 9)
                            .define('D', dye)
                            .define('P', ModItems.ABERRANT_PASTE)
                            .define('C', Items.RESIN_CLUMP)
                            .pattern("CDC")
                            .pattern("CPC")
                            .pattern("CCC")
                            .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                            .save(output);
                } else {
                    shaped(RecipeCategory.BUILDING_BLOCKS, clump, 9)
                            .define('D', dye)
                            .define('S', dye2)
                            .define('P', ModItems.ABERRANT_PASTE)
                            .define('C', Items.RESIN_CLUMP)
                            .pattern("CDC")
                            .pattern("CPC")
                            .pattern("CSC")
                            .unlockedBy(getHasName(Items.RESIN_CLUMP), has(Items.RESIN_CLUMP))
                            .save(output);
                }
            }

            public void resinRecipe(Item clump, Item brick, Block resinBlock, Block resinBlockStairs, Block resinBlockSlab, Block resinBlockWall, Block polishedResin, Block polishedResinStairs, Block polishedResinSlab, Block polishedResinWall, Block resinBricks, Block resinBricksStairs, Block resinBricksSlab, Block resinBricksWall, Block chiseledResinBricks) {
                SimpleCookingRecipeBuilder.smelting(
                                Ingredient.of(clump), RecipeCategory.MISC, brick, 0.1f, 200)
                        .unlockedBy(getHasName(clump), has(clump))
                        .save(output);

                shapeless(RecipeCategory.BUILDING_BLOCKS, resinBlock)
                        .requires(clump, 9)
                        .unlockedBy(getHasName(clump), has(clump))
                        .save(output);
                easyStonecutting(resinBlock, resinBlockStairs, resinBlockSlab, resinBlockWall);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, polishedResin, resinBlock);
                easyStonecutting(polishedResin, polishedResinStairs, polishedResinSlab, polishedResinWall);

                offer2x2CompactingRecipe4(RecipeCategory.BUILDING_BLOCKS, resinBricks, brick);
                easyStonecutting(resinBricks, resinBricksStairs, resinBricksSlab, resinBricksWall);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, chiseledResinBricks, resinBricks);
            }

            public void offer2x2CompactingRecipe4(RecipeCategory category, ItemLike output2, ItemLike input) {
                shaped(category, output2, 4)
                    .define(Character.valueOf('#'), input)
                    .pattern("##")
                    .pattern("##")
                    .unlockedBy(RecipeProvider.getHasName(input), has(input))
                    .save(output);
            }

            public void easyStonecutting(Block main, Block stair, Block slab, Block wall) {
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, stair, main);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, slab, main, 2);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, wall, main, 2);
            }

            public void easyStonecutting(Block main, Block stair, Block slab) {
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, stair, main);
                stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, slab, main, 2);
            }

            public void easyRecipe(Block main, Block stair, Block slab) {
                stairBuilder(stair, Ingredient.of(main))
                    .unlockedBy(getHasName(main), has(main))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, slab, main);
                easyStonecutting(main, stair, slab);
            }

            public void easyRecipe(Block main, Block stair, Block slab, Block wall) {
                stairBuilder(stair, Ingredient.of(main))
                    .unlockedBy(getHasName(main), has(main))
                    .save(output);
                slab(RecipeCategory.BUILDING_BLOCKS, slab, main);
                wall(RecipeCategory.BUILDING_BLOCKS, wall, main);
                easyStonecutting(main, stair, slab, wall);
            }

            public void aberrantRecipe(Block aberrantBlock, Block originalBlock) {
                shaped(RecipeCategory.BUILDING_BLOCKS, aberrantBlock, 8)
                    .define('P', ModItems.ABERRANT_PASTE)
                    .define('B', originalBlock)
                    .pattern("BBB")
                    .pattern("BPB")
                    .pattern("BBB")
                    .unlockedBy(getHasName(originalBlock), has(originalBlock))
                    .save(output);
            }
        };
    }



    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
