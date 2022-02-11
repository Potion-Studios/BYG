package potionstudios.byg.mixin.common.world;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYG;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Mixin(ServerLevel.class)
public abstract class MixinServerLevel {

    @Shadow
    @Nonnull
    public abstract MinecraftServer getServer();

    @Inject(method = "addNewPlayer", at = @At("HEAD"))
    private void warnExperimentalBYG(ServerPlayer serverPlayer, CallbackInfo ci) {
        if (BYG.WARN_EXPERIMENTAL) {
            if (this.getServer().isSingleplayer()) {
                final Path marker = BYG.CONFIG_PATH.resolve("EXPERIMENTAL_WARNING_MARKER_" + BYG.EXPERIMENTAL_WARNING_VERSION + ".txt");
                if (!marker.toFile().exists()) {
                    serverPlayer.displayClientMessage(new TranslatableComponent("byg.experimental.warning").withStyle(ChatFormatting.YELLOW), false);
                    try {
                        Files.createDirectories(marker.getParent());
                        Files.write(marker, "This file exists as a marker to warn the user of experimental settings. Once this file generates, the experimental warning will no longer show in the chat.".getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
