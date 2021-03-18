package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Task;

import java.util.List;

@RestController
public class TaskController {

    @PostMapping("/tasks/")
    public int create(Task task) {
        return Storage.addTask(task);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity read(@PathVariable int id) {
        Task task = Storage.getTask(id);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @GetMapping("/tasks/")
    public List<Task> list() {
        return Storage.getAllTasks();
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity update(@PathVariable int id, Task newTask) {
        Task task = Storage.updateTask(id, newTask);
        if (task == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(task, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable int id) {
        Storage.deleteTask(id);
    }
}
