import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    final static String movementList = "data/movementList.csv";

    private static double incomeSum;
    private static double consumptionSum;
    private static double valueIncome;
    private static double valueConsumption;
    private static String nameConsumption;
    private static String nameIncome;
    private static Map<String, Double> namesValuesConsumption = new HashMap<>();

    public static void main(String[] args) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(movementList));
            System.out.println("----------------------");
            System.out.println("Сумма доходов: " + getSumIncome(lines));
            System.out.println("Сумма расходов: " + getSumConsumption(lines));
            System.out.println("----------------------");
            infillMap(lines);
            System.out.println("Суммы расходов по организациям:");
            for (Map.Entry<String, Double> entry : namesValuesConsumption.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Double getSumIncome(List<String> lines) {

        for (String line : lines) {
            if (line.contains("/")) {
                String[] fragments = line.split("\\s+");
                for (String s : fragments) {
                    if (s.matches("\\d+\\.\\d{2}")) {
                        incomeSum += Double.parseDouble(s);
                    }
                }
            }
        }
        return incomeSum;
    }

    public static Double getSumConsumption(List<String> lines) {

        for (String line : lines) {
            if (line.contains("\\")) {
                String[] fragments = line.split("\\s+");
                for (String s : fragments) {
                    if (s.matches("\\d+\\.\\d{2}")) {
                        consumptionSum += Double.parseDouble(s);
                    }
                }
            }
        }
        return consumptionSum;
    }

    public static Double getValueConsumption(String line) {

        if (!line.contains("\\")) {
            return valueIncome;
        } else if (line.contains("\\")) {
            String[] fragments = line.split("\\s+");
            for (String s : fragments) {
                if (s.matches("\\d+\\.\\d{2}")) {
                    valueConsumption = Double.parseDouble(s);
                }
            }
        }
        return valueConsumption;
    }

    public static String getNameOperationConsumption(String line) {
        if (!line.contains("\\")) {
            return nameIncome;
        } else if (line.contains("\\")) {
            String[] fragments = line.split(" {3,}");
            for (String f : fragments) {
                if (f.contains("\\")) {
                    nameConsumption = f.replaceAll("[^a-zA-Z]", "");
                }
            }
        }
        return nameConsumption;
    }

    public static void infillMap(List<String> lines) {
        for (String line : lines) {
            if (getNameOperationConsumption(line) == nameIncome) {
                continue;
            } else {
                nameConsumption = getNameOperationConsumption(line);
            }
            if (getValueConsumption(line) == valueIncome) {
                continue;
            } else {
                valueConsumption = getValueConsumption(line);
            }
            putInMap(nameConsumption, valueConsumption);
        }
    }

    public static void putInMap(String nameConsumption, double valueConsumption) {
        if (!namesValuesConsumption.containsKey(nameConsumption)) {
            namesValuesConsumption.put(nameConsumption, valueConsumption);
        } else {
            double d = namesValuesConsumption.get(nameConsumption) + valueConsumption;
            namesValuesConsumption.put(nameConsumption, d);
        }
    }
}
