package com.jjohnston.behavioral.iterator.iterators;

import com.jjohnston.behavioral.iterator.profile.Profile;

/**
 * The common interface for all iterators.
 */
public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();

    void reset();
}
