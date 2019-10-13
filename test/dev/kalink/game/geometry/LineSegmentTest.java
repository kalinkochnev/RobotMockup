package dev.kalink.game.geometry;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineSegmentTest {

    @Test
    void testSegmentsIntersect() {
        LineSegment a = new LineSegment(new Coord(0, 0), new Coord(2, -4));
        LineSegment b = new LineSegment(new Coord(0, -4), new Coord(2, 0));
        assertTrue(LineSegment.segmentsIntersect(a, b));
    }

    @Test
    void testSegmentsDoNotIntersect() {
        LineSegment a = new LineSegment(new Coord(1, 1), new Coord(4, 4));
        LineSegment b = new LineSegment(new Coord(0, 0), new Coord(10, 0));
        assertFalse(LineSegment.segmentsIntersect(a, b));
    }

    @Test
    void testPointOnLineSegment() {
        LineSegment a = new LineSegment(new Coord(0, 0), new Coord(10, 10));
        Coord test_value = new Coord(1, 1);
        assertTrue(a.onSegment(test_value));

        // Tests if point is on horizontal line
        a = new LineSegment(new Coord(0, 0), new Coord(10, 0));
        test_value = new Coord(1, 0);
        assertTrue(a.onSegment(test_value));

        // Tests if point is on vertical line
        a = new LineSegment(new Coord(0, 0), new Coord(0, 10));
        test_value = new Coord(0, 1);
        assertTrue(a.onSegment(test_value));
    }

    @Test
    void testPointNotOnLineSegment() {
        LineSegment a = new LineSegment(new Coord(0, 0), new Coord(10, 10));
        Coord test_value = new Coord(15, 1);
        assertFalse(a.onSegment(test_value));
    }

    @Test
    void testCompareTo() {
        // Less than
        LineSegment a = new LineSegment(new Coord(0, 0), new Coord(0, 1));
        LineSegment b = new LineSegment(new Coord(0, 0), new Coord(0, 2));
        assertEquals(a.compareTo(b), -1);

        // Greater than
        assertEquals(b.compareTo(a), 1);

        // Equal to
        b = new LineSegment(new Coord(0, 0), new Coord(0, 1));
        assertEquals(a.compareTo(b), 0);
    }
}
