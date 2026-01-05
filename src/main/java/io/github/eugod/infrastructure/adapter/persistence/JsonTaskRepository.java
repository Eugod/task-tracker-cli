package io.github.eugod.infrastructure.adapter.persistence;

import io.github.eugod.domain.entity.Task;
import io.github.eugod.domain.entity.TaskStatus;
import io.github.eugod.domain.repository.TaskRepository;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonTaskRepository implements TaskRepository {
    private static final String FILE_PATH = "src/main/resources/persistence/tasks.json";
    private final Gson gson;

    public JsonTaskRepository() {
        this.gson = new Gson();
        initializeFile();
    }

    private void initializeFile() {
        Path path = Paths.get(FILE_PATH);

        try {
            if (!Files.exists(path)) {
                Files.createDirectories(path.getParent());
                Files.writeString(path, "[]");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize JSON file for tasks", e);
        }
    }

    private List<Task> readTasksFromFile() {
        try {
            String json = Files.readString(Paths.get(FILE_PATH));
            Task[] tasks = gson.fromJson(json, Task[].class);
            return tasks == null ? new ArrayList<>() : new ArrayList<>(Arrays.asList(tasks));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read tasks from JSON file", e);
        }
    }

    private void writeTasksToFile(List<Task> tasks) {
        try {
            String json = gson.toJson(tasks);
            Files.writeString(Paths.get(FILE_PATH), json);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write tasks to JSON file", e);
        }
    }

    @Override
    public Task save(Task task) {
        List<Task> tasks = readTasksFromFile();

        int nextId = tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0) + 1;

        task.setId(nextId);

        tasks.add(task);

        writeTasksToFile(tasks);

        return task;
    }

    @Override
    public List<Task> findAll() {
        return null;
    }

    @Override
    public Task update(Task task) {
        return null;
    }

    @Override
    public void delete(int taskId) {

    }

    @Override
    public List<Task> findByStatus(TaskStatus status) {
        return null;
    }
}
