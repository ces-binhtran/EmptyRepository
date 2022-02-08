package com.liferay.traning.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserZipCodeException extends PortalException {
    public UserZipCodeException() {
    }

    public UserZipCodeException(String msg) {
        super(msg);
    }

    public UserZipCodeException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserZipCodeException(Throwable throwable) {
        super(throwable);
    }

    public static class MustBeValidate extends UserZipCodeException {

        public MustBeValidate() {
            super("Zip code number must be 5 digits long.");
        }

    }

    public static class MustNotBeNull extends UserZipCodeException {

        public MustNotBeNull() {
            super("Zip code must not be null.");
        }

    }
}
