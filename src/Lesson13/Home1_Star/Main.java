package Lesson13.Home1_Star;

public class Main {
    /**
     * Задача 1:
     * Создать класс, в котором будет статический метод. Этот метод принимает на вход три
     * параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
     * login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
     * соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
     * password должна быть меньше 20 символов, не должен содержать пробелом и должен
     * содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
     * Если password не соответствует этим требованиям, необходимо выбросить
     * WrongPasswordException. WrongPasswordException и WrongLoginException -
     * пользовательские классы исключения с двумя конструкторами – один по умолчанию,
     * второй принимает сообщение исключения и передает его в конструктор класса
     * Exception. Метод возвращает true, если значения верны.
     * --------------------------------------------------------------------
     * Задача *:
     * Написать try/catch/finally, в котором finally вызван не будет.
     *      *
     */
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException {
        String login="sd";
        String password="dfsddf1";
        String confirmPassword="dfsddf1";
        System.out.println(PasswordChek.engine(login, password, confirmPassword));
                try {
                   login="sd";
                    password="dfsddf1";
                    confirmPassword="dfsddf";
                    System.out.println(PasswordChek.engine(login, password, confirmPassword));
                    System.exit(0);  //ПРЕРЫВАНИЕ!!!
                } catch (WrongLoginException|WrongPasswordException e) {
                    System.out.println(e.getMessage());
                    System.exit(1); //В ЛЮБОМ СЛУЧАЕ прерывание!!!
                }
                finally {
                    System.out.println("Это не будет исполнено");
                }
    }
}