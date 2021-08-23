package corgiaoc.byg.core;

import com.mojang.datafixers.types.Type;
import corgiaoc.byg.BYG;
import corgiaoc.byg.common.entity.tileentities.HypogealImperiumTE;
import corgiaoc.byg.mixin.access.BlockEntityTypeBuilderAccess;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.TypeReferences;

import java.util.ArrayList;
import java.util.List;

public class BYGTileEntities {

    public static final List<TileEntityType<?>> BLOCK_ENTITIES = new ArrayList<>();

    public static final TileEntityType<HypogealImperiumTE> HYPOGEAL  = register("hypogeal", TileEntityType.Builder.of(HypogealImperiumTE::new, BYGBlocks.HYPOGEAL_IMPERIUM));


    private static <T extends TileEntity> TileEntityType<T> register(String key, TileEntityType.Builder<T> builder) {
        if (((BlockEntityTypeBuilderAccess) (Object) builder).getValidBlocks().isEmpty()) {
            BYG.LOGGER.warn("Block entity type {} requires at least one valid block to be defined!", (Object) key);
        }

        Type<?> type = Util.fetchChoiceType(TypeReferences.BLOCK_ENTITY, key);
        TileEntityType<T> blockEntityType = builder.build(type);
        blockEntityType.setRegistryName(new ResourceLocation(BYG.MOD_ID, key));

        BLOCK_ENTITIES.add(blockEntityType);
        return blockEntityType;
    }
}