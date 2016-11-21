package com.demiashkevich.xmlparser.parser;

import com.demiashkevich.xmlparser.entity.OldCard;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractOldCardBuilder {

    protected Set<OldCard> cards;

    public AbstractOldCardBuilder() {
        cards = new HashSet<>();
    }

    public Set<OldCard> getCandies() {
        return cards;
    }

    public abstract void buildSetCards(String fileName);

}
