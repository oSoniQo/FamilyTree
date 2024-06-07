package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Load extends ExecutableCommand {
    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить древо";
    }

    public void execute() {
        consoleUI.load();
    }
}
