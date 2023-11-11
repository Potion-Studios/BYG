package potionstudios.byg.common.item;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.client.gui.biomepedia.screen.BiomepediaHomeScreen;

public class BiomepediaItem extends Item {
    public BiomepediaItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level level, @NotNull Player player, @NotNull InteractionHand interactionHand) {
        if (level.isClientSide) {
            Client.openScreen();

        }
        return super.use(level, player, interactionHand);
    }

    private static class Client {
        public static void openScreen() {
            Minecraft.getInstance().setScreen(new BiomepediaHomeScreen(Component.literal("")));
        }
    }
}
