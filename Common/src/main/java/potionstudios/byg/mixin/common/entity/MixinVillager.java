package potionstudios.byg.mixin.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerData;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.entity.pumpkinwarden.PumpkinWarden;

@Mixin(Villager.class)
public class MixinVillager extends AbstractVillager {

    public MixinVillager(EntityType<? extends AbstractVillager> $$0, Level $$1) {
        super($$0, $$1);
    }

    @Inject(method = "mobInteract", at = @At("HEAD"))
    public void makeWarden(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (this.hasEffect(MobEffects.WEAKNESS) && player.getItemInHand(hand).is(Items.CARVED_PUMPKIN) && this.isBaby()) {
            PumpkinWarden warden = BYGEntities.PUMPKIN_WARDEN.get().create(player.level);
            warden.setPos(this.position());
            this.level.addFreshEntity(warden);
            this.level.playSound(null, this.blockPosition(), SoundEvents.ZOMBIE_VILLAGER_CURE, SoundSource.NEUTRAL, 1, 1);
            this.remove(RemovalReason.DISCARDED);
        }
    }

    @Shadow
    protected void rewardTradeXp(@NotNull MerchantOffer var1) {
    }

    @Shadow
    protected void updateTrades() {
    }

    @Shadow @Final private static EntityDataAccessor<VillagerData> DATA_VILLAGER_DATA;

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(@NotNull ServerLevel $$0, @NotNull AgeableMob $$1) {
        double $$2 = this.random.nextDouble();
        VillagerType $$3;
        if ($$2 < 0.5D) {
            $$3 = VillagerType.byBiome($$0.getBiome(this.blockPosition()));
        } else if ($$2 < 0.75D) {
            $$3 = this.entityData.get(DATA_VILLAGER_DATA).getType();
        } else {
            $$3 = ((Villager)$$1).getVillagerData().getType();
        }

        Villager $$6 = new Villager(EntityType.VILLAGER, $$0, $$3);
        $$6.finalizeSpawn($$0, $$0.getCurrentDifficultyAt($$6.blockPosition()), MobSpawnType.BREEDING, null, null);
        return $$6;
    }
}
