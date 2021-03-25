package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.Person;

public class ReadDemo {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = factory.createEntityManager();
		Person person = manager.find(Person.class, 400);
		System.out.println("student id is " + person.getPid());
		System.out.println("student name is " + person.getPname());
		System.out.println("student salary is " + person.getPsal());
		manager.close();
	}
}
