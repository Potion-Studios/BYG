package potionstudios.byg.mixin.common.world;

import it.unimi.dsi.fastutil.bytes.Byte2DoubleOpenHashMap;
import it.unimi.dsi.fastutil.bytes.Byte2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;

import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.progress.ChunkProgressListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.WritableLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.common.block.sapling.GrowingPatterns;
import potionstudios.byg.common.world.LevelBiomeTracker;
import potionstudios.byg.config.BiomepediaConfig;
import potionstudios.byg.config.ConfigVersionTracker;
import potionstudios.byg.network.packet.BiomepediaActivePacket;
import potionstudios.byg.network.packet.LevelBiomeTrackerPacket;
import potionstudios.byg.network.packet.SaplingPatternsPacket;
import potionstudios.byg.server.command.UpdateConfigsCommand;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.DuneCache;
import potionstudios.byg.util.ModPlatform;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

@Mixin(ServerLevel.class)
public abstract class MixinServerLevel extends Level implements DuneCache {
    private Path worldPath;

    private final Long2ObjectOpenHashMap<Byte2DoubleOpenHashMap> duneDensityCache = new Long2ObjectOpenHashMap<>();
    private final Long2ObjectOpenHashMap<Byte2ObjectOpenHashMap<ResourceKey<Biome>>> duneBiomeSearchCache = new Long2ObjectOpenHashMap<>();
    @Nullable
    private LevelBiomeTracker bygLevelBiomeTracker = null;

    protected MixinServerLevel(WritableLevelData $$0, ResourceKey<Level> $$1, Holder<DimensionType> $$2, Supplier<ProfilerFiller> $$3, boolean $$4, boolean $$5, long $$6, int $$7) {
        super($$0, $$1, $$2, $$3, $$4, $$5, $$6, $$7);
    }


    @Inject(method = "<init>", at = @At("RETURN"))
    private void getWorldFolder(MinecraftServer $$0, Executor $$1, LevelStorageSource.LevelStorageAccess storageAccess, ServerLevelData $$3, ResourceKey<Level> levelResourceKey, LevelStem $$5, ChunkProgressListener $$6, boolean $$7, long $$8, List $$9, boolean $$10, CallbackInfo ci) {
        this.worldPath = storageAccess.getDimensionPath(levelResourceKey);
    }

    @Shadow
    @Nonnull
    public abstract MinecraftServer getServer();

    @Inject(method = "addPlayer", at = @At("HEAD"))
    private void warnExperimentalBYG(ServerPlayer serverPlayer, CallbackInfo ci) {
        ModPlatform.INSTANCE.sendToClient(serverPlayer, new SaplingPatternsPacket(GrowingPatterns.getConfig()));
        ModPlatform.INSTANCE.sendToClient(serverPlayer, new BiomepediaActivePacket(BiomepediaConfig.getConfig().biomepediaEnabled()));
        if (this.bygLevelBiomeTracker == null) {
            this.bygLevelBiomeTracker = LevelBiomeTracker.fromServer(this.getServer());
        }
        ModPlatform.INSTANCE.sendToClient(serverPlayer, new LevelBiomeTrackerPacket(this.bygLevelBiomeTracker));
        if (ConfigVersionTracker.getConfig().configVersion() != BYGConstants.CONFIG_VERSION) {
            if (getServer().isSingleplayerOwner(serverPlayer.getGameProfile())) {
                serverPlayer.displayClientMessage(Component.translatable("byg.command.updateconfig.outdatedconfigs", UpdateConfigsCommand.UPDATE_COMPONENT, UpdateConfigsCommand.DISMISS_UPDATE_COMPONENT), false);
            } else {
                if (getServer().isDedicatedServer()) {
                    serverPlayer.displayClientMessage(Component.translatable("byg.command.updateconfig.notifyserverowner.dedicated", Component.literal(UpdateConfigsCommand.UPDATE_COMMAND).withStyle(ChatFormatting.BLUE), Component.literal(UpdateConfigsCommand.DISMISS_COMMAND).withStyle(ChatFormatting.BLUE)), false);
                }
                if (getServer().isSingleplayer()) {
                    serverPlayer.displayClientMessage(Component.translatable("byg.command.updateconfig.notifyserverowner.singleplayer", Component.literal(UpdateConfigsCommand.UPDATE_COMMAND).withStyle(ChatFormatting.BLUE), Component.literal(UpdateConfigsCommand.DISMISS_COMMAND).withStyle(ChatFormatting.BLUE)), false);
                }
            }
        }
        if (this.getServer().isSingleplayer()) {
            if (BYGConstants.WARN_EXPERIMENTAL) {
                final Path marker = this.worldPath.resolve("EXPERIMENTAL_WARNING_MARKER_" + BYGConstants.EXPERIMENTAL_WARNING_VERSION + ".txt");
                if (BYGUtil.createMarkerFile(marker, "This file exists as a marker to warn the user of experimental settings. Once this file generates, the experimental warning will no longer show in the chat in this world!")) {
                    serverPlayer.displayClientMessage(Component.translatable("byg.experimental.warning").withStyle(ChatFormatting.YELLOW), false);
                }
            }
        }
    }

    @Override
    public Long2ObjectOpenHashMap<Byte2DoubleOpenHashMap> getDensityAt() {
        return duneDensityCache;
    }

    @Override
    public Long2ObjectOpenHashMap<Byte2ObjectOpenHashMap<ResourceKey<Biome>>> getBiomeAt() {
        return duneBiomeSearchCache;
    }
}