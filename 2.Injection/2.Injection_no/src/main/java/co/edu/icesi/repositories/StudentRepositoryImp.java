package co.edu.icesi.repositories;

import co.edu.icesi.model.*;

public class StudentRepositoryImp implements StudentRepository{

	public Student getStudent (String id)
	{
		return new Student(id);
	}
}
