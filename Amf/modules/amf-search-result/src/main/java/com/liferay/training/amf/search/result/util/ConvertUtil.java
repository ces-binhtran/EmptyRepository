package com.liferay.training.amf.search.result.util;

public class ConvertUtil {

    public static String convertName(String firstName, String lastName) {
        return firstName + " " + lastName.substring(0, 1).toUpperCase();
    }
}