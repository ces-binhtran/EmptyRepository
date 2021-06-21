package com.liferay.training.amf.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserStateException extends PortalException {

	public UserStateException() {
	}

	public UserStateException(String msg) {
		super(msg);
	}

	public UserStateException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public UserStateException(Throwable throwable) {
		super(throwable);
	}

	public static class MustNotBeNull extends UserStateException {

		public MustNotBeNull() {
			super("State must not be null.");
		}

	}

}