package potionstudios.byg.datagen.providers;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import potionstudios.byg.common.block.BYGBlockFamily;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;


public class BYGModelGenerator extends FabricModelProvider {
    private static final Map<BYGBlockFamily.Variant, BiConsumer<BYGModelGenerator.BlockFamilyProvider,
            BlockFamilyProviderMethod>> SHAPE_CONSUMERS = ImmutableMap.builder()
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
            .put(BYGBlockFamily.Variant.SIGN, BYGModelGenerator.BlockFamilyProvider::sign)
            .put(BYGBlockFamily.Variant.SLAB, BYGModelGenerator.BlockFamilyProvider::slab)
            .put(BYGBlockFamily.Variant.STAIRS, BYGModelGenerator.BlockFamilyProvider::stairs)
            .put(BYGBlockFamily.Variant.PRESSURE_PLATE, BYGModelGenerator.BlockFamilyProvider::pressurePlate)
            .put(BYGBlockFamily.Variant.POLISHED_STAIRS, BYGModelGenerator.BlockFamilyProvider::stairs)
            .put(BYGBlockFamily.Variant.POLISHED_SLAB, BYGModelGenerator.BlockFamilyProvider::slab)
            .put(BYGBlockFamily.Variant.POLISHED_WALL, BYGModelGenerator.BlockFamilyProvider::wall)
            .put(BYGBlockFamily.Variant.TRAPDOOR, BYGModelGenerator.BlockFamilyProvider::trapdoor)
            .put(BYGBlockFamily.Variant.WALL, BYGModelGenerator.BlockFamilyProvider::wall).build();

    private final Map<Block, BYGModelGenerator.BlockStateGeneratorSupplier> fullBlockModelCustomGenerators =
            ImmutableMap.builder()
                    .put(Blocks.STONE, BlockModelGenerators::createMirroredCubeGenerator)
                    .put(Blocks.DEEPSLATE, BlockModelGenerators::createMirroredColumnGenerator)
                    .put(Blocks.MUD_BRICKS, BlockModelGenerators::createNorthWestMirroredCubeGenerator)
                    .build();

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
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }

    public interface BlockFamilyProviderMethod {
        Block getBlock();
        BlockModelGenerators getGenerators();
    }

    public final class BlockFamilyProvider {
        private final TextureMapping mapping;
        private final Map<ModelTemplate, ResourceLocation> models = Maps.newHashMap();
        @Nullable
        private BYGBlockFamily family;
        @Nullable
        private ResourceLocation fullBlock;

        public BlockFamilyProvider(TextureMapping textureMapping) {
            this.mapping = textureMapping;
        }

        public BYGModelGenerator.BlockFamilyProvider fullBlock(BlockFamilyProviderMethod arguments, ModelTemplate modelTemplate) {
            this.fullBlock = modelTemplate.create(arguments.getBlock(), this.mapping, arguments.getGenerators().modelOutput);
            if (fullBlockModelCustomGenerators.containsKey(arguments.getBlock())) {
                arguments.getGenerators().blockStateOutput
                        .accept(
                                fullBlockModelCustomGenerators
                                        .get(arguments.getBlock())
                                        .create(arguments.getBlock(), this.fullBlock, this.mapping, arguments.getGenerators().modelOutput)
                        );
            } else {
                arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), this.fullBlock));
            }

            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider fullBlockCopies(BlockModelGenerators generators, Block... blocks) {
            if (this.fullBlock == null) {
                throw new IllegalStateException("Full block not generated yet");
            } else {
                for(Block block : blocks) {
                    generators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, this.fullBlock));
                    generators.delegateItemModel(block, this.fullBlock);
                }

                return this;
            }
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

        public BYGModelGenerator.BlockFamilyProvider customFence(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.customParticle(arguments.getBlock());
            ResourceLocation resourceLocation = ModelTemplates.CUSTOM_FENCE_POST.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.CUSTOM_FENCE_SIDE_NORTH.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.CUSTOM_FENCE_SIDE_EAST.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.CUSTOM_FENCE_SIDE_SOUTH.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation4 = ModelTemplates.CUSTOM_FENCE_SIDE_WEST.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createCustomFence(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2, resourceLocation3, resourceLocation4));
            ResourceLocation resourceLocation5 = ModelTemplates.CUSTOM_FENCE_INVENTORY.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().delegateItemModel(arguments.getBlock(), resourceLocation5);
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

        public BYGModelGenerator.BlockFamilyProvider customFenceGate(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.customParticle(arguments.getBlock());
            ResourceLocation resourceLocation = ModelTemplates.CUSTOM_FENCE_GATE_OPEN.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.CUSTOM_FENCE_GATE_CLOSED.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.CUSTOM_FENCE_GATE_WALL_OPEN.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.CUSTOM_FENCE_GATE_WALL_CLOSED.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createFenceGate(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2, resourceLocation3, false));
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

        public BYGModelGenerator.BlockFamilyProvider generateFor(BlockModelGenerators generators, BYGBlockFamily blockFamily) {
            this.family = blockFamily;
            blockFamily.getVariants().forEach((variant, block) -> {
                BiConsumer<BYGModelGenerator.BlockFamilyProvider, BlockFamilyProviderMethod> blockFamilyProviderBlockBiConsumer = BYGModelGenerator.SHAPE_CONSUMERS.get(variant);
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

    public static final class WoodProvider {
        private final TextureMapping logMapping;

        public WoodProvider(TextureMapping textureMapping) {
            this.logMapping = textureMapping;
        }

        public BYGModelGenerator.WoodProvider wood(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = this.logMapping.copyAndUpdate(TextureSlot.END, this.logMapping.get(TextureSlot.SIDE));
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(arguments.getBlock(), textureMapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(arguments.getBlock(), resourceLocation));
            return this;
        }

        public BYGModelGenerator.WoodProvider log(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(arguments.getBlock(), this.logMapping, arguments.getGenerators().modelOutput);
            arguments.getGenerators().blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(arguments.getBlock(), resourceLocation));
            return this;
        }

        public BYGModelGenerator.WoodProvider logWithHorizontal(BlockModelGenerators generators, Block block) {
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(block, this.logMapping, generators.modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.CUBE_COLUMN_HORIZONTAL.create(block, this.logMapping, generators.modelOutput);
            generators.blockStateOutput.accept(BlockModelGenerators.createRotatedPillarWithHorizontalVariant(block, resourceLocation, resourceLocation1));
            return this;
        }

        public BYGModelGenerator.WoodProvider logUVLocked(BlockFamilyProviderMethod arguments) {
            arguments.getGenerators().blockStateOutput
                    .accept(BlockModelGenerators.createPillarBlockUVLocked(arguments.getBlock(), this.logMapping, arguments.getGenerators().modelOutput));
            return this;
        }
    }
}
