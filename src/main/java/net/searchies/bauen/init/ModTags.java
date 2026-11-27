package net.searchies.bauen.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.searchies.bauen.Bauen;

public class ModTags {
    public static class Blocks {
        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(Bauen.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TROWEL_ENCHANTABLE = createTag("enchantable/trowel");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Bauen.MOD_ID, name));
        }
    }
}
