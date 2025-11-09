package MoneyTransfer.repository;

import MoneyTransfer.model.TableUtils;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

//Класс работы с переводами
public class Transfer {



// Метод создания(открытия) счетов из HashMap (имя файла->счет->суммы) -
// в программе загружается только одна сумма!!!
// если в начальном файле будет несколько сумм привязанных к одному счету
// открыт счет будет с первой обработанной суммой
// boolean для запуска или не запуска метода переноса файлов в архив
    public static boolean inNewAccountMap(HashMap<String, HashMap<String, List<String>>> listOfAccountsCash) {
        //Проверка пустоты
        Logger.start("Запуск создания счетов из файла.");
        if (listOfAccountsCash == null || listOfAccountsCash.isEmpty()) {
            Logger.start(" Данные счетов не обнаружены ");
            return false;
        }
        //Переборка входящей HashMap
        listOfAccountsCash.forEach((file, v) -> {
            v.forEach((operation, transfers) -> {
                try {
                    String cash = transfers.getFirst();
                    long debit = Long.parseLong(operation.trim().
                            replace("-", ""));
                    BigDecimal sum = new BigDecimal(cash);
                    TableUtils exchangeDB = new TableUtils();
                    //Проверка наличия счета в БД
                    if (!exchangeDB.isAccount(debit)) {
                        if (sum.compareTo(BigDecimal.ZERO) <= 0) {
                            Report.start(file, operation, cash, " ошибка во " +
                                    "время обработки, неверная сумма зачисления");
                        } else {
                            //Создание счета
                            exchangeDB.addValue(debit, sum);
                            Report.start(file, operation, cash, " успешно обработан открыт новый счет " +
                                    operation.trim());
                        }
                    } else {
                        Report.start(file, operation, cash, " не обработано счет " +
                                operation + " обнаружен в базе");
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    Logger.start(e.getMessage());
                    throw new RuntimeException(e);
                }

            });
        });
        Logger.start("Операция создания счетов из файла завершена.");
        return true;
    }

    //Метод обработки переводов со счета на счет
    //Входные данные HasMap (имя файла->номера счетов(операция)->лист сумм
    //Все операции будут обработаны по всем суммам переводов
    // boolean для запуска или не запуска метода переноса файлов в архив
    public static boolean fromAccountToAccount(HashMap<String, HashMap<String, List<String>>> listOfAccountsCash) {
        Logger.start("Запуск операции перевода.");
        //Проверка на пустоту
        if (listOfAccountsCash == null || listOfAccountsCash.isEmpty()) {
            System.out.println(" Операции для переводов не обнаружены");
            Logger.start(" Операции для переводов не обнаружены");
            return false;  //
        }
        //Переборка входящей HashMap
        listOfAccountsCash.forEach((file, v) -> {
            v.forEach((operation, transfers) -> {
                for (String cash : transfers) {
                    try {
                        long credit = Long.parseLong(operation.trim().split("->")[0].
                                replace("-", ""));
                        long debit = Long.parseLong(operation.trim().split("->")[1].replace("-", ""));
                        BigDecimal sum = new BigDecimal(cash);
                        TableUtils exchangeDB = new TableUtils();
                        //Проверка наличия счета в БД
                        if (exchangeDB.isAccount(credit)) {
                            BigDecimal creditValue = new BigDecimal(exchangeDB.readValue(credit).toString());
                            BigDecimal debitValue = new BigDecimal(exchangeDB.readValue(debit).toString());
                            //Проверка суммы перевода (меньше нуля)
                            if (sum.compareTo(BigDecimal.ZERO) <= 0) {
                                Report.start(file, operation, cash, " ошибка во " +
                                        "время обработки, неверная сумма перевода");
                                //Проверка хватит ли денег на кредитном счете
                            } else if (creditValue.subtract(sum).compareTo(BigDecimal.ZERO) >= 0) {
                                creditValue = creditValue.subtract(sum);
                                debitValue = debitValue.add(sum);
                                exchangeDB.updateCashByAccountNum(credit, creditValue);
                                //Проверка есть ли дебетовый счёт
                                if (exchangeDB.isAccount(debit)) {
                                    //обновление дебетового счёта
                                    exchangeDB.updateCashByAccountNum(debit, debitValue);
                                    Report.start(file, operation, cash, " успешно обработан");
                                } else {
                                    //создание дебетового счёта
                                    exchangeDB.addValue(debit, sum);
                                    Report.start(file, operation, cash, " успешно обработан открыт новый счет " +
                                            operation.trim().split("->")[1]);
                                }
                            } else {
                                //нет денег на кредитном счёте
                                Report.start(file, operation, cash, " не обработан на счету " +
                                        operation.trim().split("->")[0] + " недостаточно средств");
                            }
                        } else {
                            //нет кредитного счёта
                            Report.start(file, operation, cash, " не обработан счет " +
                                    operation.trim().split("->")[0] + " не обнаружен в базе");
                        }
                    } catch (SQLException | ClassNotFoundException e) {
                         Logger.start(RuntimeException.class.getName() + ": " + e);
                        throw new RuntimeException(e);
                    }
                }
            });
        });
        Logger.start("Операции перевода завершены.");
        return true;
    }
}