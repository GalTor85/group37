package Lesson4;

public class ArrayMain {
    public static void main(String[] args) {
        String[] names = new String[6]; //Инициализвция пустого массива
        names[0] = "John";
        names[1] = "Alex";
        names[2] = "Jan";
        names[3] = "Foma";
        names[4] = "Dima";
        names[5] = "Lena";
        String[] names2 = {"John", "Alex", "Jan", "Foma", "Dima", "Lena"}; //Инициализация массива со зевчениями
        System.out.println(names[3]);
        System.out.println(names2[3]);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }
        int[] numbers = {10, 20, 30, 40, 50};
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
            i = i + 1;
        }
        System.out.println(sum);
        for (int num : numbers) {    //For each
            System.out.println(num);
        }

        int notZero = 0;
        int[] array = {1, 2, 0, 5, 0, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                notZero++;
            }
        }
        if (notZero > 0) {
            int[] arrayNotZero = new int[notZero];
            int index = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] != 0) {
                    arrayNotZero[index++] = array[i];
                }
            }
            for (int i = 0; i < arrayNotZero.length; i++) {
                System.out.println(arrayNotZero[i]);

            }
        }

    }


}
