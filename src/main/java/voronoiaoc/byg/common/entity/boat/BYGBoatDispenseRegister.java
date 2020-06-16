package voronoiaoc.byg.common.entity.boat;

import net.minecraft.block.DispenserBlock;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGItemList;

public class BYGBoatDispenseRegister {

    public static void dispenseBoatBehavior() {
        BYG.LOGGER.debug("BYG: Adding Dispensable Boats...");

        DispenserBlock.registerDispenseBehavior(BYGItemList.ASPEN_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.ASPEN));
        DispenserBlock.registerDispenseBehavior(BYGItemList.BAOBAB_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.BAOBAB));
        DispenserBlock.registerDispenseBehavior(BYGItemList.BLUE_ENCHANTED_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.BLUE_ENCHANTED));
        DispenserBlock.registerDispenseBehavior(BYGItemList.CHERRY_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.CHERRY));
        DispenserBlock.registerDispenseBehavior(BYGItemList.CIKA_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.CIKA));
        DispenserBlock.registerDispenseBehavior(BYGItemList.CYPRESS_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.CYPRESS));
        DispenserBlock.registerDispenseBehavior(BYGItemList.EBONY_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.EBONY));
        DispenserBlock.registerDispenseBehavior(BYGItemList.FIR_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.FIR));
        DispenserBlock.registerDispenseBehavior(BYGItemList.GREEN_ENCHANTED_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.GREEN_ENCHANTED));
        DispenserBlock.registerDispenseBehavior(BYGItemList.HOLLY_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.HOLLY));
        DispenserBlock.registerDispenseBehavior(BYGItemList.JACARANDA_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.JACARANDA));
        DispenserBlock.registerDispenseBehavior(BYGItemList.MAHOGANY_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.MAHOGANY));
        DispenserBlock.registerDispenseBehavior(BYGItemList.MANGROVE_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.MANGROVE));
        DispenserBlock.registerDispenseBehavior(BYGItemList.MAPLE_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.MAPLE));
        DispenserBlock.registerDispenseBehavior(BYGItemList.PINE_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.PINE));
        DispenserBlock.registerDispenseBehavior(BYGItemList.RAINBOW_EUCALYPTUS_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.RAINBOW_EUCALYPTUS));
        DispenserBlock.registerDispenseBehavior(BYGItemList.REDWOOD_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.REDWOOD));
        DispenserBlock.registerDispenseBehavior(BYGItemList.SKYRIS_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.SKYRIS));
        DispenserBlock.registerDispenseBehavior(BYGItemList.WILLOW_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.WILLOW));
        DispenserBlock.registerDispenseBehavior(BYGItemList.WITCH_HAZEL_BOAT, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.WITCH_HAZEL));
        DispenserBlock.registerDispenseBehavior(BYGItemList.ZELKOVA_WOOD, new BYGDispenseBoatBehavior(BYGBoatEntity.BYGType.ZELKOVA));

        BYG.LOGGER.info("BYG: Added Dispensable Boats...");
    }
}
