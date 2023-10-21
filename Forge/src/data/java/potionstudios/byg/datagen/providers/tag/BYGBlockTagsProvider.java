package potionstudios.byg.datagen.providers.tag;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.BYGTags;
import potionstudios.byg.common.block.*;
import potionstudios.byg.common.block.sapling.BYGSaplingBlock;
import potionstudios.byg.datagen.util.DatagenUtils;
import potionstudios.byg.datagen.util.PredicatedTagProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static net.minecraft.tags.BlockTags.TERRACOTTA;
import static net.minecraft.tags.BlockTags.create;
import static potionstudios.byg.BYG.createLocation;
import static potionstudios.byg.common.BYGTags.*;
import static potionstudios.byg.common.block.BYGBlocks.*;

@SuppressWarnings("ALL")
public class BYGBlockTagsProvider extends BlockTagsProvider {
    static final List<ResourceLocation> EXTRA_WOOD_TYPES = new ArrayList<>();

    public BYGBlockTagsProvider(CompletableFuture<HolderLookup.Provider> future, DataGenerator pGenerator, @Nullable ExistingFileHelper existingFileHelper) {
        super(pGenerator.getPackOutput(), future, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        final var logs = tag(BYGTags.LOGS.byg(BYGTags.RegistryType.BLOCKS));
        final var logsThatBurn = tag(BYGTags.LOGS_THAT_BURN.byg(BYGTags.RegistryType.BLOCKS));
        tag(
                BYGBlockTags.LUSH,
                LUSH_GRASS_PATH, LUSH_GRASS_BLOCK, LUSH_FARMLAND
        );


        new PredicatedTagProvider<>(PROVIDER)
                .forInstance(SlabBlock.class, bygTag(SLABS))
                .forInstance(StairBlock.class, bygTag(STAIRS))
                .forInstance(ButtonBlock.class, bygTag(BUTTONS))
                .forInstance(BYGSaplingBlock.class, bygTag(SAPLINGS))
                .forInstance(BYGMushroomBlock.class, BYGBlockTags.MUSHROOMS)
                .forInstance(BYGBlockProperties.BYGWartBlock.class, BlockTags.WART_BLOCKS)
                .forInstance(CampfireBlock.class, bygTag(CAMPFIRES))
                .forInstance(BYGScaffoldingBlock.class, bygTag(SCAFFOLDING))
                .checkRegistryName(name -> name.endsWith("_sand"), bygTag(SAND))
                .checkRegistryName(name -> name.endsWith("_ice"), bygTag(ICE))
                .forInstance(LeavesBlock.class, bygTag(LEAVES))
                .checkRegistryName(name -> name.endsWith("_ore"), bygTag(ORES))
//                .add(isMaterial(shovelMaterials), BlockTags.MINEABLE_WITH_SHOVEL)
                .run(super::tag);

        tag(BlockTags.MINEABLE_WITH_SHOVEL).add(WAILING_NYLIUM.get());
        tag(SCAFFOLDING.all(RegistryType.BLOCKS)).add(Blocks.SCAFFOLDING);

        tag(BYGBlockTags.GROUND_WHITE_MANGROVE_SAPLING).addTags(BlockTags.SAND).add(Blocks.CLAY, Blocks.MUD);
        tag(BYGBlockTags.GROUND_WILLOW_SAPLING).addTags(BlockTags.SAND).add(Blocks.CLAY, Blocks.MUD);
        tag(BYGBlockTags.GROUND_CYPRESS_SAPLING).addTags(BlockTags.SAND).add(Blocks.CLAY, Blocks.MUD);
        tag(BYGBlockTags.GROUND_PALO_VERDE_SAPLING).addTags(BlockTags.SAND).addTag(TERRACOTTA);

        tag(BYGBlockTags.END_STONE).add(ETHER_STONE.get(), BULBIS_PHYCELIUM.get(), NIGHTSHADE_PHYLIUM.get(), IMPARIUS_PHYLIUM.get(), IVIS_PHYLIUM.get(), SHULKREN_PHYLIUM.get(), Blocks.END_STONE);

        for (TagKey<Block> endPlantTag : BYGBlockTags.END_PLANT_TAGS) {
            tag(endPlantTag).add(Blocks.END_STONE).addTag(BYGBlockTags.END_STONE)
                    .addOptionalTag(new ResourceLocation("c", "end_stones"))
                    .addOptionalTag(new ResourceLocation("forge", "end_stones"));
        }

        for (TagKey<Block> netherPlantTag : BYGBlockTags.NETHER_PLANT_TAGS) {
            tag(netherPlantTag).addTag(BlockTags.NYLIUM).add(Blocks.MYCELIUM).add(Blocks.SOUL_SOIL);
        }

        for (TagKey<Block> plantTag : BYGBlockTags.PLANT_TAGS) {
            this.tag(plantTag).addTag(BlockTags.DIRT);
        }
        this.tag(BYGBlockTags.GROUND_WILLOW_SAPLING).add(Blocks.CLAY);

        for (TagKey<Block> plantTag : BYGBlockTags.MUSHROOM_TAGS) {
            this.tag(plantTag).addTag(BlockTags.MUSHROOM_GROW_BLOCK).addTag(BlockTags.DIRT).addTags(BlockTags.BASE_STONE_OVERWORLD);
        }

        for (TagKey<Block> desertPlantTag : BYGBlockTags.SAND_PLANT_TAGS) {
            this.tag(desertPlantTag).addTag(BlockTags.SAND);
        }
        this.tag(BYGBlockTags.GROUND_PALM_SAPLING).addTag(BlockTags.SAND).addTag(BlockTags.DIRT);
        this.tag(BYGBlockTags.GROUND_FAIRY_SLIPPER).addTag(BlockTags.LOGS);

        this.tag(BYGBlockTags.SYTHIAN_STALK_PLANTABLE_ON).add(SYTHIAN_NYLIUM.get(), SYTHIAN_STALK_BLOCK.get(), SYTHIAN_SAPLING.get());

        // For now, until we get all wood moved
        final var axeMineable = tag(BlockTags.MINEABLE_WITH_AXE);
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            add(axeMineable, type.bookshelf(), type.button(), type.craftingTable(), type.door(), type.trapdoor(), type.planks(), type.fence(), type.fenceGate(), type.log(), type.wood(), type.strippedLog(), type.strippedWood(),
                    type.pressurePlate(), type.sign(), type.wallSign(), type.hangingSign(), type.wallHangingSign(), type.slab(), type.stairs());
        }
        add(axeMineable,
                BORIC_CAMPFIRE, SOUL_SHROOM_BLOCK, SOUL_SHROOM_STEM, GREEN_MUSHROOM_BLOCK, IMBUED_NIGHTSHADE_LOG,
                DEATH_CAP_MUSHROOM_BLOCK, CRYPTIC_CAMPFIRE,
                PALO_VERDE_LOG, PALO_VERDE_WOOD, STRIPPED_PALO_VERDE_LOG, STRIPPED_PALO_VERDE_WOOD,
                MILKCAP_MUSHROOM_BLOCK, BROWN_MUSHROOM_STEM, FUNGAL_IMPARIUS_HYPHAE, FUNGAL_IMPARIUS_STEM,
                BLEWIT_MUSHROOM_BLOCK, WHITE_MUSHROOM_STEM, SYTHIAN_SCAFFOLDING, FORAGERS_TABLE
        );

        final var planksTag = tag(BlockTags.PLANKS);
        final var bookselvesTag = tag(bygTag(BOOKSHELVES));
        final var trapdoorsTag = tag(BlockTags.TRAPDOORS);
        final var woodenButtonsTag = tag(BlockTags.WOODEN_BUTTONS);
        final var woodenDoorsTag = tag(BlockTags.WOODEN_DOORS);
        final var woodenFencesTag = tag(BlockTags.WOODEN_FENCES);
        final var woodenFencesGatesTag = tag(BYGBlockTags.WOODEN_FENCE_GATES);
        final var woodenPressurePlatesTag = tag(BlockTags.WOODEN_PRESSURE_PLATES);
        final var woodenSlabsTag = tag(BlockTags.WOODEN_SLABS);
        final var woodenStairsTag = tag(BlockTags.WOODEN_STAIRS);
        final var woodenTrapdoorsTag = tag(BlockTags.WOODEN_TRAPDOORS);
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            tag(type.logTag().block(), type.log(), type.strippedLog(), type.wood(), type.strippedWood());
            logs.addTag(type.logTag().block());
            if (type.isFlammable())
                logsThatBurn.addTag(type.logTag().block());

            planksTag.add(type.planks().get());
            bookselvesTag.add(type.bookshelf().get());

            planksTag.add(type.planks().get());
            trapdoorsTag.add(type.trapdoor().get());
            woodenButtonsTag.add(type.button().get());
            woodenDoorsTag.add(type.door().get());
            woodenFencesTag.add(type.fence().get());
            woodenFencesGatesTag.add(type.fenceGate().get());
            woodenPressurePlatesTag.add(type.pressurePlate().get());
            woodenSlabsTag.add(type.slab().get());
            woodenStairsTag.add(type.stairs().get());
            woodenTrapdoorsTag.add(type.trapdoor().get());
        }
        //TODO for 1.20 remove
        bookselvesTag.add(Blocks.BOOKSHELF);
        tag(BlockTags.FENCE_GATES).addTag(BYGBlockTags.WOODEN_FENCE_GATES);


        wood("palo_verde_logs", PALO_VERDE_LOG, PALO_VERDE_WOOD, STRIPPED_PALO_VERDE_LOG, STRIPPED_PALO_VERDE_WOOD);
        wood("imbued_blue_enchanted_logs", IMBUED_BLUE_ENCHANTED_LOG);
        wood("imbued_green_enchanted_log", IMBUED_GREEN_ENCHANTED_LOG);
        wood("imbued_nightshade_log", IMBUED_NIGHTSHADE_LOG);

        for (BYGTags tag : BYGTags.values()) {
            DatagenUtils.addBYGTag(this::tag, tag, Registries.BLOCK);
        }

        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }

    private static TagKey<Block> bygTag(BYGTags tags) {
        return tags.byg(BYGTags.RegistryType.BLOCKS);
    }

    @SafeVarargs
    private void wood(String name, Supplier<? extends Block>... blocks) {
        final var loc = createLocation(name);
        final var tag = create(loc);
        tag(tag, blocks);
        tag(BlockTags.LOGS).addTag(tag);
        tag(BlockTags.LOGS_THAT_BURN).addTag(tag);
        EXTRA_WOOD_TYPES.add(loc);
    }

    @SafeVarargs
    @SuppressWarnings("ALL")
    private void tag(TagKey<Block> tag, Supplier<? extends Block>... blocks) {
        this.tag(tag).add(Arrays.stream(blocks).filter(Objects::nonNull).map(Supplier::get).toArray(Block[]::new));
    }

    @SafeVarargs
    private <T> void add(TagAppender<T> tag, RegistryObject<T>... values) {
        for (final var sup : values)
            if (sup != null)
                tag.add(sup.getResourceKey());
    }

    @Override
    public String getName() {
        return "BYG Block Tags";
    }
}
