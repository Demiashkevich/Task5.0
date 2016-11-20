package com.demiashkevich.xmlparser.runner;

import com.demiashkevich.xmlparser.parser.dom.OldCardDOMBuilder;
import com.demiashkevich.xmlparser.parser.sax.OldCardSAXBuilder;
import com.demiashkevich.xmlparser.parser.stax.OldCardStAXBuilder;

public class Main {
    public static void main(String[] args) {
        OldCardSAXBuilder saxBuilder = new OldCardSAXBuilder();
        saxBuilder.buildSetCards("old-cards.xml");
        System.out.println(saxBuilder.getCards());

        System.out.println("-------------------------------------------------------------------------------------------");

        OldCardDOMBuilder domBuilder = new OldCardDOMBuilder();
        domBuilder.buildSetCards("old-cards.xml");
        System.out.println(domBuilder.getCards());

        System.out.println("-------------------------------------------------------------------------------------------");

        OldCardStAXBuilder staxBuilder = new OldCardStAXBuilder();
        staxBuilder.buildSetCards("old-cards.xml");
        System.out.println(staxBuilder.getCards());
    }
}
