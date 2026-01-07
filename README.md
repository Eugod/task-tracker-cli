# Task Tracker CLI

A command-line task management application built with Java, following Clean Architecture principles.

This project was created to practice and reinforce knowledge of software architecture, design patterns, and the Java programming language.

## Architecture

This project implements **Clean Architecture** (Hexagonal Architecture) with clear separation of concerns:

- **Domain Layer**: Core business entities and repository interfaces
- **Application Layer**: Use cases that orchestrate business logic
- **Infrastructure Layer**: External concerns (CLI, persistence, serialization)

## Technology Stack

- Java 21
- Maven (build tool)
- Gson (JSON serialization)

## Project Structure

```
src/main/java/io/github/eugod/
├── Main.java                          # Application entry point
├── domain/                            # Core business logic
│   ├── entity/
│   │   ├── Task.java
│   │   └── TaskStatus.java
│   └── repository/
│       └── TaskRepository.java        # Repository interface (port)
├── application/                       # Use cases
│   └── usecase/
│       └── SaveTaskUseCase.java
└── infrastructure/                    # Implementation details
    ├── config/
    │   └── DependencyFactory.java     # Dependency injection setup
    ├── serialization/
    │   └── LocalDateTimeAdapter.java  # Gson type adapter
    └── adapter/
        ├── cli/                       # CLI adapter (input)
        │   ├── commands/
        │   │   ├── Command.java
        │   │   └── AddCommand.java
        │   ├── exception/
        │   │   └── InvalidCommandException.java
        │   └── CommandHandler.java
        └── persistence/               # Persistence adapter (output)
            └── JsonTaskRepository.java
```

## Building the Project

Compile the project using Maven:

```bash
mvn clean compile
```

To package dependencies:

```bash
mvn package
```

## Running the Application

### Option 1: Using the task-cli script

Make the script executable:

```bash
chmod +x task-cli
```

Run commands:

```bash
./task-cli add "Study Clean Architecture"
```

### Option 2: Direct execution with Maven

```bash
mvn exec:java -Dexec.mainClass="io.github.eugod.Main" -Dexec.args="add 'Study Clean Architecture'"
```

### Option 3: Create a global alias

Create a symbolic link (requires sudo):

```bash
sudo ln -s $(pwd)/task-cli /usr/local/bin/task-tracker
```

Then use from anywhere:

```bash
task-tracker add "Study Design Patterns"
```

## Available Commands

Currently implemented:

- **add**: Create a new task
  ```bash
  task-tracker add "Task description"
  ```

Planned commands:

- list: List all tasks
- update: Update task description
- delete: Delete a task
- mark-in-progress: Mark task as in progress
- mark-done: Mark task as completed

## Data Storage

Tasks are persisted in JSON format at:
```
src/main/resources/persistence/tasks.json
```