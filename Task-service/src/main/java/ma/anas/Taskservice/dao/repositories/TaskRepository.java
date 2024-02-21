package ma.anas.Taskservice.dao.repositories;

import ma.anas.Taskservice.dao.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}