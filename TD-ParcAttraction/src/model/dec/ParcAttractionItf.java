package model.dec;

import model.exceptions.ParcPlein;
import model.dec.Tarif;

public interface ParcAttractionItf {

	int nbPlacesDispo();
	void vendreBillets(int nb, Tarif tarif) throws ParcPlein;
	void reinitialiser();
	double chiffreAffaires();
	double tauxRemplissage();

}