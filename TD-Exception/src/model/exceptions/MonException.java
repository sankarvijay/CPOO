package model.exceptions;

import java.lang.Exception;

public final class MonException extends Exception {
	public MonException() {
		super();
	}

	public MonException(String message) {
		super(message);
	}
}