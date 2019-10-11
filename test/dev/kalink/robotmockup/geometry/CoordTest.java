package dev.kalink.robotmockup.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    @Test
    void slope() {
        Coord a = new Coord(1, 10);
        Coord b = new Coord(0, 0);
        assertEquals(9, Coord.slope(a, b));
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

    @Test
    void testPointDistanceFromLine() {

        Coord pt_a = new Coord(0, 0);
        LineSegment new_line = new LineSegment(new Coord(1, 10), new Coord(7, 3));
        double calculated_value = pt_a.distFromLine(new_line);
        //Answer done by hand is 7.267170337
        assertEquals(7.267170337,calculated_value);

    }
}