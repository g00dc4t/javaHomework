package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Список команд:\nLIST - показать список имейлов;\nADD - добавить новый имейл.");

        HashSet<String> emailsList = new HashSet<>();
            emailsList.add("one@mafaka.com");
            emailsList.add("two@mafaka.com");
            emailsList.add("three@mafaka.com");

        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("Введи команду: ");
            String command = in.nextLine();

            //Проверка на правильность ввода команд
            if (command.equals("LIST") || command.equals("ADD")) {
            } else System.out.println("Нет такой команды");
            //LIST
            if (command.equals("LIST"))
                for (String email : emailsList) {
                    System.out.println(email);
                }
            //ADD
            if (command.equals("ADD")) {
                while (true) {
                    Scanner in1 = new Scanner(System.in);
                    System.out.print("Введи новый имейл в формате ***@***.(com|net|org): ");
                    String command1 = in1.nextLine();
                    if (command1.matches(".+\\@.+\\.(com|net|org)")) {
                        emailsList.add(command1);
                        break;
                    } else System.out.println("Неверный имейл");
                }
            }
        }
    }
}
