package com.company.lab6.calculator;

public class OperationNotSupportedException extends Exception
{
	public OperationNotSupportedException(String operation)
	{
		super("�������� " + operation + " �� ��������������");
	}
}
