package org.cap.dao;

import javax.persistence.Query;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.cap.model.Customer;
import org.springframework.stereotype.Repository;

@Repository("loginDao")
@Transactional
public class LoginDaoImpl implements ILoginDao {

	@PersistenceContext
	private EntityManager em;
	@Override
	public boolean validateLogin(int customerId, String custPass) {
		// TODO Auto-generated method stub
	Query q=em.createQuery("from Customer where customerId=? and customerPwd=?");
	q.setParameter(0, customerId);
	q.setParameter(1, custPass);
	List<Customer> l=q.getResultList();
	if(!l.isEmpty() )
		return true;
	else
		return false;
	}
	@Override
	public String getCustomerName(int customerId) {
		Query query
		= em.createQuery("select cust.firstName from Customer cust where cust.customerId=:custId");
	query.setParameter("custId", customerId);
	List<String> customers= query.getResultList();
	
		return customers.get(0);
	}

	@Override
	public Customer findCustomer(int customerId) {
		
		Customer customer= em.find(Customer.class, customerId);
		
		
		return customer;
	}
	
}
