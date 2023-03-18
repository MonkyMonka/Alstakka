package com.monky.alstakka.menu;


import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.ContainerObjectSelectionList;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarratedElementType;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collections;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class SpawnpointSelectList extends ContainerObjectSelectionList {
    final SelectSpawnpointScreen selectSpawnpointScreen;
    int maxNameWidth;

    public SpawnpointSelectList(SelectSpawnpointScreen pSelectSpawnpointScreen, Minecraft pMinecraft) {
        super(pMinecraft, pSelectSpawnpointScreen.width + 45, pSelectSpawnpointScreen.height, 20, pSelectSpawnpointScreen.height - 32, 20);
        this.selectSpawnpointScreen = pSelectSpawnpointScreen;

    }

    public int getRowWidth() {
        return super.getRowWidth() + 32;
    }

    protected int getScrollbarPosition() {
        return super.getScrollbarPosition() + 15 + 20;
    }


    @OnlyIn(Dist.CLIENT)
    public class CategoryEntry extends SpawnpointSelectList.Entry {
        final Component name;
        private final int width;

        public CategoryEntry(Component pName) {
            this.name = pName;
            this.width = SpawnpointSelectList.this.minecraft.font.width(this.name);
        }

        public void render(PoseStack pPoseStack, int pIndex, int pTop, int pLeft, int pWidth, int pHeight, int pMouseX, int pMouseY, boolean pIsMouseOver, float pPartialTick) {
            SpawnpointSelectList.this.minecraft.font.draw(pPoseStack, this.name, (float) (SpawnpointSelectList.this.minecraft.screen.width / 2 - this.width / 2), (float) (pTop + pHeight - 9 - 1), 16777215);
        }

        public boolean changeFocus(boolean pFocus) {
            return false;
        }

        public List<? extends GuiEventListener> children() {
            return Collections.emptyList();
        }

        public List<? extends NarratableEntry> narratables() {
            return ImmutableList.of(new NarratableEntry() {
                public NarratableEntry.NarrationPriority narrationPriority() {
                    return NarratableEntry.NarrationPriority.HOVERED;
                }

                public void updateNarration(NarrationElementOutput p_193906_) {
                    p_193906_.add(NarratedElementType.TITLE, SpawnpointSelectList.CategoryEntry.this.name);
                }
            });
        }
    }
}

