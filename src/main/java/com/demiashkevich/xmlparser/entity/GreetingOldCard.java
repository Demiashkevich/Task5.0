package com.demiashkevich.xmlparser.entity;

public class GreetingOldCard extends OldCard {

    private String greetingDay;

    public GreetingOldCard() {
    }

    public String getGreetingDay() {
        return greetingDay;
    }

    public void setGreetingDay(String greetingDay) {
        this.greetingDay = greetingDay;
    }

    @Override
    public String toString() {
        return "GreetingOldCard{" +
                "greetingDay='" + greetingDay + '\'' +
                ", code='" + getCode() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", cost='" + getCost() + '\'' +
                ", dispatch='" + isDispatch() + '\'' +
                ", year='" + getYear() + '\'' +
                '}';
    }
}
