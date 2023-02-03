package potionstudios.byg.mixin.common.world.level.storage.loot;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.GsonHelper;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.level.storage.loot.LootTables;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYG;
import potionstudios.byg.config.SettingsConfig;
import potionstudios.byg.mixin.access.JsonReloadListenerAccess;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;

@Mixin(LootTables.class)
public abstract class MixinLootTableManager extends SimpleJsonResourceReloadListener {

    public MixinLootTableManager(Gson gson, String string) {
        super(gson, string);
    }

    @Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"))
    private void appendTables(Map<ResourceLocation, JsonElement> values, ResourceManager resourceManager, ProfilerFiller profilerFiller, CallbackInfo ci) {
        if (!SettingsConfig.getConfig().appendLootTables()) {
            return;
        }
        String appendTablesDir = "append_loot_tables";
        Map<ResourceLocation, Resource> resourceMap = resourceManager.listResources(appendTablesDir, (key) -> key.toString().endsWith(".json"));
        for (ResourceLocation resourceLocation : resourceMap.keySet()) {
            ResourceLocation key = new ResourceLocation(resourceLocation.getPath().replace(appendTablesDir + "/", "").replaceFirst("/", ":").replace(".json", ""));
            if (values.containsKey(key)) {
                values.get(key).getAsJsonObject().getAsJsonArray("pools").addAll(extractPools(resourceManager, resourceLocation));
            }
        }
    }

    private JsonArray extractPools(ResourceManager resourceManager, ResourceLocation location) {
        try {
            Optional<Resource> optionalResource = resourceManager.getResource(location);
            if (optionalResource.isPresent()) {
                Resource appendedTable = optionalResource.get();

                InputStream inputstream = appendedTable.open();
                Reader reader = new BufferedReader(new InputStreamReader(inputstream, StandardCharsets.UTF_8));
                JsonElement appendedElement = GsonHelper.fromJson(((JsonReloadListenerAccess) this).byg_getGson(), reader, JsonElement.class);
                return appendedElement.getAsJsonObject().getAsJsonArray("pools");
            }
        } catch (IOException e) {
            BYG.logError("Could not read appended table:" + location);
            e.printStackTrace();
        }
        return new JsonArray();
    }
}