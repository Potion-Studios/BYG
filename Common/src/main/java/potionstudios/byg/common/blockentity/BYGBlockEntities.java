package potionstudios.byg.common.blockentity;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

public class BYGBlockEntities {

    private static final RegistrationProvider<BlockEntityType<?>> PROVIDER = RegistrationProvider.get(Registries.BLOCK_ENTITY_TYPE, BYG.MOD_ID);

    private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String key, Supplier<BlockEntityType.Builder<T>> builder) {
        return PROVIDER.register(key, () -> builder.get().build(null));
    }

    public static void loadClass() {}
}