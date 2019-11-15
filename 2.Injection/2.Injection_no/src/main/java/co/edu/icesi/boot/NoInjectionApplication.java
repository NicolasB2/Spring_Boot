package co.edu.icesi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.icesi.service.*;

@SpringBootApplication
public class NoInjectionApplication {
	
	private static RegistrationService registration = new RegistrationServiceImp();

	public static void main(String[] args) {
		
		SpringApplication.run(NoInjectionApplication.class, args);
		
		registration.enrolStudent("11","101",192);
		
	}

}

