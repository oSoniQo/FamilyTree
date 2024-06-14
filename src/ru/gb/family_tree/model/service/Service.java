package ru.gb.family_tree.model.service;

import org.w3c.dom.ls.LSOutput;
import ru.gb.family_tree.model.familyTree.FamilyTree;
import ru.gb.family_tree.model.fileHandler.FileHandler;
import ru.gb.family_tree.model.fileHandler.FileWritable;
import ru.gb.family_tree.model.person.Gender;
import ru.gb.family_tree.model.person.Person;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private int idPerson;
    private FamilyTree<Person> members;

    private FileWritable<Person> fileWritable;

    public Service(FileWritable<Person> fileWritable) {
        this.fileWritable = fileWritable;
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
        if (members.findMemberById(fatherId) != null || members.findMemberById(choiceId) != null) {
            members.findMemberById(choiceId).setFather(members.findMemberById(fatherId));
        }
    }
    public void setMother(int motherId, int choiceId) {
        if (members.findMemberById(motherId) != null || members.findMemberById(choiceId) != null) {
            members.findMemberById(choiceId).setMother(members.findMemberById(motherId));
        }
    }
    public void setSpouse(int spouseId, int choiceId) {
        if (members.findMemberById(spouseId) != null || members.findMemberById(choiceId) != null) {
            members.findMemberById(choiceId).setSpouse(members.findMemberById(spouseId));
        }
    }
    public void addChild(int childId, int choiceId) {
        if (members.findMemberById(childId) != null || members.findMemberById(choiceId) != null) {
            members.findMemberById(choiceId).addChild(members.findMemberById(childId));
        }
    }
    public void save() throws Exception {
        fileWritable.save(members);
    }
    public void load() throws Exception {
        members = fileWritable.load();
    }


}
