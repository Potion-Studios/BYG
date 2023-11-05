package potionstudios.byg.datagen.providers;

import com.google.gson.JsonElement;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.data.models.model.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.registration.BYGBlockFamilies;
import potionstudios.byg.common.registration.BYGBlockFamily;
import potionstudios.byg.datagen.providers.interfaces.BlockFamilyProviderMethod;
import potionstudios.byg.datagen.providers.interfaces.ItemFamilyProviderMethod;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;


public class BYGModelGenerator extends FabricModelProvider {

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
        for(BYGBlockFamily blockFamily: BYGBlockFamilies.woodFamilyMap.values()) {
            woodFamily().generateFor(blockStateModelGenerator, blockFamily);
        }
        for(BYGBlockFamily blockFamily: BYGBlockFamilies.blockFamilyMap.values()) {
            family().generateFor(blockStateModelGenerator, blockFamily);
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
        for(BYGBlockFamily blockFamily: BYGBlockFamilies.woodFamilyMap.values()) {
            itemFamily().generateFor(itemModelGenerator, blockFamily);
        }
    }

    public final BYGModelGenerator.BlockFamilyProvider family() {
        return new BYGModelGenerator.BlockFamilyProvider();
    }

    @Contract(" -> new")
    public final @NotNull OrganicProvider woodFamily() {
        return new OrganicProvider();
    }

    public final BYGModelGenerator.ItemFamilyProvider itemFamily() {
        return new BYGModelGenerator.ItemFamilyProvider();
    }

    public final class ItemFamilyProvider {

        private BYGBlockFamily family;

        public BYGModelGenerator.ItemFamilyProvider flatItem(ItemFamilyProviderMethod arguments) {
            arguments.getGenerator().generateFlatItem(arguments.getItem(), ModelTemplates.FLAT_ITEM);
            return this;
        }

        private BYGModelGenerator.ItemFamilyProvider executeGeneration(BYGBlockFamily.ItemVariant itemVariant,
                                                                        ItemFamilyProviderMethod providerMethod) {

            return switch (itemVariant) {
                default -> flatItem(providerMethod);
            };
        }

        @SuppressWarnings("unused")
        public BYGModelGenerator.ItemFamilyProvider generateFor(ItemModelGenerators generator, BYGBlockFamily blockFamily) {
            this.family = blockFamily;
            blockFamily.getItemVariants().forEach((itemVariant, item) -> executeGeneration(itemVariant,
                    new ItemFamilyProviderMethod() {
                @Override
                public Item getItem() {
                    return item;
                }

                @Override
                public ItemModelGenerators getGenerator() {
                    return generator;
                }
            }));
            return this;
        }

    }

    public final class BlockFamilyProvider {
        private TextureMapping mapping;
        private final Map<ModelTemplate, ResourceLocation> models = new HashMap<>();
        @Nullable
        private BYGBlockFamily family;
        @Nullable
        private ResourceLocation fullBlock;

        public BlockFamilyProvider() {}

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
            generator.delegateItemModel(block, this.fullBlock);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider button(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.BUTTON.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.BUTTON_PRESSED.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createButton(arguments.getBlock(), resourceLocation, resourceLocation1));
            ResourceLocation resourceLocation2 = ModelTemplates.BUTTON_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider wall(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.WALL_POST.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.WALL_LOW_SIDE.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.WALL_TALL_SIDE.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createWall(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2));
            ResourceLocation resourceLocation3 = ModelTemplates.WALL_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation3);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider fence(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.FENCE_POST.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.FENCE_SIDE.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createFence(arguments.getBlock(), resourceLocation, resourceLocation1));
            ResourceLocation resourceLocation2 = ModelTemplates.FENCE_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider fenceGate(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.FENCE_GATE_OPEN.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.FENCE_GATE_CLOSED.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.FENCE_GATE_WALL_OPEN.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.FENCE_GATE_WALL_CLOSED.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(
                    BlockModelGenerators.createFenceGate(arguments.getBlock(), resourceLocation, resourceLocation1,
                            resourceLocation2, resourceLocation3, true));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation1);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider pressurePlate(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.PRESSURE_PLATE_UP.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.PRESSURE_PLATE_DOWN.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createPressurePlate(arguments.getBlock(), resourceLocation, resourceLocation1));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        public BYGModelGenerator.BlockFamilyProvider slab(BlockFamilyProviderMethod arguments) {
            if (this.fullBlock == null) {
                throw new IllegalStateException("Full block not generated yet");
            } else {
                ResourceLocation resourceLocation = getOrCreateModel(arguments.getGenerator(), ModelTemplates.SLAB_BOTTOM, arguments.getBlock());
                ResourceLocation resourceLocation1 = getOrCreateModel(arguments.getGenerator(), ModelTemplates.SLAB_TOP, arguments.getBlock());
                arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSlab(arguments.getBlock(), resourceLocation, resourceLocation1, this.fullBlock));
                arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
                return this;
            }
        }

        public BYGModelGenerator.BlockFamilyProvider stairs(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = getOrCreateModel(arguments.getGenerator(), ModelTemplates.STAIRS_INNER, arguments.getBlock());
            ResourceLocation resourceLocation1 = getOrCreateModel(arguments.getGenerator(), ModelTemplates.STAIRS_STRAIGHT, arguments.getBlock());
            ResourceLocation resourceLocation2 = getOrCreateModel(arguments.getGenerator(), ModelTemplates.STAIRS_OUTER, arguments.getBlock());
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createStairs(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation1);
            return this;
        }

        private BYGModelGenerator.BlockFamilyProvider fullBlockVariant(BlockFamilyProviderMethod arguments) {
            TexturedModel texturedModel = texturedModels.getOrDefault(arguments.getBlock(),
                    TexturedModel.CUBE.get(arguments.getBlock()));
            ResourceLocation resourceLocation = texturedModel.create(arguments.getBlock(), arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(),
                    resourceLocation));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        private BYGModelGenerator.BlockFamilyProvider door(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.door(arguments.getBlock());
            ResourceLocation resourceLocation = ModelTemplates.DOOR_BOTTOM_LEFT.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.DOOR_BOTTOM_LEFT_OPEN.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.DOOR_BOTTOM_RIGHT.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation4 = ModelTemplates.DOOR_BOTTOM_RIGHT_OPEN.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation5 = ModelTemplates.DOOR_TOP_LEFT.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation6 = ModelTemplates.DOOR_TOP_LEFT_OPEN.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation7 = ModelTemplates.DOOR_TOP_RIGHT.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation8 = ModelTemplates.DOOR_TOP_RIGHT_OPEN.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().createSimpleFlatItemModel(arguments.getBlock().asItem());
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createDoor(arguments.getBlock(), resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4, resourceLocation5, resourceLocation6, resourceLocation7, resourceLocation8));

            return this;
        }

        private BYGModelGenerator.BlockFamilyProvider trapdoor(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.defaultTexture(arguments.getBlock());
            ResourceLocation resourceLocation = ModelTemplates.ORIENTABLE_TRAPDOOR_TOP.create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.ORIENTABLE_TRAPDOOR_BOTTOM.create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.ORIENTABLE_TRAPDOOR_OPEN.create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createOrientableTrapdoor(arguments.getBlock(), resourceLocation, resourceLocation2, resourceLocation3));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        private BYGModelGenerator.BlockFamilyProvider none(BlockFamilyProviderMethod arguments) {
            return this;
        }

        private ResourceLocation getOrCreateModel(BlockModelGenerators generators, ModelTemplate modelTemplate, Block block) {
            return this.models.computeIfAbsent(modelTemplate, template -> template.create(block, this.mapping, generators.modelOutput));
        }

        private BYGModelGenerator.BlockFamilyProvider executeGeneration(BYGBlockFamily.BlockVariant blockVariant,
                                                                        BlockFamilyProviderMethod providerMethod) {

            return switch (blockVariant) {
                case BUTTON -> button(providerMethod);
                case CARVED_STAIRS, COBBLED_STAIRS, CRACKED_STAIRS, CUT_STAIRS, CHISELED_STAIRS, POLISHED_STAIRS, STAIRS -> stairs(providerMethod);
                case CARVED_SLAB, COBBLED_SLAB, CRACKED_SLAB, CUT_SLAB, CHISELED_SLAB, POLISHED_SLAB, SLAB -> slab(providerMethod);
                case CARVED_WALL, COBBLED_WALL, CRACKED_WALL, CUT_WALL, CHISELED_WALL, POLISHED_WALL, WALL -> wall(providerMethod);
                case DOOR -> door(providerMethod);
                case FENCE -> fence(providerMethod);
                case FENCE_GATE -> fenceGate(providerMethod);
                case GROWTH, TENDRILS -> none(providerMethod);
                case PRESSURE_PLATE -> pressurePlate(providerMethod);
                case TRAPDOOR -> trapdoor(providerMethod);
                default -> fullBlockVariant(providerMethod);
            };
        }

        @SuppressWarnings("unused")
        public BYGModelGenerator.BlockFamilyProvider generateFor(BlockModelGenerators generators, BYGBlockFamily blockFamily) {
            this.family = blockFamily;
            Block baseBlock = family.get(BYGBlockFamily.BlockVariant.BASE_BLOCK);
            TexturedModel baseBlockModel = texturedModels
                    .getOrDefault(baseBlock, TexturedModel.CUBE.get(baseBlock));
            mapping = baseBlockModel.getMapping();
            fullBlock(baseBlock, baseBlockModel.getTemplate(), generators);

            blockFamily.getVariants().forEach((blockVariant, block) ->  {

                if(!(blockVariant.equals(BYGBlockFamily.BlockVariant.BASE_BLOCK))) {
                    executeGeneration(blockVariant, new BlockFamilyProviderMethod() {
                        @Override
                        public Block getBlock() {
                            return block;
                        }

                        @Override
                        public BlockModelGenerators getGenerator() {
                            return generators;
                        }
                    });
                }
            });
            return this;
        }
    }

    public final class OrganicProvider {
        private TextureMapping mapping;
        private final Map<ModelTemplate, ResourceLocation> models = new HashMap<>();
        @Nullable
        private BYGBlockFamily family;
        @Nullable
        private ResourceLocation fullBlock;

        public OrganicProvider() {}

        @SuppressWarnings("unused")
        private OrganicProvider fullBlock(Block block, ModelTemplate modelTemplate,
                                          BlockModelGenerators generator) {
            this.fullBlock = modelTemplate.create(block, this.mapping, generator.modelOutput);
            if (fullBlockModelCustomGenerators.containsKey(block)) {
                generator.blockStateOutput.accept(fullBlockModelCustomGenerators.get(block).create(block, this.fullBlock,
                        this.mapping, generator.modelOutput));
            } else {
                generator.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, this.fullBlock));
            }
            generator.delegateItemModel(block, this.fullBlock);
            return this;
        }

        public OrganicProvider bookshelf(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.column(TextureMapping.getBlockTexture(arguments.getBlock()),
                    TextureMapping.getBlockTexture(this.family.get(BYGBlockFamily.BlockVariant.PLANKS)));
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        public OrganicProvider button(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.BUTTON.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.BUTTON_PRESSED.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createButton(arguments.getBlock(), resourceLocation, resourceLocation1));
            ResourceLocation resourceLocation2 = ModelTemplates.BUTTON_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        @SuppressWarnings("DataFlowIssue")
        public OrganicProvider craftingTable(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.craftingTable(arguments.getBlock(),
                    family.get(BYGBlockFamily.BlockVariant.PLANKS));
            ResourceLocation resourceLocation = ModelTemplates.CUBE.create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        private OrganicProvider door(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.door(arguments.getBlock());
            ResourceLocation resourceLocation = ModelTemplates.DOOR_BOTTOM_LEFT.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.DOOR_BOTTOM_LEFT_OPEN.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.DOOR_BOTTOM_RIGHT.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation4 = ModelTemplates.DOOR_BOTTOM_RIGHT_OPEN.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation5 = ModelTemplates.DOOR_TOP_LEFT.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation6 = ModelTemplates.DOOR_TOP_LEFT_OPEN.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation7 = ModelTemplates.DOOR_TOP_RIGHT.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation8 = ModelTemplates.DOOR_TOP_RIGHT_OPEN.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().createSimpleFlatItemModel(arguments.getBlock().asItem());
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createDoor(arguments.getBlock(), resourceLocation, resourceLocation2, resourceLocation3, resourceLocation4, resourceLocation5, resourceLocation6, resourceLocation7, resourceLocation8));

            return this;
        }

        public OrganicProvider fence(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.FENCE_POST.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.FENCE_SIDE.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createFence(arguments.getBlock(), resourceLocation, resourceLocation1));
            ResourceLocation resourceLocation2 = ModelTemplates.FENCE_INVENTORY.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        public OrganicProvider fenceGate(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.FENCE_GATE_OPEN.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.FENCE_GATE_CLOSED.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.FENCE_GATE_WALL_OPEN.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.FENCE_GATE_WALL_CLOSED.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(
                    BlockModelGenerators.createFenceGate(arguments.getBlock(), resourceLocation, resourceLocation1,
                            resourceLocation2, resourceLocation3, true));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation1);
            return this;
        }

        public OrganicProvider carpet(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = TexturedModel.CARPET
                    .get(family.get(BYGBlockFamily.BlockVariant.LEAVES))
                    .create(arguments.getBlock(), arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput
                    .accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        private OrganicProvider fullBlockVariant(BlockFamilyProviderMethod arguments) {
            TexturedModel texturedModel = texturedModels.getOrDefault(arguments.getBlock(),
                    TexturedModel.CUBE.get(arguments.getBlock()));
            ResourceLocation resourceLocation = texturedModel.create(arguments.getBlock(), arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(),
                    resourceLocation));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        private OrganicProvider fullBlockVariantNoItem(BlockFamilyProviderMethod arguments) {
            TexturedModel texturedModel = texturedModels.getOrDefault(arguments.getBlock(),
                    TexturedModel.CUBE.get(arguments.getBlock()));
            ResourceLocation resourceLocation = texturedModel.create(arguments.getBlock(), arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(),
                    resourceLocation));
            return this;
        }

        public OrganicProvider crossBlock(BlockFamilyProviderMethod arguments) {
            arguments.getGenerator().createCrossBlock(arguments.getBlock(),
                    BlockModelGenerators.TintState.NOT_TINTED);
            arguments.getGenerator().createSimpleFlatItemModel(arguments.getBlock().asItem());
            return this;
        }

        public OrganicProvider crossBlockNoItem(BlockFamilyProviderMethod arguments) {
            arguments.getGenerator().createCrossBlock(arguments.getBlock(),
                    BlockModelGenerators.TintState.NOT_TINTED);
            return this;
        }

        public OrganicProvider doublePlant(BlockFamilyProviderMethod arguments) {
            arguments.getGenerator().createDoublePlant(arguments.getBlock(), BlockModelGenerators.TintState.TINTED);
            return this;
        }

        public OrganicProvider hangingSign(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.particle(this.family.getVariants()
                    .get(BYGBlockFamily.BlockVariant.STRIPPED_LOG));
            Block block1 = this.family.getVariants().get(BYGBlockFamily.BlockVariant.WALL_HANGING_SIGN);
            ResourceLocation resourceLocation = ModelTemplates.PARTICLE_ONLY.create(arguments.getBlock(),
                    textureMapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block1, resourceLocation));
            arguments.getGenerator().createSimpleFlatItemModel(arguments.getBlock());
            arguments.getGenerator().skipAutoItemBlock(block1);
            return this;
        }

        public OrganicProvider log(BlockFamilyProviderMethod arguments) {
            TexturedModel logColumn = texturedModels
                    .getOrDefault(arguments.getBlock(), TexturedModel.COLUMN.get(arguments.getBlock()));
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(arguments.getBlock(), logColumn.getMapping(), arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(arguments.getBlock(), resourceLocation));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        public OrganicProvider logUVLocked(BlockFamilyProviderMethod arguments) {
            arguments.getGenerator().blockStateOutput
                    .accept(BlockModelGenerators.createPillarBlockUVLocked(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput));
            return this;
        }

        public OrganicProvider potted(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping
                    .plant(this.family.get(BYGBlockFamily.BlockVariant.GROWER));
            ResourceLocation resourceLocation = BlockModelGenerators.TintState.NOT_TINTED
                    .getCrossPot().create(arguments.getBlock(), textureMapping, arguments
                    .getGenerator().modelOutput);
            arguments.getGenerator()
                    .blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
            return this;
        }

        public OrganicProvider pressurePlate(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = ModelTemplates.PRESSURE_PLATE_UP.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation1 = ModelTemplates.PRESSURE_PLATE_DOWN.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createPressurePlate(arguments.getBlock(), resourceLocation, resourceLocation1));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        public OrganicProvider sign(BlockFamilyProviderMethod arguments) {
            if (this.family == null) {
                throw new IllegalStateException("Family not defined");
            } else {
                Block block1 = this.family.getVariants().get(BYGBlockFamily.BlockVariant.WALL_SIGN);
                ResourceLocation resourceLocation = ModelTemplates.PARTICLE_ONLY.create(arguments.getBlock(), this.mapping, arguments.getGenerator().modelOutput);
                arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), resourceLocation));
                arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block1, resourceLocation));
                arguments.getGenerator().createSimpleFlatItemModel(arguments.getBlock().asItem());
                arguments.getGenerator().skipAutoItemBlock(block1);
                return this;
            }
        }

        public OrganicProvider spreadable(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = new TextureMapping().put(TextureSlot.BOTTOM,
                    TextureMapping.getBlockTexture(family.get(BYGBlockFamily.BlockVariant.SPREAD_TO)))
                    .put(TextureSlot.TOP, TextureMapping.getBlockTexture(arguments.getBlock()))
                    .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(arguments.getBlock(), "_side"));
            arguments.getGenerator().blockStateOutput
                    .accept(BlockModelGenerators.createSimpleBlock(arguments.getBlock(), ModelTemplates.CUBE_BOTTOM_TOP
                            .create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput)));
            return this;
        }

        public OrganicProvider slab(BlockFamilyProviderMethod arguments) {
            if (this.fullBlock == null) {
                throw new IllegalStateException("Full block not generated yet");
            } else {
                ResourceLocation resourceLocation = getOrCreateModel(arguments.getGenerator(), ModelTemplates.SLAB_BOTTOM, arguments.getBlock());
                ResourceLocation resourceLocation1 = getOrCreateModel(arguments.getGenerator(), ModelTemplates.SLAB_TOP, arguments.getBlock());
                arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createSlab(arguments.getBlock(), resourceLocation, resourceLocation1, this.fullBlock));
                arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
                return this;
            }
        }

        public OrganicProvider stairs(BlockFamilyProviderMethod arguments) {
            ResourceLocation resourceLocation = getOrCreateModel(arguments.getGenerator(), ModelTemplates.STAIRS_INNER, arguments.getBlock());
            ResourceLocation resourceLocation1 = getOrCreateModel(arguments.getGenerator(), ModelTemplates.STAIRS_STRAIGHT, arguments.getBlock());
            ResourceLocation resourceLocation2 = getOrCreateModel(arguments.getGenerator(), ModelTemplates.STAIRS_OUTER, arguments.getBlock());
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createStairs(arguments.getBlock(), resourceLocation, resourceLocation1, resourceLocation2));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation1);
            return this;
        }

        private OrganicProvider trapdoor(BlockFamilyProviderMethod arguments) {
            TextureMapping textureMapping = TextureMapping.defaultTexture(arguments.getBlock());
            ResourceLocation resourceLocation = ModelTemplates.ORIENTABLE_TRAPDOOR_TOP.create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation2 = ModelTemplates.ORIENTABLE_TRAPDOOR_BOTTOM.create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput);
            ResourceLocation resourceLocation3 = ModelTemplates.ORIENTABLE_TRAPDOOR_OPEN.create(arguments.getBlock(), textureMapping, arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createOrientableTrapdoor(arguments.getBlock(), resourceLocation, resourceLocation2, resourceLocation3));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation2);
            return this;
        }

        private ResourceLocation getOrCreateModel(BlockModelGenerators generators, ModelTemplate modelTemplate, Block block) {
            return this.models.computeIfAbsent(modelTemplate, template -> template.create(block, this.mapping, generators.modelOutput));
        }

        public OrganicProvider wood(BlockFamilyProviderMethod arguments) {
            TexturedModel logColumn = texturedModels
                    .getOrDefault(arguments.getBlock(), TexturedModel.COLUMN.get(arguments.getBlock()));
            ResourceLocation resourceLocation = ModelTemplates.CUBE_COLUMN.create(arguments.getBlock(), logColumn.getMapping(), arguments.getGenerator().modelOutput);
            arguments.getGenerator().blockStateOutput.accept(BlockModelGenerators.createAxisAlignedPillarBlock(arguments.getBlock(), resourceLocation));
            arguments.getGenerator().delegateItemModel(arguments.getBlock(), resourceLocation);
            return this;
        }

        public OrganicProvider vine(BlockFamilyProviderMethod arguments) {
            arguments.getGenerator().createMultiface(arguments.getBlock());
            return this;
        }

        private OrganicProvider executeGeneration(BYGBlockFamily.BlockVariant blockVariant,
                                                  BlockFamilyProviderMethod providerMethod) {
            return switch (blockVariant) {
                case BOOKSHELF -> bookshelf(providerMethod);
                case BUSH -> crossBlockNoItem(providerMethod);
                case BUTTON -> button(providerMethod);
                case DOOR -> door(providerMethod);
                case CRAFTING_TABLE -> craftingTable(providerMethod);
                case FENCE -> fence(providerMethod);
                case FENCE_GATE -> fenceGate(providerMethod);
                case FOLIAGE -> carpet(providerMethod);
                case FRUIT_BLOCK -> fullBlockVariantNoItem(providerMethod);
                case GRASS, GROWER, SPROUTS -> crossBlock(providerMethod);
                case HANGING_SIGN -> hangingSign(providerMethod);
                case IMBUED_LOG, LOG, STRIPPED_LOG -> log(providerMethod);
                case POTTED -> potted(providerMethod);
                case PRESSURE_PLATE -> pressurePlate(providerMethod);
                case ROOTS, TALL_GRASS -> doublePlant(providerMethod);
                case SIGN -> sign(providerMethod);
                case SPREADABLE -> spreadable(providerMethod);
                case SLAB -> slab(providerMethod);
                case STAIRS -> stairs(providerMethod);
                case STRIPPED_WOOD, WOOD -> wood(providerMethod);
                case TRAPDOOR -> trapdoor(providerMethod);
                case VINE -> vine(providerMethod);
                default -> fullBlockVariant(providerMethod);
            };
        }

        @SuppressWarnings("unused")
        public OrganicProvider generateFor(BlockModelGenerators generators, BYGBlockFamily blockFamily) {
            this.family = blockFamily;
            Block plank = family.get(BYGBlockFamily.BlockVariant.PLANKS);
            if(plank != null) {
                TexturedModel planksModel = texturedModels
                        .getOrDefault(plank, TexturedModel.CUBE.get(plank));
                mapping = planksModel.getMapping();
                fullBlock(plank, planksModel.getTemplate(), generators);
            }
            blockFamily.getVariants().forEach((blockVariant, block) -> {
                if(!(blockVariant.equals(BYGBlockFamily.BlockVariant.PLANKS) ||
                        blockVariant.equals(BYGBlockFamily.BlockVariant.BASE_BLOCK) ||
                        blockVariant.equals(BYGBlockFamily.BlockVariant.WALL_SIGN) ||
                        blockVariant.equals(BYGBlockFamily.BlockVariant.WALL_HANGING_SIGN))) {
                    executeGeneration(blockVariant,
                            new BlockFamilyProviderMethod() {
                                @Override
                                public Block getBlock() {
                                    return block;
                                }

                                @Override
                                public BlockModelGenerators getGenerator() {
                                    return generators;
                                }
                            });
                }
            });
            return this;
        }
    }
}
