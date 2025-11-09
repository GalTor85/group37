package MoneyTransfer.repository;


import MoneyTransfer.model.InitConst;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static MoneyTransfer.controller.InputDataHandler.handleBadLine;


//Класс обработки данных
public class InputDataHandler implements InitConst {

    //Метод обработки данных после поиска текстовых файлов, поиск и предварительная обработка осуществляется в классе FilesUtils
    public static HashMap<String, HashMap<String, List<String>>> workWithFileData(HashMap<String, String> map, String pattern) {
        Logger.start("Начало обработки данных из найденных файлов");
        //Проверка на пустоту
        if (map == null || map.isEmpty()) {
            Logger.start(" Нет данных для обработки");
            HashMap<String, HashMap<String, List<String>>> mapOut = new HashMap<>();
            return mapOut;
        }
        HashMap<String, HashMap<String, List<String>>> mapOut = new HashMap<>();
        HashMap<String, List<String>> mapTemp = new HashMap<>();
        // Флаг для передачи прерывания обработки наружу
        final HashMap<String, Boolean> shouldAbort = new HashMap<>();
        map.forEach((k, v) -> {
            Logger.start(" Обработка данных из файла " + k);
            shouldAbort.put(k, false);
            String[] lines = v.split("\\n"); //разделяем по пробелу
            for (int i = 0; i < lines.length && !shouldAbort.get(k); i++) {
                String line = lines[i].strip();
                if (line.matches(pattern)) {  //проверка паттерна
                    String[] parts = line.split(" ");
                    if (parts.length == 2) { //в этом случае первоначальная загрузка данных вида (ddddd-ddddd +-d*.dd )
                        String key = parts[0]; //сборка ключа (номер счета)
                        String value = parts[1].strip(); //сборка значения (сумма открытия)
                        if (mapTemp.containsKey(key)) {  //проверка наличия ключа
                            mapTemp.get(key).add(value);
                        } else {
                            List<String> listTemps = new ArrayList<>();
                            mapTemp.put(key, listTemps); //для того чтобы избежать null
                            mapTemp.get(key).add(value);
                        }
                    } else if (parts.length == 3) { //случай переводов
                        String key = parts[0].strip() + "->" + parts[1].strip(); //сборка операции перевода
                        String value = parts[2];  //сборка значений (сумм перевода)
                        if (mapTemp.containsKey(key)) {  //проверка наличия ключа
                            mapTemp.get(key).add(value);
                        } else {
                            List<String> listTemps = new ArrayList<>();
                            mapTemp.put(key, listTemps);   //для избежания null
                            mapTemp.get(key).add(value);
                        }
                    } else {
                        // Неполная строка — обработаем как ошибку
                        handleBadLine(k, line, shouldAbort);
                    }
                } else {
                    handleBadLine(k, line, shouldAbort);
                }
            }
            HashMap<String, List<String>> mapTemps = new HashMap<>();
            mapTemps.putAll(mapTemp);
            mapOut.put(k, mapTemps);
            mapTemp.clear();
        });

        shouldAbort.forEach((k, v) -> {
            if (v == true && mapOut.containsKey(k)) {
                mapOut.remove(k);   //удаление данных если файл проигнорирован
            }
        });
        Logger.start("Обработка данных из найденных файлов завершена");
        return mapOut;
    }

    //Переопределенный метод обработки данных файла отчета
    public static HashMap<LocalDate, List<String>> workWithReportData(String dataReport) {
        return workWithReportData(dataReport, patternDate);
    }

    //Метод обработки файла отчёта
    public static HashMap<LocalDate, List<String>> workWithReportData(String dataReport, String patternDate) {
        //Проверка на пустоту
        Logger.start("Обработка данных файла отчета");
        if (dataReport == null || dataReport.isEmpty()) {
            Logger.start(" Нет данных для формирования отчёта");
            HashMap<LocalDate, List<String>> mapOut = new HashMap<>();
            return mapOut;
        }
        HashMap<LocalDate, List<String>> mapOut = new HashMap<>();
        String[] lines = dataReport.split("\\n");
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].strip();
            Pattern p = Pattern.compile(patternDate); //компиляция паттерна даты
            Matcher m = p.matcher(line);
            while (m.find()) { //поиск дат
                String datePart = m.group();
                LocalDate date = LocalDate.parse(datePart, repDateFormat);
                String value = line.replaceAll(patternDate, ""); //остаточные данные без даты
                if (mapOut.containsKey(date)) {
                    mapOut.get(date).add(value); //формирование HashMap отчета по датам
                } else {
                    List<String> listTemps = new ArrayList<>(); //!null
                    mapOut.put(date, listTemps);
                    mapOut.get(date).add(value); //формирование HashMap отчета по датам
                }
            }
        }
        Logger.start("Обработка данных отчета завершена");
        return mapOut;
    }

    //Метод проверка валидности даты
    public static boolean isValidDate(String input, DateTimeFormatter formatter) {
        try {
            // Можно парсить как LocalDate или LocalDateTime в зависимости от задачи
            LocalDate date = LocalDate.parse(input, formatter);
            return date != null;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

}


