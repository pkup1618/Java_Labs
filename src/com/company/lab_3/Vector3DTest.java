package com.company.lab_3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;

class Vector3DTest
{
    Vector3D v = new Vector3D(3,4,5);

    @Test
    void scalar()
    {
        assertEquals(v.scalar(new Vector3D(2, 2, 2)), 24);
    }

    @Test
    void len()
    {
        assertEquals(v.len(), Math.sqrt(50));
    }

    @Test
    void multiply()
    {
        assertEquals(v.multiply(2), new Vector3D(6,8,10));
    }

    @Test
    void add()
    {
        assertEquals(v.add(new Vector3D(1,1,1)), new Vector3D(4,5,6));
    }

    @Test
    void sub()
    {
        assertEquals(v.sub(new Vector3D(1,1,1)), new Vector3D(2,3,4));
    }

    @Test
    void vecX()
    {
        assertEquals(v.vecX(new Vector3D(3,4,5)), new Vector3D(0,0,0));
    }

    @Test
    void pCollin()
    {
        assertTrue(v.pCollin(new Vector3D(-3, -4, -5)));
    }
}