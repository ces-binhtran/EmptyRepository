package com.liferay.training.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserAddressException extends PortalException {

    public UserAddressException() {
    }

    public UserAddressException(String msg) {
        super(msg);
    }

    public UserAddressException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserAddressException(Throwable throwable) {
        super(throwable);
    }

    public static class MustNotBeNull extends UserAddressException {

        public MustNotBeNull() {
            super("Address must not be null");
        }
    }

    public static class MustBeAlphanumeric extends UserAddressException {

        public MustBeAlphanumeric() {
            super("Address must be alphanumeric, does not contain special characters.");
        }
    }

    public static class MustNotBeTooLong extends UserAddressException {
        public MustNotBeTooLong() {
            super("Address just has maximum 255 characters.");
        }
    }
}
