package com.jjohnston.structural.composite;

/**
 * The leaf does not contain any children. Another approach is to think of a leaf as a zero child composite,
 * but it may lead to unimplemented interface methods.
 *
 * The leaf class represents end objects of a composition. A
 * leaf object can't have any sub-objects. Usually, it's leaf
 * objects that do the actual work, while composite objects only
 * delegate to their sub-components.
 */
public class MenuLeaf implements IMenuComponent {

    private String name;
    private String description;
    private boolean vegetarian;
    private double price;

    public MenuLeaf(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void print() {
        System.out.print("  " + getName());
        if (isVegetarian()) {
            System.out.print("(v)");
        }
        System.out.print(",  " + getPrice());
        System.out.println("  -- " + getDescription());
    }
}
