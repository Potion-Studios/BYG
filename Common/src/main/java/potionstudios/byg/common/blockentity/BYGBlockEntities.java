package potionstudios.byg.common.blockentity;

import com.mojang.datafixers.types.Type;
import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.BlockEntityTypeBuilderAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGBlockEntities {

    public static final List<RegistryObject<BlockEntityType<?>>> BLOCK_ENTITIES = new ArrayList<>();

    public static final BlockEntityType<HypogealImperiumBlockEntity> HYPOGEAL  = register("hypogeal", BlockEntityType.Builder.of(HypogealImperiumBlockEntity::new, BYGBlocks.HYPOGEAL_IMPERIUM));


    private static <T extends BlockEntity> BlockEntityType<T> register(String key, BlockEntityType.Builder<T> builder) {
        if (((BlockEntityTypeBuilderAccess) (Object) builder).byg_getValidBlocks().isEmpty()) {
            BYG.LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", (Object) key);
        }

        Type<?> type = Util.fetchChoiceType(References.BLOCK_ENTITY, key);
        BlockEntityType<T> blockEntityType = builder.build(type);
        BLOCK_ENTITIES.add(new RegistryObject<>(blockEntityType, key));
        return blockEntityType;
    }

    public static Collection<RegistryObject<BlockEntityType<?>>> bootStrap() {
        return BLOCK_ENTITIES;
    }

    static {
        BYG.LOGGER.info("BYG Block Entities class loaded.");
    }
}