package com.company;

public class Triangle extends Figure implements IShape
{
    public Triangle(String name)
    {
        super(name);
    }

    public Triangle() {
        super("Triangle"); // default name
    }

    @Override
    public double getArea()
    {
        return 0;
    }

    @Override
    public double getPerimeter()
    {
        return 0;
    }

    @Override
    public void writeName()
    {
        System.out.println(name);
    }
}
