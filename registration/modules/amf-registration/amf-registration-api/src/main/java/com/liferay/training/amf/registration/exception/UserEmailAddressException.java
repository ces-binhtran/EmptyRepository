package com.liferay.training.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserEmailAddressException extends PortalException {

    public UserEmailAddressException() {
    }

    public UserEmailAddressException(String msg) {
        super(msg);
    }

    public UserEmailAddressException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserEmailAddressException(Throwable throwable) {
        super(throwable);
    }

    public static class MustNotBeNull extends UserEmailAddressException {

        public MustNotBeNull() {
            super("Email address must not be null.");
        }

    }

    public static class MustBeAlphanumeric extends UserEmailAddressException {

        public MustBeAlphanumeric() {
            super("Email address must be alphanumeric, does not contain special characters.");
        }
    }

    public static class MustNotBeTooLong extends UserEmailAddressException {
        public MustNotBeTooLong() {
            super("Email address just has maximum 255 characters.");
        }
    }
}
