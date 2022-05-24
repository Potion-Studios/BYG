package potionstudios.byg.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CrossCollisionBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;

import java.io.IOException;

public class BYGWoodAssetsProvider extends BlockStateProvider {
    private final ItemProvider item;
    public BYGWoodAssetsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BYG.MOD_ID, existingFileHelper);
        this.item = new ItemProvider(generator, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        final var generatedParent = mcLoc("item/generated");

        for (final var type : BYGWoodTypes.values()) {
            final var typeLoc = "block/" + type + "/";
            final var typeLocItem = "item/" + type + "/";
            final var log = models().cubeColumn(type + "/log", BYG.createLocation(typeLoc + "log"), BYG.createLocation(typeLoc + "log_top"));
            axisBlock((RotatedPillarBlock) type.log().get(), log, log);
            configureTransform(item.withExistingParent(type.log().getId().getPath(), log.getLocation()));

            if (type.boat() != null)
                item.withExistingParent(type.boat().getId().getPath(), generatedParent)
                        .texture("layer0", rl(typeLocItem + "boat"));

            final var bookshelf = models().cube(
                type + "/bookshelf",
                rl(typeLoc + "planks"),
                rl(typeLoc + "planks"),
                rl(typeLoc + "bookshelf"),
                rl(typeLoc + "bookshelf"),
                rl(typeLoc + "bookshelf"),
                rl(typeLoc + "bookshelf")
            ).texture("particle", typeLoc + "planks");
            configureTransform(item.withExistingParent(type.bookshelf().getId().getPath(), bookshelf.getLocation()));
            simpleBlock(type.bookshelf().get(), bookshelf);

            final var button = models().buttonInventory(type + "/button_inventory", rl(typeLoc + "planks"));
            models().button(type + "/button", rl(typeLoc + "planks"));
            final var buttonPressed = models().buttonPressed(type + "/button_pressed", rl(typeLoc + "planks"));
            configureTransform(item.withExistingParent(type.button().getId().getPath(), button.getLocation()));
            buttonBlock((ButtonBlock) type.button().get(), button, buttonPressed);

            final var craftingTable = models().cube(
                type + "/crafting_table",
                rl(typeLoc + "planks"),
                rl(typeLoc + "crafting_table_top"),
                rl(typeLoc + "crafting_table_front"),
                rl(typeLoc + "crafting_table_side"),
                rl(typeLoc + "crafting_table_side"),
                rl(typeLoc + "crafting_table_front")
            ).texture("particle", typeLoc + "crafting_table_front");
            configureTransform(item.withExistingParent(type.craftingTable().getId().getPath(), craftingTable.getLocation()));
            simpleBlock(type.craftingTable().get(), craftingTable);

            final var doorBottomLeft = models().doorBottomLeft(
                type + "/door_bottom",
                rl(typeLoc + "door_bottom"),
                rl(typeLoc + "door_top")
            );
            final var doorBottomRight = models().doorBottomRight(
                type + "/door_bottom_hinge",
                rl(typeLoc + "door_bottom"),
                rl(typeLoc + "door_top")
            );
            final var doorTopLeft = models().doorTopLeft(
                type + "/door_top",
                rl(typeLoc + "door_bottom"),
                rl(typeLoc + "door_top")
            );
            final var doorTopRight = models().doorTopRight(
                type + "/door_top_hinge",
                rl(typeLoc + "door_bottom"),
                rl(typeLoc + "door_top")
            );
            doorBlock((DoorBlock) type.door().get(), doorBottomLeft, doorBottomRight, doorTopLeft, doorBottomRight);
            item.withExistingParent(type.door().getId().getPath(), generatedParent)
                .texture("layer0", rl(typeLocItem + "door"));

            final var fencePost = models().fencePost(type + "/fence_post", rl(typeLoc + "planks"))
                    .texture("particle", rl(typeLoc + "planks"));
            final var fenceSide = models().fenceSide(type + "/fence", rl(typeLoc + "planks"))
                .texture("particle", rl(typeLoc + "planks"));
            final var fenceInv = models().fenceInventory(type + "/fence_inv", rl(typeLoc + "planks"))
                .texture("particle", rl(typeLoc + "planks"));
            configureTransform(item.withExistingParent(type.fence().getId().getPath(), fenceInv.getLocation()));
            fourWayBlock((CrossCollisionBlock) type.fence().get(), fencePost, fenceSide);

            final var fenceGate = models().fenceGate(type + "/fence_gate", rl(typeLoc + "planks"));
            final var fenceGateOpen = models().fenceGateOpen(type + "/fence_gate_open", rl(typeLoc + "planks"));
            final var fenceGateWall = models().fenceGateWall(type + "/fence_gate_wall", rl(typeLoc + "planks"));
            final var fenceGateWallOpen = models().fenceGateWallOpen(type + "/fence_gate_wall_open", rl(typeLoc + "planks"));
            configureTransform(item.withExistingParent(type.fence().getId().getPath(), fenceGate.getLocation()));
            fenceGateBlock((FenceGateBlock) type.fenceGate().get(), fenceGate, fenceGateOpen, fenceGateWall, fenceGateWallOpen);

            if (type.leaves() != null) {
                final var leavesLoc = rl(typeLoc + "leaves");
                final var leaves = models().cube(
                    type + "/leaves",
                    leavesLoc, leavesLoc, leavesLoc,
                    leavesLoc, leavesLoc, leavesLoc
                ).texture("particle", leavesLoc);
                configureTransform(item.withExistingParent(type.leaves().getId().getPath(), leaves.getLocation()));
                models().cube(
                    type + "/leaves_snowy",
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
            final var planks = models().cube(type + "/planks", planksLoc, planksLoc, planksLoc, planksLoc, planksLoc, planksLoc)
                .texture("particle", planksLoc);
            configureTransform(item.withExistingParent(type.planks().getId().getPath(), planks.getLocation()));
            simpleBlock(type.planks().get(), planks);

            final var wood = models().cubeAll(typeLoc + "/wood", rl(typeLoc + "log"))
                .texture("particle", rl(typeLoc + "log"));
            configureTransform(item.withExistingParent(type.wood().getId().getPath(), wood.getLocation()));
            axisBlock((RotatedPillarBlock) type.wood().get(), wood, wood);

            if (type.growerItem() != null) {
                final var textureLoc = rl(typeLoc + "grower_item");
                final var growerItem = models().cross(type + "/grower_item", textureLoc);
                item.withExistingParent(type.growerItem().getId().getPath(), generatedParent)
                    .texture("layer0", textureLoc);
                simpleBlock(type.growerItem().get(), growerItem);
            }
            final var pressurePlate = models().pressurePlate(type + "/pressure_plate", rl(typeLoc + "planks"));
            final var pressurePlateDown = models().pressurePlateDown(type + "/pressure_plate_down", rl(typeLoc + "planks"));
            configureTransform(item.withExistingParent(type.pressurePlate().getId().getPath(), pressurePlate.getLocation()));
            pressurePlateBlock((PressurePlateBlock) type.pressurePlate().get(), pressurePlate, pressurePlateDown);

            final var slab = models().slab(type + "/slab", planksLoc, planksLoc, planksLoc);
            final var slabTop = models().slabTop(type + "/slab_top", planksLoc, planksLoc, planksLoc);
            configureTransform(item.withExistingParent(type.slab().getId().getPath(), slab.getLocation()));
            slabBlock((SlabBlock) type.slab().get(), slab, slabTop, planks);

            final var stairs = models().stairs(type + "/stairs", planksLoc, planksLoc, planksLoc);
            final var stairsInner = models().stairsInner(type + "/stairs_inner", planksLoc, planksLoc, planksLoc);
            final var stairsOuter = models().stairsOuter(type + "/stairs_outer", planksLoc, planksLoc, planksLoc);
            configureTransform(item.withExistingParent(type.stairs().getId().getPath(), stairs.getLocation()));
            stairsBlock((StairBlock) type.stairs().get(), stairs, stairsInner, stairsOuter);

            final var trapdoorName = type + "/trapdoor";
            final var trapdoorLoc = rl(typeLoc + "trapdoor");
            final var trapdoor = models().trapdoorOrientableBottom(trapdoorName + "_bottom", trapdoorLoc);
            final var trapdoorTop = models().trapdoorOrientableTop(trapdoorName + "_top", trapdoorLoc);
            final var trapdoorOpen = models().trapdoorOrientableOpen(trapdoorName + "_open", trapdoorLoc);
            configureTransform(item.withExistingParent(trapdoorName, trapdoor.getLocation()));
            trapdoorBlock((TrapDoorBlock) type.trapdoor().get(), trapdoor, trapdoorTop, trapdoorOpen, true);

// No wood walls for now
//            final var logLocation = rl(typeLoc + "log");
//            final var wallInv = models().wallInventory(type + "/wall_inventory", logLocation)
//                    .texture("particle", logLocation);
//            item.withExistingParent(type.wall().getId().getPath(), wallInv.getLocation());
//            final var wall = models().wallSide(type + "/wall", logLocation)
//                    .texture("particle", logLocation);
//            final var wallPost = models().wallPost(type + "/wall_post", logLocation)
//                    .texture("particle", logLocation);
//            wallBlock(type.wall().get(), wallPost, wall, wall);
        }
    }

    private static ResourceLocation rl(String path) {
        return BYG.createLocation(path);
    }

    @SuppressWarnings("all")
    private ItemModelBuilder configureTransform(ItemModelBuilder builder) {
        return builder
                .transforms()
                .transform(ModelBuilder.Perspective.THIRDPERSON_LEFT)
                .rotation(10, -45, 170)
                .translation(0, 1.5f, -2.75f)
                .scale(0.375f, 0.375f, 0.375f)
                .end()
                .transform(ModelBuilder.Perspective.THIRDPERSON_RIGHT)
                .rotation(10, -45, 170)
                .translation(0, 1.5f, -2.75f)
                .scale(0.375f, 0.375f, 0.375f)
                .end()
                .end();
    }

    public ItemModelBuilder item(String path) {
        return item.getBuilder(path);
    }

    @Override
    public void run(HashCache cache) throws IOException {
        super.run(cache);
        item.generateAll(cache);
    }

    private static final class ItemProvider extends ItemModelProvider {

        public ItemProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
            super(generator, BYG.MOD_ID, existingFileHelper);
        }

        @Override
        protected void registerModels() {

        }

        @Override
        public void generateAll(HashCache cache) {
            super.generateAll(cache);
        }
    }
}
