package potionstudios.byg.common.block;

import net.minecraft.world.level.block.state.properties.WoodType;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGConstants;

import static potionstudios.byg.mixin.access.WoodTypeAccess.byg_create;
import static potionstudios.byg.mixin.access.WoodTypeAccess.byg_invokeRegister;

public class BYGWoodType {

    public static final WoodType JACARANDA = register("jacaranda");
    public static final WoodType MAPLE = register("maple");
    public static final WoodType SKYRIS = register("skyris");
    public static final WoodType WILLOW = register("willow");
    public static final WoodType WITCH_HAZEL = register("witch_hazel");
    public static final WoodType ZELKOVA = register("zelkova");
    public static final WoodType SYTHIAN = register("sythian");
    public static final WoodType EMBUR = register("embur");
    public static final WoodType LAMENT = register("lament");
    public static final WoodType NIGHTSHADE = register("nightshade");

    private static WoodType register(String id) {
        return BYGConstants.SIGNS ? byg_invokeRegister(byg_create(BYG.createLocation(id).toString().replace(":", "/"))) : null;
    }
}