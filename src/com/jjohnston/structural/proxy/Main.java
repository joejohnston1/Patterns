package com.jjohnston.structural.proxy;

public class Main {

    /**
     * The application can configure proxies on the fly.
     *
     * Pros
     *  - You can control the service object without clients knowing about it.
     *  - You can manage the lifecycle of the service object when clients don’t care about it.
     *  - The proxy works even if the service object isn’t ready or is not available.
     *  - Open/Closed Principle. You can introduce new proxies without changing the service or clients.
     *
     *  Cons
     *  - The code may become more complicated since you need to introduce a lot of new classes.
     *  - The response from the service might get delayed.
     *
     *  Relations with Other Patterns
     *  - Adapter provides a different interface to the wrapped object, Proxy provides it with the same interface,
     *  and Decorator provides it with an enhanced interface.
     *
     *  - Facade is similar to Proxy in that both buffer a complex entity and initialize it on its own.
     *  Unlike Facade, Proxy has the same interface as its service object, which makes them interchangeable.
     *
     *  - Decorator and Proxy have similar structures, but very different intents.
     *  Both patterns are built on the composition principle, where one object is supposed to delegate some of the work to another.
     *  The difference is that a Proxy usually manages the life cycle of its service object on its own,
     *  whereas the composition of Decorators is always controlled by the client.
     *
     * @param args
     */
    public static void main(String[] args) {

        var youTubeService = new ThirdPartyYouTubeLibrary();

        var youTubeProxy = new CachedYouTubeController(youTubeService);

        var manager = new YouTubeManager(youTubeProxy);
        manager.reactOnUserInput("1");

        System.out.println("--------------------");

        manager.reactOnUserInput("1");

        System.out.println("--------------------");

        manager.reactOnUserInput("2");
    }
}
