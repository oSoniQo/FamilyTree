package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class SetFamilyConnections extends ExecutableCommand {
    public SetFamilyConnections(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить семейные связи";
    }

    public void execute(){
        consoleUI.setFamilyConnections();
    }
}

