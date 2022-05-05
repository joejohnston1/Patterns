package com.jjohnston.behavioral.mediator.components;

import com.jjohnston.behavioral.mediator.mediator.Mediator;

/**
 * Components communicate with a mediator using the mediator
 * interface. Thanks to that, you can use the same components in
 * other contexts by linking them with different mediator
 * objects.
 */
public interface Component {
    void setMediator(Mediator mediator);
    String getName();
}
