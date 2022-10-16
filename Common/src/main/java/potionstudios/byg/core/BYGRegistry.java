package potionstudios.byg.core;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerTrades;
import potionstudios.byg.BYG;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.blockentity.BYGBlockEntities;
import potionstudios.byg.common.container.BYGMenuTypes;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.entity.ai.village.poi.BYGPOITypeTags;
import potionstudios.byg.common.entity.ai.village.poi.BYGPoiTypes;
import potionstudios.byg.common.entity.npc.BYGVillagerProfessions;
import potionstudios.byg.common.entity.npc.VillagerTradeRegistry;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.sound.BYGSounds;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.BYGPlacedFeatures;
import potionstudios.byg.common.world.feature.features.BYGGlobalFeatureFeatures;
import potionstudios.byg.common.world.feature.features.BYGGlobalFeatures;
import potionstudios.byg.common.world.feature.features.BYGStructurePlacedFeatures;
import potionstudios.byg.common.world.feature.features.end.BYGEndFeatures;
import potionstudios.byg.common.world.feature.features.end.BYGEndVegetationFeatures;
import potionstudios.byg.common.world.feature.features.nether.BYGNetherFeatures;
import potionstudios.byg.common.world.feature.features.nether.BYGNetherVegetationFeatures;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldFeatures;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldTreeFeatures;
import potionstudios.byg.common.world.feature.features.overworld.BYGOverworldVegetationFeatures;
import potionstudios.byg.common.world.feature.gen.overworld.trees.decorators.BYGTreeDecoratorTypes;
import potionstudios.byg.common.world.feature.placement.BYGVillagePlacements;
import potionstudios.byg.common.world.feature.stateproviders.BYGStateProviders;
import potionstudios.byg.common.world.structure.BYGStructureTags;
import potionstudios.byg.common.world.structure.BYGStructureTypes;
import potionstudios.byg.mixin.access.RegistryAccess;
import potionstudios.byg.util.blendingfunction.BlendingFunction;

public class BYGRegistry {
    public static final ResourceKey<Registry<Codec<? extends BlendingFunction>>> BLENDING_FUNCTION_RESOURCE_KEY = ResourceKey.createRegistryKey(BYG.createLocation("blending_function"));

    public static final Registry<Codec<? extends BlendingFunction>> BLENDING_FUNCTION = RegistryAccess.byg_invokeRegisterSimple(BLENDING_FUNCTION_RESOURCE_KEY, Lifecycle.stable(), registry -> BlendingFunction.CODEC);

    public static final ResourceKey<Registry<Codec<? extends VillagerTrades.ItemListing>>> VILLAGER_TRADES_ITEM_LISTING_RESOURCE_KEY = ResourceKey.createRegistryKey(BYG.createLocation("villager_trades_item_listing"));

    public static final Registry<Codec<? extends VillagerTrades.ItemListing>> VILLAGER_TRADES_ITEM_LISTING = RegistryAccess.byg_invokeRegisterSimple(VILLAGER_TRADES_ITEM_LISTING_RESOURCE_KEY, Lifecycle.stable(), registry -> VillagerTradeRegistry.ITEM_LISTING_CODEC);

    public static void loadClasses() {
        BYGBlocks.loadClass();
        BYGItems.loadClass();
        BYGFeatures.loadClass();
        BYGMenuTypes.loadClass();
        BYGEntities.loadClass();
        BYGBlockEntities.loadClass();
        BYGBiomes.loadClass();
        BYGParticleTypes.loadClass();
        BYGVillagerProfessions.loadClass();
        BYGPoiTypes.loadClass();
        BYGSounds.loadClass();
        BYGStateProviders.loadClass();
        BYGStructureTypes.loadClass();
        BYGTreeDecoratorTypes.loadClass();
        BYGOverworldTreeFeatures.loadClass();
        BYGOverworldVegetationFeatures.loadClass();
        BYGOverworldFeatures.loadClass();
        BYGGlobalFeatureFeatures.loadClass();
        BYGGlobalFeatures.loadClass();
        BYGEndVegetationFeatures.loadClass();
        BYGEndFeatures.loadClass();
        BYGNetherVegetationFeatures.loadClass();
        BYGNetherFeatures.loadClass();
        BYGPlacedFeatures.loadClass();
        BYGStructurePlacedFeatures.loadClass();
        BYGVillagePlacements.loadClass();
        BYGPOITypeTags.loadClass();
        BYGStructureTags.loadClass();
    }
}
