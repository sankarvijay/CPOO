package model.exceptions;

import java.lang.Exception;

public final class NotAuthorized extends Exception {
	public NotAuthorized(){
		super();
	}
	public NotAuthorized(String message){
		super(message);
	}
}