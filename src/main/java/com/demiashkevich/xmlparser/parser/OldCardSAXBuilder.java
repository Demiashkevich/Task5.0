package com.demiashkevich.xmlparser.parser;

import com.demiashkevich.xmlparser.entity.OldCard;
import handler.OldCardHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class OldCardSAXBuilder extends AbstractOldCardBuilder {

    private static final Logger LOGGER =  Logger.getLogger(OldCardSAXBuilder.class);

    private OldCardHandler cardHandler;
    private XMLReader xmlReader;

    public OldCardSAXBuilder() {
        cards = new HashSet<>();
        cardHandler = new OldCardHandler();
        try {
            xmlReader = XMLReaderFactory.createXMLReader();
            xmlReader.setContentHandler(cardHandler);
        } catch (SAXException exception) {
            LOGGER.error(exception);
        }
    }

    public void buildSetCards(String pathFile){
        try {
            xmlReader.parse(pathFile);
        } catch (IOException exception) {
            LOGGER.fatal(exception);
            throw new RuntimeException(exception);
        } catch (SAXException exception) {
            LOGGER.error(exception);
        }
        cards = cardHandler.getCards();
    }

    public Set<OldCard> getCards() {
        return cards;
    }
}
