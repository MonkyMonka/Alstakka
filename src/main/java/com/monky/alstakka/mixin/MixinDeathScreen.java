package com.monky.alstakka.mixin;

import com.google.common.collect.Lists;
import com.monky.alstakka.menu.SelectSpawnpointScreen;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.*;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import javax.annotation.Nullable;
import java.util.List;


@Mixin(DeathScreen.class)
public class MixinDeathScreen extends Screen {

    private int delayTicker;
    private final Component causeOfDeath;
    private final boolean hardcore;
    private Component deathScore;
    private final List<Button> exitButtons = Lists.newArrayList();
    @Nullable
    private Button exitToTitleButton;

    public MixinDeathScreen(@Nullable Component pCauseOfDeath, boolean pHardcore) {
        super(Component.translatable(pHardcore ? "deathScreen.title.hardcore" : "alstakka.deathScreen.respawnpoints"));
        this.causeOfDeath = pCauseOfDeath;
        this.hardcore = pHardcore;
    }

    protected void init() {
        this.delayTicker = 0;
        this.exitButtons.clear();
        Component component = this.hardcore ? Component.translatable("deathScreen.spectate") : Component.translatable("deathScreen.respawn");
        this.exitButtons.add(this.addRenderableWidget(Button.builder(component, (p_95930_) -> {
            this.handleSpawnPointSelectionMenu();
            this.minecraft.player.respawn();
        }).bounds(this.width / 2 - 100, this.height / 4 + 72, 200, 20).build()));
        this.exitToTitleButton = this.addRenderableWidget(Button.builder(Component.translatable("deathScreen.titleScreen"), (p_262871_) -> {
            this.minecraft.getReportingContext().draftReportHandled(this.minecraft, this, this::handleExitToTitleScreen, true);
        }).bounds(this.width / 2 - 100, this.height / 4 + 96, 200, 20).build());
        this.exitButtons.add(this.exitToTitleButton);

        for (Button button : this.exitButtons) {
            button.active = false;
        }

        this.deathScore = Component.translatable("deathScreen.score").append(": ").append(Component.literal(Integer.toString(this.minecraft.player.getScore())).withStyle(ChatFormatting.YELLOW));
    }

    @Shadow
    private void handleExitToTitleScreen() {
        if (this.hardcore) {
            this.exitToTitleScreen();
        } else {
            ConfirmScreen confirmscreen = new ConfirmScreen((p_262870_) -> {
                if (p_262870_) {
                    this.exitToTitleScreen();
                } else {
                    this.minecraft.player.respawn();
                    this.minecraft.setScreen((Screen)null);
                }

            }, Component.translatable("deathScreen.quit.confirm"), CommonComponents.EMPTY, Component.translatable("deathScreen.titleScreen"), Component.translatable("deathScreen.respawn"));
            this.minecraft.setScreen(confirmscreen);
            confirmscreen.setDelay(20);
        }
    }

    @Shadow
    private void exitToTitleScreen() {
        if (this.minecraft.level != null) {
            this.minecraft.level.disconnect();
        }

        this.minecraft.clearLevel(new GenericDirtMessageScreen(Component.translatable("menu.savingLevel")));
        this.minecraft.setScreen(new TitleScreen());
    }

    private void handleSpawnPointSelectionMenu() {
        this.minecraft.setScreen(new SelectSpawnpointScreen(title));
    }



}