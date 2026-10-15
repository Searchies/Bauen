package net.searchies.bauen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.searchies.bauen.entity.SeatRenderer;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModEntities;

public class BauenClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT,
            ModBlocks.GOLD_CHAIN,
            ModBlocks.GOLD_LANTERN,
            ModBlocks.GOLD_TRAPDOOR,
            ModBlocks.GOLD_GRATE,
            ModBlocks.GOLD_BARS,
            ModBlocks.GOLD_DOOR,
            ModBlocks.GOLD_COINS,
            ModBlocks.CARVED_INDUSTRIAL_IRON,
            ModBlocks.INDUSTRIAL_IRON_GRATE,
            ModBlocks.INDUSTRIAL_IRON_TRAPDOOR,
            ModBlocks.INDUSTRIAL_IRON_DOOR,
            ModBlocks.BEETROOT_RESIN_CLUMP,
            ModBlocks.CHORUS_RESIN_CLUMP,
            ModBlocks.LEMON_RESIN_CLUMP,
            ModBlocks.GLACIER_RESIN_CLUMP,
            ModBlocks.CARAMEL_RESIN_CLUMP,
            ModBlocks.TOXIC_RESIN_CLUMP,
            ModBlocks.JADE_RESIN_CLUMP,
            ModBlocks.BUBBLE_RESIN_CLUMP,
            ModBlocks.OCEAN_RESIN_CLUMP,
            ModBlocks.EMERALD_RESIN_CLUMP,
            ModBlocks.DUSK_RESIN_CLUMP,
            ModBlocks.DAYBREAK_RESIN_CLUMP,
            ModBlocks.SILT_RESIN_CLUMP,
            ModBlocks.GRAPHITE_RESIN_CLUMP,
            ModBlocks.OBSIDIAN_RESIN_CLUMP,
            ModBlocks.COCOA_RESIN_CLUMP);

        EntityRendererRegistry.register(ModEntities.SEAT, SeatRenderer::new);
    }
}
