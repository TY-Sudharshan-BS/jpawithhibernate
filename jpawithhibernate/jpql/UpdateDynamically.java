package com.tyss.jpawithhibernate.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateDynamically {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			String jpql = "update Person p set p.pname ='Sudharshan' where p.pid=:identity";
			transaction.begin();
			Query query = manager.createQuery(jpql);
			query.setParameter("identity", 666);
			int record = query.executeUpdate();
			transaction.commit();
			if (record != 0) {
				System.out.println("record updated " + record);
			} else {
				System.out.println("record not updated");
			}

		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();

		}
		manager.close();
	}
}
