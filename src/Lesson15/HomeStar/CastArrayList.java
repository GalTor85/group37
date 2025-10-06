package Lesson15.HomeStar;

import java.util.Arrays;

public class CastArrayList<E> {
    //e - класс массива
    private E[] array;

    //Переопределение ToString
    @Override
    public String toString() {
        String out = "[";
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    if (i == 0) {
                        out += array[i].toString();
                    } else {
                        out += ", " + array[i].toString();
                    }
                }
            }
            out += "]";
        } else {
            out = null;
        }
        return out;
    }

    //Конструктор - создает массив по умолчанию =10
    public CastArrayList() {
        if (array == null) {
            array = (E[]) new Object[10];
        }
        this.array = array;
    }

    //метод длина (начинается с 1..)
    int length() {
        int length = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                length++;
            }
        }
        return length;
    }

    //метод добавляет элемент в конец
    public void add(E e) {
        for (int i = 0; i < array.length; i++) {
            if (null == array[i]) {
                array[i] = e;
                break;
            } else if (i == array.length - 1) {
                array = Arrays.copyOf(array, array.length * 2);
            }
        }
    }

    //метод удаления элемента по индексу
    public boolean remove(int index) {
        if ((index != 0) && (index <= length()) && (null != array[index - 1] && null != get(index))) {
            int lens = length();
            for (int i = index; i < length(); i++) {
                array[i - 1] = array[i];
            }
            array[length() - 1] = null;
            return true;
        } else {
            return false;
        }
    }

    //метод возвращает элемент по индексу
    public E get(int index) {
        if ((index != 0) && (index <= length()) && (null != array[index - 1])) {
            return array[index - 1];
        }
        return null;
    }

    //метод заменяет элемент по индексу
    public boolean replace(E e, int index) {
        if ((e != null) && (index != 0) && (index <= length()) && (null != array[index - 1])) {
            array[index - 1] = e;
            return true;
        }
        return false;
    }

    //метод добавляет элемент по индексу
    public boolean add(E e, int index) {
        if (length() == array.length && index != 1) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        if ((index != 0) && (index <= length()) && array[index - 1] != null || index == 1) {
            int lens = length();
            for (int i = lens; i >= index; i--) {
                array[i] = array[i - 1];
            }
            array[index - 1] = e;
            return true;
        } else {
            return false;
        }
    }

    //метод добавляет в начало
    public void addFirst(E e) {
        if ((array.length) == length()) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        int lens = length();
        for (int i = 0; i < lens; i++) {
            array[lens - i] = array[lens - i - 1];
        }
        array[0] = e;
    }
}




