package net.searchies.bauen.item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;

import java.util.function.Function;

public class ModItems {
    public static final Item KAOLIN_CLAY_BALL = registerItem("kaolin_clay_ball", Item::new);
    public static final Item MIDNIGHT_BRICK = registerItem("midnight_brick", Item::new);
    public static final Item TROWEL = registerItem("trowel", settings ->  new TrowelItem(ToolMaterial.IRON, 1.0F, -3.0F, settings
    ));

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Bauen.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bauen.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Bauen.LOGGER.info(Bauen.MOD_ID + " || Registering ModItems");
    }
}

