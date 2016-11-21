package com.demiashkevich.xmlparser.creator;

import com.demiashkevich.xmlparser.builder.GreetingOldCardBuilder;
import com.demiashkevich.xmlparser.builder.OldCardBuilder;
import com.demiashkevich.xmlparser.builder.PictureOldCardBuilder;
import com.demiashkevich.xmlparser.constant.CardType;
import com.demiashkevich.xmlparser.exception.CardBuilderNotFoundException;

public class CardCreator {

    public static OldCardBuilder getCard(CardType type) throws CardBuilderNotFoundException {
        OldCardBuilder card;
        switch (type){
            case GREETING_CARD: card = new GreetingOldCardBuilder();
                break;
            case PICTURE_CARD: card = new PictureOldCardBuilder();
                break;
            default: throw new CardBuilderNotFoundException("No builder card " +
                    type.getDeclaringClass() + "." + type.name());
        }
        return card;
    }

}
