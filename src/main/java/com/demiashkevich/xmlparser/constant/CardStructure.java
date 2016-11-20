package com.demiashkevich.xmlparser.constant;

public enum CardStructure {
    CODE("CODE"),
    COUNTRY("COUNTRY"),
    YEAR("YEAR"),
    DISPATCH("DISPATCH"),
    COST("COST"),
    PICTURE_TYPE("PICTURE-TYPE"),
    VALUABLE("VALUABLE"),
    AUTHOR("AUTHOR"),
    FIRST_NAME("FIRST-NAME"),
    LAST_NAME("LAST-NAME"),
    BIRTHDAY("BIRTHDAY"),
    GREETING_DAY("GREETING-DAY"),
    PICTURE_NAME("PICTURE-NAME");

    private String text;

    private CardStructure(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
