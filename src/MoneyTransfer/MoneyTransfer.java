/**
 * Описание задания
 * Создать программу для выполнения денежного перевода с одного счета на другой.
 * Предварительно в программе должен находится файл с номерами счетов и суммами
 * на них. При запуске программа должна ожидать ввода информации из консоли.
 * При выборе функции парсинга программа должна парсить все подходящие файлы из
 * каталога ‘input’ и перенести распаршеные файлы в другой каталог ‘archive’. В
 * результате парсинга файлов программа должна сформировать/обновить файл-отчет и
 * обновить информацию в файле с номерами счетов и суммами до актуальных.
 * Детали технической реализации
 * При запуске программа ожидает ввод информации:
 * в консоль введено 1 - вызов операции парсинга файлов перевода из input,
 * в консоль введено 2 - вызов операции вывода списка всех переводов из
 * файла-отчета.
 * Программа должна обрабатывать файлы формата txt.
 * Если в каталоге есть файлы другого формата, то программа должна их пропускать и не
 * обрабатывать. Предусмотреть различные кейсы и реализовать проверки.
 * Например, в каталоге нет ни одного подходящего файла, отрицательная сумма
 * перевода, невалидные номер счетов и другие. Предусмотреть другие возможные
 * случаи возникновения и обработки ошибок и исключений. Предусмотреть сохранение
 * Java классов по “слоям”. Слоем будем считать просто каталог/package в исходном
 * коде проекта. Например, model слой - каталог, в котором будут находится классы для
 * модели данных (класс для счета и другие); exception слой - каталог, в котором будут
 * находиться классы для работы с исключениями; Название каталогов(слоев) и их
 * количество - на усмотрение студента.
 */
package MoneyTransfer;

import MoneyTransfer.model.TableUtils;
import MoneyTransfer.repository.FilesUtils;
import MoneyTransfer.repository.InputDataHandler;

import MoneyTransfer.repository.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static MoneyTransfer.model.InitConst.*;

public class MoneyTransfer {


    public static void main(String[] args) {
        try {

            System.out.print("Введите 1 для поиска файлов для перевода, 2 для вывода информации по переводам, или 3 другие действия-->");

            Scanner sc = new Scanner(System.in);
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                switch (line) {
                    case keyOne -> {
                        HashMap<String, String> out;
                        HashMap<String, HashMap<String, List<String>>> openAccounts;
                        //Поиск файлов
                        out = FilesUtils.fileSearch();
                        //Обработка данных
                        openAccounts = InputDataHandler.workWithFileData(out, patternTransferOperation);
                        // System.out.println(openAccounts);
                        //Инициализация базы данных
                        TableUtils exchangeDB = new TableUtils();
                        //Операция трансферта
                        if (Transfer.fromAccountToAccount(openAccounts))  //чтобы не переместить файлы при неудаче
                        {   //Перемещение обработанных файлов в архив
                            FilesUtils.fileMove(openAccounts);
                        }
                        sc.close();
                        exchangeDB.close();
                    }
                    case keyTwo -> {
                        System.out.print("Введите 1 для вывода всего файла отчета, 2  на конкретную дату, 3 от определенной до заданной даты-->");
                        if (sc.hasNextLine()) {
                            String out;
                            String answer = sc.nextLine();
                            switch (answer) {
                                case keyOne -> {
                                    out = Report.reportGet();
                                    System.out.println(out);
                                    sc.close();
                                }
                                case keyTwo -> {
                                    System.out.print("Введите дату в формате: " + LocalDate.now().format(repDateFormat) + "-->");
                                    if (sc.hasNextLine()) {
                                        String answerTwo = sc.nextLine();
                                        if (InputDataHandler.isValidDate(answerTwo, repDateFormat)) {
                                            out = Report.reportGet(LocalDate.parse(answerTwo, repDateFormat));
                                            System.out.println(out);
                                            sc.close();
                                        } else {
                                            System.out.println("Введена неверная дата!!!");
                                        }
                                    }
                                }
                                case keyThree -> {
                                    System.out.print("Введите начальную дату в формате: " + LocalDate.now().format(repDateFormat) + "-->");
                                    if (sc.hasNextLine()) {
                                        answer = sc.nextLine();
                                        if (InputDataHandler.isValidDate(answer, repDateFormat)) {
                                            LocalDate dateStart = LocalDate.parse(answer, repDateFormat);
                                            System.out.print("Введите конечную дату в формате: " + LocalDate.now().format(repDateFormat) + "-->");
                                            if (sc.hasNextLine()) {
                                                answer = sc.nextLine();
                                                if (InputDataHandler.isValidDate(answer, repDateFormat)) {
                                                    LocalDate dateEnd = LocalDate.parse(answer, repDateFormat);
                                                    out = Report.reportGet(dateStart, dateEnd);
                                                    System.out.println(out);
                                                    sc.close();
                                                } else {
                                                    System.out.println("Введена неверная дата!!!");
                                                }
                                            }
                                        } else {
                                            System.out.println("Введена неверная дата!!!");
                                        }
                                    }
                                }
                                default -> {
                                    System.out.println("Неверный ввод!!!");
                                }
                            }
                        }

                    }
                    case keyThree -> {
                        System.out.print("Введите 1 для поиска возможно случайно сохраненной базы данных -->");
                        if (sc.hasNextLine()) {
                            if (keyOne.equals(sc.nextLine())) {
                                HashMap<String, String> out;
                                HashMap<String, HashMap<String, List<String>>> openAccounts;
                                //Поиск файлов
                                out = FilesUtils.fileSearch(inputPathFirstLoadTable);
                                //Обработка данных
                                openAccounts = InputDataHandler.workWithFileData(out, patternOpenAnAccount);
                                //Инициализация базы данных
                                TableUtils exchangeDB = new TableUtils();
                                //Создание таблиц
                                exchangeDB.createTable();
                                //Операция трансферта
                                if (Transfer.inNewAccountMap(openAccounts)) { //проверка успешности
                                    //Перемещение обработанных файлов в архив
                                    FilesUtils.fileMove(openAccounts);
                                }
                                sc.close();
                                exchangeDB.close();


                            } else System.out.println("Неверный ввод!!!");
                        }

                    }
                    default -> {
                        System.out.println("Неверный ввод!!!");
                    }
                }
            }
        } catch (Exception e) {
            Logger.start(RuntimeException.class.getName() + ": " + e);
            System.out.println(e.getMessage());
        }


    }
}
