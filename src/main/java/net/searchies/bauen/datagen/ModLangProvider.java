package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import net.searchies.bauen.block.ModBlocks;
import net.searchies.bauen.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModBlocks.MOSSY_BRICKS.asItem(),"Mossy Bricks");
        translationBuilder.add(ModBlocks.MOSSY_BRICKS_STAIRS.asItem(),"Mossy Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_BRICKS_SLAB.asItem(),"Mossy Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_BRICKS_WALL.asItem(),"Mossy Bricks Wall");

        translationBuilder.add(ModBlocks.CRACKED_BRICKS.asItem(),"Cracked Bricks");
        translationBuilder.add(ModBlocks.CRACKED_BRICKS_STAIRS.asItem(),"Cracked Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_BRICKS_SLAB.asItem(),"Cracked Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_BRICKS_WALL.asItem(),"Cracked Bricks Wall");
        translationBuilder.add(ModBlocks.CHISELED_BRICKS.asItem(),"Chiseled Bricks");
        translationBuilder.add(ModBlocks.CHISELED_BRICKS_STAIRS.asItem(),"Chiseled Bricks Stairs");
        translationBuilder.add(ModBlocks.CHISELED_BRICKS_SLAB.asItem(),"Chiseled Bricks Slab");
        translationBuilder.add(ModBlocks.CHISELED_BRICKS_WALL.asItem(),"Chiseled Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_BRICKS.asItem(),"Mossy Chiseled Bricks");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_BRICKS_STAIRS.asItem(),"Mossy Chiseled Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_BRICKS_SLAB.asItem(),"Mossy Chiseled Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_BRICKS_WALL.asItem(),"Mossy Chiseled Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_BRICKS.asItem(),"Cracked Chiseled Bricks");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_BRICKS_STAIRS.asItem(),"Cracked Chiseled Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_BRICKS_SLAB.asItem(),"Cracked Chiseled Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_BRICKS_WALL.asItem(),"Cracked Chiseled Bricks Wall");

        translationBuilder.add(ModBlocks.GOLD_CHAIN.asItem(),"Gold Chain");
        translationBuilder.add(ModBlocks.GOLD_LANTERN.asItem(),"Gold Lantern");
        translationBuilder.add(ModBlocks.GOLD_BARS.asItem(),"Gold Bars");
        translationBuilder.add(ModBlocks.CUT_GOLD.asItem(),"Cut Gold");
        translationBuilder.add(ModBlocks.CHISELED_GOLD.asItem(),"Chiseled Gold");
        translationBuilder.add(ModBlocks.GOLD_GRATE.asItem(),"Gold Grate");
        translationBuilder.add(ModBlocks.GOLD_TRAPDOOR.asItem(),"Gold Trapdoor");
        translationBuilder.add(ModBlocks.GOLD_DOOR.asItem(),"Gold Door");
        translationBuilder.add(ModBlocks.GOLD_COINS.asItem(),"Gold Coins");
//        translationBuilder.add(ModBlocks.GOLD_HOARD.asItem(),"Gold Hoard");
//        translationBuilder.add(ModBlocks.GOLD_HOARD_BLOCK.asItem(),"Gold Hoard Block");

        translationBuilder.add(ModBlocks.MIXED_COBBLESTONE.asItem(),"Mixed Cobblestone");
        translationBuilder.add(ModBlocks.MIXED_COBBLESTONE_STAIRS.asItem(),"Mixed Cobblestone Stairs");
        translationBuilder.add(ModBlocks.MIXED_COBBLESTONE_SLAB.asItem(),"Mixed Cobblestone Slab");
        translationBuilder.add(ModBlocks.MIXED_COBBLESTONE_WALL.asItem(),"Mixed Cobblestone Wall");

        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_BLOCK.asItem(),"Industrial Iron Block");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_STAIRS.asItem(),"Industrial Iron Stairs");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_SLAB.asItem(),"Industrial Iron Slab");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_WALL.asItem(),"Industrial Iron Wall");
        translationBuilder.add(ModBlocks.CUT_INDUSTRIAL_IRON.asItem(),"Cut Industrial Iron");
        translationBuilder.add(ModBlocks.CUT_INDUSTRIAL_IRON_STAIRS.asItem(),"Cut Industrial Iron Stairs");
        translationBuilder.add(ModBlocks.CUT_INDUSTRIAL_IRON_SLAB.asItem(),"Cut Industrial Iron Slab");
        translationBuilder.add(ModBlocks.CUT_INDUSTRIAL_IRON_WALL.asItem(),"Cut Industrial Iron Wall");
        translationBuilder.add(ModBlocks.CARVED_INDUSTRIAL_IRON.asItem(),"Carved Industrial Iron");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_GRATE.asItem(),"Industrial Iron Grate");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR.asItem(),"Industrial Iron Trapdoor");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_DOOR.asItem(),"Industrial Iron Door");

        translationBuilder.add(ModBlocks.MOSSY_PACKED_MUD.asItem(),"Mossy Packed Mud");
        translationBuilder.add(ModBlocks.MOSSY_PACKED_MUD_STAIRS.asItem(),"Mossy Packed Mud Stairs");
        translationBuilder.add(ModBlocks.MOSSY_PACKED_MUD_SLAB.asItem(),"Mossy Packed Mud Slab");
        translationBuilder.add(ModBlocks.MOSSY_PACKED_MUD_WALL.asItem(),"Mossy Packed Mud Wall");
        translationBuilder.add(ModBlocks.MOSSY_MUD_BRICKS.asItem(),"Mossy Mud Bricks");
        translationBuilder.add(ModBlocks.MOSSY_MUD_BRICKS_STAIRS.asItem(),"Mossy Mud Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_MUD_BRICKS_SLAB.asItem(),"Mossy Mud Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_MUD_BRICKS_WALL.asItem(),"Mossy Mud Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_TUFF_BRICKS.asItem(),"Mossy Tuff Bricks");
        translationBuilder.add(ModBlocks.MOSSY_TUFF_BRICKS_STAIRS.asItem(),"Mossy Tuff Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_TUFF_BRICKS_SLAB.asItem(),"Mossy Tuff Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_TUFF_BRICKS_WALL.asItem(),"Mossy Tuff Bricks Wall");
        translationBuilder.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS.asItem(),"Sculked Deepslate Bricks");
        translationBuilder.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS_STAIRS.asItem(),"Sculked Deepslate Bricks Stairs");
        translationBuilder.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS_SLAB.asItem(),"Sculked Deepslate Bricks Slab");
        translationBuilder.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS_WALL.asItem(),"Sculked Deepslate Bricks Wall");

        translationBuilder.add(ModItems.MIDNIGHT_BRICK,"Midnight Brick");
        translationBuilder.add(ModBlocks.MIDNIGHT_BRICKS.asItem(),"Midnight Bricks");
        translationBuilder.add(ModBlocks.MIDNIGHT_BRICKS_STAIRS.asItem(),"Midnight Bricks Stairs");
        translationBuilder.add(ModBlocks.MIDNIGHT_BRICKS_SLAB.asItem(),"Midnight Bricks Slab");
        translationBuilder.add(ModBlocks.MIDNIGHT_BRICKS_WALL.asItem(),"Midnight Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS.asItem(),"Mossy Midnight Bricks");
        translationBuilder.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS_STAIRS.asItem(),"Mossy Midnight Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS_SLAB.asItem(),"Mossy Midnight Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS_WALL.asItem(),"Mossy Midnight Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS.asItem(),"Cracked Midnight Bricks");
        translationBuilder.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS_STAIRS.asItem(),"Cracked Midnight Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS_SLAB.asItem(),"Cracked Midnight Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS_WALL.asItem(),"Cracked Midnight Bricks Wall");
        translationBuilder.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS.asItem(),"Chiseled Midnight Bricks");
        translationBuilder.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS_STAIRS.asItem(),"Chiseled Midnight Bricks Stairs");
        translationBuilder.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS_SLAB.asItem(),"Chiseled Midnight Bricks Slab");
        translationBuilder.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS_WALL.asItem(),"Chiseled Midnight Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS.asItem(),"Mossy Chiseled Midnight Bricks");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_STAIRS.asItem(),"Mossy Chiseled Midnight Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_SLAB.asItem(),"Mossy Chiseled Midnight Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS_WALL.asItem(),"Mossy Chiseled Midnight Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS.asItem(),"Cracked Chiseled Midnight Bricks");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_STAIRS.asItem(),"Cracked Chiseled Midnight Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_SLAB.asItem(),"Cracked Chiseled Midnight Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS_WALL.asItem(),"Cracked Chiseled Midnight Bricks Wall");

        translationBuilder.add(ModBlocks.KAOLIN_CLAY.asItem(),"Kaolin Clay");
        translationBuilder.add(ModItems.KAOLIN_CLAY_BALL,"Kaolin Clay Ball");

        translationBuilder.add(ModBlocks.TREATED_BRICKS.asItem(),"Treated Bricks");
        translationBuilder.add(ModBlocks.TREATED_BRICKS_STAIRS.asItem(),"Treated Bricks Stairs");
        translationBuilder.add(ModBlocks.TREATED_BRICKS_SLAB.asItem(),"Treated Bricks Slab");
        translationBuilder.add(ModBlocks.TREATED_BRICKS_WALL.asItem(),"Treated Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_TREATED_BRICKS.asItem(),"Mossy Treated Bricks");
        translationBuilder.add(ModBlocks.MOSSY_TREATED_BRICKS_STAIRS.asItem(),"Mossy Treated Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_TREATED_BRICKS_SLAB.asItem(),"Mossy Treated Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_TREATED_BRICKS_WALL.asItem(),"Mossy Treated Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_TREATED_BRICKS.asItem(),"Cracked Treated Bricks");
        translationBuilder.add(ModBlocks.CRACKED_TREATED_BRICKS_STAIRS.asItem(),"Cracked Treated Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_TREATED_BRICKS_SLAB.asItem(),"Cracked Treated Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_TREATED_BRICKS_WALL.asItem(),"Cracked Treated Bricks Wall");
        translationBuilder.add(ModBlocks.CHISELED_TREATED_BRICKS.asItem(),"Chiseled Treated Bricks");
        translationBuilder.add(ModBlocks.CHISELED_TREATED_BRICKS_STAIRS.asItem(),"Chiseled Treated Bricks Stairs");
        translationBuilder.add(ModBlocks.CHISELED_TREATED_BRICKS_SLAB.asItem(),"Chiseled Treated Bricks Slab");
        translationBuilder.add(ModBlocks.CHISELED_TREATED_BRICKS_WALL.asItem(),"Chiseled Treated Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS.asItem(),"Mossy Chiseled Treated Bricks");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_STAIRS.asItem(),"Mossy Chiseled Treated Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_SLAB.asItem(),"Mossy Chiseled Treated Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS_WALL.asItem(),"Mossy Chiseled Treated Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS.asItem(),"Cracked Chiseled Treated Bricks");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_STAIRS.asItem(),"Cracked Chiseled Treated Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_SLAB.asItem(),"Cracked Chiseled Treated Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS_WALL.asItem(),"Cracked Chiseled Treated Bricks Wall");
        translationBuilder.add(ModBlocks.MIXED_BRICKS.asItem(),"Mixed Bricks");
        translationBuilder.add(ModBlocks.MIXED_BRICKS_STAIRS.asItem(),"Mixed Bricks Stairs");
        translationBuilder.add(ModBlocks.MIXED_BRICKS_SLAB.asItem(),"Mixed Bricks Slab");
        translationBuilder.add(ModBlocks.MIXED_BRICKS_WALL.asItem(),"Mixed Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_MIXED_BRICKS.asItem(),"Mossy Mixed Bricks");
        translationBuilder.add(ModBlocks.MOSSY_MIXED_BRICKS_STAIRS.asItem(),"Mossy Mixed Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_MIXED_BRICKS_SLAB.asItem(),"Mossy Mixed Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_MIXED_BRICKS_WALL.asItem(),"Mossy Mixed Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_MIXED_BRICKS.asItem(),"Cracked Mixed Bricks");
        translationBuilder.add(ModBlocks.CRACKED_MIXED_BRICKS_STAIRS.asItem(),"Cracked Mixed Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_MIXED_BRICKS_SLAB.asItem(),"Cracked Mixed Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_MIXED_BRICKS_WALL.asItem(),"Cracked Mixed Bricks Wall");

        translationBuilder.add(ModBlocks.CALCITE_BRICKS.asItem(), "Calcite Bricks");
        translationBuilder.add(ModBlocks.CALCITE_BRICKS_STAIRS.asItem(), "Calcite Bricks Stairs");
        translationBuilder.add(ModBlocks.CALCITE_BRICKS_SLAB.asItem(), "Calcite Bricks Slab");
        translationBuilder.add(ModBlocks.CALCITE_BRICKS_WALL.asItem(), "Calcite Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_CALCITE_BRICKS.asItem(), "Mossy Calcite Bricks");
        translationBuilder.add(ModBlocks.MOSSY_CALCITE_BRICKS_STAIRS.asItem(), "Mossy Calcite Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_CALCITE_BRICKS_SLAB.asItem(), "Mossy Calcite Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_CALCITE_BRICKS_WALL.asItem(), "Mossy Calcite Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_CALCITE_BRICKS.asItem(), "Cracked Calcite Bricks");
        translationBuilder.add(ModBlocks.CRACKED_CALCITE_BRICKS_STAIRS.asItem(), "Cracked Calcite Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_CALCITE_BRICKS_SLAB.asItem(), "Cracked Calcite Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_CALCITE_BRICKS_WALL.asItem(), "Cracked Calcite Bricks Wall");

        translationBuilder.add(ModBlocks.ANDESITE_BRICKS.asItem(), "Andesite Bricks");
        translationBuilder.add(ModBlocks.ANDESITE_BRICKS_STAIRS.asItem(), "Andesite Bricks Stairs");
        translationBuilder.add(ModBlocks.ANDESITE_BRICKS_SLAB.asItem(), "Andesite Bricks Slab");
        translationBuilder.add(ModBlocks.ANDESITE_BRICKS_WALL.asItem(), "Andesite Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_ANDESITE_BRICKS.asItem(), "Mossy Andesite Bricks");
        translationBuilder.add(ModBlocks.MOSSY_ANDESITE_BRICKS_STAIRS.asItem(), "Mossy Andesite Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_ANDESITE_BRICKS_SLAB.asItem(), "Mossy Andesite Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_ANDESITE_BRICKS_WALL.asItem(), "Mossy Andesite Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_ANDESITE_BRICKS.asItem(), "Cracked Andesite Bricks");
        translationBuilder.add(ModBlocks.CRACKED_ANDESITE_BRICKS_STAIRS.asItem(), "Cracked Andesite Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_ANDESITE_BRICKS_SLAB.asItem(), "Cracked Andesite Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_ANDESITE_BRICKS_WALL.asItem(), "Cracked Andesite Bricks Wall");

        translationBuilder.add(ModBlocks.DIORITE_BRICKS.asItem(), "Diorite Bricks");
        translationBuilder.add(ModBlocks.DIORITE_BRICKS_STAIRS.asItem(), "Diorite Bricks Stairs");
        translationBuilder.add(ModBlocks.DIORITE_BRICKS_SLAB.asItem(), "Diorite Bricks Slab");
        translationBuilder.add(ModBlocks.DIORITE_BRICKS_WALL.asItem(), "Diorite Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_DIORITE_BRICKS.asItem(), "Mossy Diorite Bricks");
        translationBuilder.add(ModBlocks.MOSSY_DIORITE_BRICKS_STAIRS.asItem(), "Mossy Diorite Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_DIORITE_BRICKS_SLAB.asItem(), "Mossy Diorite Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_DIORITE_BRICKS_WALL.asItem(), "Mossy Diorite Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_DIORITE_BRICKS.asItem(), "Cracked Diorite Bricks");
        translationBuilder.add(ModBlocks.CRACKED_DIORITE_BRICKS_STAIRS.asItem(), "Cracked Diorite Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_DIORITE_BRICKS_SLAB.asItem(), "Cracked Diorite Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_DIORITE_BRICKS_WALL.asItem(), "Cracked Diorite Bricks Wall");

        translationBuilder.add(ModBlocks.DRIPSTONE_BRICKS.asItem(), "Dripstone Bricks");
        translationBuilder.add(ModBlocks.DRIPSTONE_BRICKS_STAIRS.asItem(), "Dripstone Bricks Stairs");
        translationBuilder.add(ModBlocks.DRIPSTONE_BRICKS_SLAB.asItem(), "Dripstone Bricks Slab");
        translationBuilder.add(ModBlocks.DRIPSTONE_BRICKS_WALL.asItem(), "Dripstone Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS.asItem(), "Mossy Dripstone Bricks");
        translationBuilder.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS_STAIRS.asItem(), "Mossy Dripstone Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS_SLAB.asItem(), "Mossy Dripstone Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_DRIPSTONE_BRICKS_WALL.asItem(), "Mossy Dripstone Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS.asItem(), "Cracked Dripstone Bricks");
        translationBuilder.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS_STAIRS.asItem(), "Cracked Dripstone Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS_SLAB.asItem(), "Cracked Dripstone Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_DRIPSTONE_BRICKS_WALL.asItem(), "Cracked Dripstone Bricks Wall");

        translationBuilder.add(ModBlocks.GRANITE_BRICKS.asItem(), "Granite Bricks");
        translationBuilder.add(ModBlocks.GRANITE_BRICKS_STAIRS.asItem(), "Granite Bricks Stairs");
        translationBuilder.add(ModBlocks.GRANITE_BRICKS_SLAB.asItem(), "Granite Bricks Slab");
        translationBuilder.add(ModBlocks.GRANITE_BRICKS_WALL.asItem(), "Granite Bricks Wall");
        translationBuilder.add(ModBlocks.MOSSY_GRANITE_BRICKS.asItem(), "Mossy Granite Bricks");
        translationBuilder.add(ModBlocks.MOSSY_GRANITE_BRICKS_STAIRS.asItem(), "Mossy Granite Bricks Stairs");
        translationBuilder.add(ModBlocks.MOSSY_GRANITE_BRICKS_SLAB.asItem(), "Mossy Granite Bricks Slab");
        translationBuilder.add(ModBlocks.MOSSY_GRANITE_BRICKS_WALL.asItem(), "Mossy Granite Bricks Wall");
        translationBuilder.add(ModBlocks.CRACKED_GRANITE_BRICKS.asItem(), "Cracked Granite Bricks");
        translationBuilder.add(ModBlocks.CRACKED_GRANITE_BRICKS_STAIRS.asItem(), "Cracked Granite Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_GRANITE_BRICKS_SLAB.asItem(), "Cracked Granite Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_GRANITE_BRICKS_WALL.asItem(), "Cracked Granite Bricks Wall");

        translationBuilder.add(ModBlocks.OCEANSLATE.asItem(), "Oceanslate");
        translationBuilder.add(ModBlocks.OCEANSLATE_STAIRS.asItem(), "Oceanslate Stairs");
        translationBuilder.add(ModBlocks.OCEANSLATE_SLAB.asItem(), "Oceanslate Slab");
        translationBuilder.add(ModBlocks.OCEANSLATE_WALL.asItem(), "Oceanslate Wall");
        translationBuilder.add(ModBlocks.OCEANSLATE_BRICKS.asItem(), "Oceanslate Bricks");
        translationBuilder.add(ModBlocks.OCEANSLATE_BRICKS_STAIRS.asItem(), "Oceanslate Bricks Stairs");
        translationBuilder.add(ModBlocks.OCEANSLATE_BRICKS_SLAB.asItem(), "Oceanslate Bricks Slab");
        translationBuilder.add(ModBlocks.OCEANSLATE_BRICKS_WALL.asItem(), "Oceanslate Bricks Wall");
        translationBuilder.add(ModBlocks.OCEANSLATE_TILES.asItem(), "Oceanslate Tiles");
        translationBuilder.add(ModBlocks.OCEANSLATE_TILES_STAIRS.asItem(), "Oceanslate Tiles Stairs");
        translationBuilder.add(ModBlocks.OCEANSLATE_TILES_SLAB.asItem(), "Oceanslate Tiles Slab");
        translationBuilder.add(ModBlocks.OCEANSLATE_TILES_WALL.asItem(), "Oceanslate Tiles Wall");
        translationBuilder.add(ModBlocks.POLISHED_OCEANSLATE.asItem(), "Polished Oceanslate");
        translationBuilder.add(ModBlocks.POLISHED_OCEANSLATE_STAIRS.asItem(), "Polished Oceanslate Stairs");
        translationBuilder.add(ModBlocks.POLISHED_OCEANSLATE_SLAB.asItem(), "Polished Oceanslate Slab");
        translationBuilder.add(ModBlocks.POLISHED_OCEANSLATE_WALL.asItem(), "Polished Oceanslate Wall");
        translationBuilder.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS.asItem(), "Cracked Oceanslate Bricks");
        translationBuilder.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS_STAIRS.asItem(), "Cracked Oceanslate Bricks Stairs");
        translationBuilder.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS_SLAB.asItem(), "Cracked Oceanslate Bricks Slab");
        translationBuilder.add(ModBlocks.CRACKED_OCEANSLATE_BRICKS_WALL.asItem(), "Cracked Oceanslate Bricks Wall");
        translationBuilder.add(ModBlocks.KELPY_OCEANSLATE_BRICKS.asItem(), "Kelpy Oceanslate Bricks");
        translationBuilder.add(ModBlocks.KELPY_OCEANSLATE_BRICKS_STAIRS.asItem(), "Kelpy Oceanslate Bricks Stairs");
        translationBuilder.add(ModBlocks.KELPY_OCEANSLATE_BRICKS_SLAB.asItem(), "Kelpy Oceanslate Bricks Slab");
        translationBuilder.add(ModBlocks.KELPY_OCEANSLATE_BRICKS_WALL.asItem(), "Kelpy Oceanslate Bricks Wall");

        translationBuilder.add(ModItems.TROWEL, "Trowel");

        translationBuilder.add("itemgroup.bauen.bauen_blocks_group", "Bauen");
    }
}
