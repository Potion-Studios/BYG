package corgiaoc.byg.common.entity.boat;

import corgiaoc.byg.common.network.CustomEntitySpawnS2CPacket;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGEntities;
import corgiaoc.byg.core.BYGItems;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@SuppressWarnings("EntityConstructor")
public class BYGBoatEntity extends BoatEntity {
    private static final TrackedData<Integer> BYG_BOAT_TYPE = DataTracker.registerData(BYGBoatEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public BYGBoatEntity(World world, double x, double y, double z) {
        this(BYGEntities.BOAT, world);
        this.updatePosition(x, y, z);
        this.setVelocity(Vec3d.ZERO);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    public BYGBoatEntity(EntityType<? extends BoatEntity> boatEntityType, World world) {
        super(boatEntityType, world);
    }

    @Override
    public Item asItem() {
        switch (this.getBYGBoatType()) {
            default:
                return BYGItems.ASPEN_BOAT;
            case BAOBAB:
                return BYGItems.BAOBAB_BOAT;
            case BLUE_ENCHANTED:
                return BYGItems.BLUE_ENCHANTED_BOAT;
            case CHERRY:
                return BYGItems.CHERRY_BOAT;
            case CIKA:
                return BYGItems.CIKA_BOAT;
            case CYPRESS:
                return BYGItems.CYPRESS_BOAT;
            case EBONY:
                return BYGItems.EBONY_BOAT;
            case FIR:
                return BYGItems.FIR_BOAT;
            case GREEN_ENCHANTED:
                return BYGItems.GREEN_ENCHANTED_BOAT;
            case HOLLY:
                return BYGItems.HOLLY_BOAT;
            case JACARANDA:
                return BYGItems.JACARANDA_BOAT;
            case MAHOGANY:
                return BYGItems.MAHOGANY_BOAT;
            case MANGROVE:
                return BYGItems.MANGROVE_BOAT;
            case MAPLE:
                return BYGItems.MAPLE_BOAT;
            case PALM:
                return BYGItems.PALM_BOAT;
            case PINE:
                return BYGItems.PINE_BOAT;
            case RAINBOW_EUCALYPTUS:
                return BYGItems.RAINBOW_EUCALYPTUS_BOAT;
            case REDWOOD:
                return BYGItems.REDWOOD_BOAT;
            case SKYRIS:
                return BYGItems.SKYRIS_BOAT;
            case WILLOW:
                return BYGItems.WILLOW_BOAT;
            case WITCH_HAZEL:
                return BYGItems.WITCH_HAZEL_BOAT;
            case ZELKOVA:
                return BYGItems.ZELKOVA_BOAT;
        }
    }

    public Block getPlanks() {
        switch (this.getBYGBoatType()) {
            default:
                return BYGBlocks.ASPEN_PLANKS;
            case BAOBAB:
                return BYGBlocks.BAOBAB_PLANKS;
            case BLUE_ENCHANTED:
                return BYGBlocks.BLUE_ENCHANTED_PLANKS;
            case CHERRY:
                return BYGBlocks.CHERRY_PLANKS;
            case CIKA:
                return BYGBlocks.CIKA_PLANKS;
            case CYPRESS:
                return BYGBlocks.CYPRESS_PLANKS;
            case EBONY:
                return BYGBlocks.EBONY_PLANKS;
            case FIR:
                return BYGBlocks.FIR_PLANKS;
            case GREEN_ENCHANTED:
                return BYGBlocks.GREEN_ENCHANTED_PLANKS;
            case HOLLY:
                return BYGBlocks.HOLLY_PLANKS;
            case JACARANDA:
                return BYGBlocks.JACARANDA_PLANKS;
            case MAHOGANY:
                return BYGBlocks.MAHOGANY_PLANKS;
            case MANGROVE:
                return BYGBlocks.MANGROVE_PLANKS;
            case MAPLE:
                return BYGBlocks.MAPLE_PLANKS;
            case PALM:
                return BYGBlocks.PALM_PLANKS;
            case PINE:
                return BYGBlocks.PINE_PLANKS;
            case RAINBOW_EUCALYPTUS:
                return BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS;
            case REDWOOD:
                return BYGBlocks.REDWOOD_PLANKS;
            case SKYRIS:
                return BYGBlocks.SKYRIS_PLANKS;
            case WILLOW:
                return BYGBlocks.WILLOW_PLANKS;
            case WITCH_HAZEL:
                return BYGBlocks.WITCH_HAZEL_PLANKS;
            case ZELKOVA:
                return BYGBlocks.ZELKOVA_PLANKS;
        }
    }

    public BYGType getBYGBoatType() {
        return BYGType.byId(this.dataTracker.get(BYG_BOAT_TYPE));
    }

    public void setBYGBoatType(BYGType boatBYGType) {
        this.dataTracker.set(BYG_BOAT_TYPE, boatBYGType.ordinal());
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(BYG_BOAT_TYPE, BYGType.ASPEN.ordinal());
    }


    @Override
    protected void writeCustomDataToTag(CompoundTag compound) {
        compound.putString("BYGType", this.getBYGBoatType().getName());
    }

    @Override
    protected void readCustomDataFromTag(CompoundTag compound) {
        if (compound.contains("BYGType", NbtType.STRING)) {
            this.setBYGBoatType(BYGType.getTypeFromString(compound.getString("BYGType")));
        }
    }

    @Override
    public Packet<?> createSpawnPacket() {
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
        PALM("palm"),
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