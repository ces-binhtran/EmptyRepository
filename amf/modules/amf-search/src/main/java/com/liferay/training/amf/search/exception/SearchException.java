package com.liferay.training.amf.search.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class SearchException extends PortalException {

    public SearchException(String msg) {
        super(msg);
    }

    public SearchException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public SearchException(Throwable throwable) {
        super(throwable);
    }

    public static class MustNotBeNull extends SearchException {
        public MustNotBeNull() {
            super("Value must not be null");
        }
    }

    public static class MustBeDigit extends SearchException {
        public MustBeDigit() {
            super("Value must be 5-digit postal code");
        }
    }
}
