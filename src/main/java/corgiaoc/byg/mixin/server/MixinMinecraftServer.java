package corgiaoc.byg.mixin.server;


import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import corgiaoc.byg.BYG;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerResources;
import net.minecraft.server.level.progress.ChunkProgressListenerFactory;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.players.GameProfileCache;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.WorldData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.Proxy;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("deprecation")
@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {

    @Shadow
    @Final
    protected RegistryAccess.RegistryHolder registryHolder;

    @Inject(at = @At("RETURN"), method = "<init>")
    private void addBYGFeatures(Thread thread, RegistryAccess.RegistryHolder impl, LevelStorageSource.LevelStorageAccess session, WorldData saveProperties, PackRepository resourcePackManager, Proxy proxy, DataFixer dataFixer, ServerResources serverResourceManager, MinecraftSessionService minecraftSessionService, GameProfileRepository gameProfileRepository, GameProfileCache userCache, ChunkProgressListenerFactory worldGenerationProgressListenerFactory, CallbackInfo ci) {
        Optional<WritableRegistry<Biome>> biomeMutableRegistry = this.registryHolder.registry(Registry.BIOME_REGISTRY);
        if (biomeMutableRegistry.isPresent()) {
            for (Map.Entry<ResourceKey<Biome>, Biome> biomeEntry : biomeMutableRegistry.get().entrySet()) {
                BYGBiomes.addBYGFeaturesToBiomes(biomeEntry.getValue(), biomeEntry.getKey());
            }
            BYG.biomeRegistryAccess = biomeMutableRegistry.get();
        }
    }
}
