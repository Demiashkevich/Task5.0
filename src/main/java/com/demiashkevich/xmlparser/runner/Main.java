package com.demiashkevich.xmlparser.runner;

import com.demiashkevich.xmlparser.entity.OldCard;
import com.demiashkevich.xmlparser.parser.OldCardDOMBuilder;
import com.demiashkevich.xmlparser.parser.OldCardSAXBuilder;
import com.demiashkevich.xmlparser.parser.OldCardStAXBuilder;
import com.demiashkevich.xmlparser.report.ReportXML;

import java.util.Set;

public class Main {

    private static final String pathXML = "data/old-cards.xml";

    public static void main(String[] args) {
        OldCardSAXBuilder saxBuilder = new OldCardSAXBuilder();
        saxBuilder.buildSetCards(pathXML);
        Set<OldCard> cardsSAX = saxBuilder.getCards();

        OldCardDOMBuilder domBuilder = new OldCardDOMBuilder();
        domBuilder.buildSetCards(pathXML);
        Set<OldCard> cardsDOM = domBuilder.getCards();

        OldCardStAXBuilder staxBuilder = new OldCardStAXBuilder();
        staxBuilder.buildSetCards(pathXML);
        Set<OldCard> cardsStAX = staxBuilder.getCards();

        ReportXML reportXML = new ReportXML();
        reportXML.report(cardsSAX);
        reportXML.report(cardsDOM);
        reportXML.report(cardsStAX);

    }
}
