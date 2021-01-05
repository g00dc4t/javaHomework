import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Main {

    private final static String IMAGE_DOWNLOAD_FOLDER = "G:/Java/javaHW/9.12_parsingHTML/data/imgFromLentaRu";

    public static void main(String[] args) {
        try {
            Document docHtml = Jsoup.connect("https://lenta.ru").get();
            Elements imgElements = docHtml.select("img");
            for (Element imgElement : imgElements) {
                String strImgUrl = imgElement.attr("abs:src");
                downloadImg(strImgUrl);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void downloadImg(String strImgUrl) throws IOException {
        //get file name from image path
        String strImgName = strImgUrl.substring(strImgUrl.lastIndexOf("/") + 1);
        System.out.println("Saving: " + strImgName + ", from: " + strImgUrl);

        //open the stream from URL
        URL urlImg = new URL(strImgUrl);
        InputStream in = urlImg.openStream();

        byte[] buffer = new byte[4096];
        int n = -1;

        OutputStream os = new FileOutputStream(IMAGE_DOWNLOAD_FOLDER + "/" + strImgName);

        //write bytes to the output stream
        while ((n = in.read(buffer)) != -1) {
            os.write(buffer, 0, n);
        }

        //close the stream
        os.close();

        System.out.println("Image saved");

    }

}
