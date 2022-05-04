package potionstudios.byg.common.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.registration.RegistryObject;

public interface BlockRO<B extends Block> extends RegistryObject<B>, ItemLike {

    default BlockState defaultBlockState() {
        return get().defaultBlockState();
    }

    @Override
    default @NotNull Item asItem() {
        return get().asItem();
    }
}
