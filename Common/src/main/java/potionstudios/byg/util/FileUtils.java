package potionstudios.byg.util;

import potionstudios.byg.BYG;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtils {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");

    public static Path backUpDirectory(Path path) {
        String date = DATE_FORMAT.format(new Date());

        return backUpDirectory(path, "backup_" + date);
    }

    public static Path backUpDirectory(Path pathToBackUp, String name) {
        Path backupPath = pathToBackUp.resolve("backups").resolve(String.format("%s.zip", name));
        ZipOutputStream zipOutputStream = makeZipOutputStream(pathToBackUp, backupPath, path -> !path.equals(backupPath) && !path.toFile().isDirectory());
        try {
            zipOutputStream.close();
            BYG.LOGGER.info(String.format("Created compressed zip back up for \"%s\" in \"%s\"", pathToBackUp, backupPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return backupPath;
    }

    public static ZipOutputStream makeZipOutputStream(Path directoryToZip, Path zipPath, Predicate<Path> filter) {
        try {
            Files.createDirectories(zipPath.getParent());
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));

            Files.walk(directoryToZip).sorted(Comparator.reverseOrder()).forEach(path -> {
                Path relativized = directoryToZip.relativize(path);
                if (filter.test(path) && !path.toFile().isDirectory()) {

                    ZipEntry entry = new ZipEntry(relativized.toString().replace('\\', '/'));
                    try {
                        zipOutputStream.putNextEntry(entry);
                        byte[] bytes = Files.readAllBytes(path);
                        zipOutputStream.write(bytes);
                        zipOutputStream.closeEntry();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            return zipOutputStream;
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }
    }

    public static void deleteDirectory(Path directory, Predicate<Path> filter) {
        if (!directory.toFile().isDirectory()) {
            throw new IllegalArgumentException("Not a directory! \"" + directory.toAbsolutePath() + "\"");
        }
        try {
            Files.walk(directory).sorted(Comparator.reverseOrder()).forEach(path -> {
                if (filter.test(path)) {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
