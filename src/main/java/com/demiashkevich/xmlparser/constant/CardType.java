package com.demiashkevich.xmlparser.constant;

public enum CardType {
    GREETING_CARD("GREETING-OLD-CARD"), PICTURE_CARD("PICTURE-OLD-CARD");

    private String type;

     private CardType(String type) {
         this.type = type;
    }

    public String getType() {
        return type;
    }
}
