package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;
import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu {
    private List<ExecutableCommand> commandList;
    private MenuDesignUI<ExecutableCommand> menuDesign;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddMember(consoleUI));
        commandList.add(new SetFamilyConnections(consoleUI));
        commandList.add(new GetFamilyTreeInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        commandList.add(new Save(consoleUI));
        commandList.add(new Load(consoleUI));
        commandList.add(new Finish(consoleUI));
        menuDesign = new MenuDesignUI<>(commandList);
    }

    public String menu(){
        return menuDesign.getMenu();
    }

    public void execute(int choice){
        ExecutableCommand command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
