package com.tyss.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.tyss.jpawithhibernate.dto.Person;

public class UpdateData {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = null;
		EntityTransaction transaction = null;

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			String jpql = "update Person p set p.id=666 where p.id=100 ";
			Query query = manager.createQuery(jpql);
			int record = query.executeUpdate();
			transaction.commit();
			System.out.println("record updated " + record);
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();
	}
}
