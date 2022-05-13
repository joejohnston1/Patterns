package com.jjohnston.behavioral.observer;

import com.jjohnston.behavioral.observer.editor.Editor;
import com.jjohnston.behavioral.observer.listeners.EmailNotificationListener;
import com.jjohnston.behavioral.observer.listeners.LogOpenListener;

public class Demo {

    /**
     * Use the Observer pattern when changes to the state of one object may require changing other objects,
     * and the actual set of objects is unknown beforehand or changes dynamically.
     *
     * You can often experience this problem when working with classes of the graphical user interface.
     * For example, you created custom button classes, and you want to let the clients hook some custom code to
     * your buttons so that it fires whenever a user presses a button.
     *
     * The Observer pattern lets any object that implements the subscriber interface subscribe for event
     * notifications in publisher objects. You can add the subscription mechanism to your buttons, letting
     * the clients hook up their custom code via custom subscriber classes.
     *
     * The object that has some interesting state is often called subject, but since it’s also going to notify other
     * objects about the changes to its state, we’ll call it publisher. All other objects that want to track changes
     * to the publisher’s state are called subscribers.
     *
     * The Observer pattern suggests that you add a subscription mechanism to the publisher class so individual objects
     * can subscribe to or unsubscribe from a stream of events coming from that publisher. Fear not! Everything isn’t
     * as complicated as it sounds. In reality, this mechanism consists of 1) an array field for storing a list of
     * references to subscriber objects and 2) several public methods which allow adding subscribers to and removing
     * them from that list.
     *
     * Pros
     * - Open/Closed Principle. You can introduce new subscriber classes without having to change the publisher’s
     * code (and vice versa if there’s a publisher interface).
     * - You can establish relations between objects at runtime.
     *
     * Cons
     * - Subscribers are notified in random order
     *
     * Relations with Other Patterns
     * - Chain of Responsibility, Command, Mediator and Observer address various ways of connecting senders and receivers of requests:
     *   - Chain of Responsibility passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.
     *   - Command establishes unidirectional connections between senders and receivers.
     *   - Mediator eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.
     *   - Observer lets receivers dynamically subscribe to and unsubscribe from receiving requests.
     *
     * - The difference between Mediator and Observer is often elusive. In most cases, you can implement either of these patterns;
     * but sometimes you can apply both simultaneously. Let’s see how we can do that.
     *
     * - The primary goal of Mediator is to eliminate mutual dependencies among a set of system components. Instead,
     * these components become dependent on a single mediator object. The goal of Observer is to establish dynamic one-way
     * connections between objects, where some objects act as subordinates of others.
     *
     * - There’s a popular implementation of the Mediator pattern that relies on Observer. The mediator object plays the
     * role of publisher, and the components act as subscribers which subscribe to and unsubscribe from the mediator’s events.
     * When Mediator is implemented this way, it may look very similar to Observer.
     *
     * - When you’re confused, remember that you can implement the Mediator pattern in other ways. For example, you can
     * permanently link all the components to the same mediator object. This implementation won’t resemble Observer but
     * will still be an instance of the Mediator pattern.
     *
     * - Now imagine a program where all components have become publishers, allowing dynamic connections between each other.
     * There won’t be a centralized mediator object, only a distributed set of observers.
     *
     * @param args
     */
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.events.subscribe("open", new LogOpenListener("/path/to/log/file.txt"));
        editor.events.subscribe("save", new EmailNotificationListener("admin@example.com"));

        try {
            editor.openFile("test.txt");
            editor.saveFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
