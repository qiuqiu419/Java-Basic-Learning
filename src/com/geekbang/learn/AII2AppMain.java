package com.geekbang.learn;

import java.util.Scanner;

public class AII2AppMain {

    public static void main(String[] args) {
        AI2 ai2 = new AI2();
        Scanner in = new Scanner(System.in);
        while (true) {
            String input = in.next();
            if ("exit".equals(input)) {
                System.out.println("ÔÙ¼û£¡");
                break;
            }
            String answer = ai2.answer(input);
            System.out.println(answer);
        }
    }
}
