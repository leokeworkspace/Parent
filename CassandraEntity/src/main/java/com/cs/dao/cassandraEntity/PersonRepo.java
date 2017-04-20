package com.cs.dao.cassandraEntity;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cs.model.cassandraEntity.Person;


public interface PersonRepo extends CrudRepository<Person, String> {
	
	@Query("SELECT * from Person where id = ?0  and name = ?1 ")
	public Person fetchById(String id, String name);
	
	@Query("SELECT * from Person where id = ?0 ")  
	public Person findByFirstNameAndLastName(String id);  
	
	public Person getPersonID(String id);
}
