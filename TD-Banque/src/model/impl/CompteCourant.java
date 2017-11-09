package model.impl;

import java.util.UUID;
import java.lang.StringBuilder;
import java.util.logging.Logger;

import model.dec.CompteManip;
import model.exceptions.*;

/**
 * Modelsa check account.
 */
public final class CompteCourant extends Compte implements CompteManip
{

    private static final Logger LOG = Logger.getLogger(CompteCourant.class.getCanonicalName());

    private float ceiling;
    
    public CompteCourant (String owner, double initalBalance)
    {
        super(owner, initalBalance);
        //System.out.println ("Plafond automatique : 100€");
        this.ceiling =  100f;
    }

    public CompteCourant (String owner, double initalBalance, float ceiling)
    {
        super(owner, initalBalance);
        this.ceiling =  ceiling;
    }

    public CompteCourant (String owner)
    {
        super(owner);
        //System.out.println ("Plafond automatique : 100€");
        this.ceiling =  100f;
    }

    public CompteCourant (String owner, float ceiling)
    {
        super(owner);
        this.ceiling =  ceiling;
    }

    @Override
    public double withdraw(double amount) throws InsufficientBalanceException
    { 
        double previous = this.getBalance();
        try
        {
            if (previous-amount < this.ceiling)
                throw new InsufficientBalanceException ("Overdraft. Current balance = " + previous + " Current ceiling = " + this.ceiling);
        
        }
        catch (InsufficientBalanceException ex)
        {
            LOG.severe("Overdraft of " + amount + " on account with balance " + previous);
            throw ex;
        }

            this.setBalance(previous - amount);
            return this.getBalance();
    }

    @Override
    public double deposit(double amount)
    {
        double previous = this.getBalance();
        this.setBalance(previous + amount);
        return this.getBalance();
    }

}
