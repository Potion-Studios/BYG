package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.world.BYGBiomes;
import corgiaoc.byg.core.world.BYGDecorators;
import corgiaoc.byg.core.world.BYGFeatures;
import corgiaoc.byg.core.world.BYGSurfaceBuilders;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BYG.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("deprecation")
public class RegistrationHelper {

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        BYG.LOGGER.debug("BYG: Registering blocks...");
        BYGBlocks.init();
        BYG.LOGGER.info("BYG: Blocks Registered!");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        BYG.LOGGER.debug("BYG: Registering items...");
        BYGItems.init();
        BYG.LOGGER.info("BYG: Items Registered!");
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityType<?>> event) {
        BYG.LOGGER.debug("BYG: Registering entities...");
        BYGEntities.init();
        BYG.LOGGER.info("BYG: Entities Registered!");
    }

    @SubscribeEvent
    public static void registerBiomes(RegistryEvent.Register<Biome> event) {
        BYG.LOGGER.debug("BYG: Registering biomes...");
        BYGBiomes.registerBYGBiomes();
        BYG.LOGGER.info("BYG: Biomes Registered!");
    }

    @SubscribeEvent
    public static void registerDecorators(RegistryEvent.Register<Placement<?>> event) {
        BYG.LOGGER.debug("BYG: Registering decorators...");
        BYGDecorators.init();
        BYG.LOGGER.info("BYG: Decorators registered!");
    }

    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event) {
        BYG.LOGGER.debug("BYG: Registering features...");
        BYGFeatures.init();
        BYG.LOGGER.info("BYG: Features Registered!");
    }

    @SubscribeEvent
    public static void registerSurfaceBuilders(RegistryEvent.Register<SurfaceBuilder<?>> event) {
        BYG.LOGGER.debug("BYG: Registering surface builders...");
        BYGSurfaceBuilders.init();
        BYG.LOGGER.info("BYG: Surface builders Registered!");
    }

    /********Registration Helper Methods********/

    public static <SBC extends ISurfaceBuilderConfig, SB extends SurfaceBuilder<SBC>> SB createSurfaceBuilder(String id, SB surfaceBuilder) {
        Registry.register(Registry.SURFACE_BUILDER, new ResourceLocation(BYG.MOD_ID, id), surfaceBuilder);
        return surfaceBuilder;
    }

    public static<SC extends ISurfaceBuilderConfig, CSB extends ConfiguredSurfaceBuilder<SC>> CSB createConfiguredSurfaceBuilder(String id, CSB configuredSurfaceBuilder) {
        Registry.register(WorldGenRegistries.CONFIGURED_SURFACE_BUILDER, new ResourceLocation(BYG.MOD_ID, id), configuredSurfaceBuilder);
        return configuredSurfaceBuilder;
    }

    public static <C extends IFeatureConfig, F extends Feature<C>> F createFeature(String id, F feature) {
        Registry.register(Registry.FEATURE, new ResourceLocation(BYG.MOD_ID, id), feature);
        return feature;
    }

    public static <FC extends IFeatureConfig, F extends Feature<FC>, CF extends ConfiguredFeature<FC, F>> CF createConfiguredFeature(String id, CF configuredFeature) {
        Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(BYG.MOD_ID, id), configuredFeature);
        return configuredFeature;
    }

    public static <DC extends IPlacementConfig, D extends Placement<DC>> D createDecorator(String id, D decorator) {
        Registry.register(Registry.DECORATOR, new ResourceLocation(BYG.MOD_ID, id), decorator);
        return decorator;
    }
}