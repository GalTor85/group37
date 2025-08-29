package Liesson5;

import java.util.Arrays;

public class Practica1 {
    /*Задача 1:
1.1 Создайте двумерный массив и заполните его псевдослучайными числами с помощью
класса Random.
1.2 Найдите максимальное значение в созданном 2-мерном массиве*/

    public static void main(String[] args) {
        int sizeA = (int) (Math.random() * 5 + 2);  //случайный размер массива по вертикали 2..6
        int sizeB = (int) (Math.random() * 5 + 2);  //случайный размер массива по горизонтали 2..6
        int[][] arr = new int[sizeA][sizeB];
        int maxValue = Integer.MIN_VALUE;    //инициализация максимального значения
        System.out.println("Сгенерированный Массив "+sizeA+" строк, "+sizeB+" столбцов:");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) ((Math.random() * 200 - 100)); //случайное заполнение -99..99
                if (arr[i][j] > maxValue) {
                    maxValue = arr[i][j];
                }
                if (j == arr[i].length - 1) {
                    System.out.println(Arrays.toString(arr[i]));
                                                        }
            }
        }

        System.out.println("Максимальное  значение: "+maxValue);
    }
}
