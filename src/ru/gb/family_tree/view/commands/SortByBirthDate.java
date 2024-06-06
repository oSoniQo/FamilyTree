package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SortByBirthDate extends ExecutableCommand {
    public SortByBirthDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по дате рождения";
    }

    public void execute(){
        consoleUI.sortByBirthDate();
    }
}
