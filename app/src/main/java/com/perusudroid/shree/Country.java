package com.perusudroid.shree;

/**
 * Created by Intel on 23-03-2018.
 */

public class Country {


    private String countryName;
    private int pic;

    public Country(String countryName,int pic){

        this.countryName = countryName;
        this.pic = pic;

    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
}