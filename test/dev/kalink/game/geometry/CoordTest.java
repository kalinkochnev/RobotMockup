package dev.kalink.game.geometry;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoordTest {

    @Test
    void slope() {
        Coord a = new Coord(1, 10);
        Coord b = new Coord(0, 0);
        assertEquals(10, Coord.slope(a, b));

        a = new Coord(-1, 10);
        b = new Coord(0, 0);
        assertEquals(-10, Coord.slope(a, b));
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
    void testPointDistanceFromLineInBounds() {
        Coord pt_a = new Coord(0, 0);
        LineSegment new_line = new LineSegment(new Coord(1, 10), new Coord(7, 3));
        double calculated_value = pt_a.distFromLineSegment(new_line);
        //Answer done by hand is 7.267170337
        double correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

    }

    @Test
    void testPointDistanceFromLineOutOfBounds() {
        Coord pt_a = new Coord(-2, -10);
        LineSegment new_line = new LineSegment(new Coord(1, 10), new Coord(7, 3));
        double calculated_value = pt_a.distFromLineSegment(new_line);
        double correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

        pt_a = new Coord(-2, 5);
        calculated_value = pt_a.distFromLineSegment(new_line);
        correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

        pt_a = new Coord(-2, 11);
        calculated_value = pt_a.distFromLineSegment(new_line);
        correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

        pt_a = new Coord(4, 11);
        calculated_value = pt_a.distFromLineSegment(new_line);
        correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

        pt_a = new Coord(9, 11);
        calculated_value = pt_a.distFromLineSegment(new_line);
        correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

        pt_a = new Coord(9, 5);
        calculated_value = pt_a.distFromLineSegment(new_line);
        correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

        pt_a = new Coord(9, -2);
        calculated_value = pt_a.distFromLineSegment(new_line);
        correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

        pt_a = new Coord(4, -2);
        calculated_value = pt_a.distFromLineSegment(new_line);
        correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));

        pt_a = new Coord(4, 5);
        calculated_value = pt_a.distFromLineSegment(new_line);
        correct_formula = pt_a.testMath(new_line);
        assertEquals(Math.round(correct_formula * Math.pow(10, 7)) / Math.pow(10, 7), Math.round(calculated_value * Math.pow(10, 7)) / Math.pow(10, 7));
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