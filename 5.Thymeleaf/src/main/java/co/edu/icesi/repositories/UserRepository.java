package co.edu.icesi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import co.edu.icesi.model.UserApp;
import co.edu.icesi.model.UserType;

public interface UserRepository extends CrudRepository<UserApp, Long> {

	List<UserApp> findByName(String name);
	
	List<UserApp> findByUsername(String username);
	
	List<UserApp> findByType(UserType type);

}
