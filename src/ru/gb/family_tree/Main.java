package ru.gb.family_tree;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

public class Main implements Serializable {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();
        Person person1 = new Person("Joe", Gender.Male, LocalDate.of(1990, 1, 8));
        Person person2 = new Person("Mary", Gender.Female, LocalDate.of(1995, 5, 21));
        Person person3 = new Person("David", Gender.Male, LocalDate.of(2020, 7, 15));
        familyTree.addMember(person1);
        familyTree.addMember(person2);
        familyTree.addMember(person3);
        person3.setFather(person1);
        person3.setMother(person2);
        person1.setSpouse(person2);
        person2.setSpouse(person1);
        person1.addChild(person3);
        System.out.println(familyTree);
        System.out.println(person1);
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
        System.out.println(fileHandler.load());



    }
}