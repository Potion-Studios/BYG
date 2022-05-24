package potionstudios.byg.mixin.dev;

import net.minecraftforge.client.model.generators.ModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ModelProvider.class)
public interface ModelProviderAccess {
    @Accessor("TEXTURE")
    static ExistingFileHelper.ResourceType getTexture() {
        throw new Error("Mixin failed!");
    }
}
