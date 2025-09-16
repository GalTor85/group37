package Lesson9.Home1_Star;

import java.lang.reflect.Constructor;

    public class MainStar {
        /**
         * Задача *:
         * Написать такой конструктор, который запретит создание объекта класса Dog в других
         * классах; Найти способ вызывать методы voice(), eat() класса Dog, который позволит
         * обойти ограничение, наложенное конструктором выше. Объяснить, как работают оба
         * способа
         */
        public static void main(String[] args)

                throws Exception {
            Constructor<Dog> constructor = Dog.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Dog dog = constructor.newInstance();
            dog.voice();
            dog.setName("Шарик");
            dog.eat("мясо");
        }
    }

