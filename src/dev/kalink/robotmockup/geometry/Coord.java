package dev.kalink.robotmockup.geometry;

public class Coord {
    private double x;
    private double y;

    public Coord(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double get_xcor() {
        return x;
    }

    public double get_ycor() {
        return y;
    }

    public void set_x(double x) {
        this.x = x;
    }

    public void set_y(double y) {
        this.y = y;
    }

    public static double slope(Coord a, Coord b) {
        double diff_y = a.y - b.y;
        double diff_x = a.x - b.x;

        return diff_y / diff_x;
    }

    public double distance(Coord b) {
        double x_distance = Math.pow(b.x - this.x, 2);
        double y_distance = Math.pow(b.y - this.y, 2);

        return Math.sqrt(x_distance + y_distance);
    }

    public Coord midpoint(Coord b) {
        double x_midpt = (this.x + b.x) / 2;
        double y_midpt = (this.y + b.y) / 2;

        return new Coord(x_midpt, y_midpt);
    }

    public boolean isEqual(Coord b) {
        return (this.x == b.x) && (this.y == b.y);
    }

    public boolean isCollinear(Coord a, Coord b) {
        return slope(a, b) == slope(this, b) && slope(a, b) == slope(this, a);
    }

    double distFromLine(LineSegment line) {
        double segment_dist = line.distance();
        double dist_a = line.pt1.distance(this);
        double dist_b = line.pt2.distance(this);

        // Calculates angle between line seg and seg "a"
        double angle_theta = Math.acos((Math.pow(dist_b, 2) - Math.pow(dist_a, 2) - Math.pow(segment_dist, 2)) / -2 * dist_a * dist_b);
        // calculate distance from point to line
        return dist_a * Math.sin(angle_theta);

    }
}

