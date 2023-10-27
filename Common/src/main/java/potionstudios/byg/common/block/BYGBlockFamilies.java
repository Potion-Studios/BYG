package potionstudios.byg.common.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.BlockSetTypeAccess;
import potionstudios.byg.mixin.access.WoodTypeAccess;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BYGBlockFamilies {
    public static Map<String, BYGBlockFamily> woodFamilyMap = new HashMap<>();
    public static Map<String, BYGBlockFamily> blockFamilyMap = new HashMap<>();

    public static BYGBlockFamily HOLLY = register(new BYGBlockFamily.WoodBuilder("holly",
            getOverworldWoodType("holly"), () -> MapColor.TERRACOTTA_GREEN,false)
            .boat()
            .bookshelf()
            .button()
            .chestBoat()
            .craftingTable()
            .door()
            .fence()
            .fenceGate()
            .growerItem(BYGBlockFamily.GrowerItemType.SAPLING, "holly_sapling")
            .hangingSign()
            .leaves()
            .log()
            .pressurePlate()
            .sign()
            .slab()
            .stairs()
            .strippedLog()
            .strippedWood()
            .trapdoor()
            .wood());


    private static BYGBlockFamily register(BYGBlockFamily.WoodBuilder builder) {
        BYGBlockFamily bygBlockFamily = builder.build();
        woodFamilyMap.put(bygBlockFamily.getBaseName(), bygBlockFamily);
        return bygBlockFamily;
    }
    private static BYGBlockFamily register(BYGBlockFamily.Builder builder) {
        BYGBlockFamily bygBlockFamily = builder.build();
        blockFamilyMap.put(bygBlockFamily.getBaseName(), bygBlockFamily);
        return bygBlockFamily;
    }

    private static @NotNull WoodType getOverworldWoodType(String name){
        String id = BYG.createLocation(name).toString().replace(':', '/');
        WoodType woodType = WoodTypeAccess.byg_invokeRegister(new WoodType(id, new BlockSetType(id)));
        BlockSetTypeAccess.byg_invokeRegister(woodType.setType());
        return woodType;
    }

    private static @NotNull WoodType getNotOverworldWoodType(String name) {
        String id = BYG.createLocation(name).toString().replace(':', '/');
        WoodType woodType = new WoodType(id, new BlockSetType(id, true, SoundType.NETHER_WOOD,
                SoundEvents.NETHER_WOOD_DOOR_CLOSE, SoundEvents.NETHER_WOOD_DOOR_OPEN,
                SoundEvents.NETHER_WOOD_TRAPDOOR_CLOSE, SoundEvents.NETHER_WOOD_TRAPDOOR_OPEN,
                SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF,
                SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.NETHER_WOOD_BUTTON_CLICK_OFF,
                SoundEvents.NETHER_WOOD_BUTTON_CLICK_ON), SoundType.NETHER_WOOD,
                SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE,
                SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN);
        BlockSetTypeAccess.byg_invokeRegister(woodType.setType());
        return woodType;
    }

    private static BlockSetType getBlockSetType(@NotNull Supplier<? extends BlockSetType> supplier) {
        BlockSetType blockSetType = supplier.get();
        BlockSetTypeAccess.byg_invokeRegister(blockSetType);
        return blockSetType;
    }

    @SuppressWarnings("empty")
    public static void register() {

    }
}
