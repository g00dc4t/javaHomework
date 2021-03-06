import org.jsoup.Jsoup;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class GetSiteMap extends RecursiveTask<List<String>> {

    private String siteUrl;
    private List<String> pathsList = new LinkedList<>();

    public GetSiteMap(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    @Override
    protected List<String> compute() {
        List<GetSiteMap> tasks = new LinkedList<>();
        try {
            Jsoup.connect(siteUrl).get()
                    .select("a")
                    .forEach(element -> {
                        String path = element.absUrl("href");
                        if (path.contains(siteUrl) && !pathsList.contains(path)) {
                            addInRightFormat(path);
                            GetSiteMap task = new GetSiteMap(path);
                            task.fork();
                            tasks.add(task);
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pathsList;
    }

    public void addInRightFormat(String path) {
        String rightString = ("\n" + "\t".repeat(path.split("/").length - 3) + path);
        pathsList.add(rightString);
    }
}
