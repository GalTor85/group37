package Lesson6.HomeStar;


import java.util.Scanner;

public class Bankomat {
    int amBanknote20;
    int amBanknote50;
    int amBanknote100;

    //конструктор с переменными
    public Bankomat(int amBanknote20, int amBanknote50, int amBanknote100) {
        this.amBanknote20 = amBanknote20;
        this.amBanknote50 = amBanknote50;
        this.amBanknote100 = amBanknote100;
    }

    //пустой конструктор
    public Bankomat() {
    }

    //метод внесения купюр непосредственно (без сканера)
    void getAmBanknote(int amBanknote20, int amBanknote50, int amBanknote100) {
        if (amBanknote20 >= 0 && amBanknote50 >= 0 && amBanknote100 >= 0) { //проверка минусовых значений
            this.amBanknote20 += amBanknote20;
            this.amBanknote50 += amBanknote50;
            this.amBanknote100 += amBanknote100;
        } else {
            System.out.println("Ошибка внесения!!!"); //Вывод ошибки
        }
    }

    //метод внесения купюр с запросом (со сканером)
    void getAmBanknote() {
        String output = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Внесение купюр. Введите количество купюр номиналом 20 :");
        int amBanknote20 = sc.hasNextInt() ? sc.nextInt() : -100;                     //проверка на Int
        if (amBanknote20 != -100) System.out.print("Введите количество купюр номиналом 50 :");
        int amBanknote50 = sc.hasNextInt() ? sc.nextInt() : -100;                     //проверка на Int
        if (amBanknote50 != -100) System.out.print("Введите количество купюр номиналом 100 :");
        int amBanknote100 = sc.hasNextInt() ? sc.nextInt() : -100;                    //проверка на Int
        if (amBanknote20 >= 0 && amBanknote50 >= 0 && amBanknote100 >= 0) {           //проверка минусовых значений
            this.amBanknote20 += amBanknote20;
            if (amBanknote20 > 0) output += " номиналом 20 - " + amBanknote20 + ", ";
            this.amBanknote50 += amBanknote50;
            if (amBanknote50 > 0) output += " номиналом 50 - " + amBanknote50 + ", ";
            this.amBanknote100 += amBanknote100;
            if (amBanknote100 > 0) output += " номиналом 100 - " + amBanknote100 + ". ";
            System.out.println("Внесено купюрами " + output + " " +
                    " Всего - " + (amBanknote20 * 20 + amBanknote50 * 50 + amBanknote100 * 100) + " кредитов."); //вывод результата
        } else {
            System.out.println("Ошибка внесения!!!");  //вывод ошибки
        }
    }

    //метод показывает сумму всех кредитов в банкомате
    int sumMoney() {
        return (amBanknote20 * 20 + amBanknote50 * 50 + amBanknote100 * 100);
    }

    //метод выдачи купюр принимает сумму Int, при удачном исполнении принимает значение true
    boolean getRevBanknote(int sum) {

        if (sum > 0 && sum <= sumMoney()) {
            int rev100 = 0;                  //блок временных переменных метода
            int rev50 = 0;
            int rev20 = 0;
            int t20 = amBanknote20;
            int t50 = amBanknote50;
            int t100 = amBanknote100;
            int tsum = sum;
            while ((t100 * 100) >= (tsum / 100) && ((tsum - 100) >= 0)) {  //поиск купюр номиналом 100
                if (tsum == 130) break;                                       //fix частный случай
                if ((tsum - 100 < 20) && (tsum % 50 != 0)) break;             //fix
                rev100++;
                t100--;
                tsum -= 100;
            }
            while ((t50 * 50) >= (tsum / 50) && ((tsum - 50) >= 0)) {    //поиск купюр номиналом 50
                if (tsum == 80) break;                                      //fix частный случай
                if ((tsum - 50 < 20) && (tsum % 50 != 0)) break;            //fix
                rev50++;
                t50--;
                tsum -= 50;
            }
            while ((t20 * 20) >= (tsum / 20) && ((tsum - 20) >= 0)) {     //поиск купюр номиналом 20
                rev20++;
                t20--;
                tsum -= 20;
            }
            if (tsum == 0) {         //проверка на остаток, если что-то в остатке метод не выполняется
                amBanknote20 = t20;
                amBanknote50 = t50;
                amBanknote100 = t100;
                System.out.print("Выдано всего купюр "); //вывод результата метода getRevBanknote
                if (rev20 > 0) {
                    System.out.print("номиналом 20 - " + rev20 + " , ");
                }
                if (rev50 > 0) {
                    System.out.print("номиналом 50 - " + rev50 + " , ");
                }
                if (rev100 > 0) {
                    System.out.print("номиналом 100 - " + rev100 + " , ");
                }
                System.out.println(" сумма " + sum + " кредитов.");
            } else {
                System.out.println("Нет сдачи"); //вывод нет необходимых купюр
                return false;
            }
            return true;
        } else {
            System.out.println("Ошибка !!!");   //вывод ошибки метода getRevBanknote
            return false;
        }
    }
}
