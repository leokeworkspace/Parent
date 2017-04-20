package com.cs.service.csLog;


import com.cs.model.cassandraEntity.Person;


public interface TestService {

	Person queryPerson(String id);

	Person insertPerson(Person person);
	
}
