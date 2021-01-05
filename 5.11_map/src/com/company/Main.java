package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        TreeMap<String, String> numberName = new TreeMap<>();
        TreeSet<String> nameAlph = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("LIST - показать всю мапу;");

        while (true) {
            System.out.println("Введите номер или имя:");
            String numberOrName = scanner.nextLine();

            if (numberOrName.equals("LIST")) {
                for (String key : numberName.keySet()) {
                    nameAlph.add(numberName.get(key) + " - " + key);
                }
                for (String num : nameAlph) {
                    System.out.println(num);
                    continue;
                }
            }

            if (numberOrName.matches("\\d+") && numberName.containsKey(numberOrName)) {
                System.out.println(numberOrName + " - " + numberName.get(numberOrName));
                continue;
            }   else if (numberOrName.matches("\\d+")) {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Новый номер, введите имя:");
                    String nameValue = scanner1.nextLine();

                    numberName.put(numberOrName, nameValue);
            }

            if (numberOrName.matches("[a-zA-Z]+")) {
                for (String number : numberName.keySet()) {
                    if (numberName.get(number).equals(numberOrName)) {
                        System.out.println(number + " - " + numberOrName);
                        continue;
                    }
                }

            if (numberOrName.matches("[a-zA-Z]+") && !(numberName.containsValue(numberOrName))) {
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("Новое имя, введите номер:");
                String numberValue = scanner2.nextLine();

                numberName.put(numberValue, numberOrName);
                }
            }
        }
    }
}
