package ru.gb.family_tree.familyTree;

import ru.gb.family_tree.person.Gender;
import ru.gb.family_tree.person.Person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface FamilyTreeItem<T> extends Comparable<T>, Serializable {
    String getName();

    void setName(String name);

    LocalDate getBirthDate();

    void setBirthDate(LocalDate birthDate);

    LocalDate getDeathDate();

    void setDeathDate(LocalDate deathDate);

    Gender getGender();

    void setGender(Gender gender);


    int getAge();


    String getInfo();

    String getSpouseInfo();

    String getMotherInfo();

    String getFatherInfo();

    String getChildrenInfo();

    void setMother(T mother);

    T getMother();
    void setFather(T father);

    T getFather();
    List<T> getChildren();


    void setChildren(List<T> children);
    void addChild(T child);

    T getSpouse();


    void setSpouse(T spouse);
    T findChildByName(String name);

}

