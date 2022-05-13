package com.jjohnston.behavioral.templatemethod.networks;

/**
 * The abstract class defines a template method that contains a
 * skeleton of some algorithm composed of calls, usually to
 * abstract primitive operations. Concrete subclasses implement
 * these operations, but leave the template method itself
 * intact.
 */
public abstract class Network {
    String userName;
    String password;

    Network() {}

    /**
     * Publish the data to whatever network.
     */
    public boolean post(String message) {
        // Authenticate before posting. Every network uses a different
        // authentication method.
        // The template method defines the skeleton of an algorithm.
        if (logIn(this.userName, this.password)) {
            // Send the post data.
            boolean result =  sendData(message.getBytes());
            logOut();
            return result;
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract boolean sendData(byte[] data);
    abstract void logOut();
}
