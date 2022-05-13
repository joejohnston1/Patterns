package com.jjohnston.behavioral.visitor.shapes;

import com.jjohnston.behavioral.visitor.visitor.Visitor;

public interface Shape {
    void move(int x, int y);
    void draw();
    String accept(Visitor visitor);
}
