package io.github.eugod.infrastructure.config;

import io.github.eugod.application.usecase.SaveTaskUseCase;
import io.github.eugod.infrastructure.adapter.cli.CommandHandler;
import io.github.eugod.infrastructure.adapter.cli.commands.AddCommand;
import io.github.eugod.infrastructure.adapter.persistence.JsonTaskRepository;

import java.util.Map;

public class DependencyFactory {
    public static CommandHandler createCommandHandler() {
        JsonTaskRepository repository = new JsonTaskRepository();
        SaveTaskUseCase saveTaskUseCase = new SaveTaskUseCase(repository);

        return new CommandHandler(Map.of(
                "add", new AddCommand(saveTaskUseCase)
        ));
    }
}
