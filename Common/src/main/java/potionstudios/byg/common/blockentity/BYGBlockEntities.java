package potionstudios.byg.common.blockentity;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.BlockEntityTypeBuilderAccess;
import potionstudios.byg.registration.BygRegistrationProvider;
import potionstudios.byg.registration.BygRegistryObject;

public class BYGBlockEntities {

    public static final BygRegistryObject<BlockEntityType<HypogealImperiumBlockEntity>> HYPOGEAL = register("hypogeal", BlockEntityType.Builder.of(HypogealImperiumBlockEntity::new, BYGBlocks.HYPOGEAL_IMPERIUM));

    @SuppressWarnings("rawtypes")
    private static <T extends BlockEntity> BygRegistryObject<BlockEntityType<T>> register(String key, BlockEntityType.Builder<T> builder) {
        if (((BlockEntityTypeBuilderAccess) (Object) builder).byg_getValidBlocks().isEmpty()) {
            BYG.LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", key);
        }
        return BygRegistrationProvider.INSTANCE.registerUnsafeResult(Registry.BLOCK_ENTITY_TYPE_REGISTRY, key, () -> builder.build(null));
    }

    public static void loadClass() {}
}