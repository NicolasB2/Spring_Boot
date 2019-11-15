package co.edu.icesi.boot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import co.edu.icesi.repositories.*;
import co.edu.icesi.service.*;

@SpringBootApplication
public class NoInjectionApplication {
	
	private static RegistrationService registration;

	public static void main(String[] args) {
		SpringApplication.run(NoInjectionApplication.class, args);
	}
	
	
	@Bean
	public CommandLineRunner Dummy(StudentRepository studentRepository, CourseRepository courseRepository,
			RegistrationRepository registrationRepository) {
		return (args) ->{
			registration = new 
					RegistrationServiceImp(studentRepository, courseRepository, registrationRepository);
			registration.enrolStudent("11","101",192);
		};
	}

}

