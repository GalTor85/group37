package MoneyTransfer.controller;

import MoneyTransfer.exception.DataReadException;
import MoneyTransfer.repository.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class InputDataHandler {

    //Класс обработки ошибок InputDataHandler
    public static void handleBadLine(String fileKey, String line,

                                     HashMap<String, Boolean> shouldAbort) {
        try {
            Logger.start(fileKey + " " + line + " - неправильное значение");
            throw new DataReadException(fileKey + " " + line + " - неправильное значение");
        } catch (DataReadException e) {
            if (line.trim().isEmpty()) {return;}  //игнорируем пустые строки
            System.out.print(e.getMessage() + " - игнорировать \n - yes, или любое другое значение - пропустить файл ? -->");
            try {
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                String response = console.readLine();
                if (response != null && "yes".equals(response)) {
                    System.out.println(e.getMessage() + " - проигнорирован");
                    Logger.start(e.getMessage() + " - проигнорирован");
                } else {
                    System.out.println("Начиная с ->" + e.getMessage() + " - не обработано");
                    Logger.start("Начиная с ->" + e.getMessage() + " - не обработано");
                    shouldAbort.replace(fileKey, true);
                }
            } catch (IOException ex) {
                Logger.start(RuntimeException.class.getName() + ": " + e);
                throw new RuntimeException(ex);
            }
        }
    }
}
