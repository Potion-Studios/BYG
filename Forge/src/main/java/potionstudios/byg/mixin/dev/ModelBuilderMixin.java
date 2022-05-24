package potionstudios.byg.mixin.dev;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModelBuilder.class)
public class ModelBuilderMixin {

    @Shadow @Final protected ExistingFileHelper existingFileHelper;
    private static final Logger LOG = LogUtils.getLogger();

    @Redirect(method = "texture(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraftforge/client/model/generators/ModelBuilder;", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/data/ExistingFileHelper;exists(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraftforge/common/data/ExistingFileHelper$IResourceType;)Z"), remap = false)
    private boolean shushTextureNotFound(ExistingFileHelper instance, ResourceLocation loc, ExistingFileHelper.IResourceType type) {
        if (!instance.exists(loc, ModelProviderAccess.getTexture())) {
            LOG.info("Texture {} does not exist in any known resource pack", loc);
        }
        return true;
    }

}
