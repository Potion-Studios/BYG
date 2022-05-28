package potionstudios.byg.datagen.providers.loot;

import com.mojang.datafixers.util.Pair;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.LootTables;
import net.minecraft.world.level.storage.loot.ValidationContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSet;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

@MethodsReturnNonnullByDefault
public class BYGLootTablesProvider extends LootTableProvider {
    public BYGLootTablesProvider(DataGenerator pGenerator) {
        super(pGenerator);
    }

    private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> tables = List.of(
        Pair.of(BYGBlockLootProvider::new, LootContextParamSets.BLOCK),
        Pair.of(BYGEntityLootProvider::new, LootContextParamSets.ENTITY)
    );

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootContextParamSet>> getTables() {
        return tables;
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, @NotNull ValidationContext validationtracker) {
        map.forEach((id, table) -> LootTables.validate(validationtracker, id, table));
    }
}
