package potionstudios.byg.client.gui.biomepedia1;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class BiomeListScreen extends Screen {
    private final Screen parent;
    private List<ResourceKey<Biome>> biomes;
    int imageWidth = 288;
    int imageHeight = 208;
    int leftPos;
    int bottomPos;
    int rightPos;
    int topPos;
    int page;


    private BiomeWidget[][][] widgets;

    protected BiomeListScreen(Screen parent, List<ResourceKey<Biome>> biomes) {
        super(new TranslatableComponent(""));
        this.parent = parent;
        this.biomes = biomes;
    }

    @Override
    protected void init() {
        super.init();
        this.leftPos = ((this.width - this.imageWidth) / 2);
        this.bottomPos = (this.height - this.imageHeight) / 2 - 15;
        this.rightPos = this.leftPos + this.imageWidth;
        this.topPos = this.bottomPos + this.imageHeight;
        int pagePairsCount = (biomes.size() / 4);
        int registryIdx = 0;
        int offsetFromEdge = 14;


        widgets = new BiomeWidget[pagePairsCount][2][2];
        int xOffset = this.leftPos + offsetFromEdge + 4;
        for (BiomeWidget[][] pagePairs : widgets) {
            for (int pageSide = 0; pageSide < pagePairs.length; pageSide++) {
                int startX = ((this.imageWidth / 2) - 8) * pageSide;
                int yOffset = this.bottomPos + offsetFromEdge;

                BiomeWidget[] page = pagePairs[pageSide];
                for (int yPos = 0; yPos < page.length; yPos++) {
                    if (registryIdx > biomes.size() - 1) {
                        break;
                    }
                    page[yPos] = this.addRenderableWidget(new BiomeWidget(this.biomes.get(registryIdx), xOffset + startX, yOffset, (int) (this.imageWidth / 2.5F), (int) (this.imageHeight / 2.7), button -> {
                    }));
                    registryIdx++;
                    yOffset += (this.imageHeight / 2.7) + 10;
                }
            }
        }
        PageButton pageBack = new PageButton(this.leftPos + 5, this.topPos - 10, false, button -> {
            unload(page);
            this.page = page == 0 ? pagePairsCount - 1 : (page - 1) % pagePairsCount;
            load(this.page);
        }, true);
        this.addRenderableWidget(pageBack);
        pageBack.x = this.leftPos + 15;
        pageBack.y = this.topPos - pageBack.getHeight() - 13;

        PageButton pageForward = new PageButton(this.rightPos - 5, this.topPos - 10, true, button -> {
            unload(page);
            this.page = (page + 1) % pagePairsCount;
            load(this.page);
        }, true);
        this.addRenderableWidget(pageForward);
        pageForward.x = this.rightPos - pageBack.getWidth() - 22;
        pageForward.y = this.topPos - pageBack.getHeight() - 13;
        load(page);

    }


    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        this.renderBackground(poseStack);
        RenderSystem.setShaderTexture(0, BiomepediaScreen.BIOMEPEDIA_LOCATION);

        blit(poseStack, this.leftPos, this.bottomPos, 0, 0, imageWidth, imageHeight, imageWidth, imageHeight);


        super.render(poseStack, mouseX, mouseY, partialTick);
    }

    private void unload(int page) {
        BiomeWidget[][] biomeWidgets = this.widgets[page];
        for (BiomeWidget[] biomeWidgetsByPage : biomeWidgets) {
            for (BiomeWidget biomeWidget : biomeWidgetsByPage) {
                if (biomeWidget != null) {
                    biomeWidget.visible = false;
                    biomeWidget.active = false;
                }
            }
        }
    }

    private void load(int page) {
        BiomeWidget[][] biomeWidgets = this.widgets[page];
        for (BiomeWidget[] biomeWidgetsByPage : biomeWidgets) {
            for (BiomeWidget biomeWidget : biomeWidgetsByPage) {
                if (biomeWidget != null) {
                    biomeWidget.visible = true;
                    biomeWidget.active = true;
                }
            }
        }
    }
}