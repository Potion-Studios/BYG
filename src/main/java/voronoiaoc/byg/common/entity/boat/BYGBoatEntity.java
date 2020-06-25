package voronoiaoc.byg.common.entity.boat;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGEntityList;
import voronoiaoc.byg.core.byglists.BYGItemList;

@SuppressWarnings("EntityConstructor")
public class BYGBoatEntity extends BoatEntity {
    private static final TrackedData<Integer> BYG_BOAT_TYPE = DataTracker.registerData(BYGBoatEntity.class, TrackedDataHandlerRegistry.INTEGER);;

    public BYGBoatEntity(World world, double x, double y, double z) {
        this(BYGEntityList.BYGBOAT ,world);
        this.updatePosition(x, y, z);
        this.setVelocity(Vec3d.ZERO);
        this.prevX = x;
        this.prevY = y;
        this.prevZ = z;
    }

    public BYGBoatEntity(EntityType<? extends BoatEntity> boatEntityType, World world) {
        super(boatEntityType, world);
        this.paddlePhases = new float[2];
        this.inanimate = true;
    }

    @Override
    public Item asItem() {
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
        if (compound.contains("BYGType", 8)) {
            this.setBYGBoatType(BYGType.getTypeFromString(compound.getString("BYGType")));
        }
    }

    @Override
    public void animateDamage() {
        this.setDamageWobbleSide(-this.getDamageWobbleSide());
        this.setDamageWobbleTicks(10);
        this.setDamageWobbleStrength(this.getDamageWobbleStrength() * 11.0F);
    }


    @Override
    protected void fall(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        this.fallVelocity = this.getVelocity().y;
        if (!this.hasVehicle()) {
            if (onGroundIn) {
                if (this.fallDistance > 3.0F) {
                    if (this.location != BoatEntity.Location.ON_LAND) {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.handleFallDamage(this.fallDistance, 1.0F);
                    if (!this.world.isClient && !this.removed) {
                        this.remove();
                        if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.dropItem(this.getPlanks());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.dropItem(Items.STICK);
                            }

                            this.dropItem(Blocks.AIR);
                        }
                    }
                }

                this.fallDistance = 0.0F;
            } else if (!this.world.getFluidState(this.getBlockPos().down()).isIn(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance = (float) ((double) this.fallDistance - y);
            }

        }
    }

    @Override
    public boolean damage(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.world.isClient && !this.removed) {
            this.setDamageWobbleSide(-this.getDamageWobbleSide());
            this.setDamageWobbleTicks(10);
            this.setDamageWobbleStrength(this.getDamageWobbleStrength() + amount * 10.0F);
            this.scheduleVelocityUpdate();
            boolean bl = source.getAttacker() instanceof PlayerEntity && ((PlayerEntity)source.getAttacker()).abilities.creativeMode;
            if (bl || this.getDamageWobbleStrength() > 40.0F) {
                if (!bl && this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                    this.dropItem(this.asItem());
                }

                this.remove();
            }

            return true;
        } else {
            return true;
        }
    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
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
