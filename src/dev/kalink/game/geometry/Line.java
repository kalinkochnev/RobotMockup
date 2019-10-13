package dev.kalink.game.geometry;

import java.util.ArrayList;
import java.util.List;

public class Line {
    protected Coord pt1;
    protected Coord pt2;

    Line(Coord a, Coord b) {
        this.pt1 = a;
        this.pt2 = b;
    }

    //WILL NOT CHECK IF LINE IS VERTICAL
    double getSlope() {
        return Coord.slope(pt1, pt2);
    }

    //WILL NOT CHECK IF LINE IS VERTICAL
    double getYIntercept() {
        return pt1.get_ycor() - getSlope() * pt1.get_xcor();
    }

    public Coord[] getPoints() {
        return new Coord[]{pt1, pt2};
    }

    boolean isParallel(Line other_ln) {
        if (isUndefined(this) && isUndefined(other_ln) && pt1.get_xcor() != other_ln.pt1.get_xcor()) {
            return true;
        } else if (isHorizontal(this) && isHorizontal(other_ln)) {
            return true;
        } else {
            return other_ln.getSlope() == this.getSlope() && other_ln.getYIntercept() != this.getYIntercept();
        }
    }

    static boolean isUndefined(Line a) {
        return a.pt1.get_xcor() == a.pt2.get_xcor();
    }

    static boolean isHorizontal(Line a) {
        return a.pt1.get_ycor() == a.pt2.get_ycor();
    }

    static boolean linesIntersect(Line A, Line B) {
        return A.isParallel(B) && (isUndefined(A) || isHorizontal(A));
    }

    // WILL NOT CHECK IF LINES INTERSECT
    static Coord intersection(Line A, Line B) {
        if ((A.isParallel(B) && (isUndefined(A) || isHorizontal(A)))) {
            throw new RuntimeException("Lines do not intersect");
        } else if (isUndefined(A)) {
            double y_value = B.getSlope() * A.pt1.get_xcor() + B.getYIntercept();
            return new Coord(A.pt1.get_xcor(), y_value);
        } else if (isUndefined(B)) {
            double y_value = A.getSlope() * B.pt1.get_xcor() + A.getYIntercept();
            return new Coord(B.pt1.get_xcor(), y_value);
        } else {
            double x = (A.getYIntercept() - B.getYIntercept()) / (B.getSlope() - A.getSlope());
            double y = B.getSlope() * (x) + B.getYIntercept();
            return new Coord(x, y);
        }
    }

    public boolean onLine(Coord A) {
        if (isUndefined(this)) {
            return A.get_xcor() == pt1.get_xcor();
        } else {
            double expected_y = getSlope() * A.get_xcor() + getYIntercept();
            return A.get_ycor() == expected_y;
        }
    }


}
