package com.demiashkevich.xmlparser.creator;

import com.demiashkevich.xmlparser.builder.GreetingOldCardBuilder;
import com.demiashkevich.xmlparser.builder.OldCardBuilder;
import com.demiashkevich.xmlparser.builder.PictureOldCardBuilder;
import com.demiashkevich.xmlparser.constant.CardType;

public class CardCreator {

    public static OldCardBuilder getCard(CardType type){
        OldCardBuilder card = null;
        switch (type){
            case GREETING_CARD: card = new GreetingOldCardBuilder();
                break;
            case PICTURE_CARD: card = new PictureOldCardBuilder();
                break;
            default: //Exception Enum
        }
        return card;
    }

}
