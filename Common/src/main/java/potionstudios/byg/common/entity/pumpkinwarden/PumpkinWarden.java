package potionstudios.byg.common.entity.pumpkinwarden;

import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class PumpkinWarden extends PathfinderMob implements IAnimatable {

    private final AnimationFactory factory = new AnimationFactory(this);
    private BlockPos jukebox;
    private boolean party;
    private boolean running;
    private static final EntityDataAccessor<Boolean> HIDING = SynchedEntityData.defineId(PumpkinWarden.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> TIMER = SynchedEntityData.defineId(PumpkinWarden.class, EntityDataSerializers.INT);


    public PumpkinWarden(EntityType<? extends PathfinderMob> $$0, Level $$1) {
        super($$0, $$1);
    }


    @Override
    protected void defineSynchedData() {
        this.entityData.define(HIDING, false);
        this.entityData.define(TIMER, 0);
        super.defineSynchedData();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 0.5D);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PumpkinWardenPanicGoal());
        this.goalSelector.addGoal(1, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(2, new TemptGoal(this, 1.2D, Ingredient.of(Items.PUMPKIN_PIE), false));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        super.registerGoals();
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController controller = event.getController();
        controller.transitionLengthTicks = 0;
        if (event.isMoving()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.walking", true));
            return PlayState.CONTINUE;
        }
        else if (this.party) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.wave", true));
            return PlayState.CONTINUE;
        }
        else if (this.getHiding()) {
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.pumpkinwarden.hide", false));
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
        System.out.println("time is" + this.getTimer());
        System.out.println("hiding is" + this.getHiding());
        if (this.jukebox == null || !this.jukebox.closerToCenterThan(this.position(), 10D) || !this.level.getBlockState(this.jukebox).is(Blocks.JUKEBOX)) {
            this.party = false;
            this.jukebox = null;
        }
        if (this.getTimer() > 0){
            this.setTimer(this.getTimer() - 1);
            this.setHiding(false);
        } else if (this.getTimer() <= 0){
            this.setTimer(0);
            this.setHiding(true);
        }
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller", 0, this::predicate));
    }

    public boolean getHiding() {
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

    class PumpkinWardenPanicGoal extends PanicGoal {
        public PumpkinWardenPanicGoal() {
            super(PumpkinWarden.this, 2.0D);
        }

        @Override
        public void start() {
            ((PumpkinWarden)this.mob).setTimer(50);
            super.start();
        }

        @Override
        public void stop() {
            super.stop();
            ((PumpkinWarden)this.mob).setHiding(false);
        }
    }
}
