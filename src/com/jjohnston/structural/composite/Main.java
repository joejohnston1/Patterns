package com.jjohnston.structural.composite;

public class Main {

    /**
     * The client code works with all the components via their base
     * interface. This way the client code can support simple leaf
     * components as well as complex composites.
     *
     * Pros
     *  - You can work with complex tree structures more conveniently: use polymorphism and recursion to your advantage.
     *  - Open/Closed Principle. You can introduce new element types into the app without breaking the existing code,
     *  which now works with the object tree.
     *
     *  Cons
     *  - It might be difficult to provide a common interface for classes whose functionality differs too much.
     *  In certain scenarios, you’d need to overgeneralize the component interface, making it harder to comprehend.
     *
     *  Relations with Other Patterns
     *  - You can use Builder when creating complex Composite trees because you can program its construction steps to work recursively.
     *
     *  - Chain of Responsibility is often used in conjunction with Composite. In this case, when a leaf component gets a request,
     *  it may pass it through the chain of all of the parent components down to the root of the object tree.
     *
     *  - You can use Iterators to traverse Composite trees.
     *
     *  - You can use Visitor to execute an operation over an entire Composite tree.
     *
     *  - You can implement shared leaf nodes of the Composite tree as Flyweights to save some RAM.
     *
     *  - Composite and Decorator have similar structure diagrams since both rely on recursive composition to organize an open-ended number of objects.
     *  A Decorator is like a Composite but only has one child component. There’s another significant difference:
     *  Decorator adds additional responsibilities to the wrapped object, while Composite just “sums up” its children’s results.
     *  However, the patterns can also cooperate: you can use Decorator to extend the behavior of a specific object in the Composite tree.
     *
     *  - Designs that make heavy use of Composite and Decorator can often benefit from using Prototype.
     *  Applying the pattern lets you clone complex structures instead of re-constructing them from scratch.
     *
     * @param args
     */
    public static void main(String[] args) {

        var pancakeHouseMenu = new MenuComposite("Pancake house menu", "Breakfast");
        var dinerMenu = new MenuComposite("Diner menu", "Lunch");
        var cafeMenu = new MenuComposite("Cafe menu", "Dinner");
        var dessertMenu = new MenuComposite("Dessert menu", "Dessert of course!");

        var allMenus = new MenuComposite("All menus", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // add menu items
        pancakeHouseMenu.add(new MenuLeaf("Strawberries", "Pancakes with strawberries", true, 3.89));
        pancakeHouseMenu.add(new MenuLeaf("Syrup", "Pancakes with syrup", false, 3.40));

        dinerMenu.add(new MenuLeaf("Pasta", "Spaghetti with Marinara sauce and a slice of sourdough bread", true, 3.89));
        dinerMenu.add(new MenuLeaf("Rice", "Chicken curry with rice", true, 3.40));

        cafeMenu.add(new MenuLeaf("Tea", "Tea with scone", true, 3.89));
        cafeMenu.add(new MenuLeaf("Coffee", "Coffee with scone", false, 3.40));

        // add a menu to a menu
        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuLeaf("Cake", "A slice of cake", false, 3.40));

        var waitress = new Waitress(allMenus);
        waitress.printMenu();

    }
}
