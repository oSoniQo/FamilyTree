package ru.gb.family_tree.view;

import ru.gb.family_tree.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class AdditionalMenu implements Menu {
        private List<ExecutableArgCommand> commandList;
        private MenuDesignUI<ExecutableArgCommand> menuDesign;

        private int choiceId;

        public AdditionalMenu(ConsoleUI consoleUI) {
            commandList = new ArrayList<>();
            commandList.add(new SetFather(consoleUI));
            commandList.add(new SetMother(consoleUI));
            commandList.add(new SetSpouse(consoleUI));
            commandList.add(new AddChild(consoleUI));
            menuDesign = new MenuDesignUI<>(commandList);
        }

        public String menu(){
            return menuDesign.getMenu();
        }

        public void execute(int choice){
            ExecutableArgCommand command = commandList.get(choice-1);
            command.execute(choiceId);
        }

        public int getSize(){
            return commandList.size();
        }

    public int getChoiceId() {
        return choiceId;
    }

    public void setChoiceId(int choiceId) {
        this.choiceId = choiceId;
    }
}
