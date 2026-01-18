package com.Yujin.onegradefixer.epicmoonmod.gameasset;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import com.Yujin.onegradefixer.epicmoonmod.animations.EMAnimations;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.particle.EpicFightParticles;
import yesman.epicfight.particle.HitParticleType;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(
        modid = "epicmoonmod",
        bus = Mod.EventBusSubscriber.Bus.MOD
)

public class WeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> TEST = (item) -> WeaponCapability.builder().category(CapabilityItem.WeaponCategories.UCHIGATANA).styleProvider((entityPatch) -> CapabilityItem.Styles.TWO_HAND).collider(ColliderPreset.UCHIGATANA).swingSound((SoundEvent) EpicFightSounds.WHOOSH.get()).hitSound((SoundEvent)EpicFightSounds.BLADE_HIT.get()).hitParticle((HitParticleType) EpicFightParticles.HIT_BLADE.get()).canBePlacedOffhand(false).newStyleCombo(CapabilityItem.Styles.TWO_HAND, new AnimationManager.AnimationAccessor[]{EMAnimations.TENTAI_SEITOU_SKILL}).innateSkill(CapabilityItem.Styles.TWO_HAND, (itemstack) -> tsskill.tsskill).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, EMAnimations.TENTAI_SEITOU_GUARD).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, EMAnimations.TENTAI_SEITOU_IDLE).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, EMAnimations.TENTAI_SEITOU_WALK).livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, EMAnimations.TENTAI_SEITOU_RUN).comboCancel((style) -> false);

    @SubscribeEvent
    public static void register(WeaponCapabilityPresetRegistryEvent event) {
        ResourceLocation a = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "tsskill");
        event.getTypeEntry().put(a, TEST);
    }
}
