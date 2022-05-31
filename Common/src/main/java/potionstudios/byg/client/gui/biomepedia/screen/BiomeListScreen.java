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
import org.apache.commons.lang3.mutable.Mutable;
import org.apache.commons.lang3.mutable.MutableBoolean;
import org.apache.commons.lang3.mutable.MutableObject;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.biomepedia.widget.BiomeWidget;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.mixin.access.client.EditBoxAccess;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class BiomeListScreen extends AbstractBiomepediaScreen {
    private final Screen parent;

    private int pagePair;
    private ImageButton searchButton;
    private PageButton next;
    private PageButton back;
    private EditBox search;
    private int pagePairsCount;
    private final Mutable<String> lastSearchInput = new MutableObject<>("");
    private List<ResourceKey<Biome>> lastInput = new ArrayList<>();

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
        this.clearWidgets();
        Registry<Biome> biomeRegistry = Minecraft.getInstance().level.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
        List<ResourceKey<Biome>> resourceKeys = biomeRegistry.entrySet().stream().map(Map.Entry::getKey).filter(biomeResourceKey -> biomeResourceKey.location().getNamespace().equals(BYG.MOD_ID) && biomeResourceKey != BYGBiomes.WINDSWEPT_DUNES).sorted(Comparator.comparing(ResourceKey::location)).collect(Collectors.toList());

        if (this.widgets == null) {
            createMenu(resourceKeys, false);
            this.lastInput = resourceKeys;
        } else {
            createMenu(this.lastInput, false);
        }

        PageButton back = new PageButton(this.leftPos + 5, this.topPos - 10, false, button -> {
            if (pagePairsCount == 0) {
                return;
            }
            unload(pagePair);
            this.pagePair = pagePair == 0 ? pagePairsCount - 1 : (pagePair - 1) % pagePairsCount;
            load(this.pagePair);
        }, true);

        if (this.back != null) {
            back.active = this.back.active;
            back.visible = this.back.visible;
        }

        this.back = back;
        this.addRenderableWidget(this.back);
        this.back.x = this.leftPos + 15;
        this.back.y = this.topPos - this.back.getHeight() - 13;

        PageButton next = new PageButton(this.rightPos - 5, this.topPos - 10, true, button -> {
            if (pagePairsCount == 0) {
                return;
            }
            unload(pagePair);
            this.pagePair = (pagePair + 1) % pagePairsCount;
            load(this.pagePair);
        }, true);
        if (this.next != null) {
            next.active = this.next.active;
            next.visible = this.next.visible;
        }

        this.next = next;
        this.addRenderableWidget(this.next);
        this.next.x = this.rightPos - this.back.getWidth() - 22;
        this.next.y = this.topPos - this.back.getHeight() - 13;
        load(pagePair);

        MutableBoolean snapToFront = new MutableBoolean(false);
        EditBox search = new EditBox(this.minecraft.font, this.leftPos + 15, this.bottomPos + this.IMAGE_HEIGHT - 22, 150, 15, new TextComponent(""));
        if (this.search != null) {
            search.active = this.search.active;
            search.visible = this.search.visible;
            search.setValue(this.search.getValue());
            search.setTextColor(((EditBoxAccess) this.search).byg_getTextColor());
            snapToFront.setValue(true);
        } else {
            search.active = false;
            search.visible = false;
        }

        this.search = search;


        this.search.setResponder(s -> updateForSearchValue(resourceKeys, s, snapToFront.booleanValue()));

        this.searchButton = new ImageButton(
                this.leftPos + 15, (this.bottomPos + this.IMAGE_HEIGHT) - 5, 20, 18, 0, 220, 18,
                new ResourceLocation("byg", "textures/gui/biomepedia.png"),
                256, 256,
                (button) -> {
                    this.search.visible = !this.search.visible;
                    this.search.active = !this.search.active;
                    if (this.search.visible) {
                        this.search.setFocus(true);
                        this.back.visible = false;
                        this.back.active = false;
                    } else {
                        this.back.visible = true;
                        this.back.active = true;
                    }
                });
        this.addRenderableWidget(this.searchButton);
        this.addRenderableWidget(this.search);

    }

    private void updateForSearchValue(List<ResourceKey<Biome>> resourceKeys, String s, boolean snapToFront) {
        if (s.equals(lastSearchInput.getValue())) {
            return;
        }
        lastSearchInput.setValue(s);
        if (s.isBlank()) {
            this.search.setTextColor(FastColor.ARGB32.color(255, 255, 255, 255));
            createMenu(resourceKeys, snapToFront);
            return;
        }

        List<ResourceKey<Biome>> searchResult = resourceKeys.stream().filter(biomeResourceKey -> biomeResourceKey.location().getNamespace().equals(BYG.MOD_ID)).sorted(Comparator.comparing(ResourceKey::location)).filter(biome -> {
            TranslatableComponent translatedComponent = new TranslatableComponent("biome." + biome.location().getNamespace() + "." + biome.location().getPath());
            return translatedComponent.getString().toLowerCase().contains(s.toLowerCase());
        }).toList();
        this.lastInput = searchResult;

        if (searchResult.isEmpty()) {
            this.search.setTextColor(FastColor.ARGB32.color(255, 255, 0, 0));
        } else {
            this.search.setTextColor(FastColor.ARGB32.color(255, 255, 255, 255));
        }

        createMenu(searchResult, snapToFront);
    }

    private void createMenu(List<ResourceKey<Biome>> biomes, boolean snapToFront) {
        pagePairsCount = (int) Math.ceil((double) biomes.size() / 4);
        int registryIdx = 0;
        int offsetFromEdge = 14;
        if (widgets != null) {
            forEachWidget(biomeWidget -> this.children().remove(biomeWidget));
        }

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
                    ResourceKey<Biome> biome = biomes.get(registryIdx);
                    page[yPos] = this.addWidget(new BiomeWidget(biome, xOffset + startX, yOffset, (int) (IMAGE_WIDTH / 2.5F), (int) (IMAGE_HEIGHT / 2.7), button -> {
                        this.minecraft.setScreen(new BiomeAboutScreen(biome, this));
                    }));
                    registryIdx++;
                    yOffset += (IMAGE_HEIGHT / 2.7) + 10;
                }
            }
        }
        if (this.widgets.length - 1 < this.pagePair || snapToFront) {
            this.pagePair = 0;
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
            load(pagePair);
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