package potionstudios.byg.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.server.WorldStem;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.client.gui.screen.BYGConfigLoadFailureScreen;
import potionstudios.byg.config.BYGConfigHandler;

import java.util.function.Function;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {


    @Shadow
    public abstract void setScreen(@Nullable Screen $$0);


    @Shadow
    protected abstract void doLoadLevel(String par1, Function<LevelStorageSource.LevelStorageAccess, WorldStem.DataPackConfigSupplier> par2, Function<LevelStorageSource.LevelStorageAccess, WorldStem.WorldDataSupplier> par3, boolean par4, Minecraft.ExperimentalDialogType par5, boolean par6);

    @SuppressWarnings("InvalidInjectorMethodSignature")
    @Inject(method = "doLoadLevel", at = @At("HEAD"), cancellable = true, remap = false)
    private void loadBYGConfigs(String p_205206_, Function<LevelStorageSource.LevelStorageAccess, WorldStem.DataPackConfigSupplier> p_205207_, Function<LevelStorageSource.LevelStorageAccess, WorldStem.WorldDataSupplier> p_205208_, boolean p_205209_, Minecraft.ExperimentalDialogType p_205210_, boolean creating, CallbackInfo ci) {
        try {
            String loadAllConfigs = BYGConfigHandler.loadAllConfigs(true, false);
            if(!loadAllConfigs.isEmpty()) {
                throw new IllegalStateException(loadAllConfigs);
            }
        } catch (Exception e) {
            this.setScreen(new BYGConfigLoadFailureScreen(e,
                    () -> doLoadLevel(p_205206_, p_205207_, p_205208_, p_205209_, p_205210_, creating)
            ));
            ci.cancel();
        }
    }
}
