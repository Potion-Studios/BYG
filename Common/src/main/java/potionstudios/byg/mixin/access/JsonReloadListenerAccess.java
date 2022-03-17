package potionstudios.byg.mixin.access;
import com.google.gson.Gson;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(SimpleJsonResourceReloadListener.class)
public interface JsonReloadListenerAccess {

    @Accessor("gson")
    Gson byg_getGson();

}