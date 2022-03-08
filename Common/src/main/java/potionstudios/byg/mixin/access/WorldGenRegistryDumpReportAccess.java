package potionstudios.byg.mixin.access;

import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Encoder;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.HashCache;
import net.minecraft.data.info.WorldgenRegistryDumpReport;
import net.minecraft.resources.ResourceKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.nio.file.Path;

@Mixin(WorldgenRegistryDumpReport.class)
public interface WorldGenRegistryDumpReportAccess {

    @Invoker("dumpRegistryCap")
    static <T> void byg_invokeDumpRegistryCap(HashCache p_194684_, Path p_194685_, RegistryAccess p_194686_, DynamicOps<JsonElement> p_194687_, RegistryAccess.RegistryData<T> p_194688_) {
        throw new Error("Mixin did not apply");
    }

    @Invoker("dumpRegistry")
    static <E, T extends Registry<E>> void byg_invokeDumpRegistry(Path $$0, HashCache $$1, DynamicOps<JsonElement> $$2, ResourceKey<? extends T> $$3, T $$4, Encoder<E> $$5) {
        throw new Error("Mixin did not apply");
    }
}
