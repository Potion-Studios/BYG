package corgiaoc.byg.common.world.decorator;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.decorator.config.AtOrBelowSeaLevelCountExtraConfig;
import corgiaoc.byg.mixin.access.WorldDecoratingHelperAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AtOrBelowSeaLevelCountExtra extends FeatureDecorator<AtOrBelowSeaLevelCountExtraConfig> {

    public AtOrBelowSeaLevelCountExtra(Codec<AtOrBelowSeaLevelCountExtraConfig> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(DecorationContext ctx, Random random, AtOrBelowSeaLevelCountExtraConfig config, BlockPos pos) {
        int repeats = config.count;
        if (random.nextFloat() < config.extraChance) {
            repeats += config.extraCount;
        }

        return IntStream.range(0, repeats).mapToObj((streamedInt) -> {
            int moveDown = 0;
            int j = random.nextInt(16) + pos.getX();
            int k = random.nextInt(16) + pos.getZ();
            int l = ((WorldDecoratingHelperAccess) ctx).getGenerator().getSeaLevel(); //Sea level from the chunk generator since this value is actually modified in the Nether.

            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(j, l, k);
            while (moveDown <= config.belowSeaLevel) {
                if (ctx.getBlockState(mutable).canOcclude())
                    break;

                mutable.move(Direction.DOWN);
                moveDown++;
            }
            return mutable.immutable();
        });
    }
}