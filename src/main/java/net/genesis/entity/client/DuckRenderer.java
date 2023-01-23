package net.genesis.entity.client;

import net.genesis.Init;
import net.genesis.entity.Custom.DuckEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.DynamicGeoEntityRenderer;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import javax.annotation.Nullable;

public class DuckRenderer extends DynamicGeoEntityRenderer<DuckEntity> {


    public DuckRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new DuckModel());
        this.shadowRadius = 0.1f;
    }

    @Override
    public Identifier getTextureLocation(DuckEntity instance){
        return new Identifier(Init.MOD_ID, "textures/entity/duck_texture.png");
    }



    @Override
    public RenderLayer getRenderType(DuckEntity animatable, Identifier texture, @Nullable VertexConsumerProvider bufferSource, float partialTick){
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }


}
