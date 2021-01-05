package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.print("Список команд:\nLIST - показать список дел; \nADD - добавить дело в конец списка;" +
                "\nADD * - добавить дело в список под номером *; \nEDIT * - заменить дело под номером *;" +
                "\nDELETE * - удалить дело под номером *.\n");

        ArrayList<String> todolist = new ArrayList<>() {{
            add("Напомнить Владу, что он пидр");
            add("Ёбнуть кофейку");
            add("Подъебать Ваню");
        }};

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введи команду: ");
            String command = in.nextLine();

            //Проверка на правильность ввода команд
            if (command.equals("LIST") || command.equals("ADD") || command.matches("ADD\\s+\\d+") ||
                    command.matches("EDIT\\s+\\d+") || command.matches("DELETE\\s+\\d+"))  {
            } else System.out.println("Нет такой команды, используй сиписок команд");

            //LIST
            if (command.equals("LIST"))
                for (int i = 0; i < todolist.size(); i++) {
                    System.out.println(i + 1 + " - " + todolist.get(i));
                }

            //ADD
            if (command.equals("ADD")) {
                Scanner in1 = new Scanner(System.in);
                System.out.print("Введи новую команду: ");
                String command1 = in1.nextLine();
                todolist.add(command1);
            }

            //ADD *
            if (command.matches("ADD\\s+\\d+")) {
                //отделяем цифру в команде и приводим к int
                String[] digit = command.split("\\s+");
                int digitInt = Integer.parseInt(digit[1]);

                if (digitInt > todolist.size()) {
                    digitInt = todolist.size();

                    Scanner in1 = new Scanner(System.in);
                    System.out.print("Введи новое дело: ");
                    String command1 = in1.nextLine();
                    todolist.add(digitInt, command1);
                } else {
                    Scanner in1 = new Scanner(System.in);
                    System.out.print("Введи новое дело: ");
                    String command1 = in1.nextLine();
                    todolist.add(digitInt - 1, command1);
                }
            }

            //EDIT *
            if (command.matches("EDIT\\s+\\d+")) {
                //отделяем цифру в команде и приводим к int
                String[] digit = command.split("\\s+");
                int digitInt = Integer.parseInt(digit[1]);

                Scanner in1 = new Scanner(System.in);
                System.out.print("Введи новую команду: ");
                String command1 = in1.nextLine();
                todolist.set(digitInt - 1, command1);
            }

            //DELETE *
            if (command.matches("DELETE\\s+\\d+")) {
                //отделяем цифру в команде и приводим к int
                String[] digit = command.split("\\s+");
                int digitInt = Integer.parseInt(digit[1]);

                todolist.remove(digitInt - 1);
            }
        }
    }
}
