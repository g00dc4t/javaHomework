import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Airport belarus = Airport.getInstance();

        Date currentDate = new Date();
        System.out.println("current date: \n" + currentDate + "\n");

        //Вывод всех рейсов
        belarus.getTerminals().forEach(terminal -> System.out.println(terminal.getFlights()));

        System.out.println("");

        //Вывод рейсов отправляющихся в течении 2х часов
        belarus.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream()
                        .filter(flight -> (flight.getDate().getTime() - currentDate.getTime()) <= 7200000 &&
                                (flight.getDate().getTime() - currentDate.getTime()) > 0 &&
                                flight.getType().equals(Flight.Type.DEPARTURE)))
                        .forEach(System.out::println);

    }
}
