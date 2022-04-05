package com.jjohnston.structural.flyweight;

import java.awt.*;

/**
 * The contextual object contains the extrinsic part of the tree
 * state. An application can create billions of these since they
 * are pretty small: just two integer coordinates and one
 * reference field.
 */
public class Tree {
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void draw(Graphics g) {
        type.draw(g, x, y);
    }
}
