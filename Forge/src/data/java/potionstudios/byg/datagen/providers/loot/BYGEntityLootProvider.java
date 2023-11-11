package potionstudios.byg.datagen.providers.loot;

import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.entity.boat.BYGBoat;

import java.util.function.BiConsumer;

import static net.minecraft.world.level.storage.loot.entries.LootItem.lootTableItem;
import static net.minecraft.world.level.storage.loot.providers.number.ConstantValue.exactly;

public class BYGEntityLootProvider extends EntityLootSubProvider {

    protected BYGEntityLootProvider(FeatureFlagSet pEnabledFeatures) {
        super(pEnabledFeatures);
    }

    @Override
    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> consumer) {
        for (final BYGWoodTypes type : BYGWoodTypes.values()) {
            if (type.boatType() == null) {
                continue;
            }

            for (boolean isChest : new Boolean[]{true, false}) {
                consumer.accept(BYGBoat.getLootLocation(type.boatType(), isChest, false), LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
                                .add(LootItem.lootTableItem(isChest ? type.chestBoat().get() : type.boat().get()))));
                var loot = LootTable.lootTable()
                        .withPool(LootPool.lootPool().setRolls(exactly(2))
                                .add(lootTableItem(Items.STICK)))
                        .withPool(LootPool.lootPool().setRolls(exactly(3))
                                .add(lootTableItem(type.planks().get())));
                if (isChest) {
                    loot.withPool(LootPool.lootPool().setRolls(exactly(1))
                            .add(lootTableItem(Items.CHEST)));
                }

                consumer.accept(BYGBoat.getLootLocation(type.boatType(), isChest, true), loot);
            }
        }
    }

    @Override
    public void generate() {

    }
}
