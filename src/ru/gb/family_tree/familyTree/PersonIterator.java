package ru.gb.family_tree.familyTree;

import java.util.Iterator;
import java.util.List;

public class PersonIterator<T extends FamilyTreeItem> implements Iterator<T> {
    private int index;
    private List<T> members;

    public PersonIterator(List<T> members) {
        this.members = members;
    }

    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public T next() {
        return members.get(index++);
    }
}

