package potionstudios.byg.common.world.feature.gen.overworld.pumpkins;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import potionstudios.byg.common.world.feature.config.PumpkinConfig;
import potionstudios.byg.common.world.feature.gen.FeatureGenUtil;

import java.util.Random;

public class LargePumpkin2 extends Feature<PumpkinConfig> {

    public LargePumpkin2(Codec<PumpkinConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(FeaturePlaceContext<PumpkinConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, PumpkinConfig config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);
        int height = posY + 5;

        if (world.getBlockState(pos.below()) == config.getPumpkinProvider().getState(rand, pos) || !world.getBlockState(pos.below()).canOcclude())
            return false;


        for (int startY = posY; startY <= height; startY++) {
            world.setBlock(mutable, config.getStemProvider().getState(rand, mutable), 2);
            mutable.move(Direction.UP);
        }


        int width = 2;
        for (int widthX = -width; widthX <= width; ++widthX) {
            for (int widthZ = -width; widthZ <= width; ++widthZ) {
                if (widthX <= 1 && widthZ <= 1 && widthZ >= -1 && widthX >= -1) {
                    setPumpkinState(rand, mutable.set(posX + widthX, height - 2, posZ + widthZ), config, world);
                    setPumpkinState(rand, mutable.set(posX + widthX, height - 3, posZ + widthZ), config, world);
                    setPumpkinState(rand, mutable.set(posX + widthX, height - 4, posZ + widthZ), config, world);
                    setPumpkinState(rand, mutable.set(posX + widthX, height - 5, posZ + widthZ), config, world);
                }

                setPumpkinState(rand, mutable.set(posX, height - 3, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX + 1, height - 3, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 1, height - 3, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX, height - 3, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX + 1, height - 3, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 1, height - 3, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 3, posZ), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 3, posZ + 1), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 3, posZ - 1), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 3, posZ), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 3, posZ + 1), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 3, posZ - 1), config, world);
                setPumpkinState(rand, mutable.set(posX, height - 4, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX + 1, height - 4, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 1, height - 4, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX, height - 4, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX + 1, height - 4, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 1, height - 4, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 4, posZ), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 4, posZ + 1), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 4, posZ - 1), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 4, posZ), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 4, posZ + 1), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 4, posZ - 1), config, world);
                setPumpkinState(rand, mutable.set(posX, height - 5, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX + 1, height - 5, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 1, height - 5, posZ - 2), config, world);
                setPumpkinState(rand, mutable.set(posX, height - 5, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX + 1, height - 5, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 1, height - 5, posZ + 2), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 5, posZ), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 5, posZ + 1), config, world);
                setPumpkinState(rand, mutable.set(posX - 2, height - 5, posZ - 1), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 5, posZ), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 5, posZ + 1), config, world);
                setPumpkinState(rand, mutable.set(posX + 2, height - 5, posZ - 1), config, world);

                setLeavesState(rand, mutable.set(posX+ 1, height - 1, posZ), config, world);
                setLeavesState(rand, mutable.set(posX, height, posZ + 1), config, world);
                setLeavesState(rand, mutable.set(posX - 1, height, posZ), config, world);
                setLeavesState(rand, mutable.set(posX, height + 1, posZ), config, world);

            }
        }
        return true;
    }

    private void setPumpkinState(Random rand, BlockPos pos, PumpkinConfig config, WorldGenLevel world) {
        if (world.isEmptyBlock(pos) || FeatureGenUtil.isPlant(world, pos)) {
            world.setBlock(pos, config.getPumpkinProvider().getState(rand, pos), 2);
        }
    }

    private void setLeavesState(Random rand, BlockPos pos, PumpkinConfig config, WorldGenLevel world) {
        if (world.isEmptyBlock(pos)) {
            BlockState state = config.getLeavesProvider().getState(rand, pos);
            if (state.hasProperty(BlockStateProperties.PERSISTENT))
                world.setBlock(pos, state.setValue(BlockStateProperties.PERSISTENT, true), 2);
            else
                world.setBlock(pos, state, 2);
        }
    }
}
