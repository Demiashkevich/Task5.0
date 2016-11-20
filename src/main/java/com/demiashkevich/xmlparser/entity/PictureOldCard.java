package com.demiashkevich.xmlparser.entity;

public class PictureOldCard extends OldCard {

    private String pictureType;
    private String valuable;
    private String authorFirstName;
    private String authorLastName;
    private String birthday;
    private String pictureName;

    public PictureOldCard() {
    }

    public PictureOldCard(String code, String country, int year, boolean dispatch, double cost, String pictureType,
                          String valuable, String authorFirstName, String authorLastName, String birthday, String pictureName) {
        super(code, country, year, dispatch, cost);
        this.pictureType = pictureType;
        this.valuable = valuable;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.birthday = birthday;
        this.pictureName = pictureName;

    }

    public String getPictureType() {
        return pictureType;
    }

    public void setPictureType(String pictureType) {
        this.pictureType = pictureType;
    }

    public String getValuable() {
        return valuable;
    }

    public void setValuable(String valuable) {
        this.valuable = valuable;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "PictureOldCard{" +
                "pictureType='" + pictureType + '\'' +
                ", valuable='" + valuable + '\'' +
                ", authorFirstName='" + authorFirstName + '\'' +
                ", authorLastName='" + authorLastName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", pictureName='" + pictureName + '\'' +
                ", code='" + getCode() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", cost='" + getCost() + '\'' +
                ", dispatch='" + isDispatch() + '\'' +
                ", year='" + getYear() + '\'' +
                '}';
    }
}
