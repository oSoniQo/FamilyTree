package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SetMother extends ExecutableArgCommand {
    public SetMother(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить мать";
    }

    public void execute(int choiceId) {

        consoleUI.setMother(choiceId);
    }
}
