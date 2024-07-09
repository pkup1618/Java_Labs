package com.company.lab6.calculator;

public class DivisionByZeroException extends Exception
{
	public DivisionByZeroException()
	{
		super("Деление на ноль");
	}
}
