package potionstudios.byg.mixin.access;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PressurePlateBlock.class)
public interface PressurePlateBlockAccess {

    @Invoker("<init>")
    static PressurePlateBlock byg_create(PressurePlateBlock.Sensitivity sensitivity, BlockBehaviour.Properties properties, SoundEvent soundOff, SoundEvent soundOn) {
        throw new Error("Mixin did not apply!");
    }
}
