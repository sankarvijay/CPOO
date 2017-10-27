package main;

import java.util.logging.Logger;

import model.impl.SalleCinema;
public final class Main {

    public static void main (String[] args) {

        SalleCinema s1 = new SalleCinema();
        SalleCinema s2 = new SalleCinema("Harry Potter 8",200,9.5);
        System.out.println(s1);
        for(int i=0;i<200;i++){
        	s2.vendrePlace();
        }
        System.out.println(s2);
        s2.estPleine();

    }
}