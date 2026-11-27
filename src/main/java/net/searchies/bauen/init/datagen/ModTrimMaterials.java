package net.searchies.bauen.init.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.searchies.bauen.Bauen;

public class ModTrimMaterials {
    public static final ResourceKey<TrimMaterial> PRISMARINE = registryKey("prismarine");

    public static void bootstrap(BootstrapContext<TrimMaterial> bootstrapContext) {
        register(bootstrapContext, PRISMARINE, Style.EMPTY.withColor(14931140), MaterialAssetGroup.create("prismarine"));
    }

    private static void register(BootstrapContext<TrimMaterial> bootstrapContext, ResourceKey<TrimMaterial> resourceKey, Style style, MaterialAssetGroup materialAssetGroup) {
        Component component = Component.translatable(Util.makeDescriptionId("trim_material", resourceKey.identifier())).withStyle(style);
        bootstrapContext.register(resourceKey, new TrimMaterial(materialAssetGroup, component));
    }

    private static ResourceKey<TrimMaterial> registryKey(String string) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, Bauen.id(string));
    }
}