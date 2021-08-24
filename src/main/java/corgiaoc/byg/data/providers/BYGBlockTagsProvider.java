package corgiaoc.byg.data.providers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlockTags;
import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BYGBlockTagsProvider extends BlockTagsProvider {
    public BYGBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (ITag.INamedTag<Block> plantTag : BYGBlockTags.PLANT_TAGS) {
            this.tag(plantTag).addTag(MLBlockTags.DIRT);
        }
        for (ITag.INamedTag<Block> desertPlantTag : BYGBlockTags.SAND_PLANT_TAGS) {
            this.tag(desertPlantTag).addTag(BlockTags.SAND);
        }
        this.tag(BYGBlockTags.GROUND_PALM_SAPLING).addTag(BlockTags.SAND).addTag(MLBlockTags.DIRT);
    }

    @Override
    public String getName() {
        return "BYG Block Tags";
    }
}
