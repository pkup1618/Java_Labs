package com.company.lab3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentTest {

    Vector3D a = new Vector3D(0,0,0);
    Vector3D b = new Vector3D(10,0,0);

    Segment segment = new Segment(a, b);

    @Test
    void len() {
        assertEquals(segment.len(), Math.sqrt(200));
    }

    @Test
    void distanceTo() {
        Vector3D p = new Vector3D(7, -10, 10);
        assertEquals(segment.distanceTo(p), Math.sqrt(200),0.0001);
    }
}