package com.company.lab6.calculator;

public class ParseValueException extends Exception
{
	public ParseValueException()
	{
		super("�������� ������ ������");
	}

	public ParseValueException(String details)
	{
		super("�������� ������ ������. " + details);
	}
}
