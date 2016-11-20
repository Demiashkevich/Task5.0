package com.demiashkevich.xmlparser.entity;


public class OldCard {

    private String code;
    private String country;
    private int year;
    private boolean dispatch;
    private double cost;

    public OldCard() {
    }

    public OldCard(String code, String country, int year, boolean dispatch, double cost) {
        this.code = code;
        this.country = country;
        this.year = year;
        this.dispatch = dispatch;
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public boolean isDispatch() {
        return dispatch;
    }

    public void setDispatch(boolean dispatch) {
        this.dispatch = dispatch;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object){
            return true;
        }
        if (object.getClass() == OldCard.class){
            OldCard oldCard = (OldCard) object;
            if (year != oldCard.year){
                return false;
            }
            if (!code.equals(oldCard.code)){
                return false;
            }
            if (!country.equals(oldCard.country)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = code.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + year;
        result = 31 * result + (dispatch ? 1 : 0);
        return result;
    }
}
