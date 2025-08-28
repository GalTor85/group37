package Lesson4;

import java.util.Arrays;

public class HomeStar {
    /*------------------------------Задача *:----------------------------------------
Имеется массив из неотрицательных чисел(любой). Представьте что массив
представляет целое число (Например массив {1,2,3} -> 123, {9,9,9} -> 999). Задача
добавить единицу к этому “числу” и на выходе получить исправленный массив. Массив не
содержит нуля в начале, кроме самого числа 0.*/
    public static void main(String[] args) {

        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.abs(Math.random() * 10));
        }
        //int[] arr = {9, 9, 9, 9, 9};    //принудительное условие
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        arr[arr.length - 1]++;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] >= 10 && i > 0) {
                arr[i - 1] = arr[i - 1] + arr[i] / 10;
                arr[i] = 0;
            } else if (arr[i] >= 10 && i == 0) {
                arr = Arrays.copyOf(arr, arr.length + 1); //"копирование" массива с изменением размера
                arr[0] = 1;
            }
        }
        System.out.println("Полученный массив: " + Arrays.toString(arr));
    }
}
