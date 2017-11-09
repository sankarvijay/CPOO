package model.exceptions;

public final class NotAuthorizedException extends Exception
{
	public NotAuthorizedException()
	{
		super();
	}
	public NotAuthorizedException(String message)
	{
		super(message);
	}
}