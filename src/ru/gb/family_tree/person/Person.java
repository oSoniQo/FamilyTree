package ru.gb.family_tree.person;

import ru.gb.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable, Comparable<Person>, FamilyTreeItem<Person> {
    private String name;
    private Person mother, father;
    private List<Person> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private Person spouse;
    public Person(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Person mother, Person father, List<Person> children) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }
    public Person(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null, new ArrayList<Person>());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public List<Person> getChildren() {
        return children;
    }


    public void setChildren(List<Person> children) {
        this.children = children;
    }
    public void addChild(Person child) {
        this.children.add(child);
    }

    public Person getSpouse() {
        return spouse;
    }


    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }

    public Person findChildByName(String name) {
        for (Person child : this.children) {
            if (child.getName().equalsIgnoreCase(name)) {
                return child;
            }
        }
        return null;
    }
    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        else {
            return getPeriod(birthDate, deathDate);
        }
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period difference = Period.between(birthDate, deathDate);
        return difference.getYears();
    }
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        sb.append(name);
        sb.append(", gender: ");
        sb.append(gender);
        sb.append(", age:");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        sb.append(", ");
        sb.append(getSpouseInfo());
        return sb.toString();
    }
    public String getSpouseInfo(){
        String res = "spouse: ";
        if (spouse == null){
            res+= "no";
        }
        else {
            res+=spouse.getName();
        }
        return res;
        }
    public String getMotherInfo(){
        String res = "mother: ";
        if (mother == null){
            res+= "no";
        }
        else {
            res+=mother.getName();
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "father: ";
        if (father == null){
            res+= "no";
        }
        else {
            res+=father.getName();
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("children: ");
        if (children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }
        else {
            res.append("no");
        }
        return res.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }
}