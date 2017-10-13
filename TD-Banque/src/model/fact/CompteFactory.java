package model.fact;

import model.dec.CompteManip;
import model.impl.CompteCourant;

public final class CompteFactory
{
	public CompteManip createCompteCourant(String owner)
	{
		return new CompteCourant(owner);
	}
}
