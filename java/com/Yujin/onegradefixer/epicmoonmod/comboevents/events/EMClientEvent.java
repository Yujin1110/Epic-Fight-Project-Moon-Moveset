package com.Yujin.onegradefixer.epicmoonmod.comboevents.events;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import com.Yujin.onegradefixer.epicmoonmod.client.TSHud;
import com.Yujin.onegradefixer.epicmoonmod.effect.EMeffects;
import com.Yujin.onegradefixer.epicmoonmod.item.EpicmoonItems;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;

@Mod.EventBusSubscriber(modid = Epicmoonmod.MOD_ID, value = Dist.CLIENT)
public class EMClientEvent {
    @SubscribeEvent
    public static void onRenderGui(RenderGuiEvent.Pre event) {
        RenderSystem.enableBlend();
        if (Minecraft.getInstance().screen == null && !Minecraft.getInstance().isPaused()) {
            TSHud.RenderGui(event.getGuiGraphics(), event.getWindow(), event.getPartialTick());
        }
        RenderSystem.disableBlend();
    }
}
