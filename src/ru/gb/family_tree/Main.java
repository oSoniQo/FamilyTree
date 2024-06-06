package ru.gb.family_tree;

import ru.gb.family_tree.model.familyTree.FamilyTree;
import ru.gb.family_tree.model.fileHandler.FileHandler;
import ru.gb.family_tree.model.person.Gender;
import ru.gb.family_tree.model.person.Person;
import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        View view = new ConsoleUI();
        view.start();



    }
}