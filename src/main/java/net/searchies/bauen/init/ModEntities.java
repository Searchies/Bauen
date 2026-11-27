package net.searchies.bauen.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.entity.SeatEntity;

public class ModEntities {
    public static final EntityType<SeatEntity> SEAT = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Bauen.MOD_ID, "seat_entity"),
            EntityType.Builder.of(SeatEntity::new, MobCategory.MISC).sized(0.5f, 0.5f).build(ResourceKey.create(Registries.ENTITY_TYPE, Identifier.parse(Bauen.MOD_ID + ":seat_entity"))));

    public static void registerModEntities() {

    }
}
