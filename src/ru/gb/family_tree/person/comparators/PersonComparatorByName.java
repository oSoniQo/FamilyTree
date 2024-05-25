package ru.gb.family_tree.person.comparators;

import ru.gb.family_tree.person.Person;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
