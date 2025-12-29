package io.github.eugod.domain.repository;

import io.github.eugod.domain.entity.Task;
import io.github.eugod.domain.entity.TaskStatus;

import java.util.List;

public interface TaskRepository {
    Task save(Task task);
    List<Task> findAll();
    Task update(Task task);
    void delete(int taskId);
    List<Task> findByStatus(TaskStatus status);
}
