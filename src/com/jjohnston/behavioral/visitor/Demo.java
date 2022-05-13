package com.jjohnston.behavioral.visitor;

import com.jjohnston.behavioral.visitor.shapes.*;
import com.jjohnston.behavioral.visitor.visitor.XMLExportVisitor;

public class Demo {

    /**
     * Applicability
     * - Use the Visitor when you need to perform an operation on all elements of a complex object structure (for example, an object tree).
     * - The Visitor pattern lets you execute an operation over a set of objects with different classes by having a visitor
     * object implement several variants of the same operation, which correspond to all target classes.
     * - Use the Visitor to clean up the business logic of auxiliary behaviors.
     * - The pattern lets you make the primary classes of your app more focused on their main jobs by extracting all other
     * behaviors into a set of visitor classes.
     * - Use the pattern when a behavior makes sense only in some classes of a class hierarchy, but not in others.
     * - You can extract this behavior into a separate visitor class and implement only those visiting methods that accept
     * objects of relevant classes, leaving the rest empty.
     *
     * Pros
     * - Open/Closed Principle. You can introduce a new behavior that can work with objects of different classes without
     * changing these classes.
     * - Single Responsibility Principle. You can move multiple versions of the same behavior into the same class.
     * - A visitor object can accumulate some useful information while working with various objects. This might be handy
     * when you want to traverse some complex object structure, such as an object tree, and apply the visitor to each object of this structure.
     *
     * Cons
     * - You need to update all visitors each time a class gets added to or removed from the element hierarchy.
     * - Visitors might lack the necessary access to the private fields and methods of the elements that they’re supposed to work with.
     *
     * Relations with Other Patterns
     * - You can treat Visitor as a powerful version of the Command pattern. Its objects can execute operations over
     * various objects of different classes.
     * - You can use Visitor to execute an operation over an entire Composite tree.
     * - You can use Visitor along with Iterator to traverse a complex data structure and execute some operation over
     * its elements, even if they all have different classes.
     *
     * @param args
     */
    public static void main(String[] args) {
        Dot dot = new Dot(1, 10, 55);
        Circle circle = new Circle(2, 23, 15, 10);
        Rectangle rectangle = new Rectangle(3, 10, 17, 20, 30);

        CompoundShape compoundShape = new CompoundShape(4);
        compoundShape.add(dot);
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        CompoundShape c = new CompoundShape(5);
        c.add(dot);
        compoundShape.add(c);

        export(circle, compoundShape);
    }

    private static void export(Shape... shapes) {
        XMLExportVisitor exportVisitor = new XMLExportVisitor();
        System.out.println(exportVisitor.export(shapes));
    }
}