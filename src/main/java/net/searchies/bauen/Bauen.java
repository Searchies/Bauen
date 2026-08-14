package net.searchies.bauen;

import net.fabricmc.api.ModInitializer;

import net.searchies.bauen.init.ModBlocks;

import net.searchies.bauen.init.ModEntities;
import net.searchies.bauen.init.ModItemGroups;
import net.searchies.bauen.init.ModItems;
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
		ModEntities.registerModEntities();

		Bauen.LOGGER.info("Hello guys and welcome back to the Channel - PhantomPickle 2026");
	}
}
