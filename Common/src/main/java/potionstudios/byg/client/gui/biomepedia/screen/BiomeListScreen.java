package potionstudios.byg.client.gui.biomepedia.screen;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.FastColor;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.biomepedia.widget.BiomeWidget;
import potionstudios.byg.common.world.biome.BYGBiomes;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BiomeListScreen extends AbstractBiomepediaScreen {
    private final Screen parent;

    private int page;
    private ImageButton searchButton;
    private PageButton next;
    private PageButton back;
    private EditBox search;
    private int pagePairsCount;


    private BiomeWidget[][][] widgets;

    protected BiomeListScreen(Screen parent) {
        super(new TranslatableComponent(""));
        this.parent = parent;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.search != null) {
            this.search.tick();
        }
    }

    @Override
    protected void init() {
        super.init();
        Registry<Biome> biomeRegistry = Minecraft.getInstance().level.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
        List<ResourceKey<Biome>> resourceKeys = biomeRegistry.entrySet().stream().map(Map.Entry::getKey).filter(biomeResourceKey -> biomeResourceKey.location().getNamespace().equals(BYG.MOD_ID) && biomeResourceKey != BYGBiomes.WINDSWEPT_DUNES).sorted(Comparator.comparing(ResourceKey::location)).collect(Collectors.toList());

        createMenu(resourceKeys);

        this.back = new PageButton(this.leftPos + 5, this.topPos - 10, false, button -> {
            if (pagePairsCount == 0) {
                return;
            }
            unload(page);
            this.page = page == 0 ? pagePairsCount - 1 : (page - 1) % pagePairsCount;
            load(this.page);
        }, true);
        this.addRenderableWidget(back);
        back.x = this.leftPos + 15;
        back.y = this.topPos - back.getHeight() - 13;

        this.next = new PageButton(this.rightPos - 5, this.topPos - 10, true, button -> {
            if (pagePairsCount == 0) {
                return;
            }
            unload(page);
            this.page = (page + 1) % pagePairsCount;
            load(this.page);
        }, true);
        this.addRenderableWidget(next);
        next.x = this.rightPos - back.getWidth() - 22;
        next.y = this.topPos - back.getHeight() - 13;
        load(page);

        this.search = new EditBox(this.minecraft.font, this.leftPos + 15, this.bottomPos + this.IMAGE_HEIGHT - 22, 150, 15, new TextComponent(""));
        search.setResponder(s -> {
            if (s.isBlank()) {
                search.setTextColor(FastColor.ARGB32.color(255, 255, 255, 255));
                return;
            }

            List<ResourceKey<Biome>> searchResult = resourceKeys.stream().filter(biomeResourceKey -> biomeResourceKey.location().getNamespace().equals(BYG.MOD_ID)).sorted(Comparator.comparing(ResourceKey::location)).filter(biome -> {
                TranslatableComponent translatedComponent = new TranslatableComponent("biome." + biome.location().getNamespace() + "." + biome.location().getPath());
                return translatedComponent.getString().toLowerCase().contains(s.toLowerCase());
            }).toList();

            if (searchResult.isEmpty()) {
                search.setTextColor(FastColor.ARGB32.color(255, 255, 0, 0));
            } else {
                search.setTextColor(FastColor.ARGB32.color(255, 255, 255, 255));
            }

            createMenu(searchResult);
        });
        search.active = false;
        search.visible = false;
        this.searchButton = new ImageButton(
                this.leftPos + 15, (this.bottomPos + this.IMAGE_HEIGHT) - 5, 20, 18, 0, 220, 18,
                new ResourceLocation("byg", "textures/gui/biomepedia.png"),
                256, 256,
                (button) -> {
                    search.visible = !search.visible;
                    search.active = !search.active;
                    if (search.visible) {
                        search.setFocus(true);
                    }
                });
        this.addRenderableWidget(this.searchButton);
        this.addRenderableWidget(search);

    }

    private void createMenu(List<ResourceKey<Biome>> biomes) {
        pagePairsCount = (int) Math.ceil((double) biomes.size() / 4);
        int registryIdx = 0;
        int offsetFromEdge = 14;
        this.page = 0;

        widgets = new BiomeWidget[Math.max(pagePairsCount, 1)][2][2];
        int xOffset = this.leftPos + offsetFromEdge + 4;
        for (BiomeWidget[][] pagePairs : widgets) {
            for (int pageSide = 0; pageSide < pagePairs.length; pageSide++) {
                int startX = ((IMAGE_WIDTH / 2) - 8) * pageSide;
                int yOffset = this.bottomPos + offsetFromEdge;

                BiomeWidget[] page = pagePairs[pageSide];
                for (int yPos = 0; yPos < page.length; yPos++) {
                    if (registryIdx > biomes.size() - 1) {
                        break;
                    }
                    page[yPos] = new BiomeWidget(biomes.get(registryIdx), xOffset + startX, yOffset, (int) (this.IMAGE_WIDTH / 2.5F), (int) (this.IMAGE_HEIGHT / 2.7), button -> {

                    });
                    registryIdx++;
                    yOffset += (this.IMAGE_HEIGHT / 2.7) + 10;
                }
            }
        }

        if (back != null && next != null) {
            if (pagePairsCount > 1) {
                this.back.active = true;
                this.back.visible = true;
                this.next.active = true;
                this.next.visible = true;
            } else {
                this.back.active = false;
                this.back.visible = false;
                this.next.active = false;
                this.next.visible = false;
            }
            forEachWidget(biomeWidget -> {
                biomeWidget.visible = false;
                biomeWidget.active = false;
            });
            load(page);
        }
    }

    private void forEachWidget(Consumer<BiomeWidget> widget) {
        for (BiomeWidget[][] widgetsForPage : this.widgets) {
            for (BiomeWidget[] biomeWidgets : widgetsForPage) {
                for (BiomeWidget biomeWidget : biomeWidgets) {
                    if (biomeWidget != null) {
                        widget.accept(biomeWidget);
                    }
                }
            }
        }
    }


    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTick) {
        super.render(poseStack, mouseX, mouseY, partialTick);
        this.forEachWidget(biomeWidget -> biomeWidget.render(poseStack, mouseX, mouseY, partialTick));
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