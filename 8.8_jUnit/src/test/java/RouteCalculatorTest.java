import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.*;

public class RouteCalculatorTest extends TestCase {

    List<Station> route;
    StationIndex stationIndex;
    RouteCalculator routeCalculator;
    Line line1, line2, line3;

    @Override
    protected void setUp() throws Exception {

        route = new ArrayList<>();
        stationIndex = new StationIndex();

        line1 = new Line(1, "A");
        line2 = new Line(2, "B");
        line3 = new Line(3, "C");

        route.add(new Station("1.1", line1)); //0
        route.add(new Station("1.2", line1)); //1
        route.add(new Station("2.1", line2)); //2
        route.add(new Station("2.2", line2)); //3
        route.add(new Station("2.3", line2)); //4
        route.add(new Station("3.1", line3)); //5
        route.add(new Station("3.2", line3)); //6

        line1.addStation(route.get(0));
        line1.addStation(route.get(1));
        line2.addStation(route.get(2));
        line2.addStation(route.get(3));
        line2.addStation(route.get(4));
        line3.addStation(route.get(5));
        line3.addStation(route.get(6));

        List<Station> connectedStations1 = new ArrayList<>();
        connectedStations1.add(route.get(1));
        connectedStations1.add(route.get(2));

        List<Station> connectedStations2 = new ArrayList<>();
        connectedStations1.add(route.get(4));
        connectedStations1.add(route.get(5));

        stationIndex.addConnection(connectedStations1);
        stationIndex.addConnection(connectedStations2);

        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void testGetShortestRoute() {

        List<Station> actual = routeCalculator.getShortestRoute(route.get(0), route.get(1));
        List<Station> expected = new ArrayList<>(line1.getStations());
        assertEquals(expected, actual);

        actual = routeCalculator.getShortestRoute(route.get(0), route.get(4));
        expected.addAll(line2.getStations());
        assertEquals(expected, actual);

        actual = routeCalculator.getShortestRoute(route.get(0), route.get(6));
        assertEquals(route, actual);
    }

    public void testCalculateDuration() {

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 17;
        assertEquals(expected,actual);
    }

    @Override
    protected void tearDown() throws Exception {
    }
}
