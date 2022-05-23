package potionstudios.byg.common.block;

import net.minecraft.world.level.block.state.properties.WoodType;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGConstants;

import static potionstudios.byg.mixin.access.WoodTypeAccess.byg_create;
import static potionstudios.byg.mixin.access.WoodTypeAccess.byg_invokeRegister;

// TODO this needs to be merged with BYGWoodTypes
public class BYGWoodType {

    public static final WoodType BLUE_ENCHANTED = register("blue_enchanted");
    public static final WoodType CHERRY = register("cherry");
    public static final WoodType CIKA = register("cika");
    public static final WoodType CYPRESS = register("cypress");
    public static final WoodType EBONY = register("ebony");
    public static final WoodType FIR = register("fir");
    public static final WoodType GREEN_ENCHANTED = register("green_enchanted");
    public static final WoodType HOLLY = register("holly");
    public static final WoodType JACARANDA = register("jacaranda");
    public static final WoodType MAHOGANY = register("mahogany");
    public static final WoodType MANGROVE = register("mangrove");
    public static final WoodType MAPLE = register("maple");
    public static final WoodType PINE = register("pine");
    public static final WoodType RAINBOW_EUCALYPTUS = register("rainbow_eucalyptus");
    public static final WoodType REDWOOD = register("redwood");
    public static final WoodType SKYRIS = register("skyris");
    public static final WoodType WILLOW = register("willow");
    public static final WoodType WITCH_HAZEL = register("witch_hazel");
    public static final WoodType ZELKOVA = register("zelkova");
    public static final WoodType SYTHIAN = register("sythian");
    public static final WoodType EMBUR = register("embur");
    public static final WoodType PALM = register("palm");
    public static final WoodType LAMENT = register("lament");
    public static final WoodType BULBIS = register("bulbis");
    public static final WoodType NIGHTSHADE = register("nightshade");
    public static final WoodType ETHER = register("ether");
    public static final WoodType IMPARIUS = register("imparius");

    private static WoodType register(String id) {
        return BYGConstants.SIGNS ? byg_invokeRegister(byg_create(BYG.createLocation(id).toString().replace(":", "/"))) : null;
    }
}