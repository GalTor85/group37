package Lesson7.HomeStar;


import java.lang.reflect.Field;

public class Main {
    /**
     * Задача *:
     * Создать класс Apple и добавить в него поле color с модификатором доступа private и
     * инициализировать его. В методе main другого класса создать объект Apple, и не
     * используя сеттеры изменить значение поля color.
     */
    public static void main(String[] args) {
        Apple apple = new Apple("зелёный");

        System.out.println("Цвет яблока " + apple.getColor());
//Рефлексия - другого способа не придумал...
        String color = "красное";  //новый цвет
       try {
           Field field = apple.getClass().getDeclaredField("color"); //поиск переменной color и передача ее в field
            field.setAccessible(true);                                      //открываем доступ к color (field)
           field.set(apple, color);                           //записываем в apple новое значение
       } catch (NoSuchFieldException | IllegalAccessException e) {         //блок исключений (ошибок)
            e.printStackTrace();
      }



        System.out.println("Новый цвет яблока " + apple.getColor());
    }
}



