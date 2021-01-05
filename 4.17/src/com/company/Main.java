package com.company;

import java.util.Scanner;

public class Main {
    public static int amountContainer;
    public static int amountCargo;
    public static int boxesInContainer = 27;
    public static int containerInCargo = 12;

    public static void main(String[] args) {

        //Ввод количеста ящиков в консоль
        Scanner sc = new Scanner(System.in);
        System.out.print("Количество ящиков: ");
        int amountBoxes = sc.nextInt();

//        //Подсчёт количества контейнеров
////        if (amountBoxes < boxesInContainer && amountBoxes != 0) amountContainer++;
////        if (amountBoxes % boxesInContainer != 0 && amountBoxes > boxesInContainer) amountContainer++;
////        amountContainer += amountBoxes / boxesInContainer;
////
////        //Подсчёт количества грузовиков
////        if (amountContainer < containerInCargo && amountContainer != 0) amountCargo++;
////        if (amountContainer % containerInCargo != 0 && amountContainer > containerInCargo) amountCargo++;
////        amountCargo += amountContainer / containerInCargo;
////
////        System.out.println("\nКоличество необходмых контейнеров: " + amountContainer);
////        System.out.println("Количество необходмых грузовиков: " + amountCargo);

        //Вывод результата
            for (int i = 1, k = 1, g = 1; i <= amountBoxes; i++) {
                if (i % (boxesInContainer * containerInCargo) == 1) {
                    System.out.println("\nГрузовик " + g);
                    g++;
                }
                if (i % boxesInContainer == 1) {
                    System.out.println("\tКонтейнер " + k);
                    k++;
                }
                System.out.println("\t\tЯщик " + i);
            }
    }
}
