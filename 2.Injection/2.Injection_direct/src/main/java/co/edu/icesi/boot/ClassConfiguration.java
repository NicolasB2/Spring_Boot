package co.edu.icesi.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import co.edu.icesi.repositories.*;

@Configuration
public class ClassConfiguration {

	@Bean
	public CourseRepository courseRepository() {
		return new CourseRepositoryImp();
	}
	
	@Bean 
	RegistrationRepository registrationRepository() {
		return new RegistrationRepositoryImp();
	}
	
	@Bean 
	StudentRepository studentRepository() {
		return new StudentRepositoryImp();
	}
	
}
