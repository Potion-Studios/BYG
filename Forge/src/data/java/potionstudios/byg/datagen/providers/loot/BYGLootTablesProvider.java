package potionstudios.byg.datagen.providers.loot;

import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.Set;

@MethodsReturnNonnullByDefault
public class BYGLootTablesProvider extends LootTableProvider {
    public BYGLootTablesProvider(DataGenerator pGenerator) {
        super(pGenerator.getPackOutput(), Set.of(), List.of(new SubProviderEntry(() -> new BYGBlockLootProvider(Set.of(), FeatureFlags.REGISTRY.allFlags()), LootContextParamSets.BLOCK), new SubProviderEntry(() -> new BYGEntityLootProvider(FeatureFlags.REGISTRY.allFlags()), LootContextParamSets.ENTITY)));
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationtracker) {
        map.forEach((id, table) -> LootTables.validate(validationtracker, id, table));
    }
}
