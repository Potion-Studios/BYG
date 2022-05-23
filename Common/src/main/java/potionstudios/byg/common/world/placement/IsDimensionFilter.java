package potionstudios.byg.common.world.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

//TODO: Is this possible to do as a tag?!
public class IsDimensionFilter extends PlacementModifier {

    public static final Codec<IsDimensionFilter> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(ResourceKey.codec(Registry.DIMENSION_REGISTRY).listOf().fieldOf("valid_dimensions").forGetter(isBiomeTagFilter -> isBiomeTagFilter.validDimensions)
            ).apply(builder, IsDimensionFilter::new));

    private final List<ResourceKey<Level>> validDimensions;

    public IsDimensionFilter(List<ResourceKey<Level>> validDimensions) {
        this.validDimensions = validDimensions;
    }

    @Override
    public Stream<BlockPos> getPositions(PlacementContext placementContext, Random random, BlockPos blockPos) {
        return this.validDimensions.contains(placementContext.getLevel().getLevel().dimension()) ? Stream.of(blockPos) : Stream.empty();
    }

    @Override
    public PlacementModifierType<?> type() {
        return BYGPlacementModifierType.IS_DIMENSION_FILTER.get();
    }
}