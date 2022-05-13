package com.jjohnston.behavioral.observer.listeners;

import java.io.File;

/**
 * Concrete subscribers react to updates issued by the publisher
 * they are attached to.
 */
public class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType + " operation with the following file: " + file.getName());
    }
}
