package com.jjohnston.structural.bridge;

/**
 * The "implementation" interface declares methods common to all
 * concrete implementation classes. It doesn't have to match the
 * abstraction's interface. In fact, the two interfaces can be
 * entirely different. Typically the implementation interface
 * provides only primitive operations, while the abstraction
 * defines higher-level operations based on those primitives.
 */
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}
