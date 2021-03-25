package com.tyss.jpawithhibernate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.jpawithhibernate.manytomany.CoursesInfo;
import com.tyss.jpawithhibernate.manytomany.StudentInfo;

public class TestManyToMany {
	public static void main(String[] args) {
		EntityTransaction trans = null;
		EntityManager manager = null;
		
		ArrayList<CoursesInfo> courses_array = new ArrayList<CoursesInfo>();
//		CoursesInfo cinfo1 = new CoursesInfo();
//		cinfo1.setC_id(1);
//		cinfo1.setC_name("Java");
//
//		CoursesInfo cinfo2 = new CoursesInfo();
//		cinfo2.setC_id(2);
//		cinfo2.setC_name("JavaScript");
//
//		CoursesInfo cinfo3 = new CoursesInfo();
//		cinfo3.setC_id(3);
//		cinfo3.setC_name("ReactJS");
//
//		courses_array.add(cinfo1);
//		courses_array.add(cinfo2);
//		courses_array.add(cinfo3);

		StudentInfo sinfo = new StudentInfo();
		sinfo.setS_id(10);
		sinfo.setS_name("MSD");
		sinfo.setCourses(courses_array);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
		try {
			manager = factory.createEntityManager();
			trans = manager.getTransaction();
			trans.begin();
			manager.persist(sinfo);
			trans.commit();
			System.out.println("Records Inserted");

			StudentInfo std = manager.find(StudentInfo.class, 20);
			std.getS_id();
			std.getS_id();

		} catch (Exception e) {

			e.printStackTrace();
			trans.rollback();
		}
		manager.close();
	}
}
