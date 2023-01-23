package net.genesis.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.genesis.Init;
import net.genesis.entity.Custom.DuckEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.SpawnSettings;

import javax.swing.text.html.parser.Entity;

public class ModEntities {
    public static final EntityType<DuckEntity> DUCK = Registry.register(Registries.ENTITY_TYPE, new Identifier(Init.MOD_ID, "duck"),
            FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, DuckEntity::new)

                    .dimensions(EntityDimensions.fixed(0.4f,0.4f))
                    .build());



}
