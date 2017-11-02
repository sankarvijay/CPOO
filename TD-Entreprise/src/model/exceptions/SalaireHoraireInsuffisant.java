package model.exceptions;

import java.lang.Exception;

public final class SalaireHoraireInsuffisant extends Exception {
	
	public SalaireHoraireInsuffisant(){
		super();
	}
	public SalaireHoraireInsuffisant(String message){
		super(message);
	}
}