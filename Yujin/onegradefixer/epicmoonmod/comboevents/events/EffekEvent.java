package com.Yujin.onegradefixer.epicmoonmod.comboevents.events;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import com.p1nero.invincible.api.events.TimeStampedEvent;
import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.nio.file.Path;

public class EffekEvent {
    public static TimeStampedEvent Effek(float time,String string) {
        return new TimeStampedEvent(time, (entitypatch) -> {
            Player player = entitypatch.getOriginal();
            ResourceLocation resourceLocation = new ResourceLocation("epicmoonmod",string);
            var info = ParticleEmitterInfo.create(player.level(),resourceLocation);
            AAALevel.addParticle(player.level(), true, info.position(player.getX(),player.getY(),player.getZ()).rotation(0F, - (float) Math.toRadians(player.getYHeadRot()),0F));
        });
    }
}
