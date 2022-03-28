package com.jjohnston.structural.composite;

public class Main {

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
        pancakeHouseMenu.add(new MenuItem("Strawberries", "Pancakes with strawberries", true, 3.89));
        pancakeHouseMenu.add(new MenuItem("Syrup", "Pancakes with syrup", false, 3.40));

        dinerMenu.add(new MenuItem("Pasta", "Spaghetti with Marinara sauce and a slice of sourdough bread", true, 3.89));
        dinerMenu.add(new MenuItem("Rice", "Chicken curry with rice", true, 3.40));

        cafeMenu.add(new MenuItem("Tea", "Tea with scone", true, 3.89));
        cafeMenu.add(new MenuItem("Coffee", "Coffee with scone", false, 3.40));

        // add a menu to a menu
        dinerMenu.add(dessertMenu);
        dessertMenu.add(new MenuItem("Cake", "A slice of cake", false, 3.40));

        var waitress = new Waitress(allMenus);
        waitress.printMenu();

    }
}
