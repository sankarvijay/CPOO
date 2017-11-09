package model.fact;

import model.dec.CompteManip;
import model.impl.*;

public final class CompteFactory
{

	public static final CompteFactory INSTANCE = new CompteFactory();

	public CompteManip createCompteCourant(String owner)
	{
		return new CompteCourant(owner);
	}

	public CompteManip createCompteCourant(String owner, float ceiling)
	{
		return new CompteCourant(owner, ceiling);
	}

	public CompteManip createCompteEpargne(String owner, float interestRates) {
		return new CompteEpargne(owner, interestRates) ;
	}

	public CompteManip createCompteEpargne(String owner, float interestRates, float ceiling)
	{
		return new CompteEpargne(owner, interestRates, ceiling);
	}
}