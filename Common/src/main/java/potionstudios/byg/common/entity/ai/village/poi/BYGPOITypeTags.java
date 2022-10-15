package potionstudios.byg.common.entity.ai.village.poi;

import net.minecraft.core.Registry;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import potionstudios.byg.BYG;

public class BYGPOITypeTags {

    public static final TagKey<PoiType> ACQUIRABLE_JOB_SITE = create("acquirable_job_site");

    private static TagKey<PoiType> create(String path) {
        return TagKey.create(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, BYG.createLocation(path));
    }

    public static void loadClass() {
    }
}
