package com.Yujin.onegradefixer.epicmoonmod.comboevents;

import com.Yujin.onegradefixer.epicmoonmod.item.EpicmoonItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.data.conditions.Condition;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

import java.util.List;

public class AmmoCondition implements Condition<ServerPlayerPatch> {
    @Override
    public boolean predicate(ServerPlayerPatch serverPlayerPatch) {
        ItemStack round = EpicmoonItems.TIGERMARK_ROUND.get().getDefaultInstance();
        ItemStack round2 = EpicmoonItems.SAVAGE_TIGERMARK_ROUND.get().getDefaultInstance();
        Player player = serverPlayerPatch.getOriginal();
        Inventory inventory = player.getInventory();
        if(inventory.contains(round)) return true;
        else if(inventory.contains(round2)) return true;
        else return false;
    }

    @Override
    public Condition<ServerPlayerPatch> read(CompoundTag compoundTag) {
        return null;
    }

    @Override
    public CompoundTag serializePredicate() {
        return null;
    }

    @Override
    public List<ParameterEditor> getAcceptingParameters(Screen screen) {
        return null;
    }
}
