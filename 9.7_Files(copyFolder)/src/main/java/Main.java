import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final Logger LOGGER = LogManager.getRootLogger();
    private static final Marker ALL = MarkerManager.getMarker("All");

    public static void main(String[] args) throws IOException {

        for (;;) {
            try {
                Scanner in1 = new Scanner(System.in);
                String example = "E:/example/example.file";
                System.out.println("Path example: " + example);
                System.out.print("Enter path to srcFolder: ");
                String path1 = in1.nextLine();

                File srcFolder = new File(path1); //Papka, kotoruyu nado skopirovat

                if (srcFolder.exists()) {
                    LOGGER.info(ALL, "source folder: {}", srcFolder);
                    Scanner in2 = new Scanner(System.in);
                    System.out.println("Path example: " + example);
                    System.out.print("Enter path to targetFolder: ");
                    String path2 = in2.nextLine();

                    File targetFolder = new File(path2); //Papka, V kotoruyu nado skopirovat

                    if (targetFolder.exists()) {
                        LOGGER.info(ALL, "target folder: {}", targetFolder);
                        FileUtils.copyDirectory(srcFolder, targetFolder);
                    } else {
                        LOGGER.info(ALL, "target folder create: {}", targetFolder);
                        targetFolder.mkdir();
                        FileUtils.copyDirectory(srcFolder, targetFolder);
                    }
                } else {
                    LOGGER.info(ALL, path1);
                    throw new FileNotFoundException("Wrong path to source folder or folder does not exists");
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
                LOGGER.error(ex);
            }
        }
    }
}
