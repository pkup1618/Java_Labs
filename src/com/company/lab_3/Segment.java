package com.company.lab_3;

public class Segment
{

    private Vector3D a;
    private Vector3D b;

    public Vector3D getA()
    {
        return a;
    }

    public Vector3D getB()
    {
        return b;
    }

    public Segment(Vector3D a, Vector3D b) {
        this.a = a;
        this.b = b;
    }

    public double len()
    {
        return b.sub(a).len();
    }

    public double distanceTo(Vector3D c)
    {
        if (c.equals(a) || c.equals(b))
        {
            return 0;
        }

        Vector3D AB = b.sub(a);
        double lenAB = AB.len();

        Vector3D BA = AB.multiply(-1);
        double lenBA = lenAB;

        Vector3D AC = c.sub(a);
        double lenAC = AC.len();

        Vector3D BC = c.sub(b);
        double lenBC = BC.len();

        // Если угол CAB тупой
        if (AC.scalar(AB) / (lenAC * lenAB) <= 0)
        {
            return AC.len();
        }

        // Если угол CBA тупой
        if (BC.scalar(BA) / (lenBC * lenBA) <= 0)
        {
            return BC.len();
        }

        // Высота - это и есть расстояние
        return (lenAC * lenAB * Math.sqrt(1 - Math.pow(AC.scalar(AB) / (lenAC * lenAB), 2))) / lenAB;
    }

}
