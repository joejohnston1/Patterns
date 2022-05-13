package com.jjohnston.behavioral.visitor.visitor;

import com.jjohnston.behavioral.visitor.shapes.Circle;
import com.jjohnston.behavioral.visitor.shapes.CompoundShape;
import com.jjohnston.behavioral.visitor.shapes.Dot;
import com.jjohnston.behavioral.visitor.shapes.Rectangle;

public interface Visitor {
    String visitDot(Dot dot);

    String visitCircle(Circle circle);

    String visitRectangle(Rectangle rectangle);

    String visitCompoundGraphic(CompoundShape cg);
}
