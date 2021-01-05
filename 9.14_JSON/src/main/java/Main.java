import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Main {

    public static void main(String[] args) {
        try {
//            Document docHtml = Jsoup.connect("https://www.moscowmap.ru/metro.html#lines").maxBodySize(0).get();   //html from internet
            Document docHtml = Jsoup.parse(new File("data/metro.html"), "UTF-8");   //html from file

            createJsonFile(docHtml);

            ObjectMapper mapper = new ObjectMapper();
            Metro metro = mapper.readValue(new File("data/metro.json"), Metro.class);

            System.out.println();

            for (Line l : metro.getLines()) {
                System.out.print(l.getLineName() + ": ");
                System.out.println("amount of stations = " + metro.getStations().get(l.getLineNumber()).size());
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void createJsonFile(Document document) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Metro metro = new Metro();
        ArrayList<Line> listLines = createLines(document);
        LinkedHashMap<String, ArrayList<String>> mapStations = createStations(listLines);
        metro.setLines(listLines);
        metro.setStations(mapStations);
        mapper.writeValue(Paths.get("data/metro.json").toFile(), metro);
    }

    public static ArrayList<Line> createLines(Document document) {
        ArrayList<Line> lines = new ArrayList<>();
        Elements lineElementsNumber = document.select("span[data-line]");
        for (int i = 0; i < lineElementsNumber.size(); i++) {
            String strLineElementNumber = lineElementsNumber.get(i).attr("data-line");  //line number;

            Elements lineElementsName = document.select("span[data-line]");
            for ( ; i < lineElementsName.size(); ) {
                String strLineElementName = lineElementsName.get(i).text();    //line name;
                Line line = new Line();
                line.setLineNumber(strLineElementNumber);
                line.setLineName(strLineElementName);
                getListStations(document, strLineElementNumber, line);
                lines.add(line);
                break;
            }
        }
        return lines;
    }

    public static LinkedHashMap<String, ArrayList<String>> createStations(ArrayList<Line> lines) {
        LinkedHashMap<String, ArrayList<String>> stations = new LinkedHashMap<>();
        for (Line l : lines) {
            stations.put(l.getLineNumber(), l.getListStationName(l.getListStations()));
        }
        return stations;
    }

    public static void getListStations(Document document, String lineNumber, Line line) {
        String leftNumber = "div[data-line='";
        String rightNumber = "'] > p > a > span.name";
        String cssQueryNumber = leftNumber + lineNumber + rightNumber;
        Elements stationElementsName = document.select(cssQueryNumber);
        for (int i = 0;  i < stationElementsName.size(); i++) {
            String strStationElementNumber = stationElementsName.get(i).text();
            Station station = new Station();
            station.setLine(line);
            station.setName(strStationElementNumber);
            line.setListStations(station);
        }
    }
}
