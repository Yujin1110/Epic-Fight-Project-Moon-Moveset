package com.Yujin.onegradefixer.epicmoonmod.comboevents.events;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import com.Yujin.onegradefixer.epicmoonmod.client.TSHud;
import com.Yujin.onegradefixer.epicmoonmod.particle.*;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(
        modid = Epicmoonmod.MOD_ID,
        value = Dist.CLIENT,
        bus = Mod.EventBusSubscriber.Bus.MOD
)
public class EMeventbusevents {
    @SubscribeEvent
    public static void onParticleRegistry(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(EMparticles.EFFEK_TRAIL.get(), EM_Trail.Provider::new);
        event.registerSpriteSet(EMparticles.EFFEK_TRAIL2.get(), EM_Trail2.Provider::new);
        event.registerSpriteSet(EMparticles.EFFEK_TRAIL3.get(), EM_Trail3.Provider::new);
        event.registerSpriteSet(EMparticles.EFFEK_TRAIL4.get(), EM_Trail4.Provider::new);
        event.registerSpriteSet(EMparticles.EFFEK_TRAIL5.get(), EM_Trail5.Provider::new);
        event.registerSpriteSet(EMparticles.EFFEK_TRAIL6.get(), EM_Trail6.Provider::new);
        event.registerSpriteSet(EMparticles.EFFEK_TRAIL7.get(), EM_Trail7.Provider::new);
    }
}
