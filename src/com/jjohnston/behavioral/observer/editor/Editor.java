package com.jjohnston.behavioral.observer.editor;

import com.jjohnston.behavioral.observer.publisher.EventManager;

import java.io.File;

/**
 * The concrete publisher contains real business logic that's
 * interesting for some subscribers. We could derive this class
 * from the base publisher, but that isn't always possible in
 * real life because the concrete publisher might already be a
 * subclass. In this case, you can patch the subscription logic
 * in with composition, as we did here.
 */
public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    /**
     * Methods of business logic can notify subscribers about changes.
     * @param filePath
     */
    public void openFile(String filePath) {
        this.file = new File(filePath);
        events.notify("open", file);
    }

    /**
     * Methods of business logic can notify subscribers about changes.
     */
    public void saveFile() throws Exception {
        if (this.file != null) {
            events.notify("save", file);
        } else {
            throw new Exception("Please open a file first.");
        }
    }
}
