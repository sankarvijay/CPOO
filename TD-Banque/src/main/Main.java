package main;

import model.dec.CompteManip;
import model.fact.CompteFactory;

public final class Main
{
    public static void main (String[] args)
    {
    	CompteFactory cf = new CompteFactory();
    	
    	CompteManip c1 = cf.createCompteCourant("John Doe");
    	CompteManip c2 = cf.createCompteCourant("Jack Bauer");

    	c1.deposit(1500.0d);
        double retrait = c1.withdraw(900.0d);
        double newSolde = c2.deposit(100000.0d);

        System.out.println(c1);
        System.out.println(c2);
    }
}