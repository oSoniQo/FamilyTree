package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public  abstract class ExecutableArgCommand extends Command {
    public ExecutableArgCommand(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    public abstract void execute(int choice);
}

