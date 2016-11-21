package com.demiashkevich.xmlparser.builder;

import com.demiashkevich.xmlparser.entity.PictureOldCard;

import java.util.List;

public class PictureOldCardBuilder extends OldCardBuilder {

    public PictureOldCardBuilder() {
        this.card = new PictureOldCard();
    }

    @Override
    public void buildAttribute(List<String> attributes) {
        ((PictureOldCard)card).setPictureType(attributes.get(0));
        if(attributes.size() == 2){
            ((PictureOldCard)card).setValuable(attributes.get(1));
        }
    }

    @Override
    public void buildAuthorFirstName(String firstName) {
        ((PictureOldCard)card).getAuthor().setAuthorFirstName(firstName);
    }

    @Override
    public void buildAuthorLastName(String lastName) {
        ((PictureOldCard)card).getAuthor().setAuthorLastName(lastName);
    }

    @Override
    public void buildBirthday(String date) {
        ((PictureOldCard)card).getAuthor().setBirthday(date);
    }

    @Override
    public void buildPictureName(String pictureName) {
        ((PictureOldCard)card).getAuthor().setPictureName(pictureName);
    }

}
