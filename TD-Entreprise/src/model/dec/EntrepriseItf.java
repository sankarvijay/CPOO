package model.dec;
import model.exceptions.HeuresTravailDepasse;

public interface EntrepriseItf {

	double salaireHebdo()  throws HeuresTravailDepasse;

    String getNom();

    double getSalaireBase();

    int getHeuresTravailles();

}