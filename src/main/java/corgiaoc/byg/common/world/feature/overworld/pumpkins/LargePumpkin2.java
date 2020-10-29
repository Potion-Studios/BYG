package corgiaoc.byg.common.world.feature.overworld.pumpkins;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.config.PumpkinConfig;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class LargePumpkin2 extends Feature<PumpkinConfig> {

    public LargePumpkin2(Codec<PumpkinConfig> configIn) {
        super(configIn);
    }


    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos pos, PumpkinConfig config) {
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();

        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);
        int height = posY + 5;

        if (world.getBlockState(pos.down()) == config.getPumpkinProvider().getBlockState(rand, pos) || !world.getBlockState(pos.down()).isOpaque())
            return false;


        for (int startY = posY; startY <= height; startY++) {
            world.setBlockState(mutable, config.getStemProvider().getBlockState(rand, mutable), 2);
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

                setLeavesState(rand, mutable.set(posX + 1, height - 1, posZ), config, world);
                setLeavesState(rand, mutable.set(posX, height, posZ + 1), config, world);
                setLeavesState(rand, mutable.set(posX - 1, height, posZ), config, world);
                setLeavesState(rand, mutable.set(posX, height + 1, posZ), config, world);

            }
        }
        return true;
    }

    private void setPumpkinState(Random rand, BlockPos pos, PumpkinConfig config, StructureWorldAccess world) {
        if (world.isAir(pos) || FeatureUtil.isPlant(world, pos)) {
            world.setBlockState(pos, config.getPumpkinProvider().getBlockState(rand, pos), 2);
        }
    }

    private void setLeavesState(Random rand, BlockPos pos, PumpkinConfig config, StructureWorldAccess world) {
        if (world.isAir(pos)) {
            BlockState state = config.getLeavesProvider().getBlockState(rand, pos);
            if (state.contains(Properties.PERSISTENT))
                world.setBlockState(pos, state.with(Properties.PERSISTENT, true), 2);
            else
                world.setBlockState(pos, state, 2);
        }
    }
}
