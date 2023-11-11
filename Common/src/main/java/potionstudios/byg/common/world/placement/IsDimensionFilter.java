package potionstudios.byg.common.world.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Stream;

//TODO: Is this possible to do as a tag?!
public class IsDimensionFilter extends PlacementModifier {

    public static final Codec<IsDimensionFilter> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(ResourceKey.codec(Registries.DIMENSION).listOf().fieldOf("valid_dimensions").forGetter(isBiomeTagFilter -> isBiomeTagFilter.validDimensions)
            ).apply(builder, IsDimensionFilter::new));

    private final List<ResourceKey<Level>> validDimensions;

    public IsDimensionFilter(List<ResourceKey<Level>> validDimensions) {
        this.validDimensions = validDimensions;
    }

    @Override
    public @NotNull Stream<BlockPos> getPositions(PlacementContext placementContext, @NotNull RandomSource random, @NotNull BlockPos blockPos) {
        return this.validDimensions.contains(placementContext.getLevel().getLevel().dimension()) ? Stream.of(blockPos) : Stream.empty();
    }

    @Override
    public @NotNull PlacementModifierType<?> type() {
        return BYGPlacementModifierType.IS_DIMENSION_FILTER.get();
    }
}