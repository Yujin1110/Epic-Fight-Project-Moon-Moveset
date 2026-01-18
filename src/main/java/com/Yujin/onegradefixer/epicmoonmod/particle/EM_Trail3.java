package com.Yujin.onegradefixer.epicmoonmod.particle;

import mod.chloeprime.aaaparticles.api.common.AAALevel;
import mod.chloeprime.aaaparticles.api.common.ParticleEmitterInfo;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.*;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.client.animation.property.ClientAnimationProperties;
import yesman.epicfight.api.client.animation.property.TrailInfo;
import yesman.epicfight.api.utils.math.MathUtils;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.client.ClientEngine;
import yesman.epicfight.client.particle.AnimationTrailParticle;
import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;
import java.util.Optional;

public class EM_Trail3 extends AnimationTrailParticle {
    public static final ResourceLocation a = new ResourceLocation("epicmoonmod","f");
    protected EM_Trail3(ClientLevel level, LivingEntityPatch<?> owner, Joint joint, AssetAccessor<? extends StaticAnimation> animation, TrailInfo trailInfo) {
        super(level, owner, joint, animation, trailInfo);
    }

    @Override
    protected void createNextCurve() {
        TrailInfo trailInfo = this.trailInfo;
        AnimationPlayer animPlayer = ((LivingEntityPatch)this.owner).getAnimator().getPlayerFor(this.animation);
        boolean isTrailInvisible = ((DynamicAnimation)animPlayer.getAnimation().get()).isLinkAnimation() || animPlayer.getElapsedTime() <= this.trailInfo.startTime();
        Pose prevPose = ((LivingEntityPatch)this.owner).getAnimator().getPose(0.0F);
        Vec3 posOld = ((LivingEntity)((LivingEntityPatch)this.owner).getOriginal()).getPosition(0.0F);
        OpenMatrix4f prevModelMatrix = ((LivingEntityPatch)this.owner).getModelMatrix(0.0F);
        OpenMatrix4f prvmodelTf = OpenMatrix4f.createTranslation((float)posOld.x, (float)posOld.y, (float)posOld.z).rotateDeg(180.0F, Vec3f.Y_AXIS).mulBack(prevModelMatrix);
        OpenMatrix4f prevJointTf = ((LivingEntityPatch)this.owner).getArmature().getBoundTransformFor(prevPose, this.joint).mulFront(prvmodelTf);
        Vec3 prevStartPos = OpenMatrix4f.transform(prevJointTf, trailInfo.start());
        Vec3 prevEndPos = OpenMatrix4f.transform(prevJointTf, trailInfo.end());
        super.createNextCurve();
        var info = ParticleEmitterInfo.create(level,a);
        if(isTrailInvisible)  {}
        else {
            AAALevel.addParticle(level, true, info.position(prevStartPos).position(prevEndPos).rotation((float) Math.toRadians(this.owner.getOriginal().getXRot()), - (float) Math.toRadians(this.owner.getOriginal().getYRot()),0F).clone());
        }
    }

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        public Provider(SpriteSet spriteSet) {
        }

        public Particle createParticle(SimpleParticleType typeIn, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            int eid = (int)Double.doubleToRawLongBits(x);
            int animid = (int)Double.doubleToRawLongBits(z);
            int jointId = (int)Double.doubleToRawLongBits(xSpeed);
            int idx = (int)Double.doubleToRawLongBits(ySpeed);
            Entity entity = level.getEntity(eid);
            if (entity == null) {
                return null;
            } else {
                LivingEntityPatch<?> entitypatch = (LivingEntityPatch) EpicFightCapabilities.getEntityPatch(entity, LivingEntityPatch.class);
                if (entitypatch == null) {
                    return null;
                } else {
                    AnimationManager.AnimationAccessor<? extends StaticAnimation> animation = AnimationManager.byId(animid);
                    if (animation == null) {
                        return null;
                    } else {
                        Optional<List<TrailInfo>> trailInfo = ((StaticAnimation)animation.get()).getProperty(ClientAnimationProperties.TRAIL_EFFECT);
                        if (trailInfo.isEmpty()) {
                            return null;
                        } else {
                            TrailInfo result = (TrailInfo)((List)trailInfo.get()).get(idx);
                            if (result.hand() != null) {
                                ItemStack stack = ((LivingEntity)entitypatch.getOriginal()).getItemInHand(result.hand());
                                RenderItemBase renderItemBase = ClientEngine.getInstance().renderEngine.getItemRenderer(stack);
                                if (renderItemBase != null && renderItemBase.trailInfo() != null) {
                                    result = renderItemBase.trailInfo().overwrite(result);
                                }
                            }

                            result = entitypatch.getEntityDecorations().getModifiedTrailInfo(result, result.hand() == null ? CapabilityItem.EMPTY : entitypatch.getAdvancedHoldingItemCapability(result.hand()));
                            return result.playable() ? new EM_Trail3(level, entitypatch, entitypatch.getArmature().searchJointById(jointId), animation, result) : null;
                        }
                    }
                }
            }
        }
    }
}
