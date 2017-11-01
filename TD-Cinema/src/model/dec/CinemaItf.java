package model.dec;

import model.exceptions.SallePleine;


public interface CinemaItf {
	void vendrePlace() throws SallePleine;
	double tauxRemplissage();
	double chiffreAffaires();
	int nbPlacesDisponible();
	void estPleine();
}