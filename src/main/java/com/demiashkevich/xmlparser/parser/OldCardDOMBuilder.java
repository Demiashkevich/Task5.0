package com.demiashkevich.xmlparser.parser;

import com.demiashkevich.xmlparser.builder.OldCardBuilder;
import com.demiashkevich.xmlparser.constant.CardType;
import com.demiashkevich.xmlparser.creator.CardCreator;
import com.demiashkevich.xmlparser.entity.OldCard;
import com.demiashkevich.xmlparser.exception.CardBuilderNotFoundException;
import org.apache.log4j.Logger;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OldCardDOMBuilder extends AbstractOldCardBuilder {

    private static final Logger LOGGER = Logger.getLogger(OldCardDOMBuilder.class);

    private DocumentBuilder documentBuilder;
    private OldCardBuilder card;

    public OldCardDOMBuilder() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException exception) {
            LOGGER.error(exception);
        }
    }

    public void buildSetCards(String pathFile){
        try {
            Document document = documentBuilder.parse(pathFile);
            Element rootElement = document.getDocumentElement();

            NodeList nodeCards = rootElement.getChildNodes();
            for(int i = 0; i < nodeCards.getLength(); i++){
                Node node = nodeCards.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element)node;
                    cards.add(buildOldCard(element));
                }
            }
        } catch (SAXException exception) {
            LOGGER.error(exception);
        } catch (IOException exception) {
            LOGGER.fatal(exception);
            throw new RuntimeException(exception);
        }
    }

    private OldCard buildOldCard(Element element){
        for(CardType type : CardType.values()){
            if(type.getType().equalsIgnoreCase(element.getTagName())){
                try {
                    card = CardCreator.getCard(type);
                } catch (CardBuilderNotFoundException exception) {
                    LOGGER.error(exception);
                }
            }
        }
        List<String> attribute = new ArrayList<>();
        NamedNodeMap mapAttributes = element.getAttributes();
        for(int i = 0; i < mapAttributes.getLength(); i++){
            attribute.add(mapAttributes.item(i).getNodeValue());
        }
        card.buildAttribute(attribute);
        card.buildCode(getTextContent(element, "code"));
        card.buildCountry(getTextContent(element, "country"));
        card.buildYear(Integer.parseInt(getTextContent(element, "year")));
        card.buildDispatch(Boolean.parseBoolean(getTextContent(element, "dispatch")));
        card.buildCost(Double.parseDouble(getTextContent(element, "cost")));
        card.buildAuthorFirstName(getTextContent(element, "first-name"));
        card.buildAuthorLastName(getTextContent(element, "last-name"));
        card.buildBirthday(getTextContent(element, "birthday"));
        card.buildPictureName(getTextContent(element, "picture-name"));

        return card.getCard();
    }

    private String getTextContent(Element element, String tag){
        tag = tag.toLowerCase();
        NodeList nodeList = element.getElementsByTagName(tag);
        Node node = nodeList.item(0);
        if(node != null){
            return node.getTextContent();
        }
        return null;
    }

    public Set<OldCard> getCards() {
        return cards;
    }
}
