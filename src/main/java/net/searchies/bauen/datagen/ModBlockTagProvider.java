package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.searchies.bauen.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.MOSSY_BRICKS)
            .add(ModBlocks.CRACKED_BRICKS)
            .add(ModBlocks.CHISELED_BRICKS)
            .add(ModBlocks.MOSSY_CHISELED_BRICKS)
            .add(ModBlocks.CRACKED_CHISELED_BRICKS)

            .add(ModBlocks.GOLD_CHAIN)
            .add(ModBlocks.GOLD_LANTERN)
            .add(ModBlocks.GOLD_BARS)
            .add(ModBlocks.CUT_GOLD)
            .add(ModBlocks.CHISELED_GOLD)
            .add(ModBlocks.GOLD_GRATE)
            .add(ModBlocks.GOLD_TRAPDOOR)
            .add(ModBlocks.GOLD_DOOR)
            .add(ModBlocks.GOLD_COINS)
            .add(ModBlocks.GOLD_HOARD)
            .add(ModBlocks.GOLD_HOARD_BLOCK)

            .add(ModBlocks.INDUSTRIAL_IRON_BLOCK)
            .add(ModBlocks.CUT_INDUSTRIAL_IRON)
            .add(ModBlocks.CARVED_INDUSTRIAL_IRON)
            .add(ModBlocks.INDUSTRIAL_IRON_GRATE)
            .add(ModBlocks.INDUSTRIAL_IRON_TRAPDOOR)
            .add(ModBlocks.INDUSTRIAL_IRON_DOOR)

            .add(ModBlocks.MOSSY_PACKED_MUD)
            .add(ModBlocks.MOSSY_MUD_BRICKS)
            .add(ModBlocks.MOSSY_TUFF_BRICKS)
            .add(ModBlocks.SCULKED_DEEPSLATE_BRICKS)

            .add(ModBlocks.MIDNIGHT_BRICKS)
            .add(ModBlocks.MOSSY_MIDNIGHT_BRICKS)
            .add(ModBlocks.CRACKED_MIDNIGHT_BRICKS)
            .add(ModBlocks.CHISELED_MIDNIGHT_BRICKS)
            .add(ModBlocks.MOSSY_CHISELED_MIDNIGHT_BRICKS)
            .add(ModBlocks.CRACKED_CHISELED_MIDNIGHT_BRICKS)

            .add(ModBlocks.TREATED_BRICKS)
            .add(ModBlocks.MOSSY_TREATED_BRICKS)
            .add(ModBlocks.CRACKED_TREATED_BRICKS)
            .add(ModBlocks.CHISELED_TREATED_BRICKS)
            .add(ModBlocks.MOSSY_CHISELED_TREATED_BRICKS)
            .add(ModBlocks.CRACKED_CHISELED_TREATED_BRICKS)
            .add(ModBlocks.MIXED_BRICKS)
            .add(ModBlocks.MOSSY_MIXED_BRICKS)
            .add(ModBlocks.CRACKED_MIXED_BRICKS)

            .add(ModBlocks.CALCITE_BRICKS)
            .add(ModBlocks.MOSSY_CALCITE_BRICKS)
            .add(ModBlocks.CRACKED_CALCITE_BRICKS)

            .add(ModBlocks.ANDESITE_BRICKS)
            .add(ModBlocks.MOSSY_ANDESITE_BRICKS)
            .add(ModBlocks.CRACKED_ANDESITE_BRICKS)

            .add(ModBlocks.DIORITE_BRICKS)
            .add(ModBlocks.MOSSY_DIORITE_BRICKS)
            .add(ModBlocks.CRACKED_DIORITE_BRICKS)

            .add(ModBlocks.DRIPSTONE_BRICKS)
            .add(ModBlocks.MOSSY_DRIPSTONE_BRICKS)
            .add(ModBlocks.CRACKED_DRIPSTONE_BRICKS)

            .add(ModBlocks.GRANITE_BRICKS)
            .add(ModBlocks.MOSSY_GRANITE_BRICKS)
            .add(ModBlocks.CRACKED_GRANITE_BRICKS)

            .add(ModBlocks.OCEANSLATE)
            .add(ModBlocks.OCEANSLATE_BRICKS)
            .add(ModBlocks.OCEANSLATE_TILES)
            .add(ModBlocks.POLISHED_OCEANSLATE)
            .add(ModBlocks.CRACKED_OCEANSLATE_BRICKS)
            .add(ModBlocks.KELPY_OCEANSLATE_BRICKS);

        valueLookupBuilder(BlockTags.CHAINS).add(ModBlocks.GOLD_CHAIN);
        valueLookupBuilder(BlockTags.LANTERNS).add(ModBlocks.GOLD_LANTERN);
        valueLookupBuilder(BlockTags.BARS).add(ModBlocks.GOLD_BARS);
    }
}
