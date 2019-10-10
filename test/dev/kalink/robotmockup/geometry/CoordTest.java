package dev.kalink.robotmockup.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    @Test
    void slope() {
        Coord a = new Coord(1, 10);
        Coord b = new Coord(0, 0);
        assertEquals(10, Coord.slope(a, b));
    }

    @Test
    void distance() {
    }

    @Test
    void midpoint() {
    }

    @Test
    void isEqual() {
    }

    @Test
    void isCollinear() {
    }

    @Test
    void intersect() {

    }
}