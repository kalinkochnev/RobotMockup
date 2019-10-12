package dev.kalink.game.geometry;

public class Rectangle {
    LineSegment top;
    LineSegment bottom;
    LineSegment left;
    LineSegment right;

    // In clockwise order
    public Coord[] getCorners() {
        return new Coord[]{top.pt1, top.pt2, bottom.pt2, bottom.pt1};
    }

    public LineSegment[] getEdges() {
        return new LineSegment[]{top, bottom, left, right};
    }

    public boolean lineIntersects(LineSegment line) {
        for (LineSegment side : getEdges()) {
            
        }
    }


}
