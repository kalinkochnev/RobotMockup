package dev.kalink.game.elements;

import dev.kalink.game.geometry.Coord;
import dev.kalink.game.geometry.LineSegment;
import dev.kalink.game.geometry.Rectangle;

// Is a rectangle with both corners to define rectangle outline
public class Obstacle {
    Rectangle dimensions;
    Rectangle boundary;

    Obstacle(Rectangle dimensions, double margin) {
        this.dimensions = dimensions;
        this.margin = margin;
    }

    private Rectangle calculateBoundary(double margin) {
        double xval = dimensions.getTop().getPt1().get_xcor();
        double factor = (xval + margin) / xval;
    }




}
