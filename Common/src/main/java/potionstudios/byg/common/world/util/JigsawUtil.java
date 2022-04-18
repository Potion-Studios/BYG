package potionstudios.byg.common.world.util;

import com.google.gson.JsonElement;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.JsonOps;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.StructureTemplatePoolAccess;
import potionstudios.byg.util.GSONUtil;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class JigsawUtil {
    private static final ResourceKey<StructureProcessorList> EMPTY_PROCESSOR_LIST_KEY = ResourceKey.create(
        Registry.PROCESSOR_LIST_REGISTRY, new ResourceLocation("minecraft", "empty"));

    public static void addBYGBuildingsToPool(Registry<StructureTemplatePool> templatePoolRegistry,
                                             Registry<StructureProcessorList> processorListRegistry) {
        addLegacyBuildingToPool(new ResourceLocation("village/plains/houses"), "byg:minecraft/village/plains/houses/plains_forager_1", 2, templatePoolRegistry, processorListRegistry);
        addLegacyBuildingToPool(new ResourceLocation("village/taiga/houses"), "byg:minecraft/village/plains/houses/taiga_forager_1", 2, templatePoolRegistry, processorListRegistry);
    }


    private static void addLegacyBuildingToPool(ResourceLocation poolRL, String nbtPieceRL, int weight,
                                                Registry<StructureTemplatePool> templatePoolRegistry,
                                                Registry<StructureProcessorList> processorListRegistry) {
        addBuildingToPool(poolRL, nbtPieceRL, weight, templatePoolRegistry, processorListRegistry, SinglePoolElement::legacy);
    }

    private static void addBuildingToPool(ResourceLocation poolRL, String nbtPieceRL, int weight,
                                          Registry<StructureTemplatePool> templatePoolRegistry,
                                          Registry<StructureProcessorList> processorListRegistry, BiFunction<String, Holder<StructureProcessorList>, Function<StructureTemplatePool.Projection, ? extends SinglePoolElement>> construction) {

        // Grabs the processor list we want to use along with our piece.
        // This is a requirement as using the ProcessorLists.EMPTY field will cause the game to throw errors.
        // The reason why is the empty processor list in the world's registry is not the same instance as in that field once the world is started up.
        Holder<StructureProcessorList> emptyProcessorList = processorListRegistry.getHolderOrThrow(EMPTY_PROCESSOR_LIST_KEY);

        // Grab the pool we want to add to
        StructureTemplatePool pool = templatePoolRegistry.get(poolRL);
        if (pool == null) {
            BYG.LOGGER.warn(String.format("Ignoring pool %s bc it's not available.", poolRL.toString()));
            return;
        }
        List<Pair<StructurePoolElement, Integer>> listOfPieceEntries = new ArrayList<>(((StructureTemplatePoolAccess) pool).byg_getRawTemplates());

        for (Pair<StructurePoolElement, Integer> listOfPieceEntry : listOfPieceEntries) {
            JsonElement jsonElement = StructurePoolElement.CODEC.encodeStart(JsonOps.INSTANCE, listOfPieceEntry.getFirst()).result().orElseThrow();
            @Nullable
            String location = GSONUtil.readFirstField("location", String.class, jsonElement);
            if (nbtPieceRL.equals(location)) {
                return;
            }
        }

        // Grabs the nbt piece and creates a SinglePoolElement of it that we can add to a structure's pool.
        StructurePoolElement piece = construction.apply(nbtPieceRL, emptyProcessorList).apply(StructureTemplatePool.Projection.RIGID);

        // Use AccessTransformer or Accessor Mixin to make StructureTemplatePool's templates field public for us to see.
        // Weight is handled by how many times the entry appears in this list.
        // We do not need to worry about immutability as this field is created using Lists.newArrayList(); which makes a mutable list.
        for (int i = 0; i < weight; i++) {
            ((StructureTemplatePoolAccess) pool).byg_getTemplates().add(piece);
        }

        // Use AccessTransformer or Accessor Mixin to make StructureTemplatePool's rawTemplates field public for us to see.
        // This list of pairs of pieces and weights is not used by vanilla by default but another mod may need it for efficiency.
        // So lets add to this list for completeness. We need to make a copy of the array as it can be an immutable list.

        listOfPieceEntries.add(new Pair<>(piece, weight));
        ((StructureTemplatePoolAccess) pool).byg_setRawTemplates(listOfPieceEntries);
    }
}