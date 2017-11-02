package model.exceptions;

import java.lang.Exception;

public final class HeuresTravailDepasse extends Exception {
	
	public HeuresTravailDepasse(){
		super();
	}
	public HeuresTravailDepasse(String message){
		super(message);
	}
}