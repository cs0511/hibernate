package com.csong.hibernate.test;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.csong.hibernate.Teacher;
import com.csong.hibernate.Title;

public class TeacherTest {
	public static SessionFactory sf;

	@BeforeClass
	public static void beforeClass() {
		sf = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	@Test
	public void testTteacherSave() {
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("chensong");
		t.setTitle("middle");
		t.setJobTitle(Title.A);

		Session session = sf.openSession();
		session.beginTransaction();
		session.save(t);
		session.getTransaction().commit();
		session.close();
	}

	@AfterClass
	public static void afterClass() {
		sf.close();
	}

}
