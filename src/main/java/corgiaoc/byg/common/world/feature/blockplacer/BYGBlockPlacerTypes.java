package corgiaoc.byg.common.world.feature.blockplacer;

import corgiaoc.byg.BYG;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.placer.BlockPlacer;
import net.minecraft.world.gen.placer.BlockPlacerType;

import java.util.ArrayList;
import java.util.List;

public class BYGBlockPlacerTypes {

    public static List<BlockPlacerType<?>> types = new ArrayList<>();

    public static final BlockPlacerType<DoubleBlockPlacer> DOUBLE_BLOCK = createBlockPlacer("simple_block_placer", new BlockPlacerType<>(DoubleBlockPlacer.CODEC));


    private static <P extends BlockPlacer> BlockPlacerType<P> createBlockPlacer(String id, BlockPlacerType<P> type) {
        Registry.register(Registry.BLOCK_PLACER_TYPE, new Identifier(BYG.MOD_ID, id), type);
//        type.setRegistryName(new Identifier(BYG.MOD_ID, id));
        types.add(type);
        return type;
    }

    public static void init() {
    }
}
