package corgiaoc.byg.common.world.feature.overworld.trees.pine;

import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Optional;
import java.util.Random;

public class SmallPineTree extends Feature<DefaultFeatureConfig> {

    public SmallPineTree(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random rand = context.getRandom();
        DefaultFeatureConfig config = context.getConfig();

        if (pos.getX() == -8 && pos.getZ() == -9) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        world.setBlockState(block, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }

            StructureManager templatemanager = world.toServerWorld().getStructureManager();
            Optional<Structure> template = templatemanager.getStructure(new Identifier(BYG.MOD_ID + ":features/trees/ether_tree5"));

            if (template.isEmpty()) {
                BYG.LOGGER.warn("NBT does not exist!");
                return false;
            }

            StructurePlacementData placementsettings = (new StructurePlacementData()).setMirror(BlockMirror.NONE).setRotation(BlockRotation.NONE).setIgnoreEntities(false);
            template.get().place(world, pos, pos, placementsettings, rand, Block.NOTIFY_LISTENERS);
            return true;
        }
        return false;
    }
}
