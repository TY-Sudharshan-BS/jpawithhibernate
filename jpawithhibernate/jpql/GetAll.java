package com.tyss.jpawithhibernate.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.dto.Person;

public class GetAll {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = factory.createEntityManager();
		String jpql = "select p from Person p";
		Query query = manager.createQuery(jpql);
		List<Person> personList = query.getResultList();
		for (Person person : personList) {
			System.out.println(person.getPid());
			System.out.println(person.getPname());
			System.out.println(person.getPsal());
			System.out.println("*****************");

		}

	}
}
