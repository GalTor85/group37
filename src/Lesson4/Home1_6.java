package Lesson4;

import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

/*-----------------Для задач (1-6) общий код------------------------------
Для всех задач исходные условия следующие: пользователь с клавиатуры вводит размер
массива (просто целое число). После того, как размер массива задан, заполнить его
одним из двух способов: используя Math.random(), или каждый элемент массива вводится
пользователем вручную. Попробовать оба варианта.*/
public class Home1_6 {
    public static void main(String[] args) {
        System.out.print("Введите размер массива: ");
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {                                    //проверка ввода целых чисел
            int size = sc.nextInt();
            if (size <= 0) {
                System.out.println("Введено неверное значение!!!");
                sc.close();
                System.exit(-1);   //исключение нулевого и минусовых значений размера массива
            }
            int[] arr = new int[size];
            System.out.print("Введите 1 если хотите заполнить массив вручную (иначе массив заполниться рандомно):");
            if (sc.hasNextInt() && sc.nextInt() == 1) {               //проверка условия ввода 1
                System.out.println("Введите числа:");
                for (int i = 0; i < arr.length; i++) {
                    if (sc.hasNextInt()) {                           //проверка на правильность ввода
                        arr[i] = sc.nextInt();
                    } else {
                        System.out.println("Ошибка ввода");
                        sc.close();
                        System.exit(-1);
                    }
                }
            } else {
                System.out.println("Числа массива определены псевдослучайным образом в диапазоне от -99 до +99");
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = (int) (Math.random() * 200 - 100);

                }

            }
            //-----------------Далее код выбора конкретных задач-------------------------//
            System.out.println("Ваш массив :" + Arrays.toString(arr));

            System.out.println("Введите 1 -> Пройти по массиву, вывести все элементы в прямом и в обратном порядке.\n" +
                    "Введите 2 -> Найти минимальный-максимальный элементы.\n" +
                    "Введите 3 -> Найти индексы минимального и максимального элементов.\n" +
                    "Введите 4 -> Найти и вывести количество нулевых элементов.\n" +
                    "Введите 5 -> Поменять местами элементы первый и последний, второй и предпоследний и т.д.\n" +
                    "Введите 6 -> Проверить, является ли массив возрастающей последовательностью.");
            System.out.print("Ввод :");
            sc = new Scanner(System.in);                     //сбрасываем значение сканера
            if (sc.hasNextInt()) {
                int key = sc.nextInt();
                switch (key) {
                    case 1:
//-------------------------------Задача 1:-------------------------------------------------------
                        // Пройти по массиву, вывести все элементы в прямом и в обратном порядке.
                        Arrays.sort(arr);
                        System.out.println(Arrays.toString(arr));
                        System.out.print("[");
                        for (int i = arr.length - 1; i > 0; i--) {
                            System.out.print(arr[i] + ", ");
                        }
                        System.out.println(arr[0] + "]");
                        break;

                    case 2:
//-----------------------------------Задача 2:-------------------------------------------------
                        //Найти минимальный-максимальный элементы и вывести в консоль
                        int max = arr[0];
                        int min = arr[0];
                        for (int i = 0; i < arr.length; i++) {
                            if (arr[i] > max) {
                                max = arr[i];
                            }
                            if (arr[i] < min) {
                                min = arr[i];
                            }
                        }
                        System.out.println("Минимальное значение:" + min);
                        System.out.println("Максимальное значение:" + max);
                        break;

                    case 3:
//--------------------------------------------Задача 3:-------------------------------------------
                        //Найти индексы минимального и максимального элементов и вывести в консоль
                        int maxX = arr[0];
                        int minX = arr[0];
                        int indexMin = 0;
                        int indexMax = 0;
                        for (int i = 0; i < arr.length; i++) {
                            if (arr[i] > maxX) {
                                maxX = arr[i];
                                indexMax = i;
                            }
                            if (arr[i] < minX) {
                                minX = arr[i];
                                indexMin = i;
                            }
                        }
                        System.out.println("Минимальное значение:" + minX + " первый встречающийся индекс элемента (0..): " + indexMin);
                        System.out.println("Максимальное значение:" + maxX + " первый встречающийся индекс элемента (0..): " + indexMax);
                        break;

                    case 4:
/*--------------------------------------Задача 4:---------------------------------------------
                        Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести
                        сообщение, что их нет.*/
                        int count = 0;
                        for (int i = 0; i < arr.length; i++) {
                            if (arr[i] == 0) {
                                count++;
                            }
                        }
                        if (count >= 1) {
                            System.out.println("Количество нулевых элементов: " + count);
                        } else {
                            System.out.println("Нулевые элементы отсутствуют");
                        }
                        break;

                    case 5:
/*---------------------------------------Задача 5:----------------------------------------------
Пройти по массиву и поменять местами элементы первый и последний, второй и
предпоследний и т.д.*/
                        System.out.println("Исходный массив:\n " + Arrays.toString(arr));
                        for (int i = 0; i < arr.length / 2; i++) {
                            arr[i] += arr[arr.length - 1 - i];
                            arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
                            arr[i] -= arr[arr.length - 1 - i];
                        }
                        System.out.println("Полученный массив:\n " + Arrays.toString(arr));
                        break;

                    case 6:
/*---------------------------------------Задача 6:-----------------------------------------------
Проверить, является ли массив возрастающей последовательностью (каждое следующее
число больше предыдущего)*/
                        int[] arrCopy = Arrays.copyOf(arr, arr.length);
                        System.out.println("Ваш  массив: " + Arrays.toString(arr));
                        Arrays.sort(arrCopy);
                        if ((Arrays.equals(arr, arrCopy)) && (arr.length > 1)) {
                            System.out.println("Массив является возрастающей последовательность");
                        } else System.out.println("Массив не является возрастающей последовательность");
                        break;
                }
            } else {
                System.out.println("Введены неправильные данные");
            }
        } else {  // ------------обработка исключения по общему блоку---------------------
            System.out.print("Введен неправильный размер");
        }
        sc.close();
    }
}
