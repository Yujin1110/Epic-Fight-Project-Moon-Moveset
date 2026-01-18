package com.Yujin.onegradefixer.epicmoonmod.comboevents.events;

import com.Yujin.onegradefixer.epicmoonmod.skill.weapon_innate.TsInnate;
import com.p1nero.invincible.api.events.TimeStampedEvent;
import net.minecraft.world.entity.player.Player;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;

public class UnrelentingSpiritSinEvent {
    public static TimeStampedEvent USSE(float time) {
        return new TimeStampedEvent(time,(entitypatch) -> {
            Player player = entitypatch.getOriginal();
            player.getCapability(EpicFightCapabilities.CAPABILITY_SKILL).ifPresent(capabilitySkill -> {
                SkillContainer skillContainer = capabilitySkill.getSkillContainerFor(SkillSlots.WEAPON_INNATE);
                Skill skill = skillContainer.getSkill();
                TsInnate tsInnate = (TsInnate) skill;
                tsInnate.setAura(2);
            });
        });
    }
}
