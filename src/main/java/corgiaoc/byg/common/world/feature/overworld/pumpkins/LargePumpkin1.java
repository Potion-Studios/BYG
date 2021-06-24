package corgiaoc.byg.common.world.feature.overworld.pumpkins;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.FeatureUtil;
import corgiaoc.byg.common.world.feature.config.PumpkinConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class LargePumpkin1 extends Feature<PumpkinConfig> {

    public LargePumpkin1(Codec<PumpkinConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean generate(FeatureContext<PumpkinConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        PumpkinConfig config = context.getConfig();

        BlockPos.Mutable mutable = new BlockPos.Mutable().set(pos);

        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();


        if (world.getBlockState(pos.down()) != config.getPumpkinProvider().getBlockState(random, pos) || !world.getBlockState(pos.down()).isOpaque())
            return false;

        if (posY - 1 < world.getHeight()) {
            setPumpkinState(mutable.set(posX, posY + 1, posZ), random, config, world);
            setPumpkinState(mutable.set(posX - 1, posY, posZ), random, config, world);
            setPumpkinState(mutable.set(posX + 1, posY, posZ), random, config, world);
            setPumpkinState(mutable.set(posX + 1, posY, posZ + 1), random, config, world);
            setPumpkinState(mutable.set(posX, posY, posZ + 1), random, config, world);
            setPumpkinState(mutable.set(posX, posY, posZ - 1), random, config, world);
        }
        return true;
    }

    private void setPumpkinState(BlockPos pos, Random rand, PumpkinConfig config, StructureWorldAccess world) {
        if (world.isAir(pos) || FeatureUtil.isPlant(world, pos)) {
            world.setBlockState(pos, config.getPumpkinProvider().getBlockState(rand, pos), 2);
        }
    }
}