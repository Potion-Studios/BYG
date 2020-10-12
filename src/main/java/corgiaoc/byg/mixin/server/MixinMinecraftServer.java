package corgiaoc.byg.mixin.server;


import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import net.minecraft.resources.DataPackRegistries;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.chunk.listener.IChunkStatusListenerFactory;
import net.minecraft.world.storage.IServerConfiguration;
import net.minecraft.world.storage.SaveFormat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {

    @Shadow
    @Final
    protected DynamicRegistries.Impl field_240767_f_;

    @Inject(at = @At("RETURN"), method = "<init>(Ljava/lang/Thread;Lnet/minecraft/util/registry/DynamicRegistries$Impl;Lnet/minecraft/world/storage/SaveFormat$LevelSave;Lnet/minecraft/world/storage/IServerConfiguration;Lnet/minecraft/resources/ResourcePackList;Ljava/net/Proxy;Lcom/mojang/datafixers/DataFixer;Lnet/minecraft/resources/DataPackRegistries;Lcom/mojang/authlib/minecraft/MinecraftSessionService;Lcom/mojang/authlib/GameProfileRepository;Lnet/minecraft/server/management/PlayerProfileCache;Lnet/minecraft/world/chunk/listener/IChunkStatusListenerFactory;)V", cancellable = true)
    private void implementDatapackBiomes(Thread thread, DynamicRegistries.Impl impl, SaveFormat.LevelSave session, IServerConfiguration saveProperties, ResourcePackList resourcePackManager, Proxy proxy, DataFixer dataFixer, DataPackRegistries serverResourceManager, MinecraftSessionService minecraftSessionService, GameProfileRepository gameProfileRepository, PlayerProfileCache userCache, IChunkStatusListenerFactory worldGenerationProgressListenerFactory, CallbackInfo ci) {
        //Avoid adding to the list with already spawning end biomes.
        List<Biome> endBiomeBlackList = new ArrayList<>();
        endBiomeBlackList.add(WorldGenRegistries.BIOME.getOrThrow(Biomes.END_BARRENS));
        endBiomeBlackList.add(WorldGenRegistries.BIOME.getOrThrow(Biomes.THE_END));
        endBiomeBlackList.add(WorldGenRegistries.BIOME.getOrThrow(Biomes.SMALL_END_ISLANDS));

        if (this.field_240767_f_.func_230521_a_(Registry.BIOME_KEY).isPresent()) {
            for (Biome biome : field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get()) {
                if (biome.getCategory() == Biome.Category.NETHER) {
                    ResourceLocation locationKey = field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get().getKey(biome);

                    if (locationKey != null) {
                        if (!BYGNetherBiomeProvider.NETHER_BIOMES.contains(biome) && !WorldGenRegistries.BIOME.containsKey(locationKey)) {
                            BYGNetherBiomeProvider.NETHER_BIOMES.add(biome);

                            RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, locationKey);
                            int id = field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get().getId(biome);
                            if (id > 0)
                                BiomeRegistry.idToKeyMap.put(id, key);
                        }
                    }
                }
                if (biome.getCategory().equals(Biome.Category.THEEND) && !endBiomeBlackList.contains(biome)) {
                    ResourceLocation locationKey = field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get().getKey(biome);

                    if (locationKey != null) {
                        if (!BYGEndBiomeProvider.END_BIOMES.contains(biome) && !WorldGenRegistries.BIOME.containsKey(locationKey)) {
                            BYGEndBiomeProvider.END_BIOMES.add(biome);
                            RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, locationKey);
                            int id = field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get().getId(biome);

                            if (id > 0)
                                BiomeRegistry.idToKeyMap.put(id, key);
                        }
                    }
                }
            }
        }
    }
}
