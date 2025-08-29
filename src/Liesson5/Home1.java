package Liesson5;

import java.util.Arrays;
import java.util.Scanner;

public class Home1 {
    /*Задача 1:
1.1 Создать двумерный массив, заполнить его случайными числами.
1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
1.3 Найти сумму всех получившихся элементов и вывести в консоль.*/
    public static void main(String[] args) {
        int sizeA = (int) (Math.random() * 7 + 2);                      //1.1
        int sizeB = (int) (Math.random() * 7 + 2);                      //1.1
        System.out.println("Массив размером  " + sizeA + " на " + sizeB + " :");
        int[][] arr = new int[sizeA][sizeB];                            //создание массива
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 100);                //наполнение массива
                if (j == sizeB - 1) {
                    System.out.println(Arrays.toString(arr[i]));        //вывод массива
                }
            }
        }
        System.out.print("Введите число на которое следует увеличить элементы массива:");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int sum = 0;
            int a = sc.nextInt();                                           //1.2
            System.out.println("Получившийся массив :");
            sc.close();
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] += a;                                         //1.2
                    sum += arr[i][j];                                       //1.3
                    if (j == sizeB - 1) {
                        System.out.println(Arrays.toString(arr[i]));
                    }
                }
            }
            System.out.println("Сумма элементов нового массива: " + sum);  //1.3
        } else {
            System.out.println("Введены неверные данные!!!");
            sc.close();
        }
    }

}
