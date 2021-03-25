package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.Person;

public class InsertDemo {
	public static void main(String[] args) {
		
		Person person = new Person();
		person.setPid(400);
		person.setPname("Blake");
		person.setPsal(40000);
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("TestPersistence");
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(person);
			transaction.commit();
			System.out.println("record inserted");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		manager.close();

	}
}
