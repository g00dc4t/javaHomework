package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //Пример номера: a111aa(01-197)
        String[] letters = {"A","B","E","K","M","H","O","P","C","T","Y","X"}; //АВЕКМНОРСТУХ
        String[] digits = {"000","111","222","333","444","555","666","777","888","999"};
        String[] number = new String[4]; //Длина номера 8 символов (0,2,3 - letters; 1 - digits)
        ArrayList<String> numbersList = new ArrayList<>();
        HashSet<String> hSet = new HashSet<>();
        hSet.addAll(numbersList);
        TreeSet<String> tSet = new TreeSet<>();
        tSet.addAll(numbersList);
        Scanner scanner = new Scanner(System.in);
        //Инициализируем генератор
        Random numberRnd = new Random(System.currentTimeMillis());
        int k = 0;
        while (k++ < 2000000) {
            for (int i = 0; i < number.length; i++) {
                //Генератор случайных чисел от min до max
                int leterRnd = 0 + numberRnd.nextInt(11 - 0 + 1);
                if (i == 0 || i == 2 || i == 3) number[i] = letters[leterRnd];
                for (int j = 0; j < number.length; j++) {
                    int digitRnd1 = 0 + numberRnd.nextInt(9 - 0 + 1);
                    if (j == 1) number[j] = digits[digitRnd1];
                }
            }
            //Рандомим последние три цифры
            int digitRnd2 = 0 + numberRnd.nextInt(196 - 0 + 1);
            String numberStr2 = Integer.toString(digitRnd2);
            if (digitRnd2 < 10) numberStr2 = "0" + numberStr2;
            //Перевод array в String
            String numberStr = new String();
            for (int i = 0; i < number.length; i++) numberStr += number[i];
            //Добавление String в list
            numbersList.add(numberStr + numberStr2);
        }
        while (true) {
            System.out.print("Введите номер: ");
            String newNumber = scanner.nextLine();

            long start = System.currentTimeMillis();
            numbersList.contains(newNumber);
            long duration = System.currentTimeMillis() - start;
            System.out.println("перебор " + numbersList.contains(newNumber) + " - " + duration);

            Collections.sort(numbersList);
            long start1 = System.currentTimeMillis();
            Collections.binarySearch(numbersList, newNumber);
            long duration1 = System.currentTimeMillis() - start1;
            System.out.println("бинарный " + numbersList.contains(newNumber) + " - " + duration1);

            long start2 = System.currentTimeMillis();
            hSet.contains(newNumber);
            long duration2 = System.currentTimeMillis() - start2;
            System.out.println("HashSet " + numbersList.contains(newNumber) + " - " + duration2);

            long start3 = System.currentTimeMillis();
            tSet.contains(newNumber);
            long duration3 = System.currentTimeMillis() - start3;
            System.out.println("TreeSet " + numbersList.contains(newNumber) + " - " + duration3);
        }
    }
}
