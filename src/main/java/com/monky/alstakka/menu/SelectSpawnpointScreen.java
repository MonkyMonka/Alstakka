package com.monky.alstakka.menu;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SelectSpawnpointScreen extends Screen implements ScrollButton.IScrollListener {

    private SpawnpointSelectList spawnpointSelectList;
    private ScrollButton scrollButton;
    public SelectSpawnpointScreen(Component pTitle) {
        super(pTitle);
    }

    protected void init() {
        this.spawnpointSelectList = new SpawnpointSelectList(this, this.minecraft);
        this.scrollButton = new ScrollButton(1, 2, 4,4,new ResourceLocation("alstakka", "textures/gui/scrollbar.png"),4,
                4,176,166,4,true,1.0F , spawnpointSelectList.selectSpawnpointScreen);
        this.addWidget(this.spawnpointSelectList);
        this.addRenderableWidget(this.scrollButton);
    }


    public void render(PoseStack pPoseStack, int pMouseX, int pMouseY, float pPartialTick) {
        this.renderBackground(pPoseStack);
        this.spawnpointSelectList.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
        drawCenteredString(pPoseStack, this.font, this.title, this.width / 2, 8, 16777215);

        super.render(pPoseStack, pMouseX, pMouseY, pPartialTick);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if(button == 0 && scrollButton != null && scrollButton.isHoveredOrFocused() && scrollButton.isDragging()) {
            scrollButton.onDrag(mouseX, mouseY, dragX, dragY);
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    @Override
    public void onScroll(ScrollButton button, float percent) {

    }
}