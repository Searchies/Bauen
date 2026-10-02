package net.searchies.bauen.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;
import net.minecraft.util.math.random.Random;

public record MultitoolEnchantmentEffect() implements EnchantmentValueEffect {
    public static final MapCodec<MultitoolEnchantmentEffect> CODEC = MapCodec.unit(MultitoolEnchantmentEffect::new);

    @Override
    public float apply(int level, Random random, float inputValue) {
        // need to figure out how to apply diamond level tool

        return 0;
    }

    @Override
    public MapCodec<? extends EnchantmentValueEffect> getCodec() {
        return CODEC;
    }
}
