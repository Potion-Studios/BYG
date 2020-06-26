package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraftforge.common.Tags;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class WeepingRoots extends Feature<NoFeatureConfig> {
    public WeepingRoots(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_230362_a_(ISeedReader worldIn, StructureManager structureManager, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {

        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if (!worldIn.isAirBlock(pos) || !worldIn.getBlockState(pos.up()).getBlock().isIn(Tags.Blocks.STONE) || !worldIn.getBlockState(pos.up()).getBlock().isIn(Tags.Blocks.NETHERRACK) && !worldIn.func_230315_m_().func_236040_e_()) {
            return false;
        } else {

            worldIn.setBlockState(pos, BYGBlockList.WEEPING_ROOTS.getDefaultState(), 10);

            return true;
        }
    }
}