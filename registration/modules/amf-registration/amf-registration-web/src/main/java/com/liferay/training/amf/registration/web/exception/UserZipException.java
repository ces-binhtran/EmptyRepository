package com.liferay.training.amf.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class UserZipException extends PortalException {

	public UserZipException() {
	}

	public UserZipException(String msg) {
		super(msg);
	}

	public UserZipException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public UserZipException(Throwable throwable) {
		super(throwable);
	}

	public static class MustBeValidate extends UserZipException {

		public MustBeValidate() {
			super("Phone number must be 5 digits long.");
		}

	}

	public static class MustNotBeNull extends UserZipException {

		public MustNotBeNull() {
			super("Zip code must not be null.");
		}

	}

}