package com.sax;

import com.model.ListOfAuthor;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxParser {
    public static ListOfAuthor parseSax(String pathname) { SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            SaXHandler handler = new SaXHandler();
            parser.parse(new File(pathname), handler);
            return handler.getListOfAuthor();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return null;
}}
