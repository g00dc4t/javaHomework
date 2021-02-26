import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.concurrent.RecursiveTask;

public class GetSiteMap extends RecursiveTask<List<String>> {

    private String siteUrl;


    public GetSiteMap(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Override
    protected List<String> compute() {
        List<String> pathsList = new LinkedList<>();
        List<GetSiteMap> tasks = new LinkedList<>();
        try {
//            Elements urlsElements = Jsoup.connect(siteUrl).get().select("a");
//            for (Element e : urlsElements) {
//                String path = e.absUrl("href");
//                if (path.contains(siteUrl) && !pathsList.contains(path)) {
//                    pathsList.add(path);
//                    GetSiteMap task = new GetSiteMap(path);
//                    task.fork();
//                    tasks.add(task);
//                }
//            }

            Jsoup.connect(siteUrl).get()
                    .select("a")
                    .forEach(element -> {
                        String path = element.absUrl("href");
                        if (path.contains(siteUrl) && !pathsList.contains(path)) {
                            pathsList.add(path);
                            GetSiteMap task = new GetSiteMap(path);
                            task.fork();
                            tasks.add(task);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
//        addResultFromTasks(pathsList, tasks);
        return pathsList;
    }

    public void addResultFromTasks(List<String> pathsList, List<GetSiteMap> tasks) {
        for (GetSiteMap task : tasks) {
                pathsList.addAll(task.join());
        }
    }

    public void getRightFormat() {

    }
}
