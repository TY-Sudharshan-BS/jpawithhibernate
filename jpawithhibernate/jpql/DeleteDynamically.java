package com.tyss.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteDynamically {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "delete from Person p where p.id=:idd";
			transaction.begin();
			Query query = manager.createQuery(jpql);
			query.setParameter("idd", 200);
			int record = query.executeUpdate();
			transaction.commit();
			if (record != 0) {
				System.out.println("record deleted " + record);
			} else {
				System.out.println("record not deleted");
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();
	}
}
