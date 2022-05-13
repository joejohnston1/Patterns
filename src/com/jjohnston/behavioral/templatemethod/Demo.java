package com.jjohnston.behavioral.templatemethod;

import com.jjohnston.behavioral.templatemethod.networks.Facebook;
import com.jjohnston.behavioral.templatemethod.networks.Network;
import com.jjohnston.behavioral.templatemethod.networks.Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {


    /**
     *  Use the Template Method pattern when you want to let clients extend only particular steps of an algorithm,
     *  but not the whole algorithm or its structure.
     *
     *  The Template Method lets you turn a monolithic algorithm into a series of individual steps which can be easily
     *  extended by subclasses while keeping intact the structure defined in a superclass.
     *
     *  Use the pattern when you have several classes that contain almost identical algorithms with some minor differences.
     *  As a result, you might need to modify all classes when the algorithm changes.
     *
     *  When you turn such an algorithm into a template method, you can also pull up the steps with similar implementations
     *  into a superclass, eliminating code duplication. Code that varies between subclasses can remain in subclasses.
     *
     * Pros
     * - You can let clients override only certain parts of a large algorithm, making them less affected by changes that
     * happen to other parts of the algorithm.
     * - You can pull the duplicate code into a superclass.
     *
     * Cons
     * - Some clients may be limited by the provided skeleton of an algorithm.
     * - You might violate the Liskov Substitution Principle by suppressing a default step implementation via a subclass.
     * - Template methods tend to be harder to maintain the more steps they have.
     *
     * Relations with Other Patterns
     * - Factory Method is a specialization of Template Method. At the same time, a Factory Method may serve as a step in a large Template Method.
     * - Template Method is based on inheritance: it lets you alter parts of an algorithm by extending those parts in subclasses.
     * Strategy is based on composition: you can alter parts of the object’s behavior by supplying it with different strategies
     * that correspond to that behavior. Template Method works at the class level, so it’s static. Strategy works on the object
     * level, letting you switch behaviors at runtime.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input password: ");
        String password = reader.readLine();

        // Enter the message.
        System.out.print("Input message: ");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choice = Integer.parseInt(reader.readLine());

        // Create proper network object and send the message.
        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}
