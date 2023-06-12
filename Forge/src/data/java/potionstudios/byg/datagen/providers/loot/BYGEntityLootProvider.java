//package potionstudios.byg.datagen.providers.loot;
//
//import net.minecraft.data.loot.EntityLoot;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.level.storage.loot.LootPool;
//import net.minecraft.world.level.storage.loot.LootTable;
//import net.minecraft.world.level.storage.loot.entries.LootItem;
//import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
//import org.jetbrains.annotations.NotNull;
//import potionstudios.byg.common.block.BYGWoodTypes;
//import potionstudios.byg.common.entity.boat.BYGBoat;
//
//import java.util.List;
//import java.util.function.BiConsumer;
//
//import static net.minecraft.world.level.storage.loot.entries.LootItem.lootTableItem;
//import static net.minecraft.world.level.storage.loot.providers.number.ConstantValue.exactly;
//
//public class BYGEntityLootProvider extends EntityLoot {
//
//    @Override
//    public void accept(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> cons) {
//        super.accept(cons);
//    }
//
//    @Override
//    protected void addTables() {
//        for (final BYGWoodTypes type : BYGWoodTypes.values()) {
//            if (type.boatType() == null)
//                continue;
//            for (boolean isChest : new Boolean[]{true, false}) {
//                add(BYGBoat.getLootLocation(type.boatType(), isChest,false), LootTable.lootTable()
//                        .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1))
//                                .add(LootItem.lootTableItem(isChest ? type.chestBoat().get() : type.boat().get()))));
//                var loot = LootTable.lootTable()
//                        .withPool(LootPool.lootPool().setRolls(exactly(2))
//                                .add(lootTableItem(Items.STICK)))
//                        .withPool(LootPool.lootPool().setRolls(exactly(3))
//                                .add(lootTableItem(type.planks().get())));
//                if (isChest) {
//                    loot.withPool(LootPool.lootPool().setRolls(exactly(1))
//                            .add(lootTableItem(Items.CHEST)));
//                }
//                add(BYGBoat.getLootLocation(type.boatType(), isChest, true), loot);
//            }
//        }
//    }
//
//    @Override
//    protected @NotNull Iterable<EntityType<?>> getKnownEntities() {
//        return List.of();
//    }
//}
