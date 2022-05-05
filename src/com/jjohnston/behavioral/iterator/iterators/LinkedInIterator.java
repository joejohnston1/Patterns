package com.jjohnston.behavioral.iterator.iterators;

import com.jjohnston.behavioral.iterator.socialnetworks.LinkedIn;
import com.jjohnston.behavioral.iterator.profile.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * The concrete iterator class.
 */
public class LinkedInIterator implements ProfileIterator {

    // The iterator needs a reference to the collection that it
    // traverses.
    private LinkedIn linkedIn;
    private String type;
    private String email;

    // An iterator object traverses the collection independently
    // from other iterators. Therefore it has to store the
    // iteration state.
    private int currentPosition = 0;
    private List<String> emails = new ArrayList<>();
    private List<Profile> contacts = new ArrayList<>();

    public LinkedInIterator(LinkedIn linkedIn, String type, String email) {
        this.linkedIn = linkedIn;
        this.type = type;
        this.email = email;
    }

    private void lazyLoad() {
        if (emails.size() == 0) {
            List<String> profiles = linkedIn.requestRelatedContactsFromLinkedInAPI(this.email, this.type);
            for (String profile : profiles) {
                this.emails.add(profile);
                this.contacts.add(null);
            }
        }
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < emails.size();
    }

    /**
     * Each concrete iterator class has its own implementation
     * of the common iterator interface.
     *
     * @return
     */
    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }

        String friendEmail = emails.get(currentPosition);
        Profile friendContact = contacts.get(currentPosition);
        if (friendContact == null) {
            friendContact = linkedIn.requestContactInfoFromLinkedInAPI(friendEmail);
            contacts.set(currentPosition, friendContact);
        }
        currentPosition++;
        return friendContact;
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}
