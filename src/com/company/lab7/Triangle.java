package com.company.lab7;

import java.util.Arrays;

public class Triangle extends Figure implements IShape
{
    Vector2D a;
    Vector2D b;
    Vector2D c;

    public Triangle(String name)
    {
        super(name);
    }

    public Triangle(String name, double ax, double ay, double bx, double by, double cx, double cy)
    {
        super(name);

        a = new Vector2D(ax, ay);
        b = new Vector2D(bx, by);
        c = new Vector2D(cx, cy);

        // �������� �����

        Vector2D A = new Vector2D(b.sub(a).getComponent(0), b.sub(a).getComponent(1)); // ab
        Vector2D B = new Vector2D(c.sub(a).getComponent(0), c.sub(a).getComponent(1)); // ac
        Vector2D C = new Vector2D(b.sub(c).getComponent(0), b.sub(c).getComponent(1)); // cb

        try
        {
            if (A.pCollin(B) || B.pCollin(C) || C.pCollin(A))
            {
                throw new Exception("������������ ����� ������������");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }

    public Triangle() {
        super("Triangle"); // default name
    }

    public double getMedianLength()
    {
        Vector middlePoint = b.add(c.sub(b).multiply(0.5));
        Vector median = middlePoint.sub(a);
        return median.len();
    }

    public void getType()
    {
        double A = b.sub(a).len(); // ab
        double B = c.sub(a).len(); // ac
        double C = b.sub(c).len(); // cb

        double[] agesLengths = new double[3];
        agesLengths[0] = A;
        agesLengths[1] = B;
        agesLengths[2] = C;
        Arrays.sort(agesLengths);

        A = agesLengths[0];
        B = agesLengths[1];
        C = agesLengths[2]; // C - ����� ������� �������

        if (A == B && B == C) {
            System.out.println("�������������� �����������");
        }
        else if (A == B || B == C || C == A)
        {
            System.out.println("�������������� �����������");
        }

        else
        {
            double sumCathetsSquares = Math.pow(A, 2) + Math.pow(B, 2);
            if (Math.pow(C, 2) > sumCathetsSquares)
            {
                System.out.println("������������ �����������");
            }
            else if (Math.pow(C, 2) == sumCathetsSquares)
            {
                System.out.println("������������� �����������");
            }
            else if (Math.pow(C, 2) < sumCathetsSquares)
            {
                System.out.println("�������������� �����������");
            }
        }
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
