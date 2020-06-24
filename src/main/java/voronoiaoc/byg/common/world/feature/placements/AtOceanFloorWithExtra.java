package voronoiaoc.byg.common.world.feature.placements;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AtOceanFloorWithExtra extends Placement<AtSurfaceWithExtraConfig> {

    public static final Placement<AtSurfaceWithExtraConfig> OCEANFLOOR = new AtOceanFloorWithExtra(AtSurfaceWithExtraConfig::deserialize);

    public AtOceanFloorWithExtra(Function<Dynamic<?>, ? extends AtSurfaceWithExtraConfig> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generatorIn, Random random, AtSurfaceWithExtraConfig configIn, BlockPos pos) {
        int i = configIn.count;
        if (random.nextFloat() < configIn.extraChance) {
            i += configIn.extraCount;
        }

        return IntStream.range(0, i).mapToObj((p_227444_3_) -> {
            int j = random.nextInt(16) + pos.getX();
            int k = random.nextInt(16) + pos.getZ();
            int l = worldIn.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, j, k);
            return new BlockPos(j, l, k);
        });
    }
}