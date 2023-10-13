package potionstudios.byg.common.entity.pumpkinwarden;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import javax.annotation.Nullable;
import java.util.List;

public class PumpkinWarden extends PathfinderMob implements GeoEntity {

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    private BlockPos jukebox;
    private boolean party;
    private static final EntityDataAccessor<Boolean> HIDING = SynchedEntityData.defineId(PumpkinWarden.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(PumpkinWarden.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<BlockState> DATA_CARRY_STATE = SynchedEntityData.defineId(PumpkinWarden.class, EntityDataSerializers.BLOCK_STATE);


    public PumpkinWarden(EntityType<? extends PathfinderMob> $$0, Level $$1) {
        super($$0, $$1);
    }


    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_CARRY_STATE, Blocks.AIR.defaultBlockState());
        this.entityData.define(HIDING, false);
        this.entityData.define(TIMER, 0);
        super.defineSynchedData();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.4D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.2D, Ingredient.of(Items.PUMPKIN_PIE), false));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 2.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new PumpkinWardenLeaveBlockGoal(this, 1, 32, 5));
        this.goalSelector.addGoal(1, new PumpkinWardenTakeBlockGoal(this, 1, 32, 5));
        this.goalSelector.addGoal(0, new AvoidEntityGoal<>(this, Zombie.class, 8.0F, 1.0D, 1.0D) {
            @Override
            public boolean canContinueToUse() {
                if (((PumpkinWarden) this.mob).isHiding()) {
                    return false;
                } else {
                    return super.canContinueToUse();
                }
            }
        });
        this.goalSelector.addGoal(3, new StayByBellGoal(this, 1, 5000));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        super.registerGoals();
    }

    @Override
    public boolean removeWhenFarAway(double $$0) {
        return false;
    }

    @Override
    public void checkDespawn() {
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return animatableInstanceCache;
    }

    private static final RawAnimation HIDE_START = RawAnimation.begin().thenPlay("animation.pumpkinwarden.hidestart");
    private static final RawAnimation HIDE = RawAnimation.begin().thenPlay("animation.pumpkinwarden.hide");
    private static final RawAnimation HIDE_END = RawAnimation.begin().thenPlay("animation.pumpkinwarden.hideend");
    private static final RawAnimation HOLDING_WALKING = RawAnimation.begin().thenPlay("animation.pumpkinwarden.holding_walking");
    private static final RawAnimation HOLDING_IDLE = RawAnimation.begin().thenPlay("animation.pumpkinwarden.holding_idle");
    private static final RawAnimation WALKING = RawAnimation.begin().thenPlay("animation.pumpkinwarden.walking");
    private static final RawAnimation WAVE = RawAnimation.begin().thenPlay("animation.pumpkinwarden.wave");


    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        AnimationController<E> controller = event.getController();
        controller.transitionLength(0);
        if (this.isHiding()) {
            if (this.getTimer() < 10) {
                controller.setAnimation(HIDE_START);
                return PlayState.CONTINUE;
            } else if ((this.getTimer() > 10 && this.getTimer() < 180) || !this.level().isDay() && this.getTimer() > 10) {
                controller.setAnimation(HIDE);
                return PlayState.CONTINUE;
            } else if (this.getTimer() > 180) {
                if (this.level().getBrightness(LightLayer.SKY, this.getOnPos()) > 2) {
                    controller.setAnimation(HIDE_END);
                } else {
                    controller.setAnimation(HIDE);
                }
                return PlayState.CONTINUE;
            }
        }
        if (this.getCarriedBlock() != null) {
            if (event.isMoving()) {
                controller.setAnimation(HOLDING_WALKING);
            } else {
                controller.setAnimation(HOLDING_IDLE);
            }
            return PlayState.CONTINUE;
        } else if (event.isMoving() && this.getCarriedBlock() == null) {
            controller.setAnimation(WALKING);
            return PlayState.CONTINUE;
        } else if (this.party) {
            controller.setAnimation(WAVE);
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }




    @Override
    public void setRecordPlayingNearby(BlockPos pPos, boolean pIsPartying) {
        this.jukebox = pPos;
        this.party = pIsPartying;
    }

    public void aiStep() {
        super.aiStep();
        if (this.jukebox == null || !this.jukebox.closerToCenterThan(this.position(), 10D) || !this.level().getBlockState(this.jukebox).is(Blocks.JUKEBOX)) {
            this.party = false;
            this.jukebox = null;
        }
        if (!this.level().isClientSide) {
            if (!this.level().isDay()) {
                this.setTimer(this.getTimer() + 1);
                this.setHiding(true);
            } else if (this.getTimer() > 0 && this.getLastHurtByMob() == null) {
                this.setTimer(0);
                this.setHiding(false);
            }
            if (this.getLastHurtByMob() != null) {
                if (this.getTimer() < 200) {
                    this.setTimer(this.getTimer() + 1);
                    this.setHiding(true);
                } else {
                    this.setTimer(0);
                    this.setHiding(false);
                }
            }
        }
        if (this.isHiding()) {
            this.setDeltaMovement(0, this.getDeltaMovement().y(), 0);
            this.setRot(0, 0);
            if (this.getCarriedBlock() != null) {
                BehaviorUtils.throwItem(this, this.getCarriedBlock().getBlock().asItem().getDefaultInstance(), new Vec3(this.getX() + 2, this.getY(), this.getZ()));
                this.setCarriedBlock(null);
            }
        }
        if (this.getCarriedBlock() != null) {
            this.setItemInHand(this.getUsedItemHand(), this.getCarriedBlock().getBlock().asItem().getDefaultInstance());
        } else {
            this.setItemInHand(this.getUsedItemHand(), ItemStack.EMPTY);
        }
    }

    @Override
    public boolean canBeLeashed(Player $$0) {
        return true;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.VILLAGER_AMBIENT;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource $$0) {
        return SoundEvents.VILLAGER_HURT;
    }

    @org.jetbrains.annotations.Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.VILLAGER_DEATH;
    }

    @Override
    public float getVoicePitch() {
        return (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.5F;
    }


    public boolean isHiding() {
        return entityData.get(HIDING);
    }

    public void setHiding(boolean flag) {
        entityData.set(HIDING, flag);
    }

    public int getTimer() {
        return entityData.get(TIMER);
    }

    public void setTimer(int flag) {
        entityData.set(TIMER, flag);
    }

    public void setCarriedBlock(@Nullable BlockState pState) {
        this.entityData.set(DATA_CARRY_STATE, pState == null ? Blocks.AIR.defaultBlockState() : pState);
    }

    @Nullable
    public BlockState getCarriedBlock() {
        BlockState blockState = this.entityData.get(DATA_CARRY_STATE);
        return blockState == Blocks.AIR.defaultBlockState() ? null : blockState;
    }


    static class PumpkinWardenTakeBlockGoal extends MoveToBlockGoal {
        private final PumpkinWarden warden;

        /**
         * The delay until {@link PumpkinWardenTakeBlockGoal#findNearestBlock()}
         * attempts to find for a new melon or pumpkin block nearby.
         * This delay is counted in ticks and is continuously decremented until it hits
         * 0, at which point a new nearest block will be searched for.
         * The value of this field will be -1 if the goal has already found a
         * valid target block.
         *
         * <p>This field mainly exists for performance reasons.
         */
        private int searchNearestBlockDelay = 0;

        public PumpkinWardenTakeBlockGoal(PumpkinWarden p, double speed, int range, int y) {
            super(p, speed, range, y);
            this.warden = p;
        }

        @Override
        public boolean canUse() {
            if (this.searchNearestBlockDelay > 0) {
                this.searchNearestBlockDelay--;
            }
            if (this.warden.getCarriedBlock() != null) {
                return false;
            }
            return super.canUse();
        }

        @Override
        protected boolean findNearestBlock() {
            if (this.searchNearestBlockDelay > 0) {
              return false;
            } else if (this.searchNearestBlockDelay == -1 && this.isValidTarget(this.warden.level(), this.blockPos)) {
                return true;
            }
            if (super.findNearestBlock()) {
                this.searchNearestBlockDelay = -1;
                return true;
            } else {
                this.searchNearestBlockDelay = 20;
                return false;
            }
        }

        @Override
        public double acceptedDistance() {
            return 1.7D;
        }

        @Override
        protected int nextStartTick(PathfinderMob $$0) {
            return 0;
        }

        public void tick() {
            super.tick();
            if (this.isReachedTarget()) {
                Level level = this.warden.level();
                BlockState blockstate = level.getBlockState(this.blockPos);
                if (blockstate.getBlock() instanceof StemGrownBlock block) {
                    level.removeBlock(this.blockPos, false);
                    level.gameEvent(GameEvent.BLOCK_DESTROY, this.blockPos, GameEvent.Context.of(this.warden, blockstate));
                    this.warden.setCarriedBlock(blockstate.getBlock().defaultBlockState());
                }
            }
        }

        @Override
        protected boolean isValidTarget(LevelReader level, BlockPos pos) {
            BlockState positionState = level.getBlockState(pos);
            if (positionState.is(Blocks.PUMPKIN)) {
                return level.getBlockState(pos.relative(Direction.Axis.X, 1)).getBlock() instanceof AttachedStemBlock || level.getBlockState(pos.relative(Direction.Axis.Z, 1)).getBlock() instanceof AttachedStemBlock;
            } else if (positionState.is(Blocks.MELON)) {
                return level.getBlockState(pos.relative(Direction.Axis.X, 1)).getBlock() instanceof AttachedStemBlock || level.getBlockState(pos.relative(Direction.Axis.Z, 1)).getBlock() instanceof AttachedStemBlock;
            }
            return false;
        }
    }

    static class PumpkinWardenLeaveBlockGoal extends MoveToBlockGoal {
        public PumpkinWarden warden;

        /**
         * The delay until {@link PumpkinWardenLeaveBlockGoal#findNearestBlock()}
         * attempts to find for a new carved pumpkin block nearby.
         * This delay is counted in ticks and is continuously decremented until it hits
         * 0, at which point a new nearest block will be searched for.
         * The value of this field will be -1 if the goal has already found a
         * valid target block.
         *
         * <p>This field mainly exists for performance reasons.
         */
        private int searchNearestBlockDelay = 0;

        public PumpkinWardenLeaveBlockGoal(PumpkinWarden warden, double speed, int range, int y) {
            super(warden, speed, range, y);
            this.warden = warden;
        }

        @Override
        public double acceptedDistance() {
            return 8D;
        }

        @Override
        protected int nextStartTick(PathfinderMob $$0) {
            return 0;
        }

        @Override
        public boolean canContinueToUse() {
            return (this.warden.getCarriedBlock() != null);
        }

        @Override
        public boolean canUse() {
            if (this.searchNearestBlockDelay > 0) {
                this.searchNearestBlockDelay--;
            }
            if (this.warden.getCarriedBlock() == null) {
                return false;
            }
            return super.canUse();
        }

        @Override
        protected boolean findNearestBlock() {
            if (this.searchNearestBlockDelay > 0) {
                return false;
            } else if (this.searchNearestBlockDelay == -1 && this.isValidTarget(this.warden.level(), this.blockPos)) {
                return true;
            }
            if (super.findNearestBlock()) {
                this.searchNearestBlockDelay = -1;
                return true;
            } else {
                this.searchNearestBlockDelay = 20;
                return false;
            }
        }

        public void tick() {
            super.tick();
            if (this.isReachedTarget()) {
                if (this.warden.getCarriedBlock() != null) {
                    BehaviorUtils.throwItem(this.warden, this.warden.getCarriedBlock().getBlock().asItem().getDefaultInstance(), new Vec3(this.blockPos.getX(), this.blockPos.getY(), this.blockPos.getZ()));
                    this.warden.setCarriedBlock(null);
                    this.stop();
                }
            }
        }

        @Override
        protected boolean isValidTarget(LevelReader var1, BlockPos var2) {
            BlockState pos = var1.getBlockState(var2);
            return (pos.is(Blocks.CARVED_PUMPKIN));
        }
    }

    static class StayByBellGoal extends MoveToBlockGoal {
        public PumpkinWarden warden;

        public StayByBellGoal(PumpkinWarden warden, double $$1, int $$2) {
            super(warden, $$1, $$2, 12);
            this.warden = warden;
        }

        @Override
        protected boolean isValidTarget(LevelReader world, BlockPos var2) {
            List<BlockState> blockStates = world.getBlockStates(new AABB(warden.blockPosition()).inflate(30)).toList();
            return !blockStates.get(warden.random.nextInt(blockStates.size())).isAir();
        }
    }
}
