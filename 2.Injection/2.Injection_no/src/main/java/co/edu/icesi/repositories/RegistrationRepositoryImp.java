package co.edu.icesi.repositories;


import co.edu.icesi.model.*;

public class RegistrationRepositoryImp implements RegistrationRepository{


	public Registration enrolStudent(Student student, Course course, int semester)
	{
		return new Registration(student, course, semester);
	}
}
