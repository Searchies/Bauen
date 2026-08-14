package net.searchies.bauen.init;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.entity.SeatEntity;

public class ModEntities {
    public static final EntityType<SeatEntity> SEAT = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(Bauen.MOD_ID, "seat_entity"),
            EntityType.Builder.create(SeatEntity::new, SpawnGroup.MISC).dimensions(0.5f, 0.5f).build(RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Bauen.MOD_ID + ":seat_entity"))));

    public static void registerModEntities() {

    }
}
