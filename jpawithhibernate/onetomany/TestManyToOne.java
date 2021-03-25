package com.tyss.jpawithhibernate.onetomany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.onetoone.Aadhar;
import com.tyss.jpawithhibernate.onetoone.Persons;

public class TestManyToOne {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = null;
		EntityTransaction transaction = null;

		PencilBox pbox = new PencilBox();
		pbox.setBoxid(200);
		pbox.setBname("Camlin");
		pbox.getPencils().get(1);

		Pencils pencils = new Pencils();
		pencils.setColor("black");
		pencils.setPid(22);
		pencils.setBox(pbox);

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			PencilBox precords = manager.find(PencilBox.class, 200);
			System.out.println(precords.getBname());
			System.out.println(precords.getBoxid());
//			System.out.println(precords.getPencils());
			// unidirectional
//			pencils.setBox(precords);
//			transaction.begin();
//			manager.persist(pencils);
//			transaction.commit();
			System.out.println("record inserted");
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		manager.close();

	}
}
