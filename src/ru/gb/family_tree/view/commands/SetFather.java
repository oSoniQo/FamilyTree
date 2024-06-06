package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SetFather extends ExecutableArgCommand {
    public SetFather(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить отца";
    }
    public void execute(int choiceId) {
        consoleUI.setFather(choiceId);
    }
}

