package com.jjohnston.behavioral.chainofresponsibility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Use the Chain of Responsibility pattern when your program is expected to process different kinds of requests in
 * various ways, but the exact types of requests and their sequences are unknown beforehand.
 *
 * The pattern lets you link several handlers into one chain and, upon receiving a request, “ask” each handler
 * whether it can process it. This way all handlers get a chance to process the request.
 *
 * Pros
 * - You can control the order of request handling.
 * - Single Responsibility Principle. You can decouple classes that invoke operations from classes that perform operations.
 * - Open/Closed Principle. You can introduce new handlers into the app without breaking the existing client code.
 *
 * Relations with Other Patterns
 *
 * - Chain of Responsibility, Command, Mediator and Observer address various ways of connecting senders and receivers of requests:
 *   - Chain of Responsibility passes a request sequentially along a dynamic chain of potential receivers until one of them handles it.
 *   - Command establishes unidirectional connections between senders and receivers.
 *   - Mediator eliminates direct connections between senders and receivers, forcing them to communicate indirectly via a mediator object.
 *   - Observer lets receivers dynamically subscribe to and unsubscribe from receiving requests.
 *
 * - Chain of Responsibility is often used in conjunction with Composite. In this case, when a leaf component gets a request,
 * it may pass it through the chain of all of the parent components down to the root of the object tree.
 *
 * - Handlers in Chain of Responsibility can be implemented as Commands. In this case, you can execute a lot of different operations over
 *   the same context object, represented by a request.
 *   However, there’s another approach, where the request itself is a Command object. In this case, you can execute the same operation in a
 *   series of different contexts linked into a chain.
 *
 * - Chain of Responsibility and Decorator have very similar class structures. Both patterns rely on recursive composition to
 * pass the execution through a series of objects. However, there are several crucial differences.
 *
 * - The CoR handlers can execute arbitrary operations independently of each other. They can also stop passing the request
 * further at any point. On the other hand, various Decorators can extend the object’s behavior while keeping it consistent
 * with the base interface. In addition, decorators aren’t allowed to break the flow of the request.
 */
public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        Middleware middleware = new ThrottlingMiddleware(2);
        middleware.linkWith(new UserExistsMiddleware(server))
                .linkWith(new RoleCheckMiddleware());

        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.readLine();
            System.out.print("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
