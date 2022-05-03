package potionstudios.byg.common.blockentity;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.registration.RegistrationProvider;
import potionstudios.byg.registration.RegistryObject;

import java.util.function.Supplier;

public class BYGBlockEntities {

    private static final RegistrationProvider<BlockEntityType<?>> PROVIDER = RegistrationProvider.get(Registry.BLOCK_ENTITY_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<BlockEntityType<HypogealImperiumBlockEntity>> HYPOGEAL = register("hypogeal", () -> BlockEntityType.Builder.of(HypogealImperiumBlockEntity::new, BYGBlocks.HYPOGEAL_IMPERIUM));

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String key, Supplier<BlockEntityType.Builder<T>> builder) {
        return PROVIDER.register(key, () -> builder.get().build(null));
    }

    public static void loadClass() {}
}