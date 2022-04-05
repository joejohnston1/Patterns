package com.jjohnston.structural.flyweight;

import java.awt.*;

public class Main {
    static int CANVAS_SIZE = 500;
    static int TREES_TO_DRAW = 1000000;
    static int TREE_TYPES = 2;

    /**
     * Flyweight is a structural design pattern that lets you fit more objects into the available amount of RAM
     * by sharing common parts of state between multiple objects instead of keeping all of the data in each object.
     *
     * Pros
     *  - You can save lots of RAM, assuming your program has tons of similar objects.
     *
     * Cons
     *  -  You might be trading RAM over CPU cycles when some of the context data needs to be recalculated each time
     *  somebody calls a flyweight method.
     *
     *  - The code becomes much more complicated. New team members will always be wondering why the state of an entity
     *  was separated in such a way.
     *
     * Relations with Other Patterns
     *  - You can implement shared leaf nodes of the Composite tree as Flyweights to save some RAM.
     *
     *  - Flyweight shows how to make lots of little objects, whereas Facade shows how to make a single object that
     *  represents an entire subsystem.
     *
     *  - Flyweight would resemble Singleton if you somehow managed to reduce all shared states of the objects to
     *  just one flyweight object.
     *  But there are two fundamental differences between these patterns:
     *   - There should be only one Singleton instance, whereas a Flyweight class can have multiple instances
     *   with different intrinsic states.
     *   - The Singleton object can be mutable. Flyweight objects are immutable.
     *
     * @param args
     */
    public static void main(String[] args) {
        Forest forest = new Forest();
        for (int i = 0; i < Math.floor(TREES_TO_DRAW / TREE_TYPES); i++) {
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Summer Oak", Color.GREEN, "Oak texture stub");
            forest.plantTree(random(0, CANVAS_SIZE), random(0, CANVAS_SIZE),
                    "Autumn Oak", Color.ORANGE, "Autumn Oak texture stub");
        }
        forest.setSize(CANVAS_SIZE, CANVAS_SIZE);
        forest.setVisible(true);

        System.out.println(TREES_TO_DRAW + " trees drawn");
        System.out.println("---------------------");
        System.out.println("Memory usage:");
        System.out.println("Tree size (8 bytes) * " + TREES_TO_DRAW);
        System.out.println("+ TreeTypes size (~30 bytes) * " + TREE_TYPES + "");
        System.out.println("---------------------");
        System.out.println("Total: " + ((TREES_TO_DRAW * 8 + TREE_TYPES * 30) / 1024 / 1024) +
                "MB (instead of " + ((TREES_TO_DRAW * 38) / 1024 / 1024) + "MB)");
    }

    private static int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
