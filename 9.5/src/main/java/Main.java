import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final Marker ALL = MarkerManager.getMarker("All");

    public static void main(String[] args) {

        for (;;) {
            try {
                Scanner in = new Scanner(System.in);
                String examplePath = "E:/example/example";
                System.out.println("Path example: " + examplePath);
                System.out.print("Enter path to folder: ");
                String path = in.nextLine();

                File folder = new File(path);
                Path pathFolder = Paths.get(path);

                if (folder.exists()) {
                    System.out.println(getReadableLength(getFolderSizeRecursive(folder)));
                    System.out.println(getReadableLength(FileUtils.sizeOfDirectory(folder))); //Apache Commons IO
                    System.out.println(getReadableLength(getFolderSizeJava8(pathFolder)));
                    LOGGER.info(ALL, folder);
                }
                else {
                    LOGGER.info(ALL, folder);
                    throw new FileNotFoundException("Wrong path or file not found");
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
                LOGGER.error(ex);
            }
        }
    }
    public static long getFolderSizeRecursive(File folder) { //getting catalog size with recursive method
        long length = 0;
        File[] files = folder.listFiles();

        for (File file : files) {
            if (file.isFile()) {
                length += file.length();
            } else {
                length += getFolderSizeRecursive(file);
            }
        }
        return length;
    }

    public static long getFolderSizeJava8(Path folder) throws IOException { //getting catalog size with Java 8
        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .mapToLong(p -> p.toFile().length())
                .sum();
        return size;
    }

    private static String getReadableLength(long length) { //reverse in readable format
        String[]units = new String[]{ "B", "KB", "MB", "GB", "TB" };
        int unitIndex = (int) (Math.log10(length)/3);
        double unitValue = 1 << (unitIndex * 10);

        String readableLength = new DecimalFormat("#,##0.#")
                .format(length/unitValue) + " "
                + units[unitIndex];
        return readableLength;
    }
}
