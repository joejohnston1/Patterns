package com.jjohnston.structural.bridge;

public class Main {

    /**
     * The Bridge pattern lets you split the monolithic class into several class hierarchies.
     * After this, you can change the classes in each hierarchy independently of the classes in the others.
     * This approach simplifies code maintenance and minimizes the risk of breaking existing code.
     *
     * Use the Bridge pattern when you want to divide and organize a monolithic class that has several variants of
     * some functionality (for example, if the class can work with various database servers).
     *
     * Pros
     *  - You can create platform-independent classes and apps.
     *
     *  - The client code works with high-level abstractions. It isn’t exposed to the platform details.
     *
     *  - Open/Closed Principle. You can introduce new abstractions and implementations independently from each other.
     *
     *  - Single Responsibility Principle. You can focus on high-level logic in the abstraction and on platform
     *  details in the implementation.
     *
     *  Cons
     *   - You might make the code more complicated by applying the pattern to a highly cohesive class.
     *
     *
     *  Relations with Other Patterns
     *  - Bridge is usually designed up-front, letting you develop parts of an application independently of each other.
     *  On the other hand, Adapter is commonly used with an existing app to make some otherwise-incompatible classes work together nicely.
     *
     *  - Bridge, State, Strategy (and to some degree Adapter) have very similar structures. Indeed, all of these
     *  patterns are based on composition, which is delegating work to other objects. However, they all solve different problems.
     *  A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other developers
     *  the problem the pattern solves.
     *
     *  - You can use Abstract Factory along with Bridge. This pairing is useful when some abstractions defined by Bridge
     *  can only work with specific implementations. In this case, Abstract Factory can encapsulate these relations and
     *  hide the complexity from the client code.
     *
     *  - You can combine Builder with Bridge: the director class plays the role of the abstraction, while different
     *  builders act as implementations.
     *
     * @param args
     */
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
