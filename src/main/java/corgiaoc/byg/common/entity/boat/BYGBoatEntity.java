package corgiaoc.byg.common.entity.boat;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IndirectEntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;
import corgiaoc.byg.core.byglists.BYGBlockList;
import corgiaoc.byg.core.byglists.BYGEntityList;
import corgiaoc.byg.core.byglists.BYGItemList;

@SuppressWarnings("EntityConstructor")
public class BYGBoatEntity extends BoatEntity {
    private static final DataParameter<Integer> BYG_BOAT_TYPE = EntityDataManager.createKey(BYGBoatEntity.class, DataSerializers.VARINT);


    public BYGBoatEntity(World worldIn, double x, double y, double z) {
        this(BYGEntityList.BYGBOAT, worldIn);
        this.setPosition(x, y, z);
        this.setMotion(Vector3d.ZERO);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    public BYGBoatEntity(EntityType<? extends BoatEntity> boatEntityType, World worldType) {
        super(boatEntityType, worldType);
    }

    public BYGBoatEntity(FMLPlayMessages.SpawnEntity packet, World world) {
        super(BYGEntityList.BYGBOAT, world);
    }


    @Override
    public Item getItemBoat() {
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
            case PALM:
                return BYGItemList.PALM_BOAT;
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
            case PALM:
                return BYGBlockList.PALM_PLANKS;
        }
    }

    public BYGType getBYGBoatType() {
        return BYGType.byId(this.dataManager.get(BYG_BOAT_TYPE));
    }

    public void setBYGBoatType(BYGType boatBYGType) {
        this.dataManager.set(BYG_BOAT_TYPE, boatBYGType.ordinal());
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(BYG_BOAT_TYPE, BYGType.ASPEN.ordinal());
    }


    @Override
    protected void writeAdditional(CompoundNBT compound) {
        compound.putString("BYGType", this.getBYGBoatType().getName());
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {
        if (compound.contains("BYGType", 8)) {
            this.setBYGBoatType(BYGType.getTypeFromString(compound.getString("BYGType")));
        }
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void performHurtAnimation() {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0F);
    }


    @Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        this.lastYd = this.getMotion().y;
        if (!this.isPassenger()) {
            if (onGroundIn) {
                if (this.fallDistance > 3.0F) {
                    if (this.status != BoatEntity.Status.ON_LAND) {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.onLivingFall(this.fallDistance, 1.0F);
                    if (!this.world.isRemote && !this.removed) {
                        this.remove();
                        if (this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                            for (int i = 0; i < 3; ++i) {
                                this.entityDropItem(this.getPlanks());
                            }

                            for (int j = 0; j < 2; ++j) {
                                this.entityDropItem(Items.STICK);
                            }

                            this.entityDropItem(Blocks.AIR);
                        }
                    }
                }

                this.fallDistance = 0.0F;
            } else if (!this.world.getFluidState((new BlockPos(this.getPosX(), this.getPosY(), this.getPosZ()).down())).isTagged(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance = (float) ((double) this.fallDistance - y);
            }

        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.world.isRemote && !this.removed) {
            if (source instanceof IndirectEntityDamageSource && source.getTrueSource() != null && this.isPassenger(source.getTrueSource())) {
                return false;
            } else {
                this.setForwardDirection(-this.getForwardDirection());
                this.setTimeSinceHit(10);
                this.setDamageTaken(this.getDamageTaken() + amount * 10.0F);
                this.markVelocityChanged();
                boolean flag = source.getTrueSource() instanceof PlayerEntity && ((PlayerEntity) source.getTrueSource()).abilities.isCreativeMode;
                if (flag || this.getDamageTaken() > 40.0F) {
                    if (!flag && this.world.getGameRules().getBoolean(GameRules.DO_ENTITY_DROPS)) {
                        this.entityDropItem(this.getItemBoat());
                    }

                    this.remove();
                }

                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
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
