package potionstudios.byg.common.entity.boat;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.IndirectEntityDamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.mixin.access.BoatEntityAccess;

@SuppressWarnings("EntityConstructor")
public class BYGBoatEntity extends Boat {
    private static final EntityDataAccessor<Integer> BYG_BOAT_TYPE = SynchedEntityData.defineId(BYGBoatEntity.class, EntityDataSerializers.INT);


    public BYGBoatEntity(Level worldIn, double x, double y, double z) {
        this(BYGEntities.BOAT, worldIn);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public BYGBoatEntity(EntityType<? extends Boat> boatEntityType, Level worldType) {
        super(boatEntityType, worldType);
    }

    @Override
    public Item getDropItem() {
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
            case PALM:
                return BYGItems.PALM_BOAT;
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
        if (compound.contains("BYGType", 8)) {
            this.setBYGBoatType(BYGType.getTypeFromString(compound.getString("BYGType")));
        }
    }

    @Override
    public void animateHurt() {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }


    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        ((BoatEntityAccess) this).byg_setLastYd(this.getDeltaMovement().y);
        if (!this.isPassenger()) {
            if (onGroundIn) {
                if (this.fallDistance > 3.0F) {
                    if (((BoatEntityAccess) this).byg_getStatusField() != Boat.Status.ON_LAND) {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, DamageSource.FALL);
                    if (!this.level.isClientSide && !this.isRemoved()) {
                        this.kill();
                        if (this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.spawnAtLocation(this.getPlanks());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.spawnAtLocation(Items.STICK);
                            }

                            this.spawnAtLocation(Blocks.AIR);
                        }
                    }
                }

                this.fallDistance = 0.0F;
            } else if (!this.level.getFluidState((new BlockPos(this.getX(), this.getY(), this.getZ()).below())).is(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance = (float) ((double) this.fallDistance - y);
            }

        }
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.level.isClientSide && !this.isRemoved()) {
            if (source instanceof IndirectEntityDamageSource && source.getEntity() != null && this.hasPassenger(source.getEntity())) {
                return false;
            } else {
                this.setHurtDir(-this.getHurtDir());
                this.setHurtTime(10);
                this.setDamage(this.getDamage() + amount * 10.0F);
                this.markHurt();
                boolean flag = source.getEntity() instanceof Player && ((Player) source.getEntity()).getAbilities().instabuild;
                if (flag || this.getDamage() > 40.0F) {
                    if (!flag && this.level.getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                        this.spawnAtLocation(this.getDropItem());
                    }

                    this.discard();
                }

                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public Packet<?> getAddEntityPacket() {
        //TODO: Is this right?
        return new ClientboundAddEntityPacket(this);
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
