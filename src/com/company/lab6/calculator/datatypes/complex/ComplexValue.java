package com.company.lab6.calculator.datatypes.complex;

import com.company.lab6.calculator.AbstractValue;
import com.company.lab6.calculator.DivisionByZeroException;
import com.company.lab6.calculator.OperationNotSupportedException;
import com.company.lab6.calculator.datatypes.integer.IntegerValue;
import com.company.lab6.calculator.datatypes.real.RealValue;

public class ComplexValue extends AbstractValue
{
    private final double re;
    private final double im;

    public ComplexValue(double re, double im)
    {
        super();
        this.re = re;
        this.im = im;
    }

    public String toString()
    {
        return Double.toString(re) + " + i " + Double.toString(im);
    }

    public AbstractValue add(AbstractValue operand)
    {
        return new ComplexValue(re + ((ComplexValue) operand).re, im + ((ComplexValue) operand).im);
    }

    public AbstractValue sub(AbstractValue operand)
    {
        return new ComplexValue(re - ((ComplexValue) operand).re, im - ((ComplexValue) operand).im);
    }

    public AbstractValue mul(AbstractValue operand)
    {
        return new ComplexValue(
                re * ((ComplexValue) operand).re - im * ((ComplexValue) operand).im,
                re * ((ComplexValue) operand).im - im * ((ComplexValue) operand).re);
    }

    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException
    {
        double re = ((ComplexValue) operand).re;
        double im = ((ComplexValue) operand).re;

        if (re == im && re == 0)
            throw new DivisionByZeroException();

        double moduleSquare = re * re + im * im;
        ComplexValue conjugate = new ComplexValue(re, -im);

        try
        {
            return mul(conjugate).mul(new ComplexValue(1 / moduleSquare, 0));
        }
        catch (OperationNotSupportedException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
