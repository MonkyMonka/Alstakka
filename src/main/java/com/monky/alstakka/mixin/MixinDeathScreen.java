package com.monky.alstakka.mixin;

import net.minecraft.client.gui.screens.DeathScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(DeathScreen.class)
public class MixinDeathScreen {
    @Inject(at = @At("HEAD"))
    protected void init() {

    }
}
