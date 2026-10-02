package net.searchies.bauen.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentValueEffect> MULTITOOL =
            registerValueEffect("multitool", MultitoolEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentValueEffect> registerValueEffect(String name, MapCodec<? extends EnchantmentValueEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_VALUE_EFFECT_TYPE, Identifier.of(Bauen.MOD_ID, name), codec);
    };

    public static void registerEnchantmentEffects() {

    }
}
