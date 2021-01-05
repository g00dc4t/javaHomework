import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Line {

    private String lineNumber;
    private String lineName;
    @JsonIgnore
    private ArrayList<Station> listStations;

    public Line() {
        listStations = new ArrayList<>();
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    public ArrayList<Station> getListStations() {
        return listStations;
    }

    public void setListStations(Station station) {
        listStations.add(station);
    }

    public ArrayList<String> getListStationName (ArrayList<Station> stations) {
        ArrayList<String> listStationName = new ArrayList<>();
        for (Station station : stations) {
            listStationName.add(station.getName());
        }
        return listStationName;
    }
}
