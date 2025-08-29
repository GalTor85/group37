package Liesson5;


import java.util.Scanner;

public class HomeStar {/*Задача *:
Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой (см. пример).
Формат входных данных:
Программа получает на вход два числа n и m.
Формат выходных данных:
Программа должна вывести полученный массив, отводя на вывод каждого числа ровно 3
символа.*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество строк массива : ");
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.print("Введите количество столбцов массива : ");
            if (sc.hasNextInt()) {
                int m = sc.nextInt();
                sc.close();
                int temp = 0;
                int[][] arr = new int[n][m];
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (i % 2 == 0) {
                            arr[i][j] = temp;
                            temp++;
                        } else {
                            arr[i][arr[i].length - 1 - j] = temp;
                            temp++;
                        }
                    }
                }
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr[i].length; j++) {
                        if (Math.abs(arr[i][j] / 10) < 1) {
                            System.out.print("  " + arr[i][j]);
                        } else if (Math.abs(arr[i][j]) / 10 >= 1 && Math.abs(arr[i][j]) / 10 < 10) {
                            System.out.print(" " + arr[i][j]);
                        } else System.out.print(arr[i][j]);
                        if (j == arr[i].length - 1) System.out.println();
                    }
                }
            } else {
                System.out.println("Ввод неверный!!!");
                sc.close();
            }
        } else {
            System.out.println("Ввод неверный!!!");
            sc.close();
        }
    }
}
