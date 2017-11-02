package main;

import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.Handler;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.io.IOException;
import java.util.logging.SimpleFormatter ;

import model.dec.EntrepriseItf;
import model.fact.EmployeFactory;
import model.impl.Employe;
import model.exceptions.SalaireHoraireInsuffisant;
import model.exceptions.HeuresTravailDepasse;


public final class Main {

	private static final Logger LOG = Logger.getLogger(Main.class.getCanonicalName());

	public static void main(String[] args){

		try{
			EmployeFactory ef = new EmployeFactory();
			Employe e1 = ef.createEmploye("John",7.5,35);
			Employe e2 = ef.createEmploye("Cécile",8.2,47);
			Employe e3 = ef.createEmploye("Pierre",14.5,46);
			Employe e4 = ef.createEmploye("Vijay",60.50,60);
			Employe e5 = ef.createEmploye("Laurent",10.00,73);

			e2.salaireHebdo();
			e3.salaireHebdo();
			e4.salaireHebdo();
			e5.salaireHebdo();

			System.out.println(e1);
			System.out.println(e2);
			System.out.println(e3+", Le salaire est de : "+e3.salaireHebdo()+" euros !");
			System.out.println(e4+", Le salaire est de : "+e4.salaireHebdo()+" euros !");
			System.out.println(e5);

		}catch(HeuresTravailDepasse ex){
			LOG.severe(ex.getMessage());
		}
	}
}	