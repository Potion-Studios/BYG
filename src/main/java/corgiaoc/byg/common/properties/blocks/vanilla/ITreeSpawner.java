package corgiaoc.byg.common.properties.blocks.vanilla;

import corgiaoc.byg.common.world.feature.overworld.trees.TreeSpawners;
import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Util;

public interface ITreeSpawner {

    Reference2ReferenceOpenHashMap<Block, TreeSpawner> VANILLA_SAPLING_BYG_TREE_SPAWNERS = Util.make(new Reference2ReferenceOpenHashMap<>(), (map) -> {
        map.put(Blocks.SPRUCE_SAPLING, TreeSpawners.SPRUCE);
        map.put(Blocks.BIRCH_SAPLING, TreeSpawners.BIRCH);
        map.put(Blocks.OAK_SAPLING, TreeSpawners.OAK);
    });


    void setTreeSpawner(TreeSpawner treeSpawner);
}
