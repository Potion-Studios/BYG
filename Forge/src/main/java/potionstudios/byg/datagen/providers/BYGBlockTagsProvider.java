package potionstudios.byg.datagen.providers;

import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.reg.RegistryObject;

import java.util.Arrays;
import java.util.function.Supplier;

import static potionstudios.byg.common.block.BYGBlocks.*;

@SuppressWarnings("ALL")
public class BYGBlockTagsProvider extends TagsProvider<Block> {


    public BYGBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, Registry.BLOCK, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(
                BYGBlockTags.LUSH,
                LUSH_GRASS_PATH, LUSH_GRASS_BLOCK, LUSH_FARMLAND
        );
        tag(BYGBlockTags.GROUND_MANGROVE_TREE).addTags(BlockTags.DIRT, BlockTags.SAND).add(MUD_BLOCK.get(), Blocks.CLAY);

        final var slabsTag = super.tag(BYGBlockTags.SLABS);
        PROVIDER.getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(SlabBlock.class::isInstance)
                .forEach(slabsTag::add);

        tag(BYGBlockTags.END_STONE).add(ETHER_STONE.get(), BULBIS_PHYCELIUM.get(), NIGHTSHADE_PHYLIUM.get(), IMPARIUS_PHYLIUM.get(), IVIS_PHYLIUM.get(), SHULKREN_PHYLIUM.get(), Blocks.END_STONE);

        for (TagKey<Block> netherPlantTag : BYGBlockTags.END_PLANT_TAGS) {
            tag(netherPlantTag).add(Blocks.END_STONE).addTag(BYGBlockTags.END_STONE)
                    .addOptionalTag(new ResourceLocation("c", "end_stones"))
                    .addOptionalTag(new ResourceLocation("forge", "end_stones"));
        }

        for (TagKey<Block> netherPlantTag : BYGBlockTags.NETHER_PLANT_TAGS) {
            tag(netherPlantTag).addTag(BlockTags.NYLIUM).add(Blocks.MYCELIUM).add(Blocks.SOUL_SOIL);
        }

        for (TagKey<Block> plantTag : BYGBlockTags.PLANT_TAGS) {
            this.tag(plantTag).addTag(BlockTags.DIRT);
        }
        for (TagKey<Block> plantTag : BYGBlockTags.MUSHROOM_TAGS) {
            this.tag(plantTag).addTag(BlockTags.MUSHROOM_GROW_BLOCK).addTag(BlockTags.DIRT).addTags(BlockTags.BASE_STONE_OVERWORLD);
        }

        for (TagKey<Block> desertPlantTag : BYGBlockTags.SAND_PLANT_TAGS) {
            this.tag(desertPlantTag).addTag(BlockTags.SAND);
        }
        this.tag(BYGBlockTags.GROUND_PALM_SAPLING).addTag(BlockTags.SAND).addTag(BlockTags.DIRT);
        this.tag(BYGBlockTags.GROUND_FAIRY_SLIPPER).addTag(BlockTags.LOGS);
        sortTagsAlphabeticallyAndRemoveDuplicateTagEntries();
    }

    private void sortTagsAlphabeticallyAndRemoveDuplicateTagEntries() {
//        for (Tag.Builder value : this.builders.values()) {
//            List<Tag.BuilderEntry> builderEntries = ((TagBuilderAccess) value).byg_getEntries();
//
//            Set<Tag.BuilderEntry> noDuplicates = new HashSet<>(builderEntries);
//            builderEntries.clear();
//            builderEntries.addAll(noDuplicates);
//            Collections.sort(builderEntries, Comparator.comparing(builderEntry -> builderEntry.entry().toString()));
//        }
    }

    @SafeVarargs
    @SuppressWarnings("ALL")
    private void tag(TagKey<Block> tag, Supplier<? extends Block>... blocks) {
        this.tag(tag).add(Arrays.stream(blocks).map(Supplier::get).toArray(Block[]::new));
    }

    @Override
    public String getName() {
        return "BYG Blocks";
    }
}
