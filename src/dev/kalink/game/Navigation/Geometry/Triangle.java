package org.firstinspires.ftc.teamcode.Navigation.Geometry;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {
    LineSegment a;
    LineSegment b;
    LineSegment c;

    Triangle(LineSegment[] line_segments) {
        this.a = line_segments[0];
        this.b = line_segments[1];
        this.c = line_segments[2];
    }

    public LineSegment[] getSides() {
        return new LineSegment[] {a, b, c};
    }

}
