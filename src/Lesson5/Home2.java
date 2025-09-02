package Lesson5;



public class Home2 {
    /*Задача 2:
Создать программу для раскраски шахматной доски с помощью цикла. Создать
двумерный массив String 8х8. С помощью циклов задать элементам массива значения
B(Black) или W(White). При выводе результат работы программы должен быть
следующим:
W B W B W B W B
B W B W B W B W
W B W B W B W B
B W B W B W B W
W B W B W B W B
B W B W B W B W
W B W B W B W B
B W B W B W B W*/
    public static void main(String[] args) {
        String[][] arr = new String[8][8];   //инициализация массива
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {         //условие раскраски
                    arr[i][j] = "W";            //раскраска
                } else arr[i][j] = "B";         //раскраска
                System.out.print(arr[i][j] + " ");   //вывод
                if (j == arr.length - 1) System.out.println(); //переход строки
            }
        }
    }
}
