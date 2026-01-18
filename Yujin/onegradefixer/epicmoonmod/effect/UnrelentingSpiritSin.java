package com.Yujin.onegradefixer.epicmoonmod.effect;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class UnrelentingSpiritSin extends MobEffect {
    public UnrelentingSpiritSin(MobEffectCategory pCategory, int pColor) {
        super(pCategory,pColor);
    }
    public static final ResourceLocation a = new ResourceLocation("epicmoonmod","goki");
    public static final ResourceLocation b = new ResourceLocation("epicmoonmod","goki_sin");

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        var info = ParticleEmitterInfo.create(pLivingEntity.level(),a).position(pLivingEntity.getX(),pLivingEntity.getY(),pLivingEntity.getZ());
        var info2 = ParticleEmitterInfo.create(pLivingEntity.level(),b).position(pLivingEntity.getX(),pLivingEntity.getY(),pLivingEntity.getZ());
        AAALevel.addParticle(pLivingEntity.level(),true,info.rotation(0F, - (float) Math.toRadians(pLivingEntity.getYHeadRot()),0F));
        AAALevel.addParticle(pLivingEntity.level(),true,info2.rotation(0F, - (float) Math.toRadians(pLivingEntity.getYHeadRot()),0F));
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean m_6584_(int p_19455_, int p_19456_) {
        return true;
    }
}
