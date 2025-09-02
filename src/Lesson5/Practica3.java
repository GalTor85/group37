package Lesson5;

import java.util.Arrays;

public class Practica3 {
    /*Задача 3:
Найдите сумму элементов на главной диагонали:*/
    public static void main(String[] args) {
        int size = (int) (Math.random() * 7 + 2);
        int[][] arr = new int[size][size];
        int sumGlav = 0;   //главная диагональ
        int sumPob = 0;    //побочная диагональ
        System.out.println("Генерация массива "+size+" на "+size+":");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][j] = (int) (Math.random() * 100); //случайное заполнение 1..99
                if (j == arr.length - 1) {
                    System.out.println(Arrays.toString(arr[i]));
                }
                if (i == j) {                //Главная диагональ
                    sumGlav += arr[i][j];
                }
                if ((i + j) == (size - 1)) {   //побочная диагональ
                    sumPob += arr[i][j];
                }
            }
        }
        System.out.println("Сумма эл-тов главной диагонали : "+sumGlav + "; сумма эл-тов побочной диагонали :" + " " + sumPob);
    }

}
