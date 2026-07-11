package net.searchies.bauen.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.searchies.bauen.item.ModItems;
import net.searchies.bauen.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup registries) {
        valueLookupBuilder(ModTags.Items.MIDNIGHT_ITEMS_TAG)
            .add(ModItems.KAOLIN_CLAY_BALL)
            .add(ModItems.MIDNIGHT_BRICK)
            .add(ModItems.TROWEL);

        valueLookupBuilder(ItemTags.SHOVELS)
            .add(ModItems.TROWEL);
    }
}
