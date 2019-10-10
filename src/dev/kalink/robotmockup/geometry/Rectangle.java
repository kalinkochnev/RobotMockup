package dev.kalink.robotmockup.geometry;

public class Rectangle {
    LineSegment top;
    LineSegment bottom;
    LineSegment left;
    LineSegment right;

    // In clockwise order
    public Coord[] getCorners() {
        return new Coord[]{top.pt1, top.pt2, bottom.pt2, bottom.pt1};
    }

    public boolean isRectangleToching(Rectangle a) {

    }

    public boolean coordOnSide(Coord a) {

    }

}
