package com.liferay.training.amf.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserAcceptedTouException extends PortalException {

    public UserAcceptedTouException() {
    }

    public UserAcceptedTouException(String msg) {
        super(msg);
    }

    public UserAcceptedTouException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public UserAcceptedTouException(Throwable throwable) {
        super(throwable);
    }
}
