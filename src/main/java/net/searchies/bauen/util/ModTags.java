package net.searchies.bauen.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> CUSTOM_GOLD_BLOCKS_TAG = createTag("custom_gold_blocks_tag");
        public static final TagKey<Block> CUSTOM_BRICK_BLOCKS_TAG = createTag("custom_brick_blocks_tag");
        public static final TagKey<Block> INDUSTRIAL_IRON_BLOCKS_TAG = createTag("industrial_iron_blocks_tag");
        public static final TagKey<Block> MIDNIGHT_BLOCKS_TAG = createTag("midnight_blocks_tag");
        public static final TagKey<Block> CUSTOM_STONE_TAG = createTag("custom_stone_tag");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Bauen.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MIDNIGHT_ITEMS_TAG = createTag("midnight_items_tag");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Bauen.MOD_ID, name));
        }
    }


}
