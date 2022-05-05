package potionstudios.byg;

public class BYGConstants {
    public static final boolean BIOMES = true;
    public static final boolean WARN_EXPERIMENTAL = false;
    public static final int EXPERIMENTAL_WARNING_VERSION = 5;
    public static final boolean BIOMEPEDIA = false;
    public static final boolean SIGNS = false;
    public static final boolean DEV_ENVIRONMENT = Boolean.parseBoolean(System.getProperty("bygDev", "false"));
    public static final boolean GENERATE_DATA = Boolean.parseBoolean(System.getProperty("bygGenerateData", "false"));
    public static boolean ENABLE_OVERWORLD_TREES = true;
    public static boolean ENABLE_CACTI = true;
}
