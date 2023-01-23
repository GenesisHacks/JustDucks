package net.genesis;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.genesis.entity.ModEntities;
import net.genesis.entity.client.DuckRenderer;
import net.minecraft.client.render.entity.EntityRenderer;

public class InitClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.DUCK, DuckRenderer::new);
    }
}
