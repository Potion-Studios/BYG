package potionstudios.byg.mixin.world.level.storage.loot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.level.storage.loot.LootDataManager;
import net.minecraft.world.level.storage.loot.LootDataType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import potionstudios.byg.BYG;
import potionstudios.byg.config.SettingsConfig;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Optional;

@Mixin(LootDataManager.class)
public abstract class MixinLootTableManager {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();


    @Inject(method = "method_51189(Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/world/level/storage/loot/LootDataType;Ljava/util/Map;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/packs/resources/SimpleJsonResourceReloadListener;scanDirectory(Lnet/minecraft/server/packs/resources/ResourceManager;Ljava/lang/String;Lcom/google/gson/Gson;Ljava/util/Map;)V"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void appendTables(ResourceManager resourceManager, LootDataType $$1x, Map<LootDataType<?>, Map<ResourceLocation, ?>> typeMapMap, CallbackInfo ci, Map<ResourceLocation, JsonElement> values) {
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

    private static JsonArray extractPools(ResourceManager resourceManager, ResourceLocation location) {
        try {
            Optional<Resource> optionalResource = resourceManager.getResource(location);
            if (optionalResource.isPresent()) {
                Resource appendedTable = optionalResource.get();

                InputStream inputstream = appendedTable.open();
                Reader reader = new BufferedReader(new InputStreamReader(inputstream, StandardCharsets.UTF_8));
                JsonElement appendedElement = GsonHelper.fromJson(GSON, reader, JsonElement.class);
                return appendedElement.getAsJsonObject().getAsJsonArray("pools");
            }
        } catch (IOException e) {
            BYG.logError("Could not read appended table:" + location);
            e.printStackTrace();
        }
        return new JsonArray();
    }
}