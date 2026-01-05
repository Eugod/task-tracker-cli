package io.github.eugod.infrastructure.adapter.cli.commands;

import io.github.eugod.application.usecase.SaveTaskUseCase;
import io.github.eugod.infrastructure.adapter.cli.exception.InvalidCommandException;

public class AddCommand implements Command{
    private final SaveTaskUseCase useCase;

    public AddCommand(SaveTaskUseCase useCase) {
        this.useCase = useCase;
    }

    @Override
    public String execute(String[] args) {
        if (args.length == 0) {
            throw new InvalidCommandException("Task description cannot be empty.");
        }

        String description = String.join(" ", args);

        useCase.execute(description);

        return "Task added successfully.";
    }
}
