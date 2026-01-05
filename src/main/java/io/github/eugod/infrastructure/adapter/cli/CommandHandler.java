package io.github.eugod.infrastructure.adapter.cli;

import io.github.eugod.infrastructure.adapter.cli.commands.Command;
import io.github.eugod.infrastructure.adapter.cli.exception.InvalidCommandException;

import java.util.Arrays;
import java.util.Map;

public class CommandHandler {
    private final Map<String, Command> commands;

    public CommandHandler(Map<String, Command> commands) {
        this.commands = commands;
    }


    public String handle(String[] args) {
        if (args.length == 0) {
            throw new InvalidCommandException("No command provided.");
        }

        String commandName = args[0];
        Command command = commands.get(commandName);

        if (command == null) {
            throw new InvalidCommandException("Unknown command: " + commandName);
        }

        String[] commandArgs = Arrays.copyOfRange(args, 1, args.length);

        return command.execute(commandArgs);
    }
}
