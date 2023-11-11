package potionstudios.byg.common.world.placement;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Stream;

public class NearWaterPlacementFilter extends PlacementModifier {
    public static Codec<NearWaterPlacementFilter> CODEC = RecordCodecBuilder.create(builder -> builder.group(
            Codec.INT.fieldOf("searchRange").forGetter(nearWaterPlacementFilter -> nearWaterPlacementFilter.waterSearchRange)
    ).apply(builder, NearWaterPlacementFilter::new));
    private final int waterSearchRange;


    public NearWaterPlacementFilter(int waterSearchRange) {
        this.waterSearchRange = waterSearchRange;
    }


    @Override
    public @NotNull Stream<BlockPos> getPositions(@NotNull PlacementContext placementContext, @NotNull RandomSource random, @NotNull BlockPos blockPos) {
        for (int xMove = -waterSearchRange; xMove <= waterSearchRange; xMove++) {
            for (int zMove = -waterSearchRange; zMove <= waterSearchRange; zMove++) {
                if (placementContext.getLevel().getBlockState(blockPos.offset(xMove, -1, zMove)).is(Blocks.WATER)) {
                    return Stream.of(blockPos);
                }
            }
        }

        return Stream.empty();
    }

    @Override
    public @NotNull PlacementModifierType<?> type() {
        return BYGPlacementModifierType.NEAR_WATER_FILTER.get();
    }
}
