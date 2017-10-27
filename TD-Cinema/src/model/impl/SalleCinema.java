package model.impl;

import java.lang.String;
import java.util.logging.Logger;
import java.lang.StringBuilder;

public final class SalleCinema{
	private static final Logger LOG = Logger.getLogger(SalleCinema.class.getCanonicalName());
	private String film;
	public int nbPlaces;
	private double tarif;
	private int nbPlacesVendues;

	public SalleCinema(String filmProjecte, int capacite, double prix){
		this.film=filmProjecte;
		this.nbPlaces=capacite;
		this.tarif=prix;
	}

	public SalleCinema(){
		this.film="Mersal";
		this.nbPlaces=1000;
		this.tarif=15.0d;
		this.nbPlacesVendues=0;
	}

	public void vendrePlace(){
		this.nbPlacesVendues++;
	}

	public double tauxRemplissage(){
		return (this.nbPlacesVendues/(double)this.nbPlaces)*100;
	}

	public double chiffreAffaires(){
		return this.nbPlacesVendues*this.tarif;
	}

	public int nbPlacesDisponible(){
		return this.nbPlaces-this.nbPlacesVendues;
	}

	public void estPleine(){
		if(this.nbPlaces==this.nbPlacesVendues){
			LOG.severe("La salle est remplie");
		}else{
			LOG.severe("Il reste : "+nbPlacesDisponible());
		}
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("Film projete : ").append(this.film).append("\n")
		.append("Tarif : ").append(this.tarif).append("\n")
		.append("Nombre de places : ").append(this.nbPlaces).append("\n")
		.append("Nombre de places disponible : ").append(nbPlacesDisponible()).append("\n")
		.append("Taux remplissage : ").append(tauxRemplissage()).append("%").append("\n")
		.append("Chiffre d'affaires : ").append(chiffreAffaires()).append("%").append("\n");
		return s.toString();
	}

}