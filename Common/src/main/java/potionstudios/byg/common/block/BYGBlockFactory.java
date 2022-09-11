package potionstudios.byg.common.block;

import com.google.common.collect.Lists;
import net.minecraft.Util;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;

import java.util.ServiceLoader;
import java.util.function.Supplier;

public interface BYGBlockFactory {

    BYGBlockFactory INSTANCE = Util.make(() -> {
        final var loader = ServiceLoader.load(BYGBlockFactory.class);
        final var providers = Lists.newArrayList(loader.iterator());
        if (providers.isEmpty()) {
            throw new RuntimeException("No BYGBlockFactory was found on the classpath!");
        } else if (providers.size() > 1) {
            throw new RuntimeException("More than one BYGBlockFactory was found on the classpath!");
        }
        return providers.get(0);
    });

    FlowerPotBlock createPottedBlock(Supplier<? extends Block> block, BlockBehaviour.Properties behaviour);
    BYGScaffoldingBlock createScaffolding(BlockBehaviour.Properties behaviour);
}
