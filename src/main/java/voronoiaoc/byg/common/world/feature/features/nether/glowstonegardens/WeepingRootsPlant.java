package voronoiaoc.byg.common.world.feature.features.nether.glowstonegardens;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
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

public class WeepingRootsPlant extends Feature<NoFeatureConfig> {
    public WeepingRootsPlant(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
        super(config);
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int randLength = rand.nextInt(7) + 3;

        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if (!worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.NETHERRACK) || !worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.STONE) && !worldIn.getDimension().isNether()) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable(pos.getX(), pos.getY() - WeepingRootPlantLength, pos.getZ());
                if (worldIn.getBlockState(mutable).getBlock() == Blocks.AIR)
                    worldIn.setBlockState(mutable, BYGBlockList.WEEPING_ROOTS_PLANT.getDefaultState(), 10);

            }
            return true;
        }
    }
}