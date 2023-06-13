package potionstudios.byg.mixin.access;

import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PressurePlateBlock.class)
public interface PressurePlateBlockAccess {

    @Invoker("<init>")
    static PressurePlateBlock byg_create(PressurePlateBlock.Sensitivity sensitivity, BlockBehaviour.Properties properties, BlockSetType blockSetType) {
        throw new Error("Mixin did not apply!");
    }
}
