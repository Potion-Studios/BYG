package potionstudios.byg.client.gui.biomepedia.screen;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.PageButton;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.biome.Biome;
import org.apache.commons.lang3.mutable.MutableInt;
import potionstudios.byg.client.gui.biomepedia.widget.ScrollableText;
import potionstudios.byg.common.world.LevelBiomeTracker;
import potionstudios.byg.mixin.access.BiomeAccess;

import java.util.Comparator;
import java.util.Map;

public class BiomeAboutScreen2 extends AbstractBiomepediaScreen {
    private final ResourceKey<Biome> biomeKey;
    private final Screen parent;
    private final Component mobSpawns;
    private final Component biomeTags;
    private final Component colorSettingsText;

    protected int toolTipMaxWidth;

    protected BiomeAboutScreen2(ResourceKey<Biome> biomeKey, Screen parent) {
        super(Component.translatable("biome." + biomeKey.location().getNamespace() + "." + biomeKey.location().getPath()));
        this.biomeKey = biomeKey;
        this.parent = parent;
        MutableComponent mobSpawnsText = Component.literal("").append(Component.translatable("biomepedia.biomeabout.mobspawns").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD));
        LevelBiomeTracker levelBiomeTracker = LevelBiomeTracker.client_instance;

        Map<ResourceKey<Biome>, ObjectOpenHashSet<ResourceKey<EntityType<?>>>> biomeMobs = levelBiomeTracker.getBiomeMobs();
        if (biomeMobs.containsKey(biomeKey)) {
            biomeMobs.get(biomeKey).stream().sorted(Comparator.comparing(key -> key.location().toString())).forEach(entityTypeResourceKey -> {
                mobSpawnsText.append("\n").append(Registry.ENTITY_TYPE.getOrThrow(entityTypeResourceKey).getDescription());
            });
        } else {
            mobSpawnsText.append("\n").append(Component.translatable("biomepedia.biomeabout.mobspawns.none"));
        }
        this.mobSpawns = mobSpawnsText;

        MutableComponent biomeTagsText = Component.literal("").append(Component.translatable("biomepedia.biomeabout.biometags").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD));
        MutableInt count = new MutableInt(0);
        Registry<Biome> biomeRegistry = Minecraft.getInstance().level.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
        biomeRegistry.getHolder(biomeKey).orElseThrow().tags()
                .sorted(Comparator.comparing(biomeTagKey -> biomeTagKey.location().toString()))
                .forEach(biomeTagKey -> biomeTagsText.append(String.format("\n%s. ", count.incrementAndGet())).append(Component.literal(biomeTagKey.location().toString()).withStyle(Style.EMPTY)));

        MutableComponent climateText = Component.literal("").append(Component.translatable("biomepedia.biomeabout.color").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BOLD));
        Biome biome = biomeRegistry.get(biomeKey);

        int grassColor = biome.getSpecialEffects().getGrassColorOverride().orElseGet(() -> ((BiomeAccess) (Object) biome).byg_invokeGetGrassColorFromTexture());
        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.color.grass", Integer.toHexString(grassColor)).withStyle(Style.EMPTY.withColor(grassColor)));
        int foliageColor = biome.getFoliageColor();
        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.color.foliage", Integer.toHexString(foliageColor)).withStyle(Style.EMPTY.withColor(foliageColor)));
        int fogColor = biome.getFogColor();
        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.color.fog", Integer.toHexString(fogColor)).withStyle(Style.EMPTY.withColor(fogColor)));
        int skyColor = biome.getSkyColor();
        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.color.sky", Integer.toHexString(skyColor)).withStyle(Style.EMPTY.withColor(skyColor)));
        int waterColor = biome.getWaterColor();
        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.color.water", Integer.toHexString(waterColor)).withStyle(Style.EMPTY.withColor(waterColor)));
        int waterFogColor = biome.getWaterFogColor();
        climateText.append("\n").append(Component.translatable("biomepedia.biomeabout.color.waterfog", Integer.toHexString(waterFogColor)).withStyle(Style.EMPTY.withColor(waterFogColor)));
        this.colorSettingsText = climateText;


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
        int colorSettingsTop = mobSpawnsTextBottom + distanceBetween;
        int colorSettingsBottom = colorSettingsTop + size;
        ScrollableText colorSettings = new ScrollableText(this.colorSettingsText, mobSpawns.getRowWidth(), colorSettingsTop, colorSettingsTop, colorSettingsBottom);
        colorSettings.setLeftPos(startXLeftPage);
        this.addRenderableWidget(colorSettings);


        ScrollableText biomeTags = new ScrollableText(this.biomeTags, mobSpawns.getRowWidth(), colorSettingsTop, mobSpawnsTextTop, mobSpawnsTextBottom);
        biomeTags.setLeftPos(startXRightPage);
        if (this.minecraft.options.advancedItemTooltips) {
            this.addRenderableWidget(biomeTags);
        }



    }

    @Override
    public void onClose() {
        this.minecraft.setScreen(this.parent);
    }
}
