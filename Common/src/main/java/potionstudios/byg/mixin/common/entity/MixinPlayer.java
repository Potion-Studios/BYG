package potionstudios.byg.mixin.common.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.common.entity.player.extension.BiomepediaExtension;
import potionstudios.byg.server.level.BYGPlayerTrackedData;
import potionstudios.byg.util.BYGAdditionalData;

import java.util.HashMap;

@Mixin(Player.class)
public class MixinPlayer implements BYGAdditionalData, BYGPlayerTrackedData.Access, BiomepediaExtension {

    private BYGPlayerTrackedData bygPlayerTrackedData = new BYGPlayerTrackedData(new HashMap<>());

    private boolean gotBiomepedia = false;

    @Inject(method = "addAdditionalSaveData", at = @At("RETURN"))
    private void writeBYGData(CompoundTag tag, CallbackInfo ci) {
        this.writeBYG(tag);
    }

    @Inject(method = "readAdditionalSaveData", at = @At("RETURN"))
    private void readBYGData(CompoundTag tag, CallbackInfo ci) {
        this.readBYG(tag);
    }

    @Override
    public Tag write() {
        CompoundTag tag = (CompoundTag) BYGPlayerTrackedData.CODEC.encodeStart(NbtOps.INSTANCE, this.bygPlayerTrackedData).result().orElseThrow();
        tag.putBoolean("biomepedia", gotBiomepedia);
        return tag;
    }

    @Override
    public void read(CompoundTag tag) {
        this.bygPlayerTrackedData = BYGPlayerTrackedData.CODEC.decode(NbtOps.INSTANCE, tag).result().orElseThrow().getFirst();
        this.gotBiomepedia = tag.contains("biomepedia") && tag.getBoolean("biomepedia");
    }

    @Override
    public BYGPlayerTrackedData getPlayerTrackedData() {
        return this.bygPlayerTrackedData;
    }

    @Override
    public BYGPlayerTrackedData setPlayerTrackedData(BYGPlayerTrackedData newVal) {
        this.bygPlayerTrackedData = newVal;
        return this.bygPlayerTrackedData;
    }

    @Override
    public void setGotBiomepedia(boolean gotBiomepedia) {
        this.gotBiomepedia = gotBiomepedia;
    }

    @Override
    public boolean gotBiomepedia() {
        return this.gotBiomepedia;
    }
}
