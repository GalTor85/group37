package Liesson5;

import java.util.ArrayList;
import java.util.Arrays;

public class Practica2 {
    /*Задача 2:
Создать зубчатый n-мерный массив(от 3 уровней). Посчитать количество ячеек в нём.*/
    public static void main(String[] args) {
        int sizeA = (int) (Math.random() * 5 + 2);//Мерность
        int sizeB = (int) (Math.random() * 5 + 2);//Мерность
        int sizeC = (int) (Math.random() * 5 + 2);//Мерность
        int sizeD = (int) (Math.random() * 5 + 2);//Мерность
        int[][][][] arr = new int[sizeA][sizeB][sizeC][sizeD];
        int sumN = 0;  //тут можно перемножить sizeA..D и получить сумму
        sumN = arr.length * arr[0].length * arr[0][0].length * arr[0][0][0].length;  //можно так
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)//Тут можно использовать sizeA..B , но...
                for (int k = 0; k < arr[i][j].length; k++)
                    for (int l = 0; l < arr[i][j][k].length; l++) {
                        arr[i][j][k][l] = (int) (Math.random() * 100);
                        //sumN++;               //можно так
                        if (l == arr[i][j][k].length - 1) {
                            System.out.println(Arrays.toString(arr[i][j][k])); //вывод элементов массива
                        }
                    }
        System.out.println("Мерность: | " + sizeA + " | " + sizeB + " | " + sizeC + " | " + sizeD + " |; количество ячеек: " + sumN);
    }
}
