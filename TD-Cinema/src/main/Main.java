package main;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.io.IOException;
import java.util.logging.SimpleFormatter;

import model.impl.SalleCinema;
import model.exceptions.SallePleine;
import model.fact.SalleFactory;

public final class Main {
    private static final Logger LOG = Logger.getLogger(Main.class.getCanonicalName());

    public static void main (String[] args) {

        SalleFactory sf = new SalleFactory();

        SalleCinema s1 = new SalleCinema();
        SalleCinema s2 = sf.createSalleCinema("Harry Potter 8",200,9.5);

        //s2.estPleine();
        try{
            for(int i=0;i<=250;i++){
                s2.vendrePlace();
            }
        }catch(SallePleine ex){
            LOG.severe(ex.getMessage());
        }finally{
            LOG.fine("Il reste encore " + s2.nbPlacesDisponible());
        }
            
        System.out.println(s1);    
        System.out.println(s2);
    }
}