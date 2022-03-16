package potionstudios.byg.mixin.common.world;

import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.WritableLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.sapling.SaplingPatterns;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.mixin.access.BiomeSourceAccess;
import potionstudios.byg.network.packet.SaplingPatternsPacket;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.ModLoaderContext;

import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

@Mixin(ServerLevel.class)
public abstract class MixinServerLevel extends Level {
    private Path worldPath;

    protected MixinServerLevel(WritableLevelData $$0, ResourceKey<Level> $$1, Holder<DimensionType> $$2, Supplier<ProfilerFiller> $$3, boolean $$4, boolean $$5, long $$6) {
        super($$0, $$1, $$2, $$3, $$4, $$5, $$6);
    }


    @Inject(method = "<init>", at = @At("RETURN"))
    private void getWorldFolder(MinecraftServer $$0, Executor $$1, LevelStorageSource.LevelStorageAccess storageAccess, ServerLevelData $$3, ResourceKey<Level> levelResourceKey, Holder $$5, ChunkProgressListener $$6, ChunkGenerator $$7, boolean $$8, long $$9, List $$10, boolean $$11, CallbackInfo ci) {
        this.worldPath = storageAccess.getDimensionPath(levelResourceKey);
    }

    @Shadow
    @Nonnull
    public abstract MinecraftServer getServer();

    @Shadow
    @Final
    private ServerChunkCache chunkSource;

    @Inject(method = "addPlayer", at = @At("HEAD"))
    private void warnExperimentalBYG(ServerPlayer serverPlayer, CallbackInfo ci) {
        ModLoaderContext.getInstance().sendToClient(serverPlayer, new SaplingPatternsPacket(SaplingPatterns.getConfig()));
        if (this.getServer().isSingleplayer()) {
            if (BYG.WARN_EXPERIMENTAL) {
                final Path marker = this.worldPath.resolve("EXPERIMENTAL_WARNING_MARKER_" + BYG.EXPERIMENTAL_WARNING_VERSION + ".txt");
                if (BYGUtil.createMarkerFile(marker, "This file exists as a marker to warn the user of experimental settings. Once this file generates, the experimental warning will no longer show in the chat in this world!")) {
                    serverPlayer.displayClientMessage(new TranslatableComponent("byg.experimental.warning").withStyle(ChatFormatting.YELLOW), false);
                }
            }
            EndBiomesConfig config = EndBiomesConfig.getConfig();
            ResourceLocation biomeSourceKey = Registry.BIOME_SOURCE.getKey(((BiomeSourceAccess) this.chunkSource.getGenerator().getBiomeSource()).byg_invokeCodec());
            if (config.warnBYGEndBiomeSourceNotUsedInNewWorlds() && config.useBYGEndBiomeSourceInNewWorlds() && dimension() == Level.END) {
                if (!biomeSourceKey.equals(BYGEndBiomeSource.LOCATION)) {
                    Path warningMarker = this.worldPath.resolve("END_BIOME_SOURCE_WARNING_MARKER.txt");
                    if (BYGUtil.createMarkerFile(warningMarker, "This file exists as a marker to warn the user that their end is not controlled by BYG. Once this file generates, the warning will no longer show in the chat in this world!")) {
                        String configPath = EndBiomesConfig.CONFIG_PATH.get().toString();

                        Component fileComponent = new TextComponent(configPath).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, configPath)).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));
                        Component urlComponent = new TranslatableComponent("byg.clickme").withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/AOCAWOL/BYG/wiki/Nether-&-End-Biomes-FAQ")).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));
                        serverPlayer.displayClientMessage(new TranslatableComponent("byg.end.not.used", fileComponent, urlComponent).withStyle(ChatFormatting.YELLOW), false);
                    }
                }
            }

            NetherBiomesConfig netherConfig = NetherBiomesConfig.getConfig();
            if (netherConfig.warnBYGNetherBiomeSourceNotUsedInNewWorlds() && netherConfig.useBYGNetherBiomeSourceInNewWorlds() && dimension() == Level.NETHER) {
                if (!biomeSourceKey.equals(BYGNetherBiomeSource.LOCATION)) {
                    Path warningMarker = this.worldPath.resolve("NETHER_BIOME_SOURCE_WARNING_MARKER.txt");
                    if (BYGUtil.createMarkerFile(warningMarker, "This file exists as a marker to warn the user that their nether is not controlled by BYG. Once this file generates, the warning will no longer show in the chat in this world!")) {
                        String configPath = NetherBiomesConfig.CONFIG_PATH.get().toString();

                        Path terrablenderConfigPath = ModLoaderContext.getInstance().configPath().resolve("terrablender.toml");
                        Component fileComponent = new TextComponent(configPath).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, configPath)).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));
                        Component urlComponent = new TranslatableComponent("byg.clickme").withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/AOCAWOL/BYG/wiki/Nether-&-End-Biomes-FAQ")).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));

                        Component terrablenderConfig = new TextComponent(terrablenderConfigPath.toString()).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, terrablenderConfigPath.toString())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));


                        serverPlayer.displayClientMessage(biomeSourceKey.equals(new ResourceLocation("terrablender", "multi_noise")) ? new TranslatableComponent("byg.nether.not.used.terrablender", fileComponent, terrablenderConfig, urlComponent) : new TranslatableComponent("byg.nether.not.used", fileComponent, urlComponent).withStyle(ChatFormatting.YELLOW), false);
                    }
                }
            }
        }
    }
}