package com.Yujin.onegradefixer.epicmoonmod.item;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EpicmoonTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Epicmoonmod.MOD_ID);
    public static final RegistryObject<CreativeModeTab> EPICMOON_TAB = TABS.register("epicmoon_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("creativetabs.epicmoon_tab"))
            .icon(EpicmoonItems.TENTAI_SEITOU.get()::getDefaultInstance)
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(EpicmoonItems.TENTAI_SEITOU.get());
                pOutput.accept(EpicmoonItems.TIGERMARK_ROUND.get());
                pOutput.accept(EpicmoonItems.SAVAGE_TIGERMARK_ROUND.get());
                pOutput.accept(EpicmoonItems.THUMB_GUNPOWDER.get());
                pOutput.accept(EpicmoonItems.CARTRIDGE_CASE.get());
            })
            .build());
    public static void register(IEventBus eventBus) {
        TABS.register(eventBus);
    }
}
