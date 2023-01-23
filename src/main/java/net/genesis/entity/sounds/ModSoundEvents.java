package net.genesis.entity.sounds;

import net.genesis.Init;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSoundEvents {

    /*public static final Identifier DUCK_AMBIENT = new Identifier(Init.MOD_ID, "duck_ambient");
    public static final SoundEvent DUCK_IDLE = new SoundEvent(DUCK_AMBIENT, 10.0, true);

    public static void register(Object optionalEvent) {
        Registry.register(Registries.SOUND_EVENT, DUCK_AMBIENT, DUCK_IDLE);
    }

    public static SoundEvent DuckSound() {
        return DUCK_IDLE;
    }
    public static SoundEvent DUCK_IDLE;

    public static void init() {
        DUCK_IDLE = register("duck_idle");

    }

    private static SoundEvent register(String name) {
        Identifier id = new Identifier(Init.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, new SoundEvent(id));
    }*/

}
