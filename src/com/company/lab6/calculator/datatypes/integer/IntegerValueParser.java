package com.company.lab6.calculator.datatypes.integer;

import com.company.lab6.calculator.AbstractValue;
import com.company.lab6.calculator.AbstractValueParser;
import com.company.lab6.calculator.ParseValueException;

public class IntegerValueParser implements AbstractValueParser
{
	public AbstractValue parse(String value) throws ParseValueException
	{
		try
		{
			return new IntegerValue(Integer.parseInt(value));
		}
		catch (NumberFormatException exception)
		{
			throw new ParseValueException();
		}
	}

	public String getDatatypeName()
	{
		return "целые числа";
	}
}
