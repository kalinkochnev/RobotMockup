package dev.kalink.game.geometry;

import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    void testLineAreParallel() {
        // tests y=x and y=x+1 are parallel
        Line a = new Line(new Coord(0, 0), new Coord(10, 10));
        Line b = new Line(new Coord(0, 1), new Coord(10, 11));
        assertTrue(a.isParallel(b));

        // tests two horizontal lines are parallel
        a = new Line(new Coord(0, 0), new Coord(10, 0));
        b = new Line(new Coord(0, 1), new Coord(10, 1));
        assertTrue(a.isParallel(b));

        // tests two vertical lines are parallel
        a = new Line(new Coord(0, 0), new Coord(0, 10));
        b = new Line(new Coord(1, 0), new Coord(1, 10));
        assertTrue(a.isParallel(b));

    }

    @Test
    void tesLinesAreNotParallel() {
        // tests if vertical line is parallel to y=x
        Line a = new Line(new Coord(0, 0), new Coord(10, 10));
        Line b = new Line(new Coord(5, 0), new Coord(5, 10));
        assertFalse(a.isParallel(b));

        // tests if horizontal line is parallel to y=x
        a = new Line(new Coord(0, 0), new Coord(10, 10));
        b = new Line(new Coord(0, 5), new Coord(10, 5));
        assertFalse(a.isParallel(b));

        // tests if a not vertical/horizontal line is parallel to y=x
        a = new Line(new Coord(0, 0), new Coord(10, 10));
        b = new Line(new Coord(1, 1), new Coord(11, 11));
        assertFalse(a.isParallel(b));
    }

    @Test
    void testPointOnLine() {
        // Tests if point is on y=x
        Line a = new Line(new Coord(0, 0), new Coord(10, 10));
        Coord test_value = new Coord(1, 1);
        assertTrue(a.onLine(test_value));

        // Tests if point is on horizontal line
        a = new Line(new Coord(0, 0), new Coord(10, 0));
        test_value = new Coord(1, 0);
        assertTrue(a.onLine(test_value));

        // Tests if point is on vertical line
        a = new Line(new Coord(0, 0), new Coord(0, 10));
        test_value = new Coord(0, 1);
        assertTrue(a.onLine(test_value));
    }

    @Test
    void testPointsNotOnLine() {
        // Test coord not on y=x
        Line a = new Line(new Coord(0, 0), new Coord(10, 10));
        Coord test_value = new Coord(0, 1);
        assertFalse(a.onLine(test_value));

        // Test coord not on vertical line
        a = new Line(new Coord(0, 0), new Coord(0, 10));
        test_value = new Coord(1, 1);
        assertFalse(a.onLine(test_value));

        // Test coord not on horizontal line
        a = new Line(new Coord(0, 0), new Coord(10, 0));
        assertFalse(a.onLine(test_value));

    }

    @Test
    void testIntersection() {
        // tests intersection between y=x and y=-x
        Line a = new Line(new Coord(0, 0), new Coord(10, 10));
        Line b = new Line(new Coord(0, 0), new Coord(-10, 10));
        assertTrue(Line.intersection(a, b).equals(new Coord(0, 0)));

        //tests intersection between horizontal line and vertical line
        a = new Line(new Coord(0, 4), new Coord(1, 4));
        b = new Line(new Coord(10, 0), new Coord(10, 1));
        assertTrue(Line.intersection(a, b).equals(new Coord(10, 4)));

        // tests intersection between horizontal line and y=x
        a = new Line(new Coord(0, 4), new Coord(1, 4));
        b = new Line(new Coord(0, 0), new Coord(10, 10));
        assertTrue(Line.intersection(a, b).equals(new Coord(4, 4)));

        // tests intersection between vertical line and y=x
        a = new Line(new Coord(10, 0), new Coord(10, 1));
        b = new Line(new Coord(0, 0), new Coord(10, 10));
        assertTrue(Line.intersection(a, b).equals(new Coord(10, 10)));
    }
}