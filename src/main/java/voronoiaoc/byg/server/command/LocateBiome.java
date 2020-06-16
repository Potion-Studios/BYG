package voronoiaoc.byg.server.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.ResourceLocationArgument;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistry;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class LocateBiome {
    public static ForgeRegistry<Biome> biomeRegistry = ((ForgeRegistry<Biome>) ForgeRegistries.BIOMES);
    public static ArgumentBuilder<CommandSource, ?> register(CommandDispatcher<CommandSource> dispatcher) {
        return Commands.literal("locatebiome")
                .then(Commands.argument("biome", ResourceLocationArgument.resourceLocation()).suggests((ctx, sb) -> ISuggestionProvider.suggest(biomeRegistry.getKeys().stream().map(ResourceLocation::toString), sb))
                .then(Commands.argument("radius", IntegerArgumentType.integer(1000, 25000))
                .executes((cs) -> getBiomePos(cs.getSource().getWorld(), cs.getSource(), cs.getArgument("radius", Integer.class), cs.getArgument("biome", ResourceLocation.class).toString()))));
    }

    public static BlockPos biomePos(World world, CommandSource src, int radius, String biomeName) {
        Biome biome;
        int checkPos = 0;
        BlockPos playerPos = new BlockPos(src.getPos());
        BlockPos.Mutable biomePos = new BlockPos.Mutable(playerPos);
        final int x = biomePos.getX() & 15;
        final int z = biomePos.getZ() & 15;
        int step = 50;

        while(checkPos <= radius){
            for(int curX = -checkPos; curX <= checkPos; curX += step){
                for(int curZ = -checkPos; curZ <= checkPos; curZ += step){
                    if(Math.abs(curX) == checkPos || Math.abs(curZ) == checkPos){
                        biomePos.setX(x+curX);
                        biomePos.setZ(z+curZ);
                        biome = world.getBiome(biomePos);
                        if (Objects.requireNonNull(biome.getRegistryName()).toString().equals(biomeName)) return biomePos;
                    }
                    else{
                        curZ = checkPos - step;
                    }
                }
            }
            checkPos += step;
        }
        return new BlockPos(src.getPos());
    }

    public static int getBiomePos(World world, CommandSource source, int radius, String biomeName) {
        Random rand = new Random();
        BlockPos blockPos = new BlockPos(source.getPos());
        BlockPos biomePos = new BlockPos(biomePos(world, source, radius,  biomeName));
        Biome biome = biomeRegistry.getRaw(new ResourceLocation(biomeName));

        int distance = MathHelper.floor(getBiomeDistanceFromPlayer(blockPos.getX(), blockPos.getZ(), biomePos.getX(), biomePos.getZ()));
        ITextComponent itextcomponent = TextComponentUtils.wrapInSquareBrackets(new TranslationTextComponent("chat.coordinates", biomePos.getX(), "~", biomePos.getZ())).applyTextStyle((text) -> {
            text.setColor(textFormattingArray[rand.nextInt(textFormattingArray.length)]).setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tp @s " + biomePos.getX() + " ~ " + biomePos.getZ())).setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("chat.coordinates.tooltip")));
        });
        BlockPos blockPos2 = new BlockPos(source.getPos());
        if (!blockPos2.equals(biomePos))
            source.sendFeedback(new TranslationTextComponent("commands.locate.success", biome.getRegistryName(), itextcomponent, distance), false);
        else
            source.sendFeedback(new TranslationTextComponent("commands.byg.locatebiome.failed", biome.getRegistryName()).applyTextStyle(text -> text.setColor(TextFormatting.RED)), false);

        return distance;
    }

    private static float getBiomeDistanceFromPlayer(int x1, int z1, int x2, int z2) {
        int i = x2 - x1;
        int j = z2 - z1;
        return MathHelper.sqrt((float)(i * i + j * j));
    }

   static TextFormatting[] textFormattingArray = {
            TextFormatting.LIGHT_PURPLE,
            TextFormatting.YELLOW,
            TextFormatting.GOLD,
            TextFormatting.AQUA,
            TextFormatting.GREEN
    };

    static CompletableFuture<Suggestions> suggest(Stream<Integer> intStream, SuggestionsBuilder builder) {
        intStream.forEach(builder::suggest);
        return builder.buildFuture();
    }
}