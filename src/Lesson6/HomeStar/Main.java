package Lesson6.HomeStar;

import java.util.Random;
import java.util.Scanner;

/**
 * Задача *:
 * Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
 * задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
 * метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
 * принимает сумму денег, а возвращает булевое значение - успешность выполнения
 * операции. При снятии денег, функция должна распечатывать каким количеством купюр
 * какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
 * количеством купюр каждого номинала.
 */
public class Main {
    public static void main(String[] args) {
        Bankomat bankomat = new Bankomat(new Random().nextInt(11),   //Генерируем случайное заполнение
                new Random().nextInt(11),                     //банкомата купюрами
                new Random().nextInt(11));
        System.out.println("В банкомате - " + bankomat.sumMoney() + " кредитов."); //Вывод суммы кредитов в банкомате
        System.out.println(bankomat.amBanknote20 + " " + bankomat.amBanknote50 + " " + bankomat.amBanknote100);
        System.out.print("Желаете внести деньги? Напишите Да - ");  //Запрос на внесение денег.
        Scanner sc = new Scanner(System.in);
        String answer = sc.hasNextLine() ? sc.nextLine() : "";
        if (answer.equals("Да") || answer.equals("да")) {    //Проверка ответа
            bankomat.getAmBanknote();                //исполнение метода getAmBanknote() - без параметров
            System.out.println("В банкомате - " + bankomat.sumMoney() + " кредитов.");
        }  //Вывод остатка в банкомате
        System.out.print("Какую сумму желаете снять : ");         //Запрос о снятии кредитов
        int sum = sc.hasNextInt() ? sc.nextInt() : 0;             //проверка условия sc.hasNextInt()
        if (bankomat.getRevBanknote(sum)) {                       //проверка условия метода getRevBanknote()
            System.out.println("В банкомате осталось: " + bankomat.sumMoney() + " кредитов.");
            sc.close();
        }
    }

}
