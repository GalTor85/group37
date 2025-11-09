package MoneyTransfer.repository;

import MoneyTransfer.model.InitConst;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

//Класс логирования
public class Logger implements InitConst {
    static public void start(String str) {
        File logFile = new File(logPathFile); //передача имени файла в объект File
        if (logFile.exists()) { //если файл существует
            try { //логирование - запись в файл
                FileWriter writer = new FileWriter(logPathFile, true);
                writer.write(LocalDateTime.now().format(logDTFormat) + "->" + str + "\n");
                writer.close();
            } catch (IOException e) {
                start(RuntimeException.class.getName() + ": " + e);
                throw new RuntimeException(e);
            }
        } else { //если файл не существует
            try {
                File logDir = new File(logPath);
                if (!logDir.mkdir()) { //Проверка существования директории
                    logDir.mkdir(); //создаем директорию если не существует
                }
                logFile.createNewFile(); //создаем файл потом производим запись
                FileWriter writer = new FileWriter(logPathFile, true);
                writer.write(LocalDateTime.now().format(logDTFormat) + "->" + logPathFile + " created\n");
                writer.write(LocalDateTime.now().format(logDTFormat) + "->" + str + "\n");
                writer.close(); //закрываем writer
            } catch (IOException e) {
                start(RuntimeException.class.getName() + ": " + e);
                throw new RuntimeException(e);
            }
        }
    }
}
