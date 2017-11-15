package model.impl;

import model.dec.ParcAttractionItf;
import model.dec.Tarif;
import java.lang.StringBuilder;
import java.util.logging.Logger;
import model.exceptions.ParcPlein;

public final class ParcAttraction implements ParcAttractionItf {
	private static final Logger LOG = Logger.getLogger(ParcAttraction.class.getCanonicalName());

	private String nom;
	private int capacite;
	private double prixNormalIllimite;
	private double prixNormalIllimite5;
	private int nbBilletIllimite;
	private int nbBilletIllimite5;
	private int nbBilletReduit;
	private int nbBilletReduit5;

	public ParcAttraction(String nom,int capacite,double prixNormalIllimite,double prixNormalIllimite5){
		this.nom=nom;
		this.capacite=capacite;
		this.prixNormalIllimite=prixNormalIllimite;
		this.prixNormalIllimite5=prixNormalIllimite5;
		this.nbBilletIllimite=0;
		this.nbBilletIllimite5=0;
		this.nbBilletReduit=0;
		this.nbBilletReduit5=0;
	}	
	public int nbPlacesDispo(){
		return this.capacite-(this.nbBilletIllimite+this.nbBilletIllimite5+this.nbBilletReduit+this.nbBilletReduit5);
	}

	public void vendreBillets(int nb, Tarif tarif) throws ParcPlein{
			try{
				if(nb>nbPlacesDispo()){
					throw new ParcPlein("Le parc est remplie");
				}else{
					switch(tarif){
						case illimite :
							nbBilletIllimite+=nb;
							break;
						case illimite5 :
							nbBilletIllimite5+=nb;
							break;
						case reduit : 
							nbBilletReduit+=nb;
							break;
						case reduit5 :
							nbBilletReduit5+=nb;
							break;
						default :
						break;
					}
				}
			}catch(ParcPlein ex){
				LOG.severe("Le parc est déjà remplie, il contient "+(this.nbBilletIllimite+this.nbBilletIllimite5+this.nbBilletReduit+this.nbBilletReduit5)+" personnes");
			}
	}
	
	public void reinitialiser(){
		this.nbBilletIllimite=0;
		this.nbBilletIllimite5=0;
		this.nbBilletReduit=0;
		this.nbBilletReduit5=0;
	}
	public double chiffreAffaires(){
		return (nbBilletIllimite*prixNormalIllimite+nbBilletIllimite5*prixNormalIllimite5+nbBilletReduit*(0.5*prixNormalIllimite)+nbBilletReduit5*(0.5*prixNormalIllimite5));
	}
	public double tauxRemplissage(){
		return (((double)(nbBilletIllimite+nbBilletIllimite5+nbBilletReduit+nbBilletReduit5)/capacite)*100);
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Parc ").append(this.nom).append(",\n")
		.append("Tarif normal illimité : ").append(this.prixNormalIllimite).append(" euros,\n")
		.append("Tarif normal illimité 5 : ").append(this.prixNormalIllimite5).append(" euros,\n")
		.append(this.nbBilletIllimite).append(" billets vendues au tarif illimité,\n")
		.append(this.nbBilletIllimite5).append(" billets vendues au tarif illimité 5,\n")
		.append(this.nbBilletReduit).append(" billets vendues au tarif réduit,\n")
		.append(this.nbBilletReduit5).append(" billets vendues au tarif réduit 5,\n");

		return sb.toString();
	}

}