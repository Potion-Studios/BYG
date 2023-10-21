package potionstudios.byg.datagen.providers.lang;

import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.locale.Language;
import net.minecraft.resources.ResourceKey;
import net.minecraftforge.common.data.LanguageProvider;
import org.apache.commons.lang3.text.WordUtils;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.common.world.biome.BYGBiomes;
import potionstudios.byg.reg.RegistrationProvider;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class EnUsLanguageProvider extends LanguageProvider {

    public static final Map<RegistrationProvider<?>, String> PROVIDER_TO_ID = Util.make(new HashMap<>(), map -> {
        map.put(BYGEntities.PROVIDER, "entity");
        map.put(BYGBiomes.PROVIDER, "biome");
        map.put(BYGBlocks.PROVIDER, "block");
        map.put(BYGItems.PROVIDER, "item");
//        map.put(BYGWorldPresets.PROVIDER, "generator");
    });

    public EnUsLanguageProvider(DataGenerator gen) {
        super(gen.getPackOutput(), BYG.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {

        BYGBiomes.BIOME_FACTORIES.keySet().forEach(biomeResourceKey -> {
            add(biomeResourceKey.location().toLanguageKey("biome"),
                    WordUtils.capitalize(biomeResourceKey.location().getPath().replace("_", " ")));
        });

        PROVIDER_TO_ID.forEach((provider, id) -> provider.getEntries().forEach(entry -> {
            final var descId = Util.makeDescriptionId(id, entry.getId());
            add(descId, WordUtils.capitalize(entry.getId().getPath().replace("_", " ")));
        }));

        final InputStream resourceAsStream = BYG.class.getResourceAsStream("/assets/byg/lang/en_us_misc.json");
        if (resourceAsStream != null) {
            Language.loadFromJson(resourceAsStream, this::add);
        }
    }

}
