package com.company.lab4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest
{

    @Test
    void task1()
    {
        Vector2D P = new Vector2D(3,3);
        Vector2D n = new Vector2D(-1, 1);
        Vector2D S = new Vector2D(2,4);

        assertEquals(new Vector2D(4, 2), Main.task1(P, n, S));
    }

    @Test
    void task2()
    {
        Vector2D P = new Vector2D(7,0);
        Vector2D n = new Vector2D(0, 1);
        Vector2D A = new Vector2D(3,2);
        Vector2D B = new Vector2D(6,-4);

        assertEquals(new Vector2D(0,0), Main.task2(P, n, A, B));
    }
}