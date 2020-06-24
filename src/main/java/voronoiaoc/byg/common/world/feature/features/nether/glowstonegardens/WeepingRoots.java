package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.datafixers.Dynamic;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.function.Function;

public class WeepingRoots extends Feature<NoFeatureConfig> {
    public WeepingRoots(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
        super(config);
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {

        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if (!worldIn.isAirBlock(pos) || !worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.STONE) || !worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.NETHERRACK) && !worldIn.getDimension().isNether()) {
            return false;
        } else {

            worldIn.setBlockState(pos, BYGBlockList.WEEPING_ROOTS.getDefaultState(), 10);

            return true;
        }
    }
}