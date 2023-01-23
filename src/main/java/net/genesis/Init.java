package net.genesis;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.genesis.entity.Custom.DuckEntity;
import net.genesis.entity.ModEntities;
import net.genesis.world.gen.ModEntitySpawn;
import net.genesis.world.gen.ModWorldGen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Init implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("justducks");
	public static String MOD_ID = "justducks";
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		GeckoLib.initialize();
		ModWorldGen.generateWorldGen();
		FabricDefaultAttributeRegistry.register(ModEntities.DUCK, DuckEntity.setAttributes());
		//LOGGER.info("Hello Fabric world!");

	}
}