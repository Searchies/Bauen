package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModItems;
import net.searchies.bauen.init.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        valueLookupBuilder(ItemTags.SHOVELS)
            .add(ModItems.TROWEL);
        valueLookupBuilder(ModTags.Items.TROWEL_ENCHANTABLE)
            .add(ModItems.TROWEL);
        valueLookupBuilder(ConventionalItemTags.CHAINS)
                .add(ModBlocks.GOLD_CHAIN.asItem());
        ModBlocks.ABERRANT_COPPER_CHAINS.getAll().forEach(block -> valueLookupBuilder(ConventionalItemTags.CHAINS).add(block.asItem()));
    }
}
