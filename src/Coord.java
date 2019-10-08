public class Coord {
    double x;
    double y;

    Coord(double x, double y) {
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
        double diff_x = a.y - b.x;

        return diff_y / diff_x;
    }

    public double distance(Coord other_pt) {
        double x_distance = Math.pow(other_pt.x - this.x, 2);
        double y_distance = Math.pow(other_pt.y - this.y, 2);

        return Math.sqrt(x_distance + y_distance);
    }

    public Coord midpoint(Coord other_pt) {
        double x_midpt = (this.x + other_pt.x) / 2;
        double y_midpt = (this.y + other_pt.y) / 2;

        return new Coord(x_midpt, y_midpt);
    }

    public boolean isEqual(Coord pointb) {
        return (this.x == pointb.x) && (this.y == pointb.y);
    }

    public boolean isCollinear(Coord a, Coord b) {
        return slope(a, b) == slope(this, b) && slope(a, b) == slope(this, a);
    }
}

