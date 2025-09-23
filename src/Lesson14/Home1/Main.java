package Lesson14.Home1;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    /**
     * Задача 1:
     * В задании приложен файл Ромео и Джульетта на английском, вычитать его в Idea.
     * Проанализировать и записать в другой файл самое длинное слово.
     */
    public static void main(String[] args) {
        try (FileReader fr = new FileReader(System.getProperty("user.dir") + "\\PublicFile\\Romeo and Juliet.txt")) {
            StringBuilder input = new StringBuilder();
            int i;
            while ((i = fr.read()) != -1) {
                input.append((char) i);
            }
            String[] arrTemp = input.toString().split("\\W+");
            i = 0;
            String maxLength = "";
            while (i < arrTemp.length) {
                if (arrTemp[i].length() > maxLength.length()) {
                    maxLength = arrTemp[i];
                }
                i++;
            }
            System.out.println(maxLength);

            try (FileWriter fw = new FileWriter(System.getProperty("user.dir") + "\\Pub licFile\\Outs.txt")) {
                fw.write(maxLength);
            } catch (IOException e) {
                System.out.println(e);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}

