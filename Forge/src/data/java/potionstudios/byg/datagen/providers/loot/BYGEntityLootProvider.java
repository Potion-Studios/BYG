package potionstudios.byg.datagen.providers.loot;

import net.minecraft.data.loot.EntityLoot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.entity.boat.BYGBoatEntity;

import java.util.List;
import java.util.function.BiConsumer;

import static net.minecraft.world.level.storage.loot.entries.LootItem.*;
import static net.minecraft.world.level.storage.loot.providers.number.ConstantValue.*;

public class BYGEntityLootProvider extends EntityLoot {

    @Override
    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> cons) {
        super.accept(cons);
    }

    @Override
    protected void addTables() {
        for (final BYGWoodTypes type : BYGWoodTypes.values()) {
            if (type.boatType() == null)
                continue;
            add(BYGBoatEntity.getLootLocation(type.boatType(), false), LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                            .add(LootItem.lootTableItem(type.boat().get()))));

            add(BYGBoatEntity.getLootLocation(type.boatType(), true), LootTable.lootTable()
                    .withPool(LootPool.lootPool().setRolls(exactly(2))
                            .add(lootTableItem(Items.STICK)))
                    .withPool(LootPool.lootPool().setRolls(exactly(3))
                            .add(lootTableItem(type.planks().get()))));
        }
    }

    @Override
    protected @NotNull Iterable<EntityType<?>> getKnownEntities() {
        return List.of();
    }
}
