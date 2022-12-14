package com.hugo;

import com.hugo.model.Course;
import com.hugo.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(CourseRepository courseRepository){
		return args -> {
			courseRepository.deleteAll();
			Course course1 = new Course(null, "Angular", "Front-end");
			Course course2 = new Course(null, "Spring", "Back-end");
			courseRepository.save(course1);
			courseRepository.save(course2);
		};
	}
}
