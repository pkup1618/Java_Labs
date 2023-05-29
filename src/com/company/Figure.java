package com.company;

import java.awt.*;

public class Figure
{
    protected String name; // название фигуры
    protected Color color = Color.black; // цвет линии

    protected double x;
    protected double y;

    public Figure(String name)
    {
        this.name = name;
    }
}
