package com.liferay.training.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserCityException extends PortalException {
    public UserCityException() {
    }

    public UserCityException(String msg) {
        super(msg);
    }

    public UserCityException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserCityException(Throwable throwable) {
        super(throwable);
    }

    public static class MustNotBeNull extends UserCityException {

        public MustNotBeNull() {
            super("City must not be null");
        }
    }

    public static class MustBeAlphanumeric extends UserCityException {

        public MustBeAlphanumeric() {
            super("City must be alphanumeric, does not contain special characters.");
        }
    }

    public static class MustNotBeTooLong extends UserCityException {
        public MustNotBeTooLong() {
            super("City just has maximum 255 characters.");
        }
    }
}
