package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static int sum;

    public static void main(String[] args) {
	    //Задача 1
//        String text = "Вася заработал 5000 рублей, Петя - 5000  рубля, а Маша - 5000 рублей, а Дима 5000";
//        String[] sentences = text.split("\\,\\s+");
//        for (int i = 0; i < sentences.length; i++) {
//            String digitString = sentences[i].replaceAll("[^0-9]", "");
//            int digitInt = Integer.parseInt(digitString);
//            sum += digitInt;
//        }
//        System.out.println(sum);

        //Задача 2
//        String text = "In total, immigrants would have to reach 70 points to be able to work in the UK, with points also being awarded for qualifications, the salary on offer and working in a sector with shortages.\n" +
//                "But the government said it would not introduce a route for lower-skilled workers, urging businesses to \"adapt and adjust\" to the end of free movement between EU countries and the UK.\n" +
//                "\"It is important employers move away from a reliance on the UK's immigration system as an alternative to investment in staff retention, productivity and wider investment in technology and automation,\" it said.\n" +
//                "Instead, it said the 3.2 million EU citizens who have applied to continue staying in the UK could help meet labour market demands.\n" +
//                "The government also pointed to a quadrupling of the scheme for seasonal workers in agriculture to 10,000, as well as \"youth mobility arrangements\", which allow 20,000 young people to come to the UK each year.";
//        String[] words = text.split("\\s+");
//        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i].replaceAll("[^A-Za-z0-9]", ""));
//        }

        //Задача 3
//        Scanner in = new Scanner(System.in);
//        System.out.print("Введите ФИО:");
//        String fio = in.nextLine();
//
//        String[] words = new String[3];
//        words[0] = "Фамилия: ";
//        words[1] = "Имя: ";
//        words[2] = "Отчество: ";
//
//        String[] firstNlastNsecondN = fio.split("\\s+");
//
//        for (int i = 0; i < firstNlastNsecondN.length; i++) {
//            System.out.println(words[i] + firstNlastNsecondN[i]);
//        }

        //Задача 4
//        Scanner in = new Scanner(System.in);
//        System.out.print("Введите номер телефона:");
//        String telNum = in.nextLine();
//
//        String [] newTelNum = telNum.replaceAll("[^0-9]", "").split("");
//
//        String [] form = {"+","0"," ","0","0","0"," ","0","0","0","-","0","0","-","0","0",};
//
//        form [1] = newTelNum [0];
//        form [3] = newTelNum [1];
//        form [4] = newTelNum [2];
//        form [5] = newTelNum [3];
//        form [7] = newTelNum [4];
//        form [8] = newTelNum [5];
//        form [9] = newTelNum [6];
//        form [11] = newTelNum [7];
//        form [12] = newTelNum [8];
//        form [14] = newTelNum [9];
//        form [15] = newTelNum [10];
//
//        for (int i = 0; i < form.length; i++) {
//            System.out.print(form[i]);
//        }
    }
}
