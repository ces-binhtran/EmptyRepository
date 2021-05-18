package com.liferay.training.amf.search.results.util;

public class ConvertUtil {

    public static String convertName(String firstName, String lastName) {
        return firstName + " " + lastName.substring(0, 1).toUpperCase();
    }
}
