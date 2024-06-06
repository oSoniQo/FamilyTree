package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public  abstract class ExecutableCommand extends Command {
    public ExecutableCommand(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    public abstract void execute();
}
