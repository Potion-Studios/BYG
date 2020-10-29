package corgiaoc.byg.common.world.decorator;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.decorator.CountExtraDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.DecoratorContext;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FloatingIsland extends Decorator<CountExtraDecoratorConfig> {

    public FloatingIsland(Codec<CountExtraDecoratorConfig> config) {
        super(config);
    }

    public Stream<BlockPos> getPositions(DecoratorContext decoratorContext, Random random, CountExtraDecoratorConfig config, BlockPos pos) {
        int i = config.count;
        if (random.nextFloat() < config.extraChance) {
            i += config.extraCount;
        }

        return IntStream.range(0, i).mapToObj((streamedInt) -> {
            int x = random.nextInt(16) + pos.getX();
            int z = random.nextInt(16) + pos.getZ();
            int y = random.nextInt(decoratorContext.world.getHeight() - 40) + 20;
            return new BlockPos(x, y, z);
        });
    }
}