package com.jjohnston.behavioral.strategy;

import com.jjohnston.behavioral.strategy.strategies.Order;
import com.jjohnston.behavioral.strategy.strategies.PayByCreditCard;
import com.jjohnston.behavioral.strategy.strategies.PayByPayPal;
import com.jjohnston.behavioral.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * The context maintains a reference to one of the strategy
 * objects. The context doesn't know the concrete class of a
 * strategy. It should work with all strategies via the
 * strategy interface.
 */
public class Demo {
    private static Map<Integer, Integer> priceOnProducts = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProducts.put(1, 2200);
        priceOnProducts.put(2, 1850);
        priceOnProducts.put(3, 1100);
        priceOnProducts.put(4, 890);
    }

    /**
     *  Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to
     *  switch from one algorithm to another during runtime.
     *
     *  The Strategy pattern lets you indirectly alter the object’s behavior at runtime by associating it with different
     *  sub-objects which can perform specific sub-tasks in different ways.
     *
     *  Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.
     *
     *  The Strategy pattern lets you extract the varying behavior into a separate class hierarchy and combine the original
     *  classes into one, thereby reducing duplicate code.
     *
     *  Use the pattern to isolate the business logic of a class from the implementation details of algorithms that may
     *  not be as important in the context of that logic.
     *
     *  The Strategy pattern lets you isolate the code, internal data, and dependencies of various algorithms from the
     *  rest of the code. Various clients get a simple interface to execute the algorithms and switch them at runtime.
     *
     *  Use the pattern when your class has a massive conditional operator that switches between different variants of
     *  the same algorithm.
     *
     *  The Strategy pattern lets you do away with such a conditional by extracting all algorithms into separate classes,
     *  all of which implement the same interface. The original object delegates execution to one of these objects, instead
     *  of implementing all variants of the algorithm.
     *
     *
     *  Pros
     *  - You can swap algorithms used inside an object at runtime.
     *  - You can isolate the implementation details of an algorithm from the code that uses it.
     *  - You can replace inheritance with composition.
     *  - Open/Closed Principle. You can introduce new strategies without having to change the context.
     *
     *  Cons
     *  - If you only have a couple of algorithms and they rarely change, there’s no real reason to overcomplicate the
     *  program with new classes and interfaces that come along with the pattern.
     *  - Clients must be aware of the differences between strategies to be able to select a proper one.
     *  - A lot of modern programming languages have functional type support that lets you implement different versions
     *  of an algorithm inside a set of anonymous functions. Then you could use these functions exactly as you’d have
     *  used the strategy objects, but without bloating your code with extra classes and interfaces.
     *
     *  Relations with Other Patterns
     *  - Bridge, State, Strategy (and to some degree Adapter) have very similar structures. Indeed, all of these patterns
     *  are based on composition, which is delegating work to other objects. However, they all solve different problems.
     *  A pattern isn’t just a recipe for structuring your code in a specific way. It can also communicate to other
     *  developers the problem the pattern solves.
     *
     *  - Command and Strategy may look similar because you can use both to parameterize an object with some action.
     *  However, they have very different intents.
     *    - You can use Command to convert any operation into an object. The operation’s parameters become fields of that
     *    object. The conversion lets you defer execution of the operation, queue it, store the history of commands,
     *    send commands to remote services, etc.
     *    - On the other hand, Strategy usually describes different ways of doing the same thing, letting you swap these
     *    algorithms within a single context class.
     *
     *  - Decorator lets you change the skin of an object, while Strategy lets you change the guts.
     *
     *  - Template Method is based on inheritance: it lets you alter parts of an algorithm by extending those parts in
     *  subclasses. Strategy is based on composition: you can alter parts of the object’s behavior by supplying it with
     *  different strategies that correspond to that behavior. Template Method works at the class level, so it’s static.
     *  Strategy works on the object level, letting you switch behaviors at runtime.
     *
     *  - State can be considered as an extension of Strategy. Both patterns are based on composition: they change the
     *  behavior of the context by delegating some work to helper objects. Strategy makes these objects completely
     *  independent and unaware of each other. However, State doesn’t restrict dependencies between concrete states,
     *  letting them alter the state of the context at will.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.print("Please, select a product:" + "\n" +
                        "1 - Mother board" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - HDD" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProducts.get(choice);
                System.out.print("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.print("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method:" + "\n" +
                        "1 - PalPay" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = reader.readLine();

                // Client creates different strategies based on input from user,
                // application configuration, etc.
                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            // Order object delegates gathering payment data to strategy object,
            // since only strategies know what data they need to process a
            // payment.
            order.processOrder(strategy);

            System.out.print("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                // Finally, strategy handles the payment.
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been successful.");
                } else {
                    System.out.println("FAIL! Please, check your data.");
                }
                order.setClosed();
            }
        }
    }
}