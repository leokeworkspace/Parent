package com.cs.model.cassandraEntity;

import java.io.Serializable;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.Indexed;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table(value = "person")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@PrimaryKey
	@Column(value = "id")
	private String id;
	@Indexed
	@Column(value = "name")  
	private String name;
	@Column(value = "sex")
	private String sex;
	@Column(value = "age")
	private int age;

	
	public Person(String id, String name, String sex, int age) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.id + "," + this.name + "," + this.sex + "," + this.age;
	}

}
