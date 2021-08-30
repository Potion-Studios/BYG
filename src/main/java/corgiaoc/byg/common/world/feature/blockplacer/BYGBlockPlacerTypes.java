package corgiaoc.byg.common.world.feature.blockplacer;

import corgiaoc.byg.BYG;
import corgiaoc.byg.mixin.access.BlockPlacerTypeAccess;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacer;
import net.minecraft.world.level.levelgen.feature.blockplacers.BlockPlacerType;

import java.util.ArrayList;
import java.util.List;

public class BYGBlockPlacerTypes {

    public static List<BlockPlacerType<?>> types = new ArrayList<>();

    public static final BlockPlacerType<DoubleBlockPlacer> DOUBLE_BLOCK = createBlockPlacer("simple_block_placer", BlockPlacerTypeAccess.create(DoubleBlockPlacer.CODEC));
    public static final BlockPlacerType<OnWaterOnlyBlockPlacer> WATER_ONLY = createBlockPlacer("water_only", BlockPlacerTypeAccess.create(OnWaterOnlyBlockPlacer.CODEC));


    private static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacer(String id, BlockPlacerType<P> type) {
        Registry.register(Registry.BLOCK_PLACER_TYPES, new ResourceLocation(BYG.MOD_ID, id), type);
//        type.setRegistryName(new ResourceLocation(BYG.MOD_ID, id));
        types.add(type);
        return type;
    }

    public static void init() {
    }
}
