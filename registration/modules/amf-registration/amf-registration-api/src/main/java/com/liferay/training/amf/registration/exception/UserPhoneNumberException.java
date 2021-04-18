package com.liferay.training.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserPhoneNumberException extends PortalException {

    public UserPhoneNumberException() {
    }

    public UserPhoneNumberException(String msg) {
        super(msg);
    }

    public UserPhoneNumberException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserPhoneNumberException(Throwable throwable) {
        super(throwable);
    }

    public static class MustBeValidate extends UserPhoneNumberException {

        public MustBeValidate() {
            super("Phone number must be 10 digits long.");
        }
    }
}
