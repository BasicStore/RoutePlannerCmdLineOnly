package com.myrev.rp.ex;

public class DuplicateStationException extends Exception
{
	private String message;
	
	public DuplicateStationException()
	{
		super("Duplicate Station Exception...");
	}
	
	public DuplicateStationException(String message)
	{
		super("Duplicate Station Exception...");
		this.message = message;
	}
	
	
	
	
	
}
