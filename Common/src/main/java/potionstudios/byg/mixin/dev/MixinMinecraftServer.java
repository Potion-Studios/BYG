package potionstudios.byg.mixin.dev;

import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = MinecraftServer.class, priority = 500)
public class MixinMinecraftServer {

    @ModifyConstant(method = "prepareLevels", constant = @Constant(intValue = 11, ordinal = 0))
    private static int fastSpawn(int constant) {
        return 0;
    }

    @ModifyConstant(method = "prepareLevels", constant = @Constant(intValue = 441, ordinal = 0))
    private static int fastSpawn2(int constant) {
        return 0;
    }
}