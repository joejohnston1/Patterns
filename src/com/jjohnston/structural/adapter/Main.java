package com.jjohnston.structural.adapter;

public class Main {

    /**
     * Use the Adapter class when you want to use some existing class, but its interface isn’t compatible with the rest
     * of your code.
     * The Adapter pattern lets you create a middle-layer class that serves as a translator between your code and a legacy
     * class, a 3rd-party class or any other class with a weird interface.
     * Use the pattern when you want to reuse several existing subclasses that lack some common functionality that can’t
     * be added to the superclass.
     *
     *  Pros
     *  - Single Responsibility Principle. You can separate the interface or data conversion code from the primary
     *  business logic of the program.
     *
     *  - Open/Closed Principle. You can introduce new types of adapters into the program without breaking the existing
     *  client code, as long as they work with the adapters through the client interface.
     *
     *  Cons
     *  - The overall complexity of the code increases because you need to introduce a set of new interfaces and
     *  classes. Sometimes it’s simpler just to change the service class so that it matches the rest of your code.
     *
     * Relations with Other Patterns
     * - Bridge is usually designed up-front, letting you develop parts of an application independently of each other.
     * On the other hand, Adapter is commonly used with an existing app to make some otherwise-incompatible classes work together nicely.
     *
     * - Adapter changes the interface of an existing object, while Decorator enhances an object without changing its
     * interface. In addition, Decorator supports recursive composition, which isn’t possible when you use Adapter.
     *
     * - Adapter provides a different interface to the wrapped object, Proxy provides it with the same interface,
     * and Decorator provides it with an enhanced interface.
     *
     * - Facade defines a new interface for existing objects, whereas Adapter tries to make the existing interface usable.
     * Adapter usually wraps just one object, while Facade works with an entire subsystem of objects.
     *
     * - Bridge, State, Strategy (and to some degree Adapter) have very similar structures. Indeed, all of these patterns
     * are based on composition, which is delegating work to other objects. However, they all solve different problems.
     * A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other
     * developers the problem the pattern solves.
     *
     * @param args
     */
    public static void main(String[] args) {
        // Round fits round, no surprise.
        RoundHole roundHole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        if (roundHole.fits(rpeg)) {
            System.out.println("Round peg r5 fits round hole r5.");
        }

        SquarePeg smallSqPeg = new SquarePeg(2);
        SquarePeg largeSqPeg = new SquarePeg(20);
        // hole.fits(smallSqPeg); // Won't compile.

        // Adapter solves the problem.
        SquarePegAdapter smallSqPegAdapter = new SquarePegAdapter(smallSqPeg);
        SquarePegAdapter largeSqPegAdapter = new SquarePegAdapter(largeSqPeg);
        if (roundHole.fits(smallSqPegAdapter)) {
            System.out.println("Square peg w2 fits round hole r5.");
        }
        if (!roundHole.fits(largeSqPegAdapter)) {
            System.out.println("Square peg w20 does not fit into round hole r5.");
        }
    }
}
