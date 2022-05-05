package com.jjohnston.behavioral.iterator;

import com.jjohnston.behavioral.iterator.profile.Profile;
import com.jjohnston.behavioral.iterator.socialnetworks.Facebook;
import com.jjohnston.behavioral.iterator.socialnetworks.LinkedIn;
import com.jjohnston.behavioral.iterator.socialnetworks.SocialNetwork;
import com.jjohnston.behavioral.iterator.spammer.SocialSpammer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static Scanner scanner = new Scanner(System.in);

    /**
     * Most collections store their elements in simple lists. However, some of them are based on stacks, trees, graphs and other complex data structures.
     * But no matter how a collection is structured, it must provide some way of accessing its elements so that other code can use these elements.
     * There should be a way to go through each element of the collection without accessing the same elements over and over.
     *
     * This may sound like an easy job if you have a collection based on a list. You just loop over all of the elements.
     * But how do you sequentially traverse elements of a complex data structure, such as a tree? For example, one day you might
     * be just fine with depth-first traversal of a tree. Yet the next day you might require breadth-first traversal.
     * And the next week, you might need something else, like random access to the tree elements.
     *
     * Real world analogy
     * You plan to visit Rome for a few days and visit all of its main sights and attractions. But once there, you could waste a lot of time walking in circles,
     * unable to find even the Colosseum.
     * On the other hand, you could buy a virtual guide app for your smartphone and use it for navigation. It’s smart and inexpensive, and you could be staying
     * at some interesting places for as long as you want.
     * A third alternative is that you could spend some of the trip’s budget and hire a local guide who knows the city like the back of his hand.
     * The guide would be able to tailor the tour to your likings, show you every attraction and tell a lot of exciting stories. That’ll be even more fun; but, alas, more expensive, too.
     * All of these options—the random directions born in your head, the smartphone navigator or the human guide—act as iterators over the vast collection of sights and attractions located in Rome.
     *
     *
     * Pros
     *  - Single Responsibility Principle. You can clean up the client code and the collections by extracting bulky traversal algorithms into separate classes.
     *  - Open/Closed Principle. You can implement new types of collections and iterators and pass them to existing code without breaking anything.
     *  - You can iterate over the same collection in parallel because each iterator object contains its own iteration state.
     *  - For the same reason, you can delay an iteration and continue it when needed.
     *
     * Cons
     *  - Applying the pattern can be an overkill if your app only works with simple collections.
     *  - Using an iterator may be less efficient than going through elements of some specialized collections directly.
     *
     * Relations with Other Patterns
     *  - You can use Iterators to traverse Composite trees.
     *  - You can use Factory Method along with Iterator to let collection subclasses return different types of iterators that are compatible with the collections.
     *  - You can use Memento along with Iterator to capture the current iteration state and roll it back if necessary.
     *  - You can use Visitor along with Iterator to traverse a complex data structure and execute some operation over its elements, even if they all have different classes.
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Please specify social network to target spam tool (default:Facebook):");
        System.out.println("1. Facebook");
        System.out.println("2. LinkedIn");
        String choice = scanner.nextLine();

        SocialNetwork network;
        if (choice.equals("2")) {
            network = new LinkedIn(createTestProfiles());
        }
        else {
            network = new Facebook(createTestProfiles());
        }

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("anna.smith@bing.com",
                "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?");
        spammer.sendSpamToCoworkers("anna.smith@bing.com",
                "Hey! This is Anna's boss Jason. Anna told me you would be interested in [link].");
    }

    public static List<Profile> createTestProfiles() {
        List<Profile> data = new ArrayList<Profile>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));
        return data;
    }
}
