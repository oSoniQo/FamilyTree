package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;
import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu {
    private List<ExecutableCommand> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddMember(consoleUI));
        commandList.add(new SetFamilyConnections(consoleUI));
        commandList.add(new GetFamilyTreeInfo(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice){
        ExecutableCommand command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }
}
