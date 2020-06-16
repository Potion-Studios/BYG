package voronoiaoc.byg.server.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import voronoiaoc.byg.BYG;

public class BYGCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        BYG.LOGGER.debug("Registering BYG commands...");
        LiteralCommandNode<CommandSource> source = dispatcher.register(
                Commands.literal(BYG.MOD_ID)
                .then(LocateBiome.register(dispatcher))

        );
        dispatcher.register(Commands.literal("byg").redirect(source));
        BYG.LOGGER.debug("Registered BYG Commands!");
    }
}