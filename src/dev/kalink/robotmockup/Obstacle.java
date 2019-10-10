package dev.kalink.robotmockup;

import dev.kalink.robotmockup.geometry.Coord;
import dev.kalink.robotmockup.geometry.Rectangle;

// Is a rectangle with both corners to define rectangle outline
public class Obstacle extends Rectangle {
    Coord a;
    Coord b;
    double max_margin;

    public Obstacle(Coord a, Coord b) {
        super(a,b);
        this.a = a;
        this.b = b;
    }



}
