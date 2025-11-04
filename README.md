# 🧭 Task Tracker CLI

This repository was created to practice and reinforce knowledge of the **Java programming language**.

---

## ⚙️ Project setup

### 1. Navigate to the source directory
```bash
cd src/main/java
```

### 2. Compile the project
```bash
javac -d out io/github/eugod/TaskTracker.java io/github/eugod/view/TaskView.java
```

This will generate the compiled `.class` files inside the `out/` directory.

---

## ▶️ Running the application

### 🐧 On Linux / WSL / macOS
You can create an alias for easier execution:
```bash
alias task-tracker='java -cp src/main/java/out io.github.eugod.TaskTracker'
```

Then simply run:
```bash
task-tracker [arguments]
```

---

### 🪟 On Windows (CMD or PowerShell)
Navigate to the compiled directory:
```bash
cd src\main\java\out\io\github\eugod
```

Then run the program:
```bash
java io.github.eugod.TaskTracker [arguments]
```

---

## 💡 Example
```bash
task-tracker mark-done "integration tests"
```

---

## 🧩 Folder structure
```
task-tracker-cli/
 └─ src/
     └─ main/
         └─ java/
             ├─ io/github/eugod/TaskTracker.java
             ├─ io/github/eugod/view/TaskView.java
             └─ out/
```
---