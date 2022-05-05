package com.jjohnston.behavioral.mediator;

import com.jjohnston.behavioral.mediator.components.*;
import com.jjohnston.behavioral.mediator.mediator.Editor;
import com.jjohnston.behavioral.mediator.mediator.Mediator;

import javax.swing.*;

public class Demo {

    /**
     * Real-World Analogy
     *
     * Pilots of aircraft that approach or depart the airport control area don’t communicate directly with each other.
     * Instead, they speak to an air traffic controller, who sits in a tall tower somewhere near the airstrip.
     * Without the air traffic controller, pilots would need to be aware of every plane in the vicinity of the airport,
     * discussing landing priorities with a committee of dozens of other pilots. That would probably skyrocket the airplane crash statistics.
     *
     * The tower doesn’t need to control the whole flight. It exists only to enforce constraints in the terminal area
     * because the number of involved actors there might be overwhelming to a pilot.
     *
     * Pros
     *  - Single Responsibility Principle. You can extract the communications between various components into a single place, making it easier to comprehend and maintain.
     *  - Open/Closed Principle. You can introduce new mediators without having to change the actual components.
     *  - You can reduce coupling between various components of a program.
     *  - You can reuse individual components more easily.
     *
     * Cons
     *  - Over time a mediator can evolve into a God Object.
     *
     * Relations with Other Patterns
     *
     * - Chain of Responsibility, Command, Mediator and Observer address various ways of connecting senders and receivers of requests:
     *   - Chain of Responsibility passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.
     *   - Command establishes unidirectional connections between senders and receivers.
     *   - Mediator eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.
     *   - Observer lets receivers dynamically subscribe to and unsubscribe from receiving requests.
     *
     * - Facade and Mediator have similar jobs: they try to organize collaboration between lots of tightly coupled classes.
     *   - Facade defines a simplified interface to a subsystem of objects, but it doesn’t introduce any new functionality. The subsystem itself is unaware of the facade. Objects within the subsystem can communicate directly.
     *   - Mediator centralizes communication between components of the system. The components only know about the mediator object and don’t communicate directly.
     *
     * The difference between Mediator and Observer is often elusive. In most cases, you can implement either of these patterns; but sometimes you can apply both simultaneously. Let’s see how we can do that.
     * The primary goal of Mediator is to eliminate mutual dependencies among a set of system components. Instead, these components become dependent on a single mediator object. The goal of Observer is to establish dynamic one-way connections between objects, where some objects act as subordinates of others.
     * There’s a popular implementation of the Mediator pattern that relies on Observer. The mediator object plays the role of publisher, and the components act as subscribers which subscribe to and unsubscribe from the mediator’s events. When Mediator is implemented this way, it may look very similar to Observer.
     * When you’re confused, remember that you can implement the Mediator pattern in other ways. For example, you can permanently link all the components to the same mediator object. This implementation won’t resemble Observer but will still be an instance of the Mediator pattern.
     *
     * Now imagine a program where all components have become publishers, allowing dynamic connections between each other. There won’t be a centralized mediator object, only a distributed set of observers.
     * @param args
     */
    public static void main(String[] args) {
        Mediator mediator = new Editor();

        mediator.registerComponent(new Title());
        mediator.registerComponent(new TextBox());
        mediator.registerComponent(new AddButton());
        mediator.registerComponent(new DeleteButton());
        mediator.registerComponent(new SaveButton());
        mediator.registerComponent(new List(new DefaultListModel()));
        mediator.registerComponent(new Filter());

        mediator.createGUI();
    }
}
