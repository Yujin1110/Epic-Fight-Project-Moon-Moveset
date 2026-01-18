package com.Yujin.onegradefixer.epicmoonmod.item;


import com.Yujin.onegradefixer.epicmoonmod.effect.EMeffects;
import com.Yujin.onegradefixer.epicmoonmod.skill.weapon_innate.TsInnate;
import com.merlin204.avalon.item.animationitem.IAvalonAnimationItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import yesman.epicfight.api.data.reloader.SkillManager;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.SkillSlot;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.item.WeaponItem;

import java.util.List;

public class Tentai_Seitouitems extends WeaponItem implements IAvalonAnimationItem {

    public final Armatures.ArmatureAccessor<? extends Armature> ARMATUREACCESSOR = Armatures.ArmatureAccessor.create("epicmoonmod","tentai_seitou",Armature::new);

    public Tentai_Seitouitems(Tier tier, int damageIn, float speedIn, Item.Properties builder) {
        super(tier, damageIn, speedIn, builder);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        CompoundTag TSTG = pStack.getTag();
        if(TSTG == null) {
            TSTG = new CompoundTag();
            pStack.setTag(TSTG);
            TSTG.putInt("ammotype", 0);
            TSTG.putInt("amount", 0);
        }
        pTooltipComponents.add(Component.translatable("tooltip.epicmoonmod.tstip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
        if (!pLevel.isClientSide) {
            if (pEntity instanceof Player) {
                ItemStack a = ((Player) pEntity).getMainHandItem();
                if (a.getItem() == EpicmoonItems.TENTAI_SEITOU.get()) {
                    pEntity.getCapability(EpicFightCapabilities.CAPABILITY_SKILL).ifPresent(capabilitySkill -> {
                        SkillContainer skillContainer = capabilitySkill.getSkillContainerFor(SkillSlots.WEAPON_INNATE);
                        if(skillContainer.getSkill() != null) {
                            TsInnate tsInnate = (TsInnate) skillContainer.getSkill();
                            float b = tsInnate.getAura();
                            if(b == 1) {
                                ((Player) pEntity).addEffect(new MobEffectInstance(EMeffects.UNRELENTING_SPIRIT.get(), 2, 0, true, true));
                            }
                            if(b == 2) {
                                ((Player) pEntity).addEffect(new MobEffectInstance(EMeffects.UNRELENTING_SPIRIT_SIN.get(), 2, 0, true, true));
                            }
                        }
                    });
                }
                else {
                    pEntity.getCapability(EpicFightCapabilities.CAPABILITY_SKILL).ifPresent(capabilitySkill -> {
                        SkillContainer skillContainer = capabilitySkill.getSkillContainerFor(SkillSlots.WEAPON_INNATE);
                        if(skillContainer.getSkill() instanceof TsInnate) {
                            TsInnate tsInnate = (TsInnate) skillContainer.getSkill();
                            float b = tsInnate.getAura();
                            if (b != 0) {
                                tsInnate.setAura(0);
                            }
                        }
                    });
                }
            }
        }
    }
    public Armatures.ArmatureAccessor<? extends Armature> getArmature(){return this.ARMATUREACCESSOR;}
}
