package com.ty.task3.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ty.task3.dto.StudentInfo;

public class StudentDAOHibernateImplement implements StudentDAO {

	@Override
	public boolean createStudentInfo(StudentInfo info) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		EntityTransaction transaction = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(info);
			transaction.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public List<Object[]> getAllFirstNameandtotalMarks() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select s.firstName, s.totalMarks from StudentInfo s";
			Query query = manager.createNativeQuery(jpql);
			List<Object[]> list = query.getResultList();
			return list;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public StudentInfo getStudentDetailrollNumandSubject(int rollNum, String subject) {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select s from StudentInfo s where s.rollNum = :rollNum and s.subject = :subject";
			TypedQuery<StudentInfo> query = manager.createQuery(jpql, StudentInfo.class);
			query.setParameter("rollNum", rollNum);
			query.setParameter("subject", subject);
			StudentInfo info = query.getSingleResult();
			return info;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			manager.close();
			factory.close();
		}
	}
	public double findAggregateMin() {
		double min = 0;
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select MIN(s.totalMarks) from StudentInfo s";
			Query query = manager.createNativeQuery(jpql);
			min= (double) query.getSingleResult();
			return min;
		} catch(Exception e) {
			e.printStackTrace();
			return min;
		}
	}
	
	public double findAggregateMax() {
		double max = 0;
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select MAX(s.totalMarks) from StudentInfo s";
			Query query = manager.createQuery(jpql);
			max= (double) query.getSingleResult();
			return max;
		} catch(Exception e) {
			e.printStackTrace();
			return max;
		}
	}
	
	public double findAggregateAvg() {
		double avg = 0;
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select AVG(s.totalMarks) from StudentInfo s";
			Query query = manager.createQuery(jpql);
			avg= (double) query.getSingleResult();
			return avg;
		} catch(Exception e) {
			e.printStackTrace();
			return avg;
		}
	}
}


