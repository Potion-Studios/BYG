package potionstudios.byg.datagen.providers;

import static potionstudios.byg.common.block.BYGBlocks.BULBIS_PHYCELIUM;
import static potionstudios.byg.common.block.BYGBlocks.ETHER_STONE;
import static potionstudios.byg.common.block.BYGBlocks.IMPARIUS_PHYLIUM;
import static potionstudios.byg.common.block.BYGBlocks.IVIS_PHYLIUM;
import static potionstudios.byg.common.block.BYGBlocks.LUSH_FARMLAND;
import static potionstudios.byg.common.block.BYGBlocks.LUSH_GRASS_BLOCK;
import static potionstudios.byg.common.block.BYGBlocks.LUSH_GRASS_PATH;
import static potionstudios.byg.common.block.BYGBlocks.MUD_BLOCK;
import static potionstudios.byg.common.block.BYGBlocks.NIGHTSHADE_PHYLIUM;
import static potionstudios.byg.common.block.BYGBlocks.PROVIDER;
import static potionstudios.byg.common.block.BYGBlocks.SHULKREN_PHYLIUM;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGWoodType;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.mixin.access.TagBuilderAccess;
import potionstudios.byg.mixin.dev.BlockBehaviorAccess;
import potionstudios.byg.reg.RegistryObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

@SuppressWarnings("ALL")
public class BYGBlockTagsProvider extends BlockTagsProvider {

    public BYGBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, BYG.MOD_ID, existingFileHelper);
    }

    // TODO document what gets generated
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

        final var shovelMaterials = List.of(Material.DIRT, Material.GRASS, Material.SAND, Material.CLAY);
        final var shovelMinable = tag(BlockTags.MINEABLE_WITH_SHOVEL);
        PROVIDER.getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(bl -> shovelMaterials.contains(((BlockBehaviorAccess) bl).getMaterial()))
                .forEach(shovelMinable::add);

// For now, until we get all wood moved
//        final var axeMineable = tag(BlockTags.MINEABLE_WITH_AXE);
//        for (BYGWoodTypes type : BYGWoodTypes.values()) {
//            add(axeMineable, type.bookshelf(), type.button(), type.craftingTable(), type.door(), type.trapdoor(), type.planks(), type.fence(), type.fenceGate(), type.log(), type.wood(), type.strippedLog(), type.strippedWood(), type.pressurePlate(), type.sign(), type.wallSign(), type
//                    .slab(), type.stairs());
//        }

        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            add(tag(TagKey.create(Registry.BLOCK_REGISTRY, BYG.createLocation("wood/" + type + "_logs"))), type.log(), type.strippedLog(), type.wood(), type.strippedWood());
        }

        sortTagsAlphabeticallyAndRemoveDuplicateTagEntries();
    }

    private void sortTagsAlphabeticallyAndRemoveDuplicateTagEntries() {
        for (Tag.Builder value : this.builders.values()) {
            List<Tag.BuilderEntry> builderEntries = ((TagBuilderAccess) value).byg_getEntries();

            Set<Tag.BuilderEntry> noDuplicates = new HashSet<>(builderEntries);
            builderEntries.clear();
            builderEntries.addAll(noDuplicates);
            Collections.sort(builderEntries, Comparator.comparing(builderEntry -> builderEntry.entry().toString()));
        }
    }

    @SafeVarargs
    @SuppressWarnings("ALL")
    private void tag(TagKey<Block> tag, Supplier<? extends Block>... blocks) {
        this.tag(tag).add(Arrays.stream(blocks).filter(Objects::nonNull).map(Supplier::get).toArray(Block[]::new));
    }

    @SafeVarargs
    private <T> void add(TagAppender<T> tag, Supplier<? extends T>... values) {
        for (final var sup : values)
            if (sup != null)
                tag.add(sup.get());
    }

    @Override
    public String getName() {
        return "BYG Blocks";
    }
}
