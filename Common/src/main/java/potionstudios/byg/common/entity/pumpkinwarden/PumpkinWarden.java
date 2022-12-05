package potionstudios.byg.common.entity.pumpkinwarden;

import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StemGrownBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;
import java.util.Optional;

public class PumpkinWarden extends PathfinderMob implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);
    private BlockPos jukebox;
    private boolean party;
    private static final EntityDataAccessor<Boolean> HIDING = SynchedEntityData.defineId(PumpkinWarden.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(PumpkinWarden.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Optional<BlockState>> DATA_CARRY_STATE = SynchedEntityData.defineId(PumpkinWarden.class, EntityDataSerializers.BLOCK_STATE);


    public PumpkinWarden(EntityType<? extends PathfinderMob> $$0, Level $$1) {
        super($$0, $$1);
    }


    @Override
    protected void defineSynchedData() {
        this.entityData.define(DATA_CARRY_STATE, Optional.empty());
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
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Items.PUMPKIN_PIE), false));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 2.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new PumpkinWardenLeaveBlockGoal(this, 1, 32, 5));
        this.goalSelector.addGoal(2, new PumpkinWardenTakeBlockGoal(this, 1, 32, 5));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Zombie.class, 8.0F, 1.0D, 1.0D){
            @Override
            public boolean canContinueToUse() {
                if (((PumpkinWarden)this.mob).isHiding()){
                    return false;
                }else {
                    return super.canContinueToUse();
                }
            }
        });
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        super.registerGoals();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController controller = event.getController();
        controller.transitionLengthTicks = 0;
        if (this.isHiding()) {
            if (this.getTimer() < 10) {
                controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.hidestart", false));
                return PlayState.CONTINUE;
            }else if ((this.getTimer() > 10 && this.getTimer() < 180) || !this.level.isDay() && this.getTimer() > 10){
                    controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.hide", true));
                    return PlayState.CONTINUE;
            } else if (this.getTimer() > 180 && this.level.isDay()) {
                controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.hideend", false));
                return PlayState.CONTINUE;
            }
        }
        if (this.getCarriedBlock() != null) {
            if (event.isMoving()) {
                controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.holding_walking", true));
            } else {
                controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.holding_idle", true));
            }
            return PlayState.CONTINUE;
        } else if (event.isMoving() && this.getCarriedBlock() == null) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.walking", true));
            return PlayState.CONTINUE;
        } else if (this.party) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.wave", true));
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
        System.out.println("Timer: " + this.getTimer());
        System.out.println("Hiding: " + this.isHiding());
        if (this.jukebox == null || !this.jukebox.closerToCenterThan(this.position(), 10D) || !this.level.getBlockState(this.jukebox).is(Blocks.JUKEBOX)) {
            this.party = false;
            this.jukebox = null;
        }
        if (!this.level.isClientSide) {
            System.out.println("Target: " + this.getLastHurtByMob());
            if (!this.level.isDay()) {
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
            this.setDeltaMovement(0, 0, 0);
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
        return false;
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

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
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

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }

    public void setCarriedBlock(@Nullable BlockState pState) {
        this.entityData.set(DATA_CARRY_STATE, Optional.ofNullable(pState));
    }

    @Nullable
    public BlockState getCarriedBlock() {
        return this.entityData.get(DATA_CARRY_STATE).orElse(null);
    }

    static class PumpkinWardenTakeBlockGoal extends MoveToBlockGoal {
        private final PumpkinWarden warden;

        public PumpkinWardenTakeBlockGoal(PumpkinWarden p, double speed, int range, int y) {
            super(p, speed, range, y);
            this.warden = p;
        }

        @Override
        public boolean canUse() {
            if (this.warden.getCarriedBlock() != null) {
                return false;
            }
            return super.canUse();
        }

        @Override
        public double acceptedDistance() {
            return 1.7D;
        }

        @Override
        protected int nextStartTick(PathfinderMob $$0) {
            return 5;
        }

        public void tick() {
            super.tick();
            if (this.isReachedTarget()) {
                Level level = this.warden.level;
                BlockState blockstate = level.getBlockState(this.blockPos);
                if (blockstate.getBlock() instanceof StemGrownBlock block) {
                    block.getAttachedStem();
                    level.removeBlock(this.blockPos, false);
                    level.gameEvent(GameEvent.BLOCK_DESTROY, this.blockPos, GameEvent.Context.of(this.warden, blockstate));
                    this.warden.setCarriedBlock(blockstate.getBlock().defaultBlockState());
                }
            }
        }

        @Override
        protected boolean isValidTarget(LevelReader world, BlockPos pos) {
            return (world.getBlockState(pos).getBlock() instanceof StemGrownBlock);
        }
    }

    static class PumpkinWardenLeaveBlockGoal extends MoveToBlockGoal {
        public PumpkinWarden warden;

        public PumpkinWardenLeaveBlockGoal(PumpkinWarden warden, double speed, int range, int y) {
            super(warden, speed, range, y);
            this.warden = warden;
        }

        @Override
        public double acceptedDistance() {
            return 1.7D;
        }

        @Override
        protected int nextStartTick(PathfinderMob $$0) {
            return 10;
        }

        @Override
        public boolean canContinueToUse() {
            return (this.warden.getCarriedBlock() != null);
        }

        @Override
        public boolean canUse() {
            if (this.warden.getCarriedBlock() == null) {
                return false;
            }
            return super.canUse();
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
}
