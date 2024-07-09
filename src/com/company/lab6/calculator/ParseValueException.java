package com.company.lab6.calculator;

public class ParseValueException extends Exception
{
	public ParseValueException()
	{
		super("Неверный формат строки");
	}

	public ParseValueException(String details)
	{
		super("Неверный формат строки. " + details);
	}
}
