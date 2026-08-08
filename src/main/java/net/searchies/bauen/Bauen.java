package net.searchies.bauen;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.searchies.bauen.block.ModBlocks;

import net.searchies.bauen.item.ModItemGroups;
import net.searchies.bauen.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bauen implements ModInitializer {
	public static final String MOD_ID = "bauen";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();

		Bauen.LOGGER.info("Hello guys and welcome back to the Channel - PhantomPickle 2026");
	}
}
