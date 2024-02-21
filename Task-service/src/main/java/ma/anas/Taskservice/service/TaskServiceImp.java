package ma.anas.Taskservice.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import ma.anas.Taskservice.dao.entities.Task;
import ma.anas.Taskservice.dao.repositories.TaskRepository;
import ma.anas.Taskservice.dto.TaskDTO;
import ma.anas.Taskservice.mappers.TaskMapperImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Primary
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private TaskMapperImp taskMapperImp;

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOs = new ArrayList<>();

        for (Task task : tasks) {
            TaskDTO taskDTO = taskMapperImp.fromTask(task);
            taskDTOs.add(taskDTO);
        }
        return taskDTOs;
    }

    @Override
    public TaskDTO getTaskById(long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Task not found with ID: " + id));
        return taskMapperImp.fromTask(task);
    }

    @Override
    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public TaskDTO addTask(TaskDTO t) {
        Task task = taskMapperImp.fromTaskDTO(t);
        taskRepository.save(task);
        return taskMapperImp.fromTask(task);
    }

}