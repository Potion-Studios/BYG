package voronoiaoc.byg.common.entity.boat;

import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import voronoiaoc.byg.common.network.CustomEntitySpawnS2CPacket;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGEntityList;
import voronoiaoc.byg.core.byglists.BYGItemList;

@SuppressWarnings("EntityConstructor")
public class BYGBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> BYG_BOAT_TYPE = SynchedEntityData.defineId(BYGBoatEntity.class, EntityDataSerializers.INT);

    public BYGBoatEntity(Level world, double x, double y, double z) {
        this(BYGEntityList.BYGBOAT, world);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public BYGBoatEntity(EntityType<? extends Boat> boatEntityType, Level world) {
        super(boatEntityType, world);
    }

    @Override
    public Item getDropItem() {
        switch (this.getBYGBoatType()) {
            default:
                return BYGItemList.ASPEN_BOAT;
            case BAOBAB:
                return BYGItemList.BAOBAB_BOAT;
            case BLUE_ENCHANTED:
                return BYGItemList.BLUE_ENCHANTED_BOAT;
            case CHERRY:
                return BYGItemList.CHERRY_BOAT;
            case CIKA:
                return BYGItemList.CIKA_BOAT;
            case CYPRESS:
                return BYGItemList.CYPRESS_BOAT;
            case EBONY:
                return BYGItemList.EBONY_BOAT;
            case FIR:
                return BYGItemList.FIR_BOAT;
            case GREEN_ENCHANTED:
                return BYGItemList.GREEN_ENCHANTED_BOAT;
            case HOLLY:
                return BYGItemList.HOLLY_BOAT;
            case JACARANDA:
                return BYGItemList.JACARANDA_BOAT;
            case MAHOGANY:
                return BYGItemList.MAHOGANY_BOAT;
            case MANGROVE:
                return BYGItemList.MANGROVE_BOAT;
            case MAPLE:
                return BYGItemList.MAPLE_BOAT;
            case PINE:
                return BYGItemList.PINE_BOAT;
            case RAINBOW_EUCALYPTUS:
                return BYGItemList.RAINBOW_EUCALYPTUS_BOAT;
            case REDWOOD:
                return BYGItemList.REDWOOD_BOAT;
            case SKYRIS:
                return BYGItemList.SKYRIS_BOAT;
            case WILLOW:
                return BYGItemList.WILLOW_BOAT;
            case WITCH_HAZEL:
                return BYGItemList.WITCH_HAZEL_BOAT;
            case ZELKOVA:
                return BYGItemList.ZELKOVA_BOAT;
        }
    }

    public Block getPlanks() {
        switch (this.getBYGBoatType()) {
            default:
                return BYGBlockList.ASPEN_PLANKS;
            case BAOBAB:
                return BYGBlockList.BAOBAB_PLANKS;
            case BLUE_ENCHANTED:
                return BYGBlockList.BLUE_ENCHANTED_PLANKS;
            case CHERRY:
                return BYGBlockList.CHERRY_PLANKS;
            case CIKA:
                return BYGBlockList.CIKA_PLANKS;
            case CYPRESS:
                return BYGBlockList.CYPRESS_PLANKS;
            case EBONY:
                return BYGBlockList.EBONY_PLANKS;
            case FIR:
                return BYGBlockList.FIR_PLANKS;
            case GREEN_ENCHANTED:
                return BYGBlockList.GREEN_ENCHANTED_PLANKS;
            case HOLLY:
                return BYGBlockList.HOLLY_PLANKS;
            case JACARANDA:
                return BYGBlockList.JACARANDA_PLANKS;
            case MAHOGANY:
                return BYGBlockList.MAHOGANY_PLANKS;
            case MANGROVE:
                return BYGBlockList.MANGROVE_PLANKS;
            case MAPLE:
                return BYGBlockList.MAPLE_PLANKS;
            case PINE:
                return BYGBlockList.PINE_PLANKS;
            case RAINBOW_EUCALYPTUS:
                return BYGBlockList.RAINBOW_EUCALYPTUS_PLANKS;
            case REDWOOD:
                return BYGBlockList.REDWOOD_PLANKS;
            case SKYRIS:
                return BYGBlockList.SKYRIS_PLANKS;
            case WILLOW:
                return BYGBlockList.WILLOW_PLANKS;
            case WITCH_HAZEL:
                return BYGBlockList.WITCH_HAZEL_PLANKS;
            case ZELKOVA:
                return BYGBlockList.ZELKOVA_PLANKS;
        }
    }

    public BYGType getBYGBoatType() {
        return BYGType.byId(this.entityData.get(BYG_BOAT_TYPE));
    }

    public void setBYGBoatType(BYGType boatBYGType) {
        this.entityData.set(BYG_BOAT_TYPE, boatBYGType.ordinal());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BYG_BOAT_TYPE, BYGType.ASPEN.ordinal());
    }


    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("BYGType", this.getBYGBoatType().getName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("BYGType", NbtType.STRING)) {
            this.setBYGBoatType(BYGType.getTypeFromString(compound.getString("BYGType")));
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return CustomEntitySpawnS2CPacket.createSpawnPacket(this);
    }

    public enum BYGType {
        ASPEN("aspen"),
        BAOBAB("baobab"),
        BLUE_ENCHANTED("blue_enchanted"),
        CHERRY("cherry"),
        CIKA("cika"),
        CYPRESS("cypress"),
        EBONY("ebony"),
        FIR("fir"),
        GREEN_ENCHANTED("green_enchanted"),
        HOLLY("holly"),
        JACARANDA("jacaranda"),
        MAHOGANY("mahogony"),
        MANGROVE("mangrove"),
        MAPLE("maple"),
        PINE("pine"),
        RAINBOW_EUCALYPTUS("rainbow_eucalyptus"),
        REDWOOD("redwood"),
        SKYRIS("skyris"),
        WILLOW("willow"),
        WITCH_HAZEL("witch_hazel"),
        ZELKOVA("zelkova");


        private final String name;

        BYGType(String string) {
            this.name = string;
        }

        /**
         * Get a boat type by it's enum ordinal
         */
        public static BYGType byId(int id) {
            BYGType[] aBYGBoatEntity$BYGType = values();
            if (id < 0 || id >= aBYGBoatEntity$BYGType.length) {
                id = 0;
            }

            return aBYGBoatEntity$BYGType[id];
        }

        public static BYGType getTypeFromString(String nameIn) {
            BYGType[] aBYGBoatEntity$BYGType = values();

            for (BYGType BYGType : aBYGBoatEntity$BYGType) {
                if (BYGType.getName().equals(nameIn)) {
                    return BYGType;
                }
            }

            return aBYGBoatEntity$BYGType[0];
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }
}
