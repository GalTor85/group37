package Lesson12.HomeStar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    /**
     * Задача *:
     * Программа на вход получает произвольный текст. В этом тексте может быть номер
     * документа(один или несколько), емейл и номер телефона. Номер документа в
     * формате: xxxx-xxxx-xx, где x - это любая цифра; номер телефона в формате:
     * +(xx)xxxxxxx. Документ может содержать не всю информацию, т.е. например, может не
     * содержать номер телефона, или другое. Необходимо найти эту информацию и вывести
     * в консоль в формате:
     * email: teachmeskills@gmail.com
     * document number: 1423-1512-51
     * и т.д
     */
    public static void main(String[] args) {
        String text = " 1234-5678-90  Фролов Михаил Андреевич сот +(12)3456789 frolov@mail.ru " +
                " 1234-5678-91   +(98)7654321   1234-5678-92  vetrov@gmail.com +(98)7654322 ";

        Pattern pat = Pattern.compile("([a-z]{2,}@[a-z]{2,}\\.[a-z]{2,})|(\\d{4}-\\d{4}-\\d{2})|" +
                "(\\+\\(\\d{2}\\)\\d{7})");
        String temp = "";
        Matcher matcher = pat.matcher(text);
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                System.out.println("e-mail: " + matcher.group(1));

                temp = temp + matcher.group(1) + "|";
            }
            if (matcher.group(2) != null) {
                System.out.println("document number:  " + matcher.group(2));
                temp = temp + matcher.group(2) + " ";
            }
            if (matcher.group(3) != null) {
                System.out.println("telephon:  " + matcher.group(3));
                temp = temp + matcher.group(3) + " ";
            }
        }
    }
}
