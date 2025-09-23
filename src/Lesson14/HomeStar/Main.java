package Lesson14.HomeStar;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * Задача *:
     * Допустим есть txt файл с номерами документов. Номером документа является строка,
     * состоящая из букв и цифр(без служебных символов). Пусть этот файл содержит
     * каждый номер документа с новой строки и в строке никакой другой информации,
     * только номер документа. Валидный номер документа должен иметь длину 15
     * символов и начинаться с последовательности docnum(далее любая
     * последовательность букв/цифр) или contract(далее любая последовательность
     * букв/цифр). Написать программу для чтения информации из входного файла - путь к
     * входному файлу должен задаваться через консоль. Программа должна проверять
     * номера документов на валидность. Валидные номера документов следует записать в
     * один файл-отчет. Невалидные номера документов следует записать в другой
     * файл-отчет, но после номеров документов следует добавить информацию о том,
     * почему этот документ не валиден.
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("Введите путь к файлу из которого считывать информацию (exit -выход, dir - текущая директория):");
            System.out.print("\\->");
            Scanner sc = new Scanner(System.in);
            String filePathNumbers = sc.nextLine(); //ввод пути к файлу или команд
            if (filePathNumbers.equals("exit")) {
                sc.close();
                break;
            } //выход по exit
            if (filePathNumbers.equals("dir")) {         //вывод текущей директории
                System.out.println(System.getProperty("user.dir"));
                System.out.println("Введите путь к файлу из которого считывать информацию (exit -выход, dir - текущая директория):");
                System.out.print("\\->");
                sc.reset(); //перезагрузка сканера
                filePathNumbers = sc.nextLine(); //ввод пути к файлу или команд
            }

            //проверка ввода имени файла только с расширением!!!
            while (!filePathNumbers.matches(".+?\\w+[.]\\w+")) {
                try {
                    if (!filePathNumbers.matches(".+?\\w+[.]\\w+")) {
                        throw new RuntimeException(" укажите расширение файла");
                    }
                } catch (RuntimeException e) {
                    System.out.println("Ошибка " + e.getMessage());
                    System.out.println("Введите путь к файлу из которого считывать информацию (exit -выход, dir - текущая директория):");
                    System.out.print("\\->");
                    sc.reset(); //перезагрузка сканера
                    filePathNumbers = sc.nextLine();//ввод пути к файлу или команд
                }
            }

            //меняем название введённого файла на valid.txt, работает только с файлами с расширением,
            // сюда будем выгружать валидные значения путь тот же
            String filePathValid = filePathNumbers.replaceAll("\\w+[.]\\w+", "\\valid.txt");
            //меняем название введённого файла на notvalid.txt, сюда будем выгружать не валидные значения путь тот же
            String filePathNotValid = filePathNumbers.replaceAll("\\w+[.]\\w+", "\\notvalid.txt");

            StringBuilder sb = new StringBuilder(); //временная строчка для считывания файла
            String valid = "";
            String notValid = "";

            //блок проверки исключений IOException
            try
                    (FileReader fileReader = new FileReader(filePathNumbers);
                     FileWriter fileWriterValid = new FileWriter(filePathValid);
                     FileWriter fileWriterNotValid = new FileWriter(filePathNotValid);
                    ) {
                int i;
                System.out.println("Считываем <<-" + filePathNumbers);
                while ((i = fileReader.read()) != -1) {
                    sb.append((char) i);
                }
                String numbers = sb.toString(); //для работы с методом ExVal.begin преобразуем в String
                valid = ExVal.begin(numbers, 15, "docnum", "contract")[0]; //валид
                notValid = ExVal.begin(numbers, 15, "docnum", "contract")[1]; //инвалид
                System.out.println("Записываем валидные значения в ->>" + filePathValid);
                fileWriterValid.write(valid);
                System.out.println("Записываем не валидные значения в ->>" + filePathNotValid);
                fileWriterNotValid.write(notValid);
                sc.close();
                break; //заканчиваем программу

            } catch (IOException | RuntimeException e) {
                System.out.println("Ошибка " + e.getMessage());
            }
        }
    }
}