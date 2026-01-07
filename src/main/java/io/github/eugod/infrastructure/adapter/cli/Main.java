package io.github.eugod.infrastructure.adapter.cli;

import io.github.eugod.application.usecase.SaveTaskUseCase;
import io.github.eugod.infrastructure.adapter.cli.commands.AddCommand;
import io.github.eugod.infrastructure.adapter.cli.exception.InvalidCommandException;
import io.github.eugod.infrastructure.adapter.persistence.JsonTaskRepository;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        JsonTaskRepository repository = new JsonTaskRepository();
        SaveTaskUseCase saveTaskUseCase = new SaveTaskUseCase(repository);
        CommandHandler commandHandler = new CommandHandler(Map.of(
                "add", new AddCommand(saveTaskUseCase)
        ));

        try {
            String result = commandHandler.handle(args);
            System.out.println(result);
        } catch (InvalidCommandException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
