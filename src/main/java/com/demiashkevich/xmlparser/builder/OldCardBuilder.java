package com.demiashkevich.xmlparser.builder;

import com.demiashkevich.xmlparser.entity.OldCard;

import java.util.List;

public abstract class OldCardBuilder {

    protected OldCard card;


    public abstract void buildAttribute(List<String> attributes);
    public abstract void buildAuthorFirstName(String firstName);
    public abstract void buildAuthorLastName(String lastName);
    public abstract void buildBirthday(String date);
    public abstract void buildPictureName(String pictureName);

    public void buildCode(String code){
        card.setCode(code);
    }

    public void buildCountry(String country) {
        card.setCountry(country);
    }

    public void buildYear(int year) {
        card.setYear(year);
    }

    public void buildDispatch(boolean dispatch) {
        card.setDispatch(dispatch);
}

    public void buildCost(double cost) {
        card.setCost(cost);
    }

    public OldCard getCard() {
        return card;
    }


}
