package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetFamilyTreeInfo extends ExecutableCommand {
    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список родственников";
    }

    public void execute(){
        consoleUI.getFamilyTreeInfo();
    }

}
