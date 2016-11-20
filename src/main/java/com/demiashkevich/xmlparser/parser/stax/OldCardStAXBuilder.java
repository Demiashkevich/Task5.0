package com.demiashkevich.xmlparser.parser.stax;

import com.demiashkevich.xmlparser.builder.OldCardBuilder;
import com.demiashkevich.xmlparser.constant.CardStructure;
import com.demiashkevich.xmlparser.constant.CardType;
import com.demiashkevich.xmlparser.creator.CardCreator;
import com.demiashkevich.xmlparser.entity.OldCard;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OldCardStAXBuilder {

    private static final Logger LOGGER = Logger.getLogger(OldCardStAXBuilder.class);

    private Set<OldCard> cards;
    private XMLInputFactory factory;
    private OldCardBuilder card;

    public OldCardStAXBuilder() {
        cards = new HashSet<>();
        factory = XMLInputFactory.newInstance();
    }

    public void buildSetCards(String pathFile){
        XMLStreamReader reader;
        String tagName;
        try (FileInputStream inputStream = new FileInputStream(new File(pathFile))) {
            reader = factory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int typeNext = reader.next();
                if (typeNext == XMLStreamConstants.START_ELEMENT) {
                    tagName = reader.getLocalName();
                    for(CardType typeRoot : CardType.values()){
                        if(typeRoot.getType().equalsIgnoreCase(tagName)){
                            card = CardCreator.getCard(typeRoot);
                            cards.add(buildOldCard(reader));
                        }
                    }
                }
            }
        } catch (XMLStreamException exception) {
            LOGGER.error(exception);
        } catch (IOException exception) {
            LOGGER.fatal(exception);
            throw new RuntimeException(exception);
        }
    }

    public OldCard buildOldCard(XMLStreamReader reader){
        List<String> attributes = new ArrayList<>();
        for(int i = 0; i < reader.getAttributeCount(); i++){
            attributes.add(reader.getAttributeValue(i));
        }
        card.buildAttribute(attributes);
        String tagName;
        try {
            while (reader.hasNext()) {
                int typeNext = reader.next();
                switch (typeNext) {
                    case XMLStreamConstants.START_ELEMENT:
                        tagName = reader.getLocalName();
                        CardStructure currentType = null;
                        for(CardStructure type : CardStructure.values()){
                            if(type.getText().equalsIgnoreCase(tagName)){
                                currentType = type;
                            }
                        }
                        if(currentType != null) {
                            switch (currentType) {
                                case CODE:
                                    card.buildCode(reader.getElementText());
                                    break;
                                case COUNTRY:
                                    card.buildCountry(reader.getElementText());
                                    break;
                                case YEAR:
                                    card.buildYear(Integer.parseInt(reader.getElementText()));
                                    break;
                                case DISPATCH:
                                    card.buildDispatch(Boolean.parseBoolean(reader.getElementText()));
                                    break;
                                case COST:
                                    card.buildCost(Double.parseDouble(reader.getElementText()));
                                    break;
                                case FIRST_NAME:
                                    card.buildAuthorFirstName(reader.getElementText());
                                    break;
                                case LAST_NAME:
                                    card.buildAuthorLastName(reader.getElementText());
                                    break;
                                case BIRTHDAY:
                                    card.buildBirthday(reader.getElementText());
                                    break;
                                case PICTURE_NAME:
                                    card.buildPictureName(reader.getElementText());
                                    break;
                                default: //Exception Enum
                            }
                        }
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tagName = reader.getLocalName();
                        for(CardType typeRoot : CardType.values()){
                            if(typeRoot.getType().equalsIgnoreCase(tagName)){
                               return card.getCard();
                            }
                        }
                        break;
                }

            }
        } catch (XMLStreamException exception) {
            LOGGER.error(exception);
        }
        return null; //call Exception Enum
    }

    public Set<OldCard> getCards() {
        return cards;
    }
}
