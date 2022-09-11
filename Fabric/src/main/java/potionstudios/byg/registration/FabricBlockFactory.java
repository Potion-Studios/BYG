package potionstudios.byg.registration;

import com.google.auto.service.AutoService;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import potionstudios.byg.common.block.BYGBlockFactory;
import potionstudios.byg.common.block.BYGScaffoldingBlock;

import java.util.function.Supplier;

@AutoService(BYGBlockFactory.class)
public class FabricBlockFactory implements BYGBlockFactory {
    @Override
    public FlowerPotBlock createPottedBlock(Supplier<? extends Block> block, BlockBehaviour.Properties behaviour) {
        return new FlowerPotBlock(block.get(), behaviour);
    }

    @Override
    public BYGScaffoldingBlock createScaffolding(BlockBehaviour.Properties behaviour) {
        return new BYGScaffoldingBlock(behaviour);
    }
}
