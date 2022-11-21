package potionstudios.byg.common.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class StackableBowlFoodItem extends Item {
    public StackableBowlFoodItem(Item.Properties properties) {
        super(properties);
    }
    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity playerEntity){
        super.finishUsingItem(itemStack, level, playerEntity);
        if (playerEntity instanceof ServerPlayer $$3) {
            CriteriaTriggers.CONSUME_ITEM.trigger($$3, itemStack);
            $$3.awardStat(Stats.ITEM_USED.get(this));
        }
        if (itemStack.isEmpty()) {
            return new ItemStack(Items.BOWL);
        } else {
            if (playerEntity instanceof Player && !((Player)playerEntity).getAbilities().instabuild){
                ItemStack bowlStack = new ItemStack(Items.BOWL);
                Player player = (Player) playerEntity;
                if (!player.getInventory().add(bowlStack)){
                    player.drop(bowlStack,false);
                }
            }
        }
        return itemStack;
    }
}
