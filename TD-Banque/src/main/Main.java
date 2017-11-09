package main;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.io.IOException;

import model.dec.CompteManip;
import model.fact.CompteFactory;
import model.exceptions.*;

public final class Main
{

    private static final Logger LOG = Logger.getLogger(Main.class.getCanonicalName());

    public static void main (String[] args) throws InterestRatesException {
        try {
            Handler handler = new FileHandler("bank.log", true);
            handler.setLevel(Level.FINE);
            LOG.addHandler(handler);
        } catch (IOException ioe)
        {
            LOG.warning("Fichier introuvable !");
        }
        
            CompteFactory cf = new CompteFactory();
        
            CompteManip c1 = cf.createCompteCourant("John Doe", 50);
            CompteManip c2 = cf.createCompteCourant("Jack Bauer");
            CompteManip c3 = cf.createCompteEpargne("Johnny Doc", -0.6f);
    
            double amount = 1900.0d;

        try
        {
            c1.deposit(100.0d);
            double retrait = c1.withdraw(amount);
            double newSolde = c2.deposit(100000.0d);


            c3.deposit(100.0d);
            c3.withdraw(55.0d);
        }
    	catch (InsufficientBalanceException e)
        {
            LOG.severe(e.getMessage());
            //System.out.println(e);
        }

        /*catch (InterestRatesException e)
        {
            LOG.severe(e.getMessage());
           //System.out.println(e);
        }*/
        catch (Exception e)
        {
            LOG.severe(e.getMessage());
            //System.out.println(e);
        }
        finally
        {
            LOG.config("Withdraw operation of " + amount);
        }

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

    }
}