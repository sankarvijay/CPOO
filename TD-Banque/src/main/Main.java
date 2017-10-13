package main;

import java.util.logging.Logger;

import model.dec.CompteManip;
import model.fact.CompteFactory;
import model.exceptions.InsufficientBalance;

public final class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getCanonicalName());

    public static void main (String[] args) {

    	CompteFactory cf = new CompteFactory();
    	
    	CompteManip c1 = cf.createCompteCourant("John Doe");
    	CompteManip c2 = cf.createCompteCourant("Jack Bauer");

    	c1.deposit(1500.0d);
        try{
            double retrait = c1.withdraw(1900.0d);
            
        }catch(InsufficientBalance ex){
            LOG.error(ex);
        }
        double newSolde = c2.deposit(100000.0d);

        System.out.println(c1);
        System.out.println(c2);
    }
}