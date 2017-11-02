package model.fact;

import model.dec.EntrepriseItf;
import model.impl.Employe;

public class EmployeFactory
{
	public Employe createEmploye(String nom, double salaireHoraire, int heuresTravailles){
		return new Employe(nom,salaireHoraire,heuresTravailles);
	}
}
