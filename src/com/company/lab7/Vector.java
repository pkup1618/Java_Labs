package com.company.lab7;

import java.util.Arrays;

public class Vector
{
    double[] components;

    /**
     * �����������, �� ������� ���������
     * @param components ����������
     */
    public Vector(double[] components)
    {
        this.components = components.clone();
    }

    /**
     * �����������, ����������� �������� ������, ���� ��������� ��� �������� ������������
     * @param v ���������� ��� ����������� ������
     * @param dim �����������
     */
    public Vector(Vector v, int dim)
    {
        int lessDim = Math.min(dim, v.dimension());
        double[] result = new double[dim];

        for (int i = 0; i < lessDim; i++)
        {
            result[i] = v.components[i];
        }
        // ���� �� ��������, ���� ���-�� ��������

        for (int i = lessDim; i < dim; i++)
        {
            result[i] = 0;
        }
        // ��������� ��������� ������

        components = result;
    }

    /**
     * ������ ����������� (���������� ���� ����������� ����� ��������)
     */
    public Vector() {

    }

    /**
     * �������� ����������� �������
     * @return �����������
     */
    public int dimension()
    {
        return components.length;
    }

    /**
     * �������� i-� ����������
     * @param i - �����
     * @return i-� ����������
     */
    public double getComponent(int i)
    {
        return components[i];
    }

    /**
     * ����� ������ ������� �� �����
     */
    public void printVector()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("������, ����������� ").append(dimension()).append(" ");
        stringBuilder.append("[ ");
        for (double component : components)
        {
            stringBuilder.append(component).append(" ");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }

    /**
     * ��������� ������������ ������� �� ������ v <br>
     * (������������� ���������� �� ���������� �� ������������ ��������)
     * @param v - ������, �� ������� �������� ��������
     * @return - ��������� ������������
     */
    public double scalar(Vector v)
    {
        double result = 0;
        int minDimension = Math.min(v.dimension(), this.dimension());

        for (int i = 0; i < minDimension; i++)
        {
            result += (v.getComponent(i) * this.getComponent(i));
        }

        return result;
    }

    /**
     * �������� ����� �������
     * @return ����� �������
     */
    public double len()
    {
        return Math.sqrt(this.scalar(this));
    }

    /**
     * ��������� ������� �� ������
     * @param factor ������
     * @return ������, ���������� �� ������
     */
    public Vector multiply(double factor)
    {
        double[] result = new double[this.dimension()];

        for (int i = 0; i < this.dimension(); i++)
        {
            result[i] = components[i] * factor;
        }

        return new Vector(result);
    }

    /**
     * ����� �������� (������ ����� ����� ����������� �� ������������ ��������� ��������)
     * @param v ������, ������� ���������� � ������ �������
     * @return ����� ��������
     */
    public Vector add(Vector v)
    {
        int minDim = Math.min(this.dimension(), v.dimension());
        double[] result = new double[minDim];

        for (int i = 0; i < minDim ; i++)
        {
            result[i] = this.components[i] + v.components[i];
        }

        return new Vector(result);
    }

    public Vector normalise()
    {
        return this.multiply(1/this.len());
    }

    /**
     * �������� �������� (������ �������� ����� ����������� �� ������������ ����������� ��������)
     * @param v ������, ������� �������� �� ������ �������
     * @return �������� ��������
     */
    public Vector sub(Vector v)
    {
        int minDim = Math.min(this.dimension(), v.dimension());
        double[] result = new double[minDim];

        for (int i = 0; i < Math.min(this.dimension(), v.dimension()); i++)
        {
            result[i] = this.components[i] - v.components[i];
        }

        return new Vector(result);
    }

    /**
     * �������� ������� �� ������ v
     * @param v ������
     * @return ��������
     */
    public double pr(Vector v)
    {
        return this.scalar(v) / v.len();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Vector vector = (Vector) o;

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode()
    {
        return Arrays.hashCode(components);
    }
}