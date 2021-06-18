/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.registration.web.exception;

import com.liferay.portal.kernel.exception.PortalException;

import java.util.List;

/**
 * @author Brian Wing Shun Chan
 */
public class RegistrationValidationException extends PortalException {

	public RegistrationValidationException() {
	}

	public RegistrationValidationException(List<String> _errors) {
		super(String.join(",", _errors));

		_errors = _errors;
	}

	public RegistrationValidationException(String msg) {
		super(msg);
	}

	public RegistrationValidationException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public RegistrationValidationException(Throwable throwable) {
		super(throwable);
	}

	public List<String> getErrors() {
		return _errors;
	}

	private List<String> _errors;

}