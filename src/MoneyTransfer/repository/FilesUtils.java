package MoneyTransfer.repository;

import MoneyTransfer.model.InitConst;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

//Класс работы с файлами
public class FilesUtils implements InitConst {

    //Метод поиска файлов по маске с передачей пути директории нахождения файлов
    public static HashMap<String, String> fileSearch(String path) {
        Logger.start("Начало поиска файлов по маске");
        HashMap<String, String> output = new HashMap<>();
        FileFilter fileFilter = file -> file.getName().endsWith(filesMask);//создание фильтра
        File file = new File(path);
        //Перебор массива файлов в директории соответствующих фильтру
        Arrays.stream(file.listFiles(fileFilter)).iterator().forEachRemaining(out -> {
            FileReader fos = null;
            try {
                fos = new FileReader(out);
            } catch (FileNotFoundException e) {
                Logger.start(RuntimeException.class.getName() + ": " + e);
                throw new RuntimeException(e);
            }
            StringBuilder input = new StringBuilder();
            int i;
            while (true) {
                try {
                    if (!((i = fos.read()) != -1)) break;
                } catch (IOException e) {
                    Logger.start(RuntimeException.class.getName() + ": " + e);
                    throw new RuntimeException(e);
                }
                input.append((char) i); //чтение файла
            }
            try {
                fos.close();
                Logger.start(out + " файл найден и прочитан");
            } catch (IOException e) {
                Logger.start(RuntimeException.class.getName() + ": " + e);
                throw new RuntimeException(e);
            }
            output.put(out.toString(), input.toString());
        });

        if (output == null || output.size() == 0) {
            System.out.println(" Файлов по фильтру не найдено!!!");
            Logger.start(" Файлов по фильтру не найдено!!!");
        }

        return output;
    }

    //Переопределённый метод поиска файлов с константой
    public static HashMap<String, String> fileSearch() {
        return fileSearch(inputPathAbs);
    }

    //Метод чтения файла отчёта пути константы
    public static String reportGet() {
        Logger.start("Начало чтения данных из файла отчета");
        String output;
        FileReader fos;

        try {
            fos = new FileReader(reportPathFile);
        } catch (FileNotFoundException e) {
            Logger.start(RuntimeException.class.getName() + ": " + e);
            throw new RuntimeException(e);
        }
        StringBuilder input = new StringBuilder();
        int i;
        while (true) {
            try {
                if (!((i = fos.read()) != -1)) break;
            } catch (IOException e) {
                Logger.start(RuntimeException.class.getName() + ": " + e);
                throw new RuntimeException(e);
            }
            input.append((char) i);
        }
        Logger.start(reportPathFile + " Файл найден и прочитан");
        try {
            fos.close();
        } catch (IOException e) {
            Logger.start(RuntimeException.class.getName() + ": " + e);
            throw new RuntimeException(e);
        }
        output = input.toString();
        Logger.start("Окончание чтения данных из файла отчета");
        return output;
    }

    //Метод перемещения файлов на вход идёт HashMap полученная после обработки классом Transfer - работает по ключам.
    public static void fileMove(HashMap<String, HashMap<String, List<String>>> listOfProcessedFiles) {
        if (listOfProcessedFiles == null || listOfProcessedFiles.size() == 0) {
            Logger.start(" Невозможно переместить файлы нет данных");
            return;
        }
        //Предполагается что данные полностью валидные поэтому сразу передаются в File
        listOfProcessedFiles.keySet().forEach((fileName) -> {
            File newfile = new File(fileName); //файл из HashMap
            File archfile = new File(archivePathAbs + "\\" + newfile.getName()); //путь к новому файлу
            File archive = new File(archivePathAbs); //путь к директории архива
            if (archive.mkdir()) {
                Logger.start(archivePathAbs + " директория создана");
            }
            if (!archfile.isFile()) {
                newfile.renameTo(archfile);
                Logger.start(fileName + " файл перемещен в " + archivePathAbs);
            } else { //если в архиве уже есть файл с таким названием к имени файла добавляетя дата
                archfile = new File(archivePathAbs + "\\" + LocalDateTime.now().format(localDT) + "_" +
                        newfile.getName());
                newfile.renameTo(archfile);
                Logger.start(fileName + " файл переименован в " + archfile.getName() + " и  перемещен в " +
                        archivePathAbs);
            }

        });
    }
}
