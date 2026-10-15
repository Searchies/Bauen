package net.searchies.bauen.init;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.trim.ArmorTrimMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.item.AberrantPasteItem;
import net.searchies.bauen.item.TrowelItem;

import java.util.function.Function;

public class ModItems {
    public static final Item KAOLIN_CLAY_BALL = registerItem("kaolin_clay_ball", Item::new);
    public static final Item MIDNIGHT_BRICK = registerItem("midnight_brick", Item::new);
    public static final Item TROWEL = registerItem("trowel", settings ->  new TrowelItem(ToolMaterial.IRON, 1.0F, -3.0F, settings));
    public static final Item ABERRANT_PASTE = registerItem("aberrant_paste", AberrantPasteItem::new);

    public static final Item BEETROOT_RESIN_CLUMP = registerBlockItem("beetroot_resin_clump", createBlockItemWithUniqueName(ModBlocks.BEETROOT_RESIN_CLUMP));
    public static final Item BEETROOT_RESIN_BRICK = registerItem("beetroot_resin_brick", Item::new);

    public static final Item CHORUS_RESIN_CLUMP = registerBlockItem("chorus_resin_clump", createBlockItemWithUniqueName(ModBlocks.CHORUS_RESIN_CLUMP));
    public static final Item CHORUS_RESIN_BRICK = registerItem("chorus_resin_brick", Item::new);

    public static final Item LEMON_RESIN_CLUMP = registerBlockItem("lemon_resin_clump", createBlockItemWithUniqueName(ModBlocks.LEMON_RESIN_CLUMP));
    public static final Item LEMON_RESIN_BRICK = registerItem("lemon_resin_brick", Item::new);
    public static final Item GLACIER_RESIN_CLUMP = registerBlockItem("glacier_resin_clump", createBlockItemWithUniqueName(ModBlocks.GLACIER_RESIN_CLUMP));
    public static final Item GLACIER_RESIN_BRICK = registerItem("glacier_resin_brick", Item::new);
    public static final Item CARAMEL_RESIN_CLUMP = registerBlockItem("caramel_resin_clump", createBlockItemWithUniqueName(ModBlocks.CARAMEL_RESIN_CLUMP));
    public static final Item CARAMEL_RESIN_BRICK = registerItem("caramel_resin_brick", Item::new);
    public static final Item TOXIC_RESIN_CLUMP = registerBlockItem("toxic_resin_clump", createBlockItemWithUniqueName(ModBlocks.TOXIC_RESIN_CLUMP));
    public static final Item TOXIC_RESIN_BRICK = registerItem("toxic_resin_brick", Item::new);
    public static final Item JADE_RESIN_CLUMP = registerBlockItem("jade_resin_clump", createBlockItemWithUniqueName(ModBlocks.JADE_RESIN_CLUMP));
    public static final Item JADE_RESIN_BRICK = registerItem("jade_resin_brick", Item::new);
    public static final Item BUBBLE_RESIN_CLUMP = registerBlockItem("bubble_resin_clump", createBlockItemWithUniqueName(ModBlocks.BUBBLE_RESIN_CLUMP));
    public static final Item BUBBLE_RESIN_BRICK = registerItem("bubble_resin_brick", Item::new);
    public static final Item OCEAN_RESIN_CLUMP = registerBlockItem("ocean_resin_clump", createBlockItemWithUniqueName(ModBlocks.OCEAN_RESIN_CLUMP));
    public static final Item OCEAN_RESIN_BRICK = registerItem("ocean_resin_brick", Item::new);
    public static final Item EMERALD_RESIN_CLUMP = registerBlockItem("emerald_resin_clump", createBlockItemWithUniqueName(ModBlocks.EMERALD_RESIN_CLUMP));
    public static final Item EMERALD_RESIN_BRICK = registerItem("emerald_resin_brick", Item::new);
    public static final Item DUSK_RESIN_CLUMP = registerBlockItem("dusk_resin_clump", createBlockItemWithUniqueName(ModBlocks.DUSK_RESIN_CLUMP));
    public static final Item DUSK_RESIN_BRICK = registerItem("dusk_resin_brick", Item::new);
    public static final Item DAYBREAK_RESIN_CLUMP = registerBlockItem("daybreak_resin_clump", createBlockItemWithUniqueName(ModBlocks.DAYBREAK_RESIN_CLUMP));
    public static final Item DAYBREAK_RESIN_BRICK = registerItem("daybreak_resin_brick", Item::new);
    public static final Item SILT_RESIN_CLUMP = registerBlockItem("silt_resin_clump", createBlockItemWithUniqueName(ModBlocks.SILT_RESIN_CLUMP));
    public static final Item SILT_RESIN_BRICK = registerItem("silt_resin_brick", Item::new);
    public static final Item GRAPHITE_RESIN_CLUMP = registerBlockItem("graphite_resin_clump", createBlockItemWithUniqueName(ModBlocks.GRAPHITE_RESIN_CLUMP));
    public static final Item GRAPHITE_RESIN_BRICK = registerItem("graphite_resin_brick", Item::new);
    public static final Item OBSIDIAN_RESIN_CLUMP = registerBlockItem("obsidian_resin_clump", createBlockItemWithUniqueName(ModBlocks.OBSIDIAN_RESIN_CLUMP));
    public static final Item OBSIDIAN_RESIN_BRICK = registerItem("obsidian_resin_brick", Item::new);
    public static final Item COCOA_RESIN_CLUMP = registerBlockItem("cocoa_resin_clump", createBlockItemWithUniqueName(ModBlocks.COCOA_RESIN_CLUMP));
    public static final Item COCOA_RESIN_BRICK = registerItem("cocoa_resin_brick", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(Bauen.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bauen.MOD_ID, name)))));
    }

    public static void registerModItems() {
        Bauen.LOGGER.info(Bauen.MOD_ID + " || Registering ModItems");
    }

    public static Item registerBlockItem(String name, Function<Item.Settings, Item> function) {
        Item item = function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Bauen.MOD_ID, name))));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, Identifier.of(Bauen.MOD_ID, name), item);
    }

    // Line 1636 in Items.java
    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }
}

