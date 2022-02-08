package com.liferay.traning.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserSecurityQueryException extends PortalException {
    public UserSecurityQueryException() {
    }

    public UserSecurityQueryException(String msg) {
        super(msg);
    }

    public UserSecurityQueryException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserSecurityQueryException(Throwable throwable) {
        super(throwable);
    }

    public static class MustBeAlphanumeric extends UserSecurityQueryException {

        public MustBeAlphanumeric() {
            super("Answer must be alphanumeric");
        }

    }

    public static class MustNotBeNull extends UserSecurityQueryException {

        public MustNotBeNull() {
            super("Reminder query must not be null");
        }

    }

    public static class MustNotBeTooLong extends UserSecurityQueryException {

        public MustNotBeTooLong() {
            super("Answer must have maximum 255 characters");
        }

    }
}
