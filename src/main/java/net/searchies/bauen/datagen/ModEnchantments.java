package net.searchies.bauen.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.init.ModTags;

public class ModEnchantments {
    public static final ResourceKey<Enchantment> MULTITOOL =
            ResourceKey.create(Registries.ENCHANTMENT, Identifier.fromNamespaceAndPath(Bauen.MOD_ID, "multitool"));

    public static void bootstrap(BootstrapContext<Enchantment> registerable) {
        var items = registerable.lookup(Registries.ITEM);

        register(registerable, MULTITOOL, Enchantment.enchantment(Enchantment.definition(
                items.getOrThrow(ModTags.Items.TROWEL_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                EquipmentSlotGroup.MAINHAND)));
//                .addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES, new AttributeEnchantmentEffect(Identifier.of(Bauen.MOD_ID, "enchantment.multitool"), EntityAttributes.BLOCK_BREAK_SPEED, new EnchantmentLevelBasedValue.LevelsSquared(3.0f), EntityAttributeModifier.Operation.ADD_VALUE)));
    }

    private static void register(BootstrapContext<Enchantment> registry, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.identifier()));
    }
}
