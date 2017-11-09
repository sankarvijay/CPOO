package model.dec;

import model.exceptions.*;

public interface CompteManip extends CompteItf
{
	double withdraw (double amount) throws InsufficientBalanceException ;
}