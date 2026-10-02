package net.searchies.bauen.datagen;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.AttributeEnchantmentEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.enchantment.MultitoolEnchantmentEffect;
import net.searchies.bauen.init.ModTags;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> MULTITOOL =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Bauen.MOD_ID, "multitool"));

    public static void bootstrap(Registerable<Enchantment> registerable) {
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, MULTITOOL, Enchantment.builder(Enchantment.definition(
                items.getOrThrow(ModTags.Items.TROWEL_ENCHANTABLE),
                1,
                1,
                Enchantment.constantCost(20),
                Enchantment.constantCost(50),
                8,
                AttributeModifierSlot.MAINHAND))
                .addEffect(EnchantmentEffectComponentTypes.ATTRIBUTES, new AttributeEnchantmentEffect(Identifier.of(Bauen.MOD_ID, "enchantment.multitool"), EntityAttributes.BLOCK_BREAK_SPEED, new EnchantmentLevelBasedValue.LevelsSquared(3.0f), EntityAttributeModifier.Operation.ADD_VALUE)));

    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
