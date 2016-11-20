package com.demiashkevich.xmlparser.entity;

public class GreetingOldCard extends OldCard {

    private String greetingDay;

    public GreetingOldCard() {
    }

    public GreetingOldCard(String code, String country, int year, boolean dispatch, double cost, String greetingDay) {
        super(code, country, year, dispatch, cost);
        this.greetingDay = greetingDay;
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
