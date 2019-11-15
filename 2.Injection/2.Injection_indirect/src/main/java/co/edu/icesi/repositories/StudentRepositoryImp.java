package co.edu.icesi.repositories;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.*;

@Repository
public class StudentRepositoryImp implements StudentRepository{

	public Student getStudent (String id)
	{
		return new Student(id);
	}
}
