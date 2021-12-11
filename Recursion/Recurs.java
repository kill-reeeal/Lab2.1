package com.company;

import java.util.Scanner;

public class Recurs {
    private int num = 0;

    static Scanner in = new Scanner(System.in);

    public void recursion_1(int n) {
        if (num != n) {
            num += 1;
            System.out.println(num);     // Вывод чисел от 1 до N
            recursion_1(n);
        }
    }

    public void recursion_2(int a, int b, int c, boolean f) {     //Вывод чисел между A и B
        if (a == b) {
            System.out.println(a);
            f = false;
        }
        while (f = true)
            if (a < b && a != b) {
                System.out.println(a);
                a += 1;
                recursion_2(a, b, c, f);
            } else if (a > b && a != b) {
                System.out.println(a);
                a -= 1;
                recursion_2(a, b, c, f);
            } else
                f = false;
    }

    public void recursion_3(int n, int div, int sum) {    //Сумма цифр числа N
        if (n != 0) {
            div = n % 10;
            n = n / 10;
            sum += div;
            recursion_3(n, div, sum);
        } else
            System.out.println(sum);
    }
}