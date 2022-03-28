package com.jjohnston.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * The Composite contains a list of leaf nodes.
 * The add and remove could be added to the interface to allow the leaf act as
 * a 'zero' leaf composite, but are segregated for a cleaner solution.
 */
public class MenuComposite implements IMenuComponent {

    private List<IMenuComponent> menuComponents = new ArrayList<>();
    private String name;
    private String description;

    public MenuComposite(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(IMenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(IMenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public IMenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.print(", " + getDescription());
        System.out.println("\n-------------------------");

        menuComponents.forEach(IMenuComponent::print);
    }
}
