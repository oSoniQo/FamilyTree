package ru.gb.family_tree.view;

import ru.gb.family_tree.model.person.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Введено неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu1;
    private AdditionalMenu menu2;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        menu1 = new MainMenu(this);
        menu2 = new AdditionalMenu(this);
        work = true;
    }

    public void printMessage(String text) {
        System.out.println(text);
    }

    public void start() {
        greetings();
        while (work){
            printMenu(menu1);
            execute();
        }
    }

    public void finish() {
        System.out.println("Работа программы завершена");
        work = false;
    }
    private void greetings(){
        System.out.println("Добро пожаловать в виртуальное семейное древо");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand, menu1)){
                menu1.execute(numCommand);
            }
        }
    }
    private void executeAdditional(String id) {
        String line = scanner.nextLine();
        if (checkTextForInt(line) && checkTextForInt(id)) {
            int numCommand = Integer.parseInt(line);
            int personId = Integer.parseInt(id);
            if (checkCommand(numCommand, menu2)){
                menu2.setChoiceId(personId);
                menu2.execute(numCommand);
            }
        }
    }
    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand, Menu menu){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(Menu menu){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyTreeInfo() { presenter.getFamilyTreeInfo(); }

    public void setFather(int choiceId) {
        System.out.println("Укажите id отца");
        String id = scanner.nextLine();
        if (checkTextForInt(id)) {
            int fatherId = Integer.parseInt(id);
            presenter.setFather(fatherId, choiceId);
        }
        else {
            inputError();
        }

    }
    public void setMother(int choiceId) {
        System.out.println("Укажите id матери");
        String id = scanner.nextLine();
        if (checkTextForInt(id)) {
            int motherId = Integer.parseInt(id);
            presenter.setMother(motherId, choiceId);
        }
        else {
            inputError();
        }
    }
    public void setSpouse(int choiceId) {
        System.out.println("Укажите id супруга(и)");
        String id = scanner.nextLine();
        if (checkTextForInt(id)) {
            int spouseId = Integer.parseInt(id);
            presenter.setSpouse(spouseId, choiceId);
        }
        else {
            inputError();
        }
    }
    public void addChild(int choiceId) {
        System.out.println("Укажите id ребенка");
        String id = scanner.nextLine();
        if (checkTextForInt(id)) {
            int childId = Integer.parseInt(id);
            presenter.addChild(childId, choiceId);
        }
        else {
            inputError();
        }
    }


    public void addMember() {
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Укажите пол человека ( m или f )");
        String genderString = scanner.nextLine();
        Gender gender;
        if (Objects.equals(genderString, "m")) {
            gender = Gender.Male;
        }
        else if (Objects.equals(genderString, "f")) {
            gender = Gender.Female;
        }
        else {
            inputError();
            gender = null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthDate, deathDate;
        System.out.println("Укажите дату рождения в формате dd.MM.yyyy");
        String birthDateString = scanner.nextLine();
        try {
            birthDate = LocalDate.parse(birthDateString, formatter);
        }
        catch (Exception e) {
            birthDate = null;
            inputError();
        }
        System.out.println("Укажите дату смерти");
        String deathDateString = scanner.nextLine();
        try {
            deathDate = LocalDate.parse(deathDateString, formatter);
        }
        catch (Exception e) {
            deathDate = null;
            inputError();
        }

        presenter.addMember(name, gender, birthDate, deathDate);
    }

    public void setFamilyConnections() {
        System.out.println("Выберите человека");
        String personId = scanner.nextLine();
        printMenu(menu2);
        executeAdditional(personId);
        printMenu(menu2);
    }
}
