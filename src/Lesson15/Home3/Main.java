package Lesson15.Home3;

import java.util.ArrayList;

public class Main {
    /**
     * Задача 3:
     * Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
     * оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
     * Написать метод, который удаляет студентов со средним баллом <3. Если средний
     * балл>=3, студент переводится на следующий курс. Дополнительно написать метод
     * printStudents(List<Student> students, int course), который получает список студентов и
     * номер курса. А также печатает на консоль имена тех студентов из списка, которые
     * обучаются на данном курсе.
     */
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Алексей", "ВМ01", 1, new int[]{3, 4, 4, 5, 3,}));
        students.add(new Student("Виктор", "ВМ01", 2, new int[]{3, 4, 4, 5, 3,}));
        students.add(new Student("Сергей", "ВМ01", 1, new int[]{3, 4, 4, 5, 3,}));
        students.add(new Student("Сергей", "ВМ01", 2, new int[]{3, 4, 4, 3, 3,}));
        students.add(new Student("Сергей", "ВМ01", 2, new int[]{3, 4, 4, 5, 3,}));
        System.out.println(students);

        deleteStudent(students);
        System.out.println(students);
        printStudents(students, 2);

    }

    static public void deleteStudent(ArrayList<Student> student) {
        for (int index = 0; index < student.size(); index++) {
            Double sum = 0.0;
            for (int i = 0; i < student.get(index).getBall().length; i++) {
                sum += student.get(index).getBall()[i];
            }
            if (sum / (student.get(index).getBall().length + 1) < 3) {
                student.remove(student.get(index));
                index--;
            } else {
                student.get(index).setCourse(student.get(index).getCourse() + 1);
            }
        }
    }

    static void printStudents(ArrayList<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }

    }


}
