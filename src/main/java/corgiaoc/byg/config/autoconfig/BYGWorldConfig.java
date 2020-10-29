package corgiaoc.byg.config.autoconfig;

import corgiaoc.byg.BYG;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;

@Config(name = BYG.MOD_ID + "\\" + BYG.MOD_ID + "-world")
public class BYGWorldConfig implements ConfigData {

    @ConfigEntry.Category("End_Dimension")
    @ConfigEntry.Gui.CollapsibleObject
    public EndDimensionConfig EndDimension = new EndDimensionConfig();

    @ConfigEntry.Category("Nether_Dimension")
    @ConfigEntry.Gui.CollapsibleObject
    public NetherDimensionConfig NetherDimension = new NetherDimensionConfig();
}