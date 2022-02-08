package com.liferay.traning.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserPasswordException extends PortalException {
    public UserPasswordException() {
    }

    public UserPasswordException(String msg) {
        super(msg);
    }

    public UserPasswordException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserPasswordException(Throwable throwable) {
        super(throwable);
    }

    public static class MustContain extends UserPasswordException {

        public MustContain() {
            super("Password must contain one uppercase, one number, one special character");
        }

    }

    public static class MustMatch extends UserPasswordException {

        public MustMatch() {
            super("Passwords must match.");
        }

    }

    public static class MustNotBeNull extends UserPasswordException {

        public MustNotBeNull() {
            super("Passwords must not be null");
        }

    }

    public static class MustNotBeTooShort extends UserPasswordException {

        public MustNotBeTooShort() {
            super("Password has at least 6 characters.");
        }

    }
}
