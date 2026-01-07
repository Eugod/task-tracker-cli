package io.github.eugod;

import io.github.eugod.infrastructure.adapter.cli.CommandHandler;
import io.github.eugod.infrastructure.adapter.cli.exception.InvalidCommandException;
import io.github.eugod.infrastructure.config.DependencyFactory;

public class Main {
    public static void main(String[] args) {
        CommandHandler commands = DependencyFactory.createCommandHandler();

        try {
            String result = commands.handle(args);
            System.out.println(result);
        } catch (InvalidCommandException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
