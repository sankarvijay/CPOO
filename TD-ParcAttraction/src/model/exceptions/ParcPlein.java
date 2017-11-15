package model.exceptions;

import java.lang.Exception;

public final class ParcPlein extends Exception {
	public ParcPlein(){
		super();
	}
	public ParcPlein(String message){
		super(message);
	}
}