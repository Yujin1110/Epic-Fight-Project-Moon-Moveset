package com.Yujin.onegradefixer.epicmoonmod.comboevents.events;

import com.p1nero.invincible.api.events.TimeStampedEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ShootEvent {
    public static TimeStampedEvent Shoot(float time) {
        return new TimeStampedEvent(time,(entitypatch) -> {
            Player player = entitypatch.getOriginal();
            ItemStack TS = player.getMainHandItem();
            CompoundTag TSTG = TS.getTag();
            if(TSTG == null) {
                TSTG = new CompoundTag();
                TS.setTag(TSTG);
            }
            int a = TSTG.getInt("amount");
            TSTG.putInt("amount", a - 1);
            if(TSTG.getInt("amount") == 0) TSTG.putInt("ammotype", 0);
        });
    }
}
