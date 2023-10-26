package potionstudios.byg.datagen.providers;

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlockFamilies;
import potionstudios.byg.common.block.BYGBlockFamily;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;


public class BYGModelGenerator extends FabricModelProvider {
    private static final Map<BYGBlockFamily.Variant,
            BiConsumer<BYGModelGenerator.BlockFamilyProvider, BYGModelGenerator.BlockFamilyProviderMethod>> BLOCK_SHAPE_CONSUMERS =
            ImmutableMap.builder()
            .put(BYGBlockFamily.Variant.BUTTON, BYGModelGenerator.BlockFamilyProvider::button)
            .put(BYGBlockFamily.Variant.DOOR, BYGModelGenerator.BlockFamilyProvider::door)
            .put(BYGBlockFamily.Variant.CUT_STAIRS, BYGModelGenerator.BlockFamilyProvider::stairs)
            .put(BYGBlockFamily.Variant.CUT_SLAB, BYGModelGenerator.BlockFamilyProvider::slab)
            .put(BYGBlockFamily.Variant.CUT_WALL, BYGModelGenerator.BlockFamilyProvider::wall)
            .put(BYGBlockFamily.Variant.CHISELED, BYGModelGenerator.BlockFamilyProvider::fullBlockVariant)
            .put(BYGBlockFamily.Variant.CHISELED_STAIRS, BYGModelGenerator.BlockFamilyProvider::stairs)
            .put(BYGBlockFamily.Variant.CHISELED_SLAB, BYGModelGenerator.BlockFamilyProvider::slab)
            .put(BYGBlockFamily.Variant.CHISELED_WALL, BYGModelGenerator.BlockFamilyProvider::wall)
            .put(BYGBlockFamily.Variant.CRACKED, BYGModelGenerator.BlockFamilyProvider::fullBlockVariant)
            .put(BYGBlockFamily.Variant.CRACKED_STAIRS, BYGModelGenerator.BlockFamilyProvider::stairs)
            .put(BYGBlockFamily.Variant.CRACKED_SLAB, BYGModelGenerator.BlockFamilyProvider::slab)
            .put(BYGBlockFamily.Variant.CRACKED_WALL, BYGModelGenerator.BlockFamilyProvider::wall)
            .put(BYGBlockFamily.Variant.FENCE, BYGModelGenerator.BlockFamilyProvider::fence)
            .put(BYGBlockFamily.Variant.FENCE_GATE, BYGModelGenerator.BlockFamilyProvider::fenceGate)
            .put(BYGBlockFamily.Variant.PRESSURE_PLATE, BYGModelGenerator.BlockFamilyProvider::pressurePlate)
            .put(BYGBlockFamily.Variant.POLISHED_STAIRS, BYGModelGenerator.BlockFamilyProvider::stairs)
            .put(BYGBlockFamily.Variant.POLISHED_SLAB, BYGModelGenerator.BlockFamilyProvider::slab)
            .put(BYGBlockFamily.Variant.POLISHED_WALL, BYGModelGenerator.BlockFamilyProvider::wall)
            .put(BYGBlockFamily.Variant.SIGN, BYGModelGenerator.BlockFamilyProvider::sign)
            .put(BYGBlockFamily.Variant.SLAB, BYGModelGenerator.BlockFamilyProvider::slab)
            .put(BYGBlockFamily.Variant.STAIRS, BYGModelGenerator.BlockFamilyProvider::stairs)
            .put(BYGBlockFamily.Variant.TRAPDOOR, BYGModelGenerator.BlockFamilyProvider::trapdoor)
            .put(BYGBlockFamily.Variant.WALL, BYGModelGenerator.BlockFamilyProvider::wall)
            .build();

    private static final Map<BYGBlockFamily.Variant,
            BiConsumer<BYGModelGenerator.WoodProvider, BYGModelGenerator.BlockFamilyProviderMethod>> WOOD_SHAPE_CONSUMERS =
            ImmutableMap.builder()
            .put(BYGBlockFamily.Variant.BOOKSHELF, BYGModelGenerator.WoodProvider::bookshelf)
            .put(BYGBlockFamily.Variant.BUTTON, BYGModelGenerator.WoodProvider::button)
            .put(BYGBlockFamily.Variant.DOOR, BYGModelGenerator.WoodProvider::door)
            .put(BYGBlockFamily.Variant.CRAFTING_TABLE, BYGModelGenerator.WoodProvider::craftingTable)
            .put(BYGBlockFamily.Variant.FENCE, BYGModelGenerator.WoodProvider::fence)
            .put(BYGBlockFamily.Variant.FENCE_GATE, BYGModelGenerator.WoodProvider::fenceGate)
            .put(BYGBlockFamily.Variant.GROWER, BYGModelGenerator.WoodProvider::growerItem)
            .put(BYGBlockFamily.Variant.LOG, BYGModelGenerator.WoodProvider::log)
            .put(BYGBlockFamily.Variant.POTTED, BYGModelGenerator.WoodProvider::potted)
            .put(BYGBlockFamily.Variant.PRESSURE_PLATE, BYGModelGenerator.WoodProvider::pressurePlate)
            .put(BYGBlockFamily.Variant.SIGN, BYGModelGenerator.WoodProvider::sign)
            .put(BYGBlockFamily.Variant.SLAB, BYGModelGenerator.WoodProvider::slab)
            .put(BYGBlockFamily.Variant.STAIRS, BYGModelGenerator.WoodProvider::stairs)
            .put(BYGBlockFamily.Variant.STRIPPED_LOG, BYGModelGenerator.WoodProvider::log)
            .put(BYGBlockFamily.Variant.STRIPPED_WOOD, BYGModelGenerator.WoodProvider::wood)
            .put(BYGBlockFamily.Variant.TRAPDOOR, BYGModelGenerator.WoodProvider::trapdoor)
            .put(BYGBlockFamily.Variant.WOOD, BYGModelGenerator.WoodProvider::wood)
            .build();

    private final Map<Block, BYGModelGenerator.BlockStateGeneratorSupplier> fullBlockModelCustomGenerators =
            new HashMap<>();

    private final Map<Block, TexturedModel> texturedModels = new HashMap<>();

    @FunctionalInterface
    interface BlockStateGeneratorSupplier {
        BlockStateGenerator create(Block var1, ResourceLocation var2, TextureMapping var3, BiConsumer<ResourceLocation, Supplier<JsonElement>> var4);
    }

    public BYGModelGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        woodFamily().generateFor(blockStateModelGenerator, BYGBlockFamilies.HOLLY);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }

    public final BYGModelGenerator.BlockFamilyProvider family(BlockModelGenerators generators, Block block) {
        TexturedModel texturedModel = this.texturedModels.getOrDefault(block, TexturedModel.CUBE.get(block));
        return new BYGModelGenerator.BlockFamilyProvider(texturedModel.getMapping())
                .fullBlock(block, texturedModel.getTemplate(), generators);
    }

    @Contract(" -> new")
    public final BYGModelGenerator.@NotNull WoodProvider woodFamily() {
        return new BYGModelGenerator.WoodProvider();
    }

    public interface BlockFamilyProviderMethod {
        Block getBlock();
        BlockModelGenerators getGenerators();
    }

    public final class BlockFamilyProvider {
        private final TextureMapping mapping;
        private final Map<ModelTemplate, ResourceLocation> models = new HashMap<>();
        @Nullable
        private BYGBlockFamily family;
        @Nullable
        private ResourceLocation fullBlock;

        public BlockFamilyProvider(TextureMapping textureMapping) {
            this.mapping = textureMapping;
        }

        @SuppressWarnings("unused")
        public BYGModelGenerator.BlockFamilyProvider fullBlock(Block block, ModelTemplate modelTemplate,
                                                                  BlockModelGenerators generator) {
            this.fullBlock = modelTemplate.create(block, this.mapping, generator.modelOutput);
            if (fullBlockModelCustomGenerators.containsKey(block)) {
                generator.blockStateOutput.accept(fullBlockModelCustomGenerators.get(block).create(block, this.fullBlock,
                        this.mapping, generator.modelOutput));
            } else {
                generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, this.fullBlock));
            }
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider button(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.BUTTON.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.BUTTON_PRESSED.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createButton(arguments.getBlock(), resourceLocation, resourceLocation1));
            ResourceLocation resourceLocation2 = ModelTemplates.BUTTON_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider wall(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.WALL_POST.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.WALL_LOW_SIDE.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.WALL_TALL_SIDE.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createWall(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2));
            ResourceLocation resourceLocation3 = ModelTemplates.WALL_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation3);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider fence(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.FENCE_POST.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.FENCE_SIDE.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createFence(arguments.getBlock(), resourceLocation, resourceLocation1));
            ResourceLocation resourceLocation2 = ModelTemplates.FENCE_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider fenceGate(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.FENCE_GATE_OPEN.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.FENCE_GATE_CLOSED.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.FENCE_GATE_WALL_OPEN.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.FENCE_GATE_WALL_CLOSED.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createFenceGate(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2, resourceLocation3, true));
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider pressurePlate(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.PRESSURE_PLATE_UP.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.PRESSURE_PLATE_DOWN.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createPressurePlate(arguments.getBlock(), resourceLocation, resourceLocation1));
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider sign(BlockFamilyProviderMethod arguments) {
            if (this.family == null) {
                throw new IllegalStateException("Family not defined");
            } else {
                Block block1 = this.family.getVariants().get(BYGBlockFamily.Variant.WALL_SIGN);
                ResourceLocation resourceLocation = ModelTemplates.PARTICLE_ONLY.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
                arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
                arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block1, resourceLocation));
                arguments.getGenerators().createSimpleFlatItemModel(arguments.getBlock().asItem());
                arguments.getGenerators().skipAutoItemBlock(block1);
                return this;
            }
        }

        public BYGModelGenerator.BlockFamilyProvider slab(BlockFamilyProviderMethod arguments) {
            if (this.fullBlock == null) {
                throw new IllegalStateException("Full block not generated yet");
            } else {
                ResourceLocation resourceLocation = getOrCreateModel(arguments.getGenerators(), ModelTemplates.SLAB_BOTTOM, arguments.getBlock());
                ResourceLocation resourceLocation1 = getOrCreateModel(arguments.getGenerators(), ModelTemplates.SLAB_TOP, arguments.getBlock());
                arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createSlab(arguments.getBlock(), resourceLocation, resourceLocation1, this.fullBlock));
                arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation);
                return this;
            }
        }

        public BYGModelGenerator.BlockFamilyProvider stairs(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = getOrCreateModel(arguments.getGenerators(), ModelTemplates.STAIRS_INNER, arguments.getBlock());
            ResourceLocation resourceLocation1 = getOrCreateModel(arguments.getGenerators(), ModelTemplates.STAIRS_STRAIGHT, arguments.getBlock());
            ResourceLocation resourceLocation2 = getOrCreateModel(arguments.getGenerators(), ModelTemplates.STAIRS_OUTER, arguments.getBlock());
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createStairs(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2));
            arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation1);
            return this;
        }

        private BYGModelGenerator.BlockFamilyProvider fullBlockVariant(BlockFamilyProviderMethod arguments) {
            TexturedModel texturedModel = texturedModels.getOrDefault(arguments.getBlock(), TexturedModel.CUBE.get(arguments.getBlock()));
            arguments.getGenerators().blockStateOutput
                    .accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), texturedModel.create(arguments.getBlock(), arguments.getGenerators().modelOutput)));
            return this;
        }

        private BYGModelGenerator.BlockFamilyProvider door(BlockFamilyProviderMethod arguments) {
            arguments.getGenerators().createDoor(arguments.getBlock());
            return this;
        }

        private void trapdoor(BlockFamilyProviderMethod arguments) {
            arguments.getGenerators().createOrientableTrapdoor(arguments.getBlock());
        }

        private ResourceLocation getOrCreateModel(BlockModelGenerators generators, ModelTemplate modelTemplate, Block block) {
            return this.models.computeIfAbsent(modelTemplate, template -> template.create(block, this.mapping, generators.modelOutput));
        }

        @SuppressWarnings("unused")
        public BYGModelGenerator.BlockFamilyProvider generateFor(BlockModelGenerators generators, BYGBlockFamily blockFamily) {
            this.family = blockFamily;
            blockFamily.getVariants().forEach((variant, block) -> {
                BiConsumer<BYGModelGenerator.BlockFamilyProvider, BlockFamilyProviderMethod> blockFamilyProviderBlockBiConsumer =
                        BYGModelGenerator.BLOCK_SHAPE_CONSUMERS.get(variant);
                if (blockFamilyProviderBlockBiConsumer != null) {
                    blockFamilyProviderBlockBiConsumer.accept(this, new BlockFamilyProviderMethod() {
                        @Override
                        public Block getBlock() {
                            return block;
                        }

                        @Override
                        public BlockModelGenerators getGenerators() {
                            return generators;
                        }
                    });
                }
            });
            return this;
        }
    }

    public final class WoodProvider {
        private TextureMapping mapping;
        private final Map<ModelTemplate, ResourceLocation> models = new HashMap<>();
        @Nullable
        private BYGBlockFamily family;

        @Nullable
        private ResourceLocation fullBlock;

        public WoodProvider() {
        }

        @SuppressWarnings("unused")
        private BYGModelGenerator.WoodProvider fullBlock(Block block, ModelTemplate modelTemplate,
                                                               BlockModelGenerators generator) {
            this.fullBlock = modelTemplate.create(block, this.mapping, generator.modelOutput);
            if (fullBlockModelCustomGenerators.containsKey(block)) {
                generator.blockStateOutput.accept(fullBlockModelCustomGenerators.get(block).create(block, this.fullBlock,
                        this.mapping, generator.modelOutput));
            } else {
                generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, this.fullBlock));
            }
            return this;
        }

        public BYGModelGenerator.WoodProvider bookshelf(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.column(TextureMapping.getBlockTexture(arguments.getBlock()), TextureMapping.getBlockTexture(Blocks.OAK_PLANKS));
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
            return this;
        }

        public BYGModelGenerator.WoodProvider button(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.BUTTON.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.BUTTON_PRESSED.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createButton(arguments.getBlock(), resourceLocation, resourceLocation1));
            ResourceLocation resourceLocation2 = ModelTemplates.BUTTON_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        @SuppressWarnings("DataFlowIssue")
        public BYGModelGenerator.WoodProvider craftingTable(BlockFamilyProviderMethod arguments) {
            arguments.getGenerators().createCraftingTableLike(arguments.getBlock(),
                    family.get(BYGBlockFamily.Variant.PLANKS), TextureMapping::craftingTable);
            return this;
        }

        private BYGModelGenerator.WoodProvider door(BlockFamilyProviderMethod arguments) {
            arguments.getGenerators().createDoor(arguments.getBlock());
            return this;
        }

        public BYGModelGenerator.WoodProvider fence(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.FENCE_POST.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.FENCE_SIDE.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createFence(arguments.getBlock(), resourceLocation, resourceLocation1));
            ResourceLocation resourceLocation2 = ModelTemplates.FENCE_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        public BYGModelGenerator.WoodProvider fenceGate(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.FENCE_GATE_OPEN.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.FENCE_GATE_CLOSED.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.FENCE_GATE_WALL_OPEN.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.FENCE_GATE_WALL_CLOSED.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createFenceGate(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2, resourceLocation3, true));
            return this;
        }

        public BYGModelGenerator.WoodProvider growerItem(BlockFamilyProviderMethod arguments) {
            arguments.getGenerators().createCrossBlock(arguments.getBlock(),
                    BlockModelGenerators.TintState.NOT_TINTED);
            return this;
        }

        public BYGModelGenerator.WoodProvider log(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(arguments.getBlock(), resourceLocation));
            return this;
        }

        public BYGModelGenerator.WoodProvider logWithHorizontal(BlockModelGenerators generators, Block block) {
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(block, this.mapping, generators.modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, this.mapping, generators.modelOutput);
            generators.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(block, resourceLocation, resourceLocation1));
            return this;
        }

        public BYGModelGenerator.WoodProvider logUVLocked(BlockFamilyProviderMethod arguments) {
            arguments.getGenerators().blockStateOutput
                    .accept(BlockModelGenerators.createPillarBlockUVLocked(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput));
            return this;
        }

        public BYGModelGenerator.WoodProvider potted(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping
                    .plant(this.family.get(BYGBlockFamily.Variant.GROWER));
            ResourceLocation resourceLocation = BlockModelGenerators.TintState.NOT_TINTED
                    .getCrossPot().create(arguments.getBlock(), textureMapping, arguments
                    .getGenerators().modelOutput);
            arguments.getGenerators()
                    .blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
            return this;
        }

        public BYGModelGenerator.WoodProvider pressurePlate(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.PRESSURE_PLATE_UP.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.PRESSURE_PLATE_DOWN.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createPressurePlate(arguments.getBlock(), resourceLocation, resourceLocation1));
            return this;
        }

        public BYGModelGenerator.WoodProvider sign(BlockFamilyProviderMethod arguments) {
            if (this.family == null) {
                throw new IllegalStateException("Family not defined");
            } else {
                Block block1 = this.family.getVariants().get(BYGBlockFamily.Variant.WALL_SIGN);
                ResourceLocation resourceLocation = ModelTemplates.PARTICLE_ONLY.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
                arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
                arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block1, resourceLocation));
                arguments.getGenerators().createSimpleFlatItemModel(arguments.getBlock().asItem());
                arguments.getGenerators().skipAutoItemBlock(block1);
                return this;
            }
        }

        public BYGModelGenerator.WoodProvider slab(BlockFamilyProviderMethod arguments) {
            if (this.fullBlock == null) {
                throw new IllegalStateException("Full block not generated yet");
            } else {
                ResourceLocation resourceLocation = getOrCreateModel(arguments.getGenerators(), ModelTemplates.SLAB_BOTTOM, arguments.getBlock());
                ResourceLocation resourceLocation1 = getOrCreateModel(arguments.getGenerators(), ModelTemplates.SLAB_TOP, arguments.getBlock());
                arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createSlab(arguments.getBlock(), resourceLocation, resourceLocation1, this.fullBlock));
                arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation);
                return this;
            }
        }

        public BYGModelGenerator.WoodProvider stairs(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = getOrCreateModel(arguments.getGenerators(), ModelTemplates.STAIRS_INNER, arguments.getBlock());
            ResourceLocation resourceLocation1 = getOrCreateModel(arguments.getGenerators(), ModelTemplates.STAIRS_STRAIGHT, arguments.getBlock());
            ResourceLocation resourceLocation2 = getOrCreateModel(arguments.getGenerators(), ModelTemplates.STAIRS_OUTER, arguments.getBlock());
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createStairs(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2));
            arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation1);
            return this;
        }

        private void trapdoor(BlockFamilyProviderMethod arguments) {
            arguments.getGenerators().createOrientableTrapdoor(arguments.getBlock());
        }

        private ResourceLocation getOrCreateModel(BlockModelGenerators generators, ModelTemplate modelTemplate, Block block) {
            return this.models.computeIfAbsent(modelTemplate, template -> template.create(block, this.mapping, generators.modelOutput));
        }

        public BYGModelGenerator.WoodProvider wood(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = this.mapping.copyAndUpdate(TextureSlot.END, this.mapping.get(TextureSlot.SIDE));
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(arguments.getBlock(), resourceLocation));
            return this;
        }

        @SuppressWarnings("unused")
        public BYGModelGenerator.WoodProvider generateFor(BlockModelGenerators generators, BYGBlockFamily blockFamily) {
            this.family = blockFamily;
            Block plank = family.get(BYGBlockFamily.Variant.PLANKS);
            TexturedModel planksModel = texturedModels
                    .getOrDefault(plank, TexturedModel.CUBE.get(plank));
            mapping = planksModel.getMapping();
            fullBlock(plank, planksModel.getTemplate(), generators);
            blockFamily.getVariants().forEach((variant, block) -> {
                BiConsumer<BYGModelGenerator.WoodProvider, BlockFamilyProviderMethod> blockFamilyProviderBlockBiConsumer =
                        BYGModelGenerator.WOOD_SHAPE_CONSUMERS.get(variant);
                if (blockFamilyProviderBlockBiConsumer != null) {
                    blockFamilyProviderBlockBiConsumer.accept(this, new BlockFamilyProviderMethod() {
                        @Override
                        public Block getBlock() {
                            return block;
                        }

                        @Override
                        public BlockModelGenerators getGenerators() {
                            return generators;
                        }
                    });
                } else {
                    TexturedModel texturedModel = texturedModels
                            .getOrDefault(family.get(BYGBlockFamily.Variant.PLANKS),
                                    TexturedModel.CUBE.get(family.get(BYGBlockFamily.Variant.PLANKS)));
                    fullBlock(block, texturedModel.getTemplate(), generators);
                }
            });
            return this;
        }
    }
}
