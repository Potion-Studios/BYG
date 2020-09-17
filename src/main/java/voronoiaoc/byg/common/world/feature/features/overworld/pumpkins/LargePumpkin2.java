package voronoiaoc.byg.common.world.feature.features.overworld.pumpkins;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.common.world.feature.config.BYGPumpkinFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.FeatureUtil;

import java.util.Random;

public class LargePumpkin2 extends Feature<BYGPumpkinFeatureConfig> {

    public LargePumpkin2(Codec<BYGPumpkinFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, BYGPumpkinFeatureConfig config) {
        BlockState pumpkinState = config.getPumpkinProvider().getBlockState(rand, pos);
        BlockState stemState = config.getStemProvider().getBlockState(rand, pos);

        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        BlockPos.Mutable mutable = new BlockPos.Mutable().setPos(pos);
        int height = posY + 5;

        for (int startY = posY; startY <= height; startY++) {
            worldIn.setBlockState(mutable, stemState, 2);
            mutable.move(Direction.UP);
        }


        int width = 2;
        for (int widthX = -width; widthX <= width; ++widthX) {
            for (int widthZ = -width; widthZ <= width; ++widthZ) {
                if (widthX <= 1 && widthZ <= 1 && widthZ >= -1 && widthX >= -1) {
                    setPumpkinState(mutable.setPos(posX + widthX, height - 2, posZ + widthZ), pumpkinState, worldIn);
                    setPumpkinState(mutable.setPos(posX + widthX, height - 3, posZ + widthZ), pumpkinState, worldIn);
                    setPumpkinState(mutable.setPos(posX + widthX, height - 4, posZ + widthZ), pumpkinState, worldIn);
                    setPumpkinState(mutable.setPos(posX + widthX, height - 5, posZ + widthZ), pumpkinState, worldIn);
                }

                setPumpkinState(mutable.setPos(posX, height - 3, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 1, height - 3, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 1, height - 3, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX, height - 3, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 1, height - 3, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 1, height - 3, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 3, posZ), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 3, posZ + 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 3, posZ - 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 3, posZ), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 3, posZ + 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 3, posZ - 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX, height - 4, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 1, height - 4, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 1, height - 4, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX, height - 4, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 1, height - 4, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 1, height - 4, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 4, posZ), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 4, posZ + 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 4, posZ - 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 4, posZ), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 4, posZ + 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 4, posZ - 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX, height - 5, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 1, height - 5, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 1, height - 5, posZ - 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX, height - 5, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 1, height - 5, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 1, height - 5, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 5, posZ), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 5, posZ + 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height - 5, posZ - 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 5, posZ), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 5, posZ + 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX + 2, height - 5, posZ - 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX, height - 1, posZ + 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 1, height, posZ + 2), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 2, height, posZ + 1), pumpkinState, worldIn);
                setPumpkinState(mutable.setPos(posX - 1, height + 1, posZ + 1), pumpkinState, worldIn);

            }
        }
        return false;
    }

    private void setPumpkinState(BlockPos pos, BlockState pumpkinState, ISeedReader world) {
        if (world.isAirBlock(pos) || FeatureUtil.isPlant((World) world, pos)) {
            world.setBlockState(pos, pumpkinState, 2);
        }
    }
}
