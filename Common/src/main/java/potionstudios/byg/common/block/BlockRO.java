package potionstudios.byg.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.registration.RegistryObject;

public interface BlockRO<B extends Block> extends RegistryObject<B> {

    default BlockState defaultBlockState() {
        return get().defaultBlockState();
    }

}
