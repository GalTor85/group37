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


/**
 *Написать программу для парсинга xml документа. Необходимо распарсить xml документ и
 * содержимое тегов line записать в другой документ. Название файла для записи должно
 * состоять из значений тегов и имеет вид: <firstName>_<lastName>_<title>.txt
 */
public class App {
    public static void main(String[] args) {

        fileWriter(parseSax("file.xml"));

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

    static ListOfAuthor parseSax(String pathname) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            SaXHandler handler = new SaXHandler();
            parser.parse(new File(pathname), handler);
            return handler.getListOfAuthor();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
