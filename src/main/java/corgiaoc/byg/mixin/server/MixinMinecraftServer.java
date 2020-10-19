package corgiaoc.byg.mixin.server;


import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import corgiaoc.byg.common.world.dimension.end.BYGEndBiomeProvider;
import corgiaoc.byg.common.world.dimension.nether.BYGNetherBiomeProvider;
import corgiaoc.byg.config.BYGWorldConfig;
import corgiaoc.byg.core.world.BYGBiomes;
import net.minecraft.resources.DataPackRegistries;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.MutableRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.listener.IChunkStatusListenerFactory;
import net.minecraft.world.storage.IServerConfiguration;
import net.minecraft.world.storage.SaveFormat;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.Proxy;
import java.util.*;

@SuppressWarnings("deprecation")
@Mixin(MinecraftServer.class)
public class MixinMinecraftServer {

    @Shadow
    @Final
    protected DynamicRegistries.Impl field_240767_f_;

    private static final List<String> END_BIOME_IDS = Arrays.asList(BYGWorldConfig.BLACKLIST_END.get().trim().replace(" ", "").split(","));
    private static final List<String> END_VOID_BIOME_IDS = Arrays.asList(BYGWorldConfig.VOID_BIOMES.get().trim().replace(" ", "").split(","));
    private static final List<String> NETHER_BIOME_IDS = Arrays.asList(BYGWorldConfig.BLACKLIST_NETHER.get().trim().replace(" ", "").split(","));


    @Inject(at = @At("RETURN"), method = "<init>(Ljava/lang/Thread;Lnet/minecraft/util/registry/DynamicRegistries$Impl;Lnet/minecraft/world/storage/SaveFormat$LevelSave;Lnet/minecraft/world/storage/IServerConfiguration;Lnet/minecraft/resources/ResourcePackList;Ljava/net/Proxy;Lcom/mojang/datafixers/DataFixer;Lnet/minecraft/resources/DataPackRegistries;Lcom/mojang/authlib/minecraft/MinecraftSessionService;Lcom/mojang/authlib/GameProfileRepository;Lnet/minecraft/server/management/PlayerProfileCache;Lnet/minecraft/world/chunk/listener/IChunkStatusListenerFactory;)V", cancellable = true)
    private void utilizeDatapackBiomes(Thread thread, DynamicRegistries.Impl impl, SaveFormat.LevelSave session, IServerConfiguration saveProperties, ResourcePackList resourcePackManager, Proxy proxy, DataFixer dataFixer, DataPackRegistries serverResourceManager, MinecraftSessionService minecraftSessionService, GameProfileRepository gameProfileRepository, PlayerProfileCache userCache, IChunkStatusListenerFactory worldGenerationProgressListenerFactory, CallbackInfo ci) {
        final List<Biome> NETHER_BIOMES = new ArrayList<>();
        final List<Biome> END_BIOMES = new ArrayList<>();
        final List<Biome> END_VOID_BIOMES = new ArrayList<>();

        Optional<MutableRegistry<Biome>> biomeMutableRegistry = this.field_240767_f_.func_230521_a_(Registry.BIOME_KEY);
        if (biomeMutableRegistry.isPresent()) {
            for (Biome biome : biomeMutableRegistry.get()) {
                if (biome.getCategory() == Biome.Category.NETHER) {
                    ResourceLocation locationKey = biomeMutableRegistry.get().getKey(biome);

                    if (locationKey != null) {
                        if (BYGWorldConfig.IS_BLACKLIST_NETHER.get()) {
                            //Avoid duping entries
                            if (!NETHER_BIOMES.contains(biome) && !NETHER_BIOME_IDS.contains(locationKey.toString())) {
                                NETHER_BIOMES.add(biome);
                            }
                        } else {
                            for (String id : NETHER_BIOME_IDS) {
                                if (id.equals(locationKey.toString())) {
                                    NETHER_BIOMES.add(biome);
                                }
                            }
                        }
                        //if a datapack is using the same namespace as another mod, this is bad....like really bad.
                        if (!ModList.get().isLoaded(locationKey.getNamespace()) && !NETHER_BIOMES.contains(biome)) {
                            NETHER_BIOMES.add(biome);
                        }
                    }
                }

                if (biome.getCategory() == Biome.Category.THEEND) {
                    ResourceLocation locationKey = biomeMutableRegistry.get().getKey(biome);
                    if (locationKey != null) {
                        if (BYGWorldConfig.IS_BLACKLIST_END.get()) {
                            //Avoid duping entries
                            if (!END_BIOMES.contains(biome) && !END_BIOME_IDS.contains(locationKey.toString())) {
                                END_BIOMES.add(biome);
                            }
                        } else  {
                            for (String id : END_BIOME_IDS) {
                                if (id.equals(locationKey.toString())) {
                                    END_BIOMES.add(biome);
                                }
                            }
                        }
                        //if a datapack is using the same namespace as another mod, this is bad...like really bad.
                        if (!ModList.get().isLoaded(locationKey.getNamespace())) {
                            END_BIOMES.add(biome);
                        }

                        for (String id : END_VOID_BIOME_IDS) {
                            if (id.equals(locationKey.toString()) && !END_VOID_BIOMES.contains(biome)) {
                                END_VOID_BIOMES.add(biome);
                            }
                        }
                    }
                }
                BYGBiomes.addBYGFeaturesToBiomes(biome);
            }
        }
        END_BIOMES.removeIf(Objects::isNull);
        END_VOID_BIOMES.removeIf(Objects::isNull);
        NETHER_BIOMES.removeIf(Objects::isNull);

        BYGEndBiomeProvider.END_BIOMES = END_BIOMES;
        BYGEndBiomeProvider.VOID_END_BIOMES = END_VOID_BIOMES;
        BYGNetherBiomeProvider.NETHER_BIOMES = NETHER_BIOMES;
    }
}
