package Lesson15.HomeStar;

import Lesson15.Home3.Student;

public class Main {
    /**
     * Задача *:
     * Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий
     * работу класса динамической коллекции - т.е. создать свою кастомную коллекцию. В
     * основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных
     * классов(т.е. это generic).
     */

    public static void main(String[] args) {

        CastArrayList<String> castArrayList = new CastArrayList<>();
        castArrayList.add("Один");
        castArrayList.add("Четыре");
        castArrayList.addFirst("отсчета:");
        castArrayList.add("Три", 3);
        castArrayList.add("Два", 3);
        castArrayList.add("Два", 3);
        castArrayList.add("Это тут не появится", 9); //за пределами размера
        castArrayList.add("И это тоже", 0); //индекс начинается с 1
        castArrayList.add("Пять");
        castArrayList.add("Шесть");
        castArrayList.add("Семь");
        castArrayList.add("Восемь");
        castArrayList.addFirst("начало");
        castArrayList.addFirst("здесь");
        castArrayList.addFirst("Вот");
        System.out.println(castArrayList); //вывод переопределённым методом toString
        castArrayList.remove(6);  //удаление лишнего элемента
        //вывод циклом поэлементно
        for (int i = 1; i <= castArrayList.length(); i++) {
            System.out.print(castArrayList.get(i) + " ");
        }
        System.out.println("\nДлина равна " + castArrayList.length());

        //Пример с цифрами
        CastArrayList<Integer> cast2ArrayList = new CastArrayList<>();
        cast2ArrayList.add(1);
        cast2ArrayList.add(2);
        cast2ArrayList.add(3);
        cast2ArrayList.addFirst(4);
        System.out.println(cast2ArrayList);
        //Пример с пользовательским классом
        CastArrayList<Student> cast3ArrayList = new CastArrayList<>();
        cast3ArrayList.add(new Student("Алексей", "ВМ01", 1, new int[]{3, 4, 4, 5, 3,}));
        cast3ArrayList.add(new Student("Виктор", "ВМ01", 2, new int[]{3, 4, 4, 5, 3,}));
        cast3ArrayList.add(new Student("Сергей", "ВМ02", 1, new int[]{3, 4, 4, 5, 3,}), 2);
        cast3ArrayList.addFirst(new Student("Борис", "ВМ01", 2, new int[]{3, 4, 4, 3, 3,}));
        cast3ArrayList.add(new Student("Геннадий", "ВМ01", 2, new int[]{3, 4, 4, 5, 3,}));
        cast3ArrayList.add(new Student("Сергей", "ВМ05", 1, new int[]{3, 4, 4, 5, 3,}), 1);
        cast3ArrayList.addFirst(new Student("Борис", "ВМ01", 3, new int[]{3, 4, 4, 3, 3,}));
        System.out.println(cast3ArrayList); //вывод
        System.out.println(cast3ArrayList.replace(cast3ArrayList.get(0), 3)); //программа не ломается метод возвращает false
        System.out.println(cast3ArrayList.get(11));  //программа не ломается метод принимает значение null

    }
}