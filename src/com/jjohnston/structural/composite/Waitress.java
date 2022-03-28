package com.jjohnston.structural.composite;

public class Waitress {

    private IMenuComponent allMenus;

    public Waitress(IMenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
