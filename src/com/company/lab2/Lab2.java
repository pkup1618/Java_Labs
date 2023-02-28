package com.company.lab2;

import java.util.Scanner;

public class Lab2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для проверки");
        Message message = new Message(scanner.nextLine());

        System.out.println(message.countWords());
        System.out.println(message.replaceSubstring(" ", "abc"));
        System.out.println(message.count('a'));
        System.out.println(message.number());
        System.out.println(message.reverse());
    }

}
