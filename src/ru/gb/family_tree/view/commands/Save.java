package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Save extends ExecutableCommand {
    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить древо";
    }

    public void execute() {
        consoleUI.save();
    }
}
