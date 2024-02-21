package ma.anas.Taskservice.mappers;

import ma.anas.Taskservice.dao.entities.Task;
import ma.anas.Taskservice.dto.TaskDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class TaskMapperImp{

    public TaskDTO fromTask(Task task){
        TaskDTO taskDTO=new TaskDTO();
        BeanUtils.copyProperties(task,taskDTO);
        return  taskDTO;
    }
    public Task fromTaskDTO(TaskDTO taskDTO){
        Task task=new Task();
        BeanUtils.copyProperties(taskDTO,task);
        return  task;
    }

}