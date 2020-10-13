//package corgiaoc.byg.mixin.server;
//
//
//import net.minecraft.server.MinecraftServer;
//import net.minecraft.util.registry.DynamicRegistries;
//import net.minecraft.world.storage.IServerConfiguration;
//import net.minecraft.world.storage.SaveFormat;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//
//@Mixin(MinecraftServer.class)
//public class MixinMinecraftServer {
//
//    @Shadow
//    @Final
//    protected DynamicRegistries.Impl field_240767_f_;
//
//    @Inject(at = @At("RETURN"), method = "<init>(Ljava/lang/Thread;Lnet/minecraft/util/registry/DynamicRegistries$Impl;Lnet/minecraft/world/storage/SaveFormat$LevelSave;Lnet/minecraft/world/storage/IServerConfiguration;Lnet/minecraft/resources/ResourcePackList;Ljava/net/Proxy;Lcom/mojang/datafixers/DataFixer;Lnet/minecraft/resources/DataPackRegistries;Lcom/mojang/authlib/minecraft/MinecraftSessionService;Lcom/mojang/authlib/GameProfileRepository;Lnet/minecraft/server/management/PlayerProfileCache;Lnet/minecraft/world/chunk/listener/IChunkStatusListenerFactory;)V", cancellable = true)
//    private void implementDatapackBiomes(Thread thread, DynamicRegistries.Impl impl, SaveFormat.LevelSave session, IServerConfiguration saveProperties, ResourcePackList resourcePackManager, Proxy proxy, DataFixer dataFixer, DataPackRegistries serverResourceManager, MinecraftSessionService minecraftSessionService, GameProfileRepository gameProfileRepository, PlayerProfileCache userCache, IChunkStatusListenerFactory worldGenerationProgressListenerFactory, CallbackInfo ci) {
//        if(this.field_240767_f_.func_230521_a_(Registry.BIOME_KEY).isPresent()) {
//            for (Biome biome : field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get()) {
//                if (biome.getCategory() == Biome.Category.NETHER) {
//                    if (BYGNetherBiomeCatch.useAllNetherBiomes) {
//                        if (!BYGNetherBiomeProvider.NETHER_BIOMES.contains(biome))
//                            BYGNetherBiomeProvider.NETHER_BIOMES.add(biome);
//
//                        ResourceLocation locationKey = field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get().getKey(biome);
//                        if (locationKey != null) {
//                            RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, locationKey);
//                            int id = field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get().getId(biome);
//                            if (id > 0)
//                                BiomeRegistry.idToKeyMap.put(id, key);
//                        }
//                    }
//                    BYGNetherBiomeProvider.NETHER_BIOMES.removeIf(Objects::isNull);
//                }
//                else if (biome.getCategory() == Biome.Category.THEEND) {
//                    if (BYGEndBiomeCatch.useAllEndBiomes) {
//                        if (!BYGEndBiomeProvider.END_BIOMES.contains(biome))
//                            BYGEndBiomeProvider.END_BIOMES.add(biome);
//
//                        ResourceLocation locationKey = field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get().getKey(biome);
//                        if (locationKey != null) {
//                            RegistryKey<Biome> key = RegistryKey.getOrCreateKey(Registry.BIOME_KEY, locationKey);
//                            int id = field_240767_f_.func_230521_a_(Registry.BIOME_KEY).get().getId(biome);
//
//                            if (id > 0)
//                                BiomeRegistry.idToKeyMap.put(id, key);
//                        }
//                    }
//                }
//            }
//        }
//        BYGEndBiomeProvider.END_BIOMES.removeIf(Objects::isNull);
//    }
//}
