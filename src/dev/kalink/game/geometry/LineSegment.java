package dev.kalink.game.geometry;

public class LineSegment extends Line implements Comparable<LineSegment>{
    private double length;

    LineSegment(Coord a, Coord b) {
        super(a, b);
        this.length = calculateLength();
    }

    private double calculateLength() {
        double x_part = Math.pow(pt1.get_xcor() - pt2.get_xcor(), 2);
        double y_part = Math.pow(pt1.get_ycor() - pt2.get_ycor(), 2);
        return Math.sqrt(x_part + y_part);
    }

    public double getLength() {
        return length;
    }

    static boolean segmentsIntersect(LineSegment A, LineSegment B) {
        Coord intersect = intersection(A, B);
        boolean in_x_bounds = intersect.get_xcor() >= A.pt1.get_xcor() && intersect.get_xcor() <= A.pt2.get_xcor();
        boolean in_y_bounds = intersect.get_ycor() >= A.pt1.get_ycor() && intersect.get_ycor() <= A.pt2.get_ycor();

        return in_x_bounds && in_y_bounds;
    }

    @Override
    public int compareTo(LineSegment lineSegment) {
        if (this.length > lineSegment.length) {
            return 1;
        } else if (this.length < lineSegment.length) {
            return -1;
        } else {
            return 0;
        }
    }
}