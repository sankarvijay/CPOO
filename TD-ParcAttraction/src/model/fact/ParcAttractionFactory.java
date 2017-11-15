package model.fact;

import model.dec.ParcAttractionItf;
import model.impl.ParcAttraction;

public class ParcAttractionFactory{
	public ParcAttraction createParcAttraction(String nom,int capacite,double prixNormalIllimite,double prixNormalIllimite5){
		return new ParcAttraction(nom,capacite,prixNormalIllimite,prixNormalIllimite5);
	}
}