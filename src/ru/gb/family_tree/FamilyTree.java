package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
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
}