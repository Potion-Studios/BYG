package potionstudios.byg.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.HashCache;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;

import java.io.IOException;

public class BYGAssetsProvider extends BlockModelProvider {
    private final ItemProvider item;
    public BYGAssetsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BYG.MOD_ID, existingFileHelper);
        this.item = new ItemProvider(generator, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        final var generatedParent = mcLoc("item/generated");

        for (final var type : BYGWoodTypes.values()) {
            final var typeLoc = "block/" + type + "/";
            final var typeLocItem = "item/" + type + "/";
            final var log = cubeColumn(type.log().getId().getPath(), BYG.createLocation(typeLoc + "log"), BYG.createLocation(typeLoc + "log_top"));
            configureTransform(item.withExistingParent(type.log().getId().getPath(), log.getLocation()));

            if (type.boat() != null)
                item.withExistingParent(type.boat().getId().getPath(), generatedParent)
                        .texture("layer0", rl(typeLocItem + "boat"));

            final var bookshelf = cube(
                type.bookshelf().getId().getPath(),
                rl(typeLoc + "planks"),
                rl(typeLoc + "planks"),
                rl(typeLoc + "bookshelf"),
                rl(typeLoc + "bookshelf"),
                rl(typeLoc + "bookshelf"),
                rl(typeLoc + "bookshelf")
            ).texture("particle", typeLoc + "planks");
            configureTransform(item.withExistingParent(type.bookshelf().getId().getPath(), bookshelf.getLocation()));

            final var button = buttonInventory(type.button().getId().getPath() + "_inventory", rl(typeLoc + "planks"));
            button(type.button().getId().getPath(), rl(typeLoc + "planks"));
            buttonPressed(type.button().getId().getPath() + "_pressed", rl(typeLoc + "planks"));
            configureTransform(item.withExistingParent(type.button().getId().getPath(), button.getLocation()));

            final var craftingTable = cube(
                type.craftingTable().getId().getPath(),
                rl(typeLoc + "planks"),
                rl(typeLoc + "crafting_table_top"),
                rl(typeLoc + "crafting_table_front"),
                rl(typeLoc + "crafting_table_side"),
                rl(typeLoc + "crafting_table_side"),
                rl(typeLoc + "crafting_table_front")
            ).texture("particle", typeLoc + "crafting_table_front");
            configureTransform(item.withExistingParent(type.craftingTable().getId().getPath(), craftingTable.getLocation()));

            doorBottomLeft(
                type.door().getId().getPath() + "_bottom",
                rl(typeLoc + "door_bottom"),
                rl(typeLoc + "door_top")
            );
            doorBottomRight(
                type.door().getId().getPath() + "_bottom_hinge",
                rl(typeLoc + "door_bottom"),
                rl(typeLoc + "door_top")
            );
            doorTopLeft(
                type.door().getId().getPath() + "_top",
                rl(typeLoc + "door_bottom"),
                rl(typeLoc + "door_top")
            );
            doorTopRight(
                type.door().getId().getPath() + "_top_hinge",
                rl(typeLoc + "door_bottom"),
                rl(typeLoc + "door_top")
            );
            item.withExistingParent(type.door().getId().getPath(), generatedParent)
                .texture("layer0", rl(typeLocItem + "door"));

            fenceSide(type.fence().getId().getPath(), rl(typeLoc + "planks"))
                .texture("particle", rl(typeLoc + "planks"));
            final var fenceInv = fenceInventory(type.fence().getId().getPath(), rl(typeLoc + "planks"))
                .texture("particle", rl(typeLoc + "planks"));
            configureTransform(item.withExistingParent(type.fence().getId().getPath(), fenceInv.getLocation()));

            final var fenceGate = fenceGate(type.fenceGate().getId().getPath(), rl(typeLoc + "planks"));
            fenceGateOpen(type.fenceGate().getId().getPath() + "_open", rl(typeLoc + "planks"));
            fenceGateWall(type.fenceGate().getId().getPath() + "_wall", rl(typeLoc + "planks"));
            fenceGateWallOpen(type.fenceGate().getId().getPath() + "_wall_open", rl(typeLoc + "planks"));
            fencePost(type + "_fence_post", rl(typeLoc + "planks"))
                .texture("particle", rl(typeLoc + "planks"));
            configureTransform(item.withExistingParent(type.fence().getId().getPath(), fenceGate.getLocation()));

            if (type.leaves() != null) {
                final var leavesLoc = rl(typeLoc + "leaves");
                final var leaves = cube(
                    type.leaves().getId().getPath(),
                    leavesLoc, leavesLoc, leavesLoc,
                    leavesLoc, leavesLoc, leavesLoc
                ).texture("particle", leavesLoc);
                configureTransform(item.withExistingParent(type.leaves().getId().getPath(), leaves.getLocation()));
                cube(
                    type.leaves().getId().getPath() + "_snowy",
                    rl(typeLoc + "leaves_snowy"),
                    rl(typeLoc + "leaves_snowy"),
                    rl(typeLoc + "leaves_snowy_side"),
                    rl(typeLoc + "leaves_snowy_side"),
                    rl(typeLoc + "leaves_snowy_side"),
                    rl(typeLoc + "leaves_snowy_side")
                ).texture("particle", rl(typeLoc + "leaves_snowy_side"));
            }
            final var planksLoc = rl(typeLoc + "planks");
            final var planks = cube(type.planks().getId().getPath(), planksLoc, planksLoc, planksLoc, planksLoc, planksLoc, planksLoc)
                .texture("particle", planksLoc);
            configureTransform(item.withExistingParent(type.planks().getId().getPath(), planks.getLocation()));

            final var wood = cubeAll(type.wood().getId().getPath(), rl(typeLoc + "log"))
                .texture("particle", rl(typeLoc + "log"));
            configureTransform(item.withExistingParent(type.wood().getId().getPath(), wood.getLocation()));

            if (type.growerItem() != null) {
                final var textureLoc = rl(typeLoc + "grower_item");
                cross(type.growerItem().getId().getPath(), textureLoc);
                item.withExistingParent(type.growerItem().getId().getPath(), generatedParent)
                    .texture("layer0", rl(typeLocItem + "grower_item"));
            }
            final var pressurePlate = pressurePlate(type.pressurePlate().getId().getPath(), rl(typeLoc + "planks"));
            pressurePlateDown(type.pressurePlate().getId().getPath() + "_down", rl(typeLoc + "planks"));
            configureTransform(item.withExistingParent(type.pressurePlate().getId().getPath(), pressurePlate.getLocation()));

            final var slab = slab(type.slab().getId().getPath(), planksLoc, planksLoc, planksLoc);
            slabTop(type.slab().getId().getPath() + "_top", planksLoc, planksLoc, planksLoc);
            configureTransform(item.withExistingParent(type.slab().getId().getPath(), slab.getLocation()));

            final var stairs = stairs(type.stairs().getId().getPath(), planksLoc, planksLoc, planksLoc);
            stairsInner(type.stairs().getId().getPath() + "_inner", planksLoc, planksLoc, planksLoc);
            stairsOuter(type.stairs().getId().getPath() + "_outer", planksLoc, planksLoc, planksLoc);
            configureTransform(item.withExistingParent(type.stairs().getId().getPath(), stairs.getLocation()));

            final var trapdoorName = type.trapdoor().getId().getPath();
            final var trapdoorLoc = rl(typeLoc + "trapdoor");
            final var trapdoor = trapdoorOrientableBottom(trapdoorName + "_bottom", trapdoorLoc);
            trapdoorOrientableTop(trapdoorName + "_top", trapdoorLoc);
            trapdoorOrientableOpen(trapdoorName + "_open", trapdoorLoc);
            configureTransform(item.withExistingParent(trapdoorName, trapdoor.getLocation()));

            // TODO what are walls?
            final var logLocation = rl(typeLoc + "log");
            final var wallInv = wallInventory(type + "_wall_inventory", logLocation)
                .texture("particle", logLocation);
            item.withExistingParent(type.wallSign().getId().getPath(), wallInv.getLocation());
            wallSide(type + "_wall", logLocation)
                .texture("particle", logLocation);
            wallPost(type + "_wall_post", logLocation)
                .texture("particle", logLocation);
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
