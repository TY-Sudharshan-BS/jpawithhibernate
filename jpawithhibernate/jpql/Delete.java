package com.tyss.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.dto.Person;

public class Delete {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "delete from Person p where p.id=400";
			transaction.begin();
			Query query = manager.createQuery(jpql);
			int record = query.executeUpdate();
			transaction.commit();
			System.out.println("record deleted " + record);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();
	}
}
