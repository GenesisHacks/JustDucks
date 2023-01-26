package net.genesis.entity.client;

import net.genesis.Init;
import net.genesis.entity.Custom.DuckEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;

public class DuckModel  extends GeoModel<DuckEntity> {

    @Override
    public Identifier getModelResource(DuckEntity animatable) {
        return new Identifier(Init.MOD_ID, "geo/duck.geo.json");
    }

    @Override
    public Identifier getTextureResource(DuckEntity animatable) {
        return new Identifier(Init.MOD_ID, "textures/entity/duck_texture.png");
    }

    @Override
    public Identifier getAnimationResource(DuckEntity animatable) {
        return new Identifier(Init.MOD_ID, "animations/duck.animation.json");
    }

}
