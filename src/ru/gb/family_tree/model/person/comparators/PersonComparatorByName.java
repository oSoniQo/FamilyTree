package ru.gb.family_tree.model.person.comparators;

import ru.gb.family_tree.model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class PersonComparatorByName<T extends FamilyTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
