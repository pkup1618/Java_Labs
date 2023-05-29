package com.company;

public class Vector2D extends Vector
{
    /**
     * ����������� �� ���� �����������
     * @param x ���������� �� ��� �������
     * @param y ���������� �� ��� �������
     */
    public Vector2D(double x, double y)
    {
//        double[] components = new double[2];
//        components[0] = x;
//        components[1] = y;
//
//        this.components = components;
        super(new double[] {x, y});
    }

    /**
     * �������� ���������� �� ��� �������
     * @return ���������� X
     */
    double getX()
    {
        return components[0];
    }

    /**
     * �������� ���������� �� ��� �������
     * @return ���������� Y
     */
    double getY()
    {
        return components[1];
    }

    /**
     * �������� �� ������� ������� ������������� ��� (������� ������ ������� �� 90 ��������)
     * @return ������������� ������
     */
    public Vector2D getOrthogonal()
    {
        return new Vector2D(-getY(), getX());
    }

    /**
     * ���������� ������� �� ������ �� ���� ��������
     * @param v1 ������ ������ ������
     * @param v2 ������ ������ ������
     * @return ���������� � ������
     */
    public Vector2D decompose(Vector2D v1, Vector2D v2)
    {
        try
        {
            if (v1.pCollin(v2))
            {
                throw new VCollinearException();
            }
        }
        catch (VCollinearException e)
        {
            e.printStackTrace();
        }

        double a = v1.getX();
        double b = v1.getY();

        double c = v2.getX();
        double d = v2.getY();

        double e = this.getX();
        double f = this.getY();

        // �������� ������� ������� ��� 2 �� 2
        double y = ((f / a) - (b * e) / (a * d)) / (1 - (b * c) / (a * d));
        double x = (e - (c * y)) / a;

        return new Vector2D(x, y);

//        return new Vector2D(
//                this.pr(v1) * Math.signum(this.scalar(v1)),
//                this.pr(v2) * Math.signum(this.scalar(v2)));
    }

    /**
     * ����� �������� �������� �� ��������������
     * @param v ������, � ������� ��������� ��������������
     * @return ����������� ��� ���
     */
    public boolean pCollin(Vector2D v)
    {
        if (this.getX() == 0 && v.getX() != 0)
        {
            return false;
        }

        if (this.getY() == 0 && v.getY() != 0)
        {
            return false;
        }

        if (this.getX() != 0 && v.getX() == 0)
        {
            return false;
        }

        if (this.getY() != 0 && v.getY() == 0)
        {
            return false;
        }

        if (this.getX() == v.getX() && this.getY() == v.getY())
        {
            return true;
        }

        return this.getX() / v.getX() == this.getY() / v.getY();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Vector2D vector = (Vector2D) o;
        return vector.getX() == this.getX() && vector.getY() == this.getY();
    }

    public static Vector2D task1(Vector2D P, Vector2D n, Vector2D S)
    {
        Vector normalisedN = n.normalise();

        double prLen = P.sub(S).pr(normalisedN);
        Vector simPoint = S.add(normalisedN.multiply(prLen * 2));

        return new Vector2D(simPoint.getComponent(0), simPoint.getComponent(1));
    }

    public static Vector2D task2(Vector2D P, Vector2D n, Vector2D A, Vector2D B)
    {
        Vector normalisedN = n.normalise();

        double prLenA = P.sub(A).pr(normalisedN);  // ����� �������� AP �� �������
        Vector A1 = A.add(normalisedN.multiply(prLenA * 2));

        double prLenB = P.sub(B).pr(normalisedN); // ����� �������� BP �� �������
        Vector B1 = B.add(normalisedN.multiply(prLenB * 2));

        Vector prA = normalisedN.multiply(prLenA);

        try
        {
            Vector PA = P.sub(A);
            Vector PB = P.sub(B);
            if(Math.signum(n.scalar(PA)) == Math.signum(n.scalar(PB)))
            {
                throw new Exception("Points on the same side");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }


        try
        {
            if (B.sub(A1).equals(B1.sub(A))) {
                throw new Exception("a and A1B collinear");
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        Vector BA1 = B.sub(A1);

        double scalar = (prLenA * prLenA) / prA.multiply(-1).scalar(BA1);

        Vector A1X = BA1.multiply(scalar);
        Vector answer = A1.add(A1X);

        return new Vector2D(answer.getComponent(0), answer.getComponent(1));
    }
}