package com.wenthor.userdetailsapi.enums;

import com.wenthor.userdetailsapi.exception.exceptions.CountryNotFoundException;

public enum Country {
    TURKEY("TR"),
    BELGIUM("BE"),
    UNITED_STATES("US");

    private final String shortName;

    Country(String shortName){
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }

    public static Country getByShortName(String shortName) {
        for (Country country : Country.values()) {
            if (country.getShortName().equalsIgnoreCase(shortName)) {
                return country;
            }
        }
        throw new CountryNotFoundException(ErrorCodes.COUNTRY_NOT_FOUND,String.format("İstekte bulunduğun %s kısaltmaya sahip ülke sistem üzerinde bulunamadı.",shortName));
    }
}
