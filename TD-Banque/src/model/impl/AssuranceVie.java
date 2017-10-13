package model.impl;

import java.util.Calendar;

/**
* Model a check account
*/

public  final class AssuranceVie extends Compte {

	private final Calendar creationDate;

	public AssuranceVie(String owner, double initialBalance){
		super(owner, initialBalance);
		this.creationDate = Calendar.getInstance();
	}

	public AssuranceVie(String owner){
		super(owner);
		this.creationDate = Calendar.getInstance();
	} 
	
	public Calendar getCreationDate() {
		return this.creationDate;
	}

	@Override
	public double withdraw(double amount){
		double previous = this.getBalance();
		if(this.creationDate.compareTo(Calendar.getInstance())) {
			this.setBalance(previous - amount);
		}
		return this.getBalance();

	}

	@Override
	public double deposite(double amount){
		double previous = this.getBalance();
		this.setBalance(previous + amount);
		return this.getBalance();
	}
}