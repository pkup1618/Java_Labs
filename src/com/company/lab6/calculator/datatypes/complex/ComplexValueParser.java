package com.company.lab6.calculator.datatypes.complex;


import com.company.lab6.calculator.AbstractValue;
import com.company.lab6.calculator.AbstractValueParser;
import com.company.lab6.calculator.ParseValueException;

public class ComplexValueParser implements AbstractValueParser
{
    public AbstractValue parse(String value) throws ParseValueException
    {
        try
        {
            String[] parts = value.split("i");
            if (parts.length == 1)
            {
                return new ComplexValue(Double.parseDouble(parts[0]), 0);
            }
            else
            {
                char sign = parts[0].charAt(parts[0].length() - 1);

                String real = parts[0].substring(0, parts[0].length() - 1);
                String imaginary = parts[1];

                if (sign == '-')
                {
                    return new ComplexValue(Double.parseDouble(real), -Double.parseDouble(imaginary));
                }
                else
                {
                    return new ComplexValue(Double.parseDouble(real), Double.parseDouble(imaginary));
                }
            }
        }
        catch (NumberFormatException exception)
        {
            throw new ParseValueException();
        }
    }

    public String getDatatypeName()
    {
        return "комплексные числа";
    }
}
