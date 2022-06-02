package potionstudios.byg.client.gui.biomepedia.screen;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import org.apache.commons.lang3.mutable.MutableInt;
import potionstudios.byg.client.gui.biomepedia.widget.ScrollableText;
import potionstudios.byg.common.world.LevelBiomeTracker;

import java.util.Comparator;
import java.util.Map;

public class BiomeAboutScreen2 extends AbstractBiomepediaScreen {
    private final ResourceKey<Biome> biomeKey;
    private final Screen parent;
    private final Component mobSpawns;
    private final Component biomeTags;

    protected int toolTipMaxWidth;

    protected BiomeAboutScreen2(ResourceKey<Biome> biomeKey, Screen parent) {
        super(new TranslatableComponent("biome." + biomeKey.location().getNamespace() + "." + biomeKey.location().getPath()));
        this.biomeKey = biomeKey;
        this.parent = parent;
        MutableComponent mobSpawnsText = new TranslatableComponent("biomepedia.biomeabout.mobspawns").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD);
        LevelBiomeTracker levelBiomeTracker = LevelBiomeTracker.client_instance;

        Map<ResourceKey<Biome>, ObjectOpenHashSet<ResourceKey<EntityType<?>>>> biomeMobs = levelBiomeTracker.getBiomeMobs();
        if (biomeMobs.containsKey(biomeKey)) {
            biomeMobs.get(biomeKey).stream().sorted(Comparator.comparing(key -> key.location().toString())).forEach(entityTypeResourceKey -> {
                mobSpawnsText.append("\n").append(Registry.ENTITY_TYPE.getOrThrow(entityTypeResourceKey).getDescription());
            });
        } else {
            mobSpawnsText.append("\n").append(new TranslatableComponent("biomepedia.biomeabout.mobspawns.none"));
        }
        this.mobSpawns = mobSpawnsText;

        MutableComponent biomeTagsText = new TranslatableComponent("biomepedia.biomeabout.biometags").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD);
        MutableInt count = new MutableInt(0);
        Registry<Biome> biomeRegistry = Minecraft.getInstance().level.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
        biomeRegistry.getHolder(biomeKey).orElseThrow().tags()
                .sorted(Comparator.comparing(biomeTagKey -> biomeTagKey.location().toString()))
                .forEach(biomeTagKey -> biomeTagsText.append(String.format("\n%s. ", count.incrementAndGet())).append(new TextComponent(biomeTagKey.location().toString())));

        this.biomeTags = biomeTagsText;
    }

    @Override
    protected void init() {
        super.init();
        int mobSpawnsTextTop = this.bottomPos + 15;
        int size = 80;
        int mobSpawnsTextBottom = mobSpawnsTextTop + size;
        this.toolTipMaxWidth = (IMAGE_WIDTH / 2) - 22;

        this.addRenderableWidget(new PageButton(pageBackButtonX, pageButtonY, false, button -> {
            this.minecraft.setScreen(new BiomeAboutScreen(this.biomeKey, this.parent));
        }, true));

        ScrollableText mobSpawns = new ScrollableText(this.mobSpawns, this.toolTipMaxWidth, mobSpawnsTextTop, mobSpawnsTextTop, mobSpawnsTextBottom);
        mobSpawns.setLeftPos(startXLeftPage);
        this.addRenderableWidget(mobSpawns);

        int distanceBetween = 10;
        int biomeTagsTop = mobSpawnsTextBottom + distanceBetween;
        int biomeTagsBottom = biomeTagsTop + size;
        ScrollableText biomeTags = new ScrollableText(this.biomeTags, mobSpawns.getRowWidth(), biomeTagsTop, biomeTagsTop, biomeTagsBottom);
        biomeTags.setLeftPos(startXLeftPage);
        if (this.minecraft.options.advancedItemTooltips) {
            this.addRenderableWidget(biomeTags);
        }

//        int distanceBetween = 10;
//        int climateTextTop = mobSpawnsTextBottom + distanceBetween;
//        int climateTextBottom = climateTextTop + size;
//        ScrollableText climateInfo = new ScrollableText(this.climateText, mobSpawns.getRowWidth(), climateTextTop, climateTextTop, climateTextBottom);
//        climateInfo.setLeftPos(startXLeftPage);
//        this.addRenderableWidget(climateInfo);
//
//
//        int biomeTagsTop = climateTextBottom + distanceBetween;
//        int biomeTagsBottom = biomeTagsTop + size;
//        ScrollableText biomeTags = new ScrollableText(this.biomeTags, mobSpawns.getRowWidth(), biomeTagsTop, biomeTagsTop, biomeTagsBottom);
//        biomeTags.setLeftPos(startXLeftPage);
//        this.addRenderableWidget(biomeTags);

    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }
}
