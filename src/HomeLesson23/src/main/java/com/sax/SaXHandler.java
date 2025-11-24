package com.sax;

import com.model.Author;
import com.model.ListOfAuthor;
import com.model.Titles;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SaXHandler extends DefaultHandler {
    private ListOfAuthor listOfAuthor;
    private List<Author> resultlist;
    private Author author;
    private Titles titles;
    private List<Titles> titlesList;
    private boolean isLastName;
    private boolean isFirstName;
    private boolean isTitle;
    private boolean isContent;


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("sonnet")) {
            resultlist = new ArrayList<>();
            listOfAuthor = new ListOfAuthor();
        }
        if (qName.equals("author")) {
            author = new Author();
            titlesList = new ArrayList<>();
        }
        if (qName.equals("lastName")) {
            isLastName = true;
        }
        if (qName.equals("firstName")) {
            isFirstName = true;
        }
        if (qName.equals("title")) {
            isTitle = true;
            titles = new Titles();
        }
        if (qName.equals("line")) {
            isContent = true;
        }
    }

    public ListOfAuthor getListOfAuthor() {
        return listOfAuthor;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("lines")) {
            titlesList.add(titles);
            author.setTitlesList(titlesList);
            if (listOfAuthor.getList() != null) {
                listOfAuthor.getList().add(author);
            } else {
                resultlist.add(author);
                listOfAuthor.setList(resultlist);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (isLastName) {
            author.setLastName(String.valueOf(ch, start, length));
            isLastName = false;
        }
        if (isFirstName) {
            author.setFirstName(String.valueOf(ch, start, length));
            isFirstName = false;
        }
        if (isTitle) {
            titles.setTitle(String.valueOf(ch, start, length));
            isTitle = false;
        }
        if (isContent) {
            if (titles.getContent() != null) {
                titles.setContent(titles.getContent() + "\n" + String.valueOf(ch, start, length));
            } else {
                titles.setContent(String.valueOf(ch, start, length));
            }
            isContent = false;
        }
    }
}