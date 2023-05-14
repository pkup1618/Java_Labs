package com.company.lab4;

/**
 * Исключение, выбрасываемое в случае коллинеарности векторов там, где это недопустимо
 */
public class VCollinearException extends Exception
{
    public VCollinearException()
    {
        super("Векторы коллинеарны");
    }
}
