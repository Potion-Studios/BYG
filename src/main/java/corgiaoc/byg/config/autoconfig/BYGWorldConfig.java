package corgiaoc.byg.config.autoconfig;

import corgiaoc.byg.BYG;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = BYG.MOD_ID + "/" + BYG.MOD_ID + "-world")
public class BYGWorldConfig implements ConfigData {

    @ConfigEntry.Category("Overworld_Dimension")
    @ConfigEntry.Gui.CollapsibleObject
    public OverworldDimensionConfig OverworldDimension = new OverworldDimensionConfig();

    @ConfigEntry.Category("End_Dimension")
    @ConfigEntry.Gui.CollapsibleObject
    public EndDimensionConfig EndDimension = new EndDimensionConfig();

    @ConfigEntry.Category("Nether_Dimension")
    @ConfigEntry.Gui.CollapsibleObject
    public NetherDimensionConfig NetherDimension = new NetherDimensionConfig();
}