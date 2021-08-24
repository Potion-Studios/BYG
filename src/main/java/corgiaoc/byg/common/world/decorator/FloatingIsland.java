package corgiaoc.byg.common.world.decorator;

import com.mojang.serialization.Codec;
import corgiaoc.byg.mixin.access.WorldDecoratingHelperAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FloatingIsland extends Placement<AtSurfaceWithExtraConfig> {

    public FloatingIsland(Codec<AtSurfaceWithExtraConfig> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(WorldDecoratingHelper decoratorContext, Random random, AtSurfaceWithExtraConfig config, BlockPos pos) {
        int i = config.count;
        if (random.nextFloat() < config.extraChance) {
            i += config.extraCount;
        }

        return IntStream.range(0, i).mapToObj((streamedInt) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            int y = random.nextInt(((WorldDecoratingHelperAccess) decoratorContext).getLevel().getMaxBuildHeight() - 40) + 20;
            return new BlockPos(x, y, z);
        });
    }
}