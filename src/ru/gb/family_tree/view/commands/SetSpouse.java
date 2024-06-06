package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SetSpouse extends ExecutableArgCommand {
    public SetSpouse(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить супруга(у)";
    }

    public void execute(int choiceId) {

        consoleUI.setSpouse(choiceId);
    }
}
