package com.liferay.training.amf.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserUserNameException extends PortalException {

	public UserUserNameException() {
	}

	public UserUserNameException(String msg) {
		super(msg);
	}

	public UserUserNameException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public UserUserNameException(Throwable throwable) {
		super(throwable);
	}

	public static class MustBeAlphanumeric extends UserUserNameException {

		public MustBeAlphanumeric() {
			super(
				"Email address must be alphanumeric, does not contain special characters.");
		}

	}

	public static class MustNotBeDuplicate extends UserUserNameException {

		public MustNotBeDuplicate() {
			super("User name must not be duplicate.");
		}

	}

	public static class MustNotBeNull extends UserUserNameException {

		public MustNotBeNull() {
			super("Email address must not be null");
		}

	}

	public static class MustNotBeTooLong extends UserUserNameException {

		public MustNotBeTooLong() {
			super("Email address just has maximum 16 characters.");
		}

	}

	public static class MustNotBeTooShort extends UserUserNameException {

		public MustNotBeTooShort() {
			super("Email address has at least 4 characters.");
		}

	}

}