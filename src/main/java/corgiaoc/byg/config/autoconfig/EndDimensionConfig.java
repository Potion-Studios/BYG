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
    }


    public static class Islands {
        @Comment(value = "\nEnd Island Biome Size\nDefault: 3")
        @ConfigEntry.BoundedDiscrete(min = 1, max = 25)
        public int IslandBiomeSize = 3;
    }
}
