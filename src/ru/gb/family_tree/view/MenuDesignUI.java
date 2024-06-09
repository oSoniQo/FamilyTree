package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.Command;

import java.util.List;

public class MenuDesignUI<T extends Command> extends MenuDesign<T> {

    public MenuDesignUI(List<T> commandList) {
        super(commandList);
    }

    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
