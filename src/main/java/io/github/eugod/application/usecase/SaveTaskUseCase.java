package io.github.eugod.application.usecase;

import io.github.eugod.domain.entity.Task;
import io.github.eugod.domain.repository.TaskRepository;

public class SaveTaskUseCase {
    private final TaskRepository taskRepository;

    public SaveTaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task execute(String description) {
        Task task = new Task(description);

        return taskRepository.save(task);
    }
}
