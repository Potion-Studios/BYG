package potionstudios.byg.common.world.placement;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import potionstudios.byg.BYG;

public class BYGPlacementModifierType {

    public static final PlacementModifierType<ChunkCoveringPlacement> CHUNK_COVERING_PLACEMENT = register("chunk_covering_placement", ChunkCoveringPlacement.CODEC);

    private static <P extends PlacementModifier> PlacementModifierType<P> register(String id, Codec<P> codec) {
        return Registry.register(Registry.PLACEMENT_MODIFIERS, BYG.createLocation(id), () -> {
            return codec;
        });
    }

}
