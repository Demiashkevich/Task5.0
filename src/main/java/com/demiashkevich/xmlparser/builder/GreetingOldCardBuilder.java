package com.demiashkevich.xmlparser.builder;

import com.demiashkevich.xmlparser.entity.GreetingOldCard;

import java.util.List;

public class GreetingOldCardBuilder extends OldCardBuilder{

    public GreetingOldCardBuilder() {
        this.card = new GreetingOldCard();
    }

    @Override
    public void buildAttribute(List<String> attributes) {
        ((GreetingOldCard)card).setGreetingDay(attributes.get(0));
    }

    @Override
    public void buildAuthorFirstName(String firstName) {

    }

    @Override
    public void buildAuthorLastName(String lastName) {

    }

    @Override
    public void buildBirthday(String date) {

    }

    @Override
    public void buildPictureName(String pictureName) {

    }
}
