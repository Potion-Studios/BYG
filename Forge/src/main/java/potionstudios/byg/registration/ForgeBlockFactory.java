package potionstudios.byg.registration;

import com.google.auto.service.AutoService;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import potionstudios.byg.common.block.BYGBlockFactory;

import java.util.function.Supplier;

@AutoService(BYGBlockFactory.class)
public class ForgeBlockFactory implements BYGBlockFactory {
    @Override
    public FlowerPotBlock createPottedBlock(Supplier<? extends Block> block, BlockBehaviour.Properties behaviour) {
        return new FlowerPotBlock(null, block, behaviour);
    }
}
