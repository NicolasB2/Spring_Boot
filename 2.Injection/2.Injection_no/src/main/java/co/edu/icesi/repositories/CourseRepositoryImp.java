package co.edu.icesi.repositories;

import co.edu.icesi.model.*;

public class CourseRepositoryImp implements CourseRepository{

	public Course getCourse (String id)
	{
		return new Course(id, "Computacion");
	}
}
