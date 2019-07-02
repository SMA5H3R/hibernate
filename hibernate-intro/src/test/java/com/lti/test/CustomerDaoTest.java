package com.lti.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.lti.entity.Customer;
import com.lti.entity.CustomerDao;

public class CustomerDaoTest {

	@Test
	public void testAdd() {
		
	Customer c=new Customer();
	c.setName("Damon");
	c.setEmail("Damon@mysticfalls.com");
	c.setCity("chennai");
	
	Customer d=new Customer();
	d.setName("Stefan");
	d.setEmail("Stefan@vampirediaries.com");
	d.setCity("Mystic falls");
	
	
	
   // c.setDateOfBirth(1-12-1998);	
	
	CustomerDao dao=new CustomerDao();
		dao.databaseIlAddSeiyavum(d);
	}
	
	
	
	@Test
	public void testFetch() {
		CustomerDao dao=new CustomerDao();
		Customer cust=dao.databaseIlVangudhal(28); //please check the id in db
		
		System.out.println(cust.getName());
		System.out.println(cust.getEmail());
		System.out.println(cust.getDateOfBirth());
		System.out.println(cust.getCity());
	}

	
	@Test
	public void testUpdate() {
		CustomerDao dao=new CustomerDao();
		Customer cust=dao.databaseIlVangudhal(1);
		cust.setCity("Forks");
		dao.databaseIlKootudhal(cust);
	
}
	@Test
	public void testFetchAll() {
		CustomerDao dao=new CustomerDao();
		List<Customer> list=dao.databasefetchall(); //please check the id in db
		
		for(Customer cust : list) {
		System.out.println(cust.getName());
		System.out.println(cust.getEmail());
		System.out.println(cust.getDateOfBirth());
		System.out.println(cust.getCity());
		}
}
}
