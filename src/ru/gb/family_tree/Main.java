package ru.gb.family_tree;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();



    }
}