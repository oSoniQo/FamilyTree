package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.fileHandler.FileHandler;
import ru.gb.family_tree.model.person.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler<>());
    }

    public void addMember(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        service.addMember(name, gender, birthDate, deathDate);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String info = service.getFamilyTreeInfo();
        view.printMessage(info);
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }
    public void setFather(int fatherId, int choiceId) {
        service.setFather(fatherId, choiceId);
    }
    public void setMother(int motherId, int choiceId) {
        service.setMother(motherId, choiceId);
    }
    public void setSpouse(int spouseId, int choiceId) {
        service.setSpouse(spouseId, choiceId);
    }
    public void addChild(int childId, int choiceId) {
        service.addChild(childId, choiceId);
    }

    public void save() throws Exception {
        service.save();
    }
    public void load() throws Exception {
        service.load();
    }
}
