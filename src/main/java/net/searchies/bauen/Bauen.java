package net.searchies.bauen;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ProvidesTrimMaterial;
import net.searchies.bauen.init.ModBlocks;
import net.searchies.bauen.init.ModEntities;
import net.searchies.bauen.init.ModItemGroups;
import net.searchies.bauen.init.ModItems;
import net.searchies.bauen.init.datagen.ModTrimMaterials;
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

		DefaultItemComponentEvents.MODIFY.register(listener -> {
			listener.modify(Items.PRISMARINE_SHARD, (builder) -> {
				builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(ModTrimMaterials.PRISMARINE));
			});
		});

		Bauen.LOGGER.info("Hello guys and welcome back to the Channel - PhantomPickle 2026");
	}

	public static Identifier id(String path) {
		return Identifier.fromNamespaceAndPath(MOD_ID, path);
	}
}
