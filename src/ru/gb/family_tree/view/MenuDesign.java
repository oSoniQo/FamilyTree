package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.Command;

import java.util.List;

public abstract class MenuDesign<T extends Command> {
    List<T> commandList;
    public MenuDesign(List<T> commandList) {
        this.commandList = commandList;
    }
    public abstract String getMenu();
}
