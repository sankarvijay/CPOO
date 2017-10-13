package model.impl;

import java.util.UUID;
import java.lang.StringBuilder;
import java.util.logging.Logger;


import model.dec.CompteManip;
import model.exceptions.InsufficientBalance;

/**
 * Modelsa check account.
 */
public final class CompteCourant extends Compte implements CompteManip {

    private static final Logger LOG = Logger.getLogger(CompteCourant.class.getCanonicalName());
    
    private int overdraft;

    public CompteCourant(String owner, double initialBalance, int overdraft){
        super(owner, initialBalance);
        this.overdraft = overdraft;
    }
    
    public CompteCourant(String owner, double initialBalance){
        super(owner, initialBalance);
        this.overdraft = 0;
    }

    public CompteCourant(String owner, int overdraft){
        super(owner);
        this.overdraft = overdraft;
    } 
    
    public CompteCourant(String owner){
        super(owner);
        this.overdraft = 0;
    } 
    
    public int getOverdraft() { 
        return this.overdraft;
    }
    
    public void setOverdraft(int newOverdraft) {
        this.overdraft = newOverdraft; 
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalance{
        double previous = this.getBalance();

        try{
            if(previous - amount < 0.0d) {
                throw new InsufficientBalance("Overdraft. Current balance = "+previous);
            }
        }catch(InsufficientBalance ex){
            LOG.severe("Overdraft of "+(previous-amount)+" on account with balance "+previous);
            throw ex;
        }
        return this.getBalance();
    }

    @Override
    public double deposit(double amount){
        double previous = this.getBalance();
        this.setBalance(previous + amount);
        return this.getBalance();
    }
}
