package com.demiashkevich.xmlparser.parser.sax;

import com.demiashkevich.xmlparser.builder.OldCardBuilder;
import com.demiashkevich.xmlparser.constant.CardStructure;
import com.demiashkevich.xmlparser.constant.CardType;
import com.demiashkevich.xmlparser.creator.CardCreator;
import com.demiashkevich.xmlparser.entity.OldCard;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OldCardHandler extends DefaultHandler{

    private OldCardBuilder card;
    private CardStructure currentCardType;
    private Set<OldCard> cards;

    public OldCardHandler() {
        cards = new HashSet<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        CardType typeCard = cardElement(localName);
        if(typeCard != null) {
            card = CardCreator.getCard(typeCard);
            List<String> listAttributes = new ArrayList<>();
            for (int i = 0; i < attributes.getLength(); i++) {
                listAttributes.add(attributes.getValue(i));
            }
            card.buildAttribute(listAttributes);
        }else {
            for(CardStructure structure : CardStructure.values()){
                if(structure.getText().equalsIgnoreCase(localName)){
                    currentCardType = structure;
                    break;
                }
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        for(CardType type : CardType.values()){
            if(type.getType().equalsIgnoreCase(localName)){
                cards.add(card.getCard());
                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String info = new String(ch, start, length).trim();
        if (currentCardType != null) {
            switch (currentCardType) {
                case CODE:
                    card.buildCode(info);
                    break;
                case COUNTRY:
                    card.buildCountry(info);
                    break;
                case YEAR:
                    card.buildYear(Integer.parseInt(info));
                    break;
                case DISPATCH:
                    card.buildDispatch(Boolean.parseBoolean(info));
                    break;
                case COST:
                    card.buildCost(Double.parseDouble(info));
                    break;
                case FIRST_NAME:
                    card.buildAuthorFirstName(info);
                    break;
                case LAST_NAME:
                    card.buildAuthorLastName(info);
                    break;
                case BIRTHDAY:
                    card.buildBirthday(info);
                    break;
                case PICTURE_NAME:
                    card.buildPictureName(info);
                default: //Exception Enum
            }
        }
        currentCardType = null;
    }

    private CardType cardElement(String localName){
        for(CardType type : CardType.values()) {
            if (type.getType().equalsIgnoreCase(localName)) {
                return type;
            }
        }
        return null;
    }

    public Set<OldCard> getCards() {
        return cards;
    }
}
