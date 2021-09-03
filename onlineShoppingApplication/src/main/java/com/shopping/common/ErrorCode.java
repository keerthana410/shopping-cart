package com.shopping.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {
	GLOBAL(2),

	AUTHENTICATION(10), JWT_TOKEN_EXPIRED(11);

	private int code;

	private ErrorCode(int errorCode) {
		this.code = errorCode;
	}

	@JsonValue
	public int getErrorCode() {
		return code;
	}
}