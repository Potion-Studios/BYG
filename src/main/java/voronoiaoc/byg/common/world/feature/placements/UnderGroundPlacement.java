package voronoiaoc.byg.common.world.feature.placements;


import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Heightmap;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UnderGroundPlacement extends Decorator<CountExtraChanceDecoratorConfig> {

    public static final Decorator<CountExtraChanceDecoratorConfig> UGPLACER = new UnderGroundPlacement(CountExtraChanceDecoratorConfig.CODEC);

    public UnderGroundPlacement(Codec<CountExtraChanceDecoratorConfig> codec) {
        super(codec);
    }

    public Stream<BlockPos> getPositions(WorldAccess worldIn, ChunkGenerator generator, Random random, CountExtraChanceDecoratorConfig config, BlockPos pos) {
        int c = config.count;
        if (random.nextFloat() < config.extraChance) {
            c += config.extraCount;
        }

        boolean airFlag = false;
        boolean airBlock = true;
        ArrayList<BlockPos> blockPosList = new ArrayList<BlockPos>();

        for (int i = 0; i < c; i++) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            BlockPos newPos = new BlockPos(pos.add(x, 0, z));
            int height = worldIn.getTopY(Heightmap.Type.MOTION_BLOCKING, newPos.getX(), newPos.getZ()) - 5;


            while (height > 15) {

                airBlock = worldIn.isAir
                        (pos.add(x, height, z));

                //if height is is an air block and previous block was a solid block, store the fact that we are in an air block now
                if (!airFlag && airBlock) {
                    airFlag = true;
                }


                //if height is an solid block and last block was air block, we are now on the surface of a piece of land. Generate feature now
                else if (airFlag && !airBlock) {

                    blockPosList.add(pos.add(x, height + 1, z));
                    airFlag = false;
                }

                //move down
                height--;
            }

        }

        return IntStream.range(0, blockPosList.size()).mapToObj((p_215051_3_) -> {
            return blockPosList.remove(0);
        }).filter(Objects::nonNull);
    }
}
