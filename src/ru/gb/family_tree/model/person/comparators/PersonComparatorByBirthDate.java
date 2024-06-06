package ru.gb.family_tree.model.person.comparators;

import ru.gb.family_tree.model.familyTree.FamilyTreeItem;

import java.util.Comparator;

public class PersonComparatorByBirthDate<T extends FamilyTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1.getBirthDate().isBefore(o2.getBirthDate())) {
            return -1;
        }
        else if (o1.getBirthDate().isAfter(o2.getBirthDate())) {
            return 1;
        }
        return 0;
    }
}

