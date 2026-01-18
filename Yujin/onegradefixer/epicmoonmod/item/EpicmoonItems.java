package com.Yujin.onegradefixer.epicmoonmod.item;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EpicmoonItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Epicmoonmod.MOD_ID);
    public static final RegistryObject<Item> THUMB_GUNPOWDER = ITEMS.register("thumb_gunpowder", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARTRIDGE_CASE = ITEMS.register("cartridge_case", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIGERMARK_ROUND = ITEMS.register("tigermark_round", () -> new Ammoitems(1,new Item.Properties()));
    public static final RegistryObject<Item> SAVAGE_TIGERMARK_ROUND = ITEMS.register("savage_tigermark_round", () -> new Ammoitems(2,new Item.Properties()));
    public static final RegistryObject<Item> TENTAI_SEITOU = ITEMS.register("tentai_seitou", () -> new Tentai_Seitouitems(Tiers.NETHERITE,10,-2.8F,new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

