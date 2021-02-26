import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    private static final String FILE_NAME = "data/urlsFromSite.txt";
    private static String siteUrl = "https://lenta.ru/";
    private static List<String> siteMap;

    public static void main(String[] args) {
        try {
//            createFile(FILE_NAME);
//            ForkJoinPool forkJoinPool = new ForkJoinPool();
//            GetSiteMap getSiteMap = new GetSiteMap(siteUrl);
//            forkJoinPool.execute(getSiteMap);
            siteMap = new ForkJoinPool().invoke(new GetSiteMap(siteUrl));


//            do {
//                TimeUnit.MILLISECONDS.sleep(100);
//            } while (!getSiteMap.isDone());
//            forkJoinPool.shutdown();
//
//            siteMap = getSiteMap.join();

            for (String s : siteMap) {
                System.out.println(s);
            }

//            Comparator<String> comparator = Comparator.comparing(s -> s.split("/").length);
//            comparator = comparator.thenComparing(Comparator.comparing(s -> s));
//            getSiteMap.invoke().stream().sorted(comparator).forEach(System.out::println);
//            siteMap = getSiteMap.invoke().stream().sorted(comparator).collect(Collectors.toList());

//            for (String str : siteMap) {
//                writeUrlInFile(str, FILE_NAME);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void createFile(String fileName) throws IOException {
        Path filePath = Paths.get(fileName);
        Files.createFile(filePath);
    }

    public static void writeUrlInFile(String url, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append("\n" + "\t".repeat(url.split("/").length - 3) + url);
        writer.close();
    }
}
