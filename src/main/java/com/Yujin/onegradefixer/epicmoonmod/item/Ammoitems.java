package com.Yujin.onegradefixer.epicmoonmod.item;

import net.minecraft.world.item.Item;

public class Ammoitems extends Item {
    public int AmmoType;
    public Ammoitems(int i,Item.Properties builder) {
        super(builder);
        this.AmmoType = i;
    }
}
