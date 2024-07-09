package com.company.lab6.calculator;

public class OperationNotSupportedException extends Exception
{
	public OperationNotSupportedException(String operation)
	{
		super("Операция " + operation + " не поддерживается");
	}
}
