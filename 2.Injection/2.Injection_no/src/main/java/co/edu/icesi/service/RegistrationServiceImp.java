package co.edu.icesi.service;

import co.edu.icesi.model.*;
import co.edu.icesi.repositories.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class RegistrationServiceImp implements RegistrationService{

	private StudentRepository studentRepository = new StudentRepositoryImp();
	private CourseRepository courseRepository = new CourseRepositoryImp();
	private RegistrationRepository registrationRepository = new RegistrationRepositoryImp();

	public RegistrationServiceImp() {
	}
	
	public RegistrationServiceImp(StudentRepository studentRepository, CourseRepository courseRepository,
			RegistrationRepository registrationRepository) {
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
		this.registrationRepository = registrationRepository;

	}

	public boolean enrolStudent(String studentId, String courseId, int semester) {
		Student student = studentRepository.getStudent(studentId);
		Course course = courseRepository.getCourse(courseId);
		Registration registration = registrationRepository.enrolStudent(student, course, semester);
		log.info("Student " + registration.getStudent().getId() + " registered successfully in course "
				+ registration.getCourse().getId());
		return true;
	};
}
