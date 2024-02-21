package ma.anas.Taskservice.web;

import lombok.extern.slf4j.Slf4j;
import ma.anas.Taskservice.dto.TaskDTO;
import ma.anas.Taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping("/tasks")
    public List<TaskDTO> tasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("task/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public void deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
    }

}