package com.tyss.jpawithhibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.dto.Person;

public class MySQLQuery {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = factory.createEntityManager();
		String jpql = "delete from Person p where p.id=400 ";
		Query query = manager.createNativeQuery(jpql);
		List<Person> personList = query.getResultList();
		for (Person person : personList) {
			System.out.println(person.getPid());
			System.out.println(person.getPname());
			System.out.println(person.getPsal());
			System.out.println("*****************");

		}

	}
}
