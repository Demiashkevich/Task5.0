package com.demiashkevich.xmlparser.entity;

public class PictureOldCard extends OldCard {

    private String pictureType;
    private String valuable;
    private Author author;

    public PictureOldCard() {
        this.author = new Author();
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public class Author {

        private String authorFirstName;
        private String authorLastName;
        private String birthday;
        private String pictureName;

        public Author() {
        }

        public String getAuthorFirstName() {
            return authorFirstName;
        }

        public void setAuthorFirstName(String authorFirstName) {
            this.authorFirstName = authorFirstName;
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

        public String getPictureName() {
            return pictureName;
        }

        public void setPictureName(String pictureName) {
            this.pictureName = pictureName;
        }

        @Override
        public String toString() {
            return " Author{" +
                    "authorFirstName='" + authorFirstName + '\'' +
                    ", authorLastName='" + authorLastName + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", pictureName='" + pictureName + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PictureOldCard{" +
                "pictureType='" + pictureType + '\'' +
                ", valuable='" + valuable + '\'' +
                ", code='" + getCode() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", cost='" + getCost() + '\'' +
                ", dispatch='" + isDispatch() + '\'' +
                ", year='" + getYear() + '\'' + author;
    }
}
