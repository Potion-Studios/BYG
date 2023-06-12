package potionstudios.byg.common.world.placement;

import com.mojang.serialization.Codec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import potionstudios.byg.BYG;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

public class BYGPlacementModifierType {

    public static final RegistrationProvider<PlacementModifierType<?>> PROVIDER = RegistrationProvider.get(Registries.PLACEMENT_MODIFIER_TYPE, BYG.MOD_ID);

    public static final RegistryObject<PlacementModifierType<ChunkCoveringPlacement>> CHUNK_COVERING_PLACEMENT = register("chunk_covering_placement", ChunkCoveringPlacement.CODEC);
    public static final RegistryObject<PlacementModifierType<NearWaterPlacementFilter>> NEAR_WATER_FILTER = register("near_water_filter", NearWaterPlacementFilter.CODEC);
    public static final RegistryObject<PlacementModifierType<AboveHeightmapFilter>> ABOVE_HEIGHTMAP_FILTER = register("above_heightmap_filter", AboveHeightmapFilter.CODEC);
    public static final RegistryObject<PlacementModifierType<IsBiomeTagFilter>> IS_BIOME_TAG_FILTER = register("is_biome_tag_filter", IsBiomeTagFilter.CODEC);
    public static final RegistryObject<PlacementModifierType<IsDimensionFilter>> IS_DIMENSION_FILTER = register("is_dimension_filter", IsDimensionFilter.CODEC);

    private static <P extends PlacementModifier> RegistryObject<PlacementModifierType<P>> register(String id, Codec<P> codec) {
        return PROVIDER.register(id, () -> () -> codec);
    }

    public static void bootStrap() {
    }
}
