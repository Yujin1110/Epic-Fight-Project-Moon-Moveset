package com.Yujin.onegradefixer.epicmoonmod.comboevents.events;

import com.Yujin.onegradefixer.epicmoonmod.item.EpicmoonItems;
import com.p1nero.invincible.api.events.TimeStampedEvent;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ReloadEvent {
    private static final ItemStack STR = EpicmoonItems.SAVAGE_TIGERMARK_ROUND.get().getDefaultInstance();
    private static final ItemStack TR = EpicmoonItems.TIGERMARK_ROUND.get().getDefaultInstance();

    public static TimeStampedEvent Reload(float time) {
        return new TimeStampedEvent(time,(entitypatch) -> {
            Player player = entitypatch.getOriginal();
            Inventory inventory = player.getInventory();
            int ASTR = inventory.countItem(STR.getItem());
            int ATR = inventory.countItem(TR.getItem());
            ItemStack TS = inventory.player.getMainHandItem();
            CompoundTag TSTG = TS.getTag();
            int count = 0;

            if(TSTG == null) {
                TSTG = new CompoundTag();
                TS.setTag(TSTG);
            }

            for(int i = 0;i<36;i++) {
                if(inventory.getItem(i).getItem() == EpicmoonItems.SAVAGE_TIGERMARK_ROUND.get()) {
                    TSTG.putInt("ammotype", 2);
                    if (ASTR > 8) {
                        TSTG.putInt("amount", 8);
                        for(int c = 0;c<36;c++) {
                            if(inventory.getItem(c).getItem() == EpicmoonItems.SAVAGE_TIGERMARK_ROUND.get()) {
                                int a = inventory.getItem(c).getCount();
                                if (a > 8) {
                                    int b = 8 - count;
                                    inventory.removeItem(c, b);
                                    count += 8;
                                }
                                else {
                                    if(count + a >= 8) {
                                        int b = 8 - count;
                                        inventory.removeItem(c,b);
                                        count = 8;
                                    }
                                    else {
                                        inventory.removeItem(c,a);
                                        count += a;
                                    }
                                }
                            }
                            if(count == 8) {
                                count -= 8;
                                break;
                            }
                        }
                        ItemStack b = new ItemStack(EpicmoonItems.CARTRIDGE_CASE.get(), 8);
                        player.drop(b,false);
                    }
                    else {
                        TSTG.putInt("amount", ASTR);
                        for (int c = 0; c < 36; c++) {
                            if (inventory.getItem(c).getItem() == EpicmoonItems.SAVAGE_TIGERMARK_ROUND.get()) {
                                int a = inventory.getItem(c).getCount();
                                if (a > ASTR) {
                                    int b = ASTR - count;
                                    inventory.removeItem(c, b);
                                    count += ASTR;
                                } else {
                                    if (count + a >= ASTR) {
                                        int b = ASTR - count;
                                        inventory.removeItem(c, b);
                                        count = ASTR;
                                    } else {
                                        inventory.removeItem(c, a);
                                        count += a;
                                    }
                                }
                            }
                            if (count == ASTR) {
                                count -= ASTR;
                                break;
                            }
                        }
                        ItemStack b = new ItemStack(EpicmoonItems.CARTRIDGE_CASE.get(),ASTR);
                        player.drop(b,false);
                    }
                    break;
                }
                if (inventory.getItem(i).getItem() == EpicmoonItems.TIGERMARK_ROUND.get()) {
                    TSTG.putInt("ammotype", 1);
                    if (ATR > 8) {
                        TSTG.putInt("amount", 8);
                        for (int c = 0; c < 36; c++) {
                            if (inventory.getItem(c).getItem() == EpicmoonItems.TIGERMARK_ROUND.get()) {
                                int a = inventory.getItem(c).getCount();
                                if (a > 8) {
                                    int b = 8 - count;
                                    inventory.removeItem(c, b);
                                    count += 8;
                                } else {
                                    if (count + a >= 8) {
                                        int b = 8 - count;
                                        inventory.removeItem(c, b);
                                        count = 8;
                                    } else {
                                        inventory.removeItem(c, a);
                                        count += a;
                                    }
                                }
                            }
                            if (count == 8) {
                                count -= 8;
                                break;
                            }
                        }
                        ItemStack b = new ItemStack(EpicmoonItems.CARTRIDGE_CASE.get(),8);
                        player.drop(b,false);
                    } else {
                        TSTG.putInt("amount", ATR);
                        for (int c = 0; c < 36; c++) {
                            if (inventory.getItem(c).getItem() == EpicmoonItems.TIGERMARK_ROUND.get()) {
                                int a = inventory.getItem(c).getCount();
                                if (a > ATR) {
                                    int b = ATR - count;
                                    inventory.removeItem(c, b);
                                    count += ATR;
                                } else {
                                    if (count + a >= ATR) {
                                        int b = ATR - count;
                                        inventory.removeItem(c, b);
                                        count = ATR;
                                    } else {
                                        inventory.removeItem(c, a);
                                        count += a;
                                    }
                                }
                            }
                            if (count == ATR) {
                                count -= ATR;
                                break;
                            }
                        }
                        ItemStack b = new ItemStack(EpicmoonItems.CARTRIDGE_CASE.get(),ATR);
                        player.drop(b,false);
                    }
                    break;
                }
            }
        });
    }
}
