package main;

import main.model.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<>();

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static Task getTask(int id) {
        if (tasks.containsKey(id)) {
            return tasks.get(id);
        }
        return null;
    }

    public static ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasksList = new ArrayList<>();
        tasksList.addAll(tasks.values());
        return tasksList;
    }

    public static Task updateTask(int id, Task newTask) {
        if (tasks.containsKey(id)) {
            Task updateTask = tasks.get(id);
            updateTask.setName(newTask.getName());
            updateTask.setDate(newTask.getDate());
            return tasks.get(id);
        }
        return null;
    }

    public static void deleteTask(int id) {
        tasks.remove(id);
    }
}
