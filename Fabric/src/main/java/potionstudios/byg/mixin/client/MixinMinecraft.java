package potionstudios.byg.mixin.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.main.GameConfig;
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
import potionstudios.byg.entry.BYGTerraBlenderEntry;

import java.util.function.Function;

@Mixin(Minecraft.class)
public abstract class MixinMinecraft {

    @Shadow
    public abstract void setScreen(@Nullable Screen guiScreen);

    @Shadow
    protected abstract void doLoadLevel(String levelName, Function<LevelStorageSource.LevelStorageAccess, WorldStem.DataPackConfigSupplier> levelSaveToDatapackFunction, Function<LevelStorageSource.LevelStorageAccess, WorldStem.WorldDataSupplier> function, boolean vanillaOnly, Minecraft.ExperimentalDialogType selectionType);

    @Inject(method = "<init>", at = @At("RETURN"))
    private void byg_MinecraftInit(GameConfig gameConfig, CallbackInfo ci) {
        BYGTerraBlenderEntry.readOverworldSurfaceRules();
    }

    @Inject(method = "doLoadLevel", at = @At("HEAD"), cancellable = true)
    private void loadBYGConfigs(String levelName, Function<LevelStorageSource.LevelStorageAccess, WorldStem.DataPackConfigSupplier> levelSaveToDatapackFunction, Function<LevelStorageSource.LevelStorageAccess, WorldStem.WorldDataSupplier> function, boolean vanillaOnly, Minecraft.ExperimentalDialogType selectionType, CallbackInfo ci) {
        try {
            String loadAllConfigs = BYGConfigHandler.loadAllConfigs(true, false);
            if (!loadAllConfigs.isEmpty()) {
                throw new IllegalStateException(loadAllConfigs);
            }
        } catch (Exception e) {
            this.setScreen(new BYGConfigLoadFailureScreen(e,
                    () -> doLoadLevel(levelName, levelSaveToDatapackFunction, function, vanillaOnly, selectionType)
            ));
            ci.cancel();
        }
    }
}