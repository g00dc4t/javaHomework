import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Metro {

    private LinkedHashMap<String, ArrayList<String>> stations;
    private ArrayList<Line> lines;
    @JsonIgnore
    private ArrayList<Station> listStations;

    public Metro() {
        stations = new LinkedHashMap<>();
        lines = new ArrayList<>();
    }

    public LinkedHashMap<String, ArrayList<String>> getStations() {
        return stations;
    }

    public void setStations(LinkedHashMap<String, ArrayList<String>> stations) {
        this.stations = stations;
    }

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public ArrayList<Station> getListStations() {
        return listStations;
    }

    public void setListStations(Station station) {
        listStations.add(station);
    }
}
