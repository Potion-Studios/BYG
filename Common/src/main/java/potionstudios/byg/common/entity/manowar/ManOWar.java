package potionstudios.byg.common.entity.manowar;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.item.BYGItems;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.util.RenderUtils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ManOWar extends Animal implements GeoEntity, Bucketable {

    private final AnimatableInstanceCache animatableInstanceCache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Integer> COLOR = SynchedEntityData.defineId(ManOWar.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(ManOWar.class, EntityDataSerializers.BOOLEAN);

    public float xBodyRot;
    public float xBodyRotO;
    public float zBodyRot;
    public float zBodyRotO;
    public float tentacleMovement;
    public float oldTentacleMovement;
    public float tentacleAngle;
    public float oldTentacleAngle;
    private float speed;
    private float tentacleSpeed;
    private float rotateSpeed;
    private float tx;
    private float ty;
    private float tz;

    public boolean glowLayer = false;

    public ManOWar(EntityType<? extends ManOWar> entityType, Level level) {
        super(entityType, level);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public MobType getMobType() {
        return MobType.WATER;
    }

    public boolean checkSpawnObstruction(LevelReader $$0) {
        return $$0.isUnobstructed(this);
    }

    public int getAmbientSoundInterval() {
        return 120;
    }

    public int getExperienceReward() {
        return 1 + this.level.random.nextInt(3);
    }

    protected void handleAirSupply(int $$0) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply($$0 - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAirSupply(300);
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.TROPICAL_FISH);
    }

    public void baseTick() {
        int $$0 = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply($$0);
    }

    public boolean isPushedByFluid() {
        return false;
    }

    public boolean canBeLeashed(Player $$0) {
        return false;
    }

    public static boolean checkManOWarSpawnRules(EntityType<? extends ManOWar> entity, LevelAccessor world, MobSpawnType spawnType, BlockPos pos, RandomSource rand) {
        int i = world.getSeaLevel();
        int j = i - 2;
        return pos.getY() <= j && world.getFluidState(pos.below()).is(FluidTags.WATER);
    }

    @Override
    public int getMaxAirSupply() {
        return 6000;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 10.0D).add(Attributes.MOVEMENT_SPEED, 1.2000000476837158D).add(Attributes.ATTACK_DAMAGE, 3.0D);
    }

    @Override
    public InteractionResult mobInteract(Player $$0, InteractionHand $$1) {
        if (this.isBaby()) {
            return Bucketable.bucketMobPickup($$0, $$1, this).orElse(super.mobInteract($$0, $$1));
        }
        return super.mobInteract($$0, $$1);
    }

    @Override
    public void playerTouch(Player player) {
        if (player instanceof ServerPlayer && player.hurt(DamageSource.mobAttack(this), (float) (1))) {
            RandomSource rand = player.getRandom();
            int i = rand.nextInt(4);
            if (i <= 2) {
                player.addEffect(new MobEffectInstance(MobEffects.POISON, 600, 2), this);
            } else {
                player.addEffect(new MobEffectInstance(MobEffects.POISON, 200), this);
            }
            if (player.hasEffect(MobEffects.UNLUCK)) {
                player.kill();
            }
        }
    }

    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.EVENTS;
    }

    public void travel(Vec3 vec3) {
        this.move(MoverType.SELF, this.getDeltaMovement());
    }

    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(3, new AvoidEntityGoal<>(this, Player.class, 8.0F, 1.0D, 1.0D));
        this.goalSelector.addGoal(2, new ManOWarRandomMovementGoal(this));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
    }

    public void handleEntityEvent(byte b) {
        if (b == 19) {
            this.tentacleMovement = 0.0F;
        } else {
            super.handleEntityEvent(b);
        }
    }

    public void setMovementVector(float f, float g, float h) {
        this.tx = f;
        this.ty = g;
        this.tz = h;
    }

    public boolean hasMovementVector() {
        return this.tx != 0.0F || this.ty != 0.0F || this.tz != 0.0F;
    }


    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor serverLevelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        spawnGroupData = super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
        if (mobSpawnType == MobSpawnType.BUCKET && compoundTag != null && compoundTag.contains("BucketVariantTag", 3)) {
            this.setRawFlag(compoundTag.getInt("BucketVariantTag"));
            this.setBaby(true);
            return spawnGroupData;
        } else {
            setColor(getRandColor(random));
            return super.finalizeSpawn(serverLevelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
        }
    }

    @org.jetbrains.annotations.Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        ManOWar manOWar = BYGEntities.MAN_O_WAR.get().create(serverLevel);
        manOWar.setColor(getRandColor(serverLevel.getRandom()));
        return manOWar;
    }

    @Override
    protected void defineSynchedData() {
        this.entityData.define(COLOR, 0);
        this.entityData.define(FROM_BUCKET, false);
        super.defineSynchedData();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        super.addAdditionalSaveData(compoundTag);
        compoundTag.putInt("Flag", this.getRawFlag());
        compoundTag.putBoolean("FromBucket", this.fromBucket());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compoundTag) {
        super.readAdditionalSaveData(compoundTag);
        this.setRawFlag(compoundTag.getInt("Flag"));
        this.setFromBucket(compoundTag.getBoolean("FromBucket"));
    }


    public void aiStep() {
        if (!this.isInWater() && this.onGround && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F), 0.4000000059604645D, (double) ((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.onGround = false;
            this.hasImpulse = true;
            this.playSound(SoundEvents.SALMON_FLOP, this.getSoundVolume(), this.getVoicePitch());
        }

        super.aiStep();
        this.xBodyRotO = this.xBodyRot;
        this.zBodyRotO = this.zBodyRot;
        this.oldTentacleMovement = this.tentacleMovement;
        this.oldTentacleAngle = this.tentacleAngle;
        this.tentacleMovement += this.tentacleSpeed;
        if ((double) this.tentacleMovement > 6.283185307179586D) {
            if (this.level.isClientSide) {
                this.tentacleMovement = 6.2831855F;
            } else {
                this.tentacleMovement = (float) ((double) this.tentacleMovement - 6.283185307179586D);
                if (this.random.nextInt(10) == 0) {
                    this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
                }

                this.level.broadcastEntityEvent(this, (byte) 19);
            }
        }

        if (this.isInWaterOrBubble()) {
            if (this.tentacleMovement < 3.1415927F) {
                float f = this.tentacleMovement / 3.1415927F;
                this.tentacleAngle = Mth.sin(f * f * 3.1415927F) * 3.1415927F * 0.25F;
                if ((double) f > 0.75D) {
                    this.speed = 1.0F;
                    this.rotateSpeed = 1.0F;
                } else {
                    this.rotateSpeed *= 0.8F;
                }
            } else {
                this.tentacleAngle = 0.0F;
                this.speed *= 0.9F;
                this.rotateSpeed *= 0.99F;
            }

            if (!this.level.isClientSide) {
                this.setDeltaMovement(this.tx * this.speed, (double) (this.ty * this.speed), (double) (this.tz * this.speed));
            }
            Vec3 vec3 = this.getDeltaMovement();
            double d = vec3.horizontalDistance();
            this.yBodyRot += (-((float) Mth.atan2(vec3.x, vec3.z)) * 57.295776F - this.yBodyRot) * 0.1F;
            this.setYRot(this.yBodyRot);
            this.zBodyRot = (float) ((double) this.zBodyRot + 3.141592653589793D * (double) this.rotateSpeed * 1.5D);
            this.xBodyRot += (-((float) Mth.atan2(d, vec3.y)) * 57.295776F - this.xBodyRot) * 0.1F;
        } else {
            this.tentacleAngle = Mth.abs(Mth.sin(this.tentacleMovement)) * 3.1415927F * 0.25F;
            if (!this.level.isClientSide) {
                double e = this.getDeltaMovement().y;
                if (this.hasEffect(MobEffects.LEVITATION)) {
                    e = 0.05D * (double) (this.getEffect(MobEffects.LEVITATION).getAmplifier() + 1);
                } else if (!this.isNoGravity()) {
                    e -= 0.08D;
                }
                this.setDeltaMovement(0.0D, e * 0.9800000190734863D, 0.0D);
            }
            this.xBodyRot = (float) ((double) this.xBodyRot + (double) (-90.0F - this.xBodyRot) * 0.02D);
        }
    }

    //getters setters
    public void setColor(@Nonnull Colors color) {
        setFlags(color);
    }

    public void setFlags(@Nonnull Colors color) {
        setRawFlag((color.ordinal() & Byte.MAX_VALUE) << 16);
    }

    public int getRawFlag() {
        return entityData.get(COLOR);
    }

    public void setRawFlag(int flag) {
        entityData.set(COLOR, flag);
    }

    public Colors getColor() {
        return Colors.byIndex((getRawFlag() >> 16) & Byte.MAX_VALUE);
    }

    //colors

    public static Colors getRandColor(RandomSource rand) {
        int i = rand.nextInt(5);
        if (i <= 0) {
            return Colors.MAGENTA;
        } else if (i <= 2) {
            return Colors.BLUE;
        } else if (i <= 3) {
            return Colors.PURPLE;
        } else {
            return Colors.RAINBOW;
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.animatableInstanceCache;
    }

    private static final RawAnimation SWIM_ANIMATION = RawAnimation.begin().thenPlay("animation.man_o_war.swim");
    private static final RawAnimation BEACHED_ANIMATION = RawAnimation.begin().thenPlay("animation.man_o_war.beached");

    private <E extends GeoAnimatable> PlayState predicate(AnimationState<E> event) {
        AnimationController<E> controller = event.getController();
        controller.setTransitionLength(0);
        if (this.isInWater()) {
            controller.setAnimation(SWIM_ANIMATION);
            return PlayState.CONTINUE;
        } else if (!this.isInWater()) {
            controller.setAnimation(BEACHED_ANIMATION);
            return PlayState.CONTINUE;
        } else {
            return PlayState.STOP;
        }
    }


    @Override
    public void spawnChildFromBreeding(ServerLevel level, Animal animal) {
        RandomSource rand = level.getRandom();
        int i = rand.nextIntBetweenInclusive(1, 3);
        for (int j = 0; j < i; j++) {
            ((ManOWar) animal).setColor(getRandColor(level.getRandom()));
            super.spawnChildFromBreeding(level, animal);
        }
    }

    @Override
    public boolean removeWhenFarAway(double pDistanceToClosestPlayer) {
        return !this.fromBucket() && !this.hasCustomName();
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean pFromBucket) {
        this.entityData.set(FROM_BUCKET, pFromBucket);
    }

    @Override
    public void saveToBucketTag(ItemStack var1) {
        Bucketable.saveDefaultDataToBucketTag(this, var1);
        CompoundTag compoundtag = var1.getOrCreateTag();
        compoundtag.putInt("BucketVariantTag", this.getRawFlag());
    }

    @Override
    public void loadFromBucketTag(CompoundTag pTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, pTag);
        pTag.putInt("BucketVariantTag", this.getRawFlag());
    }

    @Override
    public ItemStack getBucketItemStack() {
        return BYGItems.MAN_O_WAR_BUCKET.get().getDefaultInstance();
    }


    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_AXOLOTL;
    }

    public enum Colors {
        BLUE(),
        PURPLE(),
        MAGENTA(),
        RAINBOW();

        public static Colors byIndex(int index) {
            return makeIndex(Colors.values(), index);
        }
    }

    public static <T> T makeIndex(T[] array, int index) {
        return array[index >= array.length ? 0 : index];
    }

    private static class ManOWarRandomMovementGoal extends Goal {
        private final ManOWar mano;

        public ManOWarRandomMovementGoal(ManOWar mano) {
            this.mano = mano;
        }

        public boolean canUse() {
            return true;
        }

        public void tick() {
            int i = this.mano.getNoActionTime();
            if (i > 100) {
                this.mano.setMovementVector(0.0F, 0.0F, 0.0F);
            } else if (this.mano.getRandom().nextInt(50) == 0 || !this.mano.wasTouchingWater || !this.mano.hasMovementVector()) {
                float f = this.mano.getRandom().nextFloat() * 6.2831855F;
                float g = Mth.cos(f) * 0.2F;
                float h = -0.1F + this.mano.getRandom().nextFloat() * 0.2F;
                float j = Mth.sin(f) * 0.2F;
                this.mano.setMovementVector(g, h, j);
            }
        }
    }
}
