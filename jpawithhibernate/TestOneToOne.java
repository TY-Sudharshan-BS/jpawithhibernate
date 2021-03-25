package com.tyss.jpawithhibernate;

import java.lang.annotation.Annotation;

import javax.persistence.CascadeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.onetoone.Aadhar;
import com.tyss.jpawithhibernate.onetoone.Persons;

public class TestOneToOne {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		EntityManager manager = null;
		EntityTransaction transaction = null;
//
//		Persons persons = new Persons();
//		persons.setPname("scott");
//		persons.setPid(2000);
//
//		Aadhar aadhar = new Aadhar();
//		persons.setAadhar(aadhar);
//		aadhar.setAid(987654);
//		aadhar.setAname("smith");
//		aadhar.setAddress("bangalore");

		try {
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();

			// unidirectional
//			transaction.begin();
//			manager.persist(persons);
//			transaction.commit();
//			System.out.println("record inserted");

			// bi-directional
			Aadhar record = manager.find(Aadhar.class, 987654);
			System.out.println(record.getPersons().getPid());
			System.out.println(record.getPersons().getPname());
			System.out.println(record.getAid());
			System.out.println(record.getAddress());
			System.out.println(record.getAname());

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		manager.close();
	}
}
