package MoneyTransfer.repository;

import MoneyTransfer.model.InitConst;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

//Класс формирования отчёта о переводах
public class Report implements InitConst {
    //Метод записи отчетов в файл
    static public void start(String fileName, String operation, String sum, String result) {
        Logger.start("Формирование отчёта о переводах запущено");
        File logFile = new File(reportPathFile); //Создание связи с файлом отчёта
        if (logFile.exists()) {  //проверяем есть ли файл отчёта
            try {  //Запись в файл
                FileWriter writer = new FileWriter(reportPathFile, true);
                String substitution = "перевод с ";
                // Частный случай если зачисление подменяем подстроку для формирования отчёта
                if (operation.matches(patternMoneyAccountNumber)) {
                    substitution = "зачисление на ";
                }
                writer.write(LocalDateTime.now().format(logDTFormat) +
                        " | " + fileName + " | " + substitution +
                        operation.replace("->", " на ") + " " +
                        sum + " | " + result + "\n");
                writer.close(); // закрываем файл
            } catch (IOException e) {
                Logger.start(e.getMessage());
                Logger.start(RuntimeException.class.getName() + ": " + e);
                throw new RuntimeException(e);
            }
        } else { //если нет создаем директорию если нет и файл отчёта
            try {
                File logDir = new File(reportPath);
                if (!logDir.mkdir()) {
                    Logger.start("Создана директория " + reportPath);
                    logDir.mkdir(); //создание директории
                }
                Logger.start("Создан файл " + reportPathFile);
                logFile.createNewFile(); //создание файла
                //Запись в файл
                FileWriter writer = new FileWriter(reportPathFile, true);
                String substitution = "перевод с ";
                if (operation.matches(patternMoneyAccountNumber)) {
                    substitution = " зачисление на ";
                }
                writer.write(LocalDateTime.now().format(logDTFormat) + "->" +
                        reportPathFile + " создан\n");
                writer.write(LocalDateTime.now().format(logDTFormat) +
                        " | " + fileName + " | " + substitution +
                        operation.replace("->", " на ") + " " +
                        sum + " | " + result + "\n");
                writer.close();
            } catch (IOException e) {
                Logger.start(RuntimeException.class.getName() + ": " + e);
                throw new RuntimeException(e);
            }
        }
    }

    //Метод передаёт в строку выборку из файла отчетов по определённой дате
    public static String reportGet(LocalDate date) {
        Logger.start("Начало формирования отчёта на дату " + date.format(repDateFormat));
        String report = reportGet(); //Чтение отчета из файла метод в FileUtils
        HashMap<LocalDate, List<String>> map = InputDataHandler.workWithReportData(report);//Преобразование данных
        StringBuilder result = new StringBuilder();
        if (map.containsKey(date)) { //выборка по ключу дата - List сохраняет порядок вывода
            map.get(date).forEach(s -> {
                result.append(date.format(repDateFormat)).append(s).append("\n"); //передаем в строку
            });
        } else {
            Logger.start("Нет данных на дату-->" + date.format(repDateFormat));
            return "Нет данных на дату-->" + date.format(repDateFormat);//если нет данных на дату
        }
        Logger.start("Завершено формирование отчета на дату " + date.format(repDateFormat));
        return result.toString();
    }

    //Переопределённый метод передаёт в строку выборку из файла отчетов с даты по дату
    public static String reportGet(LocalDate dateStart, LocalDate dateEnd) {
        Logger.start("Начало формирования отчёта с даты " + dateStart.format(repDateFormat) +
                " на дату " + dateEnd.format(repDateFormat));
        if (dateStart.isAfter(dateEnd)) {
            System.out.println("Неправильный порядок дат автоматически изменён");
            LocalDate temp = dateStart;
            dateStart = dateEnd;
            dateEnd = temp;
        }
        String report = reportGet(); //чтение из файла
        HashMap<LocalDate, List<String>> map = InputDataHandler.workWithReportData(report);//обработка данных
        StringBuilder result = new StringBuilder();
        //  if (map.containsKey(dateStart) && map.containsKey(dateEnd)) { //передача данных в строку StringBuilder
        for (LocalDate date = dateStart; !date.isAfter(dateEnd); date = date.plusDays(1)) {
            LocalDate finalDate = date;
            if (map.containsKey(date)) {
                map.get(date).forEach(s -> {
                    result.append(finalDate.format(repDateFormat)).append(s).append("\n");
                });
            }
        }
        // }
//        else {
//            Logger.start("Даты c " + dateStart.format(repDateFormat) +
//                    " по " + dateEnd.format(repDateFormat) + " вне диапазона");
//            return "Даты c " + dateStart.format(repDateFormat) +
//                    " по " + dateEnd.format(repDateFormat) + " вне диапазона";
//        }
        Logger.start("Закончено формирование отчёта с даты " + dateStart.format(repDateFormat) +
                " на дату " + dateEnd.format(repDateFormat));
        if (result.length() == 0) {
            System.out.println("Записи в диапазоне " + dateStart.format(repDateFormat)
                    + "--" + dateEnd.format(repDateFormat) + " не найдены!!!");
        }
        return result.toString();
    }

    public static String reportGet() {
        return FilesUtils.reportGet();
    }
}
