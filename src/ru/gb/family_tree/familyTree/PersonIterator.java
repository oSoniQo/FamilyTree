package ru.gb.family_tree.familyTree;

import ru.gb.family_tree.person.Person;

import java.util.Iterator;
import java.util.List;

public class PersonIterator implements Iterator<Person> {
    private int index;
    private List<Person> members;

    public PersonIterator(List<Person> members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public Person next() {
        return members.get(index++);
    }
}

