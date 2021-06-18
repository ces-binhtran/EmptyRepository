package com.liferay.training.amf.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserBirthdayException extends PortalException {

	public UserBirthdayException() {
	}

	public UserBirthdayException(String msg) {
		super(msg);
	}

	public UserBirthdayException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public UserBirthdayException(Throwable throwable) {
		super(throwable);
	}

	public static class MustNotBeNull extends UserUserNameException {

		public MustNotBeNull() {
			super("Email address must not be null");
		}

	}

	public static class MustNotTooYoung extends UserBirthdayException {

		public MustNotTooYoung() {
			super("User must at least 13 years old.");
		}

	}

}