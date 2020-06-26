package voronoiaoc.byg.common.world.feature.placements;//package sporeaoc.byg.modsupport;


import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class UnderGroundPlacement extends Placement<AtSurfaceWithExtraConfig> {

    public static final Placement<AtSurfaceWithExtraConfig> UGPLACER = new UnderGroundPlacement(AtSurfaceWithExtraConfig.field_236973_a_);

    public UnderGroundPlacement(Codec<AtSurfaceWithExtraConfig> configFactoryIn) {
        super(configFactoryIn);
    }

    public Stream<BlockPos> getPositions(IWorld worldIn, ChunkGenerator chunkGenerator, Random random, AtSurfaceWithExtraConfig chancesConfig, BlockPos pos) {
        int c = chancesConfig.count;
        if (random.nextFloat() < chancesConfig.extraChance) {
            c += chancesConfig.extraCount;
        }

        boolean airFlag = false;
        boolean airBlock = true;
        ArrayList<BlockPos> blockPosList = new ArrayList<BlockPos>();

        for (int i = 0; i < c; i++) {
            int x = random.nextInt(16);
            int z = random.nextInt(16);
            int height = worldIn.getHeight(Heightmap.Type.MOTION_BLOCKING, pos.add(x, 0, z)).getY() - 5;


            while (height > 15) {

                airBlock = worldIn.isAirBlock(pos.add(x, height, z));

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
