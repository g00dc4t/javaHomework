package main;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import response.Task;

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
    public Task update(@PathVariable int id) {
        return Storage.updateTask(id);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable int id) {
        Storage.deleteTask(id);
    }
}
