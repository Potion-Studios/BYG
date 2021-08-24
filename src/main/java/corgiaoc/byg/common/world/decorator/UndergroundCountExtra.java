package corgiaoc.byg.common.world.decorator;


import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.placement.DecorationContext;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UndergroundCountExtra extends FeatureDecorator<FrequencyWithExtraChanceDecoratorConfiguration> {

    public UndergroundCountExtra(Codec<FrequencyWithExtraChanceDecoratorConfiguration> codec) {
        super(codec);
    }

    public Stream<BlockPos> getPositions(DecorationContext decoratorContext, Random random, FrequencyWithExtraChanceDecoratorConfiguration config, BlockPos pos) {
        int c = config.count;
        if (random.nextFloat() < config.extraChance) {
            c += config.extraCount;
        }

        boolean airFlag = false;
        boolean airBlock;
        ArrayList<BlockPos> blockPosList = new ArrayList<BlockPos>();

        for (int i = 0; i < c; i++) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            BlockPos newPos = new BlockPos(pos.offset(x, 0, z));
            int height = decoratorContext.getHeight(Heightmap.Types.MOTION_BLOCKING, newPos.getX(), newPos.getZ()) - 5;

            while (height > 15) {
                airBlock = decoratorContext.getBlockState(pos.offset(x, height, z)).isAir();

                //if height is is an air block and previous block was a solid block, store the fact that we are in an air block now
                if (!airFlag && airBlock) {
                    airFlag = true;
                }

                //if height is an solid block and last block was air block, we are now on the surface of a piece of land. Generate feature now
                else if (airFlag && !airBlock) {

                    blockPosList.add(pos.offset(x, height + 1, z));
                    airFlag = false;
                }

                //move down
                height--;
            }
        }
        return IntStream.range(0, blockPosList.size()).mapToObj((integer) -> blockPosList.remove(0)).filter(Objects::nonNull);
    }
}
