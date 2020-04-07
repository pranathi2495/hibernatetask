package com.ty.task2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.ty.task2.dto.ProductsInfo;

public class ProductDAOHibernateImplement implements ProductDAO  {

	@Override
	public List<ProductsInfo> getAllCustomerInfoPriceLessThanHundred() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select e from ProductsInfo e where e.price < 100";
			TypedQuery<ProductsInfo> query = manager.createQuery(jpql, ProductsInfo.class);
			List<ProductsInfo> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
			manager.close();
		}
	}

	@Override
	public List<ProductsInfo> getAllCustomerInfoStartsWithA() {
		EntityManagerFactory factory = null;
		EntityManager manager = null;
		try {
			factory = Persistence.createEntityManagerFactory("TestPersistence");
			manager = factory.createEntityManager();
			String jpql = "select e from ProductsInfo e where e.productName like 'A%'";
			TypedQuery<ProductsInfo> query = manager.createQuery(jpql, ProductsInfo.class);
			List<ProductsInfo> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			factory.close();
			manager.close();
		}
	}

	@Override
	public boolean createProductInfo(ProductsInfo info) {
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
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return false;
		} finally {
			manager.close();
			factory.close();
		}
	}

}
