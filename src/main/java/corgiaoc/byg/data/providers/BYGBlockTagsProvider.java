package corgiaoc.byg.data.providers;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlockTags;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.ITag;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BYGBlockTagsProvider extends BlockTagsProvider {
    public BYGBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (ITag.INamedTag<Block> plantTag : BYGBlockTags.PLANT_TAGS) {
            this.tag(plantTag).addTag(Tags.Blocks.DIRT);
        }
        for (ITag.INamedTag<Block> desertPlantTag : BYGBlockTags.DESERT_PLANT_TAGS) {
            this.tag(desertPlantTag).addTag(Tags.Blocks.DIRT);
        }
    }

    @Override
    public String getName() {
        return "BYG Block Tags";
    }
}
