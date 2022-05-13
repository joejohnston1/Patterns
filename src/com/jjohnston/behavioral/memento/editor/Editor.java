package com.jjohnston.behavioral.memento.editor;

import com.jjohnston.behavioral.memento.Command.Command;
import com.jjohnston.behavioral.memento.history.History;
import com.jjohnston.behavioral.memento.history.Memento;
import com.jjohnston.behavioral.memento.shapes.CompoundShape;
import com.jjohnston.behavioral.memento.shapes.Shape;

import javax.swing.*;
import java.io.*;
import java.util.Base64;

/**
 * The originator holds some important data that may change over
 * time. It also defines a method for saving its state inside a
 * memento and another method for restoring the state from it.
 */
public class Editor extends JComponent {
    private Canvas canvas;
    private CompoundShape allShapes = new CompoundShape();
    private History history;

    public Editor() {
        canvas = new Canvas(this);
        history = new History();
    }

    public void loadShapes(Shape... shapes) {
        allShapes.clear();
        allShapes.add(shapes);
        canvas.refresh();
    }

    public CompoundShape getShapes() {
        return allShapes;
    }

    /**
     *  Saves the current state inside a memento.
     * @param c
     */
    public void execute(Command c) {

        // Memento is an immutable object; that's why the
        // originator passes its state to the memento's
        // constructor parameters.
        history.push(c, new Memento(this));
        c.execute();
    }

    public void undo() {
        if (history.undo())
            canvas.repaint();
    }

    public void redo() {
        if (history.redo())
            canvas.repaint();
    }

    public String backup() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.allShapes);
            oos.close();
            return Base64.getEncoder().encodeToString(baos.toByteArray());
        } catch (IOException e) {
            return "";
        }
    }

    public void restore(String state) {
        try {
            byte[] data = Base64.getDecoder().decode(state);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
            this.allShapes = (CompoundShape) ois.readObject();
            ois.close();
        } catch (ClassNotFoundException e) {
            System.out.print("ClassNotFoundException occurred.");
        } catch (IOException e) {
            System.out.print("IOException occurred.");
        }
    }
}
