package com.company.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest
{
    Vector vector1 = new Vector(new double[] {1,2,3,4,5});
    Vector vector2 = new Vector(new double[] {1,1,1,1});

    @Test
    void dimension()
    {
        assertEquals(5, vector1.dimension());
    }

    @Test
    void printVector()
    {
        vector1.printVector();
    }

    @Test
    void scalar()
    {
        assertEquals(10, vector1.scalar(vector2), 0.0001);
    }

    @Test
    void len()
    {
        assertEquals(Math.sqrt(55), vector1.len(), 0.0001);
    }

    @Test
    void multiply()
    {
        assertEquals(new Vector(new double[] {2,4,6,8,10}), vector1.multiply(2));
    }

    @Test
    void add()
    {
        assertEquals(new Vector(new double[] {2,3,4,5}), vector1.add(vector2));
    }

    @Test
    void sub()
    {
        assertEquals(new Vector(new double[] {0,1,2,3}), vector1.sub(vector2));
    }

    @Test
    void pr()
    {
        Vector v1 = new Vector(new double[] {2,2,0});
        Vector v2 = new Vector(new double[] {-1,0,0});
        assertEquals(2, v1.pr(v2), 0.00001);
    }
}