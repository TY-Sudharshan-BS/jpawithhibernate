package com.tyss.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.dto.Person;

public class Detatched {
	public static void main(String[] args) {
		Person record = new Person();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			record = manager.find(Person.class, 400);
			System.out.println(manager.contains(record));
			manager.detach(record);
			System.out.println(manager.contains(record));
			record.setPname("Bunny");
			Person mergerecord = manager.merge(record);
			mergerecord.setPname("Popeye");
			transaction.commit();
			System.out.println("record updated");
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();

	}
}
