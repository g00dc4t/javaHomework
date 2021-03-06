import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static final String FILE_NAME = "data/urlsFromSite.txt";
    private static String siteUrl = "https://lenta.ru/";
    private static List<String> siteMap;

    public static void main(String[] args) {
        try {
            createFile(FILE_NAME);
            siteMap = new ForkJoinPool().invoke(new GetSiteMap(siteUrl));
            for (String s : siteMap) {
                writeInFile(s, FILE_NAME);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void createFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.createFile(filePath);
    }

    public static void writeInFile(String url, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(url);
        writer.close();
    }
}
