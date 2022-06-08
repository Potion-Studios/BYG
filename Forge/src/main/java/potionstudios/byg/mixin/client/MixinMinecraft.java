package potionstudios.byg.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.server.WorldStem;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.world.level.storage.LevelStorageSource;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.client.gui.screen.BYGConfigLoadFailureScreen;
import potionstudios.byg.config.BYGConfigHandler;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Shadow
    public abstract void setScreen(@Nullable Screen $$0);

    @Shadow
    public abstract void doWorldLoad(String p_231381_, LevelStorageSource.LevelStorageAccess p_231382_, PackRepository p_231383_, WorldStem p_231384_);

    @Inject(method = "doWorldLoad", at = @At("HEAD"), cancellable = true, remap = false)
    private void loadBYGConfigs(String p_231381_, LevelStorageSource.LevelStorageAccess p_231382_, PackRepository p_231383_, WorldStem p_231384_, CallbackInfo ci) {
        try {
            String loadAllConfigs = BYGConfigHandler.loadAllConfigs(true, false);
            if(!loadAllConfigs.isEmpty()) {
                throw new IllegalStateException(loadAllConfigs);
            }
        } catch (Exception e) {
            this.setScreen(new BYGConfigLoadFailureScreen(e,
                    () -> doWorldLoad(p_231381_, p_231382_, p_231383_, p_231384_)
            ));
            ci.cancel();
        }
    }
}
