package com.company.lab6.calculator.datatypes.real;

import com.company.lab6.calculator.AbstractValue;
import com.company.lab6.calculator.AbstractValueParser;
import com.company.lab6.calculator.ParseValueException;

public class RealValueParser implements AbstractValueParser
{
	public AbstractValue parse(String value) throws ParseValueException
	{
		try
		{
			return new RealValue(Double.parseDouble(value));
		}
		catch (NumberFormatException exception)
		{
			throw new ParseValueException();
		}
	}

	public String getDatatypeName()
	{
		return "вещественные числа";
	}
}
