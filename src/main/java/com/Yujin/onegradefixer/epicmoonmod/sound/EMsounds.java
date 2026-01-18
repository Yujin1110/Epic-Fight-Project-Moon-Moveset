package com.Yujin.onegradefixer.epicmoonmod.sound;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EMsounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Epicmoonmod.MOD_ID);

    public static final RegistryObject<SoundEvent> SHOT = registerSoundEvents("shot");
    public static final RegistryObject<SoundEvent> SHOT2 = registerSoundEvents("shot2");
    public static final RegistryObject<SoundEvent> SHOT3 = registerSoundEvents("shot3");
    public static final RegistryObject<SoundEvent> SHOT4 = registerSoundEvents("shot4");
    public static final RegistryObject<SoundEvent> RELOAD1 = registerSoundEvents("reload1");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(Epicmoonmod.MOD_ID,name)));
    }

    public static void register(IEventBus iEventBus) {
        SOUND_EVENTS.register(iEventBus);
    }
}
