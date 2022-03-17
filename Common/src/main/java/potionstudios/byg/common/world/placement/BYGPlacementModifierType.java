package potionstudios.byg.common.world.placement;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import potionstudios.byg.BYG;

public class BYGPlacementModifierType {

    public static final PlacementModifierType<ChunkCoveringPlacement> CHUNK_COVERING_PLACEMENT = register("chunk_covering_placement", ChunkCoveringPlacement.CODEC);
    public static final PlacementModifierType<NearWaterPlacementFilter> NEAR_WATER_FILTER = register("near_water_filter", NearWaterPlacementFilter.CODEC);
    public static final PlacementModifierType<AboveHeightmapFilter> ABOVE_HEIGHTMAP_FILTER = register("above_heightmap_filter", AboveHeightmapFilter.CODEC);
    public static final PlacementModifierType<IsBiomeTagFilter> IS_BIOME_TAG_FILTER = register("is_biome_tag_filter", IsBiomeTagFilter.CODEC);

    private static <P extends PlacementModifier> PlacementModifierType<P> register(String id, Codec<P> codec) {
        return Registry.register(Registry.PLACEMENT_MODIFIERS, BYG.createLocation(id), () -> {
            return codec;
        });
    }

    public static void bootStrap() {
    }

    static {
        BYG.LOGGER.info("BYG Placement Modifier Types class loaded.");
    }
}
