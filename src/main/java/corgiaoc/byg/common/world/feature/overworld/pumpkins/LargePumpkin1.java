package corgiaoc.byg.common.world.feature.overworld.pumpkins;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.config.PumpkinConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class LargePumpkin1 extends Feature<PumpkinConfig> {

    public LargePumpkin1(Codec<PumpkinConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, PumpkinConfig config) {
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();


        if (world.getBlockState(pos.below()) != config.getPumpkinProvider().getState(random, pos) || !world.getBlockState(pos.below()).canOcclude())
            return false;

        if (posY - 1 < world.getMaxBuildHeight()) {
            setPumpkinState(mutable.set(posX, posY + 1, posZ), random, config, world);
            setPumpkinState(mutable.set(posX - 1, posY, posZ), random, config, world);
            setPumpkinState(mutable.set(posX + 1, posY, posZ), random, config, world);
            setPumpkinState(mutable.set(posX + 1, posY, posZ + 1), random, config, world);
            setPumpkinState(mutable.set(posX, posY, posZ + 1), random, config, world);
            setPumpkinState(mutable.set(posX, posY, posZ - 1), random, config, world);
        }
        return true;
    }

    private void setPumpkinState(BlockPos pos, Random rand, PumpkinConfig config, ISeedReader world) {
        if (world.isEmptyBlock(pos) || FeatureUtil.isPlant(world, pos)) {
            world.setBlock(pos, config.getPumpkinProvider().getState(rand, pos), 2);
        }
    }
}