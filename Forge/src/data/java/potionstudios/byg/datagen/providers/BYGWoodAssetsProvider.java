package potionstudios.byg.datagen.providers;

import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.mixin.dev.ModelProviderAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class BYGWoodAssetsProvider extends BlockStateProvider {

    public final Map<String, ResourceLocation> itemParents;

    private final DataGenerator dataGenerator;
    private final ExistingFileHelper existingFileHelper;

    public BYGWoodAssetsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), BYG.MOD_ID, existingFileHelper);
        this.dataGenerator = generator;
        this.existingFileHelper = existingFileHelper;
        this.itemParents = new HashMap<>();
    }

    public ItemProvider getItemProvider() {
        return new ItemProvider(dataGenerator, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        for (final var type : BYGWoodTypes.values()) {
            final var typeName = "block/" + type;
            final var typeLoc = "block/" + type + "/";
            final var topPlanksLoc = rl(typeLoc + "planks_top");
            final var topPlanks = models().existingFileHelper.exists(topPlanksLoc, ModelProviderAccess.getTexture());
            final var log = models().cubeColumn(typeName + "/log", BYG.createLocation(typeLoc + "log"), BYG.createLocation(typeLoc + "log_top"));
            axisBlock((RotatedPillarBlock) type.log().get(), log, log);
            itemParents.put(type.log().getId().getPath(), log.getLocation());
            if (type.strippedLog() != null) {
                final var strippedLog = models().cubeColumn(typeName + "/stripped_log", BYG.createLocation(typeLoc + "stripped_log"), BYG.createLocation(typeLoc + "stripped_log_top"));
                axisBlock((RotatedPillarBlock) type.strippedLog().get(), strippedLog, strippedLog);
                itemParents.put(type.strippedLog().getId().getPath(), strippedLog.getLocation());
            }


            final var bookshelf = models().cube(
                    typeName + "/bookshelf",
                    rl(typeLoc + "planks"),
                    rl(typeLoc + "planks"),
                    rl(typeLoc + "bookshelf"),
                    rl(typeLoc + "bookshelf"),
                    rl(typeLoc + "bookshelf"),
                    rl(typeLoc + "bookshelf")
            ).texture("particle", typeLoc + "planks");
            itemParents.put(type.bookshelf().getId().getPath(), bookshelf.getLocation());
            simpleBlock(type.bookshelf().get(), bookshelf);

            final var button = models().button(typeName + "/button", rl(typeLoc + "planks"));
            final var buttonPressed = models().buttonPressed(typeName + "/button_pressed", rl(typeLoc + "planks"));
            final var buttonInv = models().buttonInventory(typeName + "/button_inventory", rl(typeLoc + "planks"));
            itemParents.put(type.button().getId().getPath(), buttonInv.getLocation());
            buttonBlock((ButtonBlock) type.button().get(), button, buttonPressed);

            final var craftingTable = models().cube(
                    typeName + "/crafting_table",
                    rl(typeLoc + "planks"),
                    rl(typeLoc + "crafting_table_top"),
                    rl(typeLoc + "crafting_table_front"),
                    rl(typeLoc + "crafting_table_side"),
                    rl(typeLoc + "crafting_table_side"),
                    rl(typeLoc + "crafting_table_front")
            ).texture("particle", typeLoc + "crafting_table_front");
            itemParents.put(type.craftingTable().getId().getPath(), craftingTable.getLocation());
            simpleBlock(type.craftingTable().get(), craftingTable);

            door(typeName, type.door().get(), rl(typeLoc + "door_bottom"), rl(typeLoc + "door_top"));

            final var fencePost = models().fencePost(typeName + "/fence_post", rl(typeLoc + "planks"))
                    .texture("particle", rl(typeLoc + "planks"));
            final var fenceSide = models().fenceSide(typeName + "/fence", rl(typeLoc + "planks"))
                    .texture("particle", rl(typeLoc + "planks"));
            final var fenceInv = models().fenceInventory(typeName + "/fence_inv", rl(typeLoc + "planks"))
                    .texture("particle", rl(typeLoc + "planks"));
            itemParents.put(type.fence().getId().getPath(), fenceInv.getLocation());
            fourWayBlock((CrossCollisionBlock) type.fence().get(), fencePost, fenceSide);

            final var fenceGate = models().fenceGate(typeName + "/fence_gate", rl(typeLoc + "planks"));
            final var fenceGateOpen = models().fenceGateOpen(typeName + "/fence_gate_open", rl(typeLoc + "planks"));
            final var fenceGateWall = models().fenceGateWall(typeName + "/fence_gate_wall", rl(typeLoc + "planks"));
            final var fenceGateWallOpen = models().fenceGateWallOpen(typeName + "/fence_gate_wall_open", rl(typeLoc + "planks"));
            itemParents.put(type.fenceGate().getId().getPath(), fenceGate.getLocation());
            fenceGateBlock((FenceGateBlock) type.fenceGate().get(), fenceGate, fenceGateOpen, fenceGateWall, fenceGateWallOpen);

            if (type.leaves() != null) {
                // So... leaves are fun.
                final var leavesLoc = rl(typeLoc + "leaves");
                final BlockModelBuilder leaves;
                if (type.leavesHaveOverlay()) {
                    final var overlaySupposedLoc = rl(typeLoc + "leaves_overlay");
                    final var overlayLoc = models().existingFileHelper.exists(overlaySupposedLoc, ModelProviderAccess.getTexture()) ? overlaySupposedLoc : leavesLoc;
                    leaves = leaves(typeName + "/leaves", leavesLoc, overlayLoc);
                } else {
                    leaves = models().withExistingParent(
                            typeName + "/leaves",
                            new ResourceLocation("block/leaves")
                    ).texture("all", leavesLoc).texture("particle", leavesLoc);
                }
                itemParents.put(type.leaves().getId().getPath(), leaves.getLocation());
                models().cube(
                        typeName + "/leaves_snowy",
                        rl(typeLoc + "leaves_snowy"),
                        rl(typeLoc + "leaves_snowy"),
                        rl(typeLoc + "leaves_snowy_side"),
                        rl(typeLoc + "leaves_snowy_side"),
                        rl(typeLoc + "leaves_snowy_side"),
                        rl(typeLoc + "leaves_snowy_side")
                ).texture("particle", rl(typeLoc + "leaves_snowy_side"));
                simpleBlock(type.leaves().get(), leaves); // TODO leaves should be snowy as well
            }
            final var planksLoc = rl(typeLoc + "planks");
            final var planks = models().cube(typeName + "/planks",
                    topPlanks ? topPlanksLoc : planksLoc,
                    topPlanks ? topPlanksLoc : planksLoc,
                    planksLoc,
                    planksLoc,
                    planksLoc,
                    planksLoc
            ).texture("particle", topPlanks ? topPlanksLoc : planksLoc);
            itemParents.put(type.planks().getId().getPath(), planks.getLocation());
            simpleBlock(type.planks().get(), planks);

            if (type.wood() != null) {
                final var wood = models().cubeAll(typeName + "/wood", rl(typeLoc + "log"))
                        .texture("particle", rl(typeLoc + "log"));
                itemParents.put(type.wood().getId().getPath(), wood.getLocation());
                axisBlock((RotatedPillarBlock) type.wood().get(), wood, wood);
            }
            if (type.strippedWood() != null) {
                final var strippedWood = models().cubeAll(typeName + "/stripped_wood", rl(typeLoc + "stripped_log"))
                        .texture("particle", rl(typeLoc + "stripped_log"));
                itemParents.put(type.strippedWood().getId().getPath(), strippedWood.getLocation());
                axisBlock((RotatedPillarBlock) type.strippedWood().get(), strippedWood, strippedWood);
            }

            if (type.growerItem() != null) {
                final var textureLoc = rl(typeLoc + "grower_item");
                final var growerItem = models().cross(typeName + "/grower_item", textureLoc);
                simpleBlock(type.growerItem().get(), growerItem);

                final var pottedBlock = ForgeRegistries.BLOCKS.getValue(BYG.createLocation("potted_" + type.growerItem().getId().getPath()));
                final var potted = models().withExistingParent(typeLoc + "potted_grower_item", mcLoc("block/flower_pot_cross"))
                        .texture("plant", growerItem.getLocation());
                simpleBlock(pottedBlock, potted);
            }
            final var pressurePlate = models().pressurePlate(typeName + "/pressure_plate", rl(typeLoc + "planks"));
            final var pressurePlateDown = models().pressurePlateDown(typeName + "/pressure_plate_down", rl(typeLoc + "planks"));
            itemParents.put(type.pressurePlate().getId().getPath(), pressurePlate.getLocation());
            pressurePlateBlock((PressurePlateBlock) type.pressurePlate().get(), pressurePlate, pressurePlateDown);

            final var slab = models().slab(typeName + "/slab", planksLoc, topPlanks ? topPlanksLoc : planksLoc, topPlanks ? topPlanksLoc : planksLoc);
            final var slabTop = models().slabTop(typeName + "/slab_top", planksLoc, topPlanks ? topPlanksLoc : planksLoc, topPlanks ? topPlanksLoc : planksLoc);
            itemParents.put(type.slab().getId().getPath(), slab.getLocation());
            slabBlock((SlabBlock) type.slab().get(), slab, slabTop, planks);

            final var stairs = models().stairs(typeName + "/stairs", planksLoc, planksLoc, planksLoc);
            final var stairsInner = models().stairsInner(typeName + "/stairs_inner", planksLoc, planksLoc, planksLoc);
            final var stairsOuter = models().stairsOuter(typeName + "/stairs_outer", planksLoc, planksLoc, planksLoc);
            itemParents.put(type.stairs().getId().getPath(), stairs.getLocation());
            stairsBlock((StairBlock) type.stairs().get(), stairs, stairsInner, stairsOuter);

            final var trapdoorName = typeName + "/trapdoor";
            final var trapdoorLoc = rl(typeLoc + "trapdoor");
            final var trapdoor = models().trapdoorOrientableBottom(trapdoorName + "_bottom", trapdoorLoc);
            final var trapdoorTop = models().trapdoorOrientableTop(trapdoorName + "_top", trapdoorLoc);
            final var trapdoorOpen = models().trapdoorOrientableOpen(trapdoorName + "_open", trapdoorLoc);
            itemParents.put(type.trapdoor().getId().getPath(), trapdoor.getLocation());
            trapdoorBlock((TrapDoorBlock) type.trapdoor().get(), trapdoor, trapdoorTop, trapdoorOpen, true);

            if (type.sign() != null) {
                final var model = models().sign(typeName + "/sign", planksLoc);
                signBlock((StandingSignBlock) type.sign().get(), (WallSignBlock) type.wallSign().get(), model);
            }

            if (type.hangingSign() != null) {
                final var model = models().sign(typeName + "/hanging_sign", planksLoc);
                hangingSign((CeilingHangingSignBlock) type.hangingSign().get(),
                        (WallHangingSignBlock) type.wallHangingSign().get(), model);
            }

// No wood walls for now
//            final var logLocation = rl(typeLoc + "log");
//            final var wallInv = models().wallInventory(typeName + "/wall_inventory", logLocation)
//                    .texture("particle", logLocation);
//            item.withExistingParent(type.wall().getId().getPath(), wallInv.getLocation());
//            final var wall = models().wallSide(typeName + "/wall", logLocation)
//                    .texture("particle", logLocation);
//            final var wallPost = models().wallPost(typeName + "/wall_post", logLocation)
//                    .texture("particle", logLocation);
//            wallBlock(type.wall().get(), wallPost, wall, wall);
        }
    }

    private void hangingSign(CeilingHangingSignBlock ceilingHangingSignBlock,
                            WallHangingSignBlock wallHangingSignBlock,
                            ModelFile sign) {
        simpleBlock(ceilingHangingSignBlock, sign);
        simpleBlock(wallHangingSignBlock, sign);
    }

    private void door(String typeLocation, Block door, ResourceLocation bottom, ResourceLocation top) {
        final var bottomLeft = doorModel(typeLocation + "/door/bottom_left", "bottom_left", bottom, top);
        final var bottomLeftOpen = doorModel(typeLocation + "/door/bottom_left_open", "bottom_left_open", bottom, top);
        final var bottomRight = doorModel(typeLocation + "/door/bottom_right", "bottom_right", bottom, top);
        final var bottomRightOpen = doorModel(typeLocation + "/door/bottom_right_open", "bottom_right_open", bottom, top);

        final var topLeft = doorModel(typeLocation + "/door/top_left", "top_left", bottom, top);
        final var topLeftOpen = doorModel(typeLocation + "/door/top_left_open", "top_left_open", bottom, top);
        final var topRight = doorModel(typeLocation + "/door/top_right", "top_right", bottom, top);
        final var topRightOpen = doorModel(typeLocation + "/door/top_right_open", "top_right_open", bottom, top);

        getVariantBuilder(door)
                .forAllStatesExcept(state -> {
                    int yRot = ((int) state.getValue(DoorBlock.FACING).toYRot()) + 90;
                    boolean right = state.getValue(DoorBlock.HINGE) == DoorHingeSide.RIGHT;
                    boolean open = state.getValue(DoorBlock.OPEN);
                    if (open) {
                        yRot += 90;
                    }
                    if (right && open) {
                        yRot += 180;
                    }
                    yRot %= 360;
                    final var bottomModel = open ? (right ? bottomRightOpen : bottomLeftOpen) : (right ? bottomRight : bottomLeft);
                    final var topModel = open ? (right ? topRightOpen : topLeftOpen) : (right ? topRight : topLeft);
                    return ConfiguredModel.builder().modelFile(state.getValue(DoorBlock.HALF) == DoubleBlockHalf.LOWER ? bottomModel : topModel)
                            .rotationY(yRot)
                            .build();
                }, DoorBlock.POWERED);
    }

    private BlockModelBuilder doorModel(String name, String type, ResourceLocation bottom, ResourceLocation top) {
        return models().withExistingParent(name, "block/door_" + type)
                .texture("bottom", bottom)
                .texture("top", top);
    }

    private BlockModelBuilder leaves(String name, ResourceLocation texture, ResourceLocation overlay) {
        return models().cube(name,
                        texture, texture, texture,
                        texture, texture, texture
                ).texture("particle", texture).texture("overlay", overlay)
                .element()
                .from(0, 0, 0)
                .to(16, 16, 16)
                .allFaces((dir, builder) -> builder
                        .uvs(0, 0, 16, 16)
                        .texture("#" + dir.getName())
                        .cullface(dir)
                        .end())
                .end()
                .element()
                .from(0, 0, 0)
                .to(16, 16, 16)
                .allFaces((dir, builder) -> builder
                        .uvs(0, 0, 16, 16)
                        .texture("#" + dir.getName())
                        .cullface(dir)
                        .tintindex(1)
                        .end())
                .end();
    }

    private static ResourceLocation rl(String path) {
        return BYG.createLocation(path);
    }

    @SuppressWarnings("all")
    private ItemModelBuilder configureTransform(ItemModelBuilder builder) {
        return builder
                .transforms()
                .transform(ItemDisplayContext.THIRD_PERSON_LEFT_HAND)
                .rotation(10, -45, 170)
                .translation(0, 1.5f, -2.75f)
                .scale(0.375f, 0.375f, 0.375f)
                .end()
                .transform(ItemDisplayContext.THIRD_PERSON_RIGHT_HAND)
                .rotation(10, -45, 170)
                .translation(0, 1.5f, -2.75f)
                .scale(0.375f, 0.375f, 0.375f)
                .end()
                .end();
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        return super.run(cache).thenRun(() -> {
            // item.generateAll(cache);
        });
    }


    @NotNull
    @Override
    public String getName() {
        return "Wood Asset Providers";
    }

    public final class ItemProvider extends ItemModelProvider {

        public ItemProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator.getPackOutput(), BYG.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerModels() {
            final var generatedParent = mcLoc("item/generated");


            for(var type: BYGWoodTypes.values()) {
                final var typeLoc = "block/" + type + "/";
                final var typeLocItem = "item/" + type + "/";

                if (type.boat() != null) {
                    withExistingParent(type.boat().getId().getPath(), generatedParent)
                            .texture("layer0", rl(typeLocItem + "boat"));
                }

                if (type.chestBoat() != null) {
                    withExistingParent(type.chestBoat().getId().getPath(), generatedParent)
                            .texture("layer0", rl(typeLocItem + "boat"))
                            .texture("layer1", "byg:item/chest_boat_overlay"
                            );
                }

                withExistingParent(type.door().getId().getPath(), generatedParent)
                        .texture("layer0", rl(typeLocItem + "door"));

                if (type.growerItem() != null) {
                    final var textureLoc = rl(typeLoc + "grower_item");
                    withExistingParent(type.growerItem().getId().getPath(), generatedParent)
                            .texture("layer0", textureLoc);
                }

                if (type.sign() != null) {
                    withExistingParent(type.sign().getId().getPath(), generatedParent)
                            .texture("layer0", rl(typeLocItem + "sign"));
                }

                if (type.hangingSign() != null) {
                    withExistingParent(type.hangingSign().getId().getPath(), generatedParent)
                            .texture("layer0", rl(typeLocItem + "hanging_sign"));
                }
            }

            for(Map.Entry<String, ResourceLocation> entry: itemParents.entrySet()) {
                configureTransform(withExistingParent(entry.getKey(), entry.getValue()));
            }
        }

        @Override
        public CompletableFuture<?> generateAll(CachedOutput cache) {
            return super.generateAll(cache);
        }

    }
}
