package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.familyTree.FamilyTree;
import ru.gb.family_tree.model.fileHandler.FileHandler;
import ru.gb.family_tree.model.person.Gender;
import ru.gb.family_tree.model.person.Person;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private int idPerson;
    private FamilyTree<Person> members;

    private FileHandler<Person> fileHandler;

    public Service() {
        fileHandler = new FileHandler<>();
        members = new FamilyTree<>();
    }

    public void addMember(String name, Gender gender, LocalDate  birthDate, LocalDate deathDate){
        Person person = new Person(idPerson++, name, gender, birthDate, deathDate);
        members.addMember(person);
    }

    public String getFamilyTreeInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Семейное древо:\n");
        for (Person person: members){
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        members.sortByName();
    }

    public void sortByBirthDate(){
        members.sortByBirthDate();
    }

    public void setFather(int fatherId, int choiceId) {
        try {
            members.findMemberById(choiceId).setFather(members.findMemberById(fatherId));
        }
        catch (Exception ignored) {
        }
    }
    public void setMother(int motherId, int choiceId) {
        try {
            members.findMemberById(choiceId).setMother(members.findMemberById(motherId));
        }
        catch (Exception ignored) {
        }
    }
    public void setSpouse(int spouseId, int choiceId) {
        try {
            members.findMemberById(choiceId).setSpouse(members.findMemberById(spouseId));
        }
        catch (Exception ignored) {
        }
    }
    public void addChild(int childId, int choiceId) {
        try {
            members.findMemberById(choiceId).addChild(members.findMemberById(childId));
        }
        catch (Exception ignored) {
        }
    }
    public void save() {
        try {
            fileHandler.save(members);
        } catch (Exception ignored) {
        }
    }
    public void load() {
        try {
            members = fileHandler.load();
        }
        catch (Exception ignored) {
        }
    }


}
