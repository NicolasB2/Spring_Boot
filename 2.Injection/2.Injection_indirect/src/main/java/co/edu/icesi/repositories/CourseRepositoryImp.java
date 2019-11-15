package co.edu.icesi.repositories;

import org.springframework.stereotype.Repository;

import co.edu.icesi.model.*;

@Repository
public class CourseRepositoryImp implements CourseRepository{

	public Course getCourse (String id)
	{
		return new Course(id, "Computacion");
	}
}
