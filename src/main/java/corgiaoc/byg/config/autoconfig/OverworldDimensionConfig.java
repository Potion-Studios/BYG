package corgiaoc.byg.config.autoconfig;

import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

public class OverworldDimensionConfig {

    @ConfigEntry.Gui.CollapsibleObject
    @ConfigEntry.Gui.Tooltip
    public Ores Ores = new Ores();

    public static class Ores {

        @ConfigEntry.Gui.CollapsibleObject
        @ConfigEntry.Gui.Tooltip
        public Ore RockyStone = new Ore();

        @ConfigEntry.Gui.CollapsibleObject
        @ConfigEntry.Gui.Tooltip
        public Ore ScoriaStone = new Ore();

        @ConfigEntry.Gui.CollapsibleObject
        @ConfigEntry.Gui.Tooltip
        public Ore SoapStone = new Ore();

        public static class Ore {

            @Comment(value = "\nGenerate ore?")
            public boolean Generate = true;

            @Comment(value = "\nY level to start generating at.\nDefault: 63")
            @ConfigEntry.BoundedDiscrete(min = 1, max = 256)
            public int YLevel = 63;

            @Comment(value = "\nSize of the clusters.\nDefault: 20")
            @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
            public int Size = 20;

            @Comment(value = "\nNumber of times to spawn per chunk.\nDefault: 10")
            @ConfigEntry.BoundedDiscrete(min = 1, max = 100)
            public int PerChunk = 10;

        }

    }
    
}
