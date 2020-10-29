package corgiaoc.byg.config.autoconfig;

import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

public class EndDimensionConfig {

    @Comment(value = "\nDoes BYG Control The End Dimension?")
    public boolean ControlEnd = true;

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public Void Void = new Void();

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public Islands Islands = new Islands();

    public static class Void {

        @Comment(value = "\nVoid Biome(where small end islands generate in vanilla) size.\nDefault: 3")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 25)
        public int VoidBiomeSize = 3;

        @ConfigEntry.Gui.PrefixText
        @Comment(value = "\nAdd biomes by their registry String ID's in a commented list.\nAdding a biome several times gives it more weight in generation.\nNO SPACES AFTER COMMAS!\nDOES NOT ACCEPT DATAPACK VALUES!\nDefault: \"byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands\"")
        public String VoidBiomes = "byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands";

    }


    public static class Islands {
        @Comment(value = "\nEnd Island Biome Size\nDefault: 3")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 25)
        public int IslandBiomeSize = 3;

        @ConfigEntry.Gui.PrefixText
        @Comment(value = "\nIs the list of biomes a blacklist or whitelist?\nWhen this list is a blacklist, the values in the list will not be in world generation.\nWhen this list is a whitelist, Adding a biome several times gives it more weight in generation and it must contain at least 1 value.\nWhen set to true, datapack biomes will work automatically!\nDefault: true")
        public boolean IsBlackListEnd = true;


        @ConfigEntry.Gui.PrefixText
        @Comment(value = "\nThis works as a whitelist or blacklist depending on the \"isBlacklistEnd\" value.\nNO SPACES AFTER COMMAS!\nDOES NOT ACCEPT DATAPACK VALUES!\nDefault: \"byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands,minecraft:the_end,minecraft:end_barrens\"")
        public String BlackListEnd = "byg:viscal_isles,byg:shattered_viscal_isles,minecraft:small_end_islands,minecraft:the_end,minecraft:end_barrens";
    }
}
