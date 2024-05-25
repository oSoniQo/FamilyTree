package ru.gb.family_tree.person.comparators;

import ru.gb.family_tree.person.Person;

import java.util.Comparator;

public class PersonComparatorByBirthDate implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getBirthDate().isBefore(o2.getBirthDate())) {
            return -1;
        }
        else if (o1.getBirthDate().isAfter(o2.getBirthDate())) {
            return 1;
        }
        return 0;
    }
}

