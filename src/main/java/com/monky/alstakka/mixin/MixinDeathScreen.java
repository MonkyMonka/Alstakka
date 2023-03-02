package com.monky.alstakka.mixin;

import net.minecraft.client.gui.screens.DeathScreen;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(DeathScreen.class)
public class MixinDeathScreen {
    protected void init() {

    }
}
