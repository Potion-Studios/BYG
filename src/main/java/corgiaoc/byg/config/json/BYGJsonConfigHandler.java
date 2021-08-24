package corgiaoc.byg.config.json;

import corgiaoc.byg.BYG;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BYGJsonConfigHandler {

    public static void createReadMe(Path path) {
        final File README_FILE = new File(String.valueOf(path));
        String text = "If you need help understanding what the byg-biomes or byg-sub-biomes configs allow you to do, please watch this video: https://youtu.be/iq0q09O7ZYo\n\nIf you need help with datapacking, please watch this: https://youtu.be/TF_p8OeB-hc";
        if (!README_FILE.exists()) {
            try {
                Files.write(path, text.getBytes());
            } catch (IOException e) {
                BYG.LOGGER.error(BYG.MOD_ID + "'s README.txt could not be created");
            }
        }
    }
}