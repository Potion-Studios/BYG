package potionstudios.byg.registration;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * A specialized registry object for {@link Block Blocks}.
 *
 * @param <B> the type of the block
 */
public interface BlockRegistryObject<B extends Block> extends RegistryObject<B>, ItemLike {

    /**
     * Gets the default state of this block.
     *
     * @return the default state of this block
     */
    default BlockState defaultBlockState() {
        return get().defaultBlockState();
    }

    /**
     * Gets the item representation of this block.
     *
     * @return the item representation of this block
     */
    @Override
    default @NotNull Item asItem() {
        return get().asItem();
    }

    /**
     * Wraps a normal registry object into a specialized block one.
     *
     * @param object the object to wrap
     * @param <B>    the type of the block
     * @return the wrapper
     */
    static <B extends Block> BlockRegistryObject<B> wrap(RegistryObject<B> object) {
        return new BlockRegistryObject<>() {
            @Override
            public ResourceKey<B> getResourceKey() {
                return object.getResourceKey();
            }

            @Override
            public ResourceLocation getId() {
                return object.getId();
            }

            @Override
            public B get() {
                return object.get();
            }

            @Override
            public Holder<B> asHolder() {
                return object.asHolder();
            }
        };
    }
}
