package Lesson14.HomeStar;

public class ExVal {
    static String[] begin(String string, int lengthNumber, String... prefix) {
        String sb = string;
        String notValidNum = "";
        String validNum = "";
        String[] temp = sb.split("\r");    //Разбиваем входную строку по строчно на массив он нужен для вывода не валидных значений
        boolean[] isPrefix = new boolean[temp.length]; //boolean переменная для "запоминания" вхождения префиксов
        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].strip(); //убираем пробелы и тп
            if (prefix.length >= 1) { //проверка входящих префиксов
                for (int j = 0; j < prefix.length; j++) {

                    //проверка валидации (префиксы)
                    if ((sb.split("\r")[i].strip().matches(prefix[j] + "[a-zA-Zа-яА-Я0-9]{" +
                            (lengthNumber - prefix[j].length()) + "}")) && (!isPrefix[i])) {
                        validNum += temp[i] + "\n"; //собираем валидную строку
                        temp[i] = ""; //обнуляем значение в массиве не валидных значений
                        isPrefix[i] = true;  //ставим метку, что есть префикс

                        //префикс не в начале строки
                    } else if ((sb.split("\r")[i].strip().matches(".+" + prefix[j] + ".*")) && (!isPrefix[i])) {
                        temp[i] += ", содержит префикс " + prefix[j] + ", но не в начале строки"; //собираем инвалидный:) массив
                        isPrefix[i] = true; //ставим метку, что есть префикс

                        //содержит вначале строки префикс, но не валидный
                    } else if ((sb.split("\r")[i].strip().matches(prefix[j] + ".*")) && (!isPrefix[i])) {
                        temp[i] += ", содержит префикс " + prefix[j] + ", но"; //собираем инвалидный:) массив
                        isPrefix[i] = true; //ставим метку, что есть префикс
                    }
                }
                //блок проверки на отсутствие префиксов
                for (int j = 0; j < prefix.length; j++) {

                    //не содержит префикс (префиксов всего 1)
                    if (prefix.length == 1 && !temp[i].strip().contains(prefix[j]) && (!isPrefix[i])) {
                        temp[i] += ", не содержит префикс " + prefix[j]; //собираем инвалидный:) массив
                        isPrefix[i] = true; //ставим метку, что есть префикс он здесь только один

                        //не содержит префикс (префиксов больше 1..2,3 и т.д.)
                    } else if ((!(temp[i].strip().contains(prefix[j]))) && (!isPrefix[i])) {
                        temp[i] += ", не содержит префикс " + prefix[j]; //собираем инвалидный:) массив
                        if (j == prefix.length) {
                            isPrefix[i] = true;  //ставим метку, что есть все префиксы по длине массива префиксов
                        }
                    }
                }

                //блок проверки если префиксов нет, ну мало ли...
            } else if (sb.split("\r")[i].strip().matches("[a-zA-Zа-яА-Я0-9]{" + lengthNumber + "}")) {
                validNum += temp[i] + "\n"; //собираем валидный массив без префиксов
                temp[i] = ""; //обнуляем значение в массиве не валидных значений
            }
            //проверка на недопустимые символы
            if (sb.split("\r")[i].strip().matches(".*?![a-zA-Zа-яА-Я0-9].*|.*?_.*")) {
                temp[i] += ", содержит недопустимые символы: " +   //собираем инвалидный:) массив
                        sb.split("\r")[i].strip().replaceAll("[a-zA-Zа-яА-Я0-9]", "").strip();
            }
            //проверка на пробелы внутри
            if (sb.split("\r")[i].strip().replaceAll(" ", "").length()
                    < sb.split("\r")[i].strip().length()) {
                temp[i] += ", содержит пробелы внутри строки";  //собираем инвалидный:) массив
            }
            //проверка длин и продолжаем собирать инвалидный:) массив
            if (sb.split("\r")[i].strip().length() > lengthNumber) {
                temp[i] += ", больше допустимой длины на:" + (sb.split("\r")[i].strip().length() - lengthNumber);
            } else if (sb.split("\r")[i].strip().length() < lengthNumber) {
                temp[i] += ", меньше допустимой длины на:" + (lengthNumber - sb.split("\r")[i].strip().length());
            }
        }
        //выгружаем инвалидный массив значений в строку тоже инвалидную
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != "") {
                notValidNum += temp[i] + "\n";
            }
        }

        //возврат массива валидных и невалидных значений
        return new String[]{validNum.strip(), notValidNum.strip()};
    }
}


