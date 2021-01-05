import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;

public class Main
{
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";

    public static void main(String[] args)
    {
        ArrayList<Employee> staff = loadStaffFromFile();

        //#1
//        Collections.sort(staff, (o1, o2) -> {
//        int salaryResult = o1.getSalary().compareTo(o2.getSalary());
//        if (salaryResult != 0) {
//            return salaryResult;
//        }
//        return o1.getName().compareTo(o2.getName());
//        });
//
//        staff.forEach(System.out::println);

        //#2.1
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy");

    Stream<Employee> stream = staff.stream();
        staff.stream()
                .filter(e1 -> newFormat.format(e1.getWorkStart()).equals("2017"))
        .max(Comparator.comparing(Employee::getSalary))
        .ifPresent(System.out::println);
}

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                    fragments[0],
                    Integer.parseInt(fragments[1]),
                    (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }
}