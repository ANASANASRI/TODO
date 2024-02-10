package ma.anas.Taskservice.mappers;

import ma.anas.Taskservice.dao.entities.Task;
import ma.anas.Taskservice.dto.TaskDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mappings({
            @Mapping(target = "id", ignore = true) // Ignorer l'ID lors de la création d'une tâche
    })
    Task taskDTOToTask(TaskDTO taskDTO);

    TaskDTO taskToTaskDTO(Task task);
}
