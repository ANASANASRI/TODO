package ma.anas.Taskservice.service;

import ma.anas.Taskservice.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(long id);
    void deleteTaskById(long id);
    TaskDTO addTask(TaskDTO t);
}