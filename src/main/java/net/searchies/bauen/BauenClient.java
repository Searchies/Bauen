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
                ModBlocks.INDUSTRIAL_IRON_DOOR);

        EntityRendererRegistry.register(ModEntities.SEAT, SeatRenderer::new);
    }
}
