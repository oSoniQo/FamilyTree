package ru.gb.family_tree.familyTree;

import ru.gb.family_tree.person.Person;
import ru.gb.family_tree.person.comparators.PersonComparatorByBirthDate;
import ru.gb.family_tree.person.comparators.PersonComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Serializable, Iterable<Person> {
    private List<Person> members;
    public FamilyTree(ArrayList<Person> members) {
        this.members = members;
    }
    public FamilyTree() {
        this(new ArrayList<Person>());
    }
    public void addMember(Person member) {
        members.add(member);
    }
    public void removeMemberByName(String name) {
        members.remove(findMemberByName(name));
    }
    public Person findMemberByName(String name) {
        for (Person member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Person member : members) {
            stringBuilder.append(member.toString()+"\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(members);
    }
    public void sortByName(){
        members.sort(new PersonComparatorByName());
    }

    public void sortByBirthDate(){
        members.sort(new PersonComparatorByBirthDate());
    }
}