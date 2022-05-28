package potionstudios.byg.datagen.providers.tag;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.world.biome.BYGBiomeType;
import potionstudios.byg.datagen.util.DatagenUtils;

public class BYGBiomeTagsProvider extends BiomeTagsProvider {
    public BYGBiomeTagsProvider(DataGenerator gen, @Nullable ExistingFileHelper existingFileHelper) {
        super(gen, BYG.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (final BYGBiomeType type : BYGBiomeType.values()) {
            tag(type.tag()).add(type.getBiomes().toArray(Biome[]::new));
        }

        DatagenUtils.sortTagsAlphabeticallyAndRemoveDuplicateTagEntries(this.builders);
    }
}
