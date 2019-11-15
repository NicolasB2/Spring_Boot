package co.edu.icesi.repositories;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.*;

@Repository
public class RegistrationRepositoryImp implements RegistrationRepository{


	public Registration enrolStudent(Student student, Course course, int semester)
	{
		return new Registration(student, course, semester);
	}
}
