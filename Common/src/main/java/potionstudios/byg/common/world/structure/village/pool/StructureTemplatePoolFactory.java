package potionstudios.byg.common.world.structure.village.pool;

import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import potionstudios.byg.BYG;

import java.util.Map;

@FunctionalInterface
public interface StructureTemplatePoolFactory {

    Map<ResourceKey<StructureTemplatePool>, StructureTemplatePoolFactory> STRUCTURE_TEMPLATE_POOL_FACTORIES = new Reference2ObjectOpenHashMap<>();


    StructureTemplatePool generate(BootstapContext<StructureTemplatePool> context);

    static ResourceKey<StructureTemplatePool> register(String id, StructureTemplatePoolFactory structureTemplatePoolFactory) {
        ResourceKey<StructureTemplatePool> biomeResourceKey = ResourceKey.create(Registries.TEMPLATE_POOL, BYG.createLocation(id));
        StructureTemplatePoolFactory.STRUCTURE_TEMPLATE_POOL_FACTORIES.put(biomeResourceKey, structureTemplatePoolFactory);

        return biomeResourceKey;
    }
}
