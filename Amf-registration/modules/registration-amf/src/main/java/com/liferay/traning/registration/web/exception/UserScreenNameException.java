package com.liferay.traning.registration.web.exception;
import com.liferay.portal.kernel.exception.PortalException;

public class UserScreenNameException extends PortalException {

    public UserScreenNameException() {
    }

    public UserScreenNameException(String msg) {
        super(msg);
    }

    public UserScreenNameException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserScreenNameException(Throwable throwable) {
        super(throwable);
    }

    public static class MustBeUnique extends UserScreenNameException {

        public MustBeUnique() {
            super("Screen name must be unique");
        }

    }

    public static class MustBeValidate extends UserScreenNameException {

        public MustBeValidate() {
            super("Screen name must be validated");
        }

    }

    public static class MustNotBeNull extends UserScreenNameException {

        public MustNotBeNull() {
            super("Screen name can't be null");
        }

    }

}