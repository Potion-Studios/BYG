package corgiaoc.byg.common.world.feature.decorator;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.RegistrationHelper;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ObsidianSpikePlacer extends Placement<AtSurfaceWithExtraConfig> {

    public ObsidianSpikePlacer(Codec<AtSurfaceWithExtraConfig> config) {
        super(config);
    }

    public Stream<BlockPos> func_241857_a(WorldDecoratingHelper decoratorContext, Random random, AtSurfaceWithExtraConfig config, BlockPos pos) {
        int i = random.nextInt(config.count);
        return IntStream.range(0, i).mapToObj((idx) -> {
            int j = random.nextInt(16) + pos.getX();
            int k = random.nextInt(16) + pos.getZ();
            int l = random.nextInt(75) + 54;
            return new BlockPos(j, l, k);
        });
    }
}