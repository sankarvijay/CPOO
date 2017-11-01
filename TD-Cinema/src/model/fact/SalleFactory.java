package model.fact;

import model.dec.CinemaItf;
import model.impl.SalleCinema;

public final class SalleFactory
{
	public SalleCinema createSalleCinema(String filmProjecte, int capacite, double prix)
	{
		return new SalleCinema(filmProjecte,capacite,prix);
	}
}
