package model.exceptions;

public class InterestRatesException extends Exception
{
	private float interestRates;
	
	public InterestRatesException (float interestRates)
	{
		this.interestRates = interestRates;
	}
	
	public String toString ()
	{
		StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("\nErreur : Taux d'interêt nul ou négatif : ").append(this.interestRates).append(" (interet par defaut : 1% )\n");
        return sb.toString();
    }
}

