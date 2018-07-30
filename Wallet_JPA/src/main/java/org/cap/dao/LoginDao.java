package org.cap.dao;

import org.cap.model.Customer;

public interface LoginDao {
	public boolean validateLogin(int customerId, String custPwd);
	public String getCustomerName(int customerId);
	public Customer findCustomer(int customerId);
}
