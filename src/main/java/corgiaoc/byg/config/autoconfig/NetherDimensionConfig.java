package corgiaoc.byg.config.autoconfig;

import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

public class NetherDimensionConfig {

    @Comment(value = "\nDoes Control The Nether Dimension?")
    public boolean ControlNether = true;

    @Comment(value = "\nEnd Island Biome Size\nDefault: 3")
    @ConfigEntry.BoundedDiscrete(min = 1, max = 25)
    public int BiomeSize = 3;

    @ConfigEntry.Gui.PrefixText
    @Comment(value = "\nIs the list of biomes a blacklist or whitelist?\nWhen this list is a blacklist, the values in the list will not be in world generation.\nWhen this list is a whitelist, Adding a biome several times gives it more weight in generation and it must contain at least 1 value.\nWhen set to true, datapack biomes will work automatically!\nDefault: true")
    public boolean IsBlackListNether = true;


    @ConfigEntry.Gui.PrefixText
    @Comment(value = "\nThis works as a whitelist or blacklist depending on the \"isBlacklistNether\" value.\nNO SPACES AFTER COMMAS!\nDOES NOT ACCEPT DATAPACK VALUES!\nDefault: \"\"")
    public String BlackListNether = "";
}
