package main;

import main.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import main.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/tasks/")
    public int create(Task task) {
        Task newTask = taskRepository.save(task);
        return newTask.getId();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity read(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (!optionalTask.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalTask.get(), HttpStatus.OK);
    }

    @GetMapping("/tasks/")
    public Iterable<Task> readList() {
        Iterable<Task> tasksIterable = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        for (Task task : tasksIterable) {
            tasks.add(task);
        }
        return tasks;
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity update(@PathVariable int id, @RequestParam String name, @RequestParam Integer date) {
        Optional<Task> taskOptional = taskRepository.findById(id);
        if (!taskOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Task updateTask = taskOptional.get();
        updateTask.setName(name);
        updateTask.setDate(date);
        taskRepository.save(updateTask);
        return new ResponseEntity(updateTask, HttpStatus.OK);
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable int id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        taskRepository.delete(optionalTask.get());
    }
}
