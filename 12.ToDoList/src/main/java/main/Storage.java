package main;

import response.Task;

import java.util.ArrayList;
import java.util.HashMap;

public class Storage {
    private static int currentId = 1;
    private static HashMap<Integer, Task> tasks = new HashMap<>();

    public static ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasksList = new ArrayList<>();
        tasksList.addAll(tasks.values());
        return tasksList;
    }

    public static int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static Task getTask(int taskId) {
        if(tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }
}
