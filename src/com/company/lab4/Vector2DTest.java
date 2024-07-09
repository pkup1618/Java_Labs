package com.company.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2DTest
{

    @Test
    void task1()
    {
        Vector2D P = new Vector2D(1,1);
        Vector2D n = new Vector2D(-1, 1);
        Vector2D S = new Vector2D(2,0);
        Vector2D.task1(P, n, S).printVector();
//        assertEquals(new Vector2D(4, 2), Vector2D.task1(P, n, S));
    }

    @Test
    void task2()
    {
        Vector2D P = new Vector2D(1,1);
        Vector2D n = new Vector2D(1, -1);
        Vector2D A = new Vector2D(2,0);
        Vector2D B = new Vector2D(-1,1);
//        Vector2D B = new Vector2D(3,0);
        Vector2D.task2(P, n, A, B).printVector();
//        assertEquals(new Vector2D(0,0), Vector2D.task2(P, n, A, B));
    }

    @Test
    void decompose()
    {
        Vector2D v1 = new Vector2D(1,1);
        Vector2D v2 = new Vector2D(3,1);
        Vector2D v3 = new Vector2D(1,3);

        Vector2D decomposition = v1.decompose(v2, v3);
        decomposition.printVector();
//        assertEquals(new Vector2D(5,5), decomposition);
    }
}