package potionstudios.byg.datagen.providers.tag;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CampfireBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockProperties;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGMushroomBlock;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.block.sapling.BYGSaplingBlock;
import potionstudios.byg.datagen.util.DatagenUtils;
import potionstudios.byg.datagen.util.PredicatedTagProvider;
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
import java.util.function.Predicate;
import java.util.function.Supplier;

import static potionstudios.byg.common.block.BYGBlocks.*;
import static potionstudios.byg.BYG.createLocation;
import static net.minecraft.tags.BlockTags.create;

@SuppressWarnings("ALL")
public class BYGBlockTagsProvider extends BlockTagsProvider {
    private final TagAppender<Block> logsThatBurn = tag(BlockTags.LOGS_THAT_BURN);
    private final TagAppender<Block> logs = tag(BlockTags.LOGS);

    public BYGBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(
                BYGBlockTags.LUSH,
                LUSH_GRASS_PATH, LUSH_GRASS_BLOCK, LUSH_FARMLAND
        );

        final Material[] shovelMaterials = { Material.DIRT, Material.GRASS, Material.SAND, Material.CLAY };

        new PredicatedTagProvider<>(PROVIDER)
            .forInstance(SlabBlock.class, BYGBlockTags.SLABS)
            .forInstance(StairBlock.class, BlockTags.STAIRS)
            .forInstance(ButtonBlock.class, BlockTags.BUTTONS)
            .forInstance(BYGSaplingBlock.class, BlockTags.SAPLINGS)
            .forInstance(BYGMushroomBlock.class, create(createLocation("mushrooms")))
            .forInstance(BYGBlockProperties.BYGWartBlock.class, BlockTags.WART_BLOCKS)
            .forInstance(CampfireBlock.class, BlockTags.CAMPFIRES)
            .add(isMaterial(shovelMaterials), BlockTags.MINEABLE_WITH_SHOVEL)
            .add(isMaterial(Material.LEAVES), BlockTags.LEAVES)
            .add(isMaterial(Material.SAND), BlockTags.SAND)
            .add(isMaterial(Material.ICE, Material.ICE_SOLID), BlockTags.ICE)
            .run(super::tag);

        tag(BYGBlockTags.GROUND_MANGROVE_TREE).addTags(BlockTags.DIRT, BlockTags.SAND).add(MUD_BLOCK.get(), Blocks.CLAY);

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

        // For now, until we get all wood moved
        final var axeMineable = tag(BlockTags.MINEABLE_WITH_AXE);
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            add(axeMineable, type.bookshelf(), type.button(), type.craftingTable(), type.door(), type.trapdoor(), type.planks(), type.fence(), type.fenceGate(), type.log(), type.wood(), type.strippedLog(), type.strippedWood(),
                    type.pressurePlate(), type.sign(), type.wallSign(), type.slab(), type.stairs());
        }
        add(axeMineable,
                BORIC_CAMPFIRE, SOUL_SHROOM_BLOCK, SOUL_SHROOM_STEM, GREEN_MUSHROOM_BLOCK, IMBUED_NIGHTSHADE_LOG,
                PLANT_STEM, WITHERING_OAK_LOG, WITHERING_OAK_WOOD, DEATH_CAP_MUSHROOM_BLOCK, CRYPTIC_CAMPFIRE,
                PALO_VERDE_LOG, PALO_VERDE_WOOD, STRIPPED_PALO_VERDE_LOG, STRIPPED_PALO_VERDE_WOOD,
                MILKCAP_MUSHROOM_BLOCK, BROWN_MUSHROOM_STEM, FUNGAL_IMPARIUS_HYPHAE, FUNGAL_IMPARIUS_STEM,
                BLEWIT_MUSHROOM_BLOCK, WHITE_MUSHROOM_STEM
        );

        final var planksTag = tag(BlockTags.PLANKS);
        final var bookselvesTag = tag(create(createLocation("bookshelves")));
        final var trapdoorsTag = tag(BlockTags.TRAPDOORS);
        final var woodenButtonsTag = tag(BlockTags.WOODEN_BUTTONS);
        final var woodenDoorsTag = tag(BlockTags.WOODEN_DOORS);
        final var woodenFencesTag = tag(BlockTags.WOODEN_FENCES);
        final var woodenPressurePlatesTag = tag(BlockTags.WOODEN_PRESSURE_PLATES);
        final var woodenSlabsTag = tag(BlockTags.WOODEN_SLABS);
        final var woodenStairsTag = tag(BlockTags.WOODEN_STAIRS);
        final var woodenTrapdoorsTag = tag(BlockTags.WOODEN_TRAPDOORS);
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            tag(type.logTag().block(), type.log(), type.strippedLog(), type.wood(), type.strippedWood());
            logsThatBurn.addTag(type.logTag().block());
            logs.addTag(type.logTag().block());
            planksTag.add(type.planks().get());
            bookselvesTag.add(type.bookshelf().get());

            planksTag.add(type.planks().get());
            trapdoorsTag.add(type.trapdoor().get());
            woodenButtonsTag.add(type.button().get());
            woodenDoorsTag.add(type.door().get());
            woodenFencesTag.add(type.fence().get());
            woodenPressurePlatesTag.add(type.pressurePlate().get());
            woodenSlabsTag.add(type.slab().get());
            woodenStairsTag.add(type.stairs().get());
            woodenTrapdoorsTag.add(type.trapdoor().get());
        }

        wood("withering_oak_logs", WITHERING_OAK_LOG, WITHERING_OAK_WOOD);
        wood("palo_verde_logs", PALO_VERDE_LOG, PALO_VERDE_WOOD, STRIPPED_PALO_VERDE_LOG, STRIPPED_PALO_VERDE_WOOD);

        tag(BlockTags.OAK_LOGS, WITHERING_OAK_LOG, WITHERING_OAK_WOOD);

        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }
    
    private static Predicate<Block> isMaterial(Material... materials) {
        final var materialsList = List.of(materials);
        return bl -> materialsList.contains(((BlockBehaviorAccess) bl).getMaterial());
    }

    @SafeVarargs
    private void wood(String name, Supplier<? extends Block>... blocks) {
        final var tag = create(createLocation("wood/" + name));
        add(tag(tag), blocks);
        logsThatBurn.addTag(tag);
        logs.addTag(tag);
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
        return "BYG Block Tags";
    }
}
