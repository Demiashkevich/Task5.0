package com.demiashkevich.xmlparser.parser;

import org.junit.Test;

public class ParserBuilderCheck {

    private static final String pathFileNotExist = "data/old.xml";

    @Test(expected = RuntimeException.class)
    public void saxBuilderCheck(){
        OldCardStAXBuilder saxBuilder = new OldCardStAXBuilder();
        saxBuilder.buildSetCards(pathFileNotExist);
    }

    @Test(expected = RuntimeException.class)
    public void domBuilderCheck(){
        OldCardDOMBuilder domBuilder = new OldCardDOMBuilder();
        domBuilder.buildSetCards(pathFileNotExist);
    }

    @Test(expected = RuntimeException.class)
    public void stAXBuilderCheck(){
        OldCardStAXBuilder stAXBuilder = new OldCardStAXBuilder();
        stAXBuilder.buildSetCards(pathFileNotExist);
    }





}
