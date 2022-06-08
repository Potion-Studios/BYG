package potionstudios.byg.mixin.dev;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ModelBuilder.class)
public class ModelBuilderMixin {

    private static final Logger LOG = LogUtils.getLogger();

    private static boolean byg$foundSnowyLeaves;

    @Redirect(method = "texture(Ljava/lang/String;Lnet/minecraft/resources/ResourceLocation;)Lnet/minecraftforge/client/model/generators/ModelBuilder;", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/common/data/ExistingFileHelper;exists(Lnet/minecraft/resources/ResourceLocation;Lnet/minecraftforge/common/data/ExistingFileHelper$IResourceType;)Z"), remap = false)
    private boolean shushTextureNotFound(ExistingFileHelper instance, ResourceLocation loc, ExistingFileHelper.IResourceType type) {
        if (loc.getPath().contains("leaves_snowy")) {
            if (!byg$foundSnowyLeaves)
                LOG.warn("Snowy Leaves textures still seem to be missing...");
            byg$foundSnowyLeaves = true;
            return true;
        }
        if (!instance.exists(loc, ModelProviderAccess.getTexture())) {
            LOG.warn("Texture {} does not exist in any known resource pack", loc);
        }
        return true;
    }

}
