package model.impl;

import model.dec.EntrepriseItf;
import model.exceptions.SalaireHoraireInsuffisant;
import model.exceptions.HeuresTravailDepasse;
import java.lang.StringBuilder;
import java.util.logging.Logger;

public class Employe implements EntrepriseItf{
	
	private static final Logger LOG = Logger.getLogger(Employe.class.getCanonicalName());

	private String nom;
	private double salaireHoraire;
	private int heuresTravailles;

	public Employe(String nom, double salaireHoraire, int heuresTravailles){
		this.nom=nom;
		try{
			if (salaireHoraire<13.0d) {
				throw new SalaireHoraireInsuffisant("Salaire Horaire de base insuffisant, il est actuellement de "+salaireHoraire+" euros");
			}else{
				this.salaireHoraire=salaireHoraire;
			}
		}catch(SalaireHoraireInsuffisant ex){
			LOG.severe("L'heure de base ne doit pas etre en dessous de 13 euros.");
		}

		try{
			if (heuresTravailles>60) {
				throw new HeuresTravailDepasse("Heures de travailles dépasses de "+(60-heuresTravailles)+" heures");
			}else{
				this.heuresTravailles=heuresTravailles;
			}
		}catch(HeuresTravailDepasse ex){
			LOG.severe("On peut pas travailler plus de 60 heures.");
		}
	}

	@Override
	public double salaireHebdo() throws HeuresTravailDepasse{
		try{
			if (heuresTravailles>60) {
				throw new HeuresTravailDepasse("Heures de travailles dépasses de "+(60-heuresTravailles)+" heures");
			}else if(heuresTravailles>40){
				return ((1.5*salaireHoraire)*(double)heuresTravailles);
			}
			else{
				return ((double)heuresTravailles*salaireHoraire);
			}
		}catch(HeuresTravailDepasse ex){
			LOG.severe("On peut pas travailler plus de 60 heures.");
		}
		return 0.0d;
	}

    public String getNom(){
    	return this.nom;
    }

    public double getSalaireBase(){
    	return this.salaireHoraire;
    }

    public int getHeuresTravailles(){
    	return this.heuresTravailles;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(salaireHoraire<13 || heuresTravailles>60){

        }else{
			sb.append(this.nom).append(",").append("salaire horaire : ").
        	append(this.salaireHoraire).append(" euros; heures travaillées : ").append(this.heuresTravailles);
        }
       
        return sb.toString(); //Retouner avec le .toString() car c'est un stringBuilder (ATTENTION !!)
    }
}
