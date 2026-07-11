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
        translationBuilder.add(ModBlocks.CRACKED_BRICKS.asItem(),"Cracked Bricks");
        translationBuilder.add(ModBlocks.CHISELED_BRICKS.asItem(),"Chiseled Bricks");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_BRICKS.asItem(),"Mossy Chiseled Bricks");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_BRICKS.asItem(),"Cracked Chiseled Bricks");

        translationBuilder.add(ModBlocks.GOLD_CHAIN.asItem(),"Gold Chain");
        translationBuilder.add(ModBlocks.GOLD_LANTERN.asItem(),"Gold Lantern");
        translationBuilder.add(ModBlocks.GOLD_BARS.asItem(),"Gold Bars");
        translationBuilder.add(ModBlocks.CUT_GOLD.asItem(),"Cut Gold");
        translationBuilder.add(ModBlocks.CHISELED_GOLD.asItem(),"Chiseled Gold");
        translationBuilder.add(ModBlocks.GOLD_GRATE.asItem(),"Gold Grate");
        translationBuilder.add(ModBlocks.GOLD_TRAPDOOR.asItem(),"Gold Trapdoor");
        translationBuilder.add(ModBlocks.GOLD_DOOR.asItem(),"Gold Door");
        translationBuilder.add(ModBlocks.GOLD_COINS.asItem(),"Gold Coins");

        translationBuilder.add(ModBlocks.MIXED_COBBLESTONE.asItem(),"Mixed Cobblestone");

        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_BLOCK.asItem(),"Industrial Iron Block");
        translationBuilder.add(ModBlocks.CUT_INDUSTRIAL_IRON.asItem(),"Cut Industrial Iron");
        translationBuilder.add(ModBlocks.CARVED_INDUSTRIAL_IRON.asItem(),"Carved Industrial Iron");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_GRATE.asItem(),"Industrial Iron Grate");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR.asItem(),"Industrial Iron Trapdoor");
        translationBuilder.add(ModBlocks.INDUSTRIAL_IRON_DOOR.asItem(),"Industrial Iron Door");

        translationBuilder.add(ModBlocks.MOSSY_PACKED_MUD.asItem(),"Mossy Packed Mud");
        translationBuilder.add(ModBlocks.MOSSY_MUD_BRICKS.asItem(),"Mossy Mud Bricks");
        translationBuilder.add(ModBlocks.MOSSY_TUFF_BRICKS.asItem(),"Mossy Tuff Bricks");
        translationBuilder.add(ModBlocks.SCULKED_DEEPSLATE_BRICKS.asItem(),"Sculked Deepslate Bricks");

        translationBuilder.add(ModItems.MIDNIGHT_BRICK,"Midnight Brick");
        translationBuilder.add(ModBlocks.MIDNIGHT_BRICKS.asItem(),"Midnight Bricks");
        translationBuilder.add(ModBlocks.MOSSY_MIDNIGHT_BRICKS.asItem(),"Mossy Midnight Bricks");
        translationBuilder.add(ModBlocks.CRACKED_MIDNIGHT_BRICKS.asItem(),"Cracked Midnight Bricks");
        translationBuilder.add(ModBlocks.CHISELED_MIDNIGHT_BRICKS.asItem(),"Chiseled Midnight Bricks");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS.asItem(),"Mossy Chiseled Midnight Bricks");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS.asItem(),"Cracked Chiseled Midnight Bricks");

        translationBuilder.add(ModBlocks.KAOLIN_CLAY.asItem(),"Kaolin Clay");
        translationBuilder.add(ModItems.KAOLIN_CLAY_BALL,"Kaolin Clay Ball");

        translationBuilder.add(ModBlocks.TREATED_BRICKS.asItem(),"Treated Bricks");
        translationBuilder.add(ModBlocks.MOSSY_TREATED_BRICKS.asItem(),"Mossy Treated Bricks");
        translationBuilder.add(ModBlocks.CRACKED_TREATED_BRICKS.asItem(),"Cracked Treated Bricks");
        translationBuilder.add(ModBlocks.CHISELED_TREATED_BRICKS.asItem(),"Chiseled Treated Bricks");
        translationBuilder.add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS.asItem(),"Mossy Chiseled Treated Bricks");
        translationBuilder.add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS.asItem(),"Cracked Chiseled Treated Bricks");
        translationBuilder.add(ModBlocks.MIXED_BRICKS.asItem(),"Mixed Bricks");
        translationBuilder.add(ModBlocks.MOSSY_MIXED_BRICKS.asItem(),"Mossy Mixed Bricks");
        translationBuilder.add(ModBlocks.CRACKED_MIXED_BRICKS.asItem(),"Cracked Mixed Bricks");

        translationBuilder.add(ModBlocks.CALCITE_BRICKS.asItem(), "Calcite Bricks");
        translationBuilder.add(ModBlocks.MOSSY_CALCITE_BRICKS.asItem(), "Mossy Calcite Bricks");
        translationBuilder.add(ModBlocks.CRACKED_CALCITE_BRICKS.asItem(), "Cracked Calcite Bricks");

        translationBuilder.add(ModItems.TROWEL, "Trowel");

//        translationBuilder.add(ModItemGroups.MIDNIGHT_BRICKS_GROUP., "");
    }
}
