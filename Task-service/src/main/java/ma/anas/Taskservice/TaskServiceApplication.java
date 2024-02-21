package ma.anas.Taskservice;

import ma.anas.Taskservice.dao.entities.Task;
import ma.anas.Taskservice.dao.repositories.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;

@EnableDiscoveryClient
@SpringBootApplication
public class TaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(TaskRepository taskRepository){
		return args -> {
			taskRepository.saveAll(List.of(
					Task.builder().title("anas anasri").description("hjdjgjh").build(),
					Task.builder().title("othman abid").description("xexx").build(),
					Task.builder().title("said fettah").description("uyiuoiuo").build()
			));
			taskRepository.findAll().forEach(System.out::println);
		};
	}
}
