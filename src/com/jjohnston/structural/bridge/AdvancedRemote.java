package com.jjohnston.structural.bridge;

/**
 * You can extend classes from the abstraction hierarchy
 * independently from device classes.
 */
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
