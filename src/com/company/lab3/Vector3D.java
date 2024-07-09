package com.company.lab3;

import java.util.Objects;

public class Vector3D
{
    private double x;
    private double y;
    private double z;

    public Vector3D() {

    }

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public double getZ()
    {
        return z;
    }

    double scalar(Vector3D v)
    {
        return this.x * v.getX() + this.y * v.getY() + this.z * v.getZ();
    }

    double len()
    {
        return Math.sqrt(scalar(this));
    }

    Vector3D multiply(double factor)
    {
        return new Vector3D(x * factor, y * factor, z * factor);
    }

    Vector3D add(Vector3D v)
    {
        return new Vector3D(x + v.getX(), y + v.getY(), z + v.getZ());
    }

    Vector3D sub(Vector3D v)
    {
        return new Vector3D(x - v.getX(), y - v.getY(), z - v.getZ());
    }

    Vector3D vecX(Vector3D v)
    {
        double x = this.y * v.getZ() - v.getY() * this.z;
        double y = this.x * v.getZ() - v.getX() * this.z;
        double z = this.x * v.getY() - v.getX() * this.y;

        return new Vector3D(x,y,z);
    }

    boolean pCollin(Vector3D v)
    {
        Vector3D prod = vecX(v);

        return MathDoubleOps.equalsWithRate(prod.len(), 0, 0.000001);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Vector3D vector3D = (Vector3D) o;

        return Double.compare(vector3D.x, x) == 0 &&
               Double.compare(vector3D.y, y) == 0 &&
               Double.compare(vector3D.z, z) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(x, y, z);
    }
}
