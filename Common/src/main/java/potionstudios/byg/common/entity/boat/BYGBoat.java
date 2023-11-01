package potionstudios.byg.common.entity.boat;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.registration.BYGBlockFamilies;
import potionstudios.byg.common.registration.BYGBlockFamily;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.loot.BYGLootContextParams;
import potionstudios.byg.mixin.access.BoatEntityAccess;

import java.util.List;

public class BYGBoat extends Boat {
    private static final EntityDataAccessor<String> BYG_BOAT_TYPE = SynchedEntityData.defineId(BYGBoat.class, EntityDataSerializers.STRING);
    private static final LootContextParamSet LOOT_CONTEXT_PARAM_SETS = LootContextParamSet.builder()
            .required(BYGLootContextParams.BOAT_TYPE)
            .required(LootContextParams.THIS_ENTITY)
            .required(LootContextParams.ORIGIN)
            .required(LootContextParams.DAMAGE_SOURCE)
            .build();

    public BYGBoat(Level worldIn, double x, double y, double z) {
        this(BYGEntities.BOAT.get(), worldIn);
        this.setPos(x, y, z);
        this.setDeltaMovement(Vec3.ZERO);
        this.xo = x;
        this.yo = y;
        this.zo = z;
    }

    public BYGBoat(EntityType<? extends Boat> boatEntityType, Level worldType) {
        super(boatEntityType, worldType);
    }

    public static ResourceLocation getLootLocation(BYGBlockFamily type, boolean isChest, boolean isFall) {
        final var regName = BYGEntities.BOAT.getId();
        String typeName = type.getBaseName() + (isChest ? "_chest" : "");
        return isFall ? new ResourceLocation(regName.getNamespace(), "boats/" + typeName + "_fall") : new ResourceLocation(regName.getNamespace(), "boats/" + typeName);
    }

    public List<ItemStack> getDrops(DamageSource damageSource, boolean isFall) {
        if (level() instanceof ServerLevel serverLevel) {
            LootParams lootContext = new LootParams.Builder(serverLevel)
                    .withParameter(BYGLootContextParams.BOAT_TYPE, getBYGBoatType())
                    .withParameter(LootContextParams.THIS_ENTITY, this)
                    .withParameter(LootContextParams.ORIGIN, position())
                    .withParameter(LootContextParams.DAMAGE_SOURCE, damageSource)
                    .create(LOOT_CONTEXT_PARAM_SETS);
            final var regName = BuiltInRegistries.ENTITY_TYPE.getKey(this.getType());
            final var defaultLocation = this.getType().getDefaultLootTable();
            final var any = serverLevel.getServer().getLootData().getLootTable(isFall ? new ResourceLocation(defaultLocation.getNamespace(), defaultLocation.getPath() + "_fall") : defaultLocation);
            if (any != LootTable.EMPTY)
                return any.getRandomItems(lootContext);

            final var lootTable = serverLevel.getServer().getLootData()
                    .getLootTable(getLootLocation(getBYGBoatType(), this instanceof BYGChestBoat, isFall));
            return lootTable.getRandomItems(lootContext);
        }
        return List.of();
    }

    @Override
    public @NotNull Item getDropItem() {
        final var type = getBYGBoatType().get(BYGBlockFamily.ItemVariant.BOAT);
        if (type != null)
            return type;
        return BYGWoodTypes.ASPEN.boat().get();
    }

    public Block getPlanks() {
        final var type = getBYGBoatType().get(BYGBlockFamily.BlockVariant.PLANKS);
        if (type != null)
            return type;
        return BYGWoodTypes.ASPEN.planks().get();
    }

    public BYGBlockFamily getBYGBoatType() {
        return BYGBlockFamilies.woodFamilyMap.get(this.entityData.get(BYG_BOAT_TYPE));
    }

    public void setBYGBoatType(BYGBlockFamily boatBYGType) {
        this.entityData.set(BYG_BOAT_TYPE, boatBYGType.getBaseName());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(BYG_BOAT_TYPE, BYGBlockFamilies.HOLLY.getBaseName());
    }


    @Override
    protected void addAdditionalSaveData(CompoundTag compound) {
        compound.putString("BYGType", this.getBYGBoatType().getBaseName());
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compound) {
        if (compound.contains("BYGType", 8)) {
            this.setBYGBoatType(BYGBlockFamilies.woodFamilyMap.get(compound.getString("BYGType")));
        }
    }

    @Override
    public void animateHurt(float f) {
        this.setHurtDir(-this.getHurtDir());
        this.setHurtTime(10);
        this.setDamage(this.getDamage() * 11.0F);
    }

    @Override
    protected void checkFallDamage(double y, boolean onGroundIn, @NotNull BlockState state, @NotNull BlockPos pos) {
        ((BoatEntityAccess) this).byg_setLastYd(this.getDeltaMovement().y);
        if (!this.isPassenger()) {
            if (onGroundIn) {
                if (this.fallDistance > 3.0F) {
                    if (((BoatEntityAccess) this).byg_getStatusField() != Boat.Status.ON_LAND) {
                        this.fallDistance = 0.0F;
                        return;
                    }

                    this.causeFallDamage(this.fallDistance, 1.0F, this.damageSources().fall());
                    if (!this.level().isClientSide && !this.isRemoved()) {
                        this.kill();
                        if (this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                            getDrops(this.damageSources().fall(), true).forEach(this::spawnAtLocation);
                        }
                    }
                }

                this.fallDistance = 0.0F;
            } else if (!this.level().getFluidState((BlockPos.containing(this.getX(), this.getY(), this.getZ()).below())).is(FluidTags.WATER) && y < 0.0D) {
                this.fallDistance = (float) (this.fallDistance - y);
            }

        }
    }
    @Override
    public boolean hurt(@NotNull DamageSource source, float amount) {
        if (this.isInvulnerableTo(source)) {
            return false;
        } else if (!this.level().isClientSide && !this.isRemoved()) {
            if (source.isIndirect() && source.getEntity() != null && this.hasPassenger(source.getEntity())) {
                return false;
            } else {
                this.setHurtDir(-this.getHurtDir());
                this.setHurtTime(10);
                this.setDamage(this.getDamage() + amount * 10.0F);
                this.markHurt();
                boolean flag = source.getEntity() instanceof Player player && player.getAbilities().instabuild;
                if (flag || this.getDamage() > 40.0F) {
                    if (!flag && this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                        getDrops(source, false).forEach(this::spawnAtLocation);
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
    public @NotNull Packet<ClientGamePacketListener> getAddEntityPacket() {
        //TODO: Is this right?
        return new ClientboundAddEntityPacket(this);
    }
}
