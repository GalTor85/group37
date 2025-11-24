package com.dom;

import com.model.Author;
import com.model.ListOfAuthor;
import com.model.Titles;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomParser {
   public static ListOfAuthor parseDom(String pathname) {
       final Integer SINGE_ELEMENT = 1;
       final Integer ZERO_INDEX = 0;

       //Создаем экземпляр фабрики парсера
       DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

       //Парсим XML
       Document doc;

       {
           try {
               doc = factory.newDocumentBuilder().parse(new File(pathname));
               doc.getDocumentElement().normalize();

           } catch (SAXException e) {
               throw new RuntimeException(e);
           } catch (IOException e) {
               throw new RuntimeException(e);
           } catch (ParserConfigurationException e) {
               throw new RuntimeException(e);
           }
       }

       //Создаем модели
       ListOfAuthor list = new ListOfAuthor();
       List<Author> authors = new ArrayList<Author>();
       Author author = new Author();
       Titles titles = null;
       List<Titles> titlesList=new ArrayList<Titles>();

       //Вычитываем Информацию
       NodeList listOfAuthor = doc.getElementsByTagName("author");
        for (int i = 0; i < listOfAuthor.getLength(); i++) {
           //вычитываем lastName и firstName
           Element authorElement = (Element) listOfAuthor.item(i);
           author = new Author();
           titlesList = new ArrayList<Titles>();
           author.setFirstName(authorElement.getElementsByTagName("firstName").item(ZERO_INDEX).getTextContent());
           author.setLastName(authorElement.getElementsByTagName("lastName").item(ZERO_INDEX).getTextContent());

               //вычитываем title
            NodeList titleList = doc.getElementsByTagName("title");
            for (int j = 0; j < titleList.getLength(); j++) {
                Element titleElement = (Element) titleList.item(j);
                titles = new Titles();
                titles.setTitle(titleElement.getTextContent());
                titlesList.add(titles);

                //вычитываем lines
                NodeList linesList = doc.getElementsByTagName("lines");
                for (int k = 0; k < linesList.getLength(); k++) {
                    Element linesElement = (Element) linesList.item(k);
                    titlesList.get(j).setContent(linesElement.getTextContent());
                }
                author.setTitlesList(titlesList);
            }
           authors.add(author);
       }
       list.setList(authors);
    return list;}
}