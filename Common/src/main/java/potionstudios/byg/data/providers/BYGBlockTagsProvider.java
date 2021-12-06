package potionstudios.byg.data.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.core.BYGBlockTags;
import potionstudios.byg.util.MLBlockTags;

public class BYGBlockTagsProvider extends BlockTagsProvider {
    public BYGBlockTagsProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void addTags() {
        for (Tag.Named<Block> plantTag : BYGBlockTags.PLANT_TAGS) {
            this.tag(plantTag).addTag(MLBlockTags.DIRT);
        }
        for (Tag.Named<Block> desertPlantTag : BYGBlockTags.SAND_PLANT_TAGS) {
            this.tag(desertPlantTag).addTag(BlockTags.SAND);
        }
        this.tag(BYGBlockTags.GROUND_PALM_SAPLING).addTag(BlockTags.SAND).addTag(MLBlockTags.DIRT);
    }

    @Override
    public String getName() {
        return "BYG Block Tags";
    }
}
