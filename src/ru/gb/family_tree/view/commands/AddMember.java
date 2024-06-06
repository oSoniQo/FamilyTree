package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddMember extends ExecutableCommand {
    public AddMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека";
    }

    public void execute() {
        consoleUI.addMember();
    }
}
