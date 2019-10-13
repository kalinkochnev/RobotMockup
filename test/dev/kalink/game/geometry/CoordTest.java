package dev.kalink.game.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    @Test
    void testIsCollinear() {
        Coord a = new Coord(0, 0);
        Coord b = new Coord(1, 10);
        Coord c = new Coord(2, 20);
        assertTrue(a.isCollinear(b, c));

        a = new Coord(0, 0);
        b = new Coord(1, 10);
        c = new Coord(3, -10);
        assertFalse(a.isCollinear(b, c));
    }

    @Test
    void testSlope() {
        Coord a = new Coord(1, 10);
        Coord b = new Coord(0, 0);
        assertEquals(10, Coord.slope(a, b));

        a = new Coord(-1, 10);
        b = new Coord(0, 0);
        assertEquals(-10, Coord.slope(a, b));
    }

    @Test
    void testPointDistanceFromLine() {
        Coord[] cases = {new Coord(-2, -10), new Coord(-2, 5), new Coord(-2, 11), new Coord(4, 11), new Coord(9, 11), new Coord(9, 5), new Coord(4, -2), new Coord(4, 5), new Coord(2, 8.833333)};
        LineSegment new_line = new LineSegment(new Coord(1, 10), new Coord(7, 3));
        for (Coord coord : cases) {
            double calculated_value = coord.distFromLineSegment(new_line);
            double correct_formula = Math.abs((new_line.pt1.get_ycor() - new_line.pt2.get_ycor()) * coord.get_xcor() - (new_line.pt1.get_xcor() - new_line.pt2.get_xcor()) * coord.get_ycor() + new_line.pt1.get_xcor() * new_line.pt2.get_ycor() - new_line.pt1.get_ycor() * new_line.pt2.get_xcor()) / new_line.getLength();
            assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));
        }

    }

    @Test
    void testProximitySort() {
        Coord a = new Coord(0, 6), b = new Coord(2, 12), c = new Coord(3, 18);
        Coord[] test_data = {c, a, b};
        Coord reference = new Coord(0, -1000);
        Coord[] correct_data = {a, b, c};
        assertArrayEquals(correct_data, Coord.sortByProximity(reference, test_data));
    }
}