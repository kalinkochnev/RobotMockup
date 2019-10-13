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

    public int numLineSegsIntersect(LineSegment line) {
        int intersect_count = 0;
        for (LineSegment side : getEdges()) {
            if (LineSegment.segmentsIntersect(side, line)) {
                intersect_count++;
            }
        }
        return intersect_count;
    }

    public int numLinesIntersect(Line line) {
        int intersect_count = 0;
        for (Line side : getEdges()) {
/*            if (LineSegment.segmentsIntersect(side, line)) {
                intersect_count++;
            }*/
        }
        return intersect_count;
    }

}
