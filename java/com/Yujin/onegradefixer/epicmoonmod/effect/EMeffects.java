package com.Yujin.onegradefixer.epicmoonmod.effect;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EMeffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Epicmoonmod.MOD_ID);

    public static final RegistryObject<MobEffect> UNRELENTING_SPIRIT = MOB_EFFECTS.register("unrelenting_spirit",() -> new UnrelentingSpirit(MobEffectCategory.NEUTRAL,00000000).addAttributeModifier(Attributes.ATTACK_DAMAGE, "5f36ae1c-0856-4901-b712-9261ba03567d",0.2F,AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.MOVEMENT_SPEED,"5f36ae1c-0856-4901-b712-9261ba03567d",0.2F,AttributeModifier.Operation.MULTIPLY_TOTAL));
    public static final RegistryObject<MobEffect> UNRELENTING_SPIRIT_SIN = MOB_EFFECTS.register("unrelenting_spirit_sin",() -> new UnrelentingSpiritSin(MobEffectCategory.NEUTRAL,00000000).addAttributeModifier(Attributes.ATTACK_DAMAGE, "5f36ae1c-0856-4901-b712-9261ba03567d",0.5F,AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.MOVEMENT_SPEED,"5f36ae1c-0856-4901-b712-9261ba03567d",0.2F,AttributeModifier.Operation.MULTIPLY_TOTAL).addAttributeModifier(Attributes.ARMOR,"5f36ae1c-0856-4901-b712-9261ba03567d",10,AttributeModifier.Operation.ADDITION).addAttributeModifier(Attributes.ARMOR_TOUGHNESS,"5f36ae1c-0856-4901-b712-9261ba03567d",5,AttributeModifier.Operation.ADDITION));

    public static void register(IEventBus iEventBus) {
        MOB_EFFECTS.register(iEventBus);
    }
}
