package com.lti.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CustomerDao {
 
	public void databaseIlAddSeiyavum(Customer customer) {
		
		//step1. load/create enititymanagerfactory obj
		//during this step,META-INF/persistence.xml is read
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		
	//step2. load/create entitymanager obj
		
		EntityManager em=emf.createEntityManager();
		
   //step3. start/participate in a transaction
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
	
		
		//now we can insert/delete/select/update whatever we want
		
		em.persist(customer);  //persist method generates insert query
		tx.commit();
		//below code should be in a finally block
		em.close();
		emf.close();
	}
	
	public Customer databaseIlVangudhal(int custId) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em=emf.createEntityManager();
 //find method generates select query
		Customer c=em.find(Customer.class, custId);
		
		em.close();
		emf.close();
		return c;

		
	}
	
	public Customer databaseIlKootudhal(Customer customer) {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em=emf.createEntityManager();
 //find method generates select query
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		em.merge(customer);
		tx.commit();
		em.close();
		emf.close();
		return customer;

}
	public List<Customer> databasefetchall() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("oracle-pu");
		EntityManager em=emf.createEntityManager();
 //introducing JP-QL
		Query q = em.createQuery("select c from Customer c");
		List<Customer> list = q.getResultList();
		
		
		em.close();
		emf.close();
		return list;

		
	}
}