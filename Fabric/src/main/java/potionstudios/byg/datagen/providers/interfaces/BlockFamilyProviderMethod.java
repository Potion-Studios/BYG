package potionstudios.byg.datagen.providers.interfaces;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.world.level.block.Block;

public interface BlockFamilyProviderMethod {
    Block getBlock();
    BlockModelGenerators getGenerator();
}