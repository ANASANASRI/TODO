package ma.anas.Taskservice.service;

import ma.anas.Taskservice.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getAllTasks();
    TaskDTO getTaskById(Long id);
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    void deleteTask(Long id);
}
