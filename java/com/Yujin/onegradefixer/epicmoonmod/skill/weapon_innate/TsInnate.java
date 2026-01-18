package com.Yujin.onegradefixer.epicmoonmod.skill.weapon_innate;

import com.google.common.collect.Lists;
import com.p1nero.invincible.client.InvincibleKeyMappings;
import com.p1nero.invincible.skill.ComboBasicAttack;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

import java.util.List;

public class TsInnate extends ComboBasicAttack {
    float Aura;

    public TsInnate(Builder builder) { super(builder);}

    @Override
    public void setParams(CompoundTag parameters) {
        this.Aura = parameters.getFloat("aura");
        super.setParams(parameters);
    }

    public float getAura() {return this.Aura;}

    public void setAura(float aura) {this.Aura=aura;}

    public List<Component> getTooltipOnItem(ItemStack itemStack, CapabilityItem cap, PlayerPatch<?> playerpatch) {
        List<Component> list = Lists.newArrayList();
        list.add(Component.translatable("skill.epicmoonmod.ts.tooltip").withStyle(ChatFormatting.GRAY));
        list.add(Component.translatable("skill.epicmoonmod.ts.tooltip1").withStyle(ChatFormatting.GRAY).append(InvincibleKeyMappings.getTranslatableKey3()));
        list.add(Component.translatable("skill.epicmoonmod.ts.tooltip3").withStyle(ChatFormatting.GRAY).append(InvincibleKeyMappings.getTranslatableKey4()));
        list.add(Component.translatable("skill.epicmoonmod.ts.tooltip2"));
        return list;
    }
}
