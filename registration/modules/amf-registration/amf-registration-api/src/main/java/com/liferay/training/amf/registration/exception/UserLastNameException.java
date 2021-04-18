package com.liferay.training.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserLastNameException extends PortalException {

    public UserLastNameException() {
    }

    public UserLastNameException(String msg) {
        super(msg);
    }

    public UserLastNameException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserLastNameException(Throwable throwable) {
        super(throwable);
    }

    public static class MustNotBeNull extends UserLastNameException {

        public MustNotBeNull() {
            super("Last name must not be null");
        }

    }

    public static class MustBeAlphanumeric extends UserLastNameException {

        public MustBeAlphanumeric() {
            super("Last name must be alphanumeric, does not contain special characters.");
        }
    }

    public static class MustNotBeTooLong extends UserLastNameException {
        public MustNotBeTooLong() {
            super("Last name just has maximum 50 characters");
        }
    }
}