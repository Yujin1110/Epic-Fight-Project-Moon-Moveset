package com.Yujin.onegradefixer.epicmoonmod.client;

import com.Yujin.onegradefixer.epicmoonmod.Epicmoonmod;
import com.Yujin.onegradefixer.epicmoonmod.item.EpicmoonItems;
import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yesman.epicfight.client.ClientEngine;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;

@OnlyIn(Dist.CLIENT)
public class TSHud{
    private static final ResourceLocation EmptyBullet = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/EmptyBullet.png");
    private static final ResourceLocation TigerBullet1 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/TigerBullet1.png");
    private static final ResourceLocation TigerBullet2 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/TigerBullet2.png");
    private static final ResourceLocation TigerBullet3 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/TigerBullet3.png");
    private static final ResourceLocation TigerBullet4 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/TigerBullet4.png");
    private static final ResourceLocation TigerBullet5 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/TigerBullet5.png");
    private static final ResourceLocation TigerBullet6 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/TigerBullet6.png");
    private static final ResourceLocation TigerBullet7 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/TigerBullet7.png");
    private static final ResourceLocation TigerBulletFull = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/TigerBulletFull.png");
    private static final ResourceLocation SavageTigerBullet1 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/SavageTigerBullet1.png");
    private static final ResourceLocation SavageTigerBullet2 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/SavageTigerBullet2.png");
    private static final ResourceLocation SavageTigerBullet3 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/SavageTigerBullet3.png");
    private static final ResourceLocation SavageTigerBullet4 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/SavageTigerBullet4.png");
    private static final ResourceLocation SavageTigerBullet5 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/SavageTigerBullet5.png");
    private static final ResourceLocation SavageTigerBullet6 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/SavageTigerBullet6.png");
    private static final ResourceLocation SavageTigerBullet7 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/SavageTigerBullet7.png");
    private static final ResourceLocation SavageTigerBulletFull = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/SavageTigerBulletFull.png");
    private static final ResourceLocation Light = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/Light.png");
    private static final ResourceLocation Light1 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/Light1.png");
    private static final ResourceLocation Light2 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/Light2.png");
    private static final ResourceLocation Light3 = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/Light3.png");
    private static final ResourceLocation Test = ResourceLocation.fromNamespaceAndPath(Epicmoonmod.MOD_ID, "textures/gui/weapon/Test.png");
    public static void RenderGui (GuiGraphics guiGraphics, Window window, float partialTick) {
        LocalPlayerPatch localPlayerPatch = ClientEngine.getInstance().getPlayerPatch();
        int x = (int) (window.getGuiScaledHeight() * 1.39);
        int y = (int) (window.getGuiScaledWidth() / 2.34);
        int z = (int) (window.getGuiScaledHeight() * 1.39);
        int v = (int) (window.getGuiScaledWidth() / 2.34);
        int s = (int) (window.getGuiScaledHeight() * 1.39);
        int l = (int) (window.getGuiScaledHeight() * 1.409);
        ResourceLocation resourceLocation;

        if(localPlayerPatch != null) {
            Player player = localPlayerPatch.getOriginal();
            ItemStack a = player.getMainHandItem();
            Item b = a.getItem();
            Item c = EpicmoonItems.TENTAI_SEITOU.get();
            CompoundTag TSTG = a.getTag();
            int f = localPlayerPatch.getChargingAmount();
            if (TSTG != null) {
                int d = TSTG.getInt("ammotype");
                int e = TSTG.getInt("amount");
                if (b == c) {
                    player.getCapability(EpicFightCapabilities.CAPABILITY_SKILL).ifPresent(capabilitySkill -> {
                        SkillContainer skillContainer = capabilitySkill.getSkillContainerFor(SkillSlots.WEAPON_INNATE);
                        int aa = skillContainer.getStack();
                        switch (aa) {
                            case 0:
                                guiGraphics.blit(Light, s, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                break;
                            case 1:
                                guiGraphics.blit(Light1, s, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                break;
                            case 2:
                                guiGraphics.blit(Light2, s, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                break;
                            case 3:
                                guiGraphics.blit(Light3, s, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                break;
                        }
                    });
                    guiGraphics.blit(Test, x, v, 105, 54, 0, 0, 64, 64, 64, 64);
                    switch (d) {
                        case 2:
                            switch (e) {
                                case 1:
                                    guiGraphics.blit(SavageTigerBullet1, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 2:
                                    guiGraphics.blit(SavageTigerBullet2, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 3:
                                    guiGraphics.blit(SavageTigerBullet3, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 4:
                                    guiGraphics.blit(SavageTigerBullet4, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 5:
                                    guiGraphics.blit(SavageTigerBullet5, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 6:
                                    guiGraphics.blit(SavageTigerBullet6, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 7:
                                    guiGraphics.blit(SavageTigerBullet7, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 8:
                                    guiGraphics.blit(SavageTigerBulletFull, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                            }
                            break;
                        case 1:
                            switch (e) {
                                case 1:
                                    guiGraphics.blit(TigerBullet1, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 2:
                                    guiGraphics.blit(TigerBullet2, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 3:
                                    guiGraphics.blit(TigerBullet3, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 4:
                                    guiGraphics.blit(TigerBullet4, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 5:
                                    guiGraphics.blit(TigerBullet5, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 6:
                                    guiGraphics.blit(TigerBullet6, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 7:
                                    guiGraphics.blit(TigerBullet7, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                                case 8:
                                    guiGraphics.blit(TigerBulletFull, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                                    break;
                            }
                            break;
                        default:
                        guiGraphics.blit(EmptyBullet, z, y, 105, 54, 0, 0, 64, 64, 64, 64);
                        break;
                    }

                }
            }
        }
    }

}
