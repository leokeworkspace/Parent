package com.cs.service.csLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.model.cassandraEntity.Person;
import com.cs.dao.cassandraEntity.PersonRepo;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private PersonRepo personRepo;
   
        
    @Override
    public Person queryPerson(String id) {
    	Person person = personRepo.getPersonID(id);
    	return person;
    }
    
    @Override
    public Person insertPerson(Person person) {
    	Person newPerson = personRepo.save(person);
    	return newPerson;
    }
    
    
}
