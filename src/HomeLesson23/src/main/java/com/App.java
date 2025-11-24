package com;

import com.model.ListOfAuthor;
import com.sax.SaXHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static com.dom.DomParser.parseDom;
import static com.sax.SaxParser.parseSax;


/**
 *Написать программу для парсинга xml документа. Необходимо распарсить xml документ и
 * содержимое тегов line записать в другой документ. Название файла для записи должно
 * состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt
 * Дополнительно реализовать следующий функционал: если с консоли введено значение 1
 * - распарсить документ с помощью SAX, если с консоли введено значение 2 - распарсить
 * документ с помощью DOM
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Введите 1 для парсинга с SAX, 2 для парсинга с DOM");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (choice == 1) {
            fileWriter((parseSax("file.xml")));
        } else if (choice == 2) {
           fileWriter((parseDom("file.xml")));
        } else {
            System.out.println("Некорректный ввод");
        }

    }

    static void fileWriter(ListOfAuthor list) {
        String fileName;

        for (int i = 0; i < list.getList().size(); i++) {
            for (int j = 0; j < list.getList().get(i).getTitlesList().size(); j++) {
                fileName = list.getList().get(i).getFirstName() + "_" +
                        list.getList().get(i).getLastName() + "_"
                        + list.getList().get(i).getTitlesList().get(j).getTitle() + ".txt";
                try {
                    FileWriter writer = new FileWriter(fileName);
                    writer.write(list.getList().get(i).getTitlesList().get(j).getContent());
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
