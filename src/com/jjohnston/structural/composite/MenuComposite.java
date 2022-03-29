package com.jjohnston.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * The Composite contains a list of leaf nodes.
 * The add and remove could be added to the interface to allow the leaf act as
 * a 'zero' leaf composite, but are segregated for a cleaner solution.
 *
 * The composite class represents complex components that may
 * have children. Composite objects usually delegate the actual
 * work to their children and then "sum up" the result.
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

    /**
     *  A composite executes its primary logic in a particular
     *  way. It traverses recursively through all its children,
     *  collecting and summing up their results. Since the
     *  composite's children pass these calls to their own
     *  children and so forth, the whole object tree is traversed
     *  as a result.
     */
    @Override
    public void print() {
        System.out.print("\n" + getName());
        System.out.print(", " + getDescription());
        System.out.println("\n-------------------------");

        menuComponents.forEach(IMenuComponent::print);
    }
}
