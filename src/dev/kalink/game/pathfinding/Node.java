package dev.kalink.game.pathfinding;

import dev.kalink.game.geometry.Coord;

import java.util.List;

public class Node {
    public Coord position;
    public List<Edge> neighbors;
}
