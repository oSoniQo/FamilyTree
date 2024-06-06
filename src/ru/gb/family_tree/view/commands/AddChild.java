package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddChild extends ExecutableArgCommand {
    public AddChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка";
    }

    public void execute(int choiceId) {

        consoleUI.addChild(choiceId);
    }
}
