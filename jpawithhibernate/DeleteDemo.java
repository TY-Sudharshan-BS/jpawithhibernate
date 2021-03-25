package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.Person;

public class DeleteDemo {
	public static void main(String[] args) {
		Person deleterecord = new Person();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			deleterecord = manager.find(Person.class, 300);
			manager.remove(deleterecord);
			transaction.commit();
			System.out.println("record deleted");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();

	}
}
