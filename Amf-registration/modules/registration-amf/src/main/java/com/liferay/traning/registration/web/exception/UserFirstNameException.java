package com.liferay.traning.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserFirstNameException extends PortalException {
    public UserFirstNameException() {
    }

    public UserFirstNameException(String msg) {
        super(msg);
    }

    public UserFirstNameException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserFirstNameException(Throwable throwable) {
        super(throwable);
    }

    public static class MustBeAlphanumeric extends UserFirstNameException {

        public MustBeAlphanumeric() {
            super(
                    "First name must be alphanumeric, does not contain special characters.");
        }

    }

    public static class MustNotBeNull extends UserFirstNameException {

        public MustNotBeNull() {
            super("First name must not be null");
        }

    }

    public static class MustNotBeTooLong extends UserFirstNameException {

        public MustNotBeTooLong() {
            super("First name just has maximum 50 characters.");
        }

    }
}
