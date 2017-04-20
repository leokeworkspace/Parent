package com.cs.dao.cassandraEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.cassandra.core.CassandraOperations;
//import org.springframework.stereotype.Repository;

import com.cs.model.cassandraEntity.Person;


public class PersonRepoImpl{
	
//
	@Autowired
	@Qualifier("cqlTemplate")
	private CassandraOperations cqlTemplate;
	
	public Person getPersonID(String id){
		System.out.println("cqlTemplate == null:"+("null".equals(cqlTemplate)));
		System.out.println("cqlTemplate == null:"+(null == cqlTemplate));
		Person person = cqlTemplate.selectOne(" SELECT * from Person where id = '"+id+"'", Person.class);
//		Person person = cqlTemplate.selectOne(
//				" SELECT * from Person where id = "+id, Person.class);
		return person;
		
	}
	
	
}
