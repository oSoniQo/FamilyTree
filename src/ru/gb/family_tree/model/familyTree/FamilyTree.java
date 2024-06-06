package ru.gb.family_tree.model.familyTree;

import ru.gb.family_tree.model.person.comparators.PersonComparatorByBirthDate;
import ru.gb.family_tree.model.person.comparators.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private int personId;
    private List<E> members;
    public FamilyTree(ArrayList<E> members) {
        this.members = members;
    }
    public FamilyTree() {
        this(new ArrayList<E>());
    }
    public void addMember(E member) {
        members.add(member);
        member.setId(personId++);
    }
    public void removeMemberByName(String name) {
        members.remove(findMemberByName(name));
    }
    public E findMemberByName(String name) {
        for (E member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E member : members) {
            stringBuilder.append(member.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(members);
    }
    public void sortByName(){
        members.sort(new PersonComparatorByName<>());
    }

    public void sortByBirthDate(){
        members.sort(new PersonComparatorByBirthDate<>());
    }

    public E findMemberById(int id) {
        for ( E person : members) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }
}