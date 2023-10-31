package com.origin.worldsrelics.sound;

import com.origin.worldsrelics.WorldsRelics;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WorldsRelics.MODID);

    public static final RegistryObject<SoundEvent> ROD_OF_DISCORD_WARP = registerSoundEvents("rod_of_discord_warp");
    public static final RegistryObject<SoundEvent> ROD_OF_DISCORD_WARP_PING = registerSoundEvents("rod_of_discord_warp_ping");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(WorldsRelics.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
