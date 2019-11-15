package co.edu.icesi.repositories;

import co.edu.icesi.model.*;

public interface RegistrationRepository {

	public Registration enrolStudent(Student student, Course course, int semester);
}
