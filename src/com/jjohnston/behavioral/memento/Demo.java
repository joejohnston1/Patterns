package com.jjohnston.behavioral.memento;

import com.jjohnston.behavioral.memento.editor.Editor;
import com.jjohnston.behavioral.memento.shapes.Circle;
import com.jjohnston.behavioral.memento.shapes.CompoundShape;
import com.jjohnston.behavioral.memento.shapes.Dot;
import com.jjohnston.behavioral.memento.shapes.Rectangle;

import java.awt.*;

/**
 *  Use the Memento pattern when you want to produce snapshots of the object’s state to be able to
 *  restore a previous state of the object.
 *
 *  The Memento pattern lets you make full copies of an object’s state, including private fields,
 *  and store them separately from the object. While most people remember this pattern thanks to the “undo” use case,
 *  it’s also indispensable when dealing with transactions (i.e., if you need to roll back an operation on error).
 *
 *  Pros
 *  - You can produce snapshots of the object’s state without violating its encapsulation.
 *  - You can simplify the originator’s code by letting the caretaker maintain the history of the originator’s state.
 *
 *  Cons
 *  - The app might consume lots of RAM if clients create mementos too often.
 *  - Caretakers should track the originator’s lifecycle to be able to destroy obsolete mementos.
 *
 * Relations with Other Patterns
 * - You can use Command and Memento together when implementing “undo”. In this case, commands are responsible for
 * performing various operations over a target object, while mementos save the state of that object just before a command gets executed.
 *
 * - You can use Memento along with Iterator to capture the current iteration state and roll it back if necessary.
 *
 * - Sometimes Prototype can be a simpler alternative to Memento. This works if the object, the state of which you want
 * to store in the history, is fairly straightforward and doesn’t have links to external resources, or the links are easy to re-establish.
 *
 */
public class Demo {
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                        new Circle(110, 110, 50, Color.RED),
                        new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}
