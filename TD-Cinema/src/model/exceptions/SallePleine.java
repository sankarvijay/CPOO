package model.exceptions;

import java.lang.Exception;

public final class SallePleine extends Exception {
	public SallePleine(){
		super();
	}
	public SallePleine(String message){
		super(message);
	}
}