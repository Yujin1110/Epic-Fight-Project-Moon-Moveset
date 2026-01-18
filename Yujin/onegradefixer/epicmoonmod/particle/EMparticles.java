package com.Yujin.onegradefixer.epicmoonmod.particle;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EMparticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, Epicmoonmod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> EFFEK_TRAIL = PARTICLE_TYPES.register("effek_trail", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> EFFEK_TRAIL2 = PARTICLE_TYPES.register("effek_trail2", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> EFFEK_TRAIL3 = PARTICLE_TYPES.register("effek_trail3", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> EFFEK_TRAIL4 = PARTICLE_TYPES.register("effek_trail4", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> EFFEK_TRAIL5 = PARTICLE_TYPES.register("effek_trail5", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> EFFEK_TRAIL6 = PARTICLE_TYPES.register("effek_trail6", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> EFFEK_TRAIL7 = PARTICLE_TYPES.register("effek_trail7", () -> new SimpleParticleType(true));

    public static void register(IEventBus iEventBus) {
        PARTICLE_TYPES.register(iEventBus);
    }
}
